package ozz.com.products.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Product  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public ozz.com.dto.Product toDto() {
        return new ozz.com.dto.Product.Builder()
                .withId(this.getId())
                .withName(this.getName())
                .withPrice(this.getPrice()).build();
    }
}
