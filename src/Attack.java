public class Attack extends Card {
    public Attack(String name, double riskmultiplier) {
        super(name, riskmultiplier);
    }

     public void place(Player p) {
        p.exchange((int) (-p.getRisk() * riskmultiplier));
        if (p.getMoney() < 0) {
            p.out();
        }
        placed = true;
    }
}
