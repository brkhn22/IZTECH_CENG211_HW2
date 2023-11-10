package climates.management;

import java.util.ArrayList;
import java.util.Scanner;

import climates.locations.Location;
import climates.measurements.*;
import climates.measurements.RadiationAbsorbtion.RadiationIntensity;

public class ClimateApp {

	private ClimateRecord climateRecord;
	private String[] askPrintArray = {
			"[1] Calculate average temperature for a country according to temperature unit and year",
			"[2] Calculate average temperature for a city according to temperature unit and year",
			"[3] Calculate average wind speed for a city according to speed unit and year",
			"[4] Calculate average humidity of a city for every year.",
			"[5] Count how many times a year a specific radiation intensity value appears.",
			"[6] Calculate the “felt temperature” value for a specific month.",
			"[7] Exit the application"
			};
	
	private static final int[] yearArray = {2020, 2021, 2022};
	private static final String[] temperatureUnitArray = {"Celcius", "Fahrenheit", "Kelvin"};
	private static final String[] windSpeedUnitArray = {"MetersPerSecond", "KmPerHour"};
	
	public ClimateApp() {
		this.climateRecord = new ClimateRecord();

	}
	
	public void startClimateApp() {
		boolean keepGoing = true;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while(keepGoing){
			askPrint();
			int selectedOption = scanner.nextInt();
			while(!isSelectionValid(selectedOption, 1, askPrintArray.length)){
				System.out.print("Incorrect option input! Please reenter another option input: ");
				selectedOption = scanner.nextInt();
				System.out.println();
			}
			scanner.nextLine();
			switch(selectedOption) {
				case 1:{
					System.out.print("Enter the name of the country: ");
					String countryName = scanner.nextLine();
					
					System.out.println();	
					while(!climateRecord.isValidCountryName(countryName)){
						System.out.print("Incorrect country input! Please reenter another country name: ");
						countryName = scanner.nextLine();
						System.out.println();
					}
					System.out.println("[1] Celsius [2] Fahrenheit [3] Kelvin");
					System.out.print("Please select the temperature unit: ");
					int selectedUnit = scanner.nextInt();
					
					System.out.println();
					while(!isSelectionValid(selectedUnit, 1, 3)) {
						System.out.print("Incorrect unit input! Please reenter another unit input: ");
						selectedUnit = scanner.nextInt();
						System.out.println();
					}
					
					System.out.println("[1] 2020 [2] 2021 [3] 2022");
					System.out.print("Please select the year: ");
					int selectedYear = scanner.nextInt();
					
					System.out.println();
					while(!isSelectionValid(selectedYear, 1, 3)){
						System.out.print("Incorrect year input! Please reenter another year input: ");
						selectedYear = scanner.nextInt();
						System.out.println();
					}
					calculateAverageTemperatureOfCountry(yearArray[selectedYear-1], countryName, temperatureUnitArray[selectedUnit-1]);
					break;
				}
				case 2:{
					System.out.print("Enter the name of the city: ");
					String cityName = scanner.nextLine();
					
					System.out.println();	
					while(!climateRecord.isValidCityName(cityName)){
						System.out.print("Incorrect city input! Please reenter another city name: ");
						cityName = scanner.nextLine();
						System.out.println();
					}
					System.out.println("[1] Celsius [2] Fahrenheit [3] Kelvin");
					System.out.print("Please select the temperature unit: ");
					int selectedUnit = scanner.nextInt();
					
					System.out.println();
					while(!isSelectionValid(selectedUnit, 1, 3)) {
						System.out.print("Incorrect unit input! Please reenter another unit input: ");
						selectedUnit = scanner.nextInt();
						System.out.println();
					}
					
					System.out.println("[1] 2020 [2] 2021 [3] 2022");
					System.out.print("Please select the year: ");
					int selectedYear = scanner.nextInt();
					
					System.out.println();
					while(!isSelectionValid(selectedYear, 1, 3)){
						System.out.print("Incorrect year input! Please reenter another year input: ");
						selectedYear = scanner.nextInt();
						System.out.println();
					}
					calculateAverageTemperatureOfCity(yearArray[selectedYear-1], cityName, temperatureUnitArray[selectedUnit-1]);
					break;
				}
				case 3:{
					System.out.print("Enter the name of the city: ");
					String cityName = scanner.nextLine();
					
					System.out.println();	
					while(!climateRecord.isValidCityName(cityName)){
						System.out.print("Incorrect city input! Please reenter another city name: ");
						cityName = scanner.nextLine();
						System.out.println();
					}
					System.out.println("[1] MetersPerSecond [2] KmPerHour");
					System.out.print("Please select the unit: ");
					int selectedUnit = scanner.nextInt();
					
					System.out.println();
					while(!isSelectionValid(selectedUnit, 1, 2)) {
						System.out.print("Incorrect unit input! Please reenter another unit input: ");
						selectedUnit = scanner.nextInt();
						System.out.println();
					}
					
					System.out.println("[1] 2020 [2] 2021 [3] 2022");
					System.out.print("Please select the year: ");
					int selectedYear = scanner.nextInt();
					
					System.out.println();
					while(!isSelectionValid(selectedYear, 1, 3)){
						System.out.print("Incorrect year input! Please reenter another year input: ");
						selectedYear = scanner.nextInt();
						System.out.println();
					}
					calculateAverageWindSpeedOfCity(yearArray[selectedYear-1], cityName, windSpeedUnitArray[selectedUnit-1]);
					break;
				}
				case 4:{
					System.out.print("Enter the name of the city: ");
					String cityName = scanner.nextLine();
					
					System.out.println();	
					while(!climateRecord.isValidCityName(cityName)){
						System.out.print("Incorrect city input! Please reenter another city name: ");
						cityName = scanner.nextLine();
						System.out.println();
					}
					
					calculateAverageHumidityOfCity(cityName);
					break;
				}
				case 5:{
					System.out.print("Enter the name of the city: ");
					String cityName = scanner.nextLine();
					
					System.out.println();	
					while(!climateRecord.isValidCityName(cityName)){
						System.out.print("Incorrect city input! Please reenter another city name: ");
						cityName = scanner.nextLine();
						System.out.println();
					}
					
					System.out.println("[1] Low [2] Medium [3] High");
					System.out.print("Please select a radiation intensity value: ");
					int selectedUnit = scanner.nextInt();
					
					System.out.println();
					while(!isSelectionValid(selectedUnit, 1, 3)) {
						System.out.print("Incorrect unit input! Please reenter another unit input: ");
						selectedUnit = scanner.nextInt();
						System.out.println();
					}
					
					System.out.println("[1] 2020 [2] 2021 [3] 2022");
					System.out.print("Please select the year: ");
					int selectedYear = scanner.nextInt();
					
					System.out.println();
					while(!isSelectionValid(selectedYear, 1, 3)){
						System.out.print("Incorrect year input! Please reenter another year input: ");
						selectedYear = scanner.nextInt();
						System.out.println();
					}
					calculateCountRadiationIntensityOfCity(yearArray[selectedYear-1], cityName, RadiationIntensity.values()[selectedUnit-1] );
					break;
				}
				case 6:{
					System.out.print("Enter the name of the city: ");
					String cityName = scanner.nextLine();
					
					System.out.println();	
					while(!climateRecord.isValidCityName(cityName)){
						System.out.print("Incorrect city input! Please reenter another city name: ");
						cityName = scanner.nextLine();
						System.out.println();
					}
					
					System.out.println("[1] January [2] February [3] March [4] April [5] May [6] June\n[7] July [8] August [9] September [10] October [11] November [12] December");
					System.out.print("Please select the month unit: ");
					int selectedUnit = scanner.nextInt();
					
					System.out.println();
					while(!isSelectionValid(selectedUnit, 1, 12)) {
						System.out.print("Incorrect unit input! Please reenter another unit input: ");
						selectedUnit = scanner.nextInt();
						System.out.println();
					}
					
					System.out.println("[1] 2020 [2] 2021 [3] 2022");
					System.out.print("Please select the year: ");
					int selectedYear = scanner.nextInt();
					
					System.out.println();
					while(!isSelectionValid(selectedYear, 1, 3)){
						System.out.print("Incorrect year input! Please reenter another year input: ");
						selectedYear = scanner.nextInt();
						System.out.println();
					}
					calculateFeltTemperatureOfCity(yearArray[selectedYear-1], Location.MONTH_ARRAY[selectedUnit-1], cityName);
					break;
				}
				case 7:{
					keepGoing = false;
					System.out.println();
					System.out.println("==> Closing the application…");
					System.exit(0);
					break;
				}
			}
			
		}
	}
	
