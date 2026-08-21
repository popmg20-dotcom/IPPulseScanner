package defpackage;

import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class cr2 {
    public static final on2 a;
    public static final on2 b;
    public static final on2 c;

    static {
        i24 i24Var = i24.b;
        a = new on2(new ei0(i24Var, null));
        b = new on2(new ei0(i24Var, null));
        c = new on2(new ei0(i24Var, null));
    }

    public static void a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.getType() == 17 && networkInfo.getState() == NetworkInfo.State.CONNECTED && n12.c(ws4.a.d(), Boolean.TRUE)) {
            ws4.d.f(new br2());
            return;
        }
        boolean z = nj3.a;
        nj3.a(new t4(14));
        d();
    }

    public static void b() {
        ArrayList arrayListM0;
        on2 on2Var = c;
        ei0 ei0Var = (ei0) on2Var.d();
        if ((ei0Var != null ? ei0Var.b : null) == null) {
            f(on2Var, new ei0(i24.b, null));
        }
        boolean z = nj3.a;
        y3 y3Var = nj3.e;
        y3Var.d(on2Var);
        int i = 0;
        if (tj4.H()) {
            k01 k01Var = new k01(24);
            yc1 yc1Var = new yc1("https://nstool.netease.com/", k01Var, k01Var, i);
            yc1Var.A0 = new fm0(2500, 2);
            yc1Var.C0 = on2Var;
            y3Var.a(yc1Var);
            return;
        }
        pr1 pr1Var = new pr1();
        ArrayList arrayList = new ArrayList(32);
        while (i < 32) {
            Iterable s30Var = new s30('a', 'z');
            s30 s30Var2 = new s30('A', 'Z');
            if (s30Var instanceof Collection) {
                arrayListM0 = d70.m0((Collection) s30Var, s30Var2);
            } else {
                ArrayList arrayList2 = new ArrayList();
                d70.U(s30Var, arrayList2);
                d70.U(s30Var2, arrayList2);
                arrayListM0 = arrayList2;
            }
            ArrayList arrayListM02 = d70.m0(arrayListM0, new s30('0', '9'));
            hd3 hd3Var = id3.b;
            if (arrayListM02.isEmpty()) {
                e04.h("Collection is empty.");
                return;
            }
            Character ch = (Character) d70.Z(arrayListM02, id3.f.b(arrayListM02.size()));
            ch.getClass();
            arrayList.add(ch);
            i++;
        }
        rw0 rw0Var = new rw0(ha0.o("https://", d70.j0(arrayList, "", null, null, null, 62), ".edns.ip-api.com/json"), null, pr1Var, pr1Var);
        rw0Var.C0 = on2Var;
        y3Var.a(rw0Var);
    }

    public static void c(String str) {
        boolean z = nj3.a;
        y3 y3Var = nj3.e;
        on2 on2Var = c;
        y3Var.d(on2Var);
        vd3 vd3Var = new vd3(24);
        str.getClass();
        yc1 yc1Var = new yc1(str, vd3Var, vd3Var, 1);
        yc1Var.A0 = new fm0(2500, 2);
        yc1Var.C0 = on2Var;
        y3Var.a(yc1Var);
    }

    public static void d() {
        ei0 ei0Var = new ei0(i24.b, null);
        on2 on2Var = b;
        f(on2Var, ei0Var);
        String strA = l72.A();
        if (strA != null) {
            f(on2Var, new ei0(i24.f, strA));
        } else {
            f(on2Var, new ei0(i24.z, null));
        }
    }

    public static void e() {
        on2 on2Var = a;
        ei0 ei0Var = (ei0) on2Var.d();
        if ((ei0Var != null ? ei0Var.b : null) == null) {
            f(on2Var, new ei0(i24.b, null));
        }
        boolean z = nj3.a;
        y3 y3Var = nj3.e;
        synchronized (((HashSet) y3Var.d)) {
            try {
                for (aj3 aj3Var : (HashSet) y3Var.d) {
                    if (aj3Var instanceof d60) {
                        aj3Var.b();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        y3 y3Var2 = nj3.e;
        wl3 wl3Var = new wl3(24);
        y3Var2.a(new d60("https://cloudflare.com/cdn-cgi/trace", wl3Var, wl3Var));
    }

    public static void f(on2 on2Var, ei0 ei0Var) {
        if (n12.c(on2Var.d(), ei0Var)) {
            return;
        }
        on2Var.l(ei0Var);
    }
}
