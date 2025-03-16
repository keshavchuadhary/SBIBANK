package sbibank.web.app.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String txId;

    private Double amount;
    private Double txFee;
    private String sender;
    private String receiver;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime createdAt;

    private Status status;
    private Type type;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
