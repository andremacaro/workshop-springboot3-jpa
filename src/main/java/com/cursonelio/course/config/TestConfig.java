package com.cursonelio.course.config;

import com.cursonelio.course.entities.User;
import com.cursonelio.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test") // Define que essa configuração só será usada quando o perfil "test" estiver ativo
public class TestConfig implements CommandLineRunner {

    @Autowired // Injeta o UserRepository para que possa ser usado na configuração
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "97777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2)); // Salva os usuários no banco de dados
    }
}
