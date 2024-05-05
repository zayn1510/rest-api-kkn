package com.api.kkn.app.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Table(name = "tbl_logs")
@Entity(name = "tbl_logs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "host",length = 100,nullable = true)
    String host;

    @Column(name = "user_agent")
    String userAgent;
    @Column(name = "message")
    String message;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
