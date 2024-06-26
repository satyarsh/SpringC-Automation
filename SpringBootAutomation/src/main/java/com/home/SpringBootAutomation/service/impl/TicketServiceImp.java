package com.home.SpringBootAutomation.service.impl;


import com.home.SpringBootAutomation.enums.Status;
import com.home.SpringBootAutomation.exceptions.NoContentException;
import com.home.SpringBootAutomation.model.Person;
import com.home.SpringBootAutomation.model.Ticket;
import com.home.SpringBootAutomation.repository.PersonRepository;
import com.home.SpringBootAutomation.repository.TicketRepository;
import com.home.SpringBootAutomation.service.PersonService;
import com.home.SpringBootAutomation.service.TicketService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TicketServiceImp implements TicketService {
    private final TicketRepository ticketRepository;
    private final PersonServiceImpl personService;

    public TicketServiceImp(TicketRepository ticketRepository, PersonServiceImpl personService) {
        this.ticketRepository = ticketRepository;
        this.personService = personService;
    }

    @Override
    public Ticket save(Ticket ticket) throws NoContentException {
        log.info("Service-Ticket-Save");
//        Person person = personService.findPersonByUserNameAndDeletedFalse(Principal.class.getName()).orElseThrow(
//                () -> new NoContentException("No Person Found with username : " + Principal.class.getName())
//        );
//        ticket.setApplicant(person.get());
        ticket.setStatus(Status.postponed);
        ticket.setDeleted(false);
        ticket.setTicketTimeStamp(LocalDateTime.now());
        ticketRepository.save(ticket);
        return ticket;
    }

    @Override
    @Transactional
    public Ticket edit(Ticket ticket) throws NoContentException {
        log.info("Service-Ticket-Edit");
        ticketRepository.findById(ticket.getId()).orElseThrow(
                () -> new NoContentException("No Ticket Found with id : " + ticket.getId()));
        return ticketRepository.save(ticket);
    }


    @Override
    @Transactional
    public Ticket editStatusById(Long id, Status status) throws NoContentException {
        log.info("Service-Ticket-Edit");
        Optional<Ticket> ticket = ticketRepository.findById(id);
        ticket.orElseThrow(
                () -> new NoContentException("No Ticket Found with id : " + id));
        ticket.get().setStatus(status);
        return ticketRepository.save(ticket.get());
    }

    @Override
    public void remove(Ticket ticket) throws NoContentException {
        log.info("Service-Ticket-Remove");
        ticketRepository.findById(ticket.getId()).orElseThrow(
                () -> new NoContentException("No Ticket Found with id : " + ticket.getId()));
        ticketRepository.delete(ticket);
    }

    @Override
    @Transactional
    public Ticket logicalRemove(Long id) throws NoContentException {
        log.info("Service-Ticket-LogicalRemove");
        Ticket ticket = ticketRepository.findById(id).orElseThrow(
                () -> new NoContentException("No Ticket Found with id : " + id));
        ticket.setDeleted(true);
        return ticketRepository.save(ticket);

    }

    @Override
    public List<Ticket> findAll() {
        log.info("Service-Ticket-FindAll");
        List<Ticket> ticketList = ticketRepository.findAll();
        return ticketList;
    }

    @Override
    public List<Ticket> findAllDeletedFalse() {
        log.info("Service-Ticket-FindAllDeletedFalse");
        List<Ticket> ticketList = ticketRepository.findAllDeletedFalse();
        return ticketList;
    }

    @Override
    public List<String> findAllTitle() {
        log.info("Service-Ticket-FindAllTitle");
        List<String> ticketList = ticketRepository.findAllTitle();
        return ticketList;
    }

    @Override
    public List<Ticket> findByTitle(String title) {
        log.info("Service-Ticket-FindByTitle");
        List<Ticket> ticketList = ticketRepository.findByTitle(title);
        return ticketList;
    }

    @Override
    public Ticket findById(Long id) throws NoContentException {
        log.info("Service-Ticket-FindById");
        return ticketRepository.findById(id).orElseThrow(
                () -> new NoContentException("No Ticket Found with id : " + id)
        );
    }


//    @Override
//    public List<Ticket> findByApplicant(Person applicant) throws NoContentException {
//        log.info("Service-Ticket-FindByApplicant");
//        List<Ticket> ticketList = ticketRepository.findByApplicant(applicant);
//        if (!ticketList.isEmpty()){
//            return ticketList;
//        }else throw new NoContentException("Ticket Not Found !");
//    }

    @Override
    public List<Ticket> findByDate(LocalDateTime timeStamp) throws NoContentException {
        log.info("Service-Ticket-FindByDate");
        List<Ticket> ticketList = ticketRepository.findByDate(timeStamp);
        if (!ticketList.isEmpty()) {
            return ticketList;
        } else throw new NoContentException("Ticket Not Found !");
    }
}
