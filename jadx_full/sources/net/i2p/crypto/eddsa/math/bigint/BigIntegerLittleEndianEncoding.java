package net.i2p.crypto.eddsa.math.bigint;

import io.netty.handler.codec.dns.DnsRecord;
import java.io.Serializable;
import java.math.BigInteger;
import net.i2p.crypto.eddsa.math.Encoding;
import net.i2p.crypto.eddsa.math.Field;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class BigIntegerLittleEndianEncoding extends Encoding implements Serializable {
    @Override // net.i2p.crypto.eddsa.math.Encoding
    public final synchronized void a(Field field) {
        super.a(field);
        BigInteger bigInteger = BigInteger.ONE;
        bigInteger.shiftLeft(DnsRecord.CLASS_ANY).subtract(bigInteger);
    }
}
