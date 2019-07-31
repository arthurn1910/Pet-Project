package com.billennium.petproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_ANSWER")
public class TestAnswerEntity extends BaseEntity {

    @Column(name = "CONTENT", nullable = false, length = 200)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEST_ID", nullable = false)
    @JsonBackReference
    private TestEntity test;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ANSWER_ID", nullable = false)
    @JsonBackReference
    private AnswerEntity answer;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TestEntity getTest() {
        return test;
    }

    public void setTest(TestEntity test) {
        this.test = test;
    }

    public AnswerEntity getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerEntity answer) {
        this.answer = answer;
    }
}
