package Labb3.ToSix;

import Labb3.Monster;

public class GiantRat extends Monster {
    public GiantRat() {
        super("GiantRat", 60,80, 25, 30, 30, 46);
    }

    @Override
    public void ShowMonster(int i) {
        super.ShowMonster(i);
        System.out.println("Wow, is that a bear? Cool!");
        System.out.println("Wait....Is that a Rat??? It's a " + getName() + "!");
    }
}
