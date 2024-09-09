package com.example.game_service_api.controller.impl;

import com.example.game_service_api.commons.entities.Game;
import com.example.game_service_api.controller.GameApi;
import com.example.game_service_api.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController implements GameApi {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public ResponseEntity<Game> saveGame(@RequestBody Game game){
        Game gameCreated = gameService.saveGame(game);
        return ResponseEntity.ok(gameCreated);
    }

    @Override
    public ResponseEntity<Game> getGameById(final String id) {
        return ResponseEntity.ok(this.gameService.getGameById(id));
    }

    @Override
    public ResponseEntity<Game> updateGameById(final String id, final Game game) {
        return ResponseEntity.ok(this.gameService.updateGameById(id, game));
    }

    @Override
    public ResponseEntity deleteById(final String id) {
        if (gameService.deleteGameById(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Game>> getAllGames() {
        return new ResponseEntity<>(gameService.getAll(), HttpStatus.OK);
    }


}
