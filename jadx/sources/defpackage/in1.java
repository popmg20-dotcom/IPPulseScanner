package defpackage;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class in1 implements Runnable {
    public static final ThreadLocal X = new ThreadLocal();
    public static final e1 Y = new e1(14);
    public long f;
    public long z;
    public final ArrayList b = new ArrayList();
    public final ArrayList A = new ArrayList();

    public static rg3 c(RecyclerView recyclerView, int i, long j) {
        int iH = recyclerView.z0.h();
        for (int i2 = 0; i2 < iH; i2++) {
            rg3 rg3VarO = RecyclerView.O(recyclerView.z0.g(i2));
            if (rg3VarO.c == i && !rg3VarO.h()) {
                return null;
            }
        }
        ig3 ig3Var = recyclerView.z;
        if (j == Long.MAX_VALUE) {
            try {
                if (zf4.a()) {
                    Trace.beginSection("RV Prefetch forced - needed next frame");
                }
            } catch (Throwable th) {
                recyclerView.Y(false);
                Trace.endSection();
                throw th;
            }
        }
        recyclerView.X();
        rg3 rg3VarL = ig3Var.l(i, j);
        if (rg3VarL != null) {
            if (!rg3VarL.g() || rg3VarL.h()) {
                ig3Var.a(rg3VarL, false);
            } else {
                ig3Var.i(rg3VarL.a);
            }
        }
        recyclerView.Y(false);
        Trace.endSection();
        return rg3VarL;
    }

    public final void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.M0) {
            if (RecyclerView.T1 && !this.b.contains(recyclerView)) {
                xe.q("attempting to post unregistered view!");
                return;
            } else if (this.f == 0) {
                this.f = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        r02 r02Var = recyclerView.x1;
        r02Var.a = i;
        r02Var.b = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [int] */
    /* JADX WARN: Type inference failed for: r11v6 */
    public final void b(long j) {
        hn1 hn1Var;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        hn1 hn1Var2;
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList.get(i2);
            int windowVisibility = recyclerView3.getWindowVisibility();
            r02 r02Var = recyclerView3.x1;
            if (windowVisibility == 0) {
                r02Var.d(recyclerView3, false);
                i += r02Var.c;
            }
        }
        ArrayList arrayList2 = this.A;
        arrayList2.ensureCapacity(i);
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            RecyclerView recyclerView4 = (RecyclerView) arrayList.get(i3);
            if (recyclerView4.getWindowVisibility() == 0) {
                r02 r02Var2 = recyclerView4.x1;
                int iAbs = Math.abs(r02Var2.b) + Math.abs(r02Var2.a);
                for (?? r11 = z; r11 < r02Var2.c * 2; r11 += 2) {
                    if (i4 >= arrayList2.size()) {
                        hn1Var2 = new hn1();
                        arrayList2.add(hn1Var2);
                    } else {
                        hn1Var2 = (hn1) arrayList2.get(i4);
                    }
                    int[] iArr = (int[]) r02Var2.d;
                    int i5 = iArr[r11 + 1];
                    if (i5 <= iAbs) {
                        z = true;
                    }
                    hn1Var2.a = z;
                    hn1Var2.b = iAbs;
                    hn1Var2.c = i5;
                    hn1Var2.d = recyclerView4;
                    hn1Var2.e = iArr[r11];
                    i4++;
                    z = false;
                }
            }
            i3++;
            z = false;
        }
        Collections.sort(arrayList2, Y);
        for (int i6 = 0; i6 < arrayList2.size() && (recyclerView = (hn1Var = (hn1) arrayList2.get(i6)).d) != null; i6++) {
            rg3 rg3VarC = c(recyclerView, hn1Var.e, hn1Var.a ? Long.MAX_VALUE : j);
            if (rg3VarC != null && rg3VarC.b != null && rg3VarC.g() && !rg3VarC.h() && (recyclerView2 = (RecyclerView) rg3VarC.b.get()) != null) {
                if (recyclerView2.X0 && recyclerView2.z0.h() != 0) {
                    ig3 ig3Var = recyclerView2.z;
                    xf3 xf3Var = recyclerView2.g1;
                    if (xf3Var != null) {
                        xf3Var.e();
                    }
                    ag3 ag3Var = recyclerView2.H0;
                    if (ag3Var != null) {
                        ag3Var.p0(ig3Var);
                        recyclerView2.H0.q0(ig3Var);
                    }
                    ig3Var.a.clear();
                    ig3Var.g();
                }
                r02 r02Var3 = recyclerView2.x1;
                r02Var3.d(recyclerView2, true);
                if (r02Var3.c != 0) {
                    try {
                        Trace.beginSection(j == Long.MAX_VALUE ? "RV Nested Prefetch" : "RV Nested Prefetch forced - needed next frame");
                        ng3 ng3Var = recyclerView2.y1;
                        rf3 rf3Var = recyclerView2.G0;
                        ng3Var.d = 1;
                        ng3Var.e = rf3Var.b();
                        ng3Var.g = false;
                        ng3Var.h = false;
                        ng3Var.i = false;
                        for (int i7 = 0; i7 < r02Var3.c * 2; i7 += 2) {
                            c(recyclerView2, ((int[]) r02Var3.d)[i7], j);
                        }
                    } finally {
                        Trace.endSection();
                    }
                }
            }
            hn1Var.a = false;
            hn1Var.b = 0;
            hn1Var.c = 0;
            hn1Var.d = null;
            hn1Var.e = 0;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.b;
        try {
            Trace.beginSection("RV Prefetch");
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.z);
                }
            }
        } finally {
            this.f = 0L;
            Trace.endSection();
        }
    }
}
