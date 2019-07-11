package com.billennium.petproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CANDIDATE")
public class CandidateEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "CANDIDATE_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CANDIDATE_SEQ", sequenceName = "CANDIDATE_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FULL_NAME", nullable = false, length = 60)
    private String fullName;

    @Column(name = "EMAIL", nullable = false, length = 60, unique = true)
    private String email;

    @OneToOne(optional = true)
    @JoinColumn(name = "TOKEN_ID")
    private TokenEntity token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TokenEntity getToken() {
        return token;
    }

    public void setToken(TokenEntity token) {
        this.token = token;
    }
}
