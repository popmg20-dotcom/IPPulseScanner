package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uk3 implements Serializable {
    public final Object b;

    public /* synthetic */ uk3(Object obj) {
        this.b = obj;
    }

    public static final Throwable a(Object obj) {
        if (obj instanceof tk3) {
            return ((tk3) obj).b;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof uk3) {
            return n12.c(this.b, ((uk3) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.b;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.b;
        return obj instanceof tk3 ? ((tk3) obj).toString() : ha0.m("Success(", obj, ')');
    }
}
