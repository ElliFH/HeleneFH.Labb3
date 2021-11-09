package Labb3.ToSix;

import Labb3.Monster;
import Labb3.Player;

public class BigFoot extends Monster {

    public BigFoot() {
        super("BigFoot", 90,110,25,40,50,70);
    }

    @Override
    public void ShowMonster(int i) {
        super.ShowMonster(i);
        System.out.println("Woooow I think it's an earthquake going on!!!");
        System.out.println("Wait.... No, it's " + getName() + "!");
    }
}
