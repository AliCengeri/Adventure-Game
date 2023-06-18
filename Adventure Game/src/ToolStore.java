public class ToolStore extends Location {
    public ToolStore(Player player) {
        super(2, player, "Store");
    }

    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("Welcome to store!");
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Exit");
            System.out.print("Select: ");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Unvalid value, try again: ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("We look forward to seeing you again!");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapons() {
        System.out.println();
        System.out.println("-----Weapons-----");
        System.out.println();
        for (Weapons w : Weapons.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() +
                    "\t\t Damage: " + w.getDamage() +
                    "\t\t Price: " + w.getPrice());
        }
        System.out.println("0 - Exit");
    }

    public void buyWeapon() {
        System.out.print("Select a weapon: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapons.weapons().length) {
            System.out.print("Unvalid value, try again: ");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapons selectedWeapon = Weapons.getWeaponByID(selectWeaponID);
            if (Weapons.getWeaponByID(selectWeaponID) != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Not enough cash, strager!");
                } else if (selectedWeapon.getId() == this.getPlayer().getInventory().getWeapon().getId()) {
                    System.out.println("You already bought this weapon, please choose another one.");
                } else {
                    System.out.println("You bought the " + selectedWeapon.getName());
                    int newMoney = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(newMoney);
                    System.out.println("Your remaining money: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Your new weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    public void printArmors() {
        System.out.println();
        System.out.println("-----Armors-----");
        System.out.println();
        for (Armors a : Armors.armors()) {
            System.out.println(a.getId() + " - " + a.getName() +
                    "\t\t Block: " + a.getBlock() +
                    "\t\t Price: " + a.getPrice());
        }
        System.out.println("0 - Exit");
    }

    public void buyArmor() {
        System.out.print("Select a armor: ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armors.armors().length) {
            System.out.print("Unvalid value, try again: ");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0) {
            Armors selectedArmor = Armors.getArmorByID(selectArmorID);
            if (Armors.getArmorByID(selectArmorID) != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Not enough cash, strager!");
                } else if (selectedArmor.getId() == this.getPlayer().getInventory().getArmor().getId()) {
                    System.out.println("You already bought this armor, please choose another one.");
                } else {
                    System.out.println("You bought the " + selectedArmor.getName());
                    int newMoney = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(newMoney);
                    System.out.println("Your remaining money: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Your new armor: " + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }
    }
}
