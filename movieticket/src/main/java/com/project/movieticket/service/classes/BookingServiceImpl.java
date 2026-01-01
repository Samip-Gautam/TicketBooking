package com.project.movieticket.service.classes;

import com.project.movieticket.entity.Theater;
import com.project.movieticket.repository.TheaterRepository;
import com.project.movieticket.service.interfaces.BookingService;
import com.project.movieticket.service.interfaces.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    @Value("${app.regular-price:200}")
    private double regularPrice;

    @Value("${app.premium-price:280}")
    private double premiumPrice;

    @Value("${app.vip-price:450}")
    private double vipPrice;

    private final TheaterService theaterService;

    @Override
    public double calculatePrice(Long theaterId, int seatCount) {
        Theater theater = theaterService.getTheaterById(theaterId);

        double basePrice = switch (theater.getType()) {
            case 1 -> regularPrice;
            case 2 -> premiumPrice;
            case 3 -> vipPrice;
            default -> regularPrice;
        };

        double availabilityMultiplier = getAvailabilityMultiplier(theater);
        return basePrice * seatCount * availabilityMultiplier;
    }

    private double getAvailabilityMultiplier(Theater theater) {
        double occupancy = (double) theater.getBookedSeats() / theater.getTotalSeats();
        if (occupancy > 0.8) return 1.5;
        if (occupancy > 0.5) return 1.2;
        return 1.0;  // Normal pricing
    }
}
