import java.util.*;
import java.io.*;

public class lab1 {
    public static void main(String[] args) {
        Vector<Student> collection = new Vector<Student>();

        try {
            File file = new File("C:/Users/TUF GAMING/Desktop/Lab1data/QS World University Rankings 2017.csv");
            Scanner sc = new Scanner(file);
            sc.nextLine(); // Skip the header line

            while (sc.hasNextLine()) {
                String[] temp = sc.nextLine().split("\"?(,|$)(?=(([^\"]*\"){2})*[^\"]*$) *\"?");
                String year = temp[0].trim();
                String rank = temp[1].trim();
                String university = temp[2].trim();
                String score = "0"; // Default score value
                String link = "";
                String country = "";
                String city = "";
                String region = "";
                String logo = "";

                if (temp.length > 3) {
                    score = temp[3].trim();
                }
                if (temp.length > 4) {
                    link = temp[4].trim();
                }
                if (temp.length > 5) {
                    country = temp[5].trim();
                }
                if (temp.length > 6) {
                    city = temp[6].trim();
                }
                if (temp.length > 7) {
                    region = temp[7].trim();
                }
                if (temp.length > 8) {
                    logo = temp[8].trim();
                }

                Student student = new Student(year, rank, university, score, link, country, city, region, logo);
                collection.addElement(student);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
            return;
        }

        // Create a new record for Chiang Mai University in 2017
        String year = "2017";
        String rank = "22";
        String university = "Chiang Mai University";
        String score = "88";
        String link = "https://www.cmu.ac.th/";
        String country = "Thailand";
        String city = "Chiangmai";
        String region = "Thai";
        String logo = "https://www.google.com/search?q=cmu+logo&rlz=1C1GCEA_enTH993TH993&sxsrf=APwXEdeBr0Rwq-yXf0mAndkY9uyui0eKuw:1688038817602&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjPjNzQsuj_AhX-xjgGHV97ByUQ_AUoAXoECAEQAw&biw=1536&bih=714&dpr=1.25#imgrc=BhimpGM0a0apzM";

        Student chiangMaiUni = new Student(year, rank, university, score, link, country, city, region, logo);

        // Add the Chiang Mai University record to the vector
        collection.addElement(chiangMaiUni);

        // Write the records to the output file
        try {
            PrintWriter writer = new PrintWriter("C:/Users/TUF GAMING/Desktop/Lab1data/QS World University Rankings 2017_out.csv");
            writer.println("Year,Rank,University,Score,Link,Country,City,Region,Logo");

            for (Student student : collection) {
                writer.println(student.getYear() + "," + student.getRank() + "," + student.getUniversity() + "," +
                        student.getScore() + "," + student.getLink() + "," + student.getCountry() + "," +
                        student.getCity() + "," + student.getRegion() + "," + student.getLogo());
            }

            writer.close();
            System.out.println("Completed! Chiang Mai University record inserted and written to QS_World University Ranking 2017_out.csv.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        }
    }
}