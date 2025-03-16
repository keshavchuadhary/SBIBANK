package sbibank.web.app.entity;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uid;

    private String firstName;
    private String lastName;

    @Column(nullable = false, unique = true)
    private String username;

    private LocalDate dob;
    private String tel;
    private String tag;
    private String password;
    private String gender;

    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private List<String> roles;

    @OneToOne(mappedBy = "owner")
    private Card card;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts;
}