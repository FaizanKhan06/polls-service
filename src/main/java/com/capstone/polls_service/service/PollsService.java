package com.capstone.polls_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.capstone.polls_service.entity.PollsEntity;
import com.capstone.polls_service.pojo.DateTimePojo;
import com.capstone.polls_service.pojo.PollVotesPojo;
import com.capstone.polls_service.pojo.PollsPojo;
import com.capstone.polls_service.pojo.RequestPojo;
import com.capstone.polls_service.repository.PollsRepository;

@Service
public class PollsService {

    @Autowired
    PollsRepository pollsRepository;

    private PollsPojo convertToPojo(PollsEntity entity) {
        PollsPojo pollsPojo = new PollsPojo();
        BeanUtils.copyProperties(entity, pollsPojo);
        RestClient restClient = RestClient.create();
        List<RequestPojo> requests = restClient.get()
                .uri("http://localhost:5003/api/requests/communities/" + entity.getCommunityId())
                .retrieve().body(new ParameterizedTypeReference<List<RequestPojo>>() {
                });

        List<PollVotesPojo> votes = restClient.get()
                .uri("http://localhost:5008/api/poll-vote/" + entity.getPollId())
                .retrieve().body(new ParameterizedTypeReference<List<PollVotesPojo>>() {
                });
        pollsPojo.setAllRequests(requests);
        pollsPojo.setAllPollVotes(votes);
        return pollsPojo;
    }

    public List<PollsEntity> getAllPolls() {
        return pollsRepository.findAll();
    }

    public PollsPojo getActivePoll(int communityId) {
        List<PollsEntity> pollsEntity = pollsRepository.findByCommunityIdAndPollEnd(communityId, false);
        if (pollsEntity.size() == 1) {
            return convertToPojo(pollsEntity.get(0));
        }
        return null;
    }

    public PollsPojo addAPoll(int communityId) {
        if (getActivePoll(communityId) != null) {
            return null;
        }
        PollsEntity pollsEntity = new PollsEntity();

        RestClient restClient = RestClient.create();
        DateTimePojo dateTimePojo = restClient.put().uri("http://localhost:5010/api/time")
                .body(new DateTimePojo(0, LocalDateTime.now())).retrieve().body(DateTimePojo.class);
        pollsEntity.setPollStartDate(dateTimePojo.getDateTime());

        pollsEntity.setPollResult(null);
        pollsEntity.setPollEnd(false);
        pollsEntity.setCommunityId(communityId);

        return convertToPojo(pollsRepository.saveAndFlush(pollsEntity));
    }

    public PollsEntity updatePoll(PollsEntity editedPoll) {
        return pollsRepository.save(editedPoll);
    }

    public void deletePoll(int pollId, String pollResult) {
        PollsEntity pollsEntity = pollsRepository.findById(pollId).orElse(null);
        if (pollsEntity != null) {
            pollsEntity.setPollResult(pollResult);
            pollsEntity.setPollEnd(true);
            pollsRepository.save(pollsEntity);
        }
    }
}
