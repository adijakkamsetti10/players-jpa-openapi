package com.demo.jpa.openapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.jpa.openapi.exception.RecordNotFoundException;
import com.demo.jpa.openapi.model.Players;
import com.demo.jpa.openapi.repository.PlayersRepository;

@Service
public class PlayerServiceImpl implements PlayersService {
	
	@Autowired
	PlayersRepository playersRepository;

	public List<Players> getPlayers() {

		List<Players> playersList = playersRepository.findAll();

		if (playersList.size() > 0) {
			return playersList;
		} else {
			return new ArrayList<Players>();
		}

	}

	public Players createPlayer(Players player) throws RecordNotFoundException {
		if (player.getId() != null) {
			player.setId(null);
		}
		return playersRepository.save(player);
	}

	public Players updatePlayer(Players player, Long id) throws RecordNotFoundException {
		Optional<Players> Players = playersRepository.findById(id);

		if (Players.isPresent()) {
			return Players.get();
		} else {
			if (player.getId() != null) {
				player.setId(null);
			}
			return playersRepository.save(player);
		}
	}

	public void deletePlayersById(Long id) throws RecordNotFoundException {
		Optional<Players> Players = playersRepository.findById(id);

		if (Players.isPresent()) {
			playersRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

}
