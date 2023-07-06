package Lab1;

public class UniData implements Comparable<UniData> {
    String year, score, uniName, link, city, country, logo, rank, region;

    public UniData() {
    }

    public UniData(String year, String rank, String uniName, String score, String link, String country, String city,
            String logo, String region) {
        if (score == null) {
            score = "0";
        }
        this.year = year;
        this.rank = rank;
        this.uniName = uniName;
        this.score = score;
        this.link = link;
        this.country = country;
        this.city = city;
        this.logo = logo;
        this.region = region;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String  getScore() {
        if (!this.score.isEmpty()) {

            double scoreValue = Double.parseDouble(score);    //round the score 
    long roundedScore = Math.round(scoreValue);
    return String.valueOf(roundedScore);
        }

        else {
            return this.score ;
        }

    }

    public void setScore(String score) {
        if (score == null) {
            score = "0";
        }
        this.score = score;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getRank() {
        return rank;
    }

   public void setRank(String rank) {
        this.rank = rank.replaceAll("\\D", "");
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public int compareTo(UniData x) {
        return this.uniName.compareTo(x.uniName);
    }

    @Override
    public String toString() {
        return "[" + year + ", " + rank + ", " + uniName + ", " + score + ", " + link + ", " + country + ", " + city
                + ", " + region + ", " + logo + "]";
    }
}