	private void askPrint() {
		for(int i = 0; i < askPrintArray.length; i++) {
			System.out.println(askPrintArray[i]);
		}
		System.out.print("Please select an option: ");
	}
	
	private void calculateAverageTemperatureOfCountry(int year, String countryName, String unit) {
			ArrayList<Temperature> temperatureArrayList = climateRecord.getTemperatureOfCountry(year, countryName);
			double temperatureSum = 0;
			// if it equals to the celcius
			if(unit.equals(temperatureUnitArray[0])) {
				for (Temperature temperature : temperatureArrayList)
					temperatureSum += temperature.getCelciusMeasurement();
			}else if(unit.equals(temperatureUnitArray[1])) {
				for (Temperature temperature : temperatureArrayList)
					temperatureSum += temperature.getFahrenheitMeasurement();
			}else if(unit.equals(temperatureUnitArray[2])) {
				for (Temperature temperature : temperatureArrayList)
					temperatureSum += temperature.getKelvinMeasurement();
			}
			double average = temperatureSum/temperatureArrayList.size();
			countryName = (""+countryName.charAt(0)).toUpperCase() + countryName.substring(1, countryName.length()).toLowerCase();

			System.out.printf("==> Average temperature of %s in %s in %s : %.2f\n", countryName, year, unit, average);
			System.out.println();
	}
	
