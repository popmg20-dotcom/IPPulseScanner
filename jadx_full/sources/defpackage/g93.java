package defpackage;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g93 extends NioSocketChannel {
    public final m32 b;

    public g93(m32 m32Var) {
        this.b = m32Var;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        socketAddress.getClass();
        channelPromise.getClass();
        try {
            Socket socket = javaChannel().socket();
            m32 m32Var = this.b;
            socket.getClass();
            if (!((Boolean) m32Var.g(socket)).booleanValue()) {
                throw new IOException("protect socket failed");
            }
            ChannelFuture channelFutureConnect = super.connect(socketAddress, socketAddress2, channelPromise);
            channelFutureConnect.getClass();
            return channelFutureConnect;
        } catch (Exception e) {
            channelPromise.setFailure((Throwable) e);
            return channelPromise;
        }
    }
}
