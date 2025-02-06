package com.capstone.polls_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.polls_service.entity.PollsEntity;

public interface PollsRepository extends JpaRepository<PollsEntity, Integer> {
    List<PollsEntity> findByCommunityIdAndPollEnd(int communityId, boolean pollEnd);
}