import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    String name = "";
    ArrayList<Card> activecards = new ArrayList<Card>();
    ArrayList<Card> inhandcards = new ArrayList<Card>();
    int money = 0;
    boolean in = true;

    public void turn() {
        Scanner s = new Scanner(System.in);
        int input = 0;
        while (input != -1) {
            printstats();
            System.out.println("which card from your hand would you like to put down (enter a number), if you wish to put down no cards, enter 0: ");
            input = Integer.parseInt(s.nextLine()) - 1;
            //use the input to use card.place, and use switchtoactive as well
            os.clear();
        }
    }

    public void printstats() {
        System.out.println(name + ", here are your cards:");
        for (int i = 0; i < 2; i++) {
            inhandcards.add(Game.getRandomCard());
        }
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
        activecards.add(inhandcards.remove(index));
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