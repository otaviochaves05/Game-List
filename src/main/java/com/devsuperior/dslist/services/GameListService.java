package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAllLists(){
        List<GameList> response = gameListRepository.findAll();
        return response.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection object = list.remove(sourceIndex);
        list.add(destinationIndex, object);

        int min = Math.min(sourceIndex, destinationIndex);
        /*int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;*/
        int max = Math.max(sourceIndex, destinationIndex);
        /*int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;*/

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(),i) ;
        }
    }
}
