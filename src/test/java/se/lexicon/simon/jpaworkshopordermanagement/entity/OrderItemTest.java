package se.lexicon.simon.jpaworkshopordermanagement.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    @Test
    void calculateProducts() {
        //Arrange
        Product product = new Product("T-Shirt", 100);
        OrderItem orderItem = new OrderItem(5, product, null);
        double expected = 500;

        //Act
        double actual = orderItem.calculateProducts();

        //Assert
        assertEquals(expected, actual);

    }
}