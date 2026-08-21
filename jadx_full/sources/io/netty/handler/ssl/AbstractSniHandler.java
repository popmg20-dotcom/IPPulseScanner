package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractSniHandler<T> extends SslClientHelloHandler<T> {
    private String hostname;

    private static String extractSniHostname(ByteBuf byteBuf) {
        int i = byteBuf.readerIndex();
        int iWriterIndex = byteBuf.writerIndex();
        int i2 = i + 34;
        if (iWriterIndex - i2 < 6) {
            return null;
        }
        int unsignedByte = byteBuf.getUnsignedByte(i2) + 1 + i2;
        int unsignedShort = byteBuf.getUnsignedShort(unsignedByte) + 2 + unsignedByte;
        int unsignedByte2 = byteBuf.getUnsignedByte(unsignedShort) + 1 + unsignedShort;
        int unsignedShort2 = byteBuf.getUnsignedShort(unsignedByte2);
        int i3 = unsignedByte2 + 2;
        int i4 = unsignedShort2 + i3;
        if (i4 > iWriterIndex) {
            return null;
        }
        while (i4 - i3 >= 4) {
            int unsignedShort3 = byteBuf.getUnsignedShort(i3);
            int unsignedShort4 = byteBuf.getUnsignedShort(i3 + 2);
            int i5 = i3 + 4;
            if (i4 - i5 < unsignedShort4) {
                return null;
            }
            if (unsignedShort3 == 0) {
                int i6 = i3 + 6;
                if (i4 - i6 < 3) {
                    return null;
                }
                int i7 = i3 + 7;
                if (byteBuf.getUnsignedByte(i6) != 0) {
                    return null;
                }
                int unsignedShort5 = byteBuf.getUnsignedShort(i7);
                int i8 = i3 + 9;
                if (i4 - i8 < unsignedShort5) {
                    return null;
                }
                return byteBuf.toString(i8, unsignedShort5, CharsetUtil.US_ASCII).toLowerCase(Locale.US);
            }
            i3 = i5 + unsignedShort4;
        }
        return null;
    }

    private static void fireSniCompletionEvent(ChannelHandlerContext channelHandlerContext, String str, Future<?> future) {
        Throwable thCause = future.cause();
        if (thCause == null) {
            channelHandlerContext.fireUserEventTriggered((Object) new SniCompletionEvent(str));
        } else {
            channelHandlerContext.fireUserEventTriggered((Object) new SniCompletionEvent(str, thCause));
        }
    }

    @Override // io.netty.handler.ssl.SslClientHelloHandler
    public Future<T> lookup(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        String strExtractSniHostname = byteBuf == null ? null : extractSniHostname(byteBuf);
        this.hostname = strExtractSniHostname;
        return lookup(channelHandlerContext, strExtractSniHostname);
    }

    public abstract Future<T> lookup(ChannelHandlerContext channelHandlerContext, String str);

    @Override // io.netty.handler.ssl.SslClientHelloHandler
    public void onLookupComplete(ChannelHandlerContext channelHandlerContext, Future<T> future) {
        try {
            onLookupComplete(channelHandlerContext, this.hostname, future);
        } finally {
            fireSniCompletionEvent(channelHandlerContext, this.hostname, future);
        }
    }

    public abstract void onLookupComplete(ChannelHandlerContext channelHandlerContext, String str, Future<T> future);
}
