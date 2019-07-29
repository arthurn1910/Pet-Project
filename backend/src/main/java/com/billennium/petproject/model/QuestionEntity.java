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
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "QUESTION")
public class QuestionEntity extends BaseEntity {

    @Column(name = "CONTENT", nullable = false, length = 200)
    private String content;

    @Column(name = "IS_OPEN", nullable = false)
    private boolean isOpen;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "QUESTION_CATEGORY",
            joinColumns = @JoinColumn(name = "QUESTION_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID")
    )
    @JsonBackReference
    private List<CategoryEntity> categories;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    private List<AnswerEntity> answers;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    public List<AnswerEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerEntity> answers) {
        this.answers = answers;
    }
}
