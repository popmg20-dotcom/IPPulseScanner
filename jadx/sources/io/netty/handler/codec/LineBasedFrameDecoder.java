package io.netty.handler.codec;

import defpackage.fw;
import defpackage.ha0;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ByteProcessor;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class LineBasedFrameDecoder extends ByteToMessageDecoder {
    private int discardedBytes;
    private boolean discarding;
    private final boolean failFast;
    private final int maxLength;
    private int offset;
    private final boolean stripDelimiter;

    public LineBasedFrameDecoder(int i, boolean z, boolean z2) {
        this.maxLength = i;
        this.failFast = z2;
        this.stripDelimiter = z;
    }

    private void fail(ChannelHandlerContext channelHandlerContext, String str) {
        channelHandlerContext.fireExceptionCaught((Throwable) new TooLongFrameException(ha0.p(fw.D("frame length (", str, ") exceeds the allowed maximum ("), this.maxLength, ')')));
    }

    private int findEndOfLine(ByteBuf byteBuf) {
        int i = byteBuf.readableBytes();
        int i2 = byteBuf.readerIndex();
        int i3 = this.offset;
        int iForEachByte = byteBuf.forEachByte(i2 + i3, i - i3, ByteProcessor.FIND_LF);
        if (iForEachByte >= 0) {
            this.offset = 0;
            return (iForEachByte <= 0 || byteBuf.getByte(iForEachByte + (-1)) != 13) ? iForEachByte : iForEachByte - 1;
        }
        this.offset = i;
        return iForEachByte;
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        int iFindEndOfLine = findEndOfLine(byteBuf);
        if (this.discarding) {
            int i = this.discardedBytes;
            if (iFindEndOfLine >= 0) {
                int i2 = (i + iFindEndOfLine) - byteBuf.readerIndex();
                byteBuf.readerIndex(iFindEndOfLine + (byteBuf.getByte(iFindEndOfLine) != 13 ? 1 : 2));
                this.discardedBytes = 0;
                this.discarding = false;
                if (!this.failFast) {
                    fail(channelHandlerContext, i2);
                }
            } else {
                this.discardedBytes = byteBuf.readableBytes() + i;
                byteBuf.readerIndex(byteBuf.writerIndex());
                this.offset = 0;
            }
            return null;
        }
        if (iFindEndOfLine >= 0) {
            int i3 = iFindEndOfLine - byteBuf.readerIndex();
            int i4 = byteBuf.getByte(iFindEndOfLine) != 13 ? 1 : 2;
            if (i3 > this.maxLength) {
                byteBuf.readerIndex(iFindEndOfLine + i4);
                fail(channelHandlerContext, i3);
                return null;
            }
            if (!this.stripDelimiter) {
                return byteBuf.readRetainedSlice(i3 + i4);
            }
            ByteBuf retainedSlice = byteBuf.readRetainedSlice(i3);
            byteBuf.skipBytes(i4);
            return retainedSlice;
        }
        int i5 = byteBuf.readableBytes();
        if (i5 > this.maxLength) {
            this.discardedBytes = i5;
            byteBuf.readerIndex(byteBuf.writerIndex());
            this.discarding = true;
            this.offset = 0;
            if (this.failFast) {
                fail(channelHandlerContext, "over " + this.discardedBytes);
            }
        }
        return null;
    }

    public LineBasedFrameDecoder(int i) {
        this(i, true, false);
    }

    private void fail(ChannelHandlerContext channelHandlerContext, int i) {
        fail(channelHandlerContext, String.valueOf(i));
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        Object objDecode = decode(channelHandlerContext, byteBuf);
        if (objDecode != null) {
            list.add(objDecode);
        }
    }
}
