package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;
/* org.springframework.beans.BeanUtils;*/

public class GameListDTO {
    private long id;
    private String name;

    public GameListDTO(){}

    public GameListDTO(GameList entity) {
        /*BeanUtils.copyProperties(entity, this);*/
        id = entity.getId();
        name = entity.getName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
