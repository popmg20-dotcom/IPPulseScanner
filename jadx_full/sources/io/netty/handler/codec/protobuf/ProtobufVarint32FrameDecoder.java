package io.netty.handler.codec.protobuf;

import defpackage.dw2;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ProtobufVarint32FrameDecoder extends ByteToMessageDecoder {
    private static int readRawVarint32(ByteBuf byteBuf) {
        int i;
        if (!byteBuf.isReadable()) {
            return 0;
        }
        byteBuf.markReaderIndex();
        byte b = byteBuf.readByte();
        if (b >= 0) {
            return b;
        }
        int i2 = b & 127;
        if (!byteBuf.isReadable()) {
            byteBuf.resetReaderIndex();
            return 0;
        }
        byte b2 = byteBuf.readByte();
        if (b2 >= 0) {
            i = b2 << 7;
        } else {
            i2 |= (b2 & 127) << 7;
            if (!byteBuf.isReadable()) {
                byteBuf.resetReaderIndex();
                return 0;
            }
            byte b3 = byteBuf.readByte();
            if (b3 >= 0) {
                i = b3 << 14;
            } else {
                i2 |= (b3 & 127) << 14;
                if (!byteBuf.isReadable()) {
                    byteBuf.resetReaderIndex();
                    return 0;
                }
                byte b4 = byteBuf.readByte();
                if (b4 < 0) {
                    int i3 = i2 | ((b4 & 127) << 21);
                    if (!byteBuf.isReadable()) {
                        byteBuf.resetReaderIndex();
                        return 0;
                    }
                    byte b5 = byteBuf.readByte();
                    int i4 = i3 | (b5 << 28);
                    if (b5 >= 0) {
                        return i4;
                    }
                    throw new CorruptedFrameException("malformed varint.");
                }
                i = b4 << 21;
            }
        }
        return i | i2;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        byteBuf.markReaderIndex();
        int i = byteBuf.readerIndex();
        int rawVarint32 = readRawVarint32(byteBuf);
        if (i == byteBuf.readerIndex()) {
            return;
        }
        if (rawVarint32 < 0) {
            throw new CorruptedFrameException(dw2.A(rawVarint32, "negative length: "));
        }
        if (byteBuf.readableBytes() < rawVarint32) {
            byteBuf.resetReaderIndex();
        } else {
            list.add(byteBuf.readRetainedSlice(rawVarint32));
        }
    }
}
