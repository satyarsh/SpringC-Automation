package com.home.SpringBootAutomation.repository;


import com.home.SpringBootAutomation.model.Person;
import com.home.SpringBootAutomation.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Query("select oo from ticketEntity oo where oo.applicant.username=:applicant and oo.deleted=true")
    List<Ticket> findByApplicant(Person applicant);

    @Query("select oo from ticketEntity oo where oo.ticketTimeStamp=:ticketDate and oo.deleted=true")
    List<Ticket> findByDate(LocalDateTime ticketDate);


}
