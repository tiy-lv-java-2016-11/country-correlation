package com.theironyard.countrycorrelation;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;

/**
 * Created by sparatan117 on 12/12/16.
 */
public class Country {
    private String abbreviation;
    private String name;

    public Country( String abbreviation, String name) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return String.format("%s %s", abbreviation, name);
    }

    public static ArrayList<Country> readCountries() throws FileNotFoundException {
        ArrayList<Country> countryList = new ArrayList<>();
        File f = new File("/Users/sparatan117/Projects/country-correlation/countries.txt");
        Scanner scanner = new Scanner(f);

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country(columns[0], columns[1]);
            countryList.add(country);
        }
        return countryList;
    }

    public static HashMap<String, ArrayList<Country>> makeHash() throws FileNotFoundException {
        HashMap<String, ArrayList<Country>> countries = new HashMap<>();
        ArrayList<Country> countryList = Country.readCountries();

        for(Country country : countryList){
            String letter = String.valueOf(country.getName().charAt(0));
            ArrayList<Country> aLetter = countries.get(letter);

            if(aLetter == null){
                aLetter = new ArrayList<>();
                countries.put(letter, aLetter);
            }
            aLetter.add(country);

        }
        return countries;
    }
}

