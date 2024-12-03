package example.corejava.other;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class CollectorsExample {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "HP", 2000f),
                new Product(2, "Dell", 3000f),
                new Product(3, "Lenovo", 4000f),
                new Product(4, "Asus", 5000f),
                new Product(5, "Apple", 6000f),
                new Product(6, "Samsung", 7000f)
        );
        List<Float> prices = products.stream().map(product -> product.price).collect(Collectors.toList());
        System.out.println("List of prices:" + prices);

        Double sumPrice = products.stream().collect(Collectors.summingDouble(product -> product.price));
        System.out.println("Sum of prices:" + sumPrice);

        Double avgPrice = products.stream().collect(Collectors.averagingDouble(product -> product.price));
        System.out.println("Average of prices:" + avgPrice);

        Long count = products.stream().collect(Collectors.counting());
        System.out.println("Count of products:" + count);
    }
}
