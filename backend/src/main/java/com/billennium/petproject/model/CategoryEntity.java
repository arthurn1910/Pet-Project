package com.billennium.petproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
public class CategoryEntity extends BaseEntity {

    @Column(name = "NAME", nullable = false, length = 60, unique = true)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<QuestionEntity> questions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }
}
