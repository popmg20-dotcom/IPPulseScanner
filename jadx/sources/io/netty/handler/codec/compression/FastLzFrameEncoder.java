package io.netty.handler.codec.compression;

import defpackage.zo2;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.MessageToByteEncoder;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class FastLzFrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private final ByteBufChecksum checksum;
    private final int level;

    public FastLzFrameEncoder(int i, Checksum checksum) {
        if (i != 0 && i != 1 && i != 2) {
            zo2.p("level: %d (expected: %d or %d or %d)", new Object[]{Integer.valueOf(i), 0, 1, 2});
            throw null;
        }
        this.level = i;
        this.checksum = checksum != null ? ByteBufChecksum.wrapChecksum(checksum) : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008d A[SYNTHETIC] */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void encode(io.netty.channel.ChannelHandlerContext r12, io.netty.buffer.ByteBuf r13, io.netty.buffer.ByteBuf r14) {
        /*
            r11 = this;
            io.netty.handler.codec.compression.ByteBufChecksum r12 = r11.checksum
        L2:
            boolean r0 = r13.isReadable()
            if (r0 != 0) goto L9
            return
        L9:
            int r0 = r13.readerIndex()
            int r1 = r13.readableBytes()
            r2 = 65535(0xffff, float:9.1834E-41)
            int r5 = java.lang.Math.min(r1, r2)
            int r1 = r14.writerIndex()
            r2 = 4607066(0x464c5a, float:6.455875E-39)
            r14.setMedium(r1, r2)
            int r2 = r1 + 4
            r9 = 0
            if (r12 == 0) goto L29
            r3 = 4
            goto L2a
        L29:
            r3 = r9
        L2a:
            int r10 = r2 + r3
            r3 = 32
            if (r5 >= r3) goto L4f
            int r3 = r10 + 2
            int r4 = r3 + r5
            r14.ensureWritable(r4)
            if (r12 == 0) goto L47
            r12.reset()
            r12.update(r13, r0, r5)
            long r6 = r12.getValue()
            int r4 = (int) r6
            r14.setInt(r2, r4)
        L47:
            r14.setBytes(r3, r13, r0, r5)
            r3 = r13
            r6 = r14
        L4c:
            r13 = r5
            r14 = r9
            goto L84
        L4f:
            if (r12 == 0) goto L5f
            r12.reset()
            r12.update(r13, r0, r5)
            long r3 = r12.getValue()
            int r3 = (int) r3
            r14.setInt(r2, r3)
        L5f:
            int r2 = io.netty.handler.codec.compression.FastLz.calculateOutputBufferLength(r5)
            int r7 = r10 + 4
            int r2 = r2 + r7
            r14.ensureWritable(r2)
            int r4 = r13.readerIndex()
            int r8 = r11.level
            r3 = r13
            r6 = r14
            int r13 = io.netty.handler.codec.compression.FastLz.compress(r3, r4, r5, r6, r7, r8)
            if (r13 >= r5) goto L7e
            r6.setShort(r10, r13)
            int r10 = r10 + 2
            r14 = 1
            goto L84
        L7e:
            int r13 = r10 + 2
            r6.setBytes(r13, r3, r0, r5)
            goto L4c
        L84:
            r6.setShort(r10, r5)
            int r1 = r1 + 3
            if (r12 == 0) goto L8d
            r9 = 16
        L8d:
            r14 = r14 | r9
            r6.setByte(r1, r14)
            int r10 = r10 + 2
            int r10 = r10 + r13
            r6.writerIndex(r10)
            r3.skipBytes(r5)
            r13 = r3
            r14 = r6
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.FastLzFrameEncoder.encode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):void");
    }

    public FastLzFrameEncoder(int i) {
        this(i, null);
    }

    public FastLzFrameEncoder(boolean z) {
        this(0, z ? new Adler32() : null);
    }

    public FastLzFrameEncoder() {
        this(0, null);
    }
}
