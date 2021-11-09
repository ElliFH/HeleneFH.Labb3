package Labb3;

public class Player extends Methods {

    private String name;
    private int level = 1;
    private int xp = 0;
    private int maxHP;
    private int attackDamage;
    private int currentHP;
    private int reqXP = 0;
    private boolean levelUp = true;

    Player() {
        setMaxHP(100);
        setLevel(1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getAttackDamage() {

        //Metod för att ge spelaren ett attack randomvärde beroende på level

        int random = attackDamage;
        if (getLevel() <= 3) {
            random = randomRange(10,25);
        }else if (getLevel() >= 3 && getLevel() <= 6) {
            random = randomRange(25, 35);
        }else if (getLevel() >=6 && getLevel() <=9) {
            random = randomRange(35,70);
        }else if (getLevel() == 10 && getXp() <= 600) {
            random = randomRange(70,100);
        }
        return random;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getCurrentHP() {

        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getReqXP() {
        return reqXP;
    }

    public void setReqXP(int reqXP) {
        this.reqXP = reqXP;
    }

    //Metod för att checka xp och beroende på requiredxp, levla upp och sätta nya värden
    public void CheckLevel(int xp) {

        if (xp < 25) {
            setLevel(1);
            setReqXP(25);
            setMaxHP(100);
        } else if (xp >= 25 && xp < 50) {
            setLevel(2);
            setReqXP(50);
            setMaxHP(110);
        } else if (xp >= 50 && xp < 85) {
            setLevel(3);
            setReqXP(85);
            setMaxHP(130);
        } else if (xp >= 85 && xp < 130) {
            setLevel(4);
            setReqXP(130);
            setMaxHP(150);
        } else if (xp >= 130 && xp < 190) {
            setLevel(5);
            setReqXP(190);
            setMaxHP(180);
        } else if (xp >= 190 && xp < 250) {
            setLevel(6);
            setReqXP(250);
            setMaxHP(210);
        } else if (xp >= 250 && xp < 320) {
            setLevel(7);
            setReqXP(320);
            setMaxHP(250);
        } else if (xp >= 320 && xp < 410) {
            setLevel(8);
            setReqXP(410);
            setMaxHP(300);
        } else if (xp >= 410 && xp < 500) {
            setLevel(9);
            setReqXP(500);
            setMaxHP(350);
        } else if (xp >= 500 && xp < 600) {
            setLevel(10);
            setReqXP(600);
            setMaxHP(400);
        } else if (xp >= 600) {
            setLevel(11);
            setReqXP(600);
            setMaxHP(400);
        }
    }


    // Metod som anropas ifall spelaren levlar upp
    public void levelUp() {
        if (getLevel() <= 10) {
            System.out.println("You leveled up!");
            System.out.println("You are at level: " + getLevel() + " and you have " + getXp() + " xp " + "and " + getMaxHP() + " hp");
            levelUp = true;
        }
    }


    //Storytelling inna varje ny level körs
    public void CheckLevelUp() {

        if (levelUp) {
            System.out.println("************");
        }
        if (getLevel() == 1 && levelUp) {
            System.out.println("It's been months since the MagicWitch came to put a spell over the little village..");
            System.out.println("She has put the people of the village to eternal sleep! Except me...");
            enter();
            System.out.println("I'm the only one who can find the MagicWitch and make her break the spell!");
            System.out.println("But it won't be easy... Let the journey begin...");
            enter();
            System.out.println("Days later of hiking...");
            levelUp = false;
        } else if (getLevel() == 2 && levelUp) {
            System.out.println("That was quite easy, I'm alright! ");
            enter();
            levelUp = false;
        } else if (getLevel() == 3 && levelUp) {
            System.out.println("MagicWitch, you better bring stronger monsters to defeat me!");
            enter();
            levelUp = false;
        }else if (getLevel() == 4 && levelUp) {
            System.out.println("Well, I might have been a little too cocky... But I made it!");
            enter();
            levelUp = false;
        }else if (getLevel() == 5 && levelUp) {
            System.out.println("Ok... That was crazy...");
            enter();
            levelUp = false;
        }else if (getLevel() == 6 && levelUp) {
            System.out.println("Pheeww... MagicWith, come out come out where ever you are...");
            enter();
            levelUp = false;
        }else if (getLevel() == 7 && levelUp) {
            System.out.println("I did not expect that... Who's next?");
            enter();
            levelUp = false;
        }else if (getLevel() == 8 && levelUp) {
            System.out.println("I'm starting to wonder if I'll ever meet the MagicWitch...");
            enter();
            levelUp = false;
        }else if (getLevel() == 9 && levelUp) {
            System.out.println("I miss the people of the village... I'll fight for them as long as I can! I will break the spell!");
            enter();
            levelUp = false;
        }else if (getLevel() == 10 && levelUp) {
            System.out.println("Come on now... MagicWitch, SHOW YOURSELF!");
            enter();
            levelUp = false;
        }
    }


    // Skriver ut spelarens detaljer
    @Override
    public String toString() {

        return "************" + '\n' +
                "* Name: " + getName() + '\n' +
                "* Level: " + getLevel() + '\n' +
                "* Hp: " + getCurrentHP() + "/" + getMaxHP() + '\n' +
                "* Exp: " + getXp() + "/" + getReqXP() + '\n' +
                "************";
    }
}
