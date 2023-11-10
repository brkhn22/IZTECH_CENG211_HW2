package climates.measurements;

public class Humidity extends ClimateMeasurement {

	private double humidityPercentage;
	
	public Humidity(int year, String month) {
		super(year, month);
		// gives values between 0,1
		humidityPercentage = Math.random();
	}
	public double getHumidityPercentage() {
		return humidityPercentage;
	}
}
