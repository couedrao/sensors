package clientm2m;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Main {
	private static String target;
	private static int sensornb;
	private static Sensor[] sensors;
	private static List<Integer> lambdas;
	private static List<Integer> reqnb;
	private static List<Boolean> poisson;

	public static void main(String[] args) {
		// Get config
		configure();

		// Start injection
		for (int i = 0; i < sensornb; i++) {
			int[] sample = new int[reqnb.get(i)];

			// create lambda
			if (poisson.get(i)) {
				PoissonDistribution poisDist = new PoissonDistribution(lambdas.get(i));
				sample = poisDist.sample(reqnb.get(i));
				showInfos(i, poisDist, sample);
			} else
				Arrays.fill(sample, lambdas.get(i));
			System.out.print("Sample " + i + " : ");
			for (int j = 0; j < sample.length; j++) {
				System.out.print(Integer.parseInt(sample[j] + "") + ", ");
			}
			System.out.println();
			
			//
			sensors[i] = new Sensor(i, sample, target, reqnb.get(i));
			if (!sensors[i].inititialization()) {
				logger("Sensor" + i + " Not inititialized");
				return;
			}
		}

		for (int i = 0; i < sensornb; i++) {
			sensors[i].start();
		}

		for (int i = 0; i < sensornb; i++) {
			try {
				sensors[i].join();
			} catch (InterruptedException e) {
				logger(e.getMessage());
			}
		}

	}

	private static void showInfos(int i, PoissonDistribution poisDist, int[] sample) {
		DescriptiveStatistics stats = new DescriptiveStatistics();

		// Add the data from the array
		for (int j = 0; j < sample.length; j++)
			stats.addValue(sample[j]);

		// Compute some statistics
		logger("Sensor " + i + " | Poisson Mean : " + poisDist.getMean() + " | Generated Sample Mean : "
				+ stats.getMean() + " | Distance : " + (poisDist.getMean() - stats.getMean()));
	}

	private static void configure() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("client.config"));
		} catch (IOException ex) {
			logger(ex.getMessage());
		}

		target = prop.getProperty("target");
		sensornb = Integer.parseInt(prop.getProperty("sensornb"));
		lambdas = Arrays.asList(prop.getProperty("lambdas").split(",")).stream().map(s -> Integer.parseInt(s.trim()))
				.collect(Collectors.toList());
		reqnb = Arrays.asList(prop.getProperty("reqnb").split(",")).stream().map(s -> Integer.parseInt(s.trim()))
				.collect(Collectors.toList());
		poisson = Arrays.asList(prop.getProperty("poisson").split(",")).stream()
				.map(s -> Boolean.parseBoolean(s.trim())).collect(Collectors.toList());
		sensors = new Sensor[sensornb];

		// Print the step.
		loggerformatted("%15s %s %s %n", "", "SETUP", "");
		logger("--------------------------------------------------");
		loggerformatted("%-15s %1s %-20s %n", "Target", ":", target + "");
		loggerformatted("%-15s %1s %-20s %n", "Sensor number", ":", sensornb + "");
		loggerformatted("%-15s %1s %-20s %n", "Lambdas", ":", lambdas.toString());
		loggerformatted("%-15s %1s %-20s %n", "Poisonnien", ":", poisson.toString());
		loggerformatted("%-15s %1s %-20s %n", "Request number", ":", reqnb.toString());
		logger("--------------------------------------------------");
	}

	static void logger(String log) {
		System.out.println(log);
	}

	static void loggerformatted(String str1, String str2, String str3, String str4) {
		System.out.printf(str1, str2, str3, str4);

	}
}
