package com.wtc.swingy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table
@Data
public class Level {
 
    @Id
    @GeneratedValue
    private Long id;
 
    private String title;
 
    private int mapLevel;

    private int size;

    private int EnemyEntiries;
    
    // User Champ sould and will always be the first champion
    @Transient
    private int PlayerIndex = 0;

    @OneToMany(
        mappedBy = "level",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Champion> Champions = new ArrayList<>();

    public Level() {
        this.mapLevel = 1;
        this.size = (mapLevel - 1) * 5 + 10 - (mapLevel % 2);
        this.EnemyEntiries = (int) Math.round(Math.random() * (this.size - 1));
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
}