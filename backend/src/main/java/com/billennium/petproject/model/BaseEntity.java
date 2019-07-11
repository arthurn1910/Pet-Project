package com.billennium.petproject.model;


import org.hibernate.annotations.OptimisticLock;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

import static com.billennium.petproject.util.DateTimeUtils.now;

@MappedSuperclass
public abstract class BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ENTITY_CREATED", nullable = false)
    @OptimisticLock(excluded = true)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ENTITY_UPDATED", nullable = false)
    @OptimisticLock(excluded = true)
    @UpdateTimestamp
    private Date updated;

    public BaseEntity() {
        created = now();
        updated = created;
    }

    protected BaseEntity(Date createdOn) {
        this.created = createdOn;
        this.updated = createdOn;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updatedDate) {
        updated = updatedDate;
    }
}
