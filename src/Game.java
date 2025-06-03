import java.util.Scanner;

public class Game {
    Scanner s;
    Player[] players;
    int numPlayers;
    Card[] cards;

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
        Card CEO = new Relationship("CEO", 5, 0, 5);
        Card partner = new Relationship("partner", 3, 0, 4);
        Card fEmploy = new Relationship("full-time employee", 2, 0, 3);
        Card pEmploy = new Relationship("part-time employee", 1, 0, 1);
        Card rEmploy = new Relationship("remote employee", 1, 0, 2);
        //Initiatives
        Card collab = new Initiative("collboration", 2, 3, 6);
        Card market = new Initiative("new market", 4, 5, 8);
        Card advert = new Initiative("advertisement", 2, 2, 4);
        Card launch = new Initiative("product launch", 3, 4, 6);
        Card reboot = new Initiative("product reboot", 1, 1, 3);
        //Attacks
        Card ransom = new Attack("ransomware", 2);
        Card breakIn = new Attack("break-in", 2.25);
        Card decrypt = new Attack("cracked encryption", 3.5);
        Card expose  = new Attack("exposé", 1);
        Card phishing = new Attack("phishing", 1.25);
        Card ddos = new Attack("distributed denial of service", 0.75);
        Card sniffing = new Attack("packet sniffing", 1);
        Card usbbait = new Attack("usb baiting", 1.5);
        Card hacking = new Attack("hacking", 3);


        cards = new Card[] {
            citProp, subProp, prodSto, machine, equip,
            CEO, partner, fEmploy, pEmploy, rEmploy,
            collab, market, advert, launch, reboot,
            ransom, breakIn, decrypt, expose, phishing, ddos, sniffing, usbbait, hacking
        };
    }

    public void runRound() {

    }

    public void runTurn(Player p) {
        for (int i = 0; i < p.getCards().size(); i++) {
            System.out.println(p.getCards().get(i));
        }
    }
}