package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tk3 implements Serializable {
    public final Throwable b;

    public tk3(Throwable th) {
        th.getClass();
        this.b = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof tk3) {
            return n12.c(this.b, ((tk3) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.b + ')';
    }
}
