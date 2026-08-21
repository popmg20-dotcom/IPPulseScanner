package io.netty.handler.codec.socksx.v5;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface Socks5CommandResponse extends Socks5Message {
    String bndAddr();

    Socks5AddressType bndAddrType();

    int bndPort();

    Socks5CommandStatus status();
}
