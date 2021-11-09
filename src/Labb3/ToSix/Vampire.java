package Labb3.ToSix;

import Labb3.Monster;

public class Vampire extends Monster {
    public Vampire() {
        super("Vampire", 70, 90, 25, 35, 40, 60);
    }

    @Override
    public void ShowMonster(int i) {
        super.ShowMonster(i);
        System.out.println("Ouch, the last monster got me bleeding...");
        System.out.println("Maybe that man could help me! But what's up with his teeth... A  " + getName() + "!");
    }
}
