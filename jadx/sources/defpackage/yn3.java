package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yn3 {
    public nt4 a;
    public ArrayList b;

    public static long a(oo0 oo0Var, long j) {
        nt4 nt4Var = oo0Var.d;
        ArrayList arrayList = oo0Var.k;
        if (nt4Var instanceof bs1) {
            return j;
        }
        int size = arrayList.size();
        long jMin = j;
        for (int i = 0; i < size; i++) {
            io0 io0Var = (io0) arrayList.get(i);
            if (io0Var instanceof oo0) {
                oo0 oo0Var2 = (oo0) io0Var;
                if (oo0Var2.d != nt4Var) {
                    jMin = Math.min(jMin, a(oo0Var2, ((long) oo0Var2.f) + j));
                }
            }
        }
        oo0 oo0Var3 = nt4Var.i;
        oo0 oo0Var4 = nt4Var.h;
        if (oo0Var != oo0Var3) {
            return jMin;
        }
        long j2 = j - nt4Var.j();
        return Math.min(Math.min(jMin, a(oo0Var4, j2)), j2 - ((long) oo0Var4.f));
    }

    public static long b(oo0 oo0Var, long j) {
        nt4 nt4Var = oo0Var.d;
        ArrayList arrayList = oo0Var.k;
        if (nt4Var instanceof bs1) {
            return j;
        }
        int size = arrayList.size();
        long jMax = j;
        for (int i = 0; i < size; i++) {
            io0 io0Var = (io0) arrayList.get(i);
            if (io0Var instanceof oo0) {
                oo0 oo0Var2 = (oo0) io0Var;
                if (oo0Var2.d != nt4Var) {
                    jMax = Math.max(jMax, b(oo0Var2, ((long) oo0Var2.f) + j));
                }
            }
        }
        oo0 oo0Var3 = nt4Var.h;
        oo0 oo0Var4 = nt4Var.i;
        if (oo0Var != oo0Var3) {
            return jMax;
        }
        long j2 = nt4Var.j() + j;
        return Math.max(Math.max(jMax, b(oo0Var4, j2)), j2 - ((long) oo0Var4.f));
    }
}
