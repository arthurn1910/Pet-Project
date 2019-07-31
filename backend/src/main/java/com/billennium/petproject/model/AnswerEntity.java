package com.billennium.petproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "ANSWER")
public class AnswerEntity extends BaseEntity {

    @Column(name = "CONTENT", nullable = false, length = 200)
    private String content;

    @Column(name = "IS_CORRECT", nullable = false)
    private boolean isCorrect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID", nullable = false)
    @JsonBackReference
    private QuestionEntity question;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "answer")
    private List<TestAnswerEntity> testAnswers;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public List<TestAnswerEntity> getTestAnswers() {
        return testAnswers;
    }

    public void setTestAnswers(List<TestAnswerEntity> testAnswers) {
        this.testAnswers = testAnswers;
    }
}
