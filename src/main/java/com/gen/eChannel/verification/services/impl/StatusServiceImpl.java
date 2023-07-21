package com.gen.eChannel.verification.services.impl;

import com.gen.eChannel.verification.dto.StatusDto;
import com.gen.eChannel.verification.entities.Status;
import com.gen.eChannel.verification.exceptions.ResourceNotFoundException;
import com.gen.eChannel.verification.repositories.StatusRepo;
import com.gen.eChannel.verification.services.StatusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StatusRepo statusRepo;


    public StatusServiceImpl(StatusRepo statusRepo, ModelMapper modelMapper) {
        this.statusRepo = statusRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public StatusDto CreateStatus(StatusDto statusDto) {

        Status status = modelMapper.map(statusDto, Status.class);

        Status savedStatus = statusRepo.save(status);
        return modelMapper.map(savedStatus, StatusDto.class);
    }

    @Override
    public List<StatusDto> getAllStatus() {

        List<Status> statusList = statusRepo.findAll();
        List<StatusDto> statusDtoList = statusList.stream().map(status ->
                modelMapper.map(status, StatusDto.class)).collect(Collectors.toList());
        return statusDtoList;
    }

    @Override
    public StatusDto getStatusById(Long statusId) {

        Status status = this.statusRepo.findById(statusId)
                .orElseThrow(() -> new ResourceNotFoundException("Status", " Id ", statusId));

        return modelMapper.map(status, StatusDto.class);
    }
}
