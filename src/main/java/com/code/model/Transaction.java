package com.code.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    private String senderName;

    private String receiverName;

    private TransactionType transactionType;

    private Double amount;

    private String description;

    @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
                + ", amount=" + amount + ", description=" + description + "]";
    }

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Wallet wallet;

}