	private void calculateAverageTemperatureOfCity(int year, String cityName, String unit) {
		ArrayList<Temperature> temperatureArrayList = climateRecord.getTemperatureOfCity(year, cityName);
		double temperatureSum = 0;
		if(unit.equals(temperatureUnitArray[0])) {
			for (Temperature temperature : temperatureArrayList)
				temperatureSum += temperature.getCelciusMeasurement();
		}else if(unit.equals(temperatureUnitArray[1])) {
			for (Temperature temperature : temperatureArrayList)
				temperatureSum += temperature.getFahrenheitMeasurement();
		}else if(unit.equals(temperatureUnitArray[2])) {
			for (Temperature temperature : temperatureArrayList)
				temperatureSum += temperature.getKelvinMeasurement();
		}
		double average = temperatureSum/temperatureArrayList.size();
		cityName = (""+cityName.charAt(0)).toUpperCase() + cityName.substring(1, cityName.length()).toLowerCase();
		System.out.printf("==> Average temperature of %s in %s in %s : %.2f\n", cityName, year, unit, average);
		System.out.println();
	}

	private void calculateAverageWindSpeedOfCity(int year, String cityName, String unit) {
		ArrayList<WindSpeed> windSpeedArrayList = climateRecord.getWindSpeedOfCity(year, cityName);
		double windSpeedSum = 0;
		if(unit.equals(windSpeedUnitArray[0])) {
			for (WindSpeed windSpeed : windSpeedArrayList) 
				windSpeedSum += windSpeed.getMetersPerSecond();
			
		}else if(unit.equals(windSpeedUnitArray[1])) {
			for (WindSpeed windSpeed : windSpeedArrayList)
				windSpeedSum += windSpeed.getKmPerHour();
		}
		double average = windSpeedSum/windSpeedArrayList.size();
		cityName = (""+cityName.charAt(0)).toUpperCase() + cityName.substring(1, cityName.length()).toLowerCase();
		System.out.printf("==> Average wind speed of %s in %s in %s : %.2f\n", cityName, year, unit, average);
		System.out.println();
	}
	
	private void calculateAverageHumidityOfCity(String cityName) {
		ArrayList<Humidity> humidityArrayList = climateRecord.getHumidityOfCity(cityName);
		double humiditySum = 0;
		for(Humidity humidity: humidityArrayList) {
			humiditySum += humidity.getHumidityPercentage();
		}
		double average = humiditySum/humidityArrayList.size();
		cityName = (""+cityName.charAt(0)).toUpperCase() + cityName.substring(1, cityName.length()).toLowerCase();

		System.out.printf("==> Average humidity of %s between 2020-2022 : %.2f\n", cityName, average);
		System.out.println();
	}
	
	private void calculateCountRadiationIntensityOfCity(int year, String cityName, RadiationAbsorbtion.RadiationIntensity unit) {
		ArrayList<RadiationAbsorbtion> radiationAbsorbtionArrayList = climateRecord.getRadiationAbsorbtionOfCity(year, cityName);
		int intensityCounter = 0;
		for(RadiationAbsorbtion radiationAbsorbtion: radiationAbsorbtionArrayList) {
			if(unit == radiationAbsorbtion.getRadiationIntensity()) {
				intensityCounter++;
			}
		}
		cityName = (""+cityName.charAt(0)).toUpperCase() + cityName.substring(1, cityName.length()).toLowerCase();
		System.out.printf("==>  Total count of %s radiation intensity in %s in %s : %s\n", unit, cityName, year, intensityCounter);
		System.out.println();
	}
	
	private void calculateFeltTemperatureOfCity(int year, String monthText, String cityName) {
		double feltTemperature = climateRecord.getFeltTemperature(year, monthText, cityName);
		cityName = (""+cityName.charAt(0)).toUpperCase() + cityName.substring(1, cityName.length()).toLowerCase();
		System.out.printf("==>  Felt temperature of %s in %s %s : %.2f\n", cityName, monthText, year, feltTemperature);
		System.out.println();
	}
	
	private boolean isSelectionValid(int selection, int min, int max) {
		if(selection >= min && selection <= max) 
			return true;
		
		return false;
	}
	
}