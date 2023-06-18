import java.util.Arrays;
import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;
    private int originalHealth;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    private Scanner input = new Scanner(System.in);

    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("------------------------------");
        for (GameChar gameChar : charList) {
            System.out.println("ID: " + gameChar.getId() +
                    "\t\t Character: " + gameChar.getName() +
                    "\t\t Damage: " + gameChar.getDamage() +
                    "\t\t Health: " + gameChar.getHealth() +
                    "\t\t Money: " + gameChar.getMoney());
        }
        System.out.println("------------------------------");
        System.out.print("Insert character ID: ");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
        }
    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
        this.setOriginalHealth(gameChar.getHealth());
    }

    public void playerInfo() {
        System.out.println("\n------------------------------");
        System.out.println("\nYour Weapon: " + this.getInventory().getWeapon().getName() +
                "\t\t Armor: " + this.getInventory().getArmor().getName() +
                "\t\t Block: " + this.getInventory().getArmor().getBlock() +
                "\t\t Damage: " + this.getDamage() +
                "\t\t Health: " + this.getHealth() +
                "\t\t Money: " + this.getMoney() +
                "\t\t Awards: " + Arrays.toString(getInventory().getAwardInv()));
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        if (health < 0) {
            return 0;
        }
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
}
