public class Weapons {
    private int id;
    private String name;
    private int damage;
    private int price;

    public Weapons(int id, String name, int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public static Weapons[] weapons() {
        Weapons[] weaponList = new Weapons[3];
        weaponList[0] = new Weapons(1, "Handgun", 2, 5);
        weaponList[1] = new Weapons(2, "Sword", 3, 35);
        weaponList[2] = new Weapons(3, "Shotgun", 7, 45);
        return weaponList;
    }

    public static Weapons getWeaponByID(int id) {
        for (Weapons w : Weapons.weapons()) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
