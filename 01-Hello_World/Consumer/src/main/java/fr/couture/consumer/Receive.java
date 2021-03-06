package fr.couture.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Receive {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) {
        try {
            var factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setUsername("anthony");
            factory.setPassword("anthony");
            factory.setPort(8081);
            var connection = factory.newConnection();
            var channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                var message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + message + "'");
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
            });
        } catch (TimeoutException | IOException e) {
            e.printStackTrace();
        }

    }
}
