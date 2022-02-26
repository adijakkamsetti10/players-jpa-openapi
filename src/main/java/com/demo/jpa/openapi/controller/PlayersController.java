package com.demo.jpa.openapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jpa.openapi.model.Players;
import com.demo.jpa.openapi.service.PlayersService;
import com.demo.jpa.openapi.exception.RecordNotFoundException;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/players")
public class PlayersController {

	@Autowired
	private PlayersService service;

	@Operation(summary = "This is to fetch All the Players stored in database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Details of All the Players", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "Page not found", content = @Content) })
	@GetMapping
	public ResponseEntity<List<Players>> getAllPlayers() {
		List<Players> list = service.getPlayers();

		return new ResponseEntity<List<Players>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@Operation(summary = "This is to create/update  the Players in the database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = " Players details saved/updated in database", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = " Page Not Found", content = @Content) })
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Players> createOrUpdateEmployee(@RequestBody Players player) throws RecordNotFoundException {
		Players updated = service.createPlayer(player);
		return new ResponseEntity<Players>(updated, new HttpHeaders(), HttpStatus.OK);
	}

    @Operation(summary = "This is to udate  the Players in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = " Player details updated in database",
            content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
            description = " Page Not Found",
            content = @Content)
    })
	@PutMapping("/{id}")
	public ResponseEntity<Players> updateParticipants(@RequestBody Players player, @PathVariable Long id)
			throws RecordNotFoundException {

		Players updated = service.updatePlayer(player, id);

		return new ResponseEntity<Players>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@Operation(summary = "This is to delete  the Players in the database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = " Player deleted from the database", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = " Page Not Found", content = @Content) })

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePlayersId(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deletePlayersById(id);
		return new ResponseEntity<String>("Record Deleted succesfullys", new HttpHeaders(), HttpStatus.OK);
	}

}
