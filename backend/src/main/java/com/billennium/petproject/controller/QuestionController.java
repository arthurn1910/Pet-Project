package com.billennium.petproject.controller;

import com.billennium.petproject.model.QuestionEntity;
import com.billennium.petproject.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("question")
@CrossOrigin(origins = "*", maxAge = 3600)
public class QuestionController extends BaseController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("content/{content}")
    public ResponseEntity questionsByContent(@PathVariable String content) {
        List<QuestionEntity> questions = questionService.getQuestionsByContent(content);
        return new ResponseEntity(questions, OK);
    }

    @GetMapping("list")
    public ResponseEntity<List<QuestionEntity>> getAllQuestions() {
        List<QuestionEntity> list = questionService.getAllQuestions();
        return new ResponseEntity<List<QuestionEntity>>(list, OK);
    }

    @PostMapping("save")
    public ResponseEntity<Void> addQuestion(@RequestBody QuestionEntity question) {
        boolean created = questionService.addQuestion(question);
        return validateCreationAndCreateResponse(created, question);
    }

    @PutMapping("update")
    public ResponseEntity<QuestionEntity> updateQuestion(@RequestBody QuestionEntity question) {
        questionService.updateQuestion(question);
        return new ResponseEntity<QuestionEntity>(question, OK);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable("id") Integer id) {
        questionService.deleteQuestion(id);
        return new ResponseEntity<Void>(NO_CONTENT);
    }

    @GetMapping("category/{categoryId}")
    public ResponseEntity questionsByCategoryId(@PathVariable Integer categoryId) {
        List<QuestionEntity> questions = questionService.getQuestionsByCategoryId(categoryId);
        return new ResponseEntity(questions, OK);
    }
}
