package Labb3.ToEight;
import Labb3.Monster;

public class Dragon extends Monster {
    public Dragon() {
        super("Dragon", 140, 180, 50, 80, 60, 105);
    }

    @Override
    public void ShowMonster(int i) {
        super.ShowMonster(i);
        System.out.println("What's that, covering the sun....");
        System.out.println("Is it a big bird? No... it's a fire-spitting " + getName() + "!");
    }
}
