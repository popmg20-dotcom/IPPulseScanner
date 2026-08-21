package io.sentry.internal.gestures;

import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final WeakReference a;
    public final String b;
    public final String c;

    public b(Object obj, String str, String str2) {
        this.a = new WeakReference(obj);
        this.b = str;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return io.sentry.util.b.i(this.b, bVar.b) && io.sentry.util.b.i(this.c, bVar.c) && io.sentry.util.b.i(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.c, null});
    }
}
