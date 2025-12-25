import com.generated.sustainableCities.AmbulanceStatus;
import com.generated.sustainableCities.EmergencyServiceGrpc;
import com.generated.sustainableCities.RouteUpdate;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.TimeUnit;

public class AmbulanceStatusClient {
    public static void main(String[] args) throws InterruptedException {
        // Creating a channel to connect to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // Creating a stub for the EmergencyService
        EmergencyServiceGrpc.EmergencyServiceStub asyncStub = EmergencyServiceGrpc.newStub(channel);

        // Creating a request observer to send ambulance status updates
        StreamObserver<AmbulanceStatus> requestObserver = asyncStub.routeOptimization(new StreamObserver<RouteUpdate>() {
            // Receiving route update from the server
            @Override
            public void onNext(RouteUpdate status) {
                System.out.println("Received route update: " + status.getNewRouteInstructions() +
                        ", Time to arrive: " + status.getEstimatedArrivalTime());
            }

            // Handling error during route updates reception
            @Override
            public void onError(Throwable t) {
                System.err.println("Error receiving route updates: " + t.getMessage());
            }

            // Completing when the server finishes sending route updates
            @Override
            public void onCompleted() {
                System.out.println("Route optimization stream completed");
            }
        });

        // Sending 5 ambulance status updates with 1 second delay
        for (int i = 1; i <= 5; i++) {
            AmbulanceStatus status = AmbulanceStatus.newBuilder()
                    .setAmbulanceId("ambulance_1")
                    .setLocation("Dublin " + i)
                    .setPatientCondition("Critical")
                    .setTimestamp((int) (System.currentTimeMillis() / 1000))
                    .build();

            // Sending the ambulance status to the server
            requestObserver.onNext(status);
            Thread.sleep(1000);
        }

        // Completing the request stream
        requestObserver.onCompleted();

        // Waiting 15 seconds to receive route updates
        Thread.sleep(15000);
        // Shutting down the channel
        channel.shutdown();
        channel.awaitTermination(5, TimeUnit.SECONDS);
    }
}