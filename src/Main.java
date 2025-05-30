//hello Ethan Be Hairy, I hope you are doing well when you see this message(if you do). As you did to me, I would also remind you to logout. - Eric
//(I literally don't remember using public windows so I don't know how I didn't log out)
//I would love to add some Java, but I have work to do

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("hello");
        System.out.println("how many players: ");
        int numPlayers = s.nextInt();
        s.nextLine();
        Player[] players = new Player[numPlayers];
        System.out.println(players);
    }
}
