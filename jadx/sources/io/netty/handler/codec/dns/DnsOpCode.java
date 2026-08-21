package io.netty.handler.codec.dns;

import defpackage.ha0;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class DnsOpCode implements Comparable<DnsOpCode> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final DnsOpCode QUERY = new DnsOpCode(0, "QUERY");
    public static final DnsOpCode IQUERY = new DnsOpCode(1, "IQUERY");
    public static final DnsOpCode STATUS = new DnsOpCode(2, "STATUS");
    public static final DnsOpCode NOTIFY = new DnsOpCode(4, "NOTIFY");
    public static final DnsOpCode UPDATE = new DnsOpCode(5, "UPDATE");

    public DnsOpCode(int i, String str) {
        this.byteValue = (byte) i;
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
    }

    public static DnsOpCode valueOf(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 4 ? i != 5 ? new DnsOpCode(i) : UPDATE : NOTIFY : STATUS : IQUERY : QUERY;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DnsOpCode) && this.byteValue == ((DnsOpCode) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public String toString() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('(');
        String strP = ha0.p(sb, this.byteValue & 255, ')');
        this.text = strP;
        return strP;
    }

    @Override // java.lang.Comparable
    public int compareTo(DnsOpCode dnsOpCode) {
        return this.byteValue - dnsOpCode.byteValue;
    }

    private DnsOpCode(int i) {
        this(i, "UNKNOWN");
    }
}
