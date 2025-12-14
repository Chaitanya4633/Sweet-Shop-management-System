package com.sweetshop.sweetshop.controller;

import com.sweetshop.sweetshop.model.Sweet;
import com.sweetshop.sweetshop.service.SweetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sweets")
public class SweetController {

    private final SweetService sweetService;

    public SweetController(SweetService sweetService) {
        this.sweetService = sweetService;
    }

    @PostMapping
    public ResponseEntity<Sweet> addSweet(@RequestBody Sweet sweet) {
        Sweet created = sweetService.addSweet(
                sweet.getName(),
                sweet.getCategory(),
                sweet.getPrice(),
                sweet.getQuantity()
        );
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/purchase")
    public ResponseEntity<Sweet> purchaseSweet(@PathVariable Long id) {
        Sweet updated = sweetService.purchaseSweet(id);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<List<Sweet>> getAllSweets() {
        return ResponseEntity.ok(sweetService.getAllSweets());
    }

}
