package Labb3.UpToThree;

import Labb3.Monster;

public class Troll extends Monster {
    public Troll() {
        super("Troll", 50, 70, 25, 30, 20, 32);
    }

    @Override
    public void ShowMonster(int i) {
        super.ShowMonster(i);
        System.out.println("A house! Maybe they could offer me some food!");
        System.out.println("Oh uh....The house is the home of a " + getName() + "!");
    }
}
