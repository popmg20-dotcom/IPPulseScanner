package io.netty.channel.unix;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class DatagramSocketAddress extends InetSocketAddress {
    private static final long serialVersionUID = 3094819287843178401L;
    private final DatagramSocketAddress localAddress;
    private final int receivedAmount;

    public DatagramSocketAddress(byte[] bArr, int i, int i2, int i3, DatagramSocketAddress datagramSocketAddress) {
        super(newAddress(bArr, i), i2);
        this.receivedAmount = i3;
        this.localAddress = datagramSocketAddress;
    }

    private static InetAddress newAddress(byte[] bArr, int i) {
        return bArr.length == 4 ? InetAddress.getByAddress(bArr) : Inet6Address.getByAddress((String) null, bArr, i);
    }

    public DatagramSocketAddress localAddress() {
        return this.localAddress;
    }

    public int receivedAmount() {
        return this.receivedAmount;
    }
}
