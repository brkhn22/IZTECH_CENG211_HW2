package climates.locations;

import java.util.ArrayList;

import climates.measurements.*;

public class Location {
	private String name;
	
	protected ArrayList<Temperature> temperatureMeasurementArrayList;
	protected ArrayList<Humidity> humidityMeasurementArrayList;
	protected ArrayList<RadiationAbsorbtion> radiationAbsorbtionMeasurementArrayList;
	protected ArrayList<WindSpeed> windSpeedMeasurementArrayList;
	
	private static final int NUMBER_OF_MONTHS = 12*3;
	
	public static final String[] MONTH_ARRAY = {
										"January", "February", "March",
										"April", "May", "June",
										"July", "August", "September",
										"October", "November", "December" 
										};
	
	public Location(String name) {
		this.name = name;
		temperatureMeasurementArrayList = new ArrayList<>(NUMBER_OF_MONTHS);
		humidityMeasurementArrayList = new ArrayList<>(NUMBER_OF_MONTHS);
		radiationAbsorbtionMeasurementArrayList = new ArrayList<>(NUMBER_OF_MONTHS);
		windSpeedMeasurementArrayList = new ArrayList<>(NUMBER_OF_MONTHS);
		initializeMeasurements();
	}
	
	private void initializeMeasurements() {
		int year = 2020;
		int month = 1;
		for(int i = 0; i < NUMBER_OF_MONTHS; i++) {
			
			// get current month text
			String monthText = MONTH_ARRAY[month-1];
			// create measurements and add to the array lists.
			temperatureMeasurementArrayList.add(new Temperature(year, monthText));
			humidityMeasurementArrayList.add(new Humidity(year, monthText));
			radiationAbsorbtionMeasurementArrayList.add(new RadiationAbsorbtion(year, monthText));
			windSpeedMeasurementArrayList.add(new WindSpeed(year, monthText));
			
			month++;
			// Count respect to every completed year.
			if((i+1) % 12 == 0) {
				year += 1;
				month = 1;
			}

		}
	}
	public static final int getNumberOfMonth(String monthText) {
		// Method that returns the month's position in a year.
		for(int i = 0; i < MONTH_ARRAY.length; i++) {
			if(monthText.equals(MONTH_ARRAY[i])) 
				return i+1;
			
		}
		return -1;
	}
	public String getName() {
		return name;
	}
	
	public ArrayList<Temperature> getTemperatureOfYear(int yearOffSet){
		// Method that returns temperature array list between (yearOffSet, yearOffSet + 12)
		ArrayList<Temperature> temperatureArrayList = new ArrayList<>(temperatureMeasurementArrayList.size()/3);

		for(int i = yearOffSet*12; i<(yearOffSet+1)*12; i++) {
			Temperature newTemperature = this.temperatureMeasurementArrayList.get(i);
			temperatureArrayList.add(newTemperature);
		}
		return temperatureArrayList;
	}
	
	public ArrayList<WindSpeed> getWindSpeedOfYear(int yearOffSet){
		// Method that returns wind speed array list between (yearOffSet, yearOffSet + 12)
		ArrayList<WindSpeed> windSpeedArrayList = new ArrayList<>(windSpeedMeasurementArrayList.size()/3);

		for(int i = yearOffSet*12; i<(yearOffSet+1)*12; i++) {
			WindSpeed newWindSpeed = this.windSpeedMeasurementArrayList.get(i);
			windSpeedArrayList.add(newWindSpeed);
		}
		return windSpeedArrayList;
	}
	
	public ArrayList<Humidity> getHumidityOfAllYears(){
		ArrayList<Humidity> humidityArrayList = new ArrayList<>(this.humidityMeasurementArrayList.size());

		for(int i = 0; i<this.humidityMeasurementArrayList.size(); i++) {
			Humidity newHumidity= this.humidityMeasurementArrayList.get(i);
			humidityArrayList.add(newHumidity);
		}
		return humidityArrayList;
	}
	
	public ArrayList<RadiationAbsorbtion> getRadiationAbsorbtionOfCity(int yearOffSet){
		// Method that returns radiaton absorbtion array list between (yearOffSet, yearOffSet + 12)
		ArrayList<RadiationAbsorbtion> radiationAbsorbtionArrayList = new ArrayList<>(radiationAbsorbtionMeasurementArrayList.size()/3);

		for(int i = yearOffSet*12; i<(yearOffSet+1)*12; i++) {
			RadiationAbsorbtion newRadiationAbsorbtion = this.radiationAbsorbtionMeasurementArrayList.get(i);
			radiationAbsorbtionArrayList.add(newRadiationAbsorbtion);
		}
		return radiationAbsorbtionArrayList;
	}
}
