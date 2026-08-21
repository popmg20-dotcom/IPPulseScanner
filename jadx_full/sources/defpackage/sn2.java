package defpackage;

import io.sentry.android.replay.capture.d;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class sn2 extends s83 implements d82, am1 {
    public sn2(String str, String str2) {
        super(qv.b, d.class, str, str2, 0);
    }

    @Override // defpackage.rv
    public final y72 c() {
        dh3.a.getClass();
        return this;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        h();
        throw null;
    }

    public final void h() {
        if (this.Z) {
            vp1.n("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
            return;
        }
        y72 y72VarF = f();
        if (y72VarF == this) {
            throw new rf0("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
        }
        ((sn2) ((d82) y72VarF)).h();
    }
}
