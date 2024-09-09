package com.example.game_service_api.services;

import com.example.game_service_api.commons.entities.Game;

import java.util.List;

public interface GameService {
    public Game saveGame(Game gameRequest);

    Game getGameById(String id);

    Game updateGameById(String id, Game game);

    boolean deleteGameById(String id);

    List<Game> getAll();
}
