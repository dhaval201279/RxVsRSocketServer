package com.its.RxVsRSocketServer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NettyWebServerCustomizer implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {
    @Override
    public void customize(NettyReactiveWebServerFactory factory) {
        log.info("Entering NettyWebServerCustomizer : customize");
        factory.addServerCustomizers(httpServer -> httpServer.wiretap(Boolean.TRUE));
    }
}
