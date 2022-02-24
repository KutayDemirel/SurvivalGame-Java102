package Player;

import Armors.Armor;
import Weapons.Weapon;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean food;
    private boolean fireWood;
    private boolean water;


    public Inventory() {
        this.weapon = new Weapon(-1,"Fist",0,0);
        this.armor = new Armor(-1,"Rag",0,0);
        boolean food = false;
        boolean fireWood = false;
        boolean water = false;
    }

    public boolean isFireWood() {
        return fireWood;
    }

    public void setFireWood(boolean fireWood) {
        this.fireWood = fireWood;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public  void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
