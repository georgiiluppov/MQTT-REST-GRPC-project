import com.generated.sustainableCities.AccidentRequest;
import com.generated.sustainableCities.AccidentResponse;
import com.generated.sustainableCities.EmergencyServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class EmergencyClient {
    public static void main(String[] args) throws InterruptedException {
        // Creating a channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // Creating a blocking stub
        EmergencyServiceGrpc.EmergencyServiceBlockingStub stub = EmergencyServiceGrpc.newBlockingStub(channel);

        // Building an accident request with location, timestamp, type, severity, and description
        AccidentRequest request = AccidentRequest.newBuilder()
                .setLocation("Dublin")
                .setTimestamp((int) (System.currentTimeMillis() / 1000))
                .setAccidentType("Traffic Accident")
                .setSeverity(5)
                .setDescription("Multiple cars collision")
                .build();

        // Sending the accident report request and receiving the response
        AccidentResponse response = stub.reportAccident(request);

        // Printing the server's response message and the accident ID
        System.out.println("From the server: " + response.getMessage() + " Accident ID: " + response.getAccidentId());

        // Shutting down the channel
        channel.shutdown();
        channel.awaitTermination(5, TimeUnit.SECONDS);
    }
}
