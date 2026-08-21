package defpackage;

import android.os.Build;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qv2 {
    public UUID a;
    public gx4 b;
    public final Set c;
    public final /* synthetic */ int d;

    public qv2(Class cls, int i) {
        this.d = i;
        UUID uuidRandomUUID = UUID.randomUUID();
        uuidRandomUUID.getClass();
        this.a = uuidRandomUUID;
        String string = this.a.toString();
        string.getClass();
        this.b = new gx4(string, (ww4) null, cls.getName(), (String) null, (di0) null, (di0) null, 0L, 0L, 0L, (mc0) null, 0, (ei) null, 0L, 0L, 0L, 0L, false, (ww2) null, 0, 0L, 0, 0, (String) null, (Boolean) null, 33554426);
        String[] strArr = {cls.getName()};
        LinkedHashSet linkedHashSet = new LinkedHashSet(fh2.U(1));
        qe.r0(strArr, linkedHashSet);
        this.c = linkedHashSet;
    }

    public final ex4 a() {
        ex4 rv2Var;
        int i = this.d;
        Set set = this.c;
        switch (i) {
            case 0:
                rv2Var = new rv2(this.a, this.b, set);
                break;
            default:
                gx4 gx4Var = this.b;
                if (!gx4Var.q) {
                    rv2Var = new c13(this.a, gx4Var, set);
                } else {
                    xe.k("PeriodicWorkRequests cannot be expedited");
                    rv2Var = null;
                }
                break;
        }
        mc0 mc0Var = this.b.j;
        boolean z = (Build.VERSION.SDK_INT >= 24 && mc0Var.b()) || mc0Var.e || mc0Var.c || mc0Var.d;
        gx4 gx4Var2 = this.b;
        if (gx4Var2.q) {
            if (z) {
                xe.k("Expedited jobs only support network and storage constraints");
                return null;
            }
            if (gx4Var2.g > 0) {
                xe.k("Expedited jobs cannot be delayed");
                return null;
            }
        }
        String str = gx4Var2.x;
        if (str == null) {
            List listL0 = p44.L0(gx4Var2.c, new String[]{"."}, 6);
            String strT0 = listL0.size() == 1 ? (String) listL0.get(0) : (String) d70.k0(listL0);
            if (strT0.length() > 127) {
                strT0 = p44.T0(127, strT0);
            }
            gx4Var2.x = strT0;
        } else if (str.length() > 127) {
            this.b.x = p44.T0(127, str);
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        uuidRandomUUID.getClass();
        this.a = uuidRandomUUID;
        String string = uuidRandomUUID.toString();
        string.getClass();
        gx4 gx4Var3 = this.b;
        this.b = new gx4(string, gx4Var3.b, gx4Var3.c, gx4Var3.d, new di0(gx4Var3.e), new di0(gx4Var3.f), gx4Var3.g, gx4Var3.h, gx4Var3.i, new mc0(gx4Var3.j), gx4Var3.k, gx4Var3.l, gx4Var3.m, gx4Var3.n, gx4Var3.o, gx4Var3.p, gx4Var3.q, gx4Var3.r, gx4Var3.s, gx4Var3.u, gx4Var3.v, gx4Var3.w, gx4Var3.x, gx4Var3.y, 524288);
        return rv2Var;
    }
}
