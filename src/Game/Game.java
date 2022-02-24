package Game;

import Locations.*;
import Player.*;

public class Game {

    public void start() {
        Player player = new Player("Selda");
        System.out.println(player.getUserName() + " Welcome to the Game!");
        player.selectChar();
        Location loc = null;
        boolean isWin= false;
        while (!isWin) {
            player.playerInfo();
            System.out.println("-----------------------");
            System.out.println("Please choose a place to go");
            System.out.println("------- Places -------");
            System.out.println("1 - Safe House - Your health will be recovered");
            System.out.println("2 - Tool Store - A place for buying valuable items");
            System.out.println("3 - Cave - Award <Food> Careful Zombies are lurking around");
            System.out.println("4 - Forest - Award <Fire Wood> Careful Vampires are lurking around");
            System.out.println("5 - River - Award <Water> Careful Bears are lurking around");
            System.out.println("6 - Mine - Award <Random Loot> Careful Snakes are lurking around");
            System.out.println("0 - Exit Game -");
            int nextPlace = Player.input.nextInt();
            switch (nextPlace) {
                case 0:
                    break;
                case 1:
                    loc = new SafeHouse(player);
                    break;
                case 2:
                    loc = new ToolStore(player);
                    break;
                case 3:
                    if(player.getInv().isFood()){
                        System.out.println("You have already cleared the Cave");
                        loc= null;
                        break;
                    }
                    loc = new Cave(player);
                    break;
                case 4:
                    if(player.getInv().isFireWood()){
                        System.out.println("You have already cleared the Forest");
                        loc= null;
                        break;
                    }
                    loc = new Forest(player);
                    break;
                case 5:
                    if(player.getInv().isWater()){
                        System.out.println("You have already cleared the River");
                        loc= null;
                        break;
                    }
                    loc = new River(player);
                    break;
                case 6:
                    loc = new Mine(player);
                    break;
                default:
                    loc = null;
                    System.out.println("Please enter valid number");
                    break;
            }
            if (nextPlace == 0) {
                System.out.println("You have left too early");
                break;
            }
            if (loc != null) {
                if (!loc.onLocation()) {
                    System.out.println("Game over!");
                    break;
                }
            }
            if(player.getInv().isFood() && player.getInv().isFireWood() &&
                    player.getInv().isWater() && nextPlace == 1){
                System.out.println("Congratulations !! You have won !!");
                isWin =true;
            }
        }
    }
}
