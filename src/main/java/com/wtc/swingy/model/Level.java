package com.wtc.swingy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Level {
 
    @Id
    @GeneratedValue
    private Long id;
 
    private int mapLevel;

    private int size;
    
    @OneToMany(
        mappedBy = "level",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Champion> Champions = new ArrayList<>();

    public void LevelUp() {
        if (this.mapLevel < 7)
        {
            this.mapLevel += 1;
            this.size = (mapLevel - 1) * 5 + 10 - (mapLevel % 2);
        }
    }

    public Level() {
        this.mapLevel = 1;
        this.size = (this.mapLevel - 1) * 5 + 10 - (this.mapLevel % 2);
    }
    
	public void addChampion(Champion champion) {
        Champions.add(champion);
        champion.setLevel(this);
    }
 
    public void removeChampion(Champion champion) {
        Champions.remove(champion);
        champion.setLevel(null);
    }


	public static void MoveChamp(Champion champ, int x, int y) {
        champ.setPlayerx(champ.getPlayerx() + x);
        champ.setPlayery(champ.getPlayery() - y);
    }

    @Override
    public String toString() {
        return this.Champions.get(0).getName() + " " + this.mapLevel + " " + this.Champions.size();
    } 

}