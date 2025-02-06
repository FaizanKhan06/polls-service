package com.capstone.polls_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.polls_service.entity.PollsEntity;
import com.capstone.polls_service.pojo.PollsPojo;
import com.capstone.polls_service.service.PollsService;

@RestController
@RequestMapping("/api/polls")
public class PollsController {

    @Autowired
    PollsService pollsService;

    @GetMapping(" ")
    public ResponseEntity<List<PollsEntity>> getAllPolls() {
        return new ResponseEntity<>(pollsService.getAllPolls(), HttpStatus.OK);
    }

    @GetMapping("/active/{communityId}")
    public ResponseEntity<PollsPojo> getActivePoll(@PathVariable int communityId) {
        return new ResponseEntity<>(pollsService.getActivePoll(communityId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<PollsPojo> addAPoll(@RequestParam int communityId) {
        return new ResponseEntity<>(pollsService.addAPoll(communityId), HttpStatus.OK);
    }

    @PutMapping(" ")
    public ResponseEntity<PollsEntity> updatePoll(PollsEntity editedPoll) {
        return new ResponseEntity<>(pollsService.updatePoll(editedPoll), HttpStatus.OK);
    }

    @DeleteMapping("/{pollId}")
    public ResponseEntity<Void> deletePoll(@PathVariable int pollId, @RequestParam String pollResult) {
        pollsService.deletePoll(pollId, pollResult);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
