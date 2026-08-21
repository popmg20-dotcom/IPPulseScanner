package io.netty.channel.unix;

import io.netty.channel.socket.DuplexChannel;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface DomainSocketChannel extends UnixChannel, DuplexChannel {
    @Override // io.netty.channel.Channel
    DomainSocketChannelConfig config();

    @Override // io.netty.channel.Channel
    DomainSocketAddress localAddress();

    @Override // io.netty.channel.Channel
    DomainSocketAddress remoteAddress();
}
