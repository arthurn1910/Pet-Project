package com.billennium.petproject.controller;

import com.billennium.petproject.model.AnswerEntity;
import com.billennium.petproject.service.AnswerService;
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
@RequestMapping("answer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AnswerController extends BaseController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("content/{content}")
    public ResponseEntity answersByContent(@PathVariable String content) {
        List<AnswerEntity> answers = answerService.getAnswersByContent(content);
        return new ResponseEntity(answers, OK);
    }

    @GetMapping("list")
    public ResponseEntity<List<AnswerEntity>> getAllAnswers() {
        List<AnswerEntity> list = answerService.getAllAnswers();
        return new ResponseEntity<List<AnswerEntity>>(list, OK);
    }

    @PostMapping("save")
    public ResponseEntity<Void> addAnswer(@RequestBody AnswerEntity answer) {
        boolean created = answerService.addAnswer(answer);
        return validateCreationAndCreateResponse(created, answer);
    }

    @PutMapping("update")
    public ResponseEntity<AnswerEntity> updateAnswer(@RequestBody AnswerEntity answer) {
        answerService.updateAnswer(answer);
        return new ResponseEntity<AnswerEntity>(answer, OK);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable("id") Integer id) {
        answerService.deleteAnswer(id);
        return new ResponseEntity<Void>(NO_CONTENT);
    }

    @GetMapping("question/{questionId}")
    public ResponseEntity answersByCategoryId(@PathVariable Integer questionId) {
        List<AnswerEntity> answers = answerService.getAnswersByQuestionId(questionId);
        return new ResponseEntity(answers, OK);
    }
}
