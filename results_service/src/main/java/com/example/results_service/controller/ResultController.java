package com.example.results_service.controller;

import com.example.results_service.entity.ResponseObject;
import com.example.results_service.entity.Result;
import com.example.results_service.service.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/result")
@CrossOrigin(origins = "*")
public class ResultController {
    @Autowired
    private IResultService resultService;


    @PostMapping("")
    public ResponseEntity<ResponseObject> createResult(@RequestBody Result result){
        result.setStatus(0);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Insert result successfully", resultService.save(result))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateResult(@RequestBody Result result, @PathVariable("id") Long id){
        result.setId(id);
        result.setStatus(1);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Update result successfully", resultService.save(result))
        );
    }
    @GetMapping("/{code}")
    public ResponseEntity<ResponseObject> getResult(@PathVariable(name = "code") String  code){
        Optional<Result> foundResult = Optional.ofNullable(resultService.findByCode(code));
        return foundResult.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Query result successfully", foundResult)
        ) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("FALSE", "Cannot find result with id = " + code, "")
        );
    }
}
