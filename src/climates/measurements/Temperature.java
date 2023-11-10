package climates.measurements;

public class Temperature extends ClimateMeasurement {
	
	private double celciusMeasurement;
	private double fahrenheitMeasurement;
	private double kelvinMeasurement;
	
	public Temperature(int year, String month) {
		super(year, month);
		// gives values between (-40, 50) 
		celciusMeasurement = Math.random()*90-40;
		fahrenheitMeasurement = celciusMeasurement * 1.8 + 32;
		kelvinMeasurement = celciusMeasurement + 273.15d;
	}

	public double getCelciusMeasurement() {
		return celciusMeasurement;
	}
	public double getFahrenheitMeasurement() {
		return fahrenheitMeasurement;
	}
	public double getKelvinMeasurement() {
		return kelvinMeasurement;
	}

}
