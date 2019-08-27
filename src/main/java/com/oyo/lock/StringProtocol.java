package com.oyo.lock;

import org.smartboot.socket.Protocol;
import org.smartboot.socket.transport.AioSession;

import java.nio.ByteBuffer;

/**
 * @author liurui
 * @time 2019-08-14 20:20
 */
public class StringProtocol implements Protocol<String> {
    public String decode(ByteBuffer buffer, AioSession<String> session) {
        buffer.mark(); // 1
        byte length = buffer.get(); // 2
        if (buffer.remaining() < length) { // 3
            buffer.reset(); // 4
            return null;
        }
        byte[] body = new byte[length];
        buffer.get(body); // 5
        buffer.mark(); // 6
        return new String(body); // 7
    }
}
