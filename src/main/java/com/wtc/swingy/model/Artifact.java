package com.wtc.swingy.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Artifact {
    @Id
    @GeneratedValue
    private Long id;

    private ArtifactType artifactType;

    private int value;

    public Artifact(int level) {
        Random rand = new Random();
        this.artifactType = ArtifactType.values()[rand.nextInt(3)];
        this.value = rand.nextInt(level);
    }

    public Artifact() {
        
    }

    @Override
    public String toString() {
        return this.artifactType.name() + " " + this.value;
    }
}