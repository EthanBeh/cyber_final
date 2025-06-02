public class Card {
    String name;
    int risk;
    int cost;
    int revenue;
    float riskmultiplier;
    boolean placed = false;

    public Card(String name, int risk, int cost, int revenue) {
        this.name = name;
        this.risk = risk;
        this.cost = cost;
        this.revenue = revenue;
    }

    public Card(float riskmultiplier) {
        this.riskmultiplier = riskmultiplier;
    }

    public int getRisk() {
        return risk;
    }

    public void place(Player p) { }

    public void turn(Player p) { }
}
