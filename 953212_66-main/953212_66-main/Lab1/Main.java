package Lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String args[]) throws IOException {
    Vector<UniData> myUni = new Vector<UniData>();
    System.out.println("Program start!");

    // Parsing a CSV file into Scanner class constructor
    Scanner sc = new Scanner(new File(
            "C:/Users/TUF GAMING/Desktop/953212_66-main/953212_66-main/Lab1/QS-World-University-Rankings-2017_full.csv"));
    sc.useDelimiter(","); // sets the delimiter pattern

    // Skip the header
    sc.nextLine();
    while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] data = line.split(",");

        if (data.length >= 9) {
            UniData u = new UniData(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);

            if (u.getRank().matches("\\d+")) {
                myUni.add(u);
                System.out.println(u);
            }
        }
    }

    sc.close();

    // Sort by university name
    Collections.sort(myUni);

    change(myUni);

    try {
        PrintWriter writer = new PrintWriter(
                "C:/Users/TUF GAMING/Desktop/953212_66-main/953212_66-main/Lab1/QS-World-University-Rankings-2017_update.csv");
        writer.println("Year,Rank,University,Score,Link,Country,City,Region,Logo");

        for (UniData uni : myUni) {
            writer.println(uni.getYear() + "," + uni.getRank() + "," + uni.getUniName().replaceAll(",", "||")
                    + "," + uni.getScore() + "," + uni.getLink() + "," + uni.getCountry() + ","
                    + uni.getCity() + "," + uni.getRegion() + "," + uni.getLogo());
        }

        writer.close();
        System.out.println("Rewrite Completed");
    } catch (FileNotFoundException e) {
        System.out.println("Error: File not found. Please try again. " + e.getMessage());
    }

    System.out.println("Program terminated properly!");
}
     public static void change(Vector<UniData> ds_uni){
        for (int i = 0; i < ds_uni.size(); i++) {
            if(ds_uni.get(i).getUniName() != null)
                ds_uni.get(i).setUniName((ds_uni.get(i).getUniName().toLowerCase()));
        }
    }
}
