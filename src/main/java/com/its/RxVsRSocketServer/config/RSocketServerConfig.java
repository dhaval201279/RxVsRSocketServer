package com.its.RxVsRSocketServer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.annotation.ConnectMapping;
import org.springframework.stereotype.Controller;

import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

/*@Slf4j
@Controller
public class RSocketServerConfig {
    private final Map<String, RSocketRequester> REQUESTER_MAP = new HashMap<>();

    @ConnectMapping("connect")
    void setup(RSocketRequester requester, @Payload String client) {
        log.info("Entering RSocketServerConfig : setup for ConnectMapping(connect) with client : {}", client);
        requester
            .rsocket()
            .onClose()
            .doFirst(() -> {
                // Add all new clients to a client list
                log.info("RSocket Client : {} CONNECTED.", client);
                REQUESTER_MAP.put(client, requester);
            })
            .doOnError(error -> {
                // Warn when channels are closed by clients
                log.warn("Channel to client : {} CLOSED", client);
            })
            .doFinally(consumer -> {
                // Remove disconnected clients from the client map
                REQUESTER_MAP.remove(client);
                log.info("RSocket Client : {} DISCONNECTED", client);
            })
            .subscribe();

        log.info("Send status back to RSocket client...");

        requester
            .route("client-status")
            .data("RSocket client : " + client + " is connected!")
            .retrieveMono(String.class)
            //.doOnNext(s -> log.info("RSocket Client: {} , Free Memory: {}.", client, s))
            .subscribe(
                data -> log.info("Received data from the RSocket client: {}", data),
                error -> log.error("error : {}", error),
                () -> log.info("done")
            );
        log.info("Leaving RSocketServerConfig : setup for ConnectMapping(connect) with client : {}", client);
    }

    @PreDestroy
    void shutdown() {
        log.info("Detaching all remaining clients...");
        REQUESTER_MAP
            .keySet()
            .forEach(key -> {
                RSocketRequester requester = REQUESTER_MAP.get(key);
                log.info("RSocketRequester : {} for client : {} ", requester, key);
                requester
                    .rsocket()
                    .dispose();
            });
        log.info("Shutting down.");
    }
}*/
