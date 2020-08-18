package se.lexicon.simon.jpaworkshopordermanagement.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    @ManyToOne(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.EAGER
    )
    private Product product;

    @ManyToOne(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    private ProductOrder productOrder;

    public OrderItem() {
    }

    public OrderItem(int quantity, Product product, ProductOrder productOrder) {
        this.quantity = quantity;
        this.product = product;
        this.productOrder = productOrder;
    }


    public double calculateProducts(){
        // Expand security?
        double price = product.getPrice() * quantity;

        return price;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return id == orderItem.id &&
                quantity == orderItem.quantity &&
                Objects.equals(product, orderItem.product) &&
                Objects.equals(productOrder, orderItem.productOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, product, productOrder);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
