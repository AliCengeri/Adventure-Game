public class Inventory {
    private Weapons weapon;
    private Armors armor;
    private String[] awardInv = {"?", "?", "?", "-"};

    public Inventory() {
        this.weapon = new Weapons(-1, "Fist", 0, 0);
        this.armor = new Armors(-1, "None", 0, 0);
    }


    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Armors getArmor() {
        return armor;
    }

    public void setArmor(Armors armor) {
        this.armor = armor;
    }

    public String[] getAwardInv() {
        return awardInv.clone();
    }

    public void setAwardInv(int awardID, String award) {
        awardInv[awardID] = award;
    }

    public String setSecondAwardInv(String award) {
        return award;
    }
}
