package org.officina.web.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "car")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(length = 10)
    private String plate;

    @CreationTimestamp
    @Column(name= "arrive", updatable = false)
    private LocalDateTime arrive;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;

    @Column(name = "start_check")
    private LocalDateTime startCheck;

    @Column(name = "end_check")
    private LocalDateTime endCheck;

    @Column(name = "withdraw")
    private LocalDateTime withdraw;
}
