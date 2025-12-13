package com.sweetshop.sweetshop.service;

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
}
