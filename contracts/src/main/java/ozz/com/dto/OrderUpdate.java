package ozz.com.dto;

import java.io.Serializable;

public class OrderUpdate implements Serializable{
	private static final long serialVersionUID = -5829518819086683096L;
	private Order order;
    private Integer code;
    private String message;

	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
