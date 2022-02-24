package Locations;

import Monsters.Bear;
import Player.Player;

public class River extends BattleLoc {
    public River(Player player) {
        super("Cave", player, new Bear(), "Water",2);
    }
}