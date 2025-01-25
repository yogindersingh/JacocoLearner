package com.bper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/numbers")
public class NumberController {

    @GetMapping()
    public ResponseEntity<List<Integer>> getNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(1, 10)
                                      .boxed()
                                      .toList();
        return ResponseEntity.ok(numbers);
    }
}