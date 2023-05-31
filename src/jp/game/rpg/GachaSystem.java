package jp.game.rpg;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

//ユーザークラス
 class User {
	private int id;
	private String name;
	private long kakin;
	
	public User(int id, String name, long kakin) {
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
	long getKakin() {
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
    private int superRareItemCount;
    private int rareItemCount;
    private int nomalItemCount;

    public GachaSystem(int id, String name, int kakin, int magicStoneCount) {
    	super(id, name, kakin);
        this.magicStoneCount = magicStoneCount;
    }
    
    //getter
    int getMagicStoneCount() {
    	return magicStoneCount;
    }
    void getItemCount() {
    	System.out.println("超レアアイテムが出た数: " + superRareItemCount);
    	System.out.println("レアアイテムが出た数: " + rareItemCount);
    	System.out.println("ノーマルアイテムが出た数: " + nomalItemCount);
    }
    
    // setter(1万円を課金して魔法石を購入する)
    void setMagicStoneCount() {
    	System.out.println("1万円で魔法石を100個購入しました。");
    	this.magicStoneCount += 100;
    	setKakin(10000);
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
        int superRareItem = 1; //超レアアイテムの確率
        int rareItem = 10; //レアアイテムの確率

        if (result < superRareItem) {
            System.out.println("超レアアイテムを獲得しました！");
            superRareItemCount++;
            // 超レアアイテムの付与処理
        } else if (result < rareItem) {
            System.out.println("レアアイテムを獲得しました！");
            rareItemCount++;
            // レアアイテムの付与処理
        } else {
            System.out.println("ノーマルアイテムを獲得しました！");
            nomalItemCount++;
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
    public void playGacha100() {
    	if(magicStoneCount < 500) {
    		System.out.println("魔法石が足りません。");
    		return;
    	} else {
    		for(int i = 0; i < 100; i++) {
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
    	LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
    	System.out.println();
    	System.out.println(now.withNano(0).format(formatter));
    	System.out.println("あなたのユーザーID: " + user1.getId());
    	System.out.println("あなたの名前: " + user1.getName());
    	System.out.println("あなたの所持魔法石: " + user1.getMagicStoneCount());
    	System.out.println("あなたの使った金額: " + user1.getKakin() + "円");
    	user1.getItemCount();
    	System.out.println();
        if(user1.getKakin() >= 1000000) {
            System.out.println("お金の使い過ぎで人生が終わった！！");
            System.out.println("GAME OVER");
            break;
        } else {
        	System.out.println("1: ガチャを引く");
            System.out.println("2: 10連ガチャを引く");
            System.out.println("3: やめる");
            System.out.println("4: 課金する");
            System.out.println("5: 勇気の決断...10万だ");
            System.out.println();
        	System.out.print("選択肢を入力してください: ");
            System.out.println();
        }
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
            	user1.setMagicStoneCount();
            	break;
            case 5: //廃課金の末路
            	for(int i = 0; i < 10; i++) {
            	user1.setMagicStoneCount();
            	}
            	break;
            case 10:
            	user1.playGacha100();
            	break;
            case 100:
            	System.out.println("100万円を散財した");
            	user1.setKakin(1000000);
            	break;
            default:
                System.out.println("無効な選択肢です。もう一度入力してください。");
                ;
    		}    	
    	
    	}
    	scanner.close();
    	
    }
}

