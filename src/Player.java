import java.util.ArrayList;

public class Player {
    String name;
    ArrayList<Card> cards;

    public void addCard(Card c) {
        cards.add(c);
    }

    public void setName(String newName) {
        name = newName;
    }

    public String toString() {
        return "player";
    }
}
