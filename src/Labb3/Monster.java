package Labb3;

import java.util.Random;

public class Monster extends Methods {

    private String name;
    private int hp;
    private int attackDamage;
    private int dropExp;
    private int hpMin;
    private int hpMax;
    private int expMin;
    private int expMax;
    private int damageMin;
    private int damageMax;

    public Monster(String name, int hpMin, int hpMax, int expMin, int expMax, int damageMin, int damageMax) {

        this.name = name;
        this.hp = randomRange(hpMin, hpMax);
        this.dropExp = randomRange(expMin, expMax);
        this.attackDamage = randomRange(damageMin, damageMax);
        this.hpMin = hpMin;
        this.hpMax = hpMax;
        this.expMin = expMin;
        this.expMax = expMax;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
    }


    //Metod för att ge varje monster en egen introduktion i spelet
    public void ShowMonster(int i) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackDamage() {
        return randomRange(damageMin, damageMax);
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getDropExp() {
        return randomRange(expMin, expMax);
    }

    public void setDropExp(int dropExp) {
        this.dropExp = dropExp;
    }

}
