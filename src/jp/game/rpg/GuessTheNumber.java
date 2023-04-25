package jp.game.rpg;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
	public static void main(String[] args) {
		Random rand = new Random();
		int randomNumber = rand.nextInt(100) + 1;
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		
		System.out.println("Guess The Number");
		
		while (choice != randomNumber) {
			System.out.print("1から100までの半角数字を入力してください(0:ギブアップ): ");
			try {
				choice = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("半角数字を入力してください");
	            scanner.next(); // 入力ストリームをクリア
	            continue;
			}
			if (choice == 0) break;
			if (choice < 1 || choice > 100) {
			} else if (choice - 30 > randomNumber) {
				System.out.println("もっと小さい数字を入力してください");	
			} else if (choice > randomNumber) {
				System.out.println("小さい数字を入力してください");
			} else if (choice + 30 < randomNumber) {
				System.out.println("もっと大きい数字を入力してください");	
			} else if (choice < randomNumber) {
				System.out.println("大きい数字を入力してください");
			} else {
				System.out.println("正解です！");
			}	
		}
		scanner.close();
	}
}
