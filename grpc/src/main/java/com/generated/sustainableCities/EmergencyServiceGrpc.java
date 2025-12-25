package com.generated.sustainableCities;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * EmergencyService provides RPC methods to manage emergency response workflows
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: EmergencyService.proto")
public final class EmergencyServiceGrpc {

  private EmergencyServiceGrpc() {}

  public static final String SERVICE_NAME = "sustainableCities.EmergencyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.generated.sustainableCities.AccidentRequest,
      com.generated.sustainableCities.AccidentResponse> getReportAccidentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportAccident",
      requestType = com.generated.sustainableCities.AccidentRequest.class,
      responseType = com.generated.sustainableCities.AccidentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.generated.sustainableCities.AccidentRequest,
      com.generated.sustainableCities.AccidentResponse> getReportAccidentMethod() {
    io.grpc.MethodDescriptor<com.generated.sustainableCities.AccidentRequest, com.generated.sustainableCities.AccidentResponse> getReportAccidentMethod;
    if ((getReportAccidentMethod = EmergencyServiceGrpc.getReportAccidentMethod) == null) {
      synchronized (EmergencyServiceGrpc.class) {
        if ((getReportAccidentMethod = EmergencyServiceGrpc.getReportAccidentMethod) == null) {
          EmergencyServiceGrpc.getReportAccidentMethod = getReportAccidentMethod = 
              io.grpc.MethodDescriptor.<com.generated.sustainableCities.AccidentRequest, com.generated.sustainableCities.AccidentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sustainableCities.EmergencyService", "ReportAccident"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.generated.sustainableCities.AccidentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.generated.sustainableCities.AccidentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EmergencyServiceMethodDescriptorSupplier("ReportAccident"))
                  .build();
          }
        }
     }
     return getReportAccidentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.generated.sustainableCities.ServiceSubscriptionRequest,
      com.generated.sustainableCities.EmergencyNotification> getNotifyServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "NotifyServices",
      requestType = com.generated.sustainableCities.ServiceSubscriptionRequest.class,
      responseType = com.generated.sustainableCities.EmergencyNotification.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.generated.sustainableCities.ServiceSubscriptionRequest,
      com.generated.sustainableCities.EmergencyNotification> getNotifyServicesMethod() {
    io.grpc.MethodDescriptor<com.generated.sustainableCities.ServiceSubscriptionRequest, com.generated.sustainableCities.EmergencyNotification> getNotifyServicesMethod;
    if ((getNotifyServicesMethod = EmergencyServiceGrpc.getNotifyServicesMethod) == null) {
      synchronized (EmergencyServiceGrpc.class) {
        if ((getNotifyServicesMethod = EmergencyServiceGrpc.getNotifyServicesMethod) == null) {
          EmergencyServiceGrpc.getNotifyServicesMethod = getNotifyServicesMethod = 
              io.grpc.MethodDescriptor.<com.generated.sustainableCities.ServiceSubscriptionRequest, com.generated.sustainableCities.EmergencyNotification>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "sustainableCities.EmergencyService", "NotifyServices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.generated.sustainableCities.ServiceSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.generated.sustainableCities.EmergencyNotification.getDefaultInstance()))
                  .setSchemaDescriptor(new EmergencyServiceMethodDescriptorSupplier("NotifyServices"))
                  .build();
          }
        }
     }
     return getNotifyServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.generated.sustainableCities.PatientData,
      com.generated.sustainableCities.PatientReport> getUploadPatientDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadPatientData",
      requestType = com.generated.sustainableCities.PatientData.class,
      responseType = com.generated.sustainableCities.PatientReport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.generated.sustainableCities.PatientData,
      com.generated.sustainableCities.PatientReport> getUploadPatientDataMethod() {
    io.grpc.MethodDescriptor<com.generated.sustainableCities.PatientData, com.generated.sustainableCities.PatientReport> getUploadPatientDataMethod;
    if ((getUploadPatientDataMethod = EmergencyServiceGrpc.getUploadPatientDataMethod) == null) {
      synchronized (EmergencyServiceGrpc.class) {
        if ((getUploadPatientDataMethod = EmergencyServiceGrpc.getUploadPatientDataMethod) == null) {
          EmergencyServiceGrpc.getUploadPatientDataMethod = getUploadPatientDataMethod = 
              io.grpc.MethodDescriptor.<com.generated.sustainableCities.PatientData, com.generated.sustainableCities.PatientReport>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "sustainableCities.EmergencyService", "UploadPatientData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.generated.sustainableCities.PatientData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.generated.sustainableCities.PatientReport.getDefaultInstance()))
                  .setSchemaDescriptor(new EmergencyServiceMethodDescriptorSupplier("UploadPatientData"))
                  .build();
          }
        }
     }
     return getUploadPatientDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.generated.sustainableCities.AmbulanceStatus,
      com.generated.sustainableCities.RouteUpdate> getRouteOptimizationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RouteOptimization",
      requestType = com.generated.sustainableCities.AmbulanceStatus.class,
      responseType = com.generated.sustainableCities.RouteUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.generated.sustainableCities.AmbulanceStatus,
      com.generated.sustainableCities.RouteUpdate> getRouteOptimizationMethod() {
    io.grpc.MethodDescriptor<com.generated.sustainableCities.AmbulanceStatus, com.generated.sustainableCities.RouteUpdate> getRouteOptimizationMethod;
    if ((getRouteOptimizationMethod = EmergencyServiceGrpc.getRouteOptimizationMethod) == null) {
      synchronized (EmergencyServiceGrpc.class) {
        if ((getRouteOptimizationMethod = EmergencyServiceGrpc.getRouteOptimizationMethod) == null) {
          EmergencyServiceGrpc.getRouteOptimizationMethod = getRouteOptimizationMethod = 
              io.grpc.MethodDescriptor.<com.generated.sustainableCities.AmbulanceStatus, com.generated.sustainableCities.RouteUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "sustainableCities.EmergencyService", "RouteOptimization"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.generated.sustainableCities.AmbulanceStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.generated.sustainableCities.RouteUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new EmergencyServiceMethodDescriptorSupplier("RouteOptimization"))
                  .build();
          }
        }
     }
     return getRouteOptimizationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EmergencyServiceStub newStub(io.grpc.Channel channel) {
    return new EmergencyServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EmergencyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EmergencyServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EmergencyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EmergencyServiceFutureStub(channel);
  }

  /**
   * <pre>
   * EmergencyService provides RPC methods to manage emergency response workflows
   * </pre>
   */
  public static abstract class EmergencyServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 1. Unary gRPC for reporting a new accident with details
     * </pre>
     */
    public void reportAccident(com.generated.sustainableCities.AccidentRequest request,
        io.grpc.stub.StreamObserver<com.generated.sustainableCities.AccidentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReportAccidentMethod(), responseObserver);
    }

    /**
     * <pre>
     * 2. Server streaming gRPC to notify subscribed emergency services about relevant incidents
     * </pre>
     */
    public void notifyServices(com.generated.sustainableCities.ServiceSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.generated.sustainableCities.EmergencyNotification> responseObserver) {
      asyncUnimplementedUnaryCall(getNotifyServicesMethod(), responseObserver);
    }

    /**
     * <pre>
     * 3. Client streaming gRPC for ambulances to upload continuous patient data during transport
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.generated.sustainableCities.PatientData> uploadPatientData(
        io.grpc.stub.StreamObserver<com.generated.sustainableCities.PatientReport> responseObserver) {
      return asyncUnimplementedStreamingCall(getUploadPatientDataMethod(), responseObserver);
    }

    /**
     * <pre>
     * 4. Bidirectional streaming gRPC for real-time route optimization and ambulance status updates
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.generated.sustainableCities.AmbulanceStatus> routeOptimization(
        io.grpc.stub.StreamObserver<com.generated.sustainableCities.RouteUpdate> responseObserver) {
      return asyncUnimplementedStreamingCall(getRouteOptimizationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReportAccidentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.generated.sustainableCities.AccidentRequest,
                com.generated.sustainableCities.AccidentResponse>(
                  this, METHODID_REPORT_ACCIDENT)))
          .addMethod(
            getNotifyServicesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.generated.sustainableCities.ServiceSubscriptionRequest,
                com.generated.sustainableCities.EmergencyNotification>(
                  this, METHODID_NOTIFY_SERVICES)))
          .addMethod(
            getUploadPatientDataMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.generated.sustainableCities.PatientData,
                com.generated.sustainableCities.PatientReport>(
                  this, METHODID_UPLOAD_PATIENT_DATA)))
          .addMethod(
            getRouteOptimizationMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.generated.sustainableCities.AmbulanceStatus,
                com.generated.sustainableCities.RouteUpdate>(
                  this, METHODID_ROUTE_OPTIMIZATION)))
          .build();
    }
  }

  /**
   * <pre>
   * EmergencyService provides RPC methods to manage emergency response workflows
   * </pre>
   */
  public static final class EmergencyServiceStub extends io.grpc.stub.AbstractStub<EmergencyServiceStub> {
    private EmergencyServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmergencyServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmergencyServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmergencyServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. Unary gRPC for reporting a new accident with details
     * </pre>
     */
    public void reportAccident(com.generated.sustainableCities.AccidentRequest request,
        io.grpc.stub.StreamObserver<com.generated.sustainableCities.AccidentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReportAccidentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 2. Server streaming gRPC to notify subscribed emergency services about relevant incidents
     * </pre>
     */
    public void notifyServices(com.generated.sustainableCities.ServiceSubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.generated.sustainableCities.EmergencyNotification> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getNotifyServicesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 3. Client streaming gRPC for ambulances to upload continuous patient data during transport
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.generated.sustainableCities.PatientData> uploadPatientData(
        io.grpc.stub.StreamObserver<com.generated.sustainableCities.PatientReport> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getUploadPatientDataMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * 4. Bidirectional streaming gRPC for real-time route optimization and ambulance status updates
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.generated.sustainableCities.AmbulanceStatus> routeOptimization(
        io.grpc.stub.StreamObserver<com.generated.sustainableCities.RouteUpdate> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getRouteOptimizationMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * EmergencyService provides RPC methods to manage emergency response workflows
   * </pre>
   */
  public static final class EmergencyServiceBlockingStub extends io.grpc.stub.AbstractStub<EmergencyServiceBlockingStub> {
    private EmergencyServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmergencyServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmergencyServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmergencyServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. Unary gRPC for reporting a new accident with details
     * </pre>
     */
    public com.generated.sustainableCities.AccidentResponse reportAccident(com.generated.sustainableCities.AccidentRequest request) {
      return blockingUnaryCall(
          getChannel(), getReportAccidentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 2. Server streaming gRPC to notify subscribed emergency services about relevant incidents
     * </pre>
     */
    public java.util.Iterator<com.generated.sustainableCities.EmergencyNotification> notifyServices(
        com.generated.sustainableCities.ServiceSubscriptionRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getNotifyServicesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * EmergencyService provides RPC methods to manage emergency response workflows
   * </pre>
   */
  public static final class EmergencyServiceFutureStub extends io.grpc.stub.AbstractStub<EmergencyServiceFutureStub> {
    private EmergencyServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmergencyServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmergencyServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmergencyServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. Unary gRPC for reporting a new accident with details
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.generated.sustainableCities.AccidentResponse> reportAccident(
        com.generated.sustainableCities.AccidentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReportAccidentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REPORT_ACCIDENT = 0;
  private static final int METHODID_NOTIFY_SERVICES = 1;
  private static final int METHODID_UPLOAD_PATIENT_DATA = 2;
  private static final int METHODID_ROUTE_OPTIMIZATION = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EmergencyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EmergencyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REPORT_ACCIDENT:
          serviceImpl.reportAccident((com.generated.sustainableCities.AccidentRequest) request,
              (io.grpc.stub.StreamObserver<com.generated.sustainableCities.AccidentResponse>) responseObserver);
          break;
        case METHODID_NOTIFY_SERVICES:
          serviceImpl.notifyServices((com.generated.sustainableCities.ServiceSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.generated.sustainableCities.EmergencyNotification>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD_PATIENT_DATA:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.uploadPatientData(
              (io.grpc.stub.StreamObserver<com.generated.sustainableCities.PatientReport>) responseObserver);
        case METHODID_ROUTE_OPTIMIZATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.routeOptimization(
              (io.grpc.stub.StreamObserver<com.generated.sustainableCities.RouteUpdate>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EmergencyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EmergencyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.generated.sustainableCities.EmergencyServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EmergencyService");
    }
  }

  private static final class EmergencyServiceFileDescriptorSupplier
      extends EmergencyServiceBaseDescriptorSupplier {
    EmergencyServiceFileDescriptorSupplier() {}
  }

  private static final class EmergencyServiceMethodDescriptorSupplier
      extends EmergencyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EmergencyServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EmergencyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EmergencyServiceFileDescriptorSupplier())
              .addMethod(getReportAccidentMethod())
              .addMethod(getNotifyServicesMethod())
              .addMethod(getUploadPatientDataMethod())
              .addMethod(getRouteOptimizationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
