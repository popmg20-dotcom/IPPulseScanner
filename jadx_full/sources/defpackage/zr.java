package defpackage;

import j$.util.DesugarCollections;
import java.util.EnumSet;
import java.util.Set;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class zr implements qo2, nw2 {
    public static final Set A;
    public static final /* synthetic */ zr[] X;
    public static final zr z;
    public final Class b;
    public final String f;

    static {
        zr zrVar = new zr();
        z = zrVar;
        X = new zr[]{zrVar, new zr("MINA", 1, "org.apache.sshd.mina.MinaServiceFactoryFactory"), new zr("NETTY", 2, "org.apache.sshd.netty.NettyIoServiceFactoryFactory")};
        A = DesugarCollections.unmodifiableSet(EnumSet.allOf(zr.class));
    }

    public zr() {
        this.b = tr2.class;
        this.f = null;
    }

    public static zr valueOf(String str) {
        return (zr) Enum.valueOf(zr.class, str);
    }

    public static zr[] values() {
        return (zr[]) X.clone();
    }

    @Override // defpackage.va1
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final r0 a() {
        try {
            try {
                try {
                    return (r0) r0.class.cast(c().getDeclaredConstructor(null).newInstance(null));
                } catch (Error | RuntimeException e) {
                    throw e;
                }
            } catch (Throwable th) {
                zo2.q(th);
                return null;
            }
        } catch (Error e2) {
            throw e2;
        }
    }

    public final Class c() {
        String str = this.f;
        Class cls = this.b;
        if (cls != null) {
            return cls;
        }
        try {
            return Class.forName(str, true, zr.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            try {
                return Class.forName(str, true, Thread.currentThread().getContextClassLoader());
            } catch (ClassNotFoundException unused) {
                zo2.q(e);
                return null;
            }
        }
    }

    @Override // defpackage.nw2
    public final boolean g() {
        return c() != null;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return a();
    }

    @Override // defpackage.to2
    public final String getName() {
        return name().toLowerCase();
    }

    public zr(String str, int i, String str2) {
        this.b = null;
        this.f = str2;
    }
}
