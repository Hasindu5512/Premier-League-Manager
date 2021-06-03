public class UniversityFootballClub extends FootballClub {

    private String uniName;

    public UniversityFootballClub(String uniName, String clubID, String clubName, String location) {
        super(clubID, clubName, location);
        this.uniName = uniName;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }
}
