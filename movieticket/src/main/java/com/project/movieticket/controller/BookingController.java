package com.project.movieticket.controller;

import com.project.movieticket.service.interfaces.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("/price")
    public ResponseEntity<Double> calculatePrice(@RequestBody PriceRequest request) {
        double price = bookingService.calculatePrice(request.theaterId(), request.seatCount());
        return ResponseEntity.ok(price);
    }

    @GetMapping("/plans")
    public ResponseEntity<String> getAllPlans() {
        return ResponseEntity.ok("""
                DYNAMIC PRICING PLANS:
                REGULAR (Type 1): ₹200/seat
                PREMIUM (Type 2): ₹280/seat  
                VIP (Type 3): ₹450/seat
                + Surge pricing (50%+ full: +20%, 80%+ full: +50%)
                """);
    }

    @GetMapping("/price/{theaterId}/{seatCount}")
    public ResponseEntity<Double> getPrice(@PathVariable Long theaterId, @PathVariable int seatCount) {
        double price = bookingService.calculatePrice(theaterId, seatCount);
        return ResponseEntity.ok(price);
    }
}

record PriceRequest(Long theaterId, int seatCount) {}
