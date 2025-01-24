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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.polls_service.entity.PollsEntity;
import com.capstone.polls_service.service.PollsService;

@RestController
@RequestMapping("/api/polls")
public class PollsController {
    
    @Autowired
    PollsService pollsService;

    @GetMapping(" ")
    public ResponseEntity<List<PollsEntity>> getAllPolls(){
        return new ResponseEntity<>(pollsService.getAllPolls(),HttpStatus.OK);
    }

    @GetMapping("/{pid}")
    public ResponseEntity<PollsEntity> getAPoll(@PathVariable int pollsId){
        return new ResponseEntity<>(pollsService.getAPoll(pollsId),HttpStatus.OK);
    }

    @PostMapping(" ")
    public ResponseEntity<PollsEntity> addAPoll(@RequestBody PollsEntity newPoll){
        return new ResponseEntity<>(pollsService.addAPoll(newPoll),HttpStatus.OK);
    }

    @PutMapping(" ")
    public ResponseEntity<PollsEntity> updatePoll(PollsEntity editedPoll){
        return new ResponseEntity<>(pollsService.updatePoll(editedPoll),HttpStatus.OK);
    }

    @DeleteMapping("/{pid}")
    public ResponseEntity<Void> deletePoll(@PathVariable("pid")int pollId){
        pollsService.deletePoll(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
