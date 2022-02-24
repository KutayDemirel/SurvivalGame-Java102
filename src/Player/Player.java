package Player;

import GameChars.*;
//import Weapons.Weapon;

import java.util.Scanner;

public class Player {
    private String userName;
    private String name;
    private int damage;
    private int health;
    private int orgHealth;
    private int money;
    private Inventory inv;
    public static Scanner input = new Scanner(System.in);

    public Player(String userName) {
        this.userName = userName;
        this.inv = new Inventory();
    }

    public void selectChar() {
        GameChar[] gameChars = new GameChar[]{new Samurai(), new Archer(), new Knight()};
        System.out.println("---------------");
        System.out.println("Characters");
        System.out.println("---------------");
        for (GameChar c : gameChars) {
            System.out.println(c.getID() + " - " + c.getName() +
                    "\tDamage :" + c.getDamage() + "\tHealth :" + c.getHealth() + "\tMoney :" + c.getMoney());
        }
        System.out.println("---------------");
        System.out.print("Please Select your Character  :");
        int selectedChar;
        do {
            selectedChar = input.nextInt();
            switch (selectedChar) {
                case 1:
                    initChar(gameChars[0]);
                    break;
                case 2:
                    initChar(gameChars[1]);
                    break;
                case 3:
                    initChar(gameChars[2]);
                    break;
                default:
                    System.out.print("You have entered invalid ID Number \nPlease choose again :");
                    break;
            }
        } while (selectedChar < 1 || selectedChar > gameChars.length);
    }

    private void initChar(GameChar gameChar) {
        this.setName(gameChar.getName());
        this.setHealth(gameChar.getHealth());
        this.setOrgHealth(gameChar.getHealth());
        this.setDamage(gameChar.getDamage());
        this.setMoney(gameChar.getMoney());
    }

    public void playerInfo() {
        System.out.println("------------------------------------");
        System.out.println("Your Character :" + this.getName() +
                ", Weapon :" + this.getInv().getWeapon().getName() +
                ", Armor :" + this.getInv().getArmor().getName() +
                ", Damage :" + this.getTotalDamage() +
                ", Block :" + this.getInv().getArmor().getBlock() +
                ", Health :" + this.getHealth() +
                ", Money :" + this.getMoney()
        );
    }

    public int getOrgHealth() {
        return orgHealth;
    }

    public void setOrgHealth(int orgHealth) {
        this.orgHealth = orgHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getTotalDamage() {
        return damage + this.getInv().getWeapon().getDamage() ;
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
        if(health < 0)
            health =0;
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }
}

