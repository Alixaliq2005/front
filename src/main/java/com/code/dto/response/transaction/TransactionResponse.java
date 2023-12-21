package com.code.dto.response.transaction;

import com.code.model.TransactionType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionResponse {

    Long transactionId;

    String senderName;

    String receiverName;

    TransactionType transactionType;

    Double amount;

    String description;


}
