package johannfjs.com.models;

import java.util.ArrayList;

/**
 * Created by Johann on 06/03/2015.
 */
public class Battle {
    private String battleTag;
    private ArrayList<Heroes> heroes;

    public Battle() {
    }

    public Battle(String battleTag, ArrayList<Heroes> heroes) {
        this.battleTag = battleTag;
        this.heroes = heroes;
    }

    public String getBattleTag() {
        return battleTag;
    }

    public void setBattleTag(String battleTag) {
        this.battleTag = battleTag;
    }

    public ArrayList<Heroes> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Heroes> heroes) {
        this.heroes = heroes;
    }
}
