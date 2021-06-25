package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order")
@NoArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinTable(name = "person")
    private Person person;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "order_details_id")
    private List<OrderDetails> orderDetails;
}
