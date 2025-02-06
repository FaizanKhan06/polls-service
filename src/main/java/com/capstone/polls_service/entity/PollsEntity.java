package com.capstone.polls_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "polls_entity")

public class PollsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poll_id")
    private int pollId;

    @Column(name = "community_id")
    private int communityId;

    @Column(name = "poll_start_date")
    private LocalDateTime pollStartDate;

    @Column(name = "poll_result")
    private String pollResult;

    @Column(name = "poll_end")
    private boolean pollEnd;
}
