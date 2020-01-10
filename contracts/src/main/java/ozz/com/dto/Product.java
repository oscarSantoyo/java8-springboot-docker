package ozz.com.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Product.Builder.class)
public class Product {

    private Long id;
    private String name;
    private Double price;

    public Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static class Builder{
        private Long id;
        private String name;
        private Double price;

        public Builder withId(Long id){
            this.id = id;
            return this;
        }

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withPrice(Double price){
            this.price = price;
            return this;
        }

        public Product build(){
            return new Product(this);
        }

    }
}
