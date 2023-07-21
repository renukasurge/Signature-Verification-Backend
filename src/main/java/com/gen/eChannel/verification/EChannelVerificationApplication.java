package com.gen.eChannel.verification;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EChannelVerificationApplication {

    static Logger logger = LoggerFactory.getLogger(EChannelVerificationApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(EChannelVerificationApplication.class, args);

        logger.info("eChannel Server Started...");
    }

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        return modelMapper;
    }


}

