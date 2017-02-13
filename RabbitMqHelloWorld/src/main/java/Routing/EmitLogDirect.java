package Routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Martin.Flekna on 3.2.2017.
 */
public class EmitLogDirect {
    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] argv)
            throws java.io.IOException, java.util.concurrent.TimeoutException, InterruptedException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        String severity = "";
        String message = "";

        int i = 0;
        while (i ==0) {
            int randInt = ThreadLocalRandom.current().nextInt(0, 2 + 1);
            switch(randInt) {
                case 0:
                    message = Messages.ERROR.getText();
                    severity =  Messages.ERROR.getCode();
                    break;
                case 1:
                    message = Messages.INFO.getText();
                    severity =  Messages.INFO.getCode();
                    break;
                case 2:
                    message = Messages.WARNING.getText();
                    severity =  Messages.WARNING.getCode();
                    break;
            }
            channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
            System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
            Thread.sleep(10);
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
    }}
