package com.example.validateForm.Controller;

import com.example.validateForm.Service.ValidateFormService;
import com.example.validateForm.model.ResultDetail;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validate")
@CrossOrigin(origins = "*")
public class ValidateFormController {
    private ValidateFormService validateFormService;

    public ValidateFormController(
            ValidateFormService validateFormService
    ) {
        this.validateFormService = validateFormService;
    }

    @PostMapping("")
    public Boolean check(@RequestBody ResultDetail validateForm) {

        return validateFormService.checkForm(validateForm);
    }
}
