package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ByteToMessageCodec<I> extends ChannelDuplexHandler {
    private final ByteToMessageDecoder decoder;
    private final MessageToByteEncoder<I> encoder;
    private final TypeParameterMatcher outboundMsgMatcher;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public final class Encoder extends MessageToByteEncoder<I> {
        public Encoder(boolean z) {
            super(z);
        }

        @Override // io.netty.handler.codec.MessageToByteEncoder
        public boolean acceptOutboundMessage(Object obj) {
            return ByteToMessageCodec.this.acceptOutboundMessage(obj);
        }

        @Override // io.netty.handler.codec.MessageToByteEncoder
        public void encode(ChannelHandlerContext channelHandlerContext, I i, ByteBuf byteBuf) {
            ByteToMessageCodec.this.encode(channelHandlerContext, i, byteBuf);
        }
    }

    public ByteToMessageCodec(boolean z) {
        this.decoder = new ByteToMessageDecoder() { // from class: io.netty.handler.codec.ByteToMessageCodec.1
            @Override // io.netty.handler.codec.ByteToMessageDecoder
            public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
                ByteToMessageCodec.this.decode(channelHandlerContext, byteBuf, list);
            }

            @Override // io.netty.handler.codec.ByteToMessageDecoder
            public void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
                ByteToMessageCodec.this.decodeLast(channelHandlerContext, byteBuf, list);
            }
        };
        ensureNotSharable();
        this.outboundMsgMatcher = TypeParameterMatcher.find(this, ByteToMessageCodec.class, "I");
        this.encoder = new Encoder(z);
    }

    public boolean acceptOutboundMessage(Object obj) {
        return this.outboundMsgMatcher.match(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        this.decoder.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        this.decoder.channelRead(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        this.decoder.channelReadComplete(channelHandlerContext);
    }

    public abstract void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list);

    public void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        if (byteBuf.isReadable()) {
            decode(channelHandlerContext, byteBuf, list);
        }
    }

    public abstract void encode(ChannelHandlerContext channelHandlerContext, I i, ByteBuf byteBuf);

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        try {
            this.decoder.handlerAdded(channelHandlerContext);
        } finally {
            this.encoder.handlerAdded(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        try {
            this.decoder.handlerRemoved(channelHandlerContext);
        } finally {
            this.encoder.handlerRemoved(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        this.encoder.write(channelHandlerContext, obj, channelPromise);
    }

    public ByteToMessageCodec(Class<? extends I> cls) {
        this(cls, true);
    }

    public ByteToMessageCodec() {
        this(true);
    }

    public ByteToMessageCodec(Class<? extends I> cls, boolean z) {
        this.decoder = new ByteToMessageDecoder() { // from class: io.netty.handler.codec.ByteToMessageCodec.1
            @Override // io.netty.handler.codec.ByteToMessageDecoder
            public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
                ByteToMessageCodec.this.decode(channelHandlerContext, byteBuf, list);
            }

            @Override // io.netty.handler.codec.ByteToMessageDecoder
            public void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
                ByteToMessageCodec.this.decodeLast(channelHandlerContext, byteBuf, list);
            }
        };
        ensureNotSharable();
        this.outboundMsgMatcher = TypeParameterMatcher.get(cls);
        this.encoder = new Encoder(z);
    }
}
