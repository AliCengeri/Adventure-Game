import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class BattleLoc extends Location {
    private Enemy enemy;
    private String award;
    private int maxEnemy;
    private int awardID;


    public BattleLoc(int id, Player player, String name, Enemy enemy, String award, int awardID, int maxEnemy) {
        super(id, player, name);
        this.enemy = enemy;
        this.award = award;
        this.maxEnemy = maxEnemy;
        this.awardID = awardID;
    }

    @Override
    public boolean onLocation() {
        String[] secondAwardInv = getPlayer().getInventory().getAwardInv();
        secondAwardInv[3] = "-";
        if (!Objects.equals(secondAwardInv[this.awardID], this.award)) {
            int enemyNumber = this.randomEnemyNumber();
            System.out.println("\nYou are here now: " + this.getName());
            System.out.println("Be carefoul! " + enemyNumber + " " + this.getEnemy().getName() + " lives here!");
            System.out.println("(F)ight or (R)un");
            Scanner input2 = new Scanner(System.in);
            String selectCase = input2.nextLine().toUpperCase();
            if (selectCase.equals("F") && combat(enemyNumber)) {
                if (Objects.equals(this.getEnemy().getName(), "Snake")) {
                    Random random = new Random();
                    int randomItem = random.nextInt(1000) + 1;
                    if (randomItem <= 30) {
                        Weapons selectedWeapon = Weapons.getWeaponByID(3);
                        this.getPlayer().getInventory().setWeapon(selectedWeapon);
                        System.out.println("Your earned: " + this.getPlayer().getInventory().getWeapon().getName());

                    }
                    if (randomItem > 30 && randomItem <= 75) {
                        Weapons selectedWeapon = Weapons.getWeaponByID(2);
                        this.getPlayer().getInventory().setWeapon(selectedWeapon);
                        System.out.println("Your earned: " + this.getPlayer().getInventory().getWeapon().getName());

                    }
                    if (randomItem > 75 && randomItem <= 150) {
                        Weapons selectedWeapon = Weapons.getWeaponByID(1);
                        this.getPlayer().getInventory().setWeapon(selectedWeapon);
                        System.out.println("Your earned: " + this.getPlayer().getInventory().getWeapon().getName());

                    }
                    if (randomItem > 150 && randomItem <= 180) {
                        Armors selectedArmor = Armors.getArmorByID(3);
                        this.getPlayer().getInventory().setArmor(selectedArmor);
                        System.out.println("Your earned: " + this.getPlayer().getInventory().getArmor().getName());

                    }
                    if (randomItem > 180 && randomItem <= 225) {
                        Armors selectedArmor = Armors.getArmorByID(2);
                        this.getPlayer().getInventory().setArmor(selectedArmor);
                        System.out.println("Your earned: " + this.getPlayer().getInventory().getArmor().getName());

                    }
                    if (randomItem > 225 && randomItem <= 300) {
                        Armors selectedArmor = Armors.getArmorByID(1);
                        this.getPlayer().getInventory().setArmor(selectedArmor);
                        System.out.println("Your earned: " + this.getPlayer().getInventory().getArmor().getName());

                    }
                    if (randomItem > 300 && randomItem <= 330) {
                        this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                        System.out.println("You earned 10 money!");
                    }
                    if (randomItem > 330 && randomItem <= 375) {
                        this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                        System.out.println("You earned 5 money!");
                    }
                    if (randomItem > 375 && randomItem <= 450) {
                        this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                        System.out.println("You earned 1 money!");
                    }
                    if (randomItem > 450) {
                        System.out.println("You earned nothing!");
                    }
                }
                System.out.println("\n" + this.getPlayer().getName() + " defeated all the enemies");
                getPlayer().getInventory().setAwardInv(this.awardID, this.award);
                getPlayer().getInventory().setAwardInv(3, "-");
                return true;
            }
            if (this.getPlayer().getHealth() == 0) {
                System.out.println("\nYou died!");
                System.out.println("GAME OVER!");
                return false;
            }
        } else {
            System.out.println("\nYou already cleaned this area!");
            return true;
        }
        return true;
    }

    public boolean combat(int enemyNumber) {
        for (int i = 0; i < enemyNumber; i++) {
            Random random = new Random();
            int hitChances = random.nextInt(100) + 1;
            this.getEnemy().setHealth(this.getEnemy().getOriginalHealth());
            if (Objects.equals(this.getEnemy().getName(), "Snake")) {
                Random random2 = new Random();
                this.getEnemy().setDamage(random2.nextInt(4) + 3);
            }
            playerStats();
            enemyStats(i + 1);
            if (hitChances <= 50) {
                int enemyDamage = this.getEnemy().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                if (enemyDamage < 0) {
                    enemyDamage = 0;
                }
                this.getPlayer().setHealth(this.getPlayer().getHealth() - enemyDamage);
                System.out.println("\n" + this.getEnemy().getName() + " hit " + enemyDamage + " damage!");
                afterHit();
            }
            while (this.getPlayer().getHealth() > 0 && this.getEnemy().getHealth() > 0) {
                System.out.println("\n(H)it or (R)un");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("H")) {
                    System.out.println("You hit " + this.getPlayer().getDamage() + " damage!");
                    enemy.setHealth(this.enemy.getHealth() - this.getPlayer().getDamage());
                    if (this.getEnemy().getHealth() > 0) {
                        int enemyDamage = this.getEnemy().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (enemyDamage < 0) {
                            enemyDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - enemyDamage);
                        System.out.println(this.getEnemy().getName() + " hit " + enemyDamage + " damage!");
                        afterHit();
                    }
                } else {
                    return false;
                }
            }
            if (this.getEnemy().getHealth() < 0) {
                System.out.println("\nYou defeated " + (i + 1) + "." + this.getEnemy().getName());
                System.out.println("You earned " + this.getEnemy().getMoney() + " money!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getEnemy().getMoney());
            } else {
                return false;
            }
        }
        return true;
    }

    public void playerStats() {
        System.out.println("\n----------Players Stats----------");
        System.out.println();
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Damage: " + this.getPlayer().getDamage());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block: " + this.getPlayer().getInventory().getArmor().getBlock());
    }

    public void enemyStats(int i) {
        System.out.println("----------" + i + "." + this.enemy.getName() + " Stats----------");
        System.out.println();
        System.out.println("Health: " + this.enemy.getHealth());
        System.out.println("Damage: " + this.enemy.getDamage());
        System.out.println("Money: " + this.enemy.getMoney());
    }

    public void afterHit() {
        System.out.println("\nYour health: " + this.getPlayer().getHealth());
        System.out.println(this.getEnemy().getName() + "'s Health: " + this.getEnemy().getHealth());
        System.out.println();
    }

    public int randomEnemyNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxEnemy()) + 1;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxEnemy() {
        return maxEnemy;
    }

    public void setMaxEnemy(int maxEnemy) {
        this.maxEnemy = maxEnemy;
    }

    public int getAwardID() {
        return awardID;
    }

    public void setAwardID(int awardID) {
        this.awardID = awardID;
    }
}
