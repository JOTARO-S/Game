package jp.game.rpg;

import java.util.ArrayList;

class CharaStatus {
	
	private int id;
	private String name;
	private int lv;
	private int hp;
	private int mp;
	private int atk;
	private int def;
	private int matk;
	private int mdef;
	private int spd;
	private int luk;
	
	
	public CharaStatus(int id, String name, int lv, int hp, int mp, int atk, int def, int matk, int mdef, int spd, int luk) {
		this.id = id;
		this.name = name;
		this.lv = lv;
		this.hp = hp;
		this.mp = mp;
		this.atk = atk;
		this.def = def;
		this.matk = matk;
		this.mdef = mdef;
		this.spd = spd;
		this.luk = luk;
	}
	
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLv() {
		return this.lv;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public int getMp() {
		return this.mp;
	}
	
	public int getAtk() {
		return this.atk;
	}
	
	public int getDef() {
		return this.def;
	}
	
	public int getMatk() {
		return this.matk;
	}
	
	public int getMdef() {
		return this.mdef;
	}
	
	public int getSpd() {
		return this.spd;
	}
	
	public int getLuk() {
		return this.luk;
	}
	
	// setter
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLv(int lv) {
		this.lv = lv;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void setMp(int mp) {
		this.mp = mp;
	}
	
	public void setAtk(int atk) {
		this.atk = atk;
	}
	
	public void setDef(int def) {
		this.def = def;
	}
	
	public void setMatk(int matk) {
		this.matk = matk;
	}
	
	public void setMdef(int mdef) {
		this.mdef = mdef;
	}
	
	public void setSpd(int spd) {
		this.spd = spd;
	}
	
	public void setLuk(int luk) {
		this.luk = luk;
	}
	
	//
	
	public void show() {
		System.out.println(
			"ID:" + id +
			", 名前:" + name +
			", Lv:" + lv +
			", ATK:" + atk +
			", DEF:" + def +
			", MATK:" + matk +
			", MDEF:" + mdef +
			", SPD:" + spd +
			", LUK:" + luk );
	}

}
 
public class Test {
	public static void main(String[] args) {
		ArrayList<CharaStatus> charaStatus = new ArrayList<>();
		CharaStatus chara1 = new CharaStatus(1, "主人公", 1	, 15, 0, 5, 5, 3, 3, 5, 1);
		
		
		charaStatus.add(chara1);
		
		for(CharaStatus c : charaStatus) {
			c.show();
		}
	}
}
