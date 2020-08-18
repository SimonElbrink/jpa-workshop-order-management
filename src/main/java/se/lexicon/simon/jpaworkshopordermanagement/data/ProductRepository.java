package se.lexicon.simon.jpaworkshopordermanagement.data;
import org.springframework.data.repository.CrudRepository;
import se.lexicon.simon.jpaworkshopordermanagement.entity.Product;

import java.util.List;


public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAll();

    List<Product> findAllByNameContainingIgnoreCase(String productName);

}
