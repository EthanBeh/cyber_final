import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    String name = "";
    ArrayList<Card> activecards = new ArrayList<Card>();
    ArrayList<Card> inhandcards = new ArrayList<Card>();
    int money = 0;
    boolean in = true;

    public void turn() {
        System.out.println();
        Scanner s = new Scanner(System.in);
        int input = 0;
        for (int i = 0; i < 2; i++) {
            inhandcards.add(Game.getRandomCard());
        }
        while (input != -1) {
            printstats();
            System.out.println("\nwhich card from your hand would you like to put down (enter a number), if you wish to put down no cards, enter 0: ");
            input = Integer.parseInt(s.nextLine()) - 1;
            if (input != -1) {
                if (inhandcards.get(input) instanceof Attack) {
                    int attackee = (int) (Math.random() * Game.getNumPlayers());
                    if (this != Game.getPlayers()[attackee]) {
                        inhandcards.get(input).place(Game.getPlayers()[attackee]);
                    } System.out.println("unable to place card");
                } else if (inhandcards.get(input) instanceof Card) {
                    inhandcards.get(input).place(this);
                }
                if (inhandcards.get(input).isPlaced()) {
                    switchToActive(input);
                }
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public void printstats() {
        System.out.println(name + ", here are your cards:");
        System.out.println("Active:");
        for (int i = 0; i < activecards.size(); i++) {
            if (!(activecards.get(i) instanceof Attack)) {
                System.out.println((i + 1) + ") " + activecards.get(i));
            }
        }
        System.out.println("In hand: ");
        for (int i = 0; i < inhandcards.size(); i++) {
            System.out.println((i + 1) + ") " + inhandcards.get(i));
        }
        System.out.println("you have " + money + "C");
        System.out.println("your current risk score is " + getRisk() + "C");
    }

    public void switchToActive(int index) {
        if (!(inhandcards.get(index) instanceof Attack)) {
            activecards.add(inhandcards.remove(index));
        } else {
            inhandcards.remove(index);
        }
    }

    public boolean isIn() {
        return in;
    }

    public int getRisk() {
        int totRisk = 0;
        for (int i = 0; i < activecards.size(); i++) {
            totRisk += activecards.get(i).getRisk();
        } return totRisk;
    }

    public int getMoney() {
        return money;
    }

    public void out() {
        in = false;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String toString() {
        return "player";
    }

    public boolean exchange(int amt) {
        if (money + amt < 0) {
            return false;
        }
        money += amt;
        return true;
    }
}