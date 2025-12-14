package com.sweetshop.sweetshop.controller;

import com.sweetshop.sweetshop.model.Sweet;
import com.sweetshop.sweetshop.repository.SweetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sweets")
public class SweetController {

    private final SweetRepository repo;

    public SweetController(SweetRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Sweet> getAll() {
        return repo.findAll();
    }

    @GetMapping("/search")
    public List<Sweet> search(@RequestParam String q) {
        return repo.findByNameContainingIgnoreCase(q);
    }

    @PostMapping
    public Sweet add(@RequestBody Sweet sweet) {
        return repo.save(sweet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @PostMapping("/{id}/buy")
    public Sweet buy(@PathVariable Long id) {
        Sweet s = repo.findById(id).orElseThrow();
        if (s.getQuantity() <= 0) {
            throw new RuntimeException("Out of stock");
        }
        s.setQuantity(s.getQuantity() - 1);
        return repo.save(s);
    }
}
