package com.demo.jpa.openapi.service;

import java.util.List;

import com.demo.jpa.openapi.exception.RecordNotFoundException;
import com.demo.jpa.openapi.model.Players;

public interface PlayersService {
	
	public List<Players> getPlayers();
	
	public Players createPlayer(Players player) throws RecordNotFoundException;
	
	public Players updatePlayer(Players player, Long id) throws RecordNotFoundException;
	
	public void deletePlayersById(Long id) throws RecordNotFoundException;

}
