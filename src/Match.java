public class Match {
    private String club1;
    private String club2;
    private String club1Goals;
    private String club2Goals;
    private String date;

    public Match(String club1, String club2, String club1Goals, String club2Goals, String date) {
        this.club1 = club1;
        this.club2 = club2;
        this.club1Goals = club1Goals;
        this.club2Goals = club2Goals;
        this.date = date;
    }

    public Match(String club1,String club1Goals, String club2,String club2Goals) {
        this.club1 = club1;
        this.club2 = club2;
        this.club1Goals = club1Goals;
        this.club2Goals = club2Goals;
    }

    public String getClub1() {
        return club1;
    }

    public void setClub1(String club1) {
        this.club1 = club1;
    }

    public String getClub2() {
        return club2;
    }

    public void setClub2(String club2) {
        this.club2 = club2;
    }

    public String getClub1Goals() {
        return club1Goals;
    }

    public void setClub1Goals(String club1Goals) {
        this.club1Goals = club1Goals;
    }

    public String getClub2Goals() {
        return club2Goals;
    }

    public void setClub2Goals(String club2Goals) {
        this.club2Goals = club2Goals;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
