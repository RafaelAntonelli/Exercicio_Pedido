package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

import Enums.OrderStatus;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;

public class Exercicio_Pedido {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Order order = new Order();
		Date orderDate = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus os1 = OrderStatus.valueOf(sc.next());
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		 for (int i = 1; i<=n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			String nameP = sc.next();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();
			OrderItem item = new OrderItem(quantity, price, new Product(nameP, price));
			order.addItem(item);
		}
		
		System.out.println("ORDER SUMARY");
		System.out.println("Order moment: " + sdf2.format(orderDate));
		System.out.println("Order status: " + OrderStatus.PROCESSING);
		System.out.println("Client: " + client.getName() + ", " + sdf.format(client.getBirthDate())  + ", " + client.getEmail());
		System.out.println("Order Items: ");
		System.out.println(order.total());
		
		
		
		sc.close();
	} 

}
