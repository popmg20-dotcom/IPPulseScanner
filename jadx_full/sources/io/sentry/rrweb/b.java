package io.sentry.rrweb;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public c b;
    public long f = System.currentTimeMillis();

    public b(c cVar) {
        this.b = cVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f == bVar.f && this.b == bVar.b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, Long.valueOf(this.f)});
    }
}
