package io.sentry.android.replay.capture;

import io.sentry.b4;
import io.sentry.f1;
import io.sentry.l0;
import io.sentry.r6;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j extends l {
    public final r6 a;
    public final b4 b;

    public j(r6 r6Var, b4 b4Var) {
        this.a = r6Var;
        this.b = b4Var;
    }

    public static void a(j jVar, f1 f1Var) {
        l0 l0Var = new l0();
        if (f1Var != null) {
            r6 r6Var = jVar.a;
            l0Var.h = jVar.b;
            f1Var.r(r6Var, l0Var);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.a.equals(jVar.a) && this.b.equals(jVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Created(replay=" + this.a + ", recording=" + this.b + ')';
    }
}
