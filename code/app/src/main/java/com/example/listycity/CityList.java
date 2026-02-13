package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     *      This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks if city is already in list of cites
     * @param city
     *      The city object to check if it's already present
     * @return
     *      Returns true if city is already present, otherwise false
     */
    public boolean hasCity(City city) {
        int list_size = this.cities.size();
        City o;
        boolean match = false;

        for (int i = 0; i < list_size; i++) {
            o = this.cities.get(i);
            // Comparison
            if (o == city) {
                match = true;
                break;
            }
            if (o.getCityName() == city.getCityName() &&
                    o.getProvinceName() == city.getProvinceName()) {
                match = true;
                break;
            }
        }
        return match;
    }

    /**
     * Deletes city if present in list of cities
     * @param city
     *      The city objected to be deleted
     */
    public void deleteCity(City city) {
        int list_size = this.cities.size();
        int i;
        City o;

        for (i = 0; i < list_size; i++) {
            o = this.cities.get(i);
            // Comparison
            if (o == city) {
                break;
            }
            if (o.getCityName() == city.getCityName() &&
                    o.getProvinceName() == city.getProvinceName()) {
                break;
            }
        }

        if (i == list_size) { // city not found
            throw new IllegalArgumentException();
        } else {
            this.cities.remove(i);
        }
    }

    /**
     * Returns the number of current held city objects
     * @return
     *      integer describing amount of city objects present
     */
    public int countCities() {
        return this.cities.size();
    }
}