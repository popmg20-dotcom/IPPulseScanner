package defpackage;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ul2 {
    public final int a;
    public final int b;
    public final BigInteger c;
    public final String d;
    public final Map e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;

    @fj2
    public ul2(@gj2(name = "binary_format_major_version") int i, @gj2(name = "binary_format_minor_version") int i2, @gj2(name = "build_epoch") BigInteger bigInteger, @gj2(name = "database_type") String str, @gj2(name = "languages") List<String> list, @gj2(name = "description") Map<String, String> map, @gj2(name = "ip_version") int i3, @gj2(name = "node_count") long j, @gj2(name = "record_size") int i4) {
        this.a = i;
        this.b = i2;
        this.c = bigInteger;
        this.d = str;
        this.e = map;
        this.f = i3;
        int i5 = (int) j;
        this.h = i5;
        this.i = i4;
        int i6 = i4 / 4;
        this.g = i6;
        this.j = i5 * i6;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Metadata [binaryFormatMajorVersion=");
        sb.append(this.a);
        sb.append(", binaryFormatMinorVersion=");
        sb.append(this.b);
        sb.append(", buildEpoch=");
        sb.append(this.c);
        sb.append(", databaseType=");
        sb.append(this.d);
        sb.append(", description=");
        sb.append(this.e);
        sb.append(", ipVersion=");
        sb.append(this.f);
        sb.append(", nodeCount=");
        sb.append(this.h);
        sb.append(", recordSize=");
        return fw.w("]", sb, this.i);
    }
}
