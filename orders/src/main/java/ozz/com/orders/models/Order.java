package ozz.com.orders.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "order_table")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Order(){}

    public Order(Long id, String name, Long productId) {
        this.id= id;
        this.name = name;
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productId=" + productId +
                '}';
    }

    public ozz.com.dto.Order toDto() {
        return new ozz.com.dto.Order.Builder()
                .withId(this.id)
                .withName(this.name)
                .withProductId(this.productId).build();
    }
}
