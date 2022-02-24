package Locations;

import Monsters.Zombie;
import Player.*;

public class Cave extends BattleLoc{

    public Cave(Player player){
        super("Cave",player,new Zombie(),"Food",3);
    }
}
