package com.code.dto.request.transaction;

import com.code.model.TransactionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionRequest {

    @Enumerated(EnumType.STRING)
    TransactionType transactionType;

    String senderName;

    String receiverName;

    Double amount;

    String description;

}

