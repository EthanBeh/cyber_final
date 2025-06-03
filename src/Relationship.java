public class Relationship extends Card {
    public Relationship(String name, int risk, int cost, int revenue) {
        super(name, risk, cost, revenue);
    }

    @Override
    public void place(Player p) {
        placed = true;
    }

    public void turn(Player p) {
        p.exchange(revenue);
    }

    public String toString() {
        return name + ", type = relationship, revenue per turn = " + revenue + "C, placed = " + placed;
    }
}
