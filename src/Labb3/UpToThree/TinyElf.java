package Labb3.UpToThree;

import Labb3.Monster;

public class TinyElf extends Monster {
    public TinyElf() {
        super("TinyElf", 30, 50, 25, 27, 15, 25);
    }

    @Override
    public void ShowMonster(int i) {
        super.ShowMonster(i);
        System.out.println("What's that? So tiny...");
        System.out.println("It's a angry " + getName() + "!");
    }
}
