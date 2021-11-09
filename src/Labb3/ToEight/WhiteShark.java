package Labb3.ToEight;

import Labb3.Monster;

public class WhiteShark extends Monster {
    public WhiteShark() {
        super("WhiteShark", 110, 140, 40, 60, 50, 90);
    }

    @Override
    public void ShowMonster(int i) {
        super.ShowMonster(i);
        System.out.println("All these battles, got me sweating... Perfect, a lake to swim in!");
        System.out.println("Is that a fish? A duck? No.... It's a " + getName() + "!!!!");
    }
}
