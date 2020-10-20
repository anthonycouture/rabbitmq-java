package fr.couture.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) {
        var factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("anthony");
        factory.setPassword("anthony");
        factory.setPort(8081);
        try (var connection = factory.newConnection();
         var channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            for (int i = 1; i < 11; i++)
                send(channel, i);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void send(Channel channel, int i) throws IOException {
        var message = "Hello World " + i;
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
    }
}
