import java.util.ArrayList;

public class Player {
    String name = "";
    ArrayList<Card> cards = new ArrayList<Card>();
    int money = 0;
    boolean in = true;

    public void addCard(Card c) {
        cards.add(c);
    }

    public ArrayList<Card> getCards() { return cards; }

    public int getRisk() {
        int totRisk = 0;
        for (int i = 0; i < cards.size(); i++) {
            totRisk += cards.get(i).getRisk();
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
