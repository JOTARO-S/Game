package jp.game.rpg;

/*
 * 
 */

public class Weapon {
    private String name;
    private int attack;

    public Weapon(String name, int attack) {
        this.name = name;
        this.attack = attack;
    }

    public String getName() {
        return this.name;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                '}';
    }

    public static void main(String[] args) {
    	Weapon weapon1 = new Weapon("鉄の剣",100);
    	System.out.println(weapon1);
    }
}
