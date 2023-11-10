package climates.management;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import climates.locations.City;
import climates.locations.Country;

public class FileRead {
	
	private static final String filePath = "./resources/countries_and_cities.csv";
	
	public void readCountriesAndCities(ArrayList<Country> countryArrayList, ArrayList<City> cityArrayList) {
		// Method that reads contries and cities file and adds to array lists.
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
			String line;
			while((line = bufferedReader.readLine()) != null) {
				String[] stringArray = line.split(", ");
				Country country = new Country(stringArray[0]);

				for(int i = 1; i < stringArray.length; i++) {
					City city = new City(stringArray[i]);
					cityArrayList.add(city);
				}
				countryArrayList.add(country);
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.err.println("File could not be found!");
		} catch (IOException e) {
			System.err.println("File could not be read!");
		}
	}
}
