package Locations;

import Armors.*;
import Weapons.*;
import Player.*;

public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super("Tool Store", player);
    }

    public boolean onLocation() {
        System.out.println();
        System.out.println("Welcome to the Shop !");
        System.out.println("---------------------");
        boolean exit = false;
        while (!exit) {
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Exit");
            System.out.print("Your choice:");
            int selectedShop = Player.input.nextInt();
            while (selectedShop < 1 || selectedShop > 3) {
                System.out.print("Please enter valid number. Your choice :");
                selectedShop = Player.input.nextInt();
            }
            switch (selectedShop) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("See you later");
                    exit = true;
                    break;
            }
        }
        return true;
    }

    private void printWeapon() {
        for (Weapon w : Weapon.weapons())
            System.out.printf("%s - %-10s Damage : %d Price : %d\n", w.getID(),
                    w.getName(), w.getDamage(), w.getPrice());
        System.out.println("0 - Exit");
    }

    private void buyWeapon() {
        System.out.println("Which weapon would you like to buy ?");
        int selectWeaponId = Player.input.nextInt();
        while (selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
            System.out.println("Please enter valid number");
            selectWeaponId = Player.input.nextInt();
        }
        if (selectWeaponId != 0) {
            Weapon selectedWeapon = Weapon.getWeaponById(selectWeaponId);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money!");
                } else {
                    System.out.println(selectedWeapon.getName() + " has been purchased");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedWeapon.getPrice());
                    System.out.println("Your remaining money is :" + this.getPlayer().getMoney());
                    //this.getPlayer().setDamage(selectedWeapon.getDamage()+this.getPlayer().getDamage());
                    this.getPlayer().getInv().setWeapon(selectedWeapon);
                }
            }
        }
    }

    private void printArmor() {
        for (Armor a : Armor.armors())
            System.out.printf("%s - %-10s Block : %d Price : %d\n", a.getID(),
                    a.getName(), a.getBlock(), a.getPrice());
        System.out.println("0 - Exit");

    }

    private void buyArmor() {
        System.out.println("Which armor would you like to buy");
        int selectArmorId = Player.input.nextInt();
        while (selectArmorId < 0 || selectArmorId > Armor.armors().length) {
            System.out.println("Please enter valid number");
            selectArmorId = Player.input.nextInt();
        }
        if (selectArmorId != 0) {
            Armor selectedArmor = Armor.getArmorById(selectArmorId);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney())
                    System.out.println("You don't have enough money!");
                else {
                    System.out.println(selectedArmor.getName() + " Armor has been purchased");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    System.out.println("Your remaining money is : " + this.getPlayer().getMoney());
                    this.getPlayer().getInv().setArmor(selectedArmor);
                }

            }
        }
    }

}
