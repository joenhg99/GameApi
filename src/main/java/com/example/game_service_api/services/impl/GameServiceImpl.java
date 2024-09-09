package com.example.game_service_api.services.impl;

import com.example.game_service_api.commons.entities.Game;
import com.example.game_service_api.commons.exceptions.GameException;
import com.example.game_service_api.repositories.GameRepository;
import com.example.game_service_api.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame(Game gameRequest){
        return this.gameRepository.save(gameRequest);
    }

    @Override
    public Game getGameById(final String id) {
        return this.gameRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND,"Error finding game"));
    }

    @Override
    public Game updateGameById(final String id, final Game game) {
        return this.gameRepository.findById(Long.valueOf(id)).map(game1 -> {
           return this.gameRepository.save(game);
        }).orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND,"This game don't exist"));
    }

    @Override
    public boolean deleteGameById(final String id) {
        return this.gameRepository.findById(Long.valueOf(id)).map(game -> {
            gameRepository.deleteById(Long.valueOf(id));
            return true;
        }).orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND,"This game don't exist"));
    }

    @Override
    public List<Game> getAll() {
        return this.gameRepository.findAll();
    }


}
