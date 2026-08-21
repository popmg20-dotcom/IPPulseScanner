package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class r83 extends s83 implements d82, Function2 {
    @Override // defpackage.rv
    public final y72 c() {
        dh3.a.getClass();
        return this;
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
        ((r83) ((d82) y72VarF)).h();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        h();
        throw null;
    }
}
