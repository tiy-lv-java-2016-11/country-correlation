package countrycorrelation;

import org.hamcrest.core.StringStartsWith;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by darionmoore on 12/9/16.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Country> countryList = new ArrayList<>();
        HashMap<String,  ArrayList<Country>> realList = new HashMap<>();
        Country.load1();
        System.out.format("%s,", realList.containsKey("a"));









    }
}






