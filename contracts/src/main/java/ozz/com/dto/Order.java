package ozz.com.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;

@JsonDeserialize(builder = Order.Builder.class)
public class Order implements Serializable {

    /**
	 * Generaded serialVersionUID
	 */
	private static final long serialVersionUID = 3998641627681226955L;

	private Long id;
    private String name;
    private Long productId;

    public Order(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.productId= builder.productId;
    }

    public Long getProductId() {
        return productId;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public static class Builder {
        private Long id;
        private String name;
        private Long productId;

        public Builder withId (Long id){
            this.id = id;
            return this;
        }

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withProductId(Long productId) {
            this.productId = productId;
            return  this;
        }

        public Order build() { return new Order(this); }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productId=" + productId +
                '}';
    }
}
