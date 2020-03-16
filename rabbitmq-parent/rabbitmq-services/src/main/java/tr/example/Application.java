package tr.example;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tr.example.data.UserData;

@SpringBootApplication
@EnableRabbit
public class Application implements CommandLineRunner {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${queue.name}")
    private String queueName;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void run(String... args) throws Exception {
        rabbitTemplate.convertAndSend(queueName, new UserData("MuzafferOzturk", "1"));
    }
}
