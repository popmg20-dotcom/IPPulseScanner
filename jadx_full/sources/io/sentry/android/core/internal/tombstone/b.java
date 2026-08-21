package io.sentry.android.core.internal.tombstone;

import android.os.Bundle;
import defpackage.ib5;
import defpackage.k85;
import defpackage.l75;
import defpackage.qf5;
import defpackage.r55;
import defpackage.t65;
import defpackage.td5;
import defpackage.yb5;
import defpackage.zd5;
import io.sentry.android.core.u;
import io.sentry.protocol.DebugImage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public long a;
    public long b;
    public Object c;
    public Object d;

    public DebugImage a() {
        long j = this.a;
        String str = (String) this.d;
        if (str.isEmpty()) {
            return null;
        }
        DebugImage debugImage = new DebugImage();
        debugImage.setCodeId(str);
        debugImage.setCodeFile((String) this.c);
        String strA = io.sentry.config.a.a(str);
        if (strA != null) {
            str = strA;
        }
        debugImage.setDebugId(str);
        debugImage.setImageAddr(String.format("0x%x", Long.valueOf(j)));
        debugImage.setImageSize(this.b - j);
        debugImage.setType("elf");
        return debugImage;
    }

    public boolean b(long j, boolean z, boolean z2) {
        zd5 zd5Var = (zd5) this.d;
        zd5Var.V0();
        zd5Var.W0();
        k85 k85Var = (k85) zd5Var.f;
        boolean zA = k85Var.a();
        t65 t65Var = k85Var.Y;
        if (zA) {
            l75 l75Var = k85Var.X;
            k85.f(l75Var);
            u uVar = l75Var.J0;
            k85Var.B0.getClass();
            uVar.b(System.currentTimeMillis());
        }
        long j2 = j - this.a;
        if (!z && j2 < 1000) {
            k85.h(t65Var);
            t65Var.H0.b(Long.valueOf(j2), "Screen exposed for less than 1000 ms. Event not sent. time");
            return false;
        }
        if (!z2) {
            j2 = j - this.b;
            this.b = j;
        }
        k85.h(t65Var);
        t65Var.H0.b(Long.valueOf(j2), "Recording user engagement, ms");
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j2);
        boolean z3 = !k85Var.A.j1();
        yb5 yb5Var = k85Var.C0;
        k85.g(yb5Var);
        qf5.O1(yb5Var.b1(z3), bundle, true);
        if (!z2) {
            ib5 ib5Var = k85Var.D0;
            k85.g(ib5Var);
            ib5Var.c1("auto", "_e", bundle);
        }
        this.a = j;
        td5 td5Var = (td5) this.c;
        td5Var.c();
        td5Var.b(((Long) r55.r0.a(null)).longValue());
        return true;
    }
}
