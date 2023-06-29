public class Student {
    private String year;
    private String rank;
    private String university;
    private String score;
    private String link;
    private String country;
    private String city;
    private String region;
    private String logo;

    public Student(String year, String rank, String university, String score, String link, String country, String city, String region, String logo) {
        this.year = year;
        this.rank = rank;
        this.university = university;
        this.score = score;
        this.link = link;
        this.country = country;
        this.city = city;
        this.region = region;
        this.logo = logo;
    }

    public String getYear() {
        return this.year;
    }

    public String getRank() {
        return this.rank;
    }

    public String getUniversity() {
        return this.university;
    }

    public String getScore() {
        return this.score;
    }

    public String getLink() {
        return this.link;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCity() {
        return this.city;
    }

    public String getRegion() {
        return this.region;
    }

    public String getLogo() {
        return this.logo;
    }
}