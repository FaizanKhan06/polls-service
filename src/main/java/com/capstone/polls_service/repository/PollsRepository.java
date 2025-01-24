package com.capstone.polls_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.polls_service.entity.PollsEntity;

public interface PollsRepository extends JpaRepository<PollsEntity,Integer>{

}