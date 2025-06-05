import com.skhanra52.genericExample.BaseballPlayer;
import com.skhanra52.genericExample.FootballPlayer;
import com.skhanra52.genericExample.Player;
import com.skhanra52.genericExample.Team;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

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

        //--------------Comparable vs Comparator---------------------------------------------------------
        Integer five = 5;
        Integer [] others = {0,5,10, -15, 15};

        for(Integer i : others){
            int val = five.compareTo(i); // we are comparing five with array element
            System.out.printf("%d %s %d compareTo= %d%n", five,
                    (val == 0? "==" : (val < 0)? "<":">"), i, val);
        }

        String banana = "banana";
        String [] fruits = {"apple", "banana", "pear", "BANANA"};
        for(String s : fruits){
            int val = banana.compareTo(s);
            System.out.printf("%d %s %s compareTo= %d%n", five,
                    (val == 0? "==" : (val < 0)? "<":">"), s, val);
        }

        // sorting the fruits here and printing
        Arrays.sort(fruits);
        System.out.println(Arrays.toString(fruits));


        Student suman = new Student("Suman");
        Student [] students = {new Student("Geetha"), new Student("vihaan"),
                new Student("Vihaan")};

        // Below sort() will give the error class Student cannot be cast to class java.lang.Comparable
        // This is an example of not being able to use Arrays.sort() to compare any class or type we want.
        // To fix this we have extended Student class with interface Comparable.
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        // ********Example of comparator method compare()

        Student tim = new Student("Tim");
        Comparator StudentGPAScore = new StudentGPAComparator();
        Arrays.sort(students,StudentGPAScore);
        System.out.println(Arrays.toString(students));

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


// This class has been created to test the comparable interface and how its work.
// Refer in the main method. This is the raw way of using Comparable
//class Student implements Comparable{
//    private String name;
//
//    public Student(String name){
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return name;
//    }
//
//    @Override
//    public int compareTo(Object o) { // Here the argument is Object which has to be cast to
//        // Student if we want to compare with Student.
//        Student other = (Student) o;
//        return name.compareTo(other.name);
//    }
//}

// Here is the properly typed class
//Natural order means that your object's compareTo method will return a zero if one object is
//considered equal to another or the equals method returns true, when the compareTo method returns 0.
//If you had a list of Students who could be uniquely identified
//by name, then this could be true. It's probably more likely that you'd have
//a Student id, and use Comparable's compareTo method to sort by student id, for example.

class Student implements Comparable<Student>{

    private static int LAST_ID = 1000;
    private static Random random = new Random();

    protected int id ;
    protected String name;
    private double gpa;
    public Student(String name){
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }
    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }
}

// This class created to demonstrate Comparator interface

class StudentGPAComparator implements Comparator<Student> {

    // accepting two args and comparing them.
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.valueOf(o1.id).compareTo(Integer.valueOf(o2.id));
    }
}