package Locations;

import Player.Player;

public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super("Safe House", player);
    }

    @Override
    public boolean onLocation() {
        System.out.println();
        System.out.println("You are in Safe House , your health is recovered");
        System.out.println();
        this.getPlayer().setHealth(this.getPlayer().getOrgHealth());
        return true;
    }

}
