package jp.game.rpg;

//Pikachuクラスの記述例
public class Pikachu extends Pokemon {
 public Pikachu(String name, int level, int hp) {
     super(name, level, hp);
 }
 
 public void thunderbolt() {
     System.out.println(getName() + " used Thunderbolt!");
 }
 
 public static void main(String[] args) {
	 Pikachu pika1 = new Pikachu("pikapi",15,30);
	 pika1.thunderbolt();
 }
 
}
