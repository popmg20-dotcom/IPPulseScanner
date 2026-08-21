package io.netty.handler.codec.socksx;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.socksx.v4.Socks4ServerDecoder;
import io.netty.handler.codec.socksx.v4.Socks4ServerEncoder;
import io.netty.handler.codec.socksx.v5.Socks5InitialRequestDecoder;
import io.netty.handler.codec.socksx.v5.Socks5ServerEncoder;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class SocksPortUnificationServerHandler extends ByteToMessageDecoder {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SocksPortUnificationServerHandler.class);
    private final Socks5ServerEncoder socks5encoder;

    /* JADX INFO: renamed from: io.netty.handler.codec.socksx.SocksPortUnificationServerHandler$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socksx$SocksVersion;

        static {
            int[] iArr = new int[SocksVersion.values().length];
            $SwitchMap$io$netty$handler$codec$socksx$SocksVersion = iArr;
            try {
                iArr[SocksVersion.SOCKS4a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$SocksVersion[SocksVersion.SOCKS5.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SocksPortUnificationServerHandler(Socks5ServerEncoder socks5ServerEncoder) {
        this.socks5encoder = (Socks5ServerEncoder) ObjectUtil.checkNotNull(socks5ServerEncoder, "socks5encoder");
    }

    private static void logKnownVersion(ChannelHandlerContext channelHandlerContext, SocksVersion socksVersion) {
        logger.debug("{} Protocol version: {}({})", channelHandlerContext.channel(), socksVersion);
    }

    private static void logUnknownVersion(ChannelHandlerContext channelHandlerContext, byte b) {
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} Unknown protocol version: {}", channelHandlerContext.channel(), Integer.valueOf(b & 255));
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int i = byteBuf.readerIndex();
        if (byteBuf.writerIndex() == i) {
            return;
        }
        ChannelPipeline channelPipelinePipeline = channelHandlerContext.pipeline();
        byte b = byteBuf.getByte(i);
        SocksVersion socksVersionValueOf = SocksVersion.valueOf(b);
        int i2 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socksx$SocksVersion[socksVersionValueOf.ordinal()];
        if (i2 == 1) {
            logKnownVersion(channelHandlerContext, socksVersionValueOf);
            channelPipelinePipeline.addAfter(channelHandlerContext.name(), null, Socks4ServerEncoder.INSTANCE);
            channelPipelinePipeline.addAfter(channelHandlerContext.name(), null, new Socks4ServerDecoder());
        } else if (i2 != 2) {
            logUnknownVersion(channelHandlerContext, b);
            byteBuf.skipBytes(byteBuf.readableBytes());
            channelHandlerContext.close();
            return;
        } else {
            logKnownVersion(channelHandlerContext, socksVersionValueOf);
            channelPipelinePipeline.addAfter(channelHandlerContext.name(), null, this.socks5encoder);
            channelPipelinePipeline.addAfter(channelHandlerContext.name(), null, new Socks5InitialRequestDecoder());
        }
        channelPipelinePipeline.remove(this);
    }

    public SocksPortUnificationServerHandler() {
        this(Socks5ServerEncoder.DEFAULT);
    }
}
