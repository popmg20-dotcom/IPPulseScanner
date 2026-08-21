package defpackage;

import android.os.SystemClock;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ps4 {
    public static final boolean c = qs4.a;
    public final ArrayList a = new ArrayList();
    public boolean b = false;

    public final synchronized void a(long j, String str) {
        if (this.b) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.a.add(new os4(str, j, SystemClock.elapsedRealtime()));
    }

    public final synchronized void b(String str) {
        this.b = true;
        ArrayList arrayList = this.a;
        long j = arrayList.size() == 0 ? 0L : ((os4) arrayList.get(arrayList.size() - 1)).c - ((os4) arrayList.get(0)).c;
        if (j <= 0) {
            return;
        }
        long j2 = ((os4) this.a.get(0)).c;
        qs4.b("(%-4d ms) %s", Long.valueOf(j), str);
        for (os4 os4Var : this.a) {
            long j3 = os4Var.c;
            qs4.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(os4Var.b), os4Var.a);
            j2 = j3;
        }
    }

    public final void finalize() {
        if (this.b) {
            return;
        }
        b("Request on the loose");
        qs4.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }
}
