import com.generated.sustainableCities.EmergencyServiceGrpc;
import com.generated.sustainableCities.PatientData;
import com.generated.sustainableCities.PatientReport;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.TimeUnit;

public class PatientDataClient {
    public static void main(String[] args) throws InterruptedException {
        // A channel to connect to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // Creating a stub for the EmergencyService
        EmergencyServiceGrpc.EmergencyServiceStub asyncStub = EmergencyServiceGrpc.newStub(channel);

        // Creating a response observer to handle server responses
        StreamObserver<PatientReport> responseObserver = new StreamObserver<PatientReport>() {
            @Override
            public void onNext(PatientReport patientReport) {
                // Called when a new patient report is received from the server
                System.out.println("Received patient report: " + patientReport.getReport());
            }

            @Override
            public void onError(Throwable t) {
                // Called if there is an error during communication
                System.err.println("Error receiving report: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Called when the server has finished sending data
                System.out.println("Patient data upload completed.");
            }
        };

        // Creating a request observer to send patient data to the server
        StreamObserver<PatientData> requestObserver = asyncStub.uploadPatientData(responseObserver);

        try {
            // Sending 5 patient data messages to the server with a 1-second delay between each
            for (int i = 0; i < 5; i++) {
                PatientData data = PatientData.newBuilder()
                        .setPatientId("patient_01")
                        .setHeartRate(60 + i * 2)
                        .setBloodPressure(120 + i)
                        .setOxygenSaturation(i)
                        .setAdditionalNotes("Requires 1 liter of blood type 2")
                        .build();

                System.out.println("Sending patient data: " + data);
                requestObserver.onNext(data);
                Thread.sleep(1000);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        // Finishing sending data
        requestObserver.onCompleted();

        // Shutdown the channel
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
