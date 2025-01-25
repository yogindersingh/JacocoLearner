package com.bper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculate")
public class CalculationController {

    @GetMapping("/add/{num1}/{num2}")
    public ResponseEntity<CalculationResponse> add(@PathVariable
                                                   double num1, @PathVariable double num2) {
        return ResponseEntity.ok(new CalculationResponse(num1 + num2));
    }

    @GetMapping("/subtract/{num1}/{num2}")
    public ResponseEntity<CalculationResponse> subtract(@PathVariable double num1, @PathVariable double num2) {
        return ResponseEntity.ok(new CalculationResponse(num1 - num2));
    }

    @GetMapping("/multiply/{num1}/{num2}")
    public ResponseEntity<CalculationResponse> multiply(@PathVariable double num1, @PathVariable double num2) {
        return ResponseEntity.ok(new CalculationResponse(num1 * num2));
    }

    @GetMapping("/divide/{num1}/{num2}")
    public ResponseEntity divide(@PathVariable double num1, @PathVariable double num2) {
        if (num2 == 0) {
            return ResponseEntity.badRequest().body("Cannot divide by zero");
        }
        return ResponseEntity.ok(new CalculationResponse(num1 / num2));
    }
}