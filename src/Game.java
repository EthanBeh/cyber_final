import java.util.Scanner;

public class Game {
    Scanner s;
    Player[] players;
    int numPlayers;
    Card[] cards = new Card[25];

    public Game() {
        s = new Scanner(System.in);
    }

    public boolean initializePlayers() {
        System.out.print("how many players: ");
        numPlayers = s.nextInt();
        s.nextLine();
        if (numPlayers == 0) {
            return false;
        }
        while (numPlayers < 2) {
            System.out.print("please input a valid amount of players (2+): ");
            numPlayers = s.nextInt();
            s.nextLine();
            if (numPlayers == 0) {
                return false;
            }
        }
        players = new Player[numPlayers];
        return true;
    }

    public void setNames() {
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player();
            System.out.println("player " + (i + 1)+ " enter your name: ");
            players[i].setName(s.nextLine());
        }
    }

    public void makeCards() {
        //String name, int risk, int cost, int revenue
        //Assets
        Card citProp = new Asset("city property", 5, 15, 6);
        Card subProp = new Asset("suburban property", 3, 10, 4);
        Card prodSto = new Asset("product storage", 2, 8, 3);
        Card machine = new Asset("machinery", 3, 3, 2);
        Card equip = new Asset("equipment", 1, 2, 1);
        //Relationships
        Card CEO = new Asset("CEO", 5, 0, 5);
        Card partner = new Asset("partner", 3, 0, 4);
        Card fEmploy = new Asset("full-time employee", 2, 0, 3);
        Card pEmploy = new Asset("part-time employee", 1, 0, 1);
        Card rEmploy = new Asset("remote employee", 1, 0, 2);
        //Initiatives
        Card collab = new Asset("collboration", 2, 3, 6);
        Card market = new Asset("new market", 4, 5, 8);
        Card advert = new Asset("advertisement", 2, 2, 4);
        Card launch = new Asset("product launch", 3, 4, 6);
        Card reboot = new Asset("product reboot", 1, 1, 3);

        cards = [citProp, subProp, prodSto, machine, equip, CEO, partner, fEmploy, pEmploy, rEmploy, collab, market, advert, launch, reboot];
    }

    public void runRound() {

    }

    public void runTurn(Player p) {
        for (int i = 0; i < p.getCards().size(); i++) {
            System.out.println(p.getCards().get(i));
        }
    }
}
