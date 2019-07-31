package com.billennium.petproject.controller;

import com.billennium.petproject.model.TestAnswerEntity;
import com.billennium.petproject.service.TestAnswerService;
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
@RequestMapping("testAnswer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TestAnswerController extends BaseController {

    private final TestAnswerService testAnswerService;

    public TestAnswerController(TestAnswerService testAnswerService) {
        this.testAnswerService = testAnswerService;
    }

    @GetMapping("content/{content}")
    public ResponseEntity testAnswersByContent(@PathVariable String content) {
        List<TestAnswerEntity> answers = testAnswerService.getTestAnswersByContent(content);
        return new ResponseEntity(answers, OK);
    }

    @GetMapping("list")
    public ResponseEntity<List<TestAnswerEntity>> getAllTestAnswers() {
        List<TestAnswerEntity> list = testAnswerService.getAllTestAnswers();
        return new ResponseEntity<List<TestAnswerEntity>>(list, OK);
    }

    @PostMapping("save")
    public ResponseEntity<Void> addTestAnswer(@RequestBody TestAnswerEntity answer) {
        boolean created = testAnswerService.addTestAnswer(answer);
        return validateCreationAndCreateResponse(created, answer);
    }

    @PutMapping("update")
    public ResponseEntity<TestAnswerEntity> updateTestAnswer(@RequestBody TestAnswerEntity answer) {
        testAnswerService.updateTestAnswer(answer);
        return new ResponseEntity<TestAnswerEntity>(answer, OK);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteTestAnswer(@PathVariable("id") Integer id) {
        testAnswerService.deleteTestAnswer(id);
        return new ResponseEntity<Void>(NO_CONTENT);
    }

    @GetMapping("test/{testId}")
    public ResponseEntity testAnswersByTestId(@PathVariable Integer testId) {
        List<TestAnswerEntity> answers = testAnswerService.getTestAnswersByTestId(testId);
        return new ResponseEntity(answers, OK);
    }

    @GetMapping("answer/{answerId}")
    public ResponseEntity testAnswersByAnswerId(@PathVariable Integer answerId) {
        List<TestAnswerEntity> answers = testAnswerService.getTestAnswersByAnswerId(answerId);
        return new ResponseEntity(answers, OK);
    }
}
