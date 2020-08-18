package se.lexicon.simon.jpaworkshopordermanagement.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.simon.jpaworkshopordermanagement.entity.OrderItem;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

    List<OrderItem> findAll();

}
