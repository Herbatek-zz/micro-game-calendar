package com.piotrke;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class GameSeries {

    @Id
    private String name;

    private String imageUrl;

    private String description;

    @ElementCollection
    private Set<String> gamesId;
}
