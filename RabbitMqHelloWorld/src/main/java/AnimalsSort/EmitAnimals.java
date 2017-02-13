package AnimalsSort;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Martin.Flekna on 3.2.2017.
 */
public class EmitAnimals {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv)
            throws java.io.IOException, java.util.concurrent.TimeoutException, InterruptedException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        String message = "";
        int i = 0;
        while (i == 0) {
            Animal animal = randomEnum(Animal.class);
            Color color = randomEnum(Color.class);
            Speed speed = randomEnum(Speed.class);

            String routingKey = speed.getText() + "." + color.getText() + "." + animal.getText();
            message = "Message with routing key: " + routingKey;

            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
            Thread.sleep(1000);
        }

        channel.close();
        connection.close();
    }

    private static String joinStrings(String[] strings, String delimiter) {
        int length = strings.length;
        if (length == 0) return "";
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }

    private static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = ThreadLocalRandom.current().nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
