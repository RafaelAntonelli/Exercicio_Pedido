package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Enums.OrderStatus;


public class Order {
	private Date moment;
	private OrderStatus status;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double total = 0.0;
		for (OrderItem orderItem : items) {
			total += orderItem.subTotal();	
		}
		return total;
	}
	
	public String printResultado() {
		String resultado = "" ;
		for (OrderItem orderItem : items) {
			resultado += orderItem.toString();
		}
		return resultado;
	}

	
		
}
