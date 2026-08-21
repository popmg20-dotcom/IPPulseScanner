package defpackage;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d00 {
    public final StringBuilder a = new StringBuilder();
    public final Object b;
    public int c;
    public final ow d;
    public final HashMap e;
    public int f;

    public d00(ow owVar) {
        Object obj = new Object();
        this.b = obj;
        this.e = new HashMap();
        this.c = 1;
        synchronized (obj) {
            this.d = owVar;
            this.f = this.c;
        }
    }

    public static void c(ex exVar, lz lzVar) {
        if (vo.A()) {
            vo.L(lzVar.ordinal(), "CX:State[" + exVar + "]");
        }
    }

    public final c00 a(String str) {
        HashMap map = this.e;
        for (wx wxVar : map.keySet()) {
            if (str.equals(wxVar.b().d())) {
                return (c00) map.get(wxVar);
            }
        }
        return null;
    }

    public final void b() {
        boolean zF = ez4.F("CameraStateRegistry");
        StringBuilder sb = this.a;
        if (zF) {
            sb.setLength(0);
            sb.append("Recalculating open cameras:\n");
            sb.append(String.format(Locale.US, "%-45s%-22s\n", "Camera", "State"));
            sb.append("-------------------------------------------------------------------\n");
        }
        int i = 0;
        for (Map.Entry entry : this.e.entrySet()) {
            if (ez4.F("CameraStateRegistry")) {
                sb.append(String.format(Locale.US, "%-45s%-22s\n", ((wx) entry.getKey()).toString(), ((c00) entry.getValue()).a != null ? ((c00) entry.getValue()).a.toString() : "UNKNOWN"));
            }
            lz lzVar = ((c00) entry.getValue()).a;
            if (lzVar != null && lzVar.b) {
                i++;
            }
        }
        if (ez4.F("CameraStateRegistry")) {
            sb.append("-------------------------------------------------------------------\n");
            Locale locale = Locale.US;
            sb.append("Open count: " + i + " (Max allowed: " + this.c + ")");
            ez4.o("CameraStateRegistry", sb.toString());
        }
        this.f = Math.max(this.c - i, 0);
    }

    public final boolean d(ex exVar) {
        boolean z;
        synchronized (this.b) {
            try {
                c00 c00Var = (c00) this.e.get(exVar);
                r25.i(c00Var, "Camera must first be registered with registerCamera()");
                z = true;
                if (ez4.F("CameraStateRegistry")) {
                    this.a.setLength(0);
                    StringBuilder sb = this.a;
                    Locale locale = Locale.US;
                    int i = this.f;
                    lz lzVar = c00Var.a;
                    boolean z2 = lzVar != null && lzVar.b;
                    sb.append("tryOpenCamera(" + exVar + ") [Available Cameras: " + i + ", Already Open: " + z2 + " (Previous state: " + c00Var.a + ")]");
                }
                if (this.f > 0) {
                    lz lzVar2 = lz.OPENING;
                    c00Var.a = lzVar2;
                    c(exVar, lzVar2);
                } else {
                    lz lzVar3 = c00Var.a;
                    if (lzVar3 != null && lzVar3.b) {
                        lz lzVar22 = lz.OPENING;
                        c00Var.a = lzVar22;
                        c(exVar, lzVar22);
                    } else {
                        z = false;
                    }
                }
                if (ez4.F("CameraStateRegistry")) {
                    StringBuilder sb2 = this.a;
                    Locale locale2 = Locale.US;
                    sb2.append(" --> ".concat(z ? "SUCCESS" : "FAIL"));
                    ez4.o("CameraStateRegistry", this.a.toString());
                }
                if (z) {
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public final boolean e(String str, String str2) {
        synchronized (this.b) {
            try {
                boolean z = true;
                if (this.d.b() != 2) {
                    return true;
                }
                c00 c00VarA = a(str);
                lz lzVar = c00VarA != null ? c00VarA.a : null;
                c00 c00VarA2 = str2 != null ? a(str2) : null;
                lz lzVar2 = c00VarA2 != null ? c00VarA2.a : null;
                lz lzVar3 = lz.OPEN;
                boolean z2 = lzVar3.equals(lzVar) || lz.CONFIGURED.equals(lzVar);
                boolean z3 = lzVar3.equals(lzVar2) || lz.CONFIGURED.equals(lzVar2);
                if (!z2 || !z3) {
                    z = false;
                }
                return z;
            } finally {
            }
        }
    }
}
