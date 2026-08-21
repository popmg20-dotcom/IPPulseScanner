package defpackage;

import j$.util.DesugarCollections;
import java.util.EnumSet;
import java.util.Set;
import java.util.TreeMap;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class ds implements yr {
    public static final cs A0;
    public static final Set B0;
    public static final /* synthetic */ ds[] C0;
    public static final ds X;
    public static final as Y;
    public static final ds Z;
    public static final bs y0;
    public static final ds z0;
    public final int A;
    public final String b;
    public final String f;
    public final int z;

    /* JADX INFO: Fake field, exist only in values array */
    ds EF0;

    /* JADX INFO: Fake field, exist only in values array */
    ds EF1;

    static {
        ds dsVar = new ds(0, 16, "hmacmd5", "hmac-md5", "HmacMD5", 16);
        ds dsVar2 = new ds(1, 12, "hmacmd596", "hmac-md5-96", "HmacMD5", 16);
        ds dsVar3 = new ds(2, 20, "hmacsha1", "hmac-sha1", "HmacSHA1", 20);
        X = dsVar3;
        as asVar = new as(3, 20, "hmacsha1etm", "hmac-sha1-etm@openssh.com", "HmacSHA1", 20);
        Y = asVar;
        ds dsVar4 = new ds(4, 12, "hmacsha196", "hmac-sha1-96", "HmacSHA1", 20);
        ds dsVar5 = new ds(5, 32, "hmacsha256", "hmac-sha2-256", "HmacSHA256", 32);
        Z = dsVar5;
        bs bsVar = new bs(6, 32, "hmacsha256etm", "hmac-sha2-256-etm@openssh.com", "HmacSHA256", 32);
        y0 = bsVar;
        ds dsVar6 = new ds(7, 64, "hmacsha512", "hmac-sha2-512", "HmacSHA512", 64);
        z0 = dsVar6;
        cs csVar = new cs(8, 64, "hmacsha512etm", "hmac-sha2-512-etm@openssh.com", "HmacSHA512", 64);
        A0 = csVar;
        C0 = new ds[]{dsVar, dsVar2, dsVar3, asVar, dsVar4, dsVar5, bsVar, dsVar6, csVar};
        B0 = DesugarCollections.unmodifiableSet(EnumSet.allOf(ds.class));
        new TreeMap(String.CASE_INSENSITIVE_ORDER);
    }

    public ds(int i, int i2, String str, String str2, String str3, int i3) {
        this.b = str2;
        this.f = str3;
        this.A = i2;
        this.z = i3;
    }

    public static ds valueOf(String str) {
        return (ds) Enum.valueOf(ds.class, str);
    }

    public static ds[] values() {
        return (ds[]) C0.clone();
    }

    @Override // defpackage.va1
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final wk a() {
        return new wk(this.f, this.A, this.z, c());
    }

    public boolean c() {
        return this instanceof as;
    }

    @Override // defpackage.nw2
    public final boolean g() {
        return true;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return a();
    }

    @Override // defpackage.to2
    public final String getName() {
        return this.b;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.b;
    }
}
