package io.netty.handler.codec.protobuf;

import defpackage.ml2;
import defpackage.nl2;
import defpackage.ol2;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@ChannelHandler.Sharable
public class ProtobufEncoder extends MessageToMessageEncoder<ol2> {
    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, ol2 ol2Var, List<Object> list) {
        if (ol2Var instanceof nl2) {
            list.add(Unpooled.wrappedBuffer(((nl2) ol2Var).j()));
        } else if (ol2Var instanceof ml2) {
            list.add(Unpooled.wrappedBuffer(((ml2) ol2Var).p().j()));
        }
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, ol2 ol2Var, List list) {
        encode2(channelHandlerContext, ol2Var, (List<Object>) list);
    }
}
