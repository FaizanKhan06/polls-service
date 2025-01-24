package com.capstone.polls_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.polls_service.entity.PollsEntity;
import com.capstone.polls_service.repository.PollsRepository;

@Service
public class PollsService {

    @Autowired
    PollsRepository pollsRepository;

    public List<PollsEntity> getAllPolls(){
       return pollsRepository.findAll();
    }

    public PollsEntity getAPoll(int pollId){
        PollsEntity pollsEntity = pollsRepository.findById(pollId).orElse(null);
        return pollsEntity;
    }

    public PollsEntity addAPoll(PollsEntity newPoll){
        return pollsRepository.saveAndFlush(newPoll);
    }

    public PollsEntity updatePoll(PollsEntity editedPoll){
        return pollsRepository.save(editedPoll);
    }

    public void deletePoll(int pollId){
        pollsRepository.deleteById(pollId);
    }
}
