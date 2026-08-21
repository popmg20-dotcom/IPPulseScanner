package io.netty.handler.codec.protobuf;

import defpackage.i1;
import defpackage.l91;
import defpackage.nl2;
import defpackage.o91;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@ChannelHandler.Sharable
public class ProtobufDecoder extends MessageToMessageDecoder<ByteBuf> {
    private static final boolean HAS_PARSER;
    private final o91 extensionRegistry;
    private final nl2 prototype;

    static {
        boolean z;
        try {
            nl2.class.getDeclaredMethod("m", null);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        HAS_PARSER = z;
    }

    public ProtobufDecoder(nl2 nl2Var, o91 o91Var) {
        this.prototype = ((nl2) ObjectUtil.checkNotNull(nl2Var, "prototype")).a();
        this.extensionRegistry = o91Var;
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public void decode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        byte[] bytes;
        int iArrayOffset;
        int i = byteBuf.readableBytes();
        if (byteBuf.hasArray()) {
            bytes = byteBuf.array();
            iArrayOffset = byteBuf.readerIndex() + byteBuf.arrayOffset();
        } else {
            bytes = ByteBufUtil.getBytes(byteBuf, byteBuf.readerIndex(), i, false);
            iArrayOffset = 0;
        }
        o91 o91Var = this.extensionRegistry;
        nl2 nl2Var = this.prototype;
        if (o91Var == null) {
            if (HAS_PARSER) {
                list.add(((i1) nl2Var.m()).c(bytes, iArrayOffset, i, i1.a));
                return;
            } else {
                list.add(nl2Var.r().s(iArrayOffset, i, bytes).p());
                return;
            }
        }
        if (!HAS_PARSER) {
            list.add(nl2Var.r().F(bytes, iArrayOffset, i, this.extensionRegistry).p());
            return;
        }
        list.add(((i1) nl2Var.m()).c(bytes, iArrayOffset, i, this.extensionRegistry));
    }

    public ProtobufDecoder(nl2 nl2Var, l91 l91Var) {
        this(nl2Var, (o91) l91Var);
    }

    public ProtobufDecoder(nl2 nl2Var) {
        this(nl2Var, (l91) null);
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) {
        decode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }
}
