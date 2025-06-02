public class Asset extends Card{
    public Asset(String name, int risk, int cost, int revenue) {
        super(name, risk, cost, revenue);
    }

    public void place(Player p) {
        if (p.exchange(-cost)) {
            System.out.println("paid " + cost + "C to place " + name);
            placed = true;
        } else {
            System.out.println("couldn't place " + name);
            placed = false;
        }
    }

    public void turn(Player p) {
        p.exchange(revenue);
        System.out.println("earned " + revenue + "C from " + name);
    }

    public String toString() {
        return name + ", cost = " + cost + "C, revenue per turn = " + revenue + "C";
    }
}
