package io.netty.channel.unix;

import io.netty.channel.Channel;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface DomainDatagramChannel extends UnixChannel, Channel {
    @Override // io.netty.channel.Channel
    DomainDatagramChannelConfig config();

    boolean isConnected();

    @Override // io.netty.channel.Channel
    DomainSocketAddress localAddress();

    @Override // io.netty.channel.Channel
    DomainSocketAddress remoteAddress();
}
