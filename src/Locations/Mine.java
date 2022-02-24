package Locations;

import Monsters.Snake;
import Player.Player;

public class Mine extends BattleLoc{

    public Mine(Player player){
        super("Mine",player,new Snake(),"none",5);
    }
}
