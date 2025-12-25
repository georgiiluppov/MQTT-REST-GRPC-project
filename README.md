# MQTT-REST-GRPC-project
This project demonstrates the use of gRPC, MQTT, and RESTful Web Services to support the development of Sustainable Cities and Communities. The system focuses on emergency response, environmental monitoring, and public transport services to improve urban safety, health, and mobility.

This project integrates multiple communication paradigms to address real-world urban challenges:
gRPC for real-time emergency coordination
MQTT for lightweight environmental monitoring
REST for public transport information and feedback

1. gRPC – Emergency Service
   The EmergencyService supports urban safety by detecting accidents, assigning emergency teams, sharing critical patient data with hospitals, and optimizing ambulance routes in real time.
   When an accident occurs, data is sent from citizens, sensors, or mobile applications. The system assigns emergency teams and continuously updates hospitals and ambulances to minimize response and transport times.

- Unary RPC – ReportAccident
Registers a new emergency incident.
Request: Location, Timestamp, Accident type, Severity, Description
Response: Unique accident ID, Confirmation message

- Server Streaming RPC – NotifyServices
Emergency services subscribe to the server and receive real-time notifications relevant to their responsibilities.
Examples:
Fires - Fire Department/Ambulances
Chemical spills - Specialized response teams

- Client Streaming RPC – UploadPatientData
Ambulances stream patient vital signs to hospitals while en route.
Benefits:
Hospitals can prepare in advance
Faster treatment upon arrival
Improved patient survival rates

- Bidirectional Streaming RPC – RouteOptimization
Ambulances continuously send: Location, Patient condition, Timestamp
The server responds with: Updated routes, Estimated arrival time, Alternative hospital options
Overall the system minimises delays caused by traffic or hospital availability.

2. MQTT – Environmental Monitoring
   The MQTT application monitors environmental conditions to improve urban health and safety. The publish/subscribe model ensures low-latency, real-time updates to multiple subscribers.
   MQTT Topic Structure
city/weather/warnings/Dublin
city/air/quality/Dublin-01
city/radiation/radon/Dublin-07

- Weather Warnings
  Topic: city/weather/warnings/Dublin
Message Examples:
Yellow – Low risk
Orange – Moderate risk
Red – Severe risk
Weather severity is generated randomly and helps residents take early precautions.

- Air Quality Reports
  Topic: city/air/quality/Dublin-01
Categories:
Good
Moderate
Unhealthy for Sensitive Groups
Unhealthy
Very Unhealthy
Subscribers can reduce exposure by limiting outdoor activity when necessary.

- Radon Level Monitoring
  Topic: city/radiation/radon/Dublin-07
Radon levels are classified as:
Safe (≤ 5.0)
Unsafe (> 5.0)
This is especially relevant in Ireland, where radon exposure poses health risks.

3. REST – Public Transport Service
   A RESTful web service that improves urban mobility by providing:
Bus route information
Live bus locations
Passenger feedback collection

- GET /api/routes
Returns a list of available bus routes.
Use case: Journey planning and route discovery.

- GET /api/routes/busesLive
Provides real-time bus locations on randomly selected routes.
Use case: Live travel updates for passengers.

- POST /api/feedback
Accepts passenger feedback in JSON format.
Use case: Service improvement and issue tracking.

Technologies Used
Java
gRPC
MQTT
Spring Boot (REST)
Postman (API Testing)
