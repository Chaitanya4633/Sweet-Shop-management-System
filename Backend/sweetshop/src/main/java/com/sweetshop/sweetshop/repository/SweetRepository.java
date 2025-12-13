package com.sweetshop.sweetshop.repository;

import com.sweetshop.sweetshop.model.Sweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SweetRepository extends JpaRepository<Sweet, Long> {}
