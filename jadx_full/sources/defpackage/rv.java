package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class rv implements y72, Serializable {
    public final String A;
    public final String X;
    public final boolean Y;
    public transient y72 b;
    public final Object f;
    public final Class z;

    public rv(Object obj, Class cls, String str, String str2, boolean z) {
        this.f = obj;
        this.z = cls;
        this.A = str;
        this.X = str2;
        this.Y = z;
    }

    public abstract y72 c();

    public final f50 d() {
        boolean z = this.Y;
        Class cls = this.z;
        if (!z) {
            return dh3.a(cls);
        }
        dh3.a.getClass();
        return new fy2(cls);
    }
}
