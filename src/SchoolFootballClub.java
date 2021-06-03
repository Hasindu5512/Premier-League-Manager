public class SchoolFootballClub extends FootballClub {

    private String sclName;

    public SchoolFootballClub(String clubID, String clubName, String location, String sclName) {
        super(clubID, clubName, location);
        this.sclName = sclName;
    }

    public String getSclName() {
        return sclName;
    }

    public void setSclName(String sclName) {
        this.sclName = sclName;
    }
}
