package jp.game.rpg;

import java.util.Random;

public class RandomEncounter {
	private static final double ENCOUNTER_RATE = 0.2; // エンカウント率
    private static final String[] ENEMY_TYPES = {"スライム", "ゴブリン", "ドラゴン"}; // 敵の種類
    private static final int MIN_ENEMY_LEVEL = 1; // 敵の最低レベル
    private static final int MAX_ENEMY_LEVEL = 10; // 敵の最高レベル

    public static void main(String[] args) {
        Random rand = new Random();
        if (rand.nextDouble() <= ENCOUNTER_RATE) {
            // 敵が出現する場合
            int enemyLevel = rand.nextInt(MAX_ENEMY_LEVEL - MIN_ENEMY_LEVEL + 1) + MIN_ENEMY_LEVEL;
            String enemyType = ENEMY_TYPES[rand.nextInt(ENEMY_TYPES.length)];
            System.out.println("Lv." + enemyLevel + " " + enemyType + "が現れた！");
        } else {
            // 敵が出現しない場合
            System.out.println("何も起こらなかった。");
        }
    }

}
