package org.yzh.jt808.codec;

import org.yzh.framework.JTApplication;
import org.yzh.framework.mvc.DefaultHandlerMapping;
import org.yzh.framework.netty.JTConfig;
import org.yzh.protocol.codec.JTMessageDecoder;
import org.yzh.protocol.codec.JTMessageEncoder;

/**
 * 不依赖spring，快速启动netty服务
 */
public class QuickStart {

    public static void main(String[] args) {
        JTConfig jt808Config = new JTConfig.Builder()
                .setPort(7611)
                .setMaxFrameLength(1024)
                .setDelimiters(new byte[]{0x7e})
                .setHandlerMapping(new DefaultHandlerMapping("org.yzh.web.endpoint"))
                .setDecoder(new JTMessageDecoder("org.yzh.protocol"))
                .setEncoder(new JTMessageEncoder("org.yzh.protocol"))
                .build();

        JTApplication.run(jt808Config);
        System.out.println("***Netty 启动成功***");
    }
}