package com.billennium.petproject.controller;

import com.billennium.petproject.model.CandidateEntity;
import com.billennium.petproject.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Long.parseLong;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("candidate")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CandidateController extends BaseController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("email/{email}")
    public ResponseEntity candidatesByContent(@PathVariable String email) {
        List<CandidateEntity> candidates = candidateService.getCandidatesByEmail(email);
        return new ResponseEntity(candidates, OK);
    }

    @GetMapping("list")
    public ResponseEntity<List<CandidateEntity>> getAllCandidates() {
        List<CandidateEntity> list = candidateService.getAllCandidates();
        return new ResponseEntity<List<CandidateEntity>>(list, OK);
    }

    @PostMapping("save")
    public ResponseEntity<Void> addCandidate(@RequestBody CandidateEntity candidate) {
        boolean created = candidateService.addCandidate(candidate);
        return validateCreationAndCreateResponse(created, candidate);
    }

    @PutMapping("update")
    public ResponseEntity<CandidateEntity> updateCandidate(@RequestBody CandidateEntity candidate) {
        candidateService.updateCandidate(candidate);
        return new ResponseEntity<CandidateEntity>(candidate, OK);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable("id") Integer id) {
        candidateService.deleteCandidate(id);
        return new ResponseEntity<Void>(NO_CONTENT);
    }

    @GetMapping("name/{name}")
    public ResponseEntity candidatesByName(@PathVariable String name) {
        List<CandidateEntity> candidates = candidateService.getCandidatesByName(name);
        return new ResponseEntity(candidates, OK);
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity removeCandidate(@PathVariable String id) {
        candidateService.removeCandidate(parseLong(id));
        return new ResponseEntity(HttpStatus.OK);
    }
}
