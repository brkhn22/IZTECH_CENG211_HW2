package climates.measurements;

public class WindSpeed extends ClimateMeasurement {

	
	private double metersPerSecond;
	private double kmPerHour;
	private static final double KM_PER_HOUR_CONSTANT = 3600d/1000;
	
	public WindSpeed(int year, String month) {
		super(year, month);
		// gives values between (0, 113.2)
		metersPerSecond = Math.random()*113.2;
		kmPerHour = metersPerSecond*KM_PER_HOUR_CONSTANT;
	}

	public double getMetersPerSecond() {
		return metersPerSecond;
	}

	public double getKmPerHour() {
		return kmPerHour;
	}

}
