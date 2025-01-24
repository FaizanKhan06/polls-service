package com.capstone.polls_service.entity;

import java.time.LocalDate;
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
@Table(name="polls")

public class PollsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="polls_id")
    private int pollId;

    @Column(name="poll_start")
    private LocalDateTime pollStart;

    @Column(name="poll_end")
    private LocalDate pollEnd;

    @Column(name="poll_result")
    private int pollResult;

    @Column(name="request_id")
    private int requestId;
}
      