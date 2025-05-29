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
