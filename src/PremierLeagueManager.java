import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class PremierLeagueManager implements LeagueManager {
    private static PremierLeagueManager premierLeagueManager;

    private ArrayList<FootballClub> listOfClub = new ArrayList<>();

    private ArrayList<Match> listOfMatch = new ArrayList<>();
    private static int max = 20;


    /**
     *  This is singleton class used to access form any where from ur project
     *  This class have only one object at a time.
     */
    public static PremierLeagueManager getInstance() {
        if (premierLeagueManager == null) {
            synchronized (PremierLeagueManager.class) {
                if (premierLeagueManager == null) {
                    premierLeagueManager = new PremierLeagueManager();
                }
            }
        }
        return premierLeagueManager;
    }

    public ArrayList<FootballClub> getListOfClub() {
        return listOfClub;
    }

    public ArrayList<Match> getListOfMatch() {
        return listOfMatch;
    }

    @Override
    public void addNewClub(FootballClub footballClub) {
        boolean b = false;
        if (listOfClub.size()<max){
            for (FootballClub club : listOfClub){
                if (footballClub.getClubID().equals(club.getClubID())){
                    b = true;
                    break;
                }
            }
            if (b == true){
                System.out.println("Club ID exists! Try Again.");
            } else{
                listOfClub.add(footballClub);
            }
        }
    }

    @Override
    public void deleteClub(String clubID) {

        if (listOfClub.isEmpty()) {
            System.out.println("List is empty");
        }else {
            boolean b = false;
            for (FootballClub club : listOfClub){
                if (clubID.equals(club.getClubID())){
                    b = true;
                    System.out.println(club);
                    listOfClub.remove(club);
                    System.out.println("Delete is successful");
                    break;
                }
            }
            if (b == false){
                System.out.println("Club Not Exists! Try Again.");
            }
        }
    }

    @Override
    public FootballClub searchClub(String clubID) {
        if (listOfClub.isEmpty()) {
            System.out.println("List is empty.");
        }else {
            boolean b = false;
            for (FootballClub club : listOfClub){
                if (clubID.equals(club.getClubID())){
                    b = true;
                    System.out.println(club);
                    break;
                }
            }
            if (b == false){
                System.out.println("Club Not Exists! Try Again");
            }
        }
        return null;
    }

    @Override
    public void viewTable() {
        if (listOfClub.isEmpty()) {
            System.out.println("List is empty.");
        }else {
            Collections.sort(listOfClub);
            for (FootballClub club : listOfClub){
                System.out.println(club);
            }
        }
    }

    @Override
    public void addNewMatch(Match match) {
        listOfMatch.add(match);
        System.out.println("Match Added is successful");
    }

    @Override
    public void save() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("SaveFile.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            for (FootballClub club : listOfClub) {
                outputStream.writeObject(club);
            }
            outputStream.close();
            fileOutputStream.close();

            System.out.println("Save is successful");
        } catch (Exception e){
            System.out.println("Error! Try Again.");
        }

        //match save
        try {
            FileOutputStream fileOutputStream1 = new FileOutputStream("SaveFile1.txt");
            ObjectOutputStream outputStream1 = new ObjectOutputStream(fileOutputStream1);

            for (Match match : listOfMatch) {
                outputStream1.writeObject(match);
            }
            outputStream1.close();
            fileOutputStream1.close();
            System.out.println("Save is successful");
        } catch (Exception e){
            System.out.println("Error! Try Again.");
        }

    }

    @Override
    public void load() {
        try {
            FileInputStream fileInputStream = new FileInputStream("SaveFile.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            for (; ; ) {            //infinite for loop
                try {
                    FootballClub footballClub = (FootballClub) objectInputStream.readObject();
                    listOfClub.add(footballClub);
                } catch (EOFException e) {          //end of file exception
                    break;
                }
            }

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Loaded is successful");
        } catch (Exception e) {
            System.out.println("Error! Try Again.");
        }

        //match load
        try {
            FileInputStream fileInputStream1 = new FileInputStream("SaveFile1.txt");
            ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);

            for (; ; ) {            //infinite for loop
                try {
                    Match match = (Match) objectInputStream1.readObject();
                    listOfMatch.add(match);
                } catch (EOFException e) {      //end of file exception
                    break;
                }
            }

            objectInputStream1.close();
            fileInputStream1.close();

            System.out.println("Loaded is successful");
        } catch (Exception e) {
            System.out.println("Error! Try Again.");
        }
    }
}
