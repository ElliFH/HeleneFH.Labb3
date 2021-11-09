package Labb3.Nine;

import Labb3.Monster;

public class BurningMan extends Monster {
    public BurningMan() {
        super("BurningMan", 160, 200, 60, 90, 70, 130);
    }

    @Override
    public void ShowMonster(int i) {
        super.ShowMonster(i);
        System.out.println("It's getting colder... Is that a fire over there? Let's get warm!");
        System.out.println("Ehh... The fire is moving!? AAHHH IT'S " + getName() + "!");
    }

}
