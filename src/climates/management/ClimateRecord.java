package climates.management;

import java.util.ArrayList;

import climates.locations.City;
import climates.locations.Country;
import climates.measurements.*;

public class ClimateRecord {

	private static final int COUNTRY_NUMBER = 5;
	private static final int CITY_NUMBER = COUNTRY_NUMBER*3;
	
	// Starting year of the climate measurements. 
	public static final int BASE_YEAR = 2020;
	public static final int TOP_YEAR = BASE_YEAR + 2;
	
	private ArrayList<Country> countryArrayList;
	private ArrayList<City> cityArrayList;
	
	
	public ClimateRecord() {
		countryArrayList = new ArrayList<>(COUNTRY_NUMBER);
		cityArrayList = new ArrayList<>(CITY_NUMBER);
		// read the file and passed countries and cities into the array lists.
		new FileRead().readCountriesAndCities(countryArrayList, cityArrayList);
	}
	
	public ArrayList<Temperature> getTemperatureOfCountry(int year, String countryName){
		// get the year off set from the starting year.
		int yearOffSet = year - BASE_YEAR;
		// find the country
		Country country = getCountryByName(countryName);
		// get temperatures of array list of the year.
		return country.getTemperatureOfYear(yearOffSet);
	}
	
	public ArrayList<Temperature> getTemperatureOfCity(int year, String countryName){
		// get the year off set from the starting year.
		int yearOffSet = year - BASE_YEAR;
		// find the city
		City city = getCityByName(countryName);
		// get temperatures of array list of the year.
		return city.getTemperatureOfYear(yearOffSet);
	}
	
	public ArrayList<WindSpeed> getWindSpeedOfCity(int year, String cityName){
		int yearOffSet = year - BASE_YEAR;
		City city = getCityByName(cityName);
		return city.getWindSpeedOfYear(yearOffSet);
	}
	
	public ArrayList<Humidity> getHumidityOfCity(String cityName){
		City city = getCityByName(cityName);
		return city.getHumidityOfAllYears();
	}
	
	public ArrayList<RadiationAbsorbtion> getRadiationAbsorbtionOfCity(int year, String cityName){
		int yearOffSet = year - BASE_YEAR;
		City city = getCityByName(cityName);
		return city.getRadiationAbsorbtionOfCity(yearOffSet);
	}
	
	public double getFeltTemperature(int year, String monthText, String cityName) {
		int yearOffSet = year - BASE_YEAR;
		City city = getCityByName(cityName);
		return city.calculateFeltTemperature(yearOffSet, monthText);
	}
	
	private Country getCountryByName(String countryName) {
		// Method that returns the Country of the given name.
		Country country = null;
		countryName = countryName.toLowerCase();
		for(Country tempCountry: countryArrayList) {
			if(countryName.equals(tempCountry.getName().toLowerCase()))
				country = tempCountry;
		}
		return country;
	}
	
	private City getCityByName(String cityName) {
		City city = null;
		cityName = cityName.toLowerCase();
		for(City tempCity: cityArrayList) {
			if(cityName.equals(tempCity.getName().toLowerCase())) {
				city = tempCity;
				return city;
			}
		}
		return city;
	}
	
	public boolean isValidCountryName(String countryName) {
		countryName = countryName.toLowerCase();
		for(Country country: countryArrayList) {
			if(countryName.equals(country.getName().toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	public boolean isValidCityName(String cityName) {
		cityName = cityName.toLowerCase();
		for(City city: cityArrayList) {
			if(cityName.equals(city.getName().toLowerCase()))
				return true;
		}
		return false;
	}
}
