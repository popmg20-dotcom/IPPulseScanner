package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class te3 {
    public final Context a;
    public final em0 b;
    public final n84 c;
    public final ce0 d;
    public final n02 e;
    public final o90 f;
    public final ArrayList g;

    public te3(Context context, em0 em0Var, n84 n84Var, n84 n84Var2, n84 n84Var3, o90 o90Var, wl3 wl3Var) {
        this.a = context;
        this.b = em0Var;
        this.c = n84Var;
        r54 r54VarD = gb4.d();
        gm0 gm0Var = qv0.a;
        this.d = p95.a(tj4.W(r54VarD, qf2.a.X).X(new se3(vd3.z)));
        x84 x84Var = new x84(this);
        n02 n02Var = new n02(this, x84Var);
        this.e = n02Var;
        v92 v92Var = new v92();
        v92Var.b = d70.z0(o90Var.a);
        v92Var.f = d70.z0(o90Var.b);
        v92Var.z = d70.z0(o90Var.c);
        v92Var.A = d70.z0(o90Var.d);
        v92Var.X = d70.z0(o90Var.e);
        int i = 2;
        v92Var.a(new pt(i), ev1.class);
        int i2 = 5;
        v92Var.a(new pt(i2), String.class);
        int i3 = 1;
        v92Var.a(new pt(i3), Uri.class);
        int i4 = 4;
        v92Var.a(new pt(i4), Uri.class);
        int i5 = 3;
        v92Var.a(new pt(i5), Integer.class);
        int i6 = 0;
        v92Var.a(new pt(i6), byte[].class);
        zc zcVar = new zc(2);
        ArrayList arrayList = (ArrayList) v92Var.z;
        arrayList.add(new e03(zcVar, Uri.class));
        arrayList.add(new e03(new zc(1), File.class));
        v92Var.b(new zu1(n84Var3, n84Var2), Uri.class);
        v92Var.b(new df(i2), File.class);
        v92Var.b(new df(i6), Uri.class);
        v92Var.b(new df(i5), Uri.class);
        v92Var.b(new df(6), Uri.class);
        v92Var.b(new df(i4), Drawable.class);
        v92Var.b(new df(i3), Bitmap.class);
        v92Var.b(new df(i), ByteBuffer.class);
        hn hnVar = new hn();
        ArrayList arrayList2 = (ArrayList) v92Var.X;
        arrayList2.add(hnVar);
        List listH = ke0.H((ArrayList) v92Var.b);
        this.f = new o90(listH, ke0.H((ArrayList) v92Var.f), ke0.H(arrayList), ke0.H((ArrayList) v92Var.A), ke0.H(arrayList2));
        this.g = d70.n0(listH, new g51(this, x84Var, n02Var));
        new AtomicBoolean(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(w51 w51Var, ty1 ty1Var, z51 z51Var) {
        ry1 ry1Var = w51Var.b;
        Drawable drawable = w51Var.a;
        if (ty1Var instanceof ty1) {
            ug4 ug4VarA = ry1Var.f.a(ty1Var, w51Var);
            if (!(ug4VarA instanceof ms2)) {
                z51Var.getClass();
                ug4VarA.a();
            }
        } else if (ty1Var != null) {
            ty1Var.b(drawable);
        }
        z51Var.getClass();
        ry1Var.getClass();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(l54 l54Var, ty1 ty1Var, z51 z51Var) {
        ry1 ry1Var = l54Var.b;
        Drawable drawable = l54Var.a;
        if (ty1Var instanceof ty1) {
            ug4 ug4VarA = ry1Var.f.a(ty1Var, l54Var);
            if (!(ug4VarA instanceof ms2)) {
                z51Var.getClass();
                ug4VarA.a();
            }
        } else if (ty1Var != null) {
            ty1Var.b(drawable);
        }
        z51Var.getClass();
        ry1Var.getClass();
    }

    public final xv0 a(ry1 ry1Var) {
        ji0.b(this.d, null, new w53(this, ry1Var, null, 5), 3);
        ty1 ty1Var = ry1Var.c;
        if (!(ty1Var instanceof ty1)) {
            return new k01(25);
        }
        jr4 jr4VarC = j.c(ty1Var.f);
        synchronized (jr4VarC) {
            c84 c84Var = jr4VarC.b;
            if (c84Var != null && n12.c(Looper.myLooper(), Looper.getMainLooper()) && jr4VarC.A) {
                jr4VarC.A = false;
                return c84Var;
            }
            z14 z14Var = jr4VarC.f;
            if (z14Var != null) {
                z14Var.g(null);
            }
            jr4VarC.f = null;
            c84 c84Var2 = new c84(4);
            jr4VarC.b = c84Var2;
            return c84Var2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0135 A[Catch: all -> 0x0139, TryCatch #5 {all -> 0x0139, blocks: (B:43:0x012b, B:45:0x0135, B:48:0x013c, B:50:0x014e, B:51:0x0151, B:38:0x010e, B:40:0x0114, B:78:0x01d5, B:79:0x01dc), top: B:98:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014e A[Catch: all -> 0x0139, TryCatch #5 {all -> 0x0139, blocks: (B:43:0x012b, B:45:0x0135, B:48:0x013c, B:50:0x014e, B:51:0x0151, B:38:0x010e, B:40:0x0114, B:78:0x01d5, B:79:0x01dc), top: B:98:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a0 A[Catch: all -> 0x01b0, TryCatch #0 {all -> 0x01b0, blocks: (B:61:0x019a, B:63:0x01a0, B:67:0x01b2, B:69:0x01b6, B:72:0x01c5, B:73:0x01ca), top: B:91:0x019a }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b2 A[Catch: all -> 0x01b0, TryCatch #0 {all -> 0x01b0, blocks: (B:61:0x019a, B:63:0x01a0, B:67:0x01b2, B:69:0x01b6, B:72:0x01c5, B:73:0x01ca), top: B:91:0x019a }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object, te3] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [jj3] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, ry1] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object, z51] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(ry1 ry1Var, ie0 ie0Var) {
        re3 re3Var;
        ?? r2;
        ?? r4;
        ?? r1;
        jj3 jj3Var;
        z51 z51Var;
        te3 te3Var;
        ?? r3;
        Bitmap bitmap;
        z51 z51Var2;
        ry1 ry1Var2;
        jj3 jj3Var2;
        te3 te3Var2;
        te3 te3Var3;
        jj3 jj3Var3;
        ry1 ry1Var3;
        z51 z51Var3;
        sy1 sy1Var;
        z51 z51Var4;
        ry1 ry1Var4;
        ty1 ty1Var;
        Object objA;
        te3 te3Var4 = this;
        if (ie0Var instanceof re3) {
            re3Var = (re3) ie0Var;
            int i = re3Var.B0;
            if ((i & Integer.MIN_VALUE) != 0) {
                re3Var.B0 = i - Integer.MIN_VALUE;
            } else {
                re3Var = new re3(te3Var4, ie0Var);
            }
        }
        re3 re3Var2 = re3Var;
        Object objB0 = re3Var2.z0;
        int i2 = re3Var2.B0;
        mf0 mf0Var = mf0.b;
        if (i2 != 0) {
            try {
                if (i2 == 1) {
                    z51 z51Var5 = re3Var2.Z;
                    ry1 ry1Var5 = re3Var2.Y;
                    jj3 jj3Var4 = re3Var2.X;
                    te3 te3Var5 = re3Var2.A;
                    n12.S(objB0);
                    jj3Var = jj3Var4;
                    z51Var = z51Var5;
                    te3Var = te3Var5;
                    ry1Var4 = ry1Var5;
                    if (((we3) te3Var.c.getValue()) != null) {
                        ry1Var4.getClass();
                    }
                    ry1Var4.getClass();
                    Integer num = ry1Var4.v;
                    ry1Var4.x.getClass();
                    Drawable drawableB = h.b(ry1Var4, num);
                    ty1Var = ry1Var4.c;
                    if (ty1Var != null) {
                        ty1Var.b(drawableB);
                    }
                    z51Var.getClass();
                    xx3 xx3Var = ry1Var4.s;
                    re3Var2.A = te3Var;
                    re3Var2.X = jj3Var;
                    re3Var2.Y = ry1Var4;
                    re3Var2.Z = z51Var;
                    re3Var2.y0 = null;
                    re3Var2.B0 = 2;
                    objA = xx3Var.a(re3Var2);
                    if (objA != mf0Var) {
                        te3Var2 = te3Var;
                        ry1Var2 = ry1Var4;
                        z51Var2 = z51Var;
                        bitmap = null;
                        jj3Var2 = jj3Var;
                        objB0 = objA;
                        z51Var2.getClass();
                        ef0 ef0Var = ry1Var2.n;
                        q73 q73Var = new q73(ry1Var2, te3Var2, (wx3) objB0, z51Var2, bitmap, null, 1);
                        z51Var4 = z51Var2;
                        re3Var2.A = te3Var2;
                        re3Var2.X = jj3Var2;
                        re3Var2.Y = ry1Var2;
                        re3Var2.Z = z51Var4;
                        re3Var2.y0 = null;
                        re3Var2.B0 = 3;
                        objB0 = ji0.b0(ef0Var, q73Var, re3Var2);
                        if (objB0 != mf0Var) {
                        }
                    }
                    return mf0Var;
                }
                if (i2 == 2) {
                    Bitmap bitmap2 = re3Var2.y0;
                    z51 z51Var6 = re3Var2.Z;
                    ry1 ry1Var6 = re3Var2.Y;
                    jj3 jj3Var5 = re3Var2.X;
                    te3 te3Var6 = re3Var2.A;
                    try {
                        n12.S(objB0);
                        bitmap = bitmap2;
                        z51Var2 = z51Var6;
                        ry1Var2 = ry1Var6;
                        jj3Var2 = jj3Var5;
                        te3Var2 = te3Var6;
                        try {
                            z51Var2.getClass();
                            ef0 ef0Var2 = ry1Var2.n;
                            q73 q73Var2 = new q73(ry1Var2, te3Var2, (wx3) objB0, z51Var2, bitmap, null, 1);
                            z51Var4 = z51Var2;
                        } catch (Throwable th) {
                            th = th;
                            z51Var4 = z51Var2;
                        }
                        try {
                            re3Var2.A = te3Var2;
                            re3Var2.X = jj3Var2;
                            re3Var2.Y = ry1Var2;
                            re3Var2.Z = z51Var4;
                            re3Var2.y0 = null;
                            re3Var2.B0 = 3;
                            objB0 = ji0.b0(ef0Var2, q73Var2, re3Var2);
                            if (objB0 != mf0Var) {
                                z51Var3 = z51Var4;
                                ry1Var3 = ry1Var2;
                                jj3Var3 = jj3Var2;
                                te3Var3 = te3Var2;
                                sy1Var = (sy1) objB0;
                                if (!(sy1Var instanceof l54)) {
                                }
                                jj3Var3.s();
                                return sy1Var;
                            }
                            return mf0Var;
                        } catch (Throwable th2) {
                            th = th2;
                            r2 = jj3Var2;
                            r1 = te3Var2;
                            r4 = z51Var4;
                            r3 = ry1Var2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        r4 = z51Var6;
                        r3 = ry1Var6;
                        r2 = jj3Var5;
                        r1 = te3Var6;
                    }
                } else {
                    if (i2 != 3) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    z51 z51Var7 = re3Var2.Z;
                    ry1 ry1Var7 = re3Var2.Y;
                    jj3 jj3Var6 = re3Var2.X;
                    te3 te3Var7 = re3Var2.A;
                    n12.S(objB0);
                    te3Var3 = te3Var7;
                    z51Var3 = z51Var7;
                    ry1Var3 = ry1Var7;
                    jj3Var3 = jj3Var6;
                    try {
                        sy1Var = (sy1) objB0;
                        if (!(sy1Var instanceof l54)) {
                            ty1 ty1Var2 = ry1Var3.c;
                            te3Var3.getClass();
                            d((l54) sy1Var, ty1Var2, z51Var3);
                        } else {
                            if (!(sy1Var instanceof w51)) {
                                throw new t80();
                            }
                            ty1 ty1Var3 = ry1Var3.c;
                            te3Var3.getClass();
                            c((w51) sy1Var, ty1Var3, z51Var3);
                        }
                        jj3Var3.s();
                        return sy1Var;
                    } catch (Throwable th4) {
                        th = th4;
                        r2 = jj3Var3;
                        r4 = z51Var3;
                        r1 = te3Var3;
                        r3 = ry1Var3;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                r2 = ry1Var;
                r4 = te3Var4;
                r1 = -2147483648;
                r3 = i2;
            }
        } else {
            n12.S(objB0);
            cf0 cf0Var = re3Var2.f;
            cf0Var.getClass();
            v32 v32VarG = je.G(cf0Var);
            n02 n02Var = te3Var4.e;
            n02Var.getClass();
            r92 r92Var = ry1Var.r;
            ty1 ty1Var4 = ry1Var.c;
            jj3 ir4Var = ty1Var4 instanceof ty1 ? new ir4((te3) n02Var.f, ry1Var, ty1Var4, r92Var, v32VarG) : new fl(r92Var, v32VarG);
            ir4Var.g();
            Context context = ry1Var.a;
            qy1 qy1Var = new qy1();
            qy1Var.a = context;
            qy1Var.b = ry1Var.x;
            qy1Var.c = ry1Var.b;
            qy1Var.d = ry1Var.c;
            qy1Var.e = ry1Var.w.a;
            lr1 lr1Var = ry1Var.g;
            lr1Var.getClass();
            qy1Var.f = gb4.A(lr1Var);
            Map map = ry1Var.h.a;
            map.getClass();
            qy1Var.g = new LinkedHashMap(map);
            qy1Var.h = new jf2(ry1Var.u);
            qy1Var.i = ry1Var.v;
            if (ry1Var.a == context) {
                qy1Var.j = ry1Var.r;
                qy1Var.k = ry1Var.s;
                qy1Var.l = ry1Var.t;
            } else {
                qy1Var.j = null;
                qy1Var.k = null;
                qy1Var.l = null;
            }
            qy1Var.b = te3Var4.b;
            qy1Var.l = null;
            ry1 ry1VarA = qy1Var.a();
            z51 z51Var8 = z51.a;
            try {
                if (ry1VarA.b == d7.y0) {
                    throw new ys2("The request's data is null.");
                }
                ir4Var.start();
                r92 r92Var2 = ry1VarA.r;
                re3Var2.A = te3Var4;
                re3Var2.X = ir4Var;
                re3Var2.Y = ry1VarA;
                re3Var2.Z = z51Var8;
                re3Var2.B0 = 1;
                te3Var = te3Var4;
                jj3Var = ir4Var;
                ry1Var4 = ry1VarA;
                z51Var = z51Var8;
                if (ek0.c(r92Var2, re3Var2) != mf0Var) {
                    if (((we3) te3Var.c.getValue()) != null) {
                    }
                    ry1Var4.getClass();
                    Integer num2 = ry1Var4.v;
                    ry1Var4.x.getClass();
                    Drawable drawableB2 = h.b(ry1Var4, num2);
                    ty1Var = ry1Var4.c;
                    if (ty1Var != null) {
                    }
                    z51Var.getClass();
                    xx3 xx3Var2 = ry1Var4.s;
                    re3Var2.A = te3Var;
                    re3Var2.X = jj3Var;
                    re3Var2.Y = ry1Var4;
                    re3Var2.Z = z51Var;
                    re3Var2.y0 = null;
                    re3Var2.B0 = 2;
                    objA = xx3Var2.a(re3Var2);
                    if (objA != mf0Var) {
                    }
                }
                return mf0Var;
            } catch (Throwable th6) {
                th = th6;
                r1 = te3Var4;
                r2 = ir4Var;
                r3 = ry1VarA;
                r4 = z51Var8;
            }
        }
        try {
            if (th instanceof CancellationException) {
                r1.getClass();
                r4.getClass();
                r3.getClass();
                throw th;
            }
            r1.e.getClass();
            w51 w51VarJ = n02.j(r3, th);
            c(w51VarJ, r3.c, r4);
            return w51VarJ;
        } finally {
            r2.s();
        }
    }
}
