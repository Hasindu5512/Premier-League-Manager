import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.*;

public class GUIMain extends Application {
    private static PremierLeagueManager premierLeagueManager;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scanner sc = new Scanner(System.in);

        try {
            premierLeagueManager = PremierLeagueManager.getInstance();
        }catch (Exception e){
            System.out.println("Error!");
        }

        /**
         *  List of CLI menu
         */
        loop1:
        while (true) {
            System.out.println("\t ___________________________________________");
            System.out.println("\t|                                           |");
            System.out.println("\t| \tWELCOME TO PREMIER LEAGUE MANAGEMENT \t|");
            System.out.println("\t|___________________________________________|\n");

            System.out.println("Press \'1\' to Add Club");
            System.out.println("Press \'2\' to Delete club");
            System.out.println("Press \'3\' to Search for club");
            System.out.println("Press \'4\' to View league table");
            System.out.println("Press \'5\' to Add match");
            System.out.println("Press \'6\' to Save");
            System.out.println("Press \'7\' to Load");
            System.out.println("Press \'8\' to Open GUI");
            System.out.println("Press \'0\' to Exit the program");

            System.out.print("\nPlease..! Enter your choice :- ");
            String input = sc.next();

            switch (input) {
                case "1":
                    System.out.print("Enter the Club ID : ");
                    String clubID = sc.next();

                    System.out.print("Enter the Club Name : ");
                    String clubName = sc.next();

                    System.out.print("Enter the Club Location : ");
                    String location = sc.next();

                    FootballClub footballClub = new FootballClub(clubID, clubName, location);
                    premierLeagueManager.addNewClub(footballClub);
                    break;
                case "2":
                    System.out.print("Enter club ID to delete : ");
                    clubID = sc.next();
                    premierLeagueManager.deleteClub(clubID);
                    break;
                case "3":
                    System.out.print("Enter club ID to Search : ");
                    clubID = sc.next();
                    premierLeagueManager.searchClub(clubID);
                    break;
                case "4":
                    premierLeagueManager.viewTable();
                    break;
                case "5":
                    addMatch();
                    break;
                case "6":
                    premierLeagueManager.save();
                    break;
                case "7":
                    premierLeagueManager.load();
                    break;
                case "8":
                    openGUI();
                    break;
                case "0":
                    System.out.println("\nYou are exiting the program..!");
                    System.out.println("Thank You..!");
                    break loop1;
                default:
                    System.out.println("Please, Enter the valid input.\n");
            }
        }
    }

    private void openGUI() {
        Stage stgGUI = new Stage();
        stgGUI.setTitle("Premier League Manager");

        Pane paneGUI = new Pane();
        paneGUI.setStyle("-fx-background-color: #d1d8e0");

        Label lblTitle = new Label("Premier League Manager\n \t\t System");
        lblTitle.setStyle("-fx-background-color: #263238; -fx-border-width: 11px; -fx-border-color:  #778ca3; -fx-text-fill: aliceblue;-fx-pref-height: 115; -fx-pref-width: 620;-fx-alignment: center");
        lblTitle.setLayoutX(159);
        lblTitle.setLayoutY(24);
        lblTitle.setFont(new Font("Goudy Stout", 22));

        /**
         * ...Main Table View.........
         */
        TableView tableView = new TableView();
        tableView.setStyle("-fx-pref-width: 870; -fx-pref-height: 400; ");

        TableColumn<FootballClub, String> column = new TableColumn<>("Club ID");
        column.setCellValueFactory(new PropertyValueFactory<>("clubID"));

        TableColumn<FootballClub, String> column1 = new TableColumn<>("Club Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("clubName"));

        TableColumn<FootballClub, String> column0 = new TableColumn<>("Club Location");
        column0.setCellValueFactory(new PropertyValueFactory<>("location"));


        TableColumn<FootballClub, Integer> column3 = new TableColumn<>("Wins");
        column3.setCellValueFactory(new PropertyValueFactory<>("wins"));

        TableColumn<FootballClub, Integer> column4 = new TableColumn<>("Draws");
        column4.setCellValueFactory(new PropertyValueFactory<>("draws"));

        TableColumn<FootballClub, Integer> column5 = new TableColumn<>("Defeats");
        column5.setCellValueFactory(new PropertyValueFactory<>("defeats"));

        TableColumn<FootballClub, Integer> column6 = new TableColumn<>("Scored Goals");
        column6.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsScored"));

        TableColumn<FootballClub, Integer> column7 = new TableColumn<>(" Received Goals");
        column7.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsReceived"));

        TableColumn<FootballClub, Integer> column2 = new TableColumn<>("Points");
        column2.setCellValueFactory(new PropertyValueFactory<>("points"));

        TableColumn<FootballClub, Integer> column8 = new TableColumn<>("Total Matches");
        column8.setCellValueFactory(new PropertyValueFactory<>("totalMatches"));

        tableView.getColumns().add(column);
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column0);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);
        tableView.getColumns().add(column7);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column8);

        for (int i=0; i<premierLeagueManager.getListOfClub().size(); i++){
            tableView.getItems().add(new FootballClub(
                    premierLeagueManager.getListOfClub().get(i).getClubID(),
                    premierLeagueManager.getListOfClub().get(i).getClubName(),
                    premierLeagueManager.getListOfClub().get(i).getLocation(),
                    premierLeagueManager.getListOfClub().get(i).getWins(),
                    premierLeagueManager.getListOfClub().get(i).getDraws(),
                    premierLeagueManager.getListOfClub().get(i).getDefeats(),
                    premierLeagueManager.getListOfClub().get(i).getNumberOfGoalsScored(),
                    premierLeagueManager.getListOfClub().get(i).getNumberOfGoalsReceived(),
                    premierLeagueManager.getListOfClub().get(i).getPoints(),
                    premierLeagueManager.getListOfClub().get(i).getTotalMatches()
            ));
        }

        VBox vbox = new VBox(tableView);
        vbox.setLayoutX(55);
        vbox.setLayoutY(215);

        //...Sort btns.........
        Label lblSort = new Label("Sort Type : ");
        lblSort.setLayoutX(72);
        lblSort.setLayoutY(645);
        lblSort.setStyle("-fx-font-size: 21px; -fx-font-weight: bold");

        Button sortWinsBtn = new Button("Wins");
        sortWinsBtn.setLayoutX(200);
        sortWinsBtn.setLayoutY(638);
        sortWinsBtn.setStyle("-fx-pref-width:110;-fx-pref-height:25px;-fx-background-color: #006064;-fx-text-fill: #FFFFFF;-fx-background-radius: 20px;-fx-border-color: aliceblue;-fx-border-radius: 20;-fx-border-width: 2;-fx-font-size: 18px ");
        sortWinsBtn.setOnAction(event -> {

            column3.setSortable(true);
            column6.setSortable(false);
            column2.setSortable(false);

            column3.setSortType(TableColumn.SortType.DESCENDING);
            tableView.getSortOrder().add(column3);
        });

        Button sortGaolsBtn = new Button("Goals");
        sortGaolsBtn.setLayoutX(360);
        sortGaolsBtn.setLayoutY(638);
        sortGaolsBtn.setStyle("-fx-pref-width:110;-fx-pref-height:25px;-fx-background-color: #006064;-fx-text-fill: #FFFFFF;-fx-background-radius: 20px;-fx-border-color: aliceblue;-fx-border-radius: 20;-fx-border-width: 2;-fx-font-size: 18px ");
        sortGaolsBtn.setOnAction(event -> {
            column6.setSortable(true);
            column3.setSortable(false);
            column2.setSortable(false);

            column6.setSortType(TableColumn.SortType.DESCENDING);
            tableView.getSortOrder().add(column6);
        });

        Button sortPointBtn = new Button("Points");
        sortPointBtn.setLayoutX(510);
        sortPointBtn.setLayoutY(638);
        sortPointBtn.setStyle("-fx-pref-width:120;-fx-pref-height:25px;-fx-background-color: #006064;-fx-text-fill: #FFFFFF;-fx-background-radius: 20px;-fx-border-color: aliceblue;-fx-border-radius: 20;-fx-border-width: 2;-fx-font-size: 18px ");
        sortPointBtn.setOnAction(event -> {

            column2.setSortable(true);
            column6.setSortable(false);
            column3.setSortable(false);

            column2.setSortType(TableColumn.SortType.DESCENDING);
            tableView.getSortOrder().add(column2);
        });

        /**
         * ...Add Random Match........
         */
        Button btnMatch = new Button("Click Here to Add Match");
        btnMatch.setLayoutX(48);
        btnMatch.setLayoutY(150);
        btnMatch.setStyle("-fx-pref-width:270;-fx-pref-height:32px;-fx-background-color: #006064;-fx-text-fill: #FFFFFF;-fx-background-radius: 20px;-fx-border-color: aliceblue;-fx-border-radius: 20;-fx-border-width: 2;-fx-font-size: 20px ");
        btnMatch.setOnAction(event -> {

            Random random = new Random();

            while (true) {
                int club1 = random.nextInt(premierLeagueManager.getListOfClub().size());
                int club2 = random.nextInt(premierLeagueManager.getListOfClub().size());
                int club1Goals = random.nextInt(5);
                int club2Goals = random.nextInt(5);

                if (club1 == club2) {
                    continue;
                } else {

                    FootballClub footballClub1 = premierLeagueManager.getListOfClub().get(club1);
                    FootballClub footballClub2 = premierLeagueManager.getListOfClub().get(club2);

                    if (club1Goals == club2Goals) {
                        footballClub1.setDraws(footballClub1.getDraws() + 1);
                        footballClub1.setNumberOfGoalsScored(footballClub1.getNumberOfGoalsScored() + Integer.valueOf(club1Goals));
                        footballClub1.setNumberOfGoalsReceived(footballClub1.getNumberOfGoalsReceived() +  Integer.valueOf(club2Goals));
                        footballClub1.setPoints(footballClub1.getPoints()+1);

                        footballClub2.setDraws(footballClub2.getDraws() + 1);
                        footballClub2.setNumberOfGoalsScored(footballClub2.getNumberOfGoalsScored() +  Integer.valueOf(club2Goals));
                        footballClub2.setNumberOfGoalsReceived(footballClub2.getNumberOfGoalsReceived() +  Integer.valueOf(club1Goals));
                        footballClub2.setPoints(footballClub2.getPoints()+0);

                    } else if (club1Goals > club2Goals) {
                        footballClub1.setWins(footballClub1.getWins() + 1);
                        footballClub1.setNumberOfGoalsScored(footballClub1.getNumberOfGoalsScored() +  Integer.valueOf(club1Goals));
                        footballClub1.setNumberOfGoalsReceived(footballClub1.getNumberOfGoalsReceived() + Integer.valueOf(club2Goals));
                        footballClub1.setPoints(footballClub1.getPoints()+3);

                        footballClub2.setDefeats(footballClub2.getDefeats() + 1);
                        footballClub2.setNumberOfGoalsScored(footballClub2.getNumberOfGoalsScored() + Integer.valueOf(club2Goals));
                        footballClub2.setNumberOfGoalsReceived(footballClub2.getNumberOfGoalsReceived() + Integer.valueOf(club1Goals));
                        footballClub2.setPoints(footballClub2.getPoints()+0);
                    } else {
                        footballClub1.setDefeats(footballClub1.getDefeats() + 1);
                        footballClub1.setNumberOfGoalsScored(footballClub1.getNumberOfGoalsScored() +  Integer.valueOf(club1Goals));
                        footballClub1.setNumberOfGoalsReceived(footballClub1.getNumberOfGoalsReceived() +  Integer.valueOf(club2Goals));
                        footballClub1.setPoints(footballClub1.getPoints()+0);

                        footballClub2.setWins(footballClub1.getWins() + 1);
                        footballClub2.setNumberOfGoalsScored(footballClub2.getNumberOfGoalsScored() + Integer.valueOf(club1Goals));
                        footballClub2.setNumberOfGoalsReceived(footballClub2.getNumberOfGoalsReceived() + Integer.valueOf(club2Goals));
                        footballClub2.setPoints(footballClub2.getPoints()+3);
                    }

                    footballClub1.setTotalMatches(footballClub1.getTotalMatches() + 1);
                    footballClub2.setTotalMatches(footballClub2.getTotalMatches() + 1);

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");
                    Date d = new Date();
                    String date = simpleDateFormat.format(d);

                    Match m = new Match(footballClub1.getClubName(),footballClub2.getClubName(),String.valueOf(club1Goals),String.valueOf(club2Goals),date);
                    premierLeagueManager.addNewMatch(m);


                    //---Random match output--------
                    Stage stgSearch = new Stage();
                    stgSearch.setTitle("Club Two Details");

                    Label lbl1 = new Label();
                    Label lbl1goal = new Label();
                    Label lbl2 = new Label();
                    Label lbl2goal = new Label();
                    Label lblvs = new Label("VS");

                    lbl1.setText(footballClub1.getClubName());
                    lbl2.setText(footballClub2.getClubName());
                    lbl1goal.setText(String.valueOf(club1Goals));
                    lbl2goal.setText(String.valueOf(club2Goals));

                    lbl1.setLayoutX(20);
                    lbl1.setLayoutY(30);

                    lbl2.setLayoutX(250);
                    lbl2.setLayoutY(30);

                    lbl1goal.setLayoutX(50);
                    lbl1goal.setLayoutY(90);

                    lbl1goal.setLayoutX(50);
                    lbl1goal.setLayoutY(90);

                    lbl2goal.setLayoutX(280);
                    lbl2goal.setLayoutY(90);

                    lblvs.setLayoutY(40);
                    lblvs.setLayoutX(160);

                    lbl1.setStyle("-fx-background-color: #81ecec;-fx-alignment: center ; -fx-font-size: 25px; -fx-pref-height: 50px;-fx-pref-width: 120px; -fx-font-weight: bold");
                    lbl2.setStyle("-fx-background-color: #81ecec;-fx-alignment: center ; -fx-font-size: 25px; -fx-pref-height: 50px;-fx-pref-width: 120px; -fx-font-weight: bold");
                    lbl1goal.setStyle("-fx-background-color: #81ecec;-fx-alignment: center ; -fx-font-size: 25px; -fx-pref-height: 50px;-fx-pref-width: 70px; -fx-font-weight: bold");
                    lbl2goal.setStyle("-fx-background-color: #81ecec;-fx-alignment: center ; -fx-font-size: 25px; -fx-pref-height: 50px;-fx-pref-width: 70px; -fx-font-weight: bold");
                    lblvs.setStyle("-fx-background-color: #60a3bc;-fx-alignment: center ; -fx-font-size: 50px; -fx-pref-height: 100px;-fx-pref-width: 70px; -fx-font-family: Forte; -fx-text-fill: #e84118; -fx-font-weight: bold");

                    stgGUI.close();
                    AnchorPane pane = new AnchorPane();
                    pane.setStyle("-fx-background-color: #82ccdd");

                    pane.getChildren().addAll(lbl1,lbl1goal,lbl2,lbl2goal,lblvs);
                    stgSearch.setScene(new Scene(pane,370,150));
                    stgSearch.setResizable(false);
                    stgSearch.showAndWait();

                    break;
                }
            }
        });


        /**
         *      ...To Search........
         *  Search using date
         */

        TextField txtSearch = new TextField();
        txtSearch.setPromptText("Enter match held date");
        txtSearch.setLayoutX(550);
        txtSearch.setLayoutY(153);
        txtSearch.setStyle("-fx-pref-width: 235px;-fx-pref-height: 32px ; -fx-font-size: 18px");

        Button btnSearch = new Button("Search");
        btnSearch.setLayoutX(800);
        btnSearch.setLayoutY(150);
        btnSearch.setStyle("-fx-pref-width:96;-fx-pref-height:32px;-fx-background-color: #006064;-fx-text-fill: #FFFFFF;-fx-background-radius: 20px;-fx-border-color: aliceblue;-fx-border-radius: 20;-fx-border-width: 2;-fx-font-size: 20px ");
        btnSearch.setOnAction(event -> {
            if (txtSearch.getText().isEmpty()){
                Alert alertEmptySpace = new Alert(Alert.AlertType.ERROR,"Please.! Input match held date",ButtonType.OK);
                alertEmptySpace.show();
            }else {                                     /**Empty space error*/
                try {
                    boolean a = false;
                    ArrayList<Match> matches = new ArrayList<>();
                    for (Match match : premierLeagueManager.getListOfMatch()) {
                        if (txtSearch.getText().equals(match.getDate())) {
                            a = true;
                            matches.add(match);
                        }
                    }

                    if (a == false) {
                        Alert alertEmptySpace = new Alert(Alert.AlertType.ERROR,"Matches Not Exists! Try Again",ButtonType.OK);
                        alertEmptySpace.show();
                    } else {
                        Stage stgSearch = new Stage();
                        stgSearch.setTitle("Club Two Details");

                        TableView tableView1 = new TableView();
                        tableView1.setStyle("-fx-pref-width: 870; -fx-pref-height: 400; ");

                        TableColumn<Match, String> colum1 = new TableColumn<>("Team 1");
                        colum1.setCellValueFactory(new PropertyValueFactory<>("club1"));

                        TableColumn<Match, String> colum2 = new TableColumn<>("Team 1 Score");
                        colum2.setCellValueFactory(new PropertyValueFactory<>("club1Goals"));

                        TableColumn<Match, String> colum3 = new TableColumn<>("Team 2");
                        colum3.setCellValueFactory(new PropertyValueFactory<>("club2"));

                        TableColumn<Match, String> colum4 = new TableColumn<>("Team 2 Score");
                        colum4.setCellValueFactory(new PropertyValueFactory<>("club2Goals"));

                        tableView1.getColumns().addAll(colum1,colum2,colum3,colum4);

                        for (Match m : matches) {
                            tableView1.getItems().add(new Match(m.getClub1(), m.getClub1Goals(), m.getClub2(),m.getClub2Goals()));
                        }

                        stgSearch.setScene(new Scene(tableView1, 400, 500));
                        stgSearch.setResizable(false);
                        stgSearch.showAndWait();
                    }
                }catch (Exception e){
                    Alert alertStringError = new Alert(Alert.AlertType.ERROR,"Some is wrong. Please, Enter correct input",ButtonType.OK);
                    txtSearch.clear();
                    alertStringError.show();
                }
            }
        });


        //...Exit btn.........
        Button btnExit = new Button("Exit");
        btnExit.setLayoutX(820);
        btnExit.setLayoutY(645);
        btnExit.setStyle("-fx-background-color:  #E53935; -fx-text-fill: aliceblue;-fx-font-size: 14px;-fx-pref-height: 30px; -fx-pref-width: 65px;-fx-border-color: #6D214F");
        btnExit.setOnAction(event -> {
            stgGUI.close();
        });

        paneGUI.getChildren().addAll(lblTitle, vbox, btnMatch, txtSearch, btnSearch,lblSort,sortGaolsBtn,sortWinsBtn, sortPointBtn, btnExit);

        stgGUI.setScene(new Scene(paneGUI, 1000, 700));
        stgGUI.setResizable(false);
        stgGUI.showAndWait();
    }

    static Scanner sc = new Scanner(System.in);

    /**
     *      ...Add Match ......
     *   fill add match taking user inputs
     */
    private static void addMatch() {
        ArrayList<FootballClub> list = premierLeagueManager.getListOfClub();
        FootballClub footballClub1 = null;
        FootballClub footballClub2 = null;
        boolean b1 = false;
        boolean b2 = false;

        System.out.print("Enter Club 1 : ");
        String club1 = sc.next();

        System.out.print("Enter Club 2 : ");
        String club2 = sc.next();

        System.out.print("Enter Club 1 Goal : ");
        String club1Goals = sc.next();

        System.out.print("Enter Club 2 Goal : ");
        String club2Goals = sc.next();

        System.out.print("Enter Date (yyyy/mm/dd) : ");
        String date = sc.next();

        for (FootballClub f : list) {
            if (club1.equals(f.getClubID())) {
                footballClub1 = f;
                b1 = true;
                break;
            }
        }
        for (FootballClub f : list) {
            if (club2.equals(f.getClubID())) {
                footballClub2 = f;
                b2 = true;
                break;
            }
        }
        if (b1 == true && b2 == true) {
            if (footballClub1.equals(footballClub2)) {
                System.out.println("Clubs are same! Try Again.");
            } else {
                if (Integer.valueOf(club1Goals) >= 0 && Integer.valueOf(club2Goals) >= 0) {
                    if (Integer.valueOf(club1Goals) == Integer.valueOf(club2Goals)) {
                        footballClub1.setDraws(footballClub1.getDraws() + 1);
                        footballClub1.setNumberOfGoalsScored(footballClub1.getNumberOfGoalsScored() + Integer.valueOf(club1Goals));
                        footballClub1.setNumberOfGoalsReceived(footballClub1.getNumberOfGoalsReceived()  + Integer.valueOf(club2Goals));
                        footballClub1.setPoints(footballClub1.getPoints()+1);

                        footballClub2.setDraws(footballClub2.getDraws() + 1);
                        footballClub2.setNumberOfGoalsScored(footballClub2.getNumberOfGoalsScored() + Integer.valueOf(club2Goals));
                        footballClub2.setNumberOfGoalsReceived(footballClub2.getNumberOfGoalsReceived() + Integer.valueOf(club1Goals));
                        footballClub2.setPoints(footballClub2.getPoints()+0);

                    } else if (Integer.valueOf(club1Goals) > Integer.valueOf(club2Goals)) {
                        footballClub1.setWins(footballClub1.getWins() + 1);
                        footballClub1.setNumberOfGoalsScored(footballClub1.getNumberOfGoalsScored() +  Integer.valueOf(club1Goals));
                        footballClub1.setNumberOfGoalsReceived(footballClub1.getNumberOfGoalsReceived() +  Integer.valueOf(club2Goals));
                        footballClub1.setPoints(footballClub1.getPoints()+3);

                        footballClub2.setDefeats(footballClub2.getDefeats() + 1);
                        footballClub2.setNumberOfGoalsScored(footballClub2.getNumberOfGoalsScored() +  Integer.valueOf(club2Goals));
                        footballClub2.setNumberOfGoalsReceived(footballClub2.getNumberOfGoalsReceived() +  Integer.valueOf(club1Goals));
                        footballClub2.setPoints(footballClub2.getPoints()+0);
                    } else {
                        footballClub1.setDefeats(footballClub1.getDefeats() + 1);
                        footballClub1.setNumberOfGoalsScored(footballClub1.getNumberOfGoalsScored() + Integer.valueOf(club1Goals));
                        footballClub1.setNumberOfGoalsReceived(footballClub1.getNumberOfGoalsReceived() +  Integer.valueOf(club2Goals));
                        footballClub1.setPoints(footballClub1.getPoints()+0);

                        footballClub2.setWins(footballClub1.getWins() + 1);
                        footballClub2.setNumberOfGoalsScored(footballClub2.getNumberOfGoalsScored() +  Integer.valueOf(club1Goals));
                        footballClub2.setNumberOfGoalsReceived(footballClub2.getNumberOfGoalsReceived() +Integer.valueOf(club2Goals));
                        footballClub2.setPoints(footballClub2.getPoints()+3);
                    }

                    footballClub1.setTotalMatches(footballClub1.getTotalMatches() + 1);
                    footballClub2.setTotalMatches(footballClub2.getTotalMatches() + 1);

                    Match match = new Match(footballClub1.getClubName(),footballClub2.getClubName(),club1Goals,club2Goals,date);
                    premierLeagueManager.addNewMatch(match);
                } else {
                    System.out.println("Score can not be minus value");
                }
            }
        } else {
            System.out.println("Club not Found! Try Again.");
        }
    }
}