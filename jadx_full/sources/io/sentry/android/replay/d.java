package io.sentry.android.replay;

import defpackage.n12;
import io.sentry.q6;
import java.util.Date;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final v a;
    public final j b;
    public final Date c;
    public final int d;
    public final long e;
    public final q6 f;
    public final String g;
    public final List h;

    public d(v vVar, j jVar, Date date, int i, long j, q6 q6Var, String str, List list) {
        this.a = vVar;
        this.b = jVar;
        this.c = date;
        this.d = i;
        this.e = j;
        this.f = q6Var;
        this.g = str;
        this.h = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.a.equals(dVar.a) && this.b == dVar.b && this.c.equals(dVar.c) && this.d == dVar.d && this.e == dVar.e && this.f == dVar.f && n12.c(this.g, dVar.g) && this.h.equals(dVar.h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31) + this.d) * 31;
        long j = this.e;
        int iHashCode2 = (this.f.hashCode() + ((iHashCode + ((int) (j ^ (j >>> 32)))) * 31)) * 31;
        String str = this.g;
        return this.h.hashCode() + ((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        return "LastSegmentData(recorderConfig=" + this.a + ", cache=" + this.b + ", timestamp=" + this.c + ", id=" + this.d + ", duration=" + this.e + ", replayType=" + this.f + ", screenAtStart=" + this.g + ", events=" + this.h + ')';
    }
}
