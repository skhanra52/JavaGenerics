import com.skhanra52.genericExample.BaseballPlayer;
import com.skhanra52.genericExample.FootballPlayer;
import com.skhanra52.genericExample.Player;
import com.skhanra52.genericExample.Team;

public class Main {
    public static void main(String[] args) {
//        BaseballTeam phillies = new BaseballTeam("Philadelphia Phillis");
//        BaseballTeam astor = new BaseballTeam("Houston Astor");
//        scoreResult(phillies,3,astor,5);
//
//        var harper = new BaseballPlayer("B Harper", "Right Fielder");
//        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
//        phillies.addTeamMember(harper);
//        phillies.addTeamMember(marsh);
//        phillies.listTeamMembers();

        //----------Generic Class Team<T> has been used here-----------------------
        // Here Team will accept specific type of player. Once team created with BaseballPlayer type
        // so it will accept only BaseballPlayers
        Team <BaseballPlayer> phillies1 = new Team<>("Philadelphia Phillis one");
        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies1.addTeamMember(harper);
        Team <BaseballPlayer> astor1 = new Team<>("Houston Astor one");
        scoreResult(phillies1,3,astor1,5);


        Team <FootballPlayer> phillies2 = new Team<>("Philadelphia Phillis one");
        Team <FootballPlayer> astor2 = new Team<>("Houston Astor one");
        var christian = new FootballPlayer("B Harper", 3);
        var acrobat = new FootballPlayer("B Marsh", 12);
        phillies2.addTeamMember(christian);
        phillies2.addTeamMember(acrobat);
        scoreResult(phillies2,3,astor2,5);
    }

//    public static void scoreResult(BaseballTeam team1, int t1_score,
//                                   BaseballTeam team2, int t2_score){
//        String message = team1.setScore(t1_score,t2_score);
//        team2.setScore(t2_score,t1_score);
//        System.out.printf("%s %s %s %n", team1, message, team2);
//    }
//
//    public static void scoreResult(SportsTeam team1, int t1_score,
//                                   SportsTeam team2, int t2_score){
//        String message = team1.setScore(t1_score,t2_score);
//        team2.setScore(t2_score,t1_score);
//        System.out.printf("%s %s %s %n", team1, message, team2);
//    }
//
    public static <T extends Player> void scoreResult(Team<T> team1, int t1_score,
                                                      Team<T> team2, int t2_score){
        String message = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

//    public static <Player> void scoreResult(Team<BaseballPlayer> team1, int t1_score,
//                                       Team<BaseballPlayer> team2, int t2_score){
//        String message = team1.setScore(t1_score,t2_score);
//        team2.setScore(t2_score,t1_score);
//        System.out.printf("%s %s %s %n", team1, message, team2);
//    }
//
//
//
//    public static <T> void scoreResult(Team<FootballPlayer> team1, int t1_score,
//                                   Team<FootballPlayer> team2, int t2_score){
//        String message = team1.setScore(t1_score,t2_score);
//        team2.setScore(t2_score,t1_score);
//        System.out.printf("%s %s %s %n", team1, message, team2);
//    }
}

//record BaseballPlayer(String name, String position){}