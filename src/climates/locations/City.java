package climates.locations;

public class City extends Location {
	
	public City(String name) {
		super(name);
	}

	public double calculateFeltTemperature(int yearOffSet, String monthText) {
		int month = getNumberOfMonth(monthText);
		int index = (month-1)+yearOffSet*12;
		double cityTemperature = temperatureMeasurementArrayList.get(index).getCelciusMeasurement();
		double humidity = humidityMeasurementArrayList.get(index).getHumidityPercentage();
		double windSpeed = windSpeedMeasurementArrayList.get(index).getMetersPerSecond();
		double radiationAbsorption = radiationAbsorbtionMeasurementArrayList.get(index).getUnitAbsorbtionValue();
		// Felt Temperature Formula: FT = CT + 0.3 * H – 0.7 * (RA / (WS + 10))
		return (cityTemperature + 0.3 * humidity - 0.7 * (radiationAbsorption/(windSpeed + 10)));
	}
	
}
