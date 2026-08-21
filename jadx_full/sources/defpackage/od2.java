package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class od2 {
    public static final dm3[] d = {aj2.d(aj2.g, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), aj2.d(aj2.f, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), aj2.d(aj2.c, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), aj2.d(aj2.b, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), aj2.d(aj2.d, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), aj2.d(aj2.e, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), aj2.d(aj2.a, new RectF(-1.0f, -1.0f, 1.0f, 1.0f))};
    public static final m20[] e = new m20[7];
    public final pd2 a;
    public final Path b = new Path();
    public final Matrix c = new Matrix();

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0355, code lost:
    
        defpackage.xe.k("Cutting point is expected to be between 0 and 1");
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x035c, code lost:
    
        throw null;
     */
    static {
        char c;
        Throwable th;
        int i;
        int i2;
        m20[] m20VarArr;
        int i3;
        m20[] m20VarArr2;
        float fD;
        e03 e03Var;
        e03 e03VarA;
        float f = 1.0f;
        int i4 = 0;
        char c2 = 2;
        int i5 = 0;
        while (true) {
            dm3[] dm3VarArr = d;
            if (i5 >= dm3VarArr.length) {
                return;
            }
            m20[] m20VarArr3 = e;
            dm3 dm3Var = dm3VarArr[i5];
            int i6 = i5 + 1;
            dm3 dm3Var2 = dm3VarArr[i6 % dm3VarArr.length];
            dm3Var.getClass();
            dm3Var2.getClass();
            m20 m20Var = new m20();
            lj2 lj2VarJ = ez4.J(new d8(dm3Var.b, dm3Var.c), dm3Var);
            lj2 lj2VarJ2 = ez4.J(new d8(dm3Var2.b, dm3Var2.c), dm3Var2);
            List list = lj2VarJ.z;
            List list2 = lj2VarJ2.z;
            list.getClass();
            list2.getClass();
            ub2 ub2VarI = p95.i();
            int size = list.size();
            for (int i7 = i4; i7 < size; i7++) {
                if (((h83) list.get(i7)).b instanceof gc1) {
                    ub2VarI.add(list.get(i7));
                }
            }
            ub2 ub2VarC = p95.c(ub2VarI);
            ub2 ub2VarI2 = p95.i();
            int size2 = list2.size();
            for (int i8 = i4; i8 < size2; i8++) {
                if (((h83) list2.get(i8)).b instanceof gc1) {
                    ub2VarI2.add(list2.get(i8));
                }
            }
            ub2 ub2VarC2 = p95.c(ub2VarI2);
            e03 e03Var2 = ub2VarC.a() > ub2VarC2.a() ? new e03(yr2.u(ub2VarC2, ub2VarC), ub2VarC2) : new e03(ub2VarC, yr2.u(ub2VarC, ub2VarC2));
            List list3 = (List) e03Var2.b;
            List list4 = (List) e03Var2.f;
            ub2 ub2VarI3 = p95.i();
            int size3 = list3.size();
            int i9 = i4;
            while (true) {
                c = c2;
                if (i9 >= size3 || i9 == list4.size()) {
                    break;
                }
                ub2VarI3.add(new e03(Float.valueOf(((h83) list3.get(i9)).a), Float.valueOf(((h83) list4.get(i9)).a)));
                i9++;
                c2 = c;
                f = f;
            }
            float f2 = f;
            e03[] e03VarArr = (e03[]) p95.c(ub2VarI3).toArray(new e03[i4]);
            lx0 lx0Var = new lx0((e03[]) Arrays.copyOf(e03VarArr, e03VarArr.length));
            kn2 kn2Var = lx0Var.a;
            kn2 kn2Var2 = lx0Var.b;
            float fN = tj4.N(kn2Var, kn2Var2, 0.0f);
            ArrayList arrayList = lj2VarJ2.f;
            if (0.0f > fN || fN > f2) {
                break;
            }
            if (fN < 1.0E-4f) {
                i2 = i5;
                m20VarArr = m20VarArr3;
                i = i4;
                i3 = 1;
                th = null;
            } else {
                Iterator it = arrayList.iterator();
                int i10 = i4;
                while (true) {
                    if (!it.hasNext()) {
                        th = null;
                        i10 = -1;
                        break;
                    }
                    kj2 kj2Var = (kj2) it.next();
                    th = null;
                    float f3 = kj2Var.c;
                    if (fN <= kj2Var.d && f3 <= fN) {
                        break;
                    } else {
                        i10++;
                    }
                }
                e03 e03VarA2 = ((kj2) arrayList.get(i10)).a(fN);
                kj2 kj2Var2 = (kj2) e03VarA2.b;
                i = i4;
                hg0[] hg0VarArr = new hg0[1];
                hg0VarArr[i] = ((kj2) e03VarA2.f).a;
                ArrayList arrayListL = e70.L(hg0VarArr);
                int size4 = arrayList.size();
                int i11 = 1;
                while (i11 < size4) {
                    arrayListL.add(((kj2) arrayList.get((i11 + i10) % arrayList.size())).a);
                    i11++;
                    i5 = i5;
                }
                i2 = i5;
                arrayListL.add(kj2Var2.a);
                kn2 kn2Var3 = new kn2(arrayList.size() + 2);
                int size5 = arrayList.size() + 2;
                int i12 = i;
                while (i12 < size5) {
                    if (i12 == 0) {
                        m20VarArr2 = m20VarArr3;
                        fD = 0.0f;
                    } else if (i12 == arrayList.size() + 1) {
                        m20VarArr2 = m20VarArr3;
                        fD = f2;
                    } else {
                        m20VarArr2 = m20VarArr3;
                        fD = eo4.d(((kj2) arrayList.get(((i10 + i12) - 1) % arrayList.size())).d - fN, f2);
                    }
                    kn2Var3.a(fD);
                    i12++;
                    m20VarArr3 = m20VarArr2;
                    f2 = 1.0f;
                }
                m20VarArr = m20VarArr3;
                i3 = 1;
                ub2 ub2VarI4 = p95.i();
                int size6 = list2.size();
                for (int i13 = i; i13 < size6; i13++) {
                    ub2VarI4.add(new h83(eo4.d(((h83) list2.get(i13)).a - fN, 1.0f), ((h83) list2.get(i13)).b));
                }
                lj2VarJ2 = new lj2(lj2VarJ2.b, p95.c(ub2VarI4), arrayListL, kn2Var3);
            }
            ArrayList arrayList2 = new ArrayList();
            int i14 = i;
            kj2 kj2Var3 = (kj2) d70.f0(i14, lj2VarJ);
            kj2 kj2Var4 = (kj2) d70.f0(i14, lj2VarJ2);
            int i15 = i3;
            int i16 = i15;
            while (kj2Var3 != null && kj2Var4 != null) {
                float f4 = i16 == lj2VarJ.f.size() ? 1.0f : kj2Var3.d;
                float fN2 = i15 == lj2VarJ2.f.size() ? 1.0f : tj4.N(kn2Var2, kn2Var, eo4.d(kj2Var4.d + fN, 1.0f));
                float fMin = Math.min(f4, fN2);
                float f5 = fMin + 1.0E-6f;
                if (f4 > f5) {
                    e03Var = kj2Var3.a(fMin);
                } else {
                    e03Var = new e03(kj2Var3, d70.f0(i16, lj2VarJ));
                    i16++;
                }
                kj2 kj2Var5 = (kj2) e03Var.b;
                kj2Var3 = (kj2) e03Var.f;
                if (fN2 > f5) {
                    e03VarA = kj2Var4.a(eo4.d(tj4.N(kn2Var, kn2Var2, fMin) - fN, 1.0f));
                } else {
                    e03 e03Var3 = new e03(kj2Var4, d70.f0(i15, lj2VarJ2));
                    i15++;
                    e03VarA = e03Var3;
                }
                kj2 kj2Var6 = (kj2) e03VarA.b;
                kj2Var4 = (kj2) e03VarA.f;
                arrayList2.add(new e03(kj2Var5.a, kj2Var6.a));
            }
            if (kj2Var3 != null || kj2Var4 != null) {
                break;
            }
            m20Var.a = arrayList2;
            m20VarArr[i2] = m20Var;
            i5 = i6;
            f = 1.0f;
            c2 = c;
            i4 = 0;
        }
        xe.k("Expected both Polygon's Cubic to be fully matched");
        throw th;
    }

    public od2(pd2 pd2Var) {
        this.a = pd2Var;
    }
}
