package io.netty.channel.local;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class LocalChannelRegistry {
    private static final ConcurrentMap<LocalAddress, Channel> boundChannels = PlatformDependent.newConcurrentHashMap();

    private LocalChannelRegistry() {
    }

    public static Channel get(SocketAddress socketAddress) {
        return boundChannels.get(socketAddress);
    }

    public static LocalAddress register(Channel channel, LocalAddress localAddress, SocketAddress socketAddress) {
        if (localAddress != null) {
            throw new ChannelException("already bound");
        }
        if (!(socketAddress instanceof LocalAddress)) {
            throw new ChannelException("unsupported address type: " + StringUtil.simpleClassName(socketAddress));
        }
        LocalAddress localAddress2 = (LocalAddress) socketAddress;
        if (LocalAddress.ANY.equals(localAddress2)) {
            localAddress2 = new LocalAddress(channel);
        }
        Channel channelPutIfAbsent = boundChannels.putIfAbsent(localAddress2, channel);
        if (channelPutIfAbsent == null) {
            return localAddress2;
        }
        throw new ChannelException("address already in use by: " + channelPutIfAbsent);
    }

    public static void unregister(LocalAddress localAddress) {
        boundChannels.remove(localAddress);
    }
}
