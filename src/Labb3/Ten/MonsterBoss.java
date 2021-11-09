package Labb3.Ten;

import Labb3.Monster;


public class MonsterBoss extends Monster {
    public MonsterBoss() {
        super("MagicWitch", 250, 300, 100, 150, 100, 150);
    }


    @Override
    public void ShowMonster(int i) {
        super.ShowMonster(i);
        System.out.println("Please tell me that last moster was the last one....");
        System.out.println("Oh Finally... The " + getName() + "! Let's break the spell!");
    }


}
