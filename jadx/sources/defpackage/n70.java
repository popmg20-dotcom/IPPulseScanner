package defpackage;

import io.netty.handler.codec.dns.DnsRecord;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n70 {
    public final byte a;
    public final byte b;
    public final short c;
    public final String d;
    public final int e;

    public n70(int i, int i2, String str) {
        this.d = str;
        this.e = i2;
        this.c = (short) (65535 & i);
        this.b = (byte) ((i >> 16) & DnsRecord.CLASS_ANY);
        this.a = (byte) ((i >> 24) & DnsRecord.CLASS_ANY);
    }
}
