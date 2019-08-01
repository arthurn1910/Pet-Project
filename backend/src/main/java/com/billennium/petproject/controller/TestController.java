package com.billennium.petproject.controller;

import com.billennium.petproject.model.TestEntity;
import com.billennium.petproject.service.TestService;
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
@RequestMapping("test")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TestController extends BaseController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("status/{status}")
    public ResponseEntity testsByStatus(@PathVariable String status) {
        List<TestEntity> tests = testService.getTestsByStatus(status);
        return new ResponseEntity(tests, OK);
    }

    @GetMapping("list")
    public ResponseEntity<List<TestEntity>> getAllTests() {
        List<TestEntity> list = testService.getAllTests();
        return new ResponseEntity<List<TestEntity>>(list, OK);
    }

    @PostMapping("save")
    public ResponseEntity<Void> addTest(@RequestBody TestEntity test) {
        boolean created = testService.addTest(test);
        return validateCreationAndCreateResponse(created, test);
    }

    @PutMapping("update")
    public ResponseEntity<TestEntity> updateTest(@RequestBody TestEntity test) {
        testService.updateTest(test);
        return new ResponseEntity<TestEntity>(test, OK);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable("id") Integer id) {
        testService.deleteTest(id);
        return new ResponseEntity<Void>(NO_CONTENT);
    }

    @GetMapping("candidate/{candidateId}")
    public ResponseEntity testsByCandidateId(@PathVariable Integer candidateId) {
        TestEntity test = testService.getTestsByCandidateId(candidateId);
        return new ResponseEntity(test, OK);
    }
}
