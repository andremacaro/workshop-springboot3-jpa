package com.cursonelio.course.config;

import com.cursonelio.course.entities.Category;
import com.cursonelio.course.entities.Order;
import com.cursonelio.course.entities.Product;
import com.cursonelio.course.entities.User;
import com.cursonelio.course.entities.enums.OrderStatus;
import com.cursonelio.course.repositories.CategoryRepository;
import com.cursonelio.course.repositories.OrderRepository;
import com.cursonelio.course.repositories.ProductRepository;
import com.cursonelio.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test") // Define que essa configuração só será usada quando o perfil "test" estiver ativo
public class TestConfig implements CommandLineRunner {

    @Autowired // Injeta o UserRepository para que possa ser usado na configuração
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet", 300.0, "www.imageurl.com/1");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus", 1500.0, "www.imageurl.com/2");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor", 2500.0, "www.imageurl.com/3");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 2200.0, "www.imageurl.com/4");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel", 150.0, "www.imageurl.com/5");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "97777777", "123456");

        Order o1 = new Order(null, Instant.parse("2025-07-14T15:12:04Z"), OrderStatus.PAID,u1);
        Order o2 = new Order(null, Instant.parse("2025-08-14T08:34:11Z"), OrderStatus.WAITING_PAYMENT,u2);
        Order o3 = new Order(null, Instant.parse("2025-09-14T10:23:22Z"), OrderStatus.WAITING_PAYMENT,u1);

        userRepository.saveAll(Arrays.asList(u1, u2)); // Salva os usuários no banco de dados
        orderRepository.saveAll(Arrays.asList(o1, o2, o3)); // Salva os pedidos no banco de dados
    }
}
