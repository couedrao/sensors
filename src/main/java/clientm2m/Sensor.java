package clientm2m;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.opencsv.CSVWriter;

public class Sensor extends Thread {
	private int sensorID;
	private int lambda[];
	private String target;
	private boolean img;
	private int reqnb;
	private List<Long[]> result = new ArrayList<Long[]>();
	// private List<Thread> arrThreads = new ArrayList<Thread>();
	static int i = 0;
	List<Callable<Long[]>> callableTasks = new ArrayList<>();
	ScheduledExecutorService executorService = Executors.newScheduledThreadPool(reqnb);

	public Sensor(int AppID, int lambda[], String target, int reqnb, boolean img) {
		this.lambda = lambda;
		this.target = target;
		this.sensorID = AppID;
		this.reqnb = reqnb;
		this.img = img;

	}

	public void run() {
		logger("Sensor " + sensorID + " running");

		Post[] tasks = new Post[reqnb];

		for (int i = 0; i < reqnb; i++) {
			String val;
			if (img)
				val = Main.getImgbody();
			else
				val = "" + ThreadLocalRandom.current().nextInt(-50, 50 + 1);
			String myinst = "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\r\n"
					+ "    <cnf>message</cnf>\r\n" + "    <con>\r\n" + "      &lt;obj&gt;\r\n"
					+ "        &lt;str name=&quot;appId&quot; val=&quot;MY_SENSOR&quot;/&gt;\r\n"
					+ "        &lt;str name=&quot;category&quot; val=&quot;temperature &quot;/&gt;\r\n"
					+ "        &lt;int name=&quot;data&quot; val=&quot;" + val + "&quot;/&gt;\r\n"
					+ "        &lt;int name=&quot;unit&quot; val=&quot;celsius&quot;/&gt;\r\n"
					+ "      &lt;/obj&gt;\r\n" + "    </con>\r\n" + "</m2m:cin>";
			tasks[i] = new Post(myinst, target, 4);
			Thread t = new Thread(tasks[i]);
			t.start();
			try {
				Thread.sleep(lambda[i]);
			} catch (InterruptedException e) {
				logger(e.getLocalizedMessage());
			}
		}

		for (int i = 0; i < reqnb; i++)
			try {
				result.add(tasks[i].get());
			} catch (InterruptedException e) {
				logger(e.getLocalizedMessage());
			}

		try {
			saveLog();
		} catch (IOException e) {
			logger(e.getLocalizedMessage());
		}

	}

	private void saveLog() throws IOException {
		// String home = System.getProperty("user.home");
		String fs = System.getProperty("file.separator");
		String home = System.getProperty("user.dir");
		String path = home + fs + "Sensor_" + sensorID + "_" + System.currentTimeMillis() + ".csv";

		File file = new File(path);
		if (file.createNewFile()) {
			logger(path + " File Created");
		} else
			logger("File " + path + " already exists");

		CSVWriter writer = new CSVWriter(new FileWriter(file), ';', CSVWriter.NO_QUOTE_CHARACTER,
				CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

		writer.writeNext(new String[] { "Request", "Status", "RTT" });

		// System.out.println("result length" +result.size());
		logger("----------------------------------------------------------");
		for (int j = 0; j < result.size(); j++) {
			logger("Sensor " + sensorID + "\t| Request " + j + "\t| Status : " + result.get(j)[0] + "\t| RTT : "
					+ result.get(j)[1]);
			writer.writeNext(new String[] { j + "", result.get(j)[0] + "", result.get(j)[1] + "" });
		}
		writer.close();
	}

	public boolean inititialization() throws InterruptedException {
		// 2001 = created AND 4105= already exist

		int status;
		// create sensor
		String mysensor = "<m2m:ae xmlns:m2m=\"http://www.onem2m.org/xml/protocols\" rn=\"SENSOR" + sensorID
				+ "\" >\r\n" + "    <api>app-sensor</api>\r\n"
				+ "    <lbl>Type/sensor Category/temperature Location/home</lbl>\r\n" + "    <rr>false</rr>\r\n"
				+ "</m2m:ae>";
		Post task = new Post(mysensor, target, 2);
		new Thread(task).start();
		status = task.get()[0].intValue();

		if (status != 2001 && status != 4105)
			return false;

		// create DATA CNT
		String mydata = "<m2m:cnt xmlns:m2m=\"http://www.onem2m.org/xml/protocols\" rn=\"DATA\">\r\n" + "</m2m:cnt>";
		target += "/in-name/SENSOR" + sensorID;

		task = new Post(mydata, target, 3);
		new Thread(task).start();
		status = task.get()[0].intValue();

		if (status != 2001 && status != 4105)
			return false;

		// create DATA INSTANCE
		String myinst = "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\r\n" + "    <cnf>message</cnf>\r\n"
				+ "    <con>\r\n" + "      &lt;obj&gt;\r\n" + "        &lt;str name=&quot;appId&quot; val=&quot;SENSOR"
				+ sensorID + "&quot;/&gt;\r\n"
				+ "        &lt;str name=&quot;category&quot; val=&quot;temperature &quot;/&gt;\r\n"
				+ "        &lt;int name=&quot;data&quot; val=&quot;27&quot;/&gt;\r\n"
				+ "        &lt;int name=&quot;unit&quot; val=&quot;celsius&quot;/&gt;\r\n" + "      &lt;/obj&gt;\r\n"
				+ "    </con>\r\n" + "</m2m:cin>";

		target += "/DATA";
		task = new Post(myinst + "", target, 4);
		new Thread(task).start();
		status = task.get()[0].intValue();

		if (status != 2001 && status != 4105)
			return false;

		return true;
	}

	private void logger(String log) {
		System.out.println(log);
	}
}
