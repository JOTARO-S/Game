package jp.game.rpg;
import java.util.Random;
import java.util.Scanner;

//ユーザークラス
 class User {
	private int id;
	private String name;
	private int kakin;
	
	public User(int id, String name, int kakin) {
		this.id = id;
		this.name = name;
		this.kakin = kakin;
	}
	
	//getter
	int getId() {
		return id;
	}
	String getName() {
		return name;
	}
	int getKakin() {
		return kakin;
	}
	
	//setter
	void setName(String name) {
		this.name = name;
	}
	void setKakin(int kakin) {
		this.kakin += kakin;
	}
}

//ガチャシステム クラス
public class GachaSystem extends User{
    private int magicStoneCount;

    public GachaSystem(int id, String name, int kakin, int magicStoneCount) {
    	super(id, name, kakin);
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
        int superRareItem = 3; //超レアアイテムの確率
        int rareItem = 20; //レアアイテムの確率

        if (result < superRareItem) {
            System.out.println("超レアアイテムを獲得しました！");
            // 超レアアイテムの付与処理
        } else if (result < rareItem) {
            System.out.println("レアアイテムを獲得しました！");
            // レアアイテムの付与処理
        } else {
            System.out.println("ノーマルアイテムを獲得しました！");
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
    	GachaSystem user1 = new GachaSystem(1234, "test", 0, 100);
    	Scanner scanner = new Scanner(System.in);
    	int choice = 0;

    	while (choice != 3) {
    	System.out.println();
    	System.out.println("あなたのユーザーID: " + user1.getId());
    	System.out.println("あなたの名前: " + user1.getName());
    	System.out.println("あなたの所持魔法石: " + user1.getMagicStoneCount());
    	System.out.println("あなたの使った金額: " + user1.getKakin() + "円");
    	System.out.println();	
    	System.out.println("1: ガチャを引く");
        System.out.println("2: 10連ガチャを引く");
        System.out.println("3: やめる");
        System.out.println("4: 課金する");
        System.out.println();	
        System.out.print("選択肢を入力してください: ");
        System.out.println();	
        
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            scanner.next(); // 入力ストリームをクリア
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
            	user1.setKakin(10000);
            	user1.setMagicStoneCount();
            	break;
            case 29:
            	System.out.println("隠しコマンド");
            	System.out.println("焼肉を食べに行った!とても美味しかった!");
            	user1.setKakin(5000);
            	break;
            default:
                System.out.println("無効な選択肢です。もう一度入力してください。");
                ;
    		}    	
    	
    	}
    	scanner.close();
    	
    }
}

