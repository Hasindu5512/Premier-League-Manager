import java.io.Serializable;
import java.util.Objects;

public abstract class SportsClub implements Serializable {
    private String clubID;
    private String clubName;
    private String location;

    public SportsClub(String clubID, String clubName, String location) {
        this.clubID = clubID;
        this.clubName = clubName;
        this.location = location;
    }

    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /**
    * .... For Searching Methods .........
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportsClub)) return false;
        SportsClub that = (SportsClub) o;
        return getClubID().equals(that.getClubID()) &&
                getClubName().equals(that.getClubName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClubID(), getClubName());
    }

    @Override
    public String toString() {
        return "\tID-"+clubID + "\tName-"+clubName;
    }
}
