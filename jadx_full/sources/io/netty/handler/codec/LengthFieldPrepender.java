package io.netty.handler.codec;

import defpackage.dw2;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@ChannelHandler.Sharable
public class LengthFieldPrepender extends MessageToMessageEncoder<ByteBuf> {
    private final ByteOrder byteOrder;
    private final int lengthAdjustment;
    private final int lengthFieldLength;
    private final boolean lengthIncludesLengthFieldLength;

    public LengthFieldPrepender(ByteOrder byteOrder, int i, int i2, boolean z) {
        if (i != 1 && i != 2 && i != 3 && i != 4 && i != 8) {
            xe.k(dw2.A(i, "lengthFieldLength must be either 1, 2, 3, 4, or 8: "));
            throw null;
        }
        this.byteOrder = (ByteOrder) ObjectUtil.checkNotNull(byteOrder, "byteOrder");
        this.lengthFieldLength = i;
        this.lengthIncludesLengthFieldLength = z;
        this.lengthAdjustment = i2;
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int i = byteBuf.readableBytes() + this.lengthAdjustment;
        if (this.lengthIncludesLengthFieldLength) {
            i += this.lengthFieldLength;
        }
        ObjectUtil.checkPositiveOrZero(i, "length");
        int i2 = this.lengthFieldLength;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        list.add(channelHandlerContext.alloc().buffer(4).order(this.byteOrder).writeInt(i));
                    } else {
                        if (i2 != 8) {
                            throw new Error("should not reach here");
                        }
                        list.add(channelHandlerContext.alloc().buffer(8).order(this.byteOrder).writeLong(i));
                    }
                } else {
                    if (i >= 16777216) {
                        xe.k(dw2.A(i, "length does not fit into a medium integer: "));
                        return;
                    }
                    list.add(channelHandlerContext.alloc().buffer(3).order(this.byteOrder).writeMedium(i));
                }
            } else {
                if (i >= 65536) {
                    xe.k(dw2.A(i, "length does not fit into a short integer: "));
                    return;
                }
                list.add(channelHandlerContext.alloc().buffer(2).order(this.byteOrder).writeShort((short) i));
            }
        } else {
            if (i >= 256) {
                xe.k(dw2.A(i, "length does not fit into a byte: "));
                return;
            }
            list.add(channelHandlerContext.alloc().buffer(1).order(this.byteOrder).writeByte((byte) i));
        }
        list.add(byteBuf.retain());
    }

    public LengthFieldPrepender(int i, boolean z) {
        this(i, 0, z);
    }

    public LengthFieldPrepender(int i, int i2) {
        this(i, i2, false);
    }

    public LengthFieldPrepender(int i, int i2, boolean z) {
        this(ByteOrder.BIG_ENDIAN, i, i2, z);
    }

    public LengthFieldPrepender(int i) {
        this(i, false);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) {
        encode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }
}
