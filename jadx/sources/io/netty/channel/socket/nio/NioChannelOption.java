package io.netty.channel.socket.nio;

import defpackage.s53;
import defpackage.zo2;
import io.netty.channel.ChannelOption;
import java.io.IOException;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.Channel;
import java.nio.channels.NetworkChannel;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class NioChannelOption<T> extends ChannelOption<T> {
    private final SocketOption<T> option;

    private NioChannelOption(SocketOption<T> socketOption) {
        super(socketOption.name());
        this.option = socketOption;
    }

    public static <T> T getOption(Channel channel, NioChannelOption<T> nioChannelOption) {
        NetworkChannel networkChannelD = zo2.d(channel);
        if (!networkChannelD.supportedOptions().contains(((NioChannelOption) nioChannelOption).option)) {
            return null;
        }
        if ((networkChannelD instanceof ServerSocketChannel) && ((NioChannelOption) nioChannelOption).option == StandardSocketOptions.IP_TOS) {
            return null;
        }
        try {
            return (T) networkChannelD.getOption(((NioChannelOption) nioChannelOption).option);
        } catch (IOException e) {
            s53.q(e);
            return null;
        }
    }

    public static ChannelOption[] getOptions(Channel channel) {
        NetworkChannel networkChannelD = zo2.d(channel);
        Set<SocketOption<?>> setSupportedOptions = networkChannelD.supportedOptions();
        int i = 0;
        if (!(networkChannelD instanceof ServerSocketChannel)) {
            ChannelOption[] channelOptionArr = new ChannelOption[setSupportedOptions.size()];
            Iterator<SocketOption<?>> it = setSupportedOptions.iterator();
            while (it.hasNext()) {
                channelOptionArr[i] = new NioChannelOption(zo2.b(it.next()));
                i++;
            }
            return channelOptionArr;
        }
        ArrayList arrayList = new ArrayList(setSupportedOptions.size());
        Iterator<SocketOption<?>> it2 = setSupportedOptions.iterator();
        while (it2.hasNext()) {
            SocketOption socketOptionB = zo2.b(it2.next());
            if (socketOptionB != StandardSocketOptions.IP_TOS) {
                arrayList.add(new NioChannelOption(socketOptionB));
            }
        }
        return (ChannelOption[]) arrayList.toArray(new ChannelOption[0]);
    }

    public static <T> ChannelOption<T> of(SocketOption<T> socketOption) {
        return new NioChannelOption(socketOption);
    }

    public static <T> boolean setOption(Channel channel, NioChannelOption<T> nioChannelOption, T t) {
        NetworkChannel networkChannelD = zo2.d(channel);
        if (!networkChannelD.supportedOptions().contains(((NioChannelOption) nioChannelOption).option)) {
            return false;
        }
        if ((networkChannelD instanceof ServerSocketChannel) && ((NioChannelOption) nioChannelOption).option == StandardSocketOptions.IP_TOS) {
            return false;
        }
        try {
            networkChannelD.setOption(((NioChannelOption) nioChannelOption).option, t);
            return true;
        } catch (IOException e) {
            s53.q(e);
            return false;
        }
    }
}
