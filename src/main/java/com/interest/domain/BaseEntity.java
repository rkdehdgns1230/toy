package com.interest.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@EntityListeners(EnableJpaAuditing.class)
@MappedSuperclass
public abstract class BaseEntity {
    @CreatedDate
    @Column(name = "crated_at", updatable = false)
    LocalDateTime createdAt;

    @LastModifiedDate
    LocalDateTime lastModifiedAt;
}
