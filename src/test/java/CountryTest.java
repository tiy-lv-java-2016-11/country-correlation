import countries.Country;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by melmo on 12/8/16.
 */
public class CountryTest {

    @Test
    public void testImportCountries() throws FileNotFoundException {
        ArrayList<Country> countries = Country.importCountries("countries.txt");
        assertEquals("Size of ArrayList not correct", 241, countries.size());
        assertEquals("Abbr of first object not correct", "AF", countries.get(0).getAbbr());
        assertEquals("Name of first object not correct", "afghanistan", countries.get(0).getName());
    }

    @Test
    public void testSortCountries() throws FileNotFoundException {
        HashMap<String , ArrayList<Country>> alphaCountries = Country.sortCountries(Country.importCountries("countries.txt"));
        assertEquals("Size of HashMap not correct", 25, alphaCountries.size());
        assertEquals("Size of ArrayList not correct", 15, alphaCountries.get("a").size());
        assertEquals("Abbr of first object not correct", "AF", alphaCountries.get("a").get(0).getAbbr());
        assertEquals("Name of first object not correct", "AF", alphaCountries.get("afghanistan").get(0).getName());

    }

    @Test
    public void testSaveSortFile(){

    }

}
