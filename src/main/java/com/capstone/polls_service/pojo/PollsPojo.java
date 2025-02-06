package com.capstone.polls_service.pojo;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PollsPojo {
    private int pollId;
    private LocalDateTime pollStartDate;
    private String pollResult;
    private int communityId;
    private boolean pollEnd;
    private List<RequestPojo> allRequests;
    private List<PollVotesPojo> allPollVotes;
}
