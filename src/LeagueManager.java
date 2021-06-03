public interface LeagueManager {
    void addNewClub(FootballClub footballClub);
    void deleteClub(String clubID);
    FootballClub searchClub(String clubID);
    void viewTable();
    void addNewMatch(Match match);
    void save();
    void load();
}
