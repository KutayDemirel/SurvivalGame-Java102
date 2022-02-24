package Monsters;

import java.util.Random;

public class Monster {
    private int ID;
    private String name;
    private int damage;
    private int health;
    private int loot;
    private int orgHealth;

    Monster(int ID, String name, int damage, int health, int loot) {
        this.ID = ID;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.loot = loot;
        this.orgHealth = health;
    }

    public int getOrgHealth() {
        return orgHealth;
    }

    public void setOrgHealth(int orgHealth) {
        this.orgHealth = orgHealth;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }
}
