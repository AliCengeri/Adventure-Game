import java.util.Objects;

public class SafeHouse extends Location {

    public SafeHouse(Player player) {
        super(1, player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        String[] secondAwardInv = getPlayer().getInventory().getAwardInv();
        int counter = 0;
        for (int i = 0; i < secondAwardInv.length; i++) {
            if (secondAwardInv[i] != "?" && secondAwardInv[i] != "-") {
                counter++;
            }
            if (counter == 3) {
                System.out.println("YOU WON THE GAME!!!");
                return false;
            }
        }
        System.out.println("\nYou are in the safe house!");
        System.out.println("Your health is renewed!");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }
}
