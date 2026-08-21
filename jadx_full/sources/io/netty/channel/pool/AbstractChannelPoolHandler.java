package io.netty.channel.pool;

import io.netty.channel.Channel;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractChannelPoolHandler implements ChannelPoolHandler {
    @Override // io.netty.channel.pool.ChannelPoolHandler
    public void channelAcquired(Channel channel) {
    }

    @Override // io.netty.channel.pool.ChannelPoolHandler
    public void channelReleased(Channel channel) {
    }
}
