package Locations;

import Armors.Armor;
import Monsters.Monster;
import Player.Player;
import Weapons.Weapon;

import java.util.Random;

public abstract class BattleLoc extends Location {
    private Monster monster;
    private String award;
    private final int maxMonster;
    private final Random rand = new Random();
    private String selectMove;

    BattleLoc(String name, Player player, Monster monster, String award, int maxMonster) {
        super(name, player);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int monsterNumber = randomMonsterNumber();
        System.out.println("Be careful! You are in " + this.getName());
        System.out.println("You must fight with " + monsterNumber + " " + this.getMonster().getName());
        System.out.println("<F>ight or <R>un Away");
        selectMove = Player.input.next().toUpperCase();
        if (selectMove.equals("F")) {
            if (combat(monsterNumber)) {
                System.out.println("You have cleared the " + this.getName());
                if (this.getAward().equals("Food"))
                    this.getPlayer().getInv().setFood(true);
                if (this.getAward().equals("Fire Wood"))
                    this.getPlayer().getInv().setFireWood(true);
                if (this.getAward().equals("Water"))
                    this.getPlayer().getInv().setWater(true);
                System.out.println("You collected " + this.getAward());
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You are dead!");
            return false;
        }
        return true;
    }

    private boolean combat(int monsterNumber) {
        for (int i = 1; i <= monsterNumber; i++) {
            this.getMonster().setHealth(this.getMonster().getOrgHealth());
            combatInfo();
            monsterInfo(i);
            int firstAttacker = rand.nextInt(1, 101);
            if (firstAttacker <= 50) {
                System.out.println(this.getMonster().getName() + " rushed at you and you get first hit");
                monsterAttack();
                afterHit();
            }
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("<A>ttack or <R>un away");
                this.selectMove = Player.input.next().toUpperCase();
                if (selectMove.equals("A")) {
                    System.out.println("You've hit!");
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getMonster().getHealth() > 0) {
                        System.out.println(this.getMonster().getName() + " hit you");
                        monsterAttack();
                        afterHit();
                    }
                } else
                    return false;
            }
            if (this.getMonster().getHealth() <= 0) {
                System.out.println("You have killed the beast");
                if (this.getMonster().getName().equals("Snake")) {
                    getSnakeLoot();
                } else {
                    System.out.println("You have looted " + this.getMonster().getLoot() + " coin");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getLoot());
                }
            } else
                return false;
        }
        return true;
    }

    public void getSnakeLoot() {
        int randomLoot = rand.nextInt(1, 101);
        if (randomLoot <= 45) {
            System.out.println(this.getMonster().getName() + " doesn't have anything to loot");
        } else if (randomLoot <= 60) {
            randomLoot = rand.nextInt(1, 101);
            if (randomLoot <= 20) {
                this.getPlayer().getInv().setWeapon(Weapon.weapons()[2]);
            } else if (randomLoot <= 50) {
                this.getPlayer().getInv().setWeapon(Weapon.weapons()[1]);
            } else {
                this.getPlayer().getInv().setWeapon(Weapon.weapons()[0]);
            }
            System.out.println("You have found " + this.getPlayer().getInv().getWeapon().getName() +
                    " and equipped");
        } else if (randomLoot <= 75) {
            randomLoot = rand.nextInt(1, 101);
            if (randomLoot <= 20) {
                this.getPlayer().getInv().setArmor(Armor.armors()[2]);
            } else if (randomLoot <= 50) {
                this.getPlayer().getInv().setArmor(Armor.armors()[1]);
            } else {
                this.getPlayer().getInv().setArmor(Armor.armors()[0]);
            }
            System.out.println("You have found " + this.getPlayer().getInv().getArmor().getName() +
                     " and equipped");
        } else {
            randomLoot = rand.nextInt(1, 101);
            if (randomLoot <= 20) {
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                System.out.println("You have found 10 coins");
            } else if (randomLoot <= 50) {
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                System.out.println("You have found 5 coins");
            } else {
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                System.out.println("You have found 1 coin");
            }
        }
    }

    private void monsterAttack() {
        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInv().getArmor().getBlock();
        if (monsterDamage < 0)
            monsterDamage = 0;
        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
    }

    private void afterHit() {
        System.out.println("Your health :" + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + "'s health :" + this.getMonster().getHealth());
        System.out.println();
    }

    public void combatInfo() {
        System.out.println("Your stats :");
        System.out.println("------------------------------------");
        System.out.println("Health :" + this.getPlayer().getHealth());
        System.out.println("Weapon :" + this.getPlayer().getInv().getWeapon().getName());
        System.out.println("Damage :" + this.getPlayer().getTotalDamage());
        System.out.println("Armor :" + this.getPlayer().getInv().getArmor().getName());
        System.out.println("Block :" + this.getPlayer().getInv().getArmor().getBlock());
        System.out.println("Money :" + this.getPlayer().getMoney());
        System.out.println();
    }

    public void monsterInfo(int i) {
        System.out.println(i + ". " + this.getMonster().getName() + " stats :");
        System.out.println("--------------------------------------");
        System.out.println("Health :" + this.getMonster().getHealth());
        if (this.getMonster().getName().equals("Snake")) {
            System.out.println("Damage : 3 - 6");
        } else {
            System.out.println("Damage :" + this.getMonster().getDamage());
        }
        System.out.println("Coin :" + this.getMonster().getLoot());
        System.out.println();
    }

    public int randomMonsterNumber() {
        return rand.nextInt(0, this.maxMonster) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
