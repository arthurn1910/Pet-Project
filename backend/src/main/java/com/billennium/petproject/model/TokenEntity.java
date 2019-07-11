package com.billennium.petproject.model;

import org.hibernate.annotations.OptimisticLock;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "TOKEN")
public class TokenEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "TOKEN_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TOKEN_SEQ", sequenceName = "TOKEN_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "VALUE", nullable = false, length = 60)
    private String value;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "VALID_DATE", nullable = false)
    @OptimisticLock(excluded = true)
    @UpdateTimestamp
    private Date valid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
