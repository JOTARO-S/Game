package jp.game.rpg;
import java.util.Random;
import java.util.Scanner;

//ガチャシステム クラス
public class GachaSystem {
    private int magicStoneCount;

    public GachaSystem(int magicStoneCount) {
        this.magicStoneCount = magicStoneCount;
    }
    
    //getter
    int getMagicStoneCount() {
    	return magicStoneCount;
    }
    
    // setter(1万円を課金して魔法石を購入する)
    void setMagicStoneCount() {
    	System.out.println("1万円で魔法石を100個購入しました。");
    	this.magicStoneCount += 100;
    }

    // ガチャを引く
    public void playGacha() {
        if (magicStoneCount < 5) {
            System.out.println("魔法石が足りません。");
            return;
        }

        magicStoneCount -= 5;

        Random random = new Random();
        int result = random.nextInt(100);  // 0~99の整数をランダムに生成

        if (result < 5) {
            System.out.println("超レアアイテムを獲得しました！");
            // 超レアアイテムの付与処理
        } else if (result < 20) {
            System.out.println("レアアイテムを獲得しました！");
            // レアアイテムの付与処理
        } else {
            System.out.println("ノーマルアイテムを獲得しました。");
            // ノーマルアイテムの付与処理
        }
    }
    
    // 10連ガチャを引く
    public void playGacha10() {
    	if(magicStoneCount < 50) {
    		System.out.println("魔法石が足りません。");
    		return;
    	} else {
    		for(int i = 0; i < 10; i++) {
    			playGacha();
    		}
    	}
    }
    
    // メイン
    public static void main(String[] args) {
    	GachaSystem user1 = new GachaSystem(100);
    	Scanner scanner = new Scanner(System.in);
    	int choice = 0;

    	while (choice != 3) {
    	System.out.println();	
    	System.out.println("あなたの所持魔法石" + user1.getMagicStoneCount());
    	System.out.println("1: ガチャを引く");
        System.out.println("2: 10連ガチャを引く");
        System.out.println("3: やめる");
        System.out.println("4: 課金する");
        System.out.print("選択肢を入力してください: ");
        System.out.println();	
        
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            scanner.next(); // 入力ストリームをクリア
            System.out.println("無効な選択です。もう一度入力してください。");
        }
        // 選択肢によって分岐
        switch (choice) {
            case 1: //1回引く
            	user1.playGacha();
            	break;
            case 2: //10回引く
            	user1.playGacha10();
            	break;
            case 3: //終了する
                System.out.println("終了します");
                break;
            case 4: //課金する
            	user1.setMagicStoneCount();
            	break;
            default:
                System.out.println("無効な選択肢です。");
                ;
    		}    	
    	
    	}
    	scanner.close();
    	
    }
}

