package jp.game.rpg;

import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

class Bank {
	private int id;
	private String password;
	private String name;
	private long money;
	
	
	Bank(int id,String password, String name, long money) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.money = money;
	}
	//setter
	void setPassword(String password) {
		this.password = hash(password);
	}
	void setName(String name) {
		this.name = name;
	}
	void setMoney(long money) {
		this.money = money;
	}
	//getter
	int getId() {
		return id;
	}
	String getPassword() {
		return password;
	}
	String getName() {
		return name;
	}
	long getMoney() {
		return money;
	}
	private String hash(String password) {
		return password;
	}
	void show() {
		System.out.println("口座番号: " + id + ", 名前: " + name + ", 残高: " + money + "円です。");
	}
	void add() {
		JPasswordField passwordField = new JPasswordField();
		long num = 0;
		Scanner scanner = new Scanner(System.in);
		int result = JOptionPane.showConfirmDialog(null, passwordField, "パスワードを入力してください", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
		    String password = new String(passwordField.getPassword());
		    System.out.println("お金を入金してください。:");
        	num = scanner.nextLong();
        	if (num >= 1) {
        		setMoney(getMoney() + num);
        	} else {
        		System.out.println("最初からやり直してください。");
        	}
        	
        	System.out.println("残高は " + getMoney() + "円です。" );
        	System.out.println("ご利用ありがとうございました。");
        	System.out.println();
		}
	}
	
}

public class Atm {
	public static void main(String[] args) {
		Bank user1 = new Bank(1000001,"1234","山田",1000000);
		
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		long num = 0;
		
		while (choice != 9) {
			System.out.println("1: 預ける");
            System.out.println("2: 引き出す");
            System.out.println("3: 残高照会");
            System.out.println("9: 終了");
			System.out.print("選択肢を入力してください: ");
			try {
				choice = scanner.nextInt();
			} catch (Exception e) {
	            scanner.next(); // 入力ストリームをクリア
			}
			switch (choice) {
            case 1: //預ける
            	user1.add();
            	break;
            case 2: //引き出す
            	System.out.println("パスワードを入力してください: ******** ");
            	System.out.println("引き出す金額を入力してください。:");
            	num = scanner.nextLong();
            	if (num > user1.getMoney()) {
            		System.out.println("残高が足りません。最初からやり直してください。");
            	} else if (num <= user1.getMoney()) {
            		user1.setMoney(user1.getMoney() - num);
            	} else {
            		System.out.println("最初からやり直してください。");
            	}
            	System.out.println("残高は " + user1.getMoney() + "円です。" );
            	System.out.println("ご利用ありがとうございました。");
            	System.out.println();
            	break;
            case 3: //残高照会
            	System.out.println("パスワードを入力してください: ******** ");
                user1.show();
                System.out.println("ご利用ありがとうございました。");
                System.out.println();
                break;
            case 9: //終了
            	System.out.println("終了します");
            	System.out.println("ご利用ありがとうございました。");
            	System.out.println();
            	break;
            default:
                System.out.println("無効な選択肢です。もう一度入力してください。");
                ;
    		}
		}
		scanner.close();
	}
}
