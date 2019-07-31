package com.billennium.petproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "TEST")
public class TestEntity extends BaseEntity {

    @OneToOne(optional = true)
    @JoinColumn(name = "CANDIDATE_ID")
    private CandidateEntity candidate;

    @Column(name = "STATUS", nullable = false, length = 60)
    private String status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TEST_QUESTION",
            joinColumns = @JoinColumn(name = "TEST_ID"),
            inverseJoinColumns = @JoinColumn(name = "QUESTION_ID")
    )
    @JsonBackReference
    private List<QuestionEntity> questions;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "test")
    private List<TestAnswerEntity> testAnswers;

    public CandidateEntity getCandidate() {
        return candidate;
    }

    public void setCandidate(CandidateEntity candidate) {
        this.candidate = candidate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }

    public List<TestAnswerEntity> getTestAnswers() {
        return testAnswers;
    }

    public void setTestAnswers(List<TestAnswerEntity> testAnswers) {
        this.testAnswers = testAnswers;
    }
}
