package alessandrofugazza;

import com.github.javafaker.Faker;
import entities.Customer;
import entities.Order;
import entities.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) {
    Faker faker = new Faker();

    Supplier<Product> productSupplier = () -> new Product(1, faker.animal().name(), null, faker.random().nextDouble() * (100 - 1) + 1);
    Supplier<Customer> customerSupplier = () -> new Customer(1, faker.name().lastName(), 1);

    ArrayList<Order> orders = new ArrayList<>();

    orders.add(new Order(1, null, null, null, new ArrayList<>(Arrays.asList(productSupplier.get(), productSupplier.get())), new Customer(1, "Doe", 1)));
    orders.add(new Order(1, null, null, null, new ArrayList<>(Arrays.asList(productSupplier.get(), productSupplier.get())), customerSupplier.get()));
    orders.add(new Order(1, null, null, null, new ArrayList<>(Arrays.asList(productSupplier.get(), productSupplier.get())), customerSupplier.get()));
    orders.add(new Order(1, null, null, null, new ArrayList<>(Arrays.asList(productSupplier.get(), productSupplier.get())), customerSupplier.get()));
    orders.add(new Order(1, null, null, null, new ArrayList<>(Arrays.asList(productSupplier.get(), productSupplier.get())), customerSupplier.get()));
    orders.add(new Order(1, null, null, null, new ArrayList<>(Arrays.asList(productSupplier.get(), productSupplier.get())), customerSupplier.get()));
    orders.add(new Order(1, null, null, null, new ArrayList<>(Arrays.asList(productSupplier.get(), productSupplier.get())), customerSupplier.get()));
    orders.add(new Order(1, null, null, null, new ArrayList<>(Arrays.asList(productSupplier.get(), productSupplier.get())), new Customer(1, "Doe", 1)));

    Map<Customer, List<Order>> ordersForCustomer = orders.stream().collect(Collectors.groupingBy(Order::getCustomer));
    ordersForCustomer.forEach((customer, ordersList) -> System.out.println("Customer: " + customer + " " + ordersList));

    Map<Customer, Double> totalForCustomer = orders.stream().collect(Collectors.groupingBy(Order::getCustomer, ));

    ArrayList<Product> products = new ArrayList<>();

    products.add(productSupplier.get());
    products.add(productSupplier.get());
    products.add(productSupplier.get());
    products.add(productSupplier.get());
    products.add(productSupplier.get());
    products.add(productSupplier.get());
    products.add(productSupplier.get());
    products.add(productSupplier.get());



//    Order priciestOrder = users.stream().sorted(Comparator.comparing(User::getName, Comparator.reverseOrder()))
//            .peek(user -> System.out.println("PEEK: " + user)).skip(5).limit(10).toList();
  }
}
