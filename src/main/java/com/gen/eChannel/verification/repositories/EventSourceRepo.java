package com.gen.eChannel.verification.repositories;

import com.gen.eChannel.verification.entities.EventSource;
import com.gen.eChannel.verification.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventSourceRepo extends JpaRepository<EventSource, Long> {

    List<EventSource> findByStatus(Status status);

    @Query("SELECT COUNT(es) FROM EventSource es WHERE es.status.name = :name")
    long countByStatusName(@Param("name") String name);

    List<EventSource> findByUserIsNotNull();

    List<EventSource> findByStatusName(String name);

}
