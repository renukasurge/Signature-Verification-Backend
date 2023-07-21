package com.gen.eChannel.verification.services;

import com.gen.eChannel.verification.dto.EventSourceDto;
import com.gen.eChannel.verification.dto.EventSourceSignatureVerificationDto;
import com.gen.eChannel.verification.dto.EventSourceStatusDto;

import java.util.ArrayList;
import java.util.List;

public interface EventSourceService {

    EventSourceDto createEventSource(EventSourceDto eventSourceDto, String statusName, Long userId);

    EventSourceDto getSignatureEventSourceById(Long signatureEventSourceId);

    EventSourceDto updateSignatureEventSources(EventSourceDto eventSourceDto, Long userId, Long eventSourceId, String statusName);


    List<EventSourceSignatureVerificationDto> getAllSignatureVerificationByStatus(String statusName);

    List<EventSourceDto> getAssignedSignatureEvents();

    //void assignRequestsToCurrentUser(List<Long> eventSourceId, Long userId, Long statusId);

    EventSourceStatusDto getSignatureVerificationStats();

    void assignRequestsToCurrentUsers(List<Long> eventSignatureIds, Long userId, String statusName);

    public List<EventSourceDto> getAssignedEventsByUserId(String statusName, Long userId) ;

}
