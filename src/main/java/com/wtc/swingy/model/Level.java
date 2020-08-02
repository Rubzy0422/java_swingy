package com.wtc.swingy.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.LazyCollection;


@Data
@Entity
@Table
public class Level {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private final int size;

        private final int level;


        @OneToMany(
                mappedBy = "Map",
                cascade = CascadeType.ALL,
                orphanRemoval = true
            )
            private List<Champion> Champions;
       

        // Array List is champion or null
        public Level(final int level) {
                this.level = level;
                this.size = (level - 1)*5+10-(level%2);
               
                // Square = new ArrayList<Champion>();
                // GenerateChampions();
        }

        public void GenerateChampions()
        {
                // FOR EACH BLOCK THERE IS A 1 IN X CHANCE TO SPAWN A VILLAN
                for (int y = 0; y < Champions.size(); y++) {
                        Random rand = new Random();
                        int numx = rand.nextInt((Champions.size() - 0) + 1);
                        int numy = rand.nextInt((Champions.size() - 0) + 1);
                       Champion tmp = new Champion("RAND", "warrior", 1, 0, false, this);
                       
                       tmp.setPlayerx(numx);
                       tmp.setPlayery(numy);
                       Champions.add(tmp);
               }
       }

		public long getId() {
			return this.id;
		}

		public int getSize() {
			return this.size;
                }

                public void AddChampion(Champion champ) {
                        Champions.add(champ);
                        // champ.setPost(this);
                    }
                
                    public void RemoveChampion(Champion champ) {
                        Champions.remove(champ);
                        // champ.setPost(null);
                    }
}
