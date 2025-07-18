package com.cursonelio.course.config;

import com.cursonelio.course.entities.Order;
import com.cursonelio.course.entities.User;
import com.cursonelio.course.repositories.OrderRepository;
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

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "97777777", "123456");

        Order o1 = new Order(null, Instant.parse("2025-07-14T15:12:04Z"), u1);
        Order o2 = new Order(null, Instant.parse("2025-08-14T08:34:11Z"), u2);
        Order o3 = new Order(null, Instant.parse("2025-09-14T10:23:22Z"), u1);

        userRepository.saveAll(Arrays.asList(u1, u2)); // Salva os usuários no banco de dados
        orderRepository.saveAll(Arrays.asList(o1, o2, o3)); // Salva os pedidos no banco de dados
    }
}
