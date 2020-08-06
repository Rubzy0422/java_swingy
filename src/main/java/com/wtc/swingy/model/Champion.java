package com.wtc.swingy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


@Entity
@Table
@Data
public class Champion {
 
    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 20, min = 3, message = "Player Name Must Be between three and 20 Characters long")
    @NotEmpty(message = "Please enter name")
    private String Name;

    private ChampionClass ChampionClass;

    private int Experience;

    private int Attack;

    private int Defence;

    private int HitPoints;
    
    @NotNull(message = "Champion must be user or system generated!")
    private boolean UserGenerated;
    
    
    private int playerx;
    
    private int playery;
 

    @ManyToOne(fetch = FetchType.LAZY)
    private Level level;
  
    @OneToOne(fetch = FetchType.LAZY)
    private Artifact artifact;
    
    public int compare(Champion champ) {
        
        int pScore = (this.HitPoints * this.Defence) - champ.getAttack();
        int eScore = (champ.getHitPoints() * champ.getAttack())  - this.Attack;       
        pScore += this.Experience;
        eScore += champ.getExperience();
        System.out.println(pScore + " : " + eScore );
        if (pScore >= eScore)
            return Math.abs(eScore - pScore) * 10;
        return -1;
    }

    public void setExperience(int Experience)
    {
        Random rand = new Random();
        this.Experience = Experience;
        if (this.Experience >= this.level.getMapLevel() * 1000 + (this.level.getMapLevel() - 1) * (this.level.getMapLevel() - 1) * 450)
        {
            System.out.println("LEVEL UP");
            this.level.LevelUp();
            for (Champion c : this.level.getChampions())
            {
                c.setExperience(rand.nextInt(c.getExperience() + 10));
                c.setAttack(rand.nextInt(c.getAttack() + 2));
                c.setDefence(rand.nextInt(c.getDefence() + 2));
                c.setHitPoints(rand.nextInt(c.getHitPoints() + 2));
        
                // Artifact artifact = new Artifact(level.getMapLevel());
            }
        }
    }

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

    // int Attack, int Defence, int HitPoints,
	public Champion(String name, ChampionClass ChampionClass, int Experience, boolean UserGenerated, int playerx, int playery) {
        this.Name = name;
        setChampionClass(ChampionClass);
        this.Experience = Experience;
        this.UserGenerated = UserGenerated;
        this.playerx = playerx;
        this.playery = playery;
    }

    public Champion() {};
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HERO NAME:\t\t").append(this.Name).append("\n")
        .append("HERO CLASS:\t\t").append(this.ChampionClass.name()).append("\n")
        .append("HERO ATTACK:\t\t").append(this.Attack).append("\n")
        .append(" HERO DEFENSE:\t\t").append(this.Defence).append("\n")
        .append("HERO HIT POINTS:\t\t").append(this.HitPoints).append("\n")
        .append("HERO XP:\t\t\t").append(this.Experience).append("\n");

        return sb.toString();
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
            case PIKEMAN : {
                this.Attack = 3;
                this.Defence = 1; 
                this.HitPoints = 3;
            }
        }
	}

    public void setArtifact(Artifact artifact) {
        
        if (this.artifact != null)
        {
            switch (this.artifact.getArtifactType())
            {
                case ARMOR:
                    this.Defence -= this.artifact.getValue();
                    break;
                case HELM:
                    this.HitPoints -= this.artifact.getValue();
                    break;
                case WEAPON:
                    this.Attack -= this.artifact.getValue();
                    break;
                default:
                    break;
            }
        }

        switch (artifact.getArtifactType())
        {
            case ARMOR:
                this.Defence += artifact.getValue();
                break;
            case HELM:
                this.HitPoints += artifact.getValue();
                break;
            case WEAPON:
                this.Attack += artifact.getValue();
                break;
            default:
                break;
            
        }
        this.artifact = artifact;
    }
}