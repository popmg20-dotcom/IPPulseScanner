package io.netty.handler.codec.dns;

import defpackage.xe;
import io.netty.channel.socket.InternetProtocolFamily;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultDnsOptEcsRecord extends AbstractDnsOptPseudoRrRecord implements DnsOptEcsRecord {
    private final byte[] address;
    private final int srcPrefixLength;

    public DefaultDnsOptEcsRecord(int i, int i2, int i3, int i4, byte[] bArr) {
        super(i, i2, i3);
        this.srcPrefixLength = i4;
        this.address = (byte[]) verifyAddress(bArr).clone();
    }

    private static byte[] verifyAddress(byte[] bArr) {
        if (bArr.length == 4 || bArr.length == 16) {
            return bArr;
        }
        xe.k("bytes.length must either 4 or 16");
        return null;
    }

    @Override // io.netty.handler.codec.dns.DnsOptEcsRecord
    public byte[] address() {
        return (byte[]) this.address.clone();
    }

    @Override // io.netty.handler.codec.dns.DnsOptEcsRecord
    public int scopePrefixLength() {
        return 0;
    }

    @Override // io.netty.handler.codec.dns.DnsOptEcsRecord
    public int sourcePrefixLength() {
        return this.srcPrefixLength;
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsOptPseudoRrRecord, io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        StringBuilder stringBuilder = toStringBuilder();
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append(" address:");
        stringBuilder.append(Arrays.toString(this.address));
        stringBuilder.append(" sourcePrefixLength:");
        stringBuilder.append(sourcePrefixLength());
        stringBuilder.append(" scopePrefixLength:");
        stringBuilder.append(scopePrefixLength());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public DefaultDnsOptEcsRecord(int i, int i2, byte[] bArr) {
        this(i, 0, 0, i2, bArr);
    }

    public DefaultDnsOptEcsRecord(int i, InternetProtocolFamily internetProtocolFamily) {
        this(i, 0, 0, 0, internetProtocolFamily.localhost().getAddress());
    }
}
