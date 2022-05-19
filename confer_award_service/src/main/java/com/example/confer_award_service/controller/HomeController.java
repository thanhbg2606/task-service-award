package com.example.confer_award_service.controller;

import com.example.confer_award_service.entity.ResponseObject;
import com.example.confer_award_service.entity.ResultDetail;
import com.example.confer_award_service.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class HomeController {

    @Autowired
    private IHomeService homeService;

    @PostMapping("/submit")
    public ResponseEntity<ResponseObject> submitForm(@RequestBody ResultDetail resultDetail) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Submit successfully", homeService.SubmitForm(resultDetail))
        );
    }
}
