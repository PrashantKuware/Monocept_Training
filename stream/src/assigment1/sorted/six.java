package assigment1.sorted;
import java.util.*;

class Product 
{
    String name;
    int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}


 class six {
    public static void main(String[] args) {
        List<Product> list = Arrays.asList(
            new Product("Karan", 50),
            new Product("Manish", 234),
            new Product("Ram", 65),
            new Product("Lala", 267),
            new Product("Ganesh", 98),
            new Product("Ramesh", 56)
        );

        list.stream()
            .sorted((p1, p2) -> p1.price - p2.price)
            .forEach(p -> System.out.println(p.name + " " + p.price));
    }
}