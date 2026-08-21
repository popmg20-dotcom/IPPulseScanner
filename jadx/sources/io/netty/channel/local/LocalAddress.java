package io.netty.channel.local;

import defpackage.fw;
import defpackage.ha0;
import io.netty.channel.Channel;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class LocalAddress extends SocketAddress implements Comparable<LocalAddress> {
    public static final LocalAddress ANY = new LocalAddress("ANY");
    private static final long serialVersionUID = 4644331421130916435L;
    private final String id;
    private final String strVal;

    public LocalAddress(Channel channel) {
        StringBuilder sbB = fw.B(16, "local:E");
        sbB.append(Long.toHexString((((long) channel.hashCode()) & 4294967295L) | 4294967296L));
        sbB.setCharAt(7, ':');
        this.id = sbB.substring(6);
        this.strVal = sbB.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalAddress localAddress) {
        return this.id.compareTo(localAddress.id);
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocalAddress) {
            return this.id.equals(((LocalAddress) obj).id);
        }
        return false;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String id() {
        return this.id;
    }

    public String toString() {
        return this.strVal;
    }

    public LocalAddress(String str) {
        String lowerCase = ObjectUtil.checkNonEmptyAfterTrim(str, "id").toLowerCase();
        this.id = lowerCase;
        this.strVal = ha0.n("local:", lowerCase);
    }

    public LocalAddress(Class<?> cls) {
        this(cls.getSimpleName() + '/' + UUID.randomUUID());
    }
}
