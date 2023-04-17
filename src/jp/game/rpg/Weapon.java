package jp.game.rpg;

/*

class Car2 {
	String color;
	int num;
	double gas;
	
	public Car2(String c, int n, double g) {
		color = c;
		num = n;
		gas = g;
	}
	
	public void show() {
		System.out.println("車の色は" + color + " ナンバーは[" + num + "] 燃料は [" + gas + "]");
	}
}

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
}
