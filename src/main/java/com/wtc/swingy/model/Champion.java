package com.wtc.swingy.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;


@Data
@Entity
@Table
public class Champion implements ChampionConsts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Champion Name is Required")
    private String Name;

    @NotBlank(message = "Champion Class is Required")
    private String ChampionClass;

    @NotBlank(message = "Champion Level is Required")
    private int ChampLevel;

    @NotBlank(message = "Champion XP is Required")
    private double Experience;

    @NotBlank(message = "Champion AttackDamage is Required")
//    @Transient
    private float Attack;

    @NotBlank(message = "Champion Defence is Required")
//    @Transient
    private float Defence;

    @NotBlank(message = "Champion HitPoints is Required")
//    @Transient
    private float HitPoints;

    @NotBlank(message = "UserGenerated required")
    private boolean UserGenerated;

    private int playerx;

    private int playery;

    @ManyToOne
    private Level Map;

    public Champion(String Name, String ChampionClass, int ChampLevel, double Experience, boolean UserGenerated, Level Map) {
        setChampionClass(ChampionClass);
        this.ChampLevel = ChampLevel;
        this.Experience = Experience;
        this.UserGenerated = UserGenerated;
        if (UserGenerated)
        {
            this.playerx = ((Map.getSize() - 1) / 2) + 1;
            this.playery =  ((Map.getSize() - 1) / 2) + 1;
        }
      
        this.Map = Map;
        this.Name = Name;
    }


    public String toString() {
        return String.format("HERO NAME:\t\t%s\n\nHERO CLASS:\t\t%s\nHERO ATTACK:\t\t%f\nHERO DEFENSE:\t\t%f\nHERO HIT POINTS:\t\t%f\n\nHERO LEVEL:\t\t%d\nHERO XP:\t\t\t%f\nMAP LEVEL:\t\t\t%d", this.Name, this.ChampionClass, this.Attack, this.Defence, this.HitPoints, this.ChampLevel, this.Experience, this.Map.getId());
    }


	public void setName(String name) {
        this.Name = name;
	}


	public void setChampionClass(String chosenClass) {
        this.ChampionClass = chosenClass;
        if (ChampionClass.equals("warrior"))
        {
            this.Attack = WARRIORAttack;
            this.Defence = WARRIORDefence;
            this.HitPoints = WARRIORHitPoints;
        }
        else if (ChampionClass.equals("skeleton"))
        {
            this.Attack = SKELETONAttack;
            this.Defence = SKELETONDefence;
            this.HitPoints = SKELETONHitPoints;
        }
        else if (ChampionClass.equals("spearman"))
        {
            this.Attack = SPEARMANAttack;
            this.Defence = SPEARMANDefence;
            this.HitPoints = SPEARMANHitPoints;
        }
	}


	public void setPlayerx(int numx) {
        this.playerx = numx;
	}


	public void setPlayery(int numy) {
        this.playery = numy;
	}
}