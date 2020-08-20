package se.lexicon.simon.jpaworkshopordermanagement.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.simon.jpaworkshopordermanagement.entity.AppUser;
import se.lexicon.simon.jpaworkshopordermanagement.entity.OrderItem;
import se.lexicon.simon.jpaworkshopordermanagement.entity.Product;
import se.lexicon.simon.jpaworkshopordermanagement.entity.ProductOrder;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductOrderRepositoryTest {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    private ProductOrder testObject;

    @BeforeEach
    void setUp() {

        AppUser testUser = new AppUser("Test", "Testsson", "test@test.se");
        Product testProduct = new Product("Book", 150);
        OrderItem testOrderItem = new OrderItem(2, testProduct, null);
        testObject = new ProductOrder(LocalDateTime.of(2020, Month.JANUARY, 1, 13, 30), null, testUser);
        testObject.addOrderItem(testOrderItem);
        testObject = productOrderRepository.save(testObject);


        OrderItem orderItem1 = new OrderItem(3, testProduct, null);
        ProductOrder productOrder1 = new ProductOrder(LocalDateTime.of(2020, Month.JANUARY, 2, 15, 0), null, testUser);
        productOrder1.addOrderItem(orderItem1);
        productOrderRepository.save(productOrder1);


        AppUser appUser2 = new AppUser("Foo", "Boo", "Foo@Boo.se");
        Product product2 = new Product("Toy", 100);
        OrderItem orderItem2 = new OrderItem(4, product2, null);
        ProductOrder productOrder2 = new ProductOrder(LocalDateTime.of(2020, Month.FEBRUARY, 1, 11, 0), null, appUser2);
        productOrder2.addOrderItem(orderItem2);
        productOrderRepository.save(productOrder2);


    }

    @Test
    void successfullyCreated() {
        Optional<ProductOrder> found = productOrderRepository.findById(testObject.getId());

        assertTrue(found.isPresent());
        assertEquals(found.get(), testObject);

        assertNotNull(found.get().getOrderItems());
        assertNotNull(found.get().getOrderItems().get(0).getProductOrder());

    }



    @Test
    void findAllByOrderDateTimeBetween() {
        // Arrange
        LocalDateTime start = LocalDateTime.parse("2020-01-01T00:00:00");
        LocalDateTime end = LocalDateTime.parse("2020-02-01T00:00:00");

        // Act
        List<ProductOrder> found = productOrderRepository.findAllByOrderDateTimeBetween(start, end);

        //Assert
        assertNotNull(found);
        assertEquals(2, found.size());

    }

    @Test
    void findByOrderItems_Product_Id() {
        // Arrange
        int productId = testObject.getOrderItems().get(0).getProduct().getId();

        // Act
        List<ProductOrder> foundOrders = productOrderRepository.findByOrderItems_Product_Id(productId);

        //Assert
        assertNotNull(foundOrders);
        assertFalse(foundOrders.isEmpty());
        assertEquals(2, foundOrders.size());

    }

    @Test
    void findAllByOrderItems_Product_name() {
         // Arrange
        String productName = "bOOk";

         // Act
        List<ProductOrder> foundOrders = productOrderRepository.findAllByOrderItems_Product_nameIgnoreCase(productName);

        //Assert
        assertNotNull(foundOrders);
        assertEquals(2, foundOrders.size());

    }

    @Test
    void findAllByCustomer_Id() {
        // Arrange
        int customerId = testObject.getCustomer().getId();

        // Act
        List<ProductOrder> foundOrdersByAppUser = productOrderRepository.findAllByCustomer_Id(customerId);

        //Assert
        assertNotNull(foundOrdersByAppUser);
        assertEquals(2, foundOrdersByAppUser.size());
        assertEquals(foundOrdersByAppUser.get(0).getCustomer(), testObject.getCustomer());
    }
}