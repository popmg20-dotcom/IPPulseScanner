package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class HttpContentDecoder extends MessageToMessageDecoder<HttpObject> {
    static final String IDENTITY = HttpHeaderValues.IDENTITY.toString();
    private boolean continueResponse;
    protected ChannelHandlerContext ctx;
    private EmbeddedChannel decoder;
    private boolean needRead = true;

    private void cleanup() {
        EmbeddedChannel embeddedChannel = this.decoder;
        if (embeddedChannel != null) {
            embeddedChannel.finishAndReleaseAll();
            this.decoder = null;
        }
    }

    private void cleanupSafely(ChannelHandlerContext channelHandlerContext) {
        try {
            cleanup();
        } catch (Throwable th) {
            channelHandlerContext.fireExceptionCaught(th);
        }
    }

    private void decodeContent(HttpContent httpContent, List<Object> list) throws Throwable {
        decode(httpContent.content(), list);
        if (httpContent instanceof LastHttpContent) {
            finishDecode(list);
            HttpHeaders httpHeadersTrailingHeaders = ((LastHttpContent) httpContent).trailingHeaders();
            if (httpHeadersTrailingHeaders.isEmpty()) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
            } else {
                list.add(new ComposedLastHttpContent(httpHeadersTrailingHeaders, DecoderResult.SUCCESS));
            }
        }
    }

    private void fetchDecoderOutput(List<Object> list) {
        while (true) {
            ByteBuf byteBuf = (ByteBuf) this.decoder.readInbound();
            if (byteBuf == null) {
                return;
            }
            if (byteBuf.isReadable()) {
                list.add(new DefaultHttpContent(byteBuf));
            } else {
                byteBuf.release();
            }
        }
    }

    private void finishDecode(List<Object> list) {
        if (this.decoder.finish()) {
            fetchDecoderOutput(list);
        }
        this.decoder = null;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        cleanupSafely(channelHandlerContext);
        super.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        boolean z = this.needRead;
        this.needRead = true;
        try {
            channelHandlerContext.fireChannelReadComplete();
        } finally {
            if (z && !channelHandlerContext.channel().config().isAutoRead()) {
                channelHandlerContext.read();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0125 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x0015, B:9:0x0019, B:12:0x0020, B:15:0x002e, B:17:0x0033, B:19:0x0037, B:20:0x0039, B:21:0x0041, B:23:0x0045, B:25:0x0057, B:33:0x007d, B:35:0x0085, B:37:0x0089, B:38:0x008f, B:39:0x0093, B:41:0x009b, B:42:0x00a5, B:44:0x00b1, B:46:0x00b8, B:48:0x00bc, B:50:0x00c0, B:54:0x00e9, B:51:0x00d5, B:53:0x00d9, B:55:0x00ff, B:56:0x011d, B:57:0x011e, B:45:0x00b5, B:26:0x005c, B:28:0x0064, B:30:0x006d, B:31:0x0076, B:32:0x007b, B:58:0x0121, B:60:0x0125, B:62:0x012b, B:63:0x0134), top: B:67:0x0002 }] */
    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void decode2(io.netty.channel.ChannelHandlerContext r8, io.netty.handler.codec.http.HttpObject r9, java.util.List<java.lang.Object> r10) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.HttpContentDecoder.decode2(io.netty.channel.ChannelHandlerContext, io.netty.handler.codec.http.HttpObject, java.util.List):void");
    }

    public String getTargetContentEncoding(String str) {
        return IDENTITY;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        this.ctx = channelHandlerContext;
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        cleanupSafely(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    public abstract EmbeddedChannel newContentDecoder(String str);

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List list) {
        decode2(channelHandlerContext, httpObject, (List<Object>) list);
    }

    private void decode(ByteBuf byteBuf, List<Object> list) throws Throwable {
        this.decoder.writeInbound(byteBuf.retain());
        fetchDecoderOutput(list);
    }
}
