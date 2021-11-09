package Labb3.UpToThree;

import Labb3.Monster;

public class Zombie extends Monster {

    public Zombie() {
        super("Zombie", 40, 60, 25, 28, 18, 28);
    }

    @Override
    public void ShowMonster(int i) {
        super.ShowMonster(i);
        System.out.println("Is that a dead man? ");
        System.out.println("Uh no! It's a " + getName() + "!");
    }
}
