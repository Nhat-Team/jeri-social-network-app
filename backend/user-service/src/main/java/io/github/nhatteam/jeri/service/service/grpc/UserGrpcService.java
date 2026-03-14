package io.github.nhatteam.jeri.service.service.grpc;

import io.github.nhatteam.jeri.service.IdProtoRequest;
import io.github.nhatteam.jeri.service.UserServiceProtoGrpc;
import io.github.nhatteam.jeri.service.UserServiceProtoResponse;
import io.github.nhatteam.jeri.service.model.vo.UserVo;
import io.github.nhatteam.jeri.service.service.UserService;
import io.grpc.stub.StreamObserver;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserGrpcService extends UserServiceProtoGrpc.UserServiceProtoImplBase {

    UserService userService;

    @Override
    public void getUserInformation(IdProtoRequest request, StreamObserver<UserServiceProtoResponse> responseObserver) {
        UserVo userVo = userService.getById(request.getId());
        UserServiceProtoResponse response = UserServiceProtoResponse.newBuilder()
                .setId(userVo.getId())
                .setFirstName(userVo.getFirstName())
                .setLastName(userVo.getLastName())
                .setEmail(userVo.getEmail())
                .setPhone(userVo.getPhone())
                .setAvatar(userVo.getAvatar())
                .setAvatarUrl(userVo.getAvatarUrl())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
