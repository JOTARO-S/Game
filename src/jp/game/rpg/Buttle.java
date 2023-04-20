package jp.game.rpg;

public class Buttle {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    
    public Buttle(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }
    
    public void start() {
        System.out.println("The buttle begins!");
        
        while(pokemon1.getHp() > 0 && pokemon2.getHp() > 0) {
            // どちらかのポケモンが倒れるまで戦闘を続ける
            // ...戦闘中の処理...
        }
        
        if(pokemon1.getHp() > 0) {
            System.out.println(pokemon1.getName() + "の勝利！");
        } else {
            System.out.println(pokemon2.getName() + "の勝利！");
        }
    }
}

