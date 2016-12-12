package countries;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by melmo on 12/8/16.
 */
public class Country {
    String abbr;
    String name;

    public Country(){}

    public Country(String abbr, String name) {
        this.abbr = abbr;
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", this.abbr, this.name);
    }

    /* *
     * Converts list of countries in .txt file to an ArrayList of
     * Country objects
     * @param filename File path to .txt file containing list
     * */
    public static ArrayList<Country> importCountries(String filename) throws FileNotFoundException {
        ArrayList<Country> countries = new ArrayList<>();
        File f = new File(filename);
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()){
            String line = fileScanner.nextLine();
            String[] fields = line.split("\\|");
            Country temp = new Country(fields[0], fields[1]);
            countries.add(temp);
        }
        return countries;
    }

    /* *
     * Sorts an ArrayList of Country objects into a HashMap of ArrayLists
     * containing all countries that start with the same letter.
     * @param alphaCountries An unsorted ArrayList of Country objects
     * @return A HashMap of ArrayLists of Country objects sorted by starting letter
     * */
    public static HashMap<String, ArrayList<Country>> sortCountries(ArrayList<Country> countries){
        HashMap<String , ArrayList<Country>> alphaCountries = new HashMap<>();
        for (Country country : countries){
            String ch = String.valueOf(country.getName().charAt(0));
            ArrayList<Country> temp = alphaCountries.get(ch);
            if (temp == null) {
                temp = new ArrayList<>();
                temp.add(country);
                alphaCountries.put(ch, temp);
            }
            else {
                temp.add(country);
            }
        }
        return alphaCountries;
    }

    /* *
     * Saves the ArrayList of Countries starting with a chosen letter to a file.
     * @param countries HashMap of ArrayLists of Country objects sorted by starting letter
     * @param letter Single letter choosing which ArrayList of Countries to save
     * */
    public static void saveSortFile(HashMap<String, ArrayList<Country>> countries, String letter) throws Exception {
        String filename = letter.toUpperCase() + "_countries.txt";
        ArrayList<Country> list = countries.get(letter.toLowerCase());
        if (list == null){
            throw new Exception("No countries exist for that letter");
        }
        File f = new File(filename);
        FileWriter fw = new FileWriter(f);
        fw.write("");
        for (Country country : list){
            fw.append(String.format("%s|%s\n", country.getAbbr(), country.getName()));
        }
        fw.close();
    }

}
