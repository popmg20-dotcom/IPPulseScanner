package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(defpackage.w51 r3, defpackage.ty1 r4, defpackage.z51 r5) {
        /*
            ry1 r0 = r3.b
            android.graphics.drawable.Drawable r1 = r3.a
            boolean r2 = r4 instanceof defpackage.ty1
            if (r2 != 0) goto Lb
            if (r4 == 0) goto L1f
            goto L15
        Lb:
            qg4 r2 = r0.f
            ug4 r3 = r2.a(r4, r3)
            boolean r2 = r3 instanceof defpackage.ms2
            if (r2 == 0) goto L19
        L15:
            r4.b(r1)
            goto L1f
        L19:
            r5.getClass()
            r3.a()
        L1f:
            r5.getClass()
            r0.getClass()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.te3.c(w51, ty1, z51):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(defpackage.l54 r3, defpackage.ty1 r4, defpackage.z51 r5) {
        /*
            ry1 r0 = r3.b
            android.graphics.drawable.Drawable r1 = r3.a
            boolean r2 = r4 instanceof defpackage.ty1
            if (r2 != 0) goto Lb
            if (r4 == 0) goto L1f
            goto L15
        Lb:
            qg4 r2 = r0.f
            ug4 r3 = r2.a(r4, r3)
            boolean r2 = r3 instanceof defpackage.ms2
            if (r2 == 0) goto L19
        L15:
            r4.b(r1)
            goto L1f
        L19:
            r5.getClass()
            r3.a()
        L1f:
            r5.getClass()
            r0.getClass()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.te3.d(l54, ty1, z51):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(defpackage.ry1 r23, defpackage.ie0 r24) {
        /*
            Method dump skipped, instruction units count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.te3.b(ry1, ie0):java.lang.Object");
    }
}
