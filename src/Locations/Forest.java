package Locations;

import Monsters.Vampire;
import Player.Player;

public class Forest extends BattleLoc{
    public Forest(Player player) {
        super("Forest", player, new Vampire(), "Fire Wood",3);

    }
}
