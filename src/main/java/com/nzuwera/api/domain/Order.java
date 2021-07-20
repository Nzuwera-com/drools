package com.nzuwera.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDERS")
@Entity
public class Order {
    @Id
    @GeneratedValue
    @Type(type = "pg-uuid")
    @Column(name = "ID", unique = true, length = 36)
    private UUID id;
    private Integer orderId;
    private String paymentType;
    private Integer totalPrice;
    private Integer discount;
}
