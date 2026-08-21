package io.netty.handler.codec.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class CompatibleObjectEncoder extends MessageToByteEncoder<Serializable> {
    private final int resetInterval;
    private int writtenObjects;

    public CompatibleObjectEncoder(int i) {
        this.resetInterval = ObjectUtil.checkPositiveOrZero(i, "resetInterval");
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Serializable serializable, ByteBuf byteBuf) throws IOException {
        ObjectOutputStream objectOutputStreamNewObjectOutputStream = newObjectOutputStream(new ByteBufOutputStream(byteBuf));
        try {
            int i = this.resetInterval;
            if (i != 0) {
                int i2 = this.writtenObjects + 1;
                this.writtenObjects = i2;
                if (i2 % i == 0) {
                    objectOutputStreamNewObjectOutputStream.reset();
                }
            }
            objectOutputStreamNewObjectOutputStream.writeObject(serializable);
            objectOutputStreamNewObjectOutputStream.flush();
            objectOutputStreamNewObjectOutputStream.close();
        } catch (Throwable th) {
            objectOutputStreamNewObjectOutputStream.close();
            throw th;
        }
    }

    public ObjectOutputStream newObjectOutputStream(OutputStream outputStream) {
        return new ObjectOutputStream(outputStream);
    }

    public CompatibleObjectEncoder() {
        this(16);
    }
}
