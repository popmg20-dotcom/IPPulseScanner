package defpackage;

import android.os.SystemClock;
import io.sentry.android.core.anr.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bx {
    public final long a;
    public long b;
    public final Object c;

    public bx(List list) {
        this.c = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar != null) {
                ((ArrayList) this.c).add(fVar);
            }
        }
        Collections.sort((ArrayList) this.c);
        if (((ArrayList) this.c).isEmpty()) {
            this.a = 0L;
            this.b = 0L;
        } else {
            this.a = ((f) ((ArrayList) this.c).get(0)).f;
            this.b = ((f) fw.r((ArrayList) this.c, 1)).f + 10000;
        }
    }

    public int a() {
        if (!((dx) this.c).c()) {
            return 700;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = this.b;
        if (j == -1) {
            this.b = jUptimeMillis;
            j = jUptimeMillis;
        }
        long j2 = jUptimeMillis - j;
        if (j2 <= 120000) {
            return 1000;
        }
        return j2 <= 300000 ? 2000 : 4000;
    }

    public int b() {
        boolean zC = ((dx) this.c).c();
        long j = this.a;
        if (zC) {
            if (j > 0) {
                return Math.min((int) j, 1800000);
            }
            return 1800000;
        }
        if (j > 0) {
            return Math.min((int) j, 10000);
        }
        return 10000;
    }

    public bx(long j, long j2, Date date) {
        this.a = j;
        this.b = j2;
        this.c = date;
    }

    public bx(dx dxVar, long j) {
        this.c = dxVar;
        this.b = -1L;
        this.a = j;
    }
}
