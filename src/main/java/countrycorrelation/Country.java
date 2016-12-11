package countrycorrelation;

import jodd.json.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by darionmoore on 12/9/16.
 */
public class Country {
    private String name;
    private String abbreviation;


    public Country(String name) throws FileNotFoundException {
        this.name = name;

    }

    public Country() {
        this.abbreviation = getAbbreviation();

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

    public void setAbbreviation(String abbreviation) throws FileNotFoundException {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return String.format("Name: %s", getName());
    }

    public static ArrayList<Country> loadList() throws FileNotFoundException {
        ArrayList<Country> countryList = new ArrayList<>();

        File file = new File("countries.txt");
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNext()) {
            String nextLine = fileScanner.nextLine();
            String[] columns = nextLine.split("\\|");
            Country country = new Country(columns[1]);
            countryList.add(country);
            System.out.format("\n%s", countryList);
        }
        return countryList;
    }

    public static HashMap<String, ArrayList<Country>> load1() throws FileNotFoundException {
        HashMap<String, ArrayList<Country>> abbreviationList = new HashMap<>();
        Scanner key = new Scanner(System.in);
        String theKey = key.nextLine();

        File file2 = new File("countries.txt");
        Scanner fileScanner2 = new Scanner(file2);
        while (fileScanner2.hasNext()) {
            String nextLine2 = fileScanner2.nextLine();
            String[] theValue = nextLine2.split("\\|");
            Country country1 = new Country(theValue[1]);
            abbreviationList.put(theKey, Country.loadList());
            if((theKey.matches(theValue[1]))){
                System.out.format(theValue[1]);

            }

        }
        return abbreviationList;
    }
}







