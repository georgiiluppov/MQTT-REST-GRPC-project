import com.generated.sustainableCities.EmergencyNotification;
import com.generated.sustainableCities.EmergencyServiceGrpc;
import com.generated.sustainableCities.ServiceSubscriptionRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.TimeUnit;

public class NotifyServicesClient {
    public static void main(String[] args) throws InterruptedException {
        // Creating a channel to connect to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // Creating a stub
        EmergencyServiceGrpc.EmergencyServiceStub asyncStub = EmergencyServiceGrpc.newStub(channel);

        // Building a request for a specific service type and team ID
        ServiceSubscriptionRequest request = ServiceSubscriptionRequest.newBuilder()
                .setServiceType("Ambulance")
                .setTeamID("Team-01")
                .build();

        // Calling the notifyServices gRPC with the subscription request and handling responses
        asyncStub.notifyServices(request, new StreamObserver<EmergencyNotification>() {
            // Receiving a new notification from the server
            @Override
            public void onNext(EmergencyNotification emergencyNotification) {
                System.out.println("Received notification: AccidentID=" + emergencyNotification.getAccidentId() +
                        ", Location=" + emergencyNotification.getLocation() +
                        ", Type=" + emergencyNotification.getAccidentType() +
                        ", Severity=" + emergencyNotification.getSeverity());
            }

            @Override
            // Handling an error during notification reception
            public void onError(Throwable t) {
                System.err.println("Error receiving notifications: " + t.getMessage());
            }

            @Override
            // Completing when the server indicates no more notifications will be sent
            public void onCompleted() {
                System.out.println("All notifications received");
            }
        });

        // Waiting for 35 seconds to allow notifications to be received
        Thread.sleep(35000);

        // Shutting down the channel
        channel.shutdown();
        channel.awaitTermination(5, TimeUnit.SECONDS);
    }
}
