package io.github.nhatteam.jeri.service.controller.socket;

public interface IChatRoomSocket<S extends Record, P extends Number> {

    Object sendAndGetMessage(S request) throws Exception;

}
