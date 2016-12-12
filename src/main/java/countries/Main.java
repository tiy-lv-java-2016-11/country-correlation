package countries;

import com.sun.org.apache.bcel.internal.classfile.SourceFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by melmo on 12/8/16.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        ArrayList<Country> countries = Country.importCountries("countries.txt");

        HashMap<String , ArrayList<Country>> alphaCountries = Country.sortCountries(countries);

        System.out.println("\nPlease choose a letter");
        String letter = input.nextLine();

        if (letter.length() > 1){
            throw new Exception("Please enter a single letter");
        }
        else {
            Country.saveSortFile(alphaCountries, letter);
        }

    }

}
