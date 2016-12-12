package countrycorrelation;

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
            String[] column = nextLine.split("\\|");
            Country country = new Country(column[1]);
            countryList.add(country);

        }
        return countryList;
    }

    //This is where my brain stopped functioning usefully.
    //I will work on it more tomorrow morning and afternoon, sorry for not completing it.

    public ArrayList<String> loadKey() {
        ArrayList<String> keyList = new ArrayList<>();
        keyList.add("a");
        keyList.add("b");
        keyList.add("c");
        return keyList;
    }







    public static HashMap<String, ArrayList<Country>> load1() throws FileNotFoundException {
        HashMap<String, ArrayList<Country>> realList = new HashMap<>();
        int a = 0;
        while(a < Country.loadList().size()){
            Country.loadList();
            realList.put("", loadList());
            a++;
            Scanner scanner = new Scanner("countries.txt");
            String nextLine = scanner.nextLine();
            String[] column = nextLine.split("\\|");
            String checkSub = nextLine.substring(1);



        }
        return realList;
    }




}








