package defpackage;

import com.getsurfboard.ui.service.ExplorerService;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v81 extends ChannelInitializer {
    public final /* synthetic */ k5 b;

    public v81(k5 k5Var) {
        this.b = k5Var;
    }

    @Override // io.netty.channel.ChannelInitializer
    public final void initChannel(Channel channel) {
        SocketChannel socketChannel = (SocketChannel) channel;
        socketChannel.getClass();
        ChannelPipeline channelPipelinePipeline = socketChannel.pipeline();
        channelPipelinePipeline.addLast(new HttpServerCodec());
        channelPipelinePipeline.addLast(new HttpObjectAggregator(10485760));
        channelPipelinePipeline.addLast(new u81((ExplorerService) this.b.b));
    }

    @Override // io.netty.channel.ChannelHandlerAdapter
    public final boolean isSharable() {
        return true;
    }
}
