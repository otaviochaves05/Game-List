package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> response = gameRepository.findAll();
        return response.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(long gameId){
        Game response = gameRepository.findById(gameId).get();
        return new GameDTO(response);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(long listId) {
        List<GameMinProjection> response = gameRepository.searchByList(listId);
        return response.stream().map(GameMinDTO::new).toList();
    }

}