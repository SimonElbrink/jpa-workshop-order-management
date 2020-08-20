package se.lexicon.simon.jpaworkshopordermanagement.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.simon.jpaworkshopordermanagement.entity.ProductOrder;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductOrderRepository extends CrudRepository<ProductOrder, Integer> {

    List<ProductOrder> findAll();

    List<ProductOrder> findAllByOrderDateTimeBetween(LocalDateTime start, LocalDateTime end);

    List<ProductOrder> findByOrderItems_Product_Id(int ProductId);

    List<ProductOrder> findAllByOrderItems_Product_nameIgnoreCase(String productName);

    List<ProductOrder> findAllByCustomer_Id(int Id);

}
