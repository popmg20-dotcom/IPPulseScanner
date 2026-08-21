package defpackage;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(defpackage.ie0 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof defpackage.ty2
            if (r0 == 0) goto L13
            r0 = r5
            ty2 r0 = (defpackage.ty2) r0
            int r1 = r0.y0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.y0 = r1
            goto L18
        L13:
            ty2 r0 = new ty2
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.Y
            int r1 = r0.y0
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L30
            if (r1 != r2) goto L2a
            yn2 r1 = r0.X
            bz2 r0 = r0.A
            defpackage.n12.S(r5)
            goto L47
        L2a:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r4)
            return r3
        L30:
            defpackage.n12.S(r5)
            bz2 r5 = r4.h
            yn2 r1 = r5.a
            r0.A = r5
            r0.X = r1
            r0.y0 = r2
            java.lang.Object r0 = r1.g(r0)
            mf0 r2 = defpackage.mf0.b
            if (r0 != r2) goto L46
            return r2
        L46:
            r0 = r5
        L47:
            dz2 r5 = r0.b     // Catch: java.lang.Throwable -> L5b
            wn1 r4 = r4.e     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r4 = r4.f     // Catch: java.lang.Throwable -> L5b
            iv1 r4 = (defpackage.iv1) r4     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r4 = r4.A     // Catch: java.lang.Throwable -> L5b
            yr4 r4 = (defpackage.yr4) r4     // Catch: java.lang.Throwable -> L5b
            b03 r4 = r5.a(r4)     // Catch: java.lang.Throwable -> L5b
            r1.n(r3)
            return r4
        L5b:
            r4 = move-exception
            r1.n(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.az2.b(ie0):java.lang.Object");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(defpackage.ie0 r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.az2.c(ie0):java.lang.Object");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(defpackage.hd2 r25, defpackage.do1 r26, defpackage.ge0 r27) {
        /*
            Method dump skipped, instruction units count: 1658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.az2.d(hd2, do1, ge0):java.lang.Object");
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
