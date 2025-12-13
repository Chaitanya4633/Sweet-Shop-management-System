package com.sweetshop.sweetshop.service;

import com.sweetshop.sweetshop.model.Sweet;
import com.sweetshop.sweetshop.repository.SweetRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class SweetServiceTest {

    @Test
    void shouldAddSweetSuccessfully() {
        SweetRepository repo = Mockito.mock(SweetRepository.class);
        SweetService service = new SweetService(repo);

        Sweet sweet = new Sweet("Ladoo", "Indian", 10.0, 5);
        Mockito.when(repo.save(Mockito.any())).thenReturn(sweet);

        Sweet result = service.addSweet("Ladoo", "Indian", 10.0, 5);

        assertEquals("Ladoo", result.getName());
        assertEquals(5, result.getQuantity());
    }

    @Test
void shouldThrowExceptionWhenPurchasingOutOfStockSweet() {
    // Arrange
    SweetRepository sweetRepository = Mockito.mock(SweetRepository.class);
    SweetService sweetService = new SweetService(sweetRepository);

    Sweet sweet = new Sweet("Barfi", "Indian", 20.0, 0);

    Mockito.when(sweetRepository.findById(1L))
            .thenReturn(java.util.Optional.of(sweet));

    // Act & Assert
    assertThrows(
            com.sweetshop.sweetshop.exception.OutOfStockException.class,
            () -> sweetService.purchaseSweet(1L)
    );
}

}
