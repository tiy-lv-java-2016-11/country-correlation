package com.theironyard.countrycorrelation;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sparatan117 on 12/12/16.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        HashMap<String, ArrayList<Country>> ordered = Country.makeHash();

        System.out.println("\nenter a letter: ");
        String pick = input.nextLine();
        if(pick.length() == 1){
            String newName = pick.toUpperCase() + "_countries.txt";
            ArrayList<Country> lettersList = ordered.get(pick);
            if(lettersList == null){
                throw new Exception("there are not countries with that letter");
            }

            File f = new File(newName);
            FileWriter fw = new FileWriter(f);
            fw.write("");

            for(Country country : lettersList){
                fw.append(String.format("%s|%s\n", country.getAbbreviation(), country.getName()));
            }

            fw.close();
        }
        else{
            throw new Exception("enter one letter");
        }
    }
}

