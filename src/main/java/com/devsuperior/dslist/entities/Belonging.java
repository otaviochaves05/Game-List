package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    private BelongingPrimaryKey id = new BelongingPrimaryKey();
    private int position;

    public Belonging(){}

    public Belonging(Game game, GameList list, int position) {
        id.setGame(game);
        id.setList(list);
        this.position = position;
    }

    public BelongingPrimaryKey getId() {
        return id;
    }

    public void setId(BelongingPrimaryKey id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Belonging belonging = (Belonging) o;
        return Objects.equals(id, belonging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
