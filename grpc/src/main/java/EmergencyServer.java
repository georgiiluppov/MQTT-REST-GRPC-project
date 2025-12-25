import com.generated.sustainableCities.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;

public class EmergencyServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50051;
        EmergencyServiceImpl serviceImpl = new EmergencyServiceImpl();

        // Creating and starting the gRPC server on the specified port
        Server server = ServerBuilder.forPort(port)
                .addService(serviceImpl)
                .build();

        System.out.println("Starting EmergencyService gRPC server on port " + port);
        server.start();
        server.awaitTermination();
    }

    // 1. Unary
    static class EmergencyServiceImpl extends EmergencyServiceGrpc.EmergencyServiceImplBase {
        @Override
        public void reportAccident(AccidentRequest request, StreamObserver<AccidentResponse> responseObserver) {
            try {
                String accidentId = "accident_1";

                // Creating a response message with accident details
                AccidentResponse response = AccidentResponse.newBuilder()
                        .setAccidentId(accidentId)
                        .setMessage("Sending data to emergency services. Type: " + request.getAccidentType()
                        + " Severity: " + request.getSeverity())
                        .build();

                // Sending the response to the client
                responseObserver.onNext(response);
                responseObserver.onCompleted();

                System.out.println("Received accident report from location: " + request.getLocation());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 2. Server stream
        @Override
        public void notifyServices(ServiceSubscriptionRequest request, StreamObserver<EmergencyNotification> responseObserver) {
            try {
                System.out.println("Subscribed service: " + request.getServiceType() + ", team: " + request.getTeamID());

                // Sending 5 notifications with random accident types and increasing severity
                for (int i = 1; i <= 5; i++) {
                    String accidentType;
                    int randomNum = (int)(Math.random() * 3 + 1);

                    if (randomNum == 1){
                        accidentType = "Traffic Accident";
                    } else if (randomNum == 2) {
                        accidentType = "Medical Emergency";
                    } else {
                        accidentType = "Hurricane";
                    }

                    // Creating an emergency notification message
                    EmergencyNotification notification = EmergencyNotification.newBuilder()
                            .setAccidentId("accident_" + i)
                            .setLocation("Dublin")
                            .setAccidentType(accidentType)
                            .setSeverity(i)
                            .build();

                    // Sending the notification to the client
                    responseObserver.onNext(notification);
                    Thread.sleep(3000);
                }
                // All notifications have been sent
                responseObserver.onCompleted();
            } catch (Exception e) {
                e.printStackTrace();
                responseObserver.onError(e);
            }
        }

        // 3. Client stream
        @Override
        public StreamObserver<PatientData> uploadPatientData(StreamObserver<PatientReport> responseObserver) {
            return new StreamObserver<PatientData>() {
                String patientId = "patient_1";
                int count = 0;
                double avgHeartRate = 0;
                double avgBloodPressure = 0;
                double avgOxygen = 0;

                @Override
                public void onNext(PatientData patientData) {
                    avgHeartRate = (avgHeartRate * count + patientData.getHeartRate()) / (count + 1);
                    avgBloodPressure = (avgBloodPressure * count + patientData.getBloodPressure()) / (count + 1);
                    avgOxygen = (avgOxygen * count + patientData.getOxygenSaturation()) / (count + 1);
                    count++;

                    System.out.println("Received patient data update: HR=" + patientData.getHeartRate() +
                            ", BP=" + patientData.getBloodPressure() +
                            ", Oxygen=" + patientData.getOxygenSaturation());
                }

                // Handling an error during notification reception
                @Override
                public void onError(Throwable t) {
                    System.err.println("Error receiving patient data: " + t.getMessage());
                }

                // Creating a report with the average patient data collected
                @Override
                public void onCompleted() {
                    String report = "Patient " + patientId + " data received. Average BPM: " + avgHeartRate +
                            ", BP: " + avgBloodPressure + ", Oxygen: " + avgOxygen;

                    // Sending the patient report back to the client
                    PatientReport response = PatientReport.newBuilder()
                            .setReport(report)
                            .build();

                    responseObserver.onNext(response);
                    responseObserver.onCompleted();

                    System.out.println("Completed receiving patient data stream. " + report);
                }
            };
        }

        // 4. Bidirectional stream
        @Override
        public StreamObserver<AmbulanceStatus> routeOptimization(StreamObserver<RouteUpdate> responseObserver) {
            return new StreamObserver<AmbulanceStatus>() {
                @Override
                public void onNext(AmbulanceStatus status) {
                    System.out.println("Received status from ambulance: " + status.getAmbulanceId() +
                            ", location: " + status.getLocation() +
                            ", patient condition: " + status.getPatientCondition());

                    String changeRoute;
                    int randomNum = (int)(Math.random() * 3 + 1);

                    if (randomNum == 1){
                        changeRoute = "Turn left";
                    } else if (randomNum == 2) {
                        changeRoute = "Turn right";
                    } else {
                        changeRoute = "Go straight";
                    }

                    // Creating a route update message
                    RouteUpdate update = RouteUpdate.newBuilder()
                            .setNewRouteInstructions(changeRoute)
                            .setEstimatedArrivalTime("5 minutes")
                            .setAlternateHospital("City Hospital")
                            .setTimestamp((int) (System.currentTimeMillis() / 1000))
                            .build();

                    // Sending the route update to the ambulance client
                    responseObserver.onNext(update);
                }

                // Handling an error during notification reception
                @Override
                public void onError(Throwable t) {
                    System.err.println("Error in routeOptimization: " + t.getMessage());
                }

                // Finishing stream
                @Override
                public void onCompleted() {
                    System.out.println("Ambulance finished stream.");
                    responseObserver.onCompleted();
                }
            };
        }
    }
}