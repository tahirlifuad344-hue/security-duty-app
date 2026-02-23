package com.example.security.controller;

import com.example.security.service.ShiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/shifts")
@RequiredArgsConstructor
public class ShiftController {

    private final ShiftService service;

    @PostMapping("/generate")
    public void generate(@RequestParam String date) {
        service.generateDailyShift(LocalDate.parse(date));
    }
}
