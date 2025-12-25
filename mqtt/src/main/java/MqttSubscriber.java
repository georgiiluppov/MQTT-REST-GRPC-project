import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttSubscriber {
    public static void main(String[] args) {
        // MQTT broker URL
        String broker = "tcp://localhost:1883";
        // Unique client ID for this subscriber
        String clientId = "Subscriber";

        // Store client in memory
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            // Create client instance
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);

            // Set callback to handle incoming messages
            MqttConnectOptions connOpts = new MqttConnectOptions();
            // Start fresh session, no stored subscriptions
            connOpts.setCleanSession(true);
            sampleClient.setCallback(new Subscriber());

            System.out.println("Connecting to broker: " + broker);

            // Connect to the broker
            sampleClient.connect(connOpts);
            System.out.println("Connected");

            // Subscribe to the topics (all subtopics)
            sampleClient.subscribe("city/weather/warnings/#");
            sampleClient.subscribe("city/air/quality/#");
            sampleClient.subscribe("city/radiation/radon/#");

        } catch (MqttException me) {
            // Printing error messages
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }
}