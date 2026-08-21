package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.util.List;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g51 {
    public final te3 a;
    public final x84 b;
    public final n02 c;
    public final oj1 d;

    public g51(te3 te3Var, x84 x84Var, n02 n02Var) {
        this.a = te3Var;
        this.b = x84Var;
        this.c = n02Var;
        this.d = new oj1(te3Var, n02Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x009f -> B:23:0x00a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(pz3 pz3Var, o90 o90Var, ry1 ry1Var, Object obj, rw2 rw2Var, z51 z51Var, ie0 ie0Var) {
        b51 b51Var;
        int i;
        List list;
        e03 e03Var;
        if (ie0Var instanceof b51) {
            b51Var = (b51) ie0Var;
            int i2 = b51Var.E0;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                b51Var.E0 = i2 - Integer.MIN_VALUE;
            } else {
                b51Var = new b51(this, ie0Var);
            }
        }
        Object objA = b51Var.C0;
        int i3 = b51Var.E0;
        if (i3 == 0) {
            n12.S(objA);
            i = 0;
            te3 te3Var = this.a;
            list = o90Var.e;
            if (i >= list.size()) {
            }
            if (e03Var != null) {
            }
        } else {
            if (i3 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            int i4 = b51Var.B0;
            z51 z51Var2 = b51Var.A0;
            rw2 rw2Var2 = b51Var.z0;
            Object obj2 = b51Var.y0;
            ry1 ry1Var2 = b51Var.Z;
            o90 o90Var2 = b51Var.Y;
            pz3 pz3Var2 = b51Var.X;
            g51 g51Var = b51Var.A;
            n12.S(objA);
            int iIntValue = i4;
            this = g51Var;
            z51Var = z51Var2;
            pz3Var = pz3Var2;
            rw2Var = rw2Var2;
            o90Var = o90Var2;
            obj = obj2;
            ry1Var = ry1Var2;
            gk0 gk0Var = (gk0) objA;
            z51Var.getClass();
            if (gk0Var == null) {
                BitmapDrawable bitmapDrawable = gk0Var.a;
                boolean z = gk0Var.b;
                pi0 pi0Var = pz3Var.c;
                j62 j62Var = pz3Var.a;
                sd1 sd1Var = j62Var instanceof sd1 ? (sd1) j62Var : null;
                return new a51(bitmapDrawable, z, pi0Var, sd1Var != null ? sd1Var.z : null);
            }
            i = iIntValue;
            te3 te3Var2 = this.a;
            list = o90Var.e;
            if (i >= list.size()) {
                hn hnVar = (hn) list.get(i);
                hnVar.getClass();
                e03Var = new e03(new jn(pz3Var.a, rw2Var, hnVar.a), Integer.valueOf(i));
            } else {
                e03Var = null;
            }
            if (e03Var != null) {
                zo2.m(obj, "Unable to create a decoder that supports: ");
                return null;
            }
            nk0 nk0Var = (nk0) e03Var.b;
            iIntValue = ((Number) e03Var.f).intValue() + 1;
            z51Var.getClass();
            b51Var.A = this;
            b51Var.X = pz3Var;
            b51Var.Y = o90Var;
            b51Var.Z = ry1Var;
            b51Var.y0 = obj;
            b51Var.z0 = rw2Var;
            b51Var.A0 = z51Var;
            b51Var.B0 = iIntValue;
            b51Var.E0 = 1;
            objA = ((jn) nk0Var).a(b51Var);
            mf0 mf0Var = mf0.b;
            if (objA == mf0Var) {
                return mf0Var;
            }
            gk0 gk0Var2 = (gk0) objA;
            z51Var.getClass();
            if (gk0Var2 == null) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x015f, code lost:
    
        if (r1 == r10) goto L56;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(ry1 ry1Var, Object obj, rw2 rw2Var, z51 z51Var, ie0 ie0Var) throws Throwable {
        c51 c51Var;
        pz3 pz3Var;
        g51 g51Var;
        Object obj2;
        z51 z51Var2;
        bh3 bh3Var;
        bh3 bh3Var2;
        bh3 bh3Var3;
        bh3 bh3Var4;
        ry1 ry1Var2;
        ry1 ry1Var3;
        bh3 bh3Var5;
        bh3 bh3Var6;
        g51 g51Var2;
        pz3 pz3Var2;
        Bitmap bitmap;
        if (ie0Var instanceof c51) {
            c51Var = (c51) ie0Var;
            int i = c51Var.E0;
            if ((i & Integer.MIN_VALUE) != 0) {
                c51Var.E0 = i - Integer.MIN_VALUE;
            } else {
                c51Var = new c51(this, ie0Var);
            }
        }
        c51 c51Var2 = c51Var;
        Object objC = c51Var2.C0;
        bh3 bh3Var7 = c51Var2.E0;
        mf0 mf0Var = mf0.b;
        try {
            if (bh3Var7 == 0) {
                n12.S(objC);
                bh3 bh3Var8 = new bh3();
                bh3Var8.b = rw2Var;
                bh3 bh3Var9 = new bh3();
                bh3Var9.b = this.a.f;
                bh3 bh3Var10 = new bh3();
                try {
                    bh3Var8.b = this.c.Q((rw2) bh3Var8.b);
                    ry1Var.getClass();
                    o90 o90Var = (o90) bh3Var9.b;
                    rw2 rw2Var2 = (rw2) bh3Var8.b;
                    c51Var2.A = this;
                    c51Var2.X = ry1Var;
                    c51Var2.Y = obj;
                    c51Var2.Z = z51Var;
                    c51Var2.y0 = bh3Var8;
                    c51Var2.z0 = bh3Var9;
                    c51Var2.A0 = bh3Var10;
                    c51Var2.B0 = bh3Var10;
                    c51Var2.E0 = 1;
                    objC = c(o90Var, ry1Var, obj, rw2Var2, z51Var, c51Var2);
                    if (objC != mf0Var) {
                        g51Var = this;
                        obj2 = obj;
                        z51Var2 = z51Var;
                        bh3Var = bh3Var8;
                        bh3Var2 = bh3Var9;
                        bh3Var3 = bh3Var10;
                        bh3Var4 = bh3Var3;
                        ry1Var2 = ry1Var;
                    }
                    return mf0Var;
                } catch (Throwable th) {
                    th = th;
                    bh3Var7 = bh3Var10;
                    Object obj3 = bh3Var7.b;
                    if (obj3 instanceof pz3) {
                    }
                    if (pz3Var != null) {
                    }
                    throw th;
                }
            }
            if (bh3Var7 == 1) {
                bh3Var3 = c51Var2.B0;
                bh3Var4 = c51Var2.A0;
                bh3 bh3Var11 = c51Var2.z0;
                bh3 bh3Var12 = c51Var2.y0;
                z51 z51Var3 = (z51) c51Var2.Z;
                Object obj4 = c51Var2.Y;
                ry1Var2 = c51Var2.X;
                g51 g51Var3 = c51Var2.A;
                n12.S(objC);
                bh3Var2 = bh3Var11;
                bh3Var = bh3Var12;
                z51Var2 = z51Var3;
                obj2 = obj4;
                g51Var = g51Var3;
            } else {
                if (bh3Var7 != 2) {
                    if (bh3Var7 != 3) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(objC);
                    a51 a51Var = (a51) objC;
                    Drawable drawable = a51Var.a;
                    BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
                    if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                        bitmap.prepareToDraw();
                    }
                    return a51Var;
                }
                bh3Var4 = c51Var2.y0;
                bh3Var6 = (bh3) c51Var2.Z;
                ry1Var3 = c51Var2.X;
                g51Var2 = c51Var2.A;
                n12.S(objC);
                objC = (a51) objC;
                bh3Var5 = bh3Var6;
                g51Var = g51Var2;
                ry1 ry1Var4 = ry1Var3;
                Object obj5 = bh3Var4.b;
                pz3Var2 = obj5 instanceof pz3 ? (pz3) obj5 : null;
                if (pz3Var2 != null) {
                    j.a(pz3Var2.a);
                }
                c51Var2.A = null;
                c51Var2.X = null;
                c51Var2.Y = null;
                c51Var2.Z = null;
                c51Var2.y0 = null;
                c51Var2.z0 = null;
                c51Var2.A0 = null;
                c51Var2.B0 = null;
                c51Var2.E0 = 3;
                g51Var.getClass();
                ry1Var4.getClass();
            }
            bh3Var3.b = objC;
            Object obj6 = bh3Var4.b;
            dd1 dd1Var = (dd1) obj6;
            if (dd1Var instanceof pz3) {
                ef0 ef0Var = ry1Var2.p;
                bh3 bh3Var13 = bh3Var4;
                ry1 ry1Var5 = ry1Var2;
                try {
                    d51 d51Var = new d51(g51Var, bh3Var13, bh3Var2, ry1Var5, obj2, bh3Var, z51Var2, (ge0) null);
                    ry1Var3 = ry1Var5;
                    bh3 bh3Var14 = bh3Var;
                    z51 z51Var4 = z51Var2;
                    c51Var2.A = g51Var;
                    c51Var2.X = ry1Var3;
                    c51Var2.Y = z51Var4;
                    c51Var2.Z = bh3Var14;
                    c51Var2.y0 = bh3Var4;
                    c51Var2.z0 = null;
                    c51Var2.A0 = null;
                    c51Var2.B0 = null;
                    c51Var2.E0 = 2;
                    objC = ji0.b0(ef0Var, d51Var, c51Var2);
                    if (objC == mf0Var) {
                        return mf0Var;
                    }
                    bh3Var6 = bh3Var14;
                    g51Var2 = g51Var;
                    objC = (a51) objC;
                    bh3Var5 = bh3Var6;
                    g51Var = g51Var2;
                    ry1 ry1Var42 = ry1Var3;
                    Object obj52 = bh3Var4.b;
                    if (obj52 instanceof pz3) {
                    }
                    if (pz3Var2 != null) {
                    }
                    c51Var2.A = null;
                    c51Var2.X = null;
                    c51Var2.Y = null;
                    c51Var2.Z = null;
                    c51Var2.y0 = null;
                    c51Var2.z0 = null;
                    c51Var2.A0 = null;
                    c51Var2.B0 = null;
                    c51Var2.E0 = 3;
                    g51Var.getClass();
                    ry1Var42.getClass();
                } catch (Throwable th2) {
                    th = th2;
                    bh3Var7 = bh3Var13;
                    Object obj32 = bh3Var7.b;
                    pz3Var = obj32 instanceof pz3 ? (pz3) obj32 : null;
                    if (pz3Var != null) {
                        j.a(pz3Var.a);
                    }
                    throw th;
                }
            } else {
                ry1Var3 = ry1Var2;
                bh3Var5 = bh3Var;
                if (!(dd1Var instanceof ox0)) {
                    throw new t80();
                }
                objC = new a51(((ox0) obj6).a, ((ox0) obj6).b, ((ox0) obj6).c, null);
                ry1 ry1Var422 = ry1Var3;
                Object obj522 = bh3Var4.b;
                if (obj522 instanceof pz3) {
                }
                if (pz3Var2 != null) {
                }
                c51Var2.A = null;
                c51Var2.X = null;
                c51Var2.Y = null;
                c51Var2.Z = null;
                c51Var2.y0 = null;
                c51Var2.z0 = null;
                c51Var2.A0 = null;
                c51Var2.B0 = null;
                c51Var2.E0 = 3;
                g51Var.getClass();
                ry1Var422.getClass();
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a8 -> B:28:0x00ab). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(o90 o90Var, ry1 ry1Var, Object obj, rw2 rw2Var, z51 z51Var, ie0 ie0Var) {
        e51 e51Var;
        int i;
        int size;
        e03 e03Var;
        if (ie0Var instanceof e51) {
            e51Var = (e51) ie0Var;
            int i2 = e51Var.D0;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                e51Var.D0 = i2 - Integer.MIN_VALUE;
            } else {
                e51Var = new e51(this, ie0Var);
            }
        }
        Object objA = e51Var.B0;
        int i3 = e51Var.D0;
        if (i3 == 0) {
            n12.S(objA);
            i = 0;
            te3 te3Var = this.a;
            List list = o90Var.d;
            size = list.size();
            while (true) {
                if (i < size) {
                }
                i++;
            }
            if (e03Var != null) {
            }
        } else {
            if (i3 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            int i4 = e51Var.A0;
            z51 z51Var2 = e51Var.z0;
            rw2 rw2Var2 = e51Var.y0;
            obj = e51Var.Z;
            ry1 ry1Var2 = e51Var.Y;
            o90 o90Var2 = e51Var.X;
            g51 g51Var = e51Var.A;
            n12.S(objA);
            int iIntValue = i4;
            this = g51Var;
            z51Var = z51Var2;
            o90Var = o90Var2;
            rw2Var = rw2Var2;
            ry1Var = ry1Var2;
            dd1 dd1Var = (dd1) objA;
            try {
                z51Var.getClass();
                if (dd1Var == null) {
                    return dd1Var;
                }
                i = iIntValue;
                te3 te3Var2 = this.a;
                List list2 = o90Var.d;
                size = list2.size();
                while (true) {
                    if (i < size) {
                        e03Var = null;
                        break;
                    }
                    e03 e03Var2 = (e03) list2.get(i);
                    fd1 fd1Var = (fd1) e03Var2.b;
                    if (((Class) e03Var2.f).isAssignableFrom(obj.getClass())) {
                        fd1Var.getClass();
                        gd1 gd1VarA = fd1Var.a(obj, rw2Var);
                        if (gd1VarA != null) {
                            e03Var = new e03(gd1VarA, Integer.valueOf(i));
                            break;
                        }
                    }
                    i++;
                }
                if (e03Var != null) {
                    zo2.m(obj, "Unable to create a fetcher that supports: ");
                    return null;
                }
                gd1 gd1Var = (gd1) e03Var.b;
                iIntValue = ((Number) e03Var.f).intValue() + 1;
                z51Var.getClass();
                e51Var.A = this;
                e51Var.X = o90Var;
                e51Var.Y = ry1Var;
                e51Var.Z = obj;
                e51Var.y0 = rw2Var;
                e51Var.z0 = z51Var;
                e51Var.A0 = iIntValue;
                e51Var.D0 = 1;
                objA = gd1Var.a(e51Var);
                mf0 mf0Var = mf0.b;
                if (objA == mf0Var) {
                    return mf0Var;
                }
                dd1 dd1Var2 = (dd1) objA;
                z51Var.getClass();
                if (dd1Var2 == null) {
                }
            } catch (Throwable th) {
                pz3 pz3Var = dd1Var2 instanceof pz3 ? (pz3) dd1Var2 : null;
                if (pz3Var != null) {
                    j.a(pz3Var.a);
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(e10 e10Var, ie0 ie0Var) {
        f51 f51Var;
        g51 g51Var = this;
        e10 e10Var2 = e10Var;
        oj1 oj1Var = g51Var.d;
        if (ie0Var instanceof f51) {
            f51Var = (f51) ie0Var;
            int i = f51Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                f51Var.y0 = i - Integer.MIN_VALUE;
            } else {
                f51Var = new f51(g51Var, ie0Var);
            }
        }
        f51 f51Var2 = f51Var;
        Object obj = f51Var2.Y;
        int i2 = f51Var2.y0;
        if (i2 == 0) {
            n12.S(obj);
            try {
                ry1 ry1Var = (ry1) e10Var2.X;
                Object obj2 = ry1Var.b;
                wx3 wx3Var = (wx3) e10Var2.Y;
                Bitmap.Config config = j.a;
                z51 z51Var = (z51) e10Var2.Z;
                rw2 rw2VarC = g51Var.c.C(ry1Var, wx3Var);
                sp3 sp3Var = rw2VarC.e;
                List list = g51Var.a.f.b;
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    e03 e03Var = (e03) list.get(i3);
                    pt ptVar = (pt) e03Var.b;
                    if (((Class) e03Var.f).isAssignableFrom(obj2.getClass())) {
                        ptVar.getClass();
                        Object objA = ptVar.a(obj2, rw2VarC);
                        if (objA != null) {
                            obj2 = objA;
                        }
                    }
                }
                tj2 tj2VarC = oj1Var.C(ry1Var, obj2, rw2VarC, z51Var);
                uj2 uj2VarB = tj2VarC != null ? oj1Var.B(ry1Var, tj2VarC, wx3Var, sp3Var) : null;
                if (uj2VarB != null) {
                    return oj1.D(e10Var2, ry1Var, tj2VarC, uj2VarB);
                }
                ef0 ef0Var = ry1Var.o;
                d51 d51Var = new d51(g51Var, ry1Var, obj2, rw2VarC, z51Var, tj2VarC, e10Var2, (ge0) null);
                f51Var2.A = g51Var;
                f51Var2.X = e10Var2;
                f51Var2.y0 = 1;
                Object objB0 = ji0.b0(ef0Var, d51Var, f51Var2);
                mf0 mf0Var = mf0.b;
                return objB0 == mf0Var ? mf0Var : objB0;
            } catch (Throwable th) {
                th = th;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            e10 e10Var3 = f51Var2.X;
            g51 g51Var2 = f51Var2.A;
            try {
                n12.S(obj);
                return obj;
            } catch (Throwable th2) {
                th = th2;
                e10Var2 = e10Var3;
                g51Var = g51Var2;
            }
        }
        if (th instanceof CancellationException) {
            throw th;
        }
        n02 n02Var = g51Var.c;
        return n02.j((ry1) e10Var2.X, th);
    }
}
