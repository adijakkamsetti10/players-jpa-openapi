package com.demo.jpa.openapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.jpa.openapi.model.Players;

@Repository
public interface PlayersRepository extends JpaRepository<Players, Long> {

}
