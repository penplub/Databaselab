import java.util.*;
import java.io.*;

public class lab1 {
    public static void main(String[] args) {
        Vector<Student> collection = new Vector<Student>();

        try {
            File file = new File("C:\\Users\\CAMT\\Desktop\\Lab1data\\QS World University Rankings 2017.csv");
            Scanner sc = new Scanner(file);
            sc.nextLine(); // Skip the header line

            int count = 0;
            while (sc.hasNextLine() && count < 3) {
                String[] temp = sc.nextLine().split("\"?(,|$)(?=(([^\"]*\"){2})*[^\"]*$) *\"?");
                String year = temp[0].trim();
                String rank = temp[1].trim();
                String university = temp[2].trim();
                String score = (temp.length > 3 && temp[3] != null && !temp[3].isEmpty()) ? temp[3].trim() : "0";
                String link = temp[4].trim();
                String country = temp[5].trim();
                String city = temp[6].trim();
                String region = temp[7].trim();
                String logo = temp[8].trim();

                Student student = new Student(year, rank, university, score, link, country, city, region, logo);
                collection.addElement(student);

                count++;
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
            return;
        }

        // Create a new record for Chiang Mai University in 2017
        String year = "2017";
        String rank = "-1";
        String university = "Chiang Mai University";
        String score = "-1.0";
        String link = "";
        String country = "";
        String city = "";
        String region = "";
        String logo = "";

        Student chiangMaiUni = new Student(year, rank, university, score, link, country, city, region, logo);

        // Add the Chiang Mai University record to the vector
        collection.addElement(chiangMaiUni);

        // Write the records to the output file
        try {
            PrintWriter writer = new PrintWriter("C:\\Users\\CAMT\\Desktop\\Lab1data\\QS_World University Ranking 2017_out.csv");
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
