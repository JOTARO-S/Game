package jp.game.rpg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Monster {
	private int id;
	private String name;
	private int hp;
	private int mp;
	private int atk;
	private int def;
	private int matk;
	private int mdef;
	private int spd;
	private int luk;
	private String op;
	
	Monster() {
		
	}
	Monster(int id, String name, int hp, int mp, int atk, int def, int matk, int mdef, int spd, int luk, String op) {
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.atk = atk;
		this.def = def;
		this.matk = matk;
		this.mdef = mdef;
		this.spd = spd;
		this.luk = luk;
		this.op = op;
	}

	//setter
	void setId(int id) {
		this.id = id;
	}
	void setName(String name) {
		this.name = name;
	}
	void setHp(int hp) {
		this.hp =hp;
	}
	void setMp(int mp) {
		this.mp = mp;
	}
	void setAtk(int atk) {
		this.atk = atk;
	}
	void setDef(int def) {
		this.def = def;
	}
	void setMatk(int matk) {
		this.matk = matk;
	}
	void setMdef(int mdef) {
		this.mdef = mdef;
	}
	void setSpd(int spd) {
		this.spd = spd;
	}
	void setLuk(int luk) {
		this.luk = luk;
	}
	void setOp(String op) {
		this.op = op;
	}
	//getter
	int getId() {
		return id;
	}
	
	void show() {
		System.out.println("ID: " + id + ", 名前: " + name + ", HP: " + hp + ", MP: " + mp + ", ATK: " + atk + ", DEF: " + def 
				+ ", MATK: " + matk + ", MDEF: " + mdef + ", SPD: " + spd + ", LUK: " + luk + ", OP: " + op);
	}
	
	void encaunt() {
		System.out.println(name + "が現れた！どうする？");
		
	}
	

	public static void main(String[] args) {
		File inputFile = null;
		BufferedReader in = null;
		
		ArrayList<Monster> list = new ArrayList<>();
		
		try {
			inputFile = new File("Monster.txt");
			in = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
			String line;
			while((line = in.readLine()) != null) {
				Monster monster = new Monster();
				String[] str = line.split(",");
				monster.setId(Integer.parseInt(str[0]));
				monster.setName(str[1]);
				monster.setHp(Integer.parseInt(str[2]));
				monster.setMp(Integer.parseInt(str[3]));
				monster.setAtk(Integer.parseInt(str[4]));
				monster.setDef(Integer.parseInt(str[5]));
				monster.setMatk(Integer.parseInt(str[6]));
				monster.setMdef(Integer.parseInt(str[7]));
				monster.setSpd(Integer.parseInt(str[8]));
				monster.setLuk(Integer.parseInt(str[9]));
				monster.setOp(str[10]);
				list.add(monster);
			}
			for(Monster i : list) {
				i.show();
			}
			list.get(0).encaunt();
			
		} catch(FileNotFoundException e) {
			System.out.println("FileNotFoundException occurs");
		} catch(IOException e) {
			System.out.println("IOException occurs");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch(IOException e) {
				System.out.println("close fail");
				e.printStackTrace();
			}
		}	
	}
}
