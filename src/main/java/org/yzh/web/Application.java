package org.yzh.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.yzh.framework.JTApplication;
import org.yzh.framework.mvc.HandlerMapping;
import org.yzh.framework.mvc.SpringHandlerMapping;
import org.yzh.framework.netty.JTConfig;
import org.yzh.web.jt.codec.JTMessageDecoder;
import org.yzh.web.jt.codec.JTMessageEncoder;

@EnableWebSocket
@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        log.info("***Spring 启动成功***");
    }

    @Bean
    public ApplicationRunner runner() {
        return arguments -> {
            JTConfig jt808Config = new JTConfig.Builder()
                    .setPort(7611)
                    .setMaxFrameLength(1024)
                    .setDelimiters(new byte[]{0x7e})
                    .setHandlerMapping(handlerMapping())
                    .setDecoder(new JTMessageDecoder("org.yzh.web.jt"))
                    .setEncoder(new JTMessageEncoder("org.yzh.web.jt"))
                    .build();

            JTConfig jt1078Config = new JTConfig.Builder()
                    .setPort(7612)
                    .setMaxFrameLength(1024)
                    .setDelimiters(new byte[]{0x7e})
                    .setHandlerMapping(handlerMapping())
                    .setDecoder(new JTMessageDecoder("org.yzh.web.jt"))
                    .setEncoder(new JTMessageEncoder("org.yzh.web.jt"))
                    .build();
            JTApplication.run(jt808Config, jt1078Config);
            System.out.println("***Netty 启动成功***");
        };
    }

    @Bean
    public HandlerMapping handlerMapping() {
        return new SpringHandlerMapping("org.yzh.web.endpoint");
    }
}