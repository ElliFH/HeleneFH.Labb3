package Labb3;

import Labb3.Ten.MonsterBoss;
import Labb3.Nine.BurningMan;
import Labb3.ToEight.Dragon;
import Labb3.ToEight.WhiteShark;
import Labb3.ToSix.BigFoot;
import Labb3.ToSix.GiantRat;
import Labb3.ToSix.Vampire;
import Labb3.UpToThree.TinyElf;
import Labb3.UpToThree.Troll;
import Labb3.UpToThree.Zombie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Methods {

    // "Enter to continue" metod
    public static void enter() {
        {
            System.out.println("[Press Enter...]");
            try {
                System.in.read();
            } catch (Exception e) {
            }
        }
    }

    static Random r = new Random();

    // Randommetod för att kunna ta fram min/max värde på hp, xp, damage, monsters osv...
    public int randomRange(int min, int max) {
        int random = r.nextInt(max + 1 - min) + min;
        return random;
    }

    // Det finns 10% chans att denna kod körs istället för "The Battle"
    public static void RandomMethod() {
        Random r = new Random();
        if (r.nextDouble() < 0.1) {
            System.out.println("You look around and see nothing but the forest... ");
            System.out.println("You take a moment to breath... ");
            System.out.println("");
            enter();
        }
    }

    static ArrayList<Monster> monsters = new ArrayList<>();
    static Random rd = new Random();

    // ArrayList som returnerar en lista av monster
    static public ArrayList<Monster> initialize() {

        ArrayList<Monster> returnMonsters = new ArrayList<>();

        Monster level1 = new TinyElf();
        Monster level2 = new Zombie();
        Monster level3 = new Troll();
        returnMonsters.add(level1);
        returnMonsters.add(level2);
        returnMonsters.add(level3);

        Monster level4 = new GiantRat();
        Monster level5 = new Vampire();
        Monster level6 = new BigFoot();
        returnMonsters.add(level4);
        returnMonsters.add(level5);
        returnMonsters.add(level6);

        Monster level7 = new Dragon();
        Monster level8 = new WhiteShark();
        returnMonsters.add(level7);
        returnMonsters.add(level8);

        Monster level9 = new BurningMan();
        returnMonsters.add(level9);

        Monster level10 = new MonsterBoss();
        returnMonsters.add(level10);

        return returnMonsters;
    }

    // Iniitierar player och menyval
    public void init() {

        String name;
        Scanner sc = new Scanner(System.in);
        Player player = new Player();
        name = sc.nextLine();
        player.setName(name);

        int choice;

        do {

            player.setCurrentHP(player.getMaxHP());

            System.out.println("");
            System.out.println("1. Go adventuring");
            System.out.println("2. Show level details about your character");
            System.out.println("3. Exit game");
            System.out.print(">");
            choice = sc.nextInt();
            System.out.println("");


            switch (choice) {

                case 1:

                    //Startar battle
                    StartBattle(player);

                case 2:
                    // metod för att skriva ut spelarens detaljer
                    System.out.println(player.toString());
                    break;

                case 3:
                    System.out.println("Bye!");
                    break;

                default:
                    // Ifall fel input
                    System.out.println("Choose from the menu!");
            }

        }
        while (choice != 3);
    }

    public static void StartBattle(Player player) {

        player.CheckLevelUp(); // Kollar vilken level som ska köras
        monsters = initialize();
        int randomizeMonster = 0;

        if (player.getLevel() <= 3) {
            randomizeMonster = rd.nextInt(3);
            battle((monsters.get(randomizeMonster)), player);  //Anropar Battle metoden mellan spelare och ett randommonster inom rätt index

        } else if (player.getLevel() == 4 || player.getLevel() == 5 || player.getLevel() == 6) {
            randomizeMonster = rd.nextInt(3) + 3;
            battle((monsters.get(randomizeMonster)), player);

        } else if (player.getLevel() == 7 || player.getLevel() == 8) {
            randomizeMonster = rd.nextInt(2) + 6;
            battle((monsters.get(randomizeMonster)), player);

        } else if (player.getLevel() == 9 && player.getXp() <= 500) {
            randomizeMonster = 8;
            battle((monsters.get(randomizeMonster)), player);

        } else if (player.getLevel() == 10 && player.getXp() <= 600) {
            randomizeMonster = 9;
            battle((monsters.get(randomizeMonster)), player);
        }
    }

    // The battle mellan monster och spelare
    public static Player battle(Monster monster, Player player) {

        boolean playerAlive = true;
        boolean monsterAlive = true;

        RandomMethod();
        System.out.println("");
        monster.ShowMonster(rd.nextInt(3)+1);

        while (playerAlive && monsterAlive) {

            int playerDamage = player.getAttackDamage();
            int monsterDamage = monster.getAttackDamage();
            int monsterDropExp = monster.getDropExp();
            int preLevel = player.getLevel();

            System.out.println("You hit the " + monster.getName() + " dealing " + playerDamage + " damage");
            monster.setHp(monster.getHp() - playerDamage);

            if (monster.getHp() <= 0) {
                System.out.println("You killed the monster, gaining " + monsterDropExp + " xp");
                player.setXp((player).getXp() + monsterDropExp);
                System.out.println(player.getName() + ":" + player.getCurrentHP() + " hp");
                monster.setHp(0);
                System.out.println(monster.getName() + ":" + monster.getHp() + " hp");
                System.out.println("");

                player.CheckLevel(player.getXp());
                if (player.getLevel() == 11) {
                    Winner();       // Om spelare klarar level 10 anropas en metod med "Vinnar text"
                    monsterAlive = false;
                }
                int postLevel = player.getLevel();
                if (preLevel != postLevel) {
                    player.levelUp(); // levlar upp om nya leveln inte är samma som förra
                    monsterAlive = false;
                }  if (preLevel == postLevel) { // bryter loopen om nya leveln är samma som förra, alltså inte levlat upp
                    monsterAlive = false;
                }
            } else if (player.getCurrentHP() > 0 && monster.getHp() > 0) {
                System.out.println("Ahhh!!");
                System.out.println("The " + monster.getName() + " hit you, dealing " + monsterDamage + " damage!");
                player.setCurrentHP(player.getCurrentHP() - monsterDamage);
                if (player.getCurrentHP() < 0) {
                    System.out.println("The monster knocked you out :(, you need a rest...");
                    player.setCurrentHP(0);
                    playerAlive = false;
                }
            }
            enter();
        }
        System.out.println("Details from last round!");
        return player;
    }


    // Ifall spelare vinner anropas denna text
    public static void Winner() {
        System.out.println("");
        System.out.println("You killed the MagicWitch and broke the spell...");
        enter();
        System.out.println("Days later of hiking back to the village...");
        enter();
        System.out.println("The people of the village are all awake! You saved them <3 ");
    }

}


