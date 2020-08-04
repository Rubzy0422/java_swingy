package com.wtc.swingy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javassist.expr.NewArray;
import lombok.Data;


@Entity
@Table
@Data
public class Champion {
 
    @Id
    @GeneratedValue
    private Long id;
    private String Name;
    private ChampionClass ChampionClass;
    private int ChampLevel;
    private float Experience;
    private float Attack;
    private float Defence;
    private float HitPoints;
    private boolean UserGenerated;
    private int playerx;
    private int playery;
 

    @ManyToOne(fetch = FetchType.LAZY)
    private Level level;
  
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Champion )) return false;
        return id != null && id.equals(((Champion) o).getId());
    }
 
    // @Override
    // public int hashCode() {
    //     return 31;
    // }

    public List<Champion> getEnemies()
    {
        List<Champion> chamlst = level.getChampions();
        List<Champion> tmp = new ArrayList<Champion>();

        for(Champion _enem : chamlst) {
            if (_enem != this)
                tmp.add(_enem);
        }
        return tmp;
    }

    // float Attack, float Defence, float HitPoints,
	public Champion(String name, ChampionClass ChampionClass, int ChampLevel, float Experience, boolean UserGenerated, int playerx, int playery) {
        this.Name = name;
        setChampionClass(ChampionClass);
        this.ChampLevel = ChampLevel;
        this.Experience = Experience;
        this.UserGenerated = UserGenerated;
        this.playerx = playerx;
        this.playery = playery;
    }

    public String toString() {
        return String.format("HERO NAME:\t\t%s\n\nHERO CLASS:\t\t%s\nHERO ATTACK:\t\t%f\nHERO DEFENSE:\t\t%f\nHERO HIT POINTS:\t\t%f\n\nHERO LEVEL:\t\t%d\nHERO XP:\t\t\t%f\n", this.Name, this.ChampionClass, this.Attack, this.Defence, this.HitPoints, this.ChampLevel, this.Experience);
    }

    public void setChampionClass(ChampionClass _ChampionClass) {
        this.ChampionClass = _ChampionClass;
        switch (_ChampionClass) {
            case SKELETON: {
                this.Attack = 3;
                this.Defence = 1;
                this.HitPoints = 2;
                break;
            }
            case WARRIOR : {
                this.Attack = 2;
                this.Defence = 2;
                this.HitPoints = 2; 
            }
            case SPEARMAN : {
                this.Attack = 3;
                this.Defence = 1; 
                this.HitPoints = 3;
            }
        }
	}
}