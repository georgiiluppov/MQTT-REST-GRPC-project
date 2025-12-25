import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttCityPublisher {
    private static MqttClient client;

    public static void main(String[] args) {
        // 0 (At most once): Message sent once, no confirmation
        // 1 (At least once): Message sent until acknowledged
        // 2 (Exactly once): Message sent exactly once, no duplicates
        int qos = 1;

        // MQTT broker URL
        String broker = "tcp://localhost:1883";
        // Unique ID for this publisher
        String clientId = "CityPublisher";

        // This object stores MQTT session data in memory
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            client = new MqttClient(broker, clientId, persistence);

            // Lets set connection parameters (setCleanSession, setUserName, setPassword)
            MqttConnectOptions connOpts = new MqttConnectOptions();

            // Every time the client connects, it starts fresh, it does not keep any old subscriptions or messages from before (true)
            // If it was set to false, the client keeps its subscriptions and any messages it missed while they were offline
            connOpts.setCleanSession(true);

            // How often client sends a ping to the broker to show that they are still connected
            connOpts.setKeepAliveInterval(180);

            //connOpts.setUserName("");
            //connOpts.setPassword("");

            System.out.println("Connecting to broker: " + broker);

            // Connecting to the broker
            client.connect(connOpts);
            System.out.println("Connected");

            // Publishing 5 messages for every service
            for( int i = 0; i < 3; i++) {
                // Publishing weather warning message
                String weatherTopic = "city/weather/warnings/Dublin";
                String weatherMessage = generateWeatherWarning();
                // The false means that the broker will not save the message
                publishMessage(weatherTopic, weatherMessage, qos, false);

                // Publishing air quality message
                String airTopic = "city/air/quality/Dublin-01";
                String airMessage = generateAirQuality();
                publishMessage(airTopic, airMessage, qos, false);

                // Publishing radon level message
                String radonTopic = "city/radiation/radon/Dublin-07";
                String radonMessage = generateRadonLevel();
                publishMessage(radonTopic, radonMessage, qos, false);

                System.out.println("--------------------------------");
                // Wait for 3 second between messages
                Thread.sleep(3000);
            }

            // Disconnects the client from the MQTT broker
            client.disconnect();
            System.out.println("Disconnected");
            // Closing the client
            client.close();
            System.exit(0);

        } catch (MqttException | InterruptedException exception) {
            // Printing error messages
            System.out.println("msg " + exception.getMessage());
            System.out.println("loc-msg " + exception.getLocalizedMessage());
            System.out.println("cause " + exception.getCause());
            System.out.println("exception " + exception);
            exception.printStackTrace();
        }
    }

     // 'topic' - the category of the message
     // 'payload' - the content of the message
     // 'qos' - the quality of service
     // 'retained' - if retained is true the message is held and sent to future subscribers
    private static void publishMessage(String topic, String payload, int qos, boolean retained) {
        System.out.println("Publishing message: " + payload + " on topic " + topic);
        MqttMessage message = new MqttMessage(payload.getBytes());
        message.setRetained(retained);
        message.setQos(qos);

        try {
            client.publish(topic, message);

        } catch (MqttException me) {
            // Printing error messages
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc-msg " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("exception " + me);
            me.printStackTrace();
        }
        System.out.println("Message published");
    }

    private static String generateWeatherWarning() {
        int weatherRandom = (int) (Math.random() * 10) + 1;
        String warningLevel;
        if (weatherRandom < 5) {
            warningLevel = "Yellow. Low weather risk. Stay alert.";
        } else if (weatherRandom <= 7) {
            warningLevel = "Orange. Moderate weather risk.";
        } else {
            warningLevel = "Red. Severe weather risk! Take precautions!";
        }
        return warningLevel;
    }

    private static String generateAirQuality() {
        int airQualityIndexRandom = (int) (Math.random() * 5) + 1;
        String message;
        switch (airQualityIndexRandom){
            case 1:
                message = "Good air quality in Dublin 7";
                break;
            case 2:
                message = "Moderate air quality in Dublin 7";
                break;
            case 3:
                message = "Unhealthy for Sensitive Groups in Dublin 7";
                break;
            case 4:
                message = "Unhealthy air quality in Dublin 7";
                break;
            default:
                message = "Very Unhealthy air quality in Dublin 7";
        }
        return message;
    }


    private static String generateRadonLevel() {
        double radonLevelRandom = 1 + (Math.random() * 9.0);
        String status;
        if (radonLevelRandom <= 5){
            status = "Radon level is safe in Dublin 1. Level: " + radonLevelRandom;
        } else {
            status = "Radon level is unsafe in Dublin 1. Level: " + radonLevelRandom;
        }
        return status;
    }
}
