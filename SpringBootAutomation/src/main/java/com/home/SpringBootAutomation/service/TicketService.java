package com.home.SpringBootAutomation.service;

import com.home.SpringBootAutomation.model.Ticket;

import java.time.LocalDate;
import java.util.List;

public interface TicketService {
    Ticket save(Ticket ticket);
    Ticket edit(Ticket ticket);
    Ticket remove(Ticket ticket);
    Ticket logicalRemove(Long id);
    List<Ticket> findAll();
    Ticket findById(Long id);
    List<Ticket> findByApplicant(String applicant);
    List<Ticket> findByDate(LocalDate Date);

}