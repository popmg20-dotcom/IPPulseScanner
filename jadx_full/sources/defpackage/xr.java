package defpackage;

import j$.util.DesugarCollections;
import java.security.MessageDigest;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public enum xr implements qo2, nw2 {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("md5", "md5", "MD5"),
    X("sha1", "sha1", "SHA-1"),
    /* JADX INFO: Fake field, exist only in values array */
    EF2("sha224", "sha224", "SHA-224"),
    Y("sha256", "sha256", "SHA-256"),
    Z("sha384", "sha384", "SHA-384"),
    y0("sha512", "sha512", "SHA-512");

    public static final Set z0 = DesugarCollections.unmodifiableSet(EnumSet.allOf(xr.class));
    public final boolean A;
    public final String b;
    public final int f;
    public final String z;

    xr(String str, String str2, String str3) {
        this.z = str2;
        this.b = str3;
        this.f = i;
        n12.g(str3, "No algorithm");
        boolean z = false;
        try {
            if (((MessageDigest) nr3.k(MessageDigest.class, str3, new sm(str3, 12)).a(str3)) != null) {
                z = true;
            }
        } catch (Exception unused) {
        }
        this.A = z;
    }

    @Override // defpackage.va1
    public final Object a() {
        return new ok(this.b, this.f);
    }

    @Override // defpackage.nw2
    public final boolean g() {
        return this.A;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return a();
    }

    @Override // defpackage.to2
    public final String getName() {
        return this.z;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.z;
    }
}
