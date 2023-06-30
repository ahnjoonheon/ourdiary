package com.example.ourdiary.applock;

import com.example.ourdiary.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "app_lock")
public class AppLock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lock_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "lock_type", nullable = false, length = 20)
    private String lockType;

    @Column(name = "lock_value", nullable = false, length = 200)
    private String lockValue;

}