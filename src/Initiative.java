public class Initiative extends Card {
    public Initiative(String name, int risk, int cost, int revenue) {
        super(name, risk, cost, revenue);
    }

    @Override
    public void place(Player p) {
        if (p.exchange(-cost)) {
            p.exchange(revenue);
            System.out.println("earned " + (revenue - cost) + "C from placing " + name);
            placed = true;
        } else {
            System.out.println("not enough money to place " + name);
            placed = false;
        }
    }

    public void turn(Player p) { }

    public String toString() {
        return name + ", cost = " + cost + "C, one time revenue = " + revenue + "C, risk = " + risk + "C";
    }
}
