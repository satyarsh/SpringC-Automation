package com.home.SpringBootAutomation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity(name = "responseEntity")
@Table(name = "response_tbl")
public class Response {
    @Id
    @SequenceGenerator(name = "responseSeq" ,  sequenceName = "response_seq" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator ="responseSeq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "response_responder_id" )
    private Person responder;

    @Column(name = "response_response"  , nullable = false , columnDefinition = "NVARCHAR2(255)")
    @Pattern(regexp = "^[a-zA-Zآ-ی\\s]{3,255}$", message = "Invalid Ticket Response")
    @Size(min = 3, max = 255, message = "City Name must be between 3 and 255 characters")
    @NotBlank(message = "Should Not Be Null")
    private String ticketResponse;

    @Column(name = "response_time_stamp" )
    private LocalDateTime responseTimeStamp;

    @Column(name = "response_active")
    private Boolean deleted;

}
