package jp.game.rpg;

//Pokemonクラスの記述例
public class Pokemon {
 private String name;
 private int level;
 private int hp;
 
 public Pokemon(String name, int level, int hp) {
     this.name = name;
     this.level = level;
     this.hp = hp;
 }
 
 public String getName() {
     return name;
 }
 
 public int getLevel() {
     return level;
 }
 
 public int getHp() {
     return hp;
 }
 
 public void setHp(int hp) {
     this.hp = hp;
 }
 
 public void attack() {
     System.out.println(name + " attacked!");
 }
}
