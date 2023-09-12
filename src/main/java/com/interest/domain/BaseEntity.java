package com.interest.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class) // activating Entity Auditing
@MappedSuperclass
public abstract class BaseEntity {
    @CreatedDate
    @Column(name = "crated_at", updatable = false)
    LocalDateTime createdAt;

    @LastModifiedDate
    LocalDateTime lastModifiedAt;
}
