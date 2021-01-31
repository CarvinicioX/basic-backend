package com.sinch.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
public class Sale extends RepresentationModel<Sale> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long saleId;

    private String product;

    private Integer quantity;

    private Float total;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
