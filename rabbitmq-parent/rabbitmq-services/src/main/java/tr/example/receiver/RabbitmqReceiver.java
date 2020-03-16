package tr.example.receiver;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import tr.example.data.UserData;

@Component("rabbitmqReceiver")
public class RabbitmqReceiver {

    @Value("${queue.name}")
    private String queueName;
    @Bean
    public Queue receiveQueue(){
        return new Queue(queueName);
    }

    @RabbitListener(queues = "${queue.name}")
    public void listen(UserData userData){
        System.out.println(userData.getName() + "-" + userData.getNumber());
    }
}
