package clientm2m;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.opencsv.CSVWriter;


public class Sensor extends Thread {
	private int sensorID;
	private int lambda[];
	private String target;
	private int reqnb;
	private List<Long[]> result = new ArrayList<Long[]>();

	public Sensor(int AppID, int lambda[], String target, int reqnb) {
		this.lambda = lambda;
		this.target = target;
		this.sensorID = AppID;
		this.reqnb = reqnb;
	}

	public void run() {
		logger("Sensor " + sensorID + " running");
		int i = 0;
		while (i < reqnb) {
			// gen temp val
			int val = ThreadLocalRandom.current().nextInt(-50, 50 + 1);
			String myinst = "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\r\n"
					+ "    <cnf>message</cnf>\r\n" + "    <con>\r\n" + "      &lt;obj&gt;\r\n"
					+ "        &lt;str name=&quot;appId&quot; val=&quot;MY_SENSOR&quot;/&gt;\r\n"
					+ "        &lt;str name=&quot;category&quot; val=&quot;temperature &quot;/&gt;\r\n"
					+ "        &lt;int name=&quot;data&quot; val=&quot;" + val + "&quot;/&gt;\r\n"
					+ "        &lt;int name=&quot;unit&quot; val=&quot;celsius&quot;/&gt;\r\n"
					+ "      &lt;/obj&gt;\r\n" + "    </con>\r\n" + "</m2m:cin>";

			// creat DATA INSTANCE
			new Thread(() -> {
				result.add(new Post().postm2m(myinst + "", target, 4, reqnb));
			}).start();

			try {
				Thread.sleep(lambda[i]);
				i++;
			} catch (InterruptedException e) {
				logger(e.getMessage());
			}

		}
		try {
			saveLog();
		} catch (IOException e) {
			logger(e.getMessage());
		}

	}

	private void saveLog() throws IOException {
		String home = System.getProperty("user.home");
		String fs = System.getProperty("file.separator");
		String path = home + fs + "Logs" + fs + "Sensor_" + sensorID + "_" + System.currentTimeMillis() + ".csv";

		File file = new File(path);
		if (file.createNewFile()) {
			logger(path + " File Created");
		} else
			logger("File " + path + " already exists");

		CSVWriter writer = new CSVWriter(new FileWriter(file), ';', CSVWriter.NO_QUOTE_CHARACTER,
				CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

		writer.writeNext(new String[] { "Request", "Status", "RTT" });

		logger("----------------------------------------------------------");
		for (int j = 0; j < reqnb; j++) {
			logger("Sensor " + sensorID + "\t| Request " + j + "\t| Status : " + result.get(j)[0] + "\t| RTT : "
					+ result.get(j)[1]);

			writer.writeNext(new String[] { j + "", result.get(j)[0] + "", result.get(j)[1] + "" });
		}
		writer.close();
	}

	public boolean inititialization() {
		// 2001 = created AND 4105= already exist

		int status;
		// create sensor
		String mysensor = "<m2m:ae xmlns:m2m=\"http://www.onem2m.org/xml/protocols\" rn=\"SENSOR" + sensorID
				+ "\" >\r\n" + "    <api>app-sensor</api>\r\n"
				+ "    <lbl>Type/sensor Category/temperature Location/home</lbl>\r\n" + "    <rr>false</rr>\r\n"
				+ "</m2m:ae>";
		status = new Post().postm2m(mysensor, target, 2, -2)[0].intValue();
		if (status != 2001 && status != 4105)
			return false;

		// create DATA CNT
		String mydata = "<m2m:cnt xmlns:m2m=\"http://www.onem2m.org/xml/protocols\" rn=\"DATA\">\r\n" + "</m2m:cnt>";
		target += "/in-name/SENSOR" + sensorID;
		status = new Post().postm2m(mydata, target, 3, -1)[0].intValue();
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
		status = new Post().postm2m(myinst + "", target, 4, reqnb)[0].intValue();
		if (status != 2001 && status != 4105)
			return false;

		return true;
	}

	private void logger(String log) {
		System.out.println(log);
	}
}
