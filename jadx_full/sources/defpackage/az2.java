package defpackage;

import android.os.Build;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class az2 {
    public final Object a;
    public final hj3 b;
    public final ue2 c;
    public final av d;
    public final wn1 e;
    public final AtomicBoolean f;
    public final xp g;
    public final bz2 h;
    public final x32 i;
    public final pg1 j;

    public az2(Object obj, hj3 hj3Var, ue2 ue2Var, av avVar, b03 b03Var, ly2 ly2Var) {
        hj3Var.getClass();
        this.a = obj;
        this.b = hj3Var;
        this.c = ue2Var;
        this.d = avVar;
        this.e = new wn1(1);
        this.f = new AtomicBoolean(false);
        ge0 ge0Var = null;
        this.g = uf2.a(-2, null, null, 6);
        this.h = new bz2(ue2Var);
        x32 x32VarB = je.b();
        this.i = x32VarB;
        this.j = new pg1(new hd(this, ge0Var, 11), ez4.U(new uf(x32VarB, new hd(this, ge0Var, 10), ge0Var, 2)));
    }

    public static String f(hd2 hd2Var, Object obj, a03 a03Var) {
        if (a03Var == null) {
            return "End " + hd2Var + " with loadkey " + obj + ". Load CANCELLED.";
        }
        return "End " + hd2Var + " with loadKey " + obj + ". Returned " + a03Var;
    }

    public final Object a(pg1 pg1Var, hd2 hd2Var, v74 v74Var) {
        ge0 ge0Var = null;
        zf1 zf1VarU = ez4.U(new fg1(pg1Var, new qy2(null, this, hd2Var), ge0Var, 1));
        ry2 ry2Var = new ry2(hd2Var, null);
        zf1VarU.getClass();
        Object objA = p95.b(new av(7, new fg1(zf1VarU, ry2Var, ge0Var, 0)), -1).a(new tf(3, this, hd2Var), v74Var);
        return objA == mf0.b ? objA : xl4.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(ie0 ie0Var) {
        ty2 ty2Var;
        yn2 yn2Var;
        bz2 bz2Var;
        if (ie0Var instanceof ty2) {
            ty2Var = (ty2) ie0Var;
            int i = ty2Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                ty2Var.y0 = i - Integer.MIN_VALUE;
            } else {
                ty2Var = new ty2(this, ie0Var);
            }
        }
        Object obj = ty2Var.Y;
        int i2 = ty2Var.y0;
        if (i2 == 0) {
            n12.S(obj);
            bz2 bz2Var2 = this.h;
            yn2Var = bz2Var2.a;
            ty2Var.A = bz2Var2;
            ty2Var.X = yn2Var;
            ty2Var.y0 = 1;
            Object objG = yn2Var.g(ty2Var);
            mf0 mf0Var = mf0.b;
            if (objG == mf0Var) {
                return mf0Var;
            }
            bz2Var = bz2Var2;
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            yn2Var = ty2Var.X;
            bz2Var = ty2Var.A;
            n12.S(obj);
        }
        try {
            return bz2Var.b.a((yr4) ((iv1) this.e.f).A);
        } finally {
            yn2Var.n(null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x01be, code lost:
    
        if (r0.a(r2, r1) != r13) goto L83;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fa A[PHI: r3
      0x00fa: PHI (r3v9 wn2) = (r3v6 wn2), (r3v16 wn2) binds: [B:44:0x00f6, B:34:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0132 A[PHI: r1
      0x0132: PHI (r1v7 java.lang.Object) = (r1v6 java.lang.Object), (r1v1 java.lang.Object) binds: [B:52:0x012e, B:32:0x00b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0167 A[Catch: all -> 0x016d, TRY_ENTER, TryCatch #5 {all -> 0x016d, blocks: (B:60:0x014d, B:63:0x0167, B:66:0x016f, B:68:0x0176), top: B:138:0x014d }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0176 A[Catch: all -> 0x016d, TRY_LEAVE, TryCatch #5 {all -> 0x016d, blocks: (B:60:0x014d, B:63:0x0167, B:66:0x016f, B:68:0x0176), top: B:138:0x014d }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e0  */
    /* JADX WARN: Type inference failed for: r16v0, types: [az2] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [wn2] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v2, types: [wn2] */
    /* JADX WARN: Type inference failed for: r3v33, types: [wn2] */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(ie0 ie0Var) throws Throwable {
        uy2 uy2Var;
        wn2 wn2Var;
        bz2 bz2Var;
        dz2 dz2Var;
        a03 a03Var;
        yn2 yn2Var;
        a03 a03Var2;
        yn2 yn2Var2;
        a03 a03Var3;
        bz2 bz2Var2;
        boolean zB;
        Object obj;
        yn2 yn2Var3;
        a03 a03Var4;
        wn2 wn2Var2;
        dz2 dz2Var2;
        cd2 cd2Var;
        if (ie0Var instanceof uy2) {
            uy2Var = (uy2) ie0Var;
            int i = uy2Var.z0;
            if ((i & Integer.MIN_VALUE) != 0) {
                uy2Var.z0 = i - Integer.MIN_VALUE;
            } else {
                uy2Var = new uy2(this, ie0Var);
            }
        }
        Object objD = uy2Var.Z;
        ?? r3 = uy2Var.z0;
        hd2 hd2Var = hd2.b;
        xl4 xl4Var = xl4.a;
        hj3 hj3Var = this.b;
        bz2 bz2Var3 = this.h;
        Object obj2 = this.a;
        mf0 mf0Var = mf0.b;
        try {
            try {
                switch (r3) {
                    case 0:
                        n12.S(objD);
                        yn2 yn2Var4 = bz2Var3.a;
                        uy2Var.A = bz2Var3;
                        uy2Var.X = yn2Var4;
                        uy2Var.z0 = 1;
                        if (yn2Var4.g(uy2Var) != mf0Var) {
                            wn2Var = yn2Var4;
                            bz2Var = bz2Var3;
                            dz2Var = bz2Var.b;
                            uy2Var.A = wn2Var;
                            uy2Var.X = null;
                            uy2Var.z0 = 2;
                            if (j(dz2Var, hd2Var, uy2Var) != mf0Var) {
                                wn2Var.n(null);
                                wz2 wz2VarE = e(hd2Var, obj2);
                                r3 = Build.ID;
                                if (r3 != 0 && Log.isLoggable("Paging", 3)) {
                                    Log.d("Paging", "Start REFRESH with loadKey " + obj2 + " on " + hj3Var, null);
                                }
                                uy2Var.A = null;
                                uy2Var.z0 = 3;
                                objD = hj3Var.d.d(wz2VarE, uy2Var);
                                if (objD != mf0Var) {
                                    a03Var = (a03) objD;
                                    if (!(a03Var instanceof zz2)) {
                                        yn2Var2 = bz2Var3.a;
                                        uy2Var.A = a03Var;
                                        uy2Var.X = bz2Var3;
                                        uy2Var.Y = yn2Var2;
                                        uy2Var.z0 = 4;
                                        if (yn2Var2.g(uy2Var) != mf0Var) {
                                            a03Var3 = a03Var;
                                            bz2Var2 = bz2Var3;
                                            try {
                                                dz2 dz2Var3 = bz2Var2.b;
                                                zB = dz2Var3.b(0, hd2Var, (zz2) a03Var3);
                                                n02 n02Var = dz2Var3.j;
                                                n02Var.N(hd2Var, ed2.c);
                                                obj = ((zz2) a03Var3).f;
                                                ed2 ed2Var = ed2.b;
                                                if (obj == null) {
                                                    n02Var.N(hd2.f, ed2Var);
                                                }
                                                if (((zz2) a03Var3).z == null) {
                                                    n02Var.N(hd2.z, ed2Var);
                                                }
                                                if (zB) {
                                                    if (Build.ID != null && Log.isLoggable("Paging", 2)) {
                                                        Log.v("Paging", f(hd2Var, obj2, null), null);
                                                    }
                                                    return xl4Var;
                                                }
                                                if (Build.ID != null && Log.isLoggable("Paging", 3)) {
                                                    Log.d("Paging", f(hd2Var, obj2, a03Var3), null);
                                                }
                                                yn2 yn2Var5 = bz2Var3.a;
                                                uy2Var.A = a03Var3;
                                                uy2Var.X = bz2Var3;
                                                uy2Var.Y = yn2Var5;
                                                uy2Var.z0 = 5;
                                                if (yn2Var5.g(uy2Var) != mf0Var) {
                                                    yn2Var3 = yn2Var5;
                                                    a03Var4 = a03Var3;
                                                    dz2 dz2Var4 = bz2Var3.b;
                                                    xp xpVar = this.g;
                                                    hy2 hy2VarC = dz2Var4.c((zz2) a03Var4, hd2Var);
                                                    uy2Var.A = a03Var4;
                                                    uy2Var.X = yn2Var3;
                                                    uy2Var.Y = null;
                                                    uy2Var.z0 = 6;
                                                    r3 = yn2Var3;
                                                }
                                            } catch (Throwable th) {
                                                throw th;
                                            }
                                        }
                                        break;
                                    } else {
                                        if (!(a03Var instanceof xz2)) {
                                            if (!(a03Var instanceof yz2)) {
                                                g.d();
                                                return null;
                                            }
                                            if (Build.ID != null && Log.isLoggable("Paging", 2)) {
                                                Log.v("Paging", f(hd2Var, obj2, a03Var), null);
                                            }
                                            this.i.g(null);
                                            hj3Var.a();
                                            return xl4Var;
                                        }
                                        if (Build.ID != null && Log.isLoggable("Paging", 2)) {
                                            Log.v("Paging", f(hd2Var, obj2, a03Var), null);
                                        }
                                        yn2Var = bz2Var3.a;
                                        uy2Var.A = a03Var;
                                        uy2Var.X = bz2Var3;
                                        uy2Var.Y = yn2Var;
                                        uy2Var.z0 = 8;
                                        if (yn2Var.g(uy2Var) != mf0Var) {
                                            a03Var2 = a03Var;
                                            try {
                                                dz2Var2 = bz2Var3.b;
                                                cd2Var = new cd2(((xz2) a03Var2).b);
                                                uy2Var.A = yn2Var;
                                                uy2Var.X = null;
                                                uy2Var.Y = null;
                                                uy2Var.z0 = 9;
                                                if (i(dz2Var2, hd2Var, cd2Var, uy2Var) != mf0Var) {
                                                    wn2Var2 = yn2Var;
                                                    return xl4Var;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                wn2Var2 = yn2Var;
                                                throw th;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return mf0Var;
                    case 1:
                        wn2Var = (wn2) uy2Var.X;
                        bz2Var = (bz2) uy2Var.A;
                        n12.S(objD);
                        dz2Var = bz2Var.b;
                        uy2Var.A = wn2Var;
                        uy2Var.X = null;
                        uy2Var.z0 = 2;
                        if (j(dz2Var, hd2Var, uy2Var) != mf0Var) {
                        }
                        return mf0Var;
                    case 2:
                        wn2Var = (wn2) uy2Var.A;
                        n12.S(objD);
                        wn2Var.n(null);
                        wz2 wz2VarE2 = e(hd2Var, obj2);
                        r3 = Build.ID;
                        if (r3 != 0) {
                            Log.d("Paging", "Start REFRESH with loadKey " + obj2 + " on " + hj3Var, null);
                        }
                        uy2Var.A = null;
                        uy2Var.z0 = 3;
                        objD = hj3Var.d.d(wz2VarE2, uy2Var);
                        if (objD != mf0Var) {
                        }
                        return mf0Var;
                    case 3:
                        n12.S(objD);
                        a03Var = (a03) objD;
                        if (!(a03Var instanceof zz2)) {
                        }
                        return mf0Var;
                    case 4:
                        yn2Var2 = uy2Var.Y;
                        bz2Var2 = (bz2) uy2Var.X;
                        a03Var3 = (a03) uy2Var.A;
                        n12.S(objD);
                        dz2 dz2Var32 = bz2Var2.b;
                        zB = dz2Var32.b(0, hd2Var, (zz2) a03Var3);
                        n02 n02Var2 = dz2Var32.j;
                        n02Var2.N(hd2Var, ed2.c);
                        obj = ((zz2) a03Var3).f;
                        ed2 ed2Var2 = ed2.b;
                        if (obj == null) {
                        }
                        if (((zz2) a03Var3).z == null) {
                        }
                        if (zB) {
                        }
                        break;
                    case 5:
                        yn2 yn2Var6 = uy2Var.Y;
                        bz2Var3 = (bz2) uy2Var.X;
                        a03Var4 = (a03) uy2Var.A;
                        n12.S(objD);
                        yn2Var3 = yn2Var6;
                        dz2 dz2Var42 = bz2Var3.b;
                        xp xpVar2 = this.g;
                        hy2 hy2VarC2 = dz2Var42.c((zz2) a03Var4, hd2Var);
                        uy2Var.A = a03Var4;
                        uy2Var.X = yn2Var3;
                        uy2Var.Y = null;
                        uy2Var.z0 = 6;
                        r3 = yn2Var3;
                        break;
                    case 6:
                        wn2 wn2Var3 = (wn2) uy2Var.X;
                        n12.S(objD);
                        r3 = wn2Var3;
                        return xl4Var;
                    case 7:
                        yn2 yn2Var7 = uy2Var.Y;
                        bz2 bz2Var4 = (bz2) uy2Var.X;
                        a03 a03Var5 = (a03) uy2Var.A;
                        n12.S(objD);
                        try {
                            bz2Var4.b.a((yr4) ((iv1) this.e.f).A);
                            yn2Var7.n(null);
                            zz2 zz2Var = (zz2) a03Var5;
                            zz2Var.f.getClass();
                            zz2Var.z.getClass();
                            return xl4Var;
                        } catch (Throwable th3) {
                            yn2Var7.n(null);
                            throw th3;
                        }
                    case 8:
                        yn2Var = uy2Var.Y;
                        bz2Var3 = (bz2) uy2Var.X;
                        a03Var2 = (a03) uy2Var.A;
                        n12.S(objD);
                        dz2Var2 = bz2Var3.b;
                        cd2Var = new cd2(((xz2) a03Var2).b);
                        uy2Var.A = yn2Var;
                        uy2Var.X = null;
                        uy2Var.Y = null;
                        uy2Var.z0 = 9;
                        if (i(dz2Var2, hd2Var, cd2Var, uy2Var) != mf0Var) {
                        }
                        return mf0Var;
                    case Xlog.COMPRESS_LEVEL9 /* 9 */:
                        wn2Var2 = (wn2) uy2Var.A;
                        try {
                            n12.S(objD);
                            return xl4Var;
                        } catch (Throwable th4) {
                            th = th4;
                            throw th;
                        }
                    default:
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                }
            } finally {
            }
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:248:0x03a0, code lost:
    
        r2 = r0;
        r19 = r8;
        r0 = r11;
        r8 = r20;
        r11 = r22;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0514 A[Catch: all -> 0x0523, TryCatch #2 {all -> 0x0523, blocks: (B:157:0x04ea, B:158:0x04f8, B:160:0x0514, B:162:0x051c, B:164:0x0520, B:168:0x0529, B:167:0x0527, B:169:0x052c), top: B:235:0x04ea }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0520 A[Catch: all -> 0x0523, TryCatch #2 {all -> 0x0523, blocks: (B:157:0x04ea, B:158:0x04f8, B:160:0x0514, B:162:0x051c, B:164:0x0520, B:168:0x0529, B:167:0x0527, B:169:0x052c), top: B:235:0x04ea }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0527 A[Catch: all -> 0x0523, TryCatch #2 {all -> 0x0523, blocks: (B:157:0x04ea, B:158:0x04f8, B:160:0x0514, B:162:0x051c, B:164:0x0520, B:168:0x0529, B:167:0x0527, B:169:0x052c), top: B:235:0x04ea }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x064a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0367 A[Catch: all -> 0x038d, TRY_LEAVE, TryCatch #4 {all -> 0x038d, blocks: (B:82:0x034f, B:84:0x0367), top: B:239:0x034f }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03a4  */
    /* JADX WARN: Type inference failed for: r0v0, types: [az2] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v64, types: [az2] */
    /* JADX WARN: Type inference failed for: r0v66 */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r11v10, types: [az2] */
    /* JADX WARN: Type inference failed for: r11v14, types: [az2] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [az2] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [hd2, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r14v37 */
    /* JADX WARN: Type inference failed for: r1v0, types: [hd2] */
    /* JADX WARN: Type inference failed for: r1v1, types: [wn2] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v56, types: [wn2] */
    /* JADX WARN: Type inference failed for: r1v67, types: [dz2] */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r1v74, types: [hd2, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v8, types: [hd2] */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r1v84 */
    /* JADX WARN: Type inference failed for: r1v85 */
    /* JADX WARN: Type inference failed for: r1v86 */
    /* JADX WARN: Type inference failed for: r1v87 */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r2v105 */
    /* JADX WARN: Type inference failed for: r2v106 */
    /* JADX WARN: Type inference failed for: r2v107 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v78, types: [hd2] */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81, types: [hd2, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94, types: [hd2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [as4] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v20, types: [hd2] */
    /* JADX WARN: Type inference failed for: r3v27, types: [dz2] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r5v49, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r8v10, types: [n02] */
    /* JADX WARN: Type inference failed for: r8v6, types: [as4] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(hd2 hd2Var, do1 do1Var, ge0 ge0Var) {
        vy2 vy2Var;
        zg3 zg3Var;
        do1 do1Var2;
        ?? r14;
        wn2 wn2Var;
        bz2 bz2Var;
        xl4 xl4Var;
        int iOrdinal;
        String str;
        wn2 wn2Var2;
        do1 do1Var3;
        bh3 bh3Var;
        bh3 bh3Var2;
        ?? r1;
        zg3 zg3Var2;
        bz2 bz2Var2;
        wn2 wn2Var3;
        qs3 qs3Var;
        Object objG;
        Object obj;
        zg3 zg3Var3;
        Object obj2;
        ?? r2;
        bh3 bh3Var3;
        ?? r12;
        bh3 bh3Var4;
        xg3 xg3Var;
        ?? r22;
        zg3 zg3Var4;
        do1 do1Var4;
        xg3 xg3Var2;
        wz2 wz2Var;
        ?? r13;
        bh3 bh3Var5;
        Object objD;
        a03 a03Var;
        xg3 xg3Var3;
        ?? r23;
        do1 do1Var5;
        bz2 bz2Var3;
        wz2 wz2Var2;
        wn2 wn2Var4;
        a03 a03Var2;
        ?? r11;
        bz2 bz2Var4;
        ?? r3;
        dz2 dz2Var;
        do1 do1Var6;
        hd2 hd2Var2;
        wn2 wn2Var5;
        bz2 bz2Var5;
        ?? r24;
        hj3 hj3Var;
        a03 a03Var3;
        a03 a03Var4;
        wn2 wn2Var6;
        do1 do1Var7;
        ?? r25;
        ?? r15;
        a03 a03Var5;
        wz2 wz2Var3;
        bz2 bz2Var6;
        Object obj3;
        ?? r112;
        ?? r0;
        qs3 qs3Var2;
        wn2 wn2Var7;
        ?? r32;
        wn2 wn2Var8;
        cd2 cd2Var;
        Object objG2;
        ?? r8;
        hy2 hy2VarC;
        ?? r02;
        Object obj4;
        Object obj5;
        Object obj6;
        boolean z;
        boolean z2;
        boolean z3;
        ?? r03 = this;
        ?? r16 = hd2Var;
        xp xpVar = r03.g;
        if (ge0Var instanceof vy2) {
            vy2Var = (vy2) ge0Var;
            int i = vy2Var.G0;
            if ((i & Integer.MIN_VALUE) != 0) {
                vy2Var.G0 = i - Integer.MIN_VALUE;
            } else {
                vy2Var = new vy2(r03, ge0Var);
            }
        }
        Object obj7 = vy2Var.E0;
        int i2 = vy2Var.G0;
        hd2 hd2Var3 = hd2.f;
        xl4 xl4Var2 = xl4.a;
        hj3 hj3Var2 = r03.b;
        bz2 bz2Var7 = r03.h;
        mf0 mf0Var = mf0.b;
        try {
            switch (i2) {
                case 0:
                    n12.S(obj7);
                    if (r16 == hd2.b) {
                        xe.k("Use doInitialLoad for LoadType == REFRESH");
                        return null;
                    }
                    zg3Var = new zg3();
                    yn2 yn2Var = bz2Var7.a;
                    vy2Var.A = r16;
                    do1Var2 = do1Var;
                    vy2Var.X = do1Var2;
                    vy2Var.Y = zg3Var;
                    vy2Var.Z = bz2Var7;
                    vy2Var.y0 = yn2Var;
                    vy2Var.G0 = 1;
                    if (yn2Var.g(vy2Var) != mf0Var) {
                        r14 = r16;
                        wn2Var = yn2Var;
                        bz2Var = bz2Var7;
                        try {
                            dz2 dz2Var2 = bz2Var.b;
                            ArrayList arrayList = dz2Var2.c;
                            xl4Var = xl4Var2;
                            iOrdinal = r14.ordinal();
                            if (iOrdinal != 0) {
                                throw new IllegalStateException("Use doInitialLoad for LoadType == REFRESH");
                            }
                            str = "Use doInitialLoad for LoadType == REFRESH";
                            if (iOrdinal == 1) {
                                int size = (dz2Var2.d + do1Var2.b.c) - 1;
                                if (size > arrayList.size() - 1) {
                                    zg3Var.b = ((size - (arrayList.size() - 1)) * 100) + zg3Var.b;
                                    size = arrayList.size() - 1;
                                }
                                if (size >= 0) {
                                    int i3 = 0;
                                    while (true) {
                                        zg3Var.b += ((zz2) arrayList.get(i3)).b.size();
                                        if (i3 != size) {
                                            i3++;
                                        }
                                    }
                                }
                            } else {
                                if (iOrdinal != 2) {
                                    throw new t80();
                                }
                                int i4 = dz2Var2.d + do1Var2.b.d + 1;
                                if (i4 < 0) {
                                    zg3Var.b = (100 * (-i4)) + zg3Var.b;
                                    i4 = 0;
                                }
                                int size2 = arrayList.size() - 1;
                                if (i4 <= size2) {
                                    while (true) {
                                        zg3Var.b += ((zz2) arrayList.get(i4)).b.size();
                                        if (i4 != size2) {
                                            i4++;
                                        }
                                    }
                                }
                            }
                            wn2Var.n(null);
                            bh3 bh3Var6 = new bh3();
                            yn2 yn2Var2 = bz2Var7.a;
                            vy2Var.A = r14;
                            vy2Var.X = do1Var2;
                            vy2Var.Y = zg3Var;
                            vy2Var.Z = bh3Var6;
                            vy2Var.y0 = bz2Var7;
                            vy2Var.z0 = yn2Var2;
                            vy2Var.A0 = bh3Var6;
                            vy2Var.G0 = 2;
                            if (yn2Var2.g(vy2Var) != mf0Var) {
                                wn2Var2 = yn2Var2;
                                do1Var3 = do1Var2;
                                bh3Var = bh3Var6;
                                bh3Var2 = bh3Var;
                                r1 = r14;
                                zg3Var2 = zg3Var;
                                bz2Var2 = bz2Var7;
                                try {
                                    dz2 dz2Var3 = bz2Var2.b;
                                    qs3Var = xpVar;
                                    objG = r03.g(dz2Var3, r1, do1Var3.a, do1Var3.b.a(r1) + zg3Var2.b);
                                    if (objG != null) {
                                        obj = null;
                                        zg3Var3 = zg3Var2;
                                        obj2 = null;
                                        r12 = r1;
                                        bh3Var4 = bh3Var2;
                                        wn2Var2.n(obj2);
                                        bh3Var.b = obj;
                                        xg3Var = new xg3();
                                        r22 = r12;
                                        obj5 = bh3Var4.b;
                                        if (obj5 != null) {
                                        }
                                        return xl4Var;
                                    }
                                    vy2Var.A = r1;
                                    vy2Var.X = do1Var3;
                                    vy2Var.Y = zg3Var2;
                                    vy2Var.Z = bh3Var2;
                                    vy2Var.y0 = wn2Var2;
                                    vy2Var.z0 = objG;
                                    vy2Var.A0 = bh3Var;
                                    vy2Var.G0 = 3;
                                    if (r03.j(dz2Var3, r1, vy2Var) != mf0Var) {
                                        bh3 bh3Var7 = bh3Var;
                                        r2 = r1;
                                        bh3Var3 = bh3Var7;
                                        wn2Var3 = wn2Var2;
                                        ?? r7 = r2;
                                        bh3Var = bh3Var3;
                                        r12 = r7;
                                        wn2Var2 = wn2Var3;
                                        obj = objG;
                                        obj2 = null;
                                        zg3Var3 = zg3Var2;
                                        bh3Var4 = bh3Var2;
                                        wn2Var2.n(obj2);
                                        bh3Var.b = obj;
                                        xg3Var = new xg3();
                                        r22 = r12;
                                        obj5 = bh3Var4.b;
                                        if (obj5 != null) {
                                            wz2 wz2VarE = r03.e(r22, obj5);
                                            if (Build.ID == null || !Log.isLoggable("Paging", 3)) {
                                                obj6 = null;
                                            } else {
                                                obj6 = null;
                                                Log.d("Paging", "Start " + r22 + " with loadKey " + bh3Var4.b + " on " + hj3Var2, null);
                                            }
                                            vy2Var.A = r22;
                                            vy2Var.X = do1Var3;
                                            vy2Var.Y = zg3Var3;
                                            vy2Var.Z = bh3Var4;
                                            vy2Var.y0 = xg3Var;
                                            vy2Var.z0 = wz2VarE;
                                            vy2Var.A0 = obj6;
                                            vy2Var.B0 = obj6;
                                            vy2Var.G0 = 4;
                                            objD = hj3Var2.d.d(wz2VarE, vy2Var);
                                            if (objD != mf0Var) {
                                                ?? r232 = r22;
                                                wz2Var = wz2VarE;
                                                r13 = r232;
                                                xg3 xg3Var4 = xg3Var;
                                                zg3Var4 = zg3Var3;
                                                xg3Var2 = xg3Var4;
                                                do1 do1Var8 = do1Var3;
                                                bh3Var5 = bh3Var4;
                                                do1Var4 = do1Var8;
                                                r02 = r03;
                                                a03Var = (a03) objD;
                                                if (a03Var instanceof zz2) {
                                                    int iOrdinal2 = r13.ordinal();
                                                    if (iOrdinal2 == 1) {
                                                        obj4 = ((zz2) a03Var).f;
                                                    } else {
                                                        if (iOrdinal2 != 2) {
                                                            xe.k(str);
                                                            return null;
                                                        }
                                                        obj4 = ((zz2) a03Var).z;
                                                    }
                                                    hj3Var2.getClass();
                                                    if (n12.c(obj4, bh3Var5.b)) {
                                                        g.g(q44.c0("The same value, " + bh3Var5.b + ", was passed as the " + (r13 == hd2Var3 ? "prevKey" : "nextKey") + " in two\n                            | sequential Pages loaded from a PagingSource. Re-using load keys in\n                            | PagingSource is often an error, and must be explicitly enabled by\n                            | overriding PagingSource.keyReuseSupported.\n                            "));
                                                        return null;
                                                    }
                                                    wn2Var4 = bz2Var7.a;
                                                    vy2Var.A = r13;
                                                    vy2Var.X = do1Var4;
                                                    vy2Var.Y = zg3Var4;
                                                    vy2Var.Z = bh3Var5;
                                                    vy2Var.y0 = xg3Var2;
                                                    vy2Var.z0 = wz2Var;
                                                    vy2Var.A0 = a03Var;
                                                    vy2Var.B0 = bz2Var7;
                                                    vy2Var.C0 = wn2Var4;
                                                    vy2Var.G0 = 5;
                                                    if (wn2Var4.g(vy2Var) != mf0Var) {
                                                        wz2Var2 = wz2Var;
                                                        r23 = r13;
                                                        do1Var5 = do1Var4;
                                                        xg3Var3 = xg3Var2;
                                                        bz2Var3 = bz2Var7;
                                                        try {
                                                            hj3Var = hj3Var2;
                                                            if (bz2Var3.b.b(do1Var5.a, r23, (zz2) a03Var)) {
                                                                if (Build.ID != null && Log.isLoggable("Paging", 3)) {
                                                                    Log.d("Paging", f(r23, bh3Var5.b, a03Var), z ? 1 : 0);
                                                                }
                                                                zz2 zz2Var = (zz2) a03Var;
                                                                zg3Var4.b = zz2Var.b.size() + zg3Var4.b;
                                                                hd2 hd2Var4 = hd2.z;
                                                                if ((r23 == hd2Var3 && zz2Var.f == null) || (r23 == hd2Var4 && zz2Var.z == null)) {
                                                                    xg3Var3.b = true;
                                                                }
                                                                if (py2.a[r23.ordinal()] != 2) {
                                                                    hd2Var4 = hd2Var3;
                                                                }
                                                                yn2 yn2Var3 = bz2Var7.a;
                                                                vy2Var.A = r23;
                                                                vy2Var.X = do1Var5;
                                                                vy2Var.Y = zg3Var4;
                                                                vy2Var.Z = bh3Var5;
                                                                vy2Var.y0 = xg3Var3;
                                                                vy2Var.z0 = wz2Var2;
                                                                vy2Var.A0 = a03Var;
                                                                vy2Var.B0 = hd2Var4;
                                                                vy2Var.C0 = bz2Var7;
                                                                vy2Var.D0 = yn2Var3;
                                                                vy2Var.G0 = 8;
                                                                if (yn2Var3.g(vy2Var) != mf0Var) {
                                                                    a03Var3 = a03Var;
                                                                    hd2Var2 = hd2Var4;
                                                                    wn2Var5 = yn2Var3;
                                                                    bz2Var5 = bz2Var7;
                                                                    r24 = r23;
                                                                    try {
                                                                        dz2 dz2Var4 = bz2Var5.b;
                                                                        as4 as4Var = do1Var5.b;
                                                                        hd2Var2.getClass();
                                                                        as4Var.getClass();
                                                                        do1 do1Var9 = do1Var5;
                                                                        r15 = dz2Var4;
                                                                        do1Var7 = do1Var9;
                                                                        a03Var4 = a03Var3;
                                                                        r25 = r24;
                                                                        bz2Var6 = bz2Var7;
                                                                        ?? r113 = this;
                                                                        objG2 = r113.g(r15, r25, do1Var7.a, do1Var7.b.a(r25) + zg3Var4.b);
                                                                        r8 = r15.j;
                                                                        bh3Var5.b = objG2;
                                                                        if (objG2 == null && !(r8.k(r25) instanceof cd2)) {
                                                                            r8.N(r25, !xg3Var3.b ? ed2.b : ed2.c);
                                                                        }
                                                                        hy2VarC = r15.c((zz2) a03Var4, r25);
                                                                        vy2Var.A = r25;
                                                                        vy2Var.X = do1Var7;
                                                                        vy2Var.Y = zg3Var4;
                                                                        vy2Var.Z = bh3Var5;
                                                                        vy2Var.y0 = xg3Var3;
                                                                        vy2Var.z0 = wz2Var2;
                                                                        vy2Var.A0 = a03Var4;
                                                                        vy2Var.B0 = wn2Var5;
                                                                        obj3 = null;
                                                                        vy2Var.C0 = null;
                                                                        vy2Var.D0 = null;
                                                                        vy2Var.G0 = 10;
                                                                        qs3Var2 = qs3Var;
                                                                        if (qs3Var2.a(vy2Var, hy2VarC) != mf0Var) {
                                                                            wn2Var7 = wn2Var5;
                                                                            zg3Var3 = zg3Var4;
                                                                            xg3Var = xg3Var3;
                                                                            bh3Var4 = bh3Var5;
                                                                            do1Var3 = do1Var7;
                                                                            r0 = r25;
                                                                            a03Var5 = a03Var4;
                                                                            wz2Var3 = wz2Var2;
                                                                            r112 = r113;
                                                                            wn2Var7.n(obj3);
                                                                            if (wz2Var3 instanceof uz2) {
                                                                                Object obj8 = ((zz2) a03Var5).f;
                                                                            }
                                                                            if (wz2Var3 instanceof tz2) {
                                                                                r22 = r0;
                                                                                qs3Var = qs3Var2;
                                                                                r03 = r112;
                                                                                hj3Var2 = hj3Var;
                                                                                bz2Var7 = bz2Var6;
                                                                            } else {
                                                                                Object obj9 = ((zz2) a03Var5).z;
                                                                                r22 = r0;
                                                                                qs3Var = qs3Var2;
                                                                                r03 = r112;
                                                                                hj3Var2 = hj3Var;
                                                                                bz2Var7 = bz2Var6;
                                                                            }
                                                                            obj5 = bh3Var4.b;
                                                                            if (obj5 != null) {
                                                                            }
                                                                        }
                                                                    } catch (Throwable th) {
                                                                        th = th;
                                                                        wn2Var6 = wn2Var5;
                                                                        wn2Var6.n(null);
                                                                        throw th;
                                                                    }
                                                                }
                                                            } else if (Build.ID != null && Log.isLoggable("Paging", 2)) {
                                                                Log.v("Paging", f(r23, bh3Var5.b, z2 ? 1 : 0), z3 ? 1 : 0);
                                                                return xl4Var;
                                                            }
                                                        } finally {
                                                            wn2Var4.n(null);
                                                        }
                                                    }
                                                } else {
                                                    hj3 hj3Var3 = hj3Var2;
                                                    bz2 bz2Var8 = bz2Var7;
                                                    ?? r114 = r02;
                                                    if (!(a03Var instanceof xz2)) {
                                                        if (!(a03Var instanceof yz2)) {
                                                            g.d();
                                                            return null;
                                                        }
                                                        if (Build.ID != null && Log.isLoggable("Paging", 2)) {
                                                            Log.v("Paging", f(r13, bh3Var5.b, a03Var), null);
                                                        }
                                                        r114.i.g(null);
                                                        hj3Var3.a();
                                                        return xl4Var;
                                                    }
                                                    if (Build.ID != null && Log.isLoggable("Paging", 2)) {
                                                        Log.v("Paging", f(r13, bh3Var5.b, a03Var), null);
                                                    }
                                                    bz2Var4 = bz2Var8;
                                                    yn2 yn2Var4 = bz2Var4.a;
                                                    vy2Var.A = r13;
                                                    vy2Var.X = do1Var4;
                                                    vy2Var.Y = a03Var;
                                                    vy2Var.Z = bz2Var4;
                                                    vy2Var.y0 = yn2Var4;
                                                    vy2Var.z0 = null;
                                                    vy2Var.G0 = 6;
                                                    if (yn2Var4.g(vy2Var) != mf0Var) {
                                                        r3 = r13;
                                                        wn2Var8 = yn2Var4;
                                                        a03Var2 = a03Var;
                                                        r11 = r114;
                                                        dz2Var = bz2Var4.b;
                                                        cd2Var = new cd2(((xz2) a03Var2).b);
                                                        vy2Var.A = r3;
                                                        vy2Var.X = do1Var4;
                                                        vy2Var.Y = wn2Var8;
                                                        vy2Var.Z = dz2Var;
                                                        vy2Var.y0 = null;
                                                        vy2Var.G0 = 7;
                                                        if (r11.i(dz2Var, r3, cd2Var, vy2Var) != mf0Var) {
                                                            do1Var6 = do1Var4;
                                                            r16 = wn2Var8;
                                                            r32 = r3;
                                                            dz2Var.i.put(r32, do1Var6.b);
                                                            return xl4Var;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        return xl4Var;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    wn2Var3 = wn2Var2;
                                    wn2Var3.n(null);
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            wn2Var.n(null);
                            throw th3;
                        }
                    }
                    return mf0Var;
                case 1:
                    wn2Var = (wn2) vy2Var.y0;
                    bz2Var = (bz2) vy2Var.Z;
                    zg3Var = (zg3) vy2Var.Y;
                    do1Var2 = vy2Var.X;
                    hd2 hd2Var5 = vy2Var.A;
                    n12.S(obj7);
                    r14 = hd2Var5;
                    dz2 dz2Var22 = bz2Var.b;
                    ArrayList arrayList2 = dz2Var22.c;
                    xl4Var = xl4Var2;
                    iOrdinal = r14.ordinal();
                    if (iOrdinal != 0) {
                    }
                    break;
                case 2:
                    bh3 bh3Var8 = (bh3) vy2Var.A0;
                    wn2 wn2Var9 = (wn2) vy2Var.z0;
                    bz2Var2 = (bz2) vy2Var.y0;
                    bh3Var2 = (bh3) vy2Var.Z;
                    zg3Var2 = (zg3) vy2Var.Y;
                    do1Var3 = vy2Var.X;
                    hd2 hd2Var6 = vy2Var.A;
                    n12.S(obj7);
                    xl4Var = xl4Var2;
                    str = "Use doInitialLoad for LoadType == REFRESH";
                    wn2Var2 = wn2Var9;
                    bh3Var = bh3Var8;
                    r1 = hd2Var6;
                    dz2 dz2Var32 = bz2Var2.b;
                    qs3Var = xpVar;
                    objG = r03.g(dz2Var32, r1, do1Var3.a, do1Var3.b.a(r1) + zg3Var2.b);
                    if (objG != null) {
                    }
                    break;
                case 3:
                    bh3 bh3Var9 = (bh3) vy2Var.A0;
                    Object obj10 = vy2Var.z0;
                    wn2Var3 = (wn2) vy2Var.y0;
                    bh3Var2 = (bh3) vy2Var.Z;
                    zg3Var2 = (zg3) vy2Var.Y;
                    do1Var3 = vy2Var.X;
                    hd2 hd2Var7 = vy2Var.A;
                    try {
                        n12.S(obj7);
                        qs3Var = xpVar;
                        xl4Var = xl4Var2;
                        str = "Use doInitialLoad for LoadType == REFRESH";
                        objG = obj10;
                        r2 = hd2Var7;
                        bh3Var3 = bh3Var9;
                        ?? r72 = r2;
                        bh3Var = bh3Var3;
                        r12 = r72;
                        wn2Var2 = wn2Var3;
                        obj = objG;
                        obj2 = null;
                        zg3Var3 = zg3Var2;
                        bh3Var4 = bh3Var2;
                        wn2Var2.n(obj2);
                        bh3Var.b = obj;
                        xg3Var = new xg3();
                        r22 = r12;
                        obj5 = bh3Var4.b;
                        if (obj5 != null) {
                        }
                        return xl4Var;
                    } catch (Throwable th4) {
                        th = th4;
                        wn2Var3.n(null);
                        throw th;
                    }
                case 4:
                    wz2 wz2Var4 = (wz2) vy2Var.z0;
                    xg3 xg3Var5 = (xg3) vy2Var.y0;
                    bh3 bh3Var10 = (bh3) vy2Var.Z;
                    zg3Var4 = (zg3) vy2Var.Y;
                    do1Var4 = vy2Var.X;
                    hd2 hd2Var8 = vy2Var.A;
                    n12.S(obj7);
                    qs3Var = xpVar;
                    str = "Use doInitialLoad for LoadType == REFRESH";
                    xg3Var2 = xg3Var5;
                    wz2Var = wz2Var4;
                    r13 = hd2Var8;
                    bh3Var5 = bh3Var10;
                    objD = obj7;
                    xl4Var = xl4Var2;
                    r02 = r03;
                    a03Var = (a03) objD;
                    if (a03Var instanceof zz2) {
                    }
                    return mf0Var;
                case 5:
                    wn2 wn2Var10 = (wn2) vy2Var.C0;
                    bz2 bz2Var9 = (bz2) vy2Var.B0;
                    a03Var = (a03) vy2Var.A0;
                    wz2 wz2Var5 = (wz2) vy2Var.z0;
                    xg3Var3 = (xg3) vy2Var.y0;
                    bh3Var5 = (bh3) vy2Var.Z;
                    zg3 zg3Var5 = (zg3) vy2Var.Y;
                    do1 do1Var10 = vy2Var.X;
                    hd2 hd2Var9 = vy2Var.A;
                    n12.S(obj7);
                    r23 = hd2Var9;
                    do1Var5 = do1Var10;
                    qs3Var = xpVar;
                    bz2Var3 = bz2Var9;
                    xl4Var = xl4Var2;
                    str = "Use doInitialLoad for LoadType == REFRESH";
                    wz2Var2 = wz2Var5;
                    wn2Var4 = wn2Var10;
                    zg3Var4 = zg3Var5;
                    hj3Var = hj3Var2;
                    if (bz2Var3.b.b(do1Var5.a, r23, (zz2) a03Var)) {
                    }
                    break;
                case 6:
                    wn2 wn2Var11 = (wn2) vy2Var.y0;
                    bz2 bz2Var10 = (bz2) vy2Var.Z;
                    a03Var2 = (a03) vy2Var.Y;
                    do1 do1Var11 = vy2Var.X;
                    hd2 hd2Var10 = vy2Var.A;
                    n12.S(obj7);
                    r11 = r03;
                    bz2Var4 = bz2Var10;
                    do1Var4 = do1Var11;
                    r3 = hd2Var10;
                    xl4Var = xl4Var2;
                    wn2Var8 = wn2Var11;
                    dz2Var = bz2Var4.b;
                    cd2Var = new cd2(((xz2) a03Var2).b);
                    vy2Var.A = r3;
                    vy2Var.X = do1Var4;
                    vy2Var.Y = wn2Var8;
                    vy2Var.Z = dz2Var;
                    vy2Var.y0 = null;
                    vy2Var.G0 = 7;
                    if (r11.i(dz2Var, r3, cd2Var, vy2Var) != mf0Var) {
                    }
                    return mf0Var;
                case 7:
                    dz2Var = (dz2) vy2Var.Z;
                    wn2 wn2Var12 = (wn2) vy2Var.Y;
                    do1Var6 = vy2Var.X;
                    hd2 hd2Var11 = vy2Var.A;
                    n12.S(obj7);
                    xl4Var = xl4Var2;
                    r16 = wn2Var12;
                    r32 = hd2Var11;
                    dz2Var.i.put(r32, do1Var6.b);
                    return xl4Var;
                case 8:
                    yn2 yn2Var5 = vy2Var.D0;
                    bz2 bz2Var11 = (bz2) vy2Var.C0;
                    hd2Var2 = (hd2) vy2Var.B0;
                    a03 a03Var6 = (a03) vy2Var.A0;
                    wz2 wz2Var6 = (wz2) vy2Var.z0;
                    xg3 xg3Var6 = (xg3) vy2Var.y0;
                    bh3 bh3Var11 = (bh3) vy2Var.Z;
                    zg3 zg3Var6 = (zg3) vy2Var.Y;
                    do1 do1Var12 = vy2Var.X;
                    hd2 hd2Var12 = vy2Var.A;
                    n12.S(obj7);
                    qs3Var = xpVar;
                    wn2Var5 = yn2Var5;
                    bz2Var5 = bz2Var11;
                    xl4Var = xl4Var2;
                    str = "Use doInitialLoad for LoadType == REFRESH";
                    wz2Var2 = wz2Var6;
                    xg3Var3 = xg3Var6;
                    bh3Var5 = bh3Var11;
                    r24 = hd2Var12;
                    do1Var5 = do1Var12;
                    hj3Var = hj3Var2;
                    a03Var3 = a03Var6;
                    zg3Var4 = zg3Var6;
                    dz2 dz2Var42 = bz2Var5.b;
                    as4 as4Var2 = do1Var5.b;
                    hd2Var2.getClass();
                    as4Var2.getClass();
                    do1 do1Var92 = do1Var5;
                    r15 = dz2Var42;
                    do1Var7 = do1Var92;
                    a03Var4 = a03Var3;
                    r25 = r24;
                    bz2Var6 = bz2Var7;
                    ?? r1132 = this;
                    objG2 = r1132.g(r15, r25, do1Var7.a, do1Var7.b.a(r25) + zg3Var4.b);
                    r8 = r15.j;
                    bh3Var5.b = objG2;
                    if (objG2 == null) {
                        r8.N(r25, !xg3Var3.b ? ed2.b : ed2.c);
                    }
                    hy2VarC = r15.c((zz2) a03Var4, r25);
                    vy2Var.A = r25;
                    vy2Var.X = do1Var7;
                    vy2Var.Y = zg3Var4;
                    vy2Var.Z = bh3Var5;
                    vy2Var.y0 = xg3Var3;
                    vy2Var.z0 = wz2Var2;
                    vy2Var.A0 = a03Var4;
                    vy2Var.B0 = wn2Var5;
                    obj3 = null;
                    vy2Var.C0 = null;
                    vy2Var.D0 = null;
                    vy2Var.G0 = 10;
                    qs3Var2 = qs3Var;
                    if (qs3Var2.a(vy2Var, hy2VarC) != mf0Var) {
                    }
                    return mf0Var;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    dz2 dz2Var5 = (dz2) vy2Var.C0;
                    wn2 wn2Var13 = (wn2) vy2Var.B0;
                    a03Var4 = (a03) vy2Var.A0;
                    wz2 wz2Var7 = (wz2) vy2Var.z0;
                    xg3Var3 = (xg3) vy2Var.y0;
                    bh3Var5 = (bh3) vy2Var.Z;
                    zg3 zg3Var7 = (zg3) vy2Var.Y;
                    do1 do1Var13 = vy2Var.X;
                    hd2 hd2Var13 = vy2Var.A;
                    try {
                        n12.S(obj7);
                        xl4Var = xl4Var2;
                        hj3Var = hj3Var2;
                        str = "Use doInitialLoad for LoadType == REFRESH";
                        wz2Var2 = wz2Var7;
                        do1Var7 = do1Var13;
                        zg3Var4 = zg3Var7;
                        qs3Var = xpVar;
                        wn2Var5 = wn2Var13;
                        r25 = hd2Var13;
                        r15 = dz2Var5;
                        bz2Var6 = bz2Var7;
                        ?? r11322 = this;
                        objG2 = r11322.g(r15, r25, do1Var7.a, do1Var7.b.a(r25) + zg3Var4.b);
                        r8 = r15.j;
                        bh3Var5.b = objG2;
                        if (objG2 == null) {
                        }
                        hy2VarC = r15.c((zz2) a03Var4, r25);
                        vy2Var.A = r25;
                        vy2Var.X = do1Var7;
                        vy2Var.Y = zg3Var4;
                        vy2Var.Z = bh3Var5;
                        vy2Var.y0 = xg3Var3;
                        vy2Var.z0 = wz2Var2;
                        vy2Var.A0 = a03Var4;
                        vy2Var.B0 = wn2Var5;
                        obj3 = null;
                        vy2Var.C0 = null;
                        vy2Var.D0 = null;
                        vy2Var.G0 = 10;
                        qs3Var2 = qs3Var;
                        if (qs3Var2.a(vy2Var, hy2VarC) != mf0Var) {
                        }
                        return mf0Var;
                    } catch (Throwable th5) {
                        th = th5;
                        wn2Var6 = wn2Var13;
                        wn2Var6.n(null);
                        throw th;
                    }
                case 10:
                    wn2 wn2Var14 = (wn2) vy2Var.B0;
                    a03Var5 = (a03) vy2Var.A0;
                    wz2Var3 = (wz2) vy2Var.z0;
                    xg3Var = (xg3) vy2Var.y0;
                    bh3Var4 = (bh3) vy2Var.Z;
                    zg3 zg3Var8 = (zg3) vy2Var.Y;
                    do1 do1Var14 = vy2Var.X;
                    hd2 hd2Var14 = vy2Var.A;
                    try {
                        n12.S(obj7);
                        xl4Var = xl4Var2;
                        hj3Var = hj3Var2;
                        str = "Use doInitialLoad for LoadType == REFRESH";
                        bz2Var6 = bz2Var7;
                        obj3 = null;
                        r112 = r03;
                        r0 = hd2Var14;
                        qs3Var2 = xpVar;
                        zg3Var3 = zg3Var8;
                        wn2Var7 = wn2Var14;
                        do1Var3 = do1Var14;
                        wn2Var7.n(obj3);
                        if (wz2Var3 instanceof uz2) {
                        }
                        if (wz2Var3 instanceof tz2) {
                        }
                        obj5 = bh3Var4.b;
                        if (obj5 != null) {
                        }
                        return xl4Var;
                    } catch (Throwable th6) {
                        th = th6;
                        wn2Var6 = wn2Var14;
                        wn2Var6.n(null);
                        throw th;
                    }
                case 11:
                    wn2 wn2Var15 = (wn2) vy2Var.A0;
                    bz2 bz2Var12 = (bz2) vy2Var.z0;
                    xg3Var = (xg3) vy2Var.y0;
                    bh3Var4 = (bh3) vy2Var.Z;
                    zg3 zg3Var9 = (zg3) vy2Var.Y;
                    do1 do1Var15 = vy2Var.X;
                    hd2 hd2Var15 = vy2Var.A;
                    n12.S(obj7);
                    try {
                        bz2Var12.b.a((yr4) ((iv1) r03.e.f).A);
                        wn2Var15.n(null);
                        r22 = hd2Var15;
                        qs3Var = xpVar;
                        xl4Var = xl4Var2;
                        str = "Use doInitialLoad for LoadType == REFRESH";
                        zg3Var3 = zg3Var9;
                        do1Var3 = do1Var15;
                        obj5 = bh3Var4.b;
                        if (obj5 != null) {
                        }
                        return xl4Var;
                    } catch (Throwable th7) {
                        wn2Var15.n(null);
                        throw th7;
                    }
                default:
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        } catch (Throwable th8) {
            r16.n(null);
            throw th8;
        }
    }

    public final wz2 e(hd2 hd2Var, Object obj) {
        int i = hd2Var == hd2.b ? this.c.b : 100;
        hd2Var.getClass();
        int iOrdinal = hd2Var.ordinal();
        if (iOrdinal == 0) {
            return new vz2(i, obj);
        }
        if (iOrdinal == 1) {
            if (obj != null) {
                return new uz2(i, obj);
            }
            xe.k("key cannot be null for prepend");
            return null;
        }
        if (iOrdinal != 2) {
            g.d();
            return null;
        }
        if (obj != null) {
            return new tz2(i, obj);
        }
        xe.k("key cannot be null for append");
        return null;
    }

    public final Object g(dz2 dz2Var, hd2 hd2Var, int i, int i2) {
        dz2Var.getClass();
        int iOrdinal = hd2Var.ordinal();
        if (iOrdinal == 0) {
            xe.k("Cannot get loadId for loadType: REFRESH");
            return null;
        }
        if (iOrdinal != 1 && iOrdinal != 2) {
            g.d();
            return null;
        }
        if (i != 0 || (dz2Var.j.k(hd2Var) instanceof cd2) || i2 >= 100) {
            return null;
        }
        ArrayList arrayList = dz2Var.c;
        return hd2Var == hd2.f ? ((zz2) d70.d0(arrayList)).f : ((zz2) d70.k0(arrayList)).z;
    }

    public final Object h(hd2 hd2Var, as4 as4Var, yy2 yy2Var) throws Throwable {
        if (py2.a[hd2Var.ordinal()] == 1) {
            Object objC = c(yy2Var);
            return objC == mf0.b ? objC : xl4.a;
        }
        if (as4Var == null) {
            xe.q("Cannot retry APPEND / PREPEND load on PagingSource without ViewportHint");
            return null;
        }
        wn1 wn1Var = this.e;
        wn1Var.getClass();
        hd2 hd2Var2 = hd2.f;
        if (hd2Var != hd2Var2 && hd2Var != hd2.z) {
            st4.o(hd2Var, "invalid load type for reset: ");
            return null;
        }
        iv1 iv1Var = (iv1) wn1Var.f;
        iv1Var.getClass();
        synchronized (((o84) iv1Var.X)) {
            try {
                eg0 eg0Var = (eg0) iv1Var.f;
                eg0 eg0Var2 = (eg0) iv1Var.z;
                if (hd2Var == hd2Var2) {
                    eg0Var.T(as4Var);
                } else {
                    eg0Var2.T(as4Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xl4.a;
    }

    public final Object i(dz2 dz2Var, hd2 hd2Var, cd2 cd2Var, ie0 ie0Var) {
        n02 n02Var = dz2Var.j;
        if (!n02Var.k(hd2Var).equals(cd2Var)) {
            n02Var.N(hd2Var, cd2Var);
            Object objA = this.g.a(ie0Var, new iy2(n02Var.O(), null));
            if (objA == mf0.b) {
                return objA;
            }
        }
        return xl4.a;
    }

    public final Object j(dz2 dz2Var, hd2 hd2Var, ie0 ie0Var) {
        n02 n02Var = dz2Var.j;
        fd2 fd2VarK = n02Var.k(hd2Var);
        dd2 dd2Var = dd2.b;
        if (!fd2VarK.equals(dd2Var)) {
            n02Var.N(hd2Var, dd2Var);
            Object objA = this.g.a(ie0Var, new iy2(n02Var.O(), null));
            if (objA == mf0.b) {
                return objA;
            }
        }
        return xl4.a;
    }

    public final void k(lf0 lf0Var) {
        ge0 ge0Var = null;
        ji0.B(lf0Var, null, null, new zy2(this, ge0Var, 0), 3);
        ji0.B(lf0Var, null, null, new zy2(this, ge0Var, 1), 3);
    }
}
