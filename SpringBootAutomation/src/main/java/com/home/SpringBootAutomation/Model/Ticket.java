package com.home.SpringBootAutomation.Model;

import com.home.SpringBootAutomation.model.enums.Status;
import com.home.SpringBootAutomation.repository.TicketRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity(name = "ticketEntity")
@Table(name = "ticket_tbl")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "t_date")
    private LocalDate ticketDate;

    @Column(name = "t_time")
    private LocalTime ticketTime;

    @Column(name = "t_applicant")
    private String applicant;

    @Column(name = "t_request" , length = 255)
    private String request;

    @Column(name = "t_group")
    private String group;

    @Column(name = "t_status")
    private String status;

    @Column(name = "t_active")
    private Boolean active;
}
