package fr.couture.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class NewTask {

    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] argv) throws Exception {
        var factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("anthony");
        factory.setPassword("anthony");
        factory.setPort(8081);
        try (var connection = factory.newConnection();
             var channel = connection.createChannel()) {
            channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

            var listmessage = new ArrayList<String>();

            listmessage.add("test");
            listmessage.add("test1");
            listmessage.add(".");
            listmessage.add("test2");
            listmessage.add("test3");

            for (String message : listmessage){
                channel.basicPublish("", TASK_QUEUE_NAME,
                        MessageProperties.PERSISTENT_TEXT_PLAIN,
                        message.getBytes(StandardCharsets.UTF_8));
                System.out.println(" [x] Sent '" + message + "'");
            }
        }
    }

}
