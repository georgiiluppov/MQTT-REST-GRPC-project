import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Subscriber implements MqttCallback {
    // Constructor for Subscriber class
    public Subscriber() {
    }

    // Called when the connection to the MQTT broker is lost.
    @Override
    public void connectionLost(Throwable thrwbl) {
        System.out.println("connection is lost " + thrwbl.getStackTrace());
    }

    // Called when a message arrives from the broker for a subscribed topic
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println(new String(message.getPayload()) + " arrived from topic " + topic + " with qos " + message.getQos());
    }

    // Called when delivery for a message published by this client is complete
    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("Delivery is completed " + token.isComplete());
    }
}