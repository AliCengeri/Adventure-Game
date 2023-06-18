import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Adventure Game!");
        System.out.print("Please insert a name: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Welcome! " + player.getName());
        System.out.println("Please select a character");
        player.selectChar();
        Location location = null;

        while (true) {
            player.playerInfo();
            System.out.println("\n----------LOCATIONS----------");
            System.out.println("\n0" + "\t" + "Exit game");
            Location[] locList = {new SafeHouse(player), new ToolStore(player), new Cave(player), new Forest(player), new River(player), new Mine(player)};
            for (Location loc : locList) {
                System.out.println(loc.getId() +
                        "\tName: " + loc.getName());
            }
            System.out.print("Select the location you want to go to: ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (location == null) {
                System.out.println("Exiting the game...");
                break;
            }
            if (!location.onLocation()) {
                break;
            }
        }
    }
}
