package com.billennium.petproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OptimisticLock;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "TOKEN")
public class TokenEntity extends BaseEntity {

    @Column(name = "VALUE", nullable = false, length = 60)
    private String value;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "VALID_DATE", nullable = false)
    @OptimisticLock(excluded = true)
    @UpdateTimestamp
    private Date valid;

    @OneToOne(optional = true)
    @JoinColumn(name = "CANDIDATE_ID")
    @JsonBackReference
    private CandidateEntity candidate;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getValid() {
        return valid;
    }

    public void setValid(Date valid) {
        this.valid = valid;
    }
}
