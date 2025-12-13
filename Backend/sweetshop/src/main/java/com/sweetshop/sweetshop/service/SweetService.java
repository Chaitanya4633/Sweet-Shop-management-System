package com.sweetshop.sweetshop.service;

import com.sweetshop.sweetshop.exception.OutOfStockException;
import com.sweetshop.sweetshop.model.Sweet;
import com.sweetshop.sweetshop.repository.SweetRepository;
import org.springframework.stereotype.Service;

@Service
public class SweetService {

    private final SweetRepository sweetRepository;

    public SweetService(SweetRepository sweetRepository) {
        this.sweetRepository = sweetRepository;
    }

    public Sweet addSweet(String name, String category, double price, int quantity) {
        Sweet sweet = new Sweet(name, category, price, quantity);
        return sweetRepository.save(sweet);
    }

    public Sweet purchaseSweet(Long sweetId) {
        Sweet sweet = sweetRepository.findById(sweetId)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));

        if (sweet.getQuantity() <= 0) {
            throw new OutOfStockException("Sweet is out of stock");
        }

        sweet.decreaseQuantity(1);
        return sweetRepository.save(sweet);
    }
}
