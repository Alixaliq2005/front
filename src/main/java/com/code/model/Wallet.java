package com.code.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String walletName;

    private Long accountNumber;

    private Double balance;

    private Integer cvv;

    @JsonFormat//    @JsonFormat(pattern = "MM/yyyy")
    private LocalDateTime endTime;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "wallet")
    @JsonIgnore
    private List<Transaction> transaction;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "wallet")
    @JsonIgnore
    private List<BillPayment> billPayments;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "wallet")
    @JsonIgnore
    private List<BeneficiaryDetail> beneficiaryDetails;

    public Long getWalletId() {
        return null;
    }
}
