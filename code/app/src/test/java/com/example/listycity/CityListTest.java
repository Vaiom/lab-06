package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();  // Edmonton
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCities() {
        CityList cityList = new CityList();
        City cityA = mockCity();
        cityList.add(cityA);
        assertTrue(cityList.hasCity(cityA));  // same instance of city object

        // Initialize new city object with same values
        City cityB = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(cityB));  // different instance of city object with same values;

        // Initialize new city object with different values
        City cityC = new City("Charlottetown", "Prince Edward Island");
        assertFalse(cityList.hasCity(cityC));
    }

    @Test
    void testDeleteCity() {
        CityList cityList = new CityList();
        City cityA = mockCity();

        // from: https://www.baeldung.com/junit-assert-exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(cityA);
        });

        // Add cityA
        cityList.add(cityA);
        assertTrue(cityList.hasCity(cityA));

        assertDoesNotThrow(() -> {
            cityList.deleteCity(cityA);
        });
        assertFalse(cityList.hasCity(cityA));
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());

        City cityA = mockCity();
        City cityB = new City("Ottawa", "Ontario");

        // add 1 city
        cityList.add(cityA);
        assertEquals(1, cityList.countCities());

        // add 2 cities
        cityList.add(cityB);
        assertEquals(2, cityList.countCities());

        // Remove cities
        cityList.deleteCity(cityA);
        assertEquals(1, cityList.countCities());
        cityList.deleteCity(cityB);
        assertEquals(0, cityList.countCities());
    }
}
