package Monsters;

import java.util.Random;

public class Snake extends Monster {
    private Random rand = new Random();

    public Snake() {
        super(4, "Snake", 6, 12, 0);
    }

    @Override
    public int getDamage() {
        return rand.nextInt(3, 7);
    }

}
