import java.io.Serializable;

public class FootballClub extends SportsClub implements Comparable<FootballClub>, Serializable {
    private int wins;
    private int draws;
    private int defeats;
    private int numberOfGoalsScored;
    private int numberOfGoalsReceived;
    private int points;
    private int totalMatches;

    public FootballClub(String clubID, String clubName, String location) {
        super(clubID, clubName, location);
    }

    public FootballClub(String clubID, String clubName, String location, int wins, int draws, int defeats, int numberOfGoalsScored, int numberOfGoalsReceived, int points, int totalMatches) {
        super(clubID, clubName, location);
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.numberOfGoalsScored = numberOfGoalsScored;
        this.numberOfGoalsReceived = numberOfGoalsReceived;
        this.points = points;
        this.totalMatches = totalMatches;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getNumberOfGoalsScored() {
        return numberOfGoalsScored;
    }

    public void setNumberOfGoalsScored(int numberOfGoalsScored) {
        this.numberOfGoalsScored = numberOfGoalsScored;
    }

    public int getNumberOfGoalsReceived() {
        return numberOfGoalsReceived;
    }

    public void setNumberOfGoalsReceived(int numberOfGoalsReceived) {
        this.numberOfGoalsReceived = numberOfGoalsReceived;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    @Override
    public int compareTo(FootballClub o) {
        if (points == o.points){
            return 0;
        }else if (points < o.points){
            return 1;
        }else {
            return -1;
        }
    }


    @Override
    public String toString() {
        return super.toString() + "\tPoints-"+points
                + "\tWins-" + wins
                + "\tDraws-" + draws
                + "\tDefeats-" + defeats
                + "\tNumberOfGoalsScored-" + numberOfGoalsScored
                + "\tNumberOfGoalsReceived-" + numberOfGoalsReceived
                + "\tTotalMatches-" + totalMatches
                ;
    }
}
