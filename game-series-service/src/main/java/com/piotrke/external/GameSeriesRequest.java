package com.piotrke.external;

import java.util.Objects;
import java.util.Set;

public class GameSeriesRequest {
    private String name;

    private Set<String> games;

    private String image;
    private String description;

    public String getName() {
        return name;
    }

    public Set<String> getGames() {
        return games;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGames(Set<String> games) {
        this.games = games;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameSeriesRequest that = (GameSeriesRequest) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "GameSeriesRequest{" +
                "name='" + name + '\'' +
                ", games=" + games +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
