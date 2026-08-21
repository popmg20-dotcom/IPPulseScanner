package defpackage;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.getsurfboard.ui.activity.DeeplinkActivity;
import com.getsurfboard.ui.fragment.MemoryUsageFragment;
import com.getsurfboard.ui.fragment.ProfileAddMethodsFragment;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function2;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hj extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public /* synthetic */ Object Z;
    public final /* synthetic */ Object y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hj(Object obj, Object obj2, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = obj;
        this.y0 = obj2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        if (r0.a(r1, r10) == r2) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        if (r0.a(r1, r10) != r2) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object r(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.Z
            zf1 r0 = (defpackage.zf1) r0
            java.lang.Object r1 = r10.y0
            hv3 r1 = (defpackage.hv3) r1
            mf0 r2 = defpackage.mf0.b
            int r3 = r10.Y
            r4 = 0
            r5 = 3
            r6 = 1
            r7 = 2
            if (r3 == 0) goto L29
            if (r3 == r6) goto L1b
            if (r3 == r7) goto L25
            if (r3 == r5) goto L1b
            r10 = 4
            if (r3 != r10) goto L1f
        L1b:
            defpackage.n12.S(r11)
            goto L70
        L1f:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r10)
            return r4
        L25:
            defpackage.n12.S(r11)
            goto L67
        L29:
            defpackage.n12.S(r11)
            wl3 r11 = defpackage.vv3.b
            vd3 r3 = defpackage.vv3.a
            if (r11 != r3) goto L3b
            r10.Y = r6
            java.lang.Object r10 = r0.a(r1, r10)
            if (r10 != r2) goto L70
            goto L6f
        L3b:
            monitor-enter(r1)
            h54 r11 = r1.A     // Catch: java.lang.Throwable -> L56
            if (r11 != 0) goto L58
            h54 r11 = new h54     // Catch: java.lang.Throwable -> L56
            int r3 = r1.f     // Catch: java.lang.Throwable -> L56
            jp r8 = defpackage.jp.f     // Catch: java.lang.Throwable -> L56
            r9 = 2147483647(0x7fffffff, float:NaN)
            r11.<init>(r6, r9, r8)     // Catch: java.lang.Throwable -> L56
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L56
            r11.p(r3)     // Catch: java.lang.Throwable -> L56
            r1.A = r11     // Catch: java.lang.Throwable -> L56
            goto L58
        L56:
            r10 = move-exception
            goto L73
        L58:
            monitor-exit(r1)
            od r3 = new od
            r3.<init>(r7, r4, r7)
            r10.Y = r7
            java.lang.Object r11 = defpackage.ye.p(r11, r3, r10)
            if (r11 != r2) goto L67
            goto L6f
        L67:
            r10.Y = r5
            java.lang.Object r10 = r0.a(r1, r10)
            if (r10 != r2) goto L70
        L6f:
            return r2
        L70:
            xl4 r10 = defpackage.xl4.a
            return r10
        L73:
            monitor-exit(r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hj.r(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object s(java.lang.Object r10) {
        /*
            r9 = this;
            int r0 = r9.Y
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L12
            if (r0 != r2) goto Lc
            defpackage.n12.S(r10)
            goto L71
        Lc:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r9)
            return r1
        L12:
            defpackage.n12.S(r10)
            java.lang.Object r10 = r9.Z
            tf2 r10 = (defpackage.tf2) r10
            java.lang.Object r0 = r9.y0
            android.net.Uri r0 = (android.net.Uri) r0
            r92 r3 = r10.getLifecycle()
            gm0 r4 = defpackage.qv0.a
            tq1 r4 = defpackage.qf2.a
            tq1 r6 = r4.X
            cf0 r4 = r9.f
            r4.getClass()
            boolean r5 = r6.q0(r4)
            q92 r4 = defpackage.q92.X
            if (r5 != 0) goto L5f
            q92 r7 = r3.b()
            q92 r8 = defpackage.q92.b
            if (r7 == r8) goto L5b
            q92 r1 = r3.b()
            int r1 = r1.compareTo(r4)
            if (r1 < 0) goto L5f
            r9 = 2131362284(0x7f0a01ec, float:1.8344344E38)
            r10.l(r9)
            d83 r9 = r10.A
            if (r9 == 0) goto L71
            java.lang.String r10 = r0.toString()
            r10.getClass()
            defpackage.d83.l(r9, r10)
            goto L71
        L5b:
            defpackage.vp1.m()
            return r1
        L5f:
            kt r7 = new kt
            r1 = 4
            r7.<init>(r1, r10, r0)
            r9.Y = r2
            r8 = r9
            java.lang.Object r9 = defpackage.ji0.V(r3, r4, r5, r6, r7, r8)
            mf0 r10 = defpackage.mf0.b
            if (r9 != r10) goto L71
            return r10
        L71:
            xl4 r9 = defpackage.xl4.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hj.s(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object t(java.lang.Object r10) {
        /*
            r9 = this;
            int r0 = r9.Y
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L12
            if (r0 != r2) goto Lc
            defpackage.n12.S(r10)
            goto L6a
        Lc:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r9)
            return r1
        L12:
            defpackage.n12.S(r10)
            java.lang.Object r10 = r9.Z
            tf2 r10 = (defpackage.tf2) r10
            java.lang.Object r0 = r9.y0
            java.lang.String r0 = (java.lang.String) r0
            r92 r3 = r10.getLifecycle()
            gm0 r4 = defpackage.qv0.a
            tq1 r4 = defpackage.qf2.a
            tq1 r6 = r4.X
            cf0 r4 = r9.f
            r4.getClass()
            boolean r5 = r6.q0(r4)
            q92 r4 = defpackage.q92.X
            if (r5 != 0) goto L58
            q92 r7 = r3.b()
            q92 r8 = defpackage.q92.b
            if (r7 == r8) goto L54
            q92 r1 = r3.b()
            int r1 = r1.compareTo(r4)
            if (r1 < 0) goto L58
            r9 = 2131362284(0x7f0a01ec, float:1.8344344E38)
            r10.l(r9)
            d83 r9 = r10.A
            if (r9 == 0) goto L6a
            defpackage.d83.l(r9, r0)
            goto L6a
        L54:
            defpackage.vp1.m()
            return r1
        L58:
            kt r7 = new kt
            r1 = 5
            r7.<init>(r1, r10, r0)
            r9.Y = r2
            r8 = r9
            java.lang.Object r9 = defpackage.ji0.V(r3, r4, r5, r6, r7, r8)
            mf0 r10 = defpackage.mf0.b
            if (r9 != r10) goto L6a
            return r10
        L6a:
            xl4 r9 = defpackage.xl4.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hj.t(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e6, code lost:
    
        if (defpackage.ji0.V(r8, r9, r10, r11, r12, r14) == r7) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object u(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hj.u(java.lang.Object):java.lang.Object");
    }

    private final Object v(Object obj) {
        oy2 oy2Var = (oy2) this.y0;
        int i = this.Y;
        int i2 = 1;
        ge0 ge0Var = null;
        if (i == 0) {
            n12.S(obj);
            hx3 hx3Var = (hx3) this.Z;
            int i3 = 2;
            pg1 pg1Var = new pg1(new mt(i3, ge0Var), (av) oy2Var.c.z);
            bv bvVar = new bv(oy2Var, ge0Var, i3);
            int i4 = 6;
            zf1 zf1VarU = ez4.U(new fg1(new av(i4, new av(7, new hd(pg1Var, bvVar, ge0Var, i4))), new bv(ge0Var, oy2Var, 3), ge0Var, i2));
            my2 my2Var = new my2(hx3Var);
            this.Y = 1;
            Object objA = zf1VarU.a(my2Var, this);
            mf0 mf0Var = mf0.b;
            if (objA == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n12.S(obj);
        }
        return xl4.a;
    }

    private final Object w(Object obj) {
        int i = this.Y;
        if (i == 0) {
            n12.S(obj);
            z20 z20VarN = ez4.n(((az2) this.Z).g);
            xu xuVar = new xu(8, (hx3) this.y0);
            this.Y = 1;
            Object objA = z20VarN.a(xuVar, this);
            mf0 mf0Var = mf0.b;
            if (objA == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n12.S(obj);
        }
        return xl4.a;
    }

    private final Object x(Object obj) {
        int i = this.Y;
        if (i != 0) {
            if (i == 1) {
                n12.S(obj);
                return xl4.a;
            }
            xe.q("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        n12.S(obj);
        av avVar = ((az2) this.Z).d;
        xu xuVar = new xu(9, (xp) this.y0);
        this.Y = 1;
        avVar.a(xuVar, this);
        return mf0.b;
    }

    private final Object y(Object obj) {
        int i = this.Y;
        if (i != 0) {
            if (i != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            rn2 rn2Var = (rn2) this.Z;
            n12.S(obj);
            return rn2Var;
        }
        n12.S(obj);
        rn2 rn2Var2 = new rn2(new LinkedHashMap(((rn2) this.Z).a()), false);
        ah0 ah0Var = (ah0) this.y0;
        this.Z = rn2Var2;
        this.Y = 1;
        ah0Var.k(rn2Var2, this);
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        return xl4Var == mf0Var ? mf0Var : rn2Var2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) throws Throwable {
        int i = this.X;
        mf0 mf0Var = mf0.b;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 1:
                ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return mf0Var;
            case 2:
                return ((hj) n((ge0) obj2, (q53) obj)).p(xl4Var);
            case 3:
                return ((hj) n((ge0) obj2, (ag1) obj)).p(xl4Var);
            case 4:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 5:
                return ((hj) n((ge0) obj2, (q53) obj)).p(xl4Var);
            case 6:
                return ((hj) n((ge0) obj2, (ag1) obj)).p(xl4Var);
            case 7:
                return ((hj) n((ge0) obj2, (t13) obj)).p(xl4Var);
            case 8:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 10:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 11:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return ((hj) n((ge0) obj2, (kl2) obj)).p(xl4Var);
            case 13:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 14:
                return ((hj) n((ge0) obj2, (q53) obj)).p(xl4Var);
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 16:
                ((hj) n((ge0) obj2, (q53) obj)).p(xl4Var);
                return mf0Var;
            case 17:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 18:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 19:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 20:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 21:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 22:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 23:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 24:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 25:
                return ((hj) n((ge0) obj2, (hx3) obj)).p(xl4Var);
            case 26:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 27:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 28:
                return ((hj) n((ge0) obj2, (rn2) obj)).p(xl4Var);
            default:
                return ((hj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.y0;
        switch (i) {
            case 0:
                return new hj((jj) this.Z, (Uri) obj2, ge0Var, 0);
            case 1:
                return new hj((ek) this.Z, (View) obj2, ge0Var, 1);
            case 2:
                hj hjVar = new hj((hk) obj2, ge0Var, 2);
                hjVar.Z = obj;
                return hjVar;
            case 3:
                hj hjVar2 = new hj((v92) obj2, ge0Var, 3);
                hjVar2.Z = obj;
                return hjVar2;
            case 4:
                return new hj((zf1) this.Z, (v92) obj2, ge0Var, 4);
            case 5:
                hj hjVar3 = new hj((b30) obj2, ge0Var, 5);
                hjVar3.Z = obj;
                return hjVar3;
            case 6:
                hj hjVar4 = new hj((c30) obj2, ge0Var, 6);
                hjVar4.Z = obj;
                return hjVar4;
            case 7:
                return new hj((j80) this.Z, (wz2) obj2, ge0Var, 7);
            case 8:
                return new hj((Function2) this.Z, (z13) obj2, ge0Var, 8);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new hj((Function2) this.Z, (bh3) obj2, ge0Var, 9);
            case 10:
                return new hj((xh0) this.Z, (Context) obj2, ge0Var, 10);
            case 11:
                return new hj((Function2) this.Z, (fi0) obj2, ge0Var, 11);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                hj hjVar5 = new hj((lj0) obj2, ge0Var, 12);
                hjVar5.Z = obj;
                return hjVar5;
            case 13:
                return new hj((DeeplinkActivity) this.Z, (DeeplinkActivity) obj2, ge0Var, 13);
            case 14:
                hj hjVar6 = new hj((m24) obj2, ge0Var, 14);
                hjVar6.Z = obj;
                return hjVar6;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return new hj((zf1) this.Z, (hv3) obj2, ge0Var, 15);
            case 16:
                hj hjVar7 = new hj((on2) obj2, ge0Var, 16);
                hjVar7.Z = obj;
                return hjVar7;
            case 17:
                return new hj((vh1) this.Z, (Activity) obj2, ge0Var, 17);
            case 18:
                return new hj((ed4) this.Z, (Uri) obj2, ge0Var, 18);
            case 19:
                return new hj((b32) this.Z, (am1) obj2, ge0Var, 19);
            case 20:
                return new hj((tf2) this.Z, (Uri) obj2, ge0Var, 20);
            case 21:
                return new hj((tf2) this.Z, (String) obj2, ge0Var, 21);
            case 22:
                return new hj((nj2) this.Z, (Uri) obj2, ge0Var, 22);
            case 23:
                return new hj((MemoryUsageFragment) this.Z, (View) obj2, ge0Var, 23);
            case 24:
                return new hj((ir2) this.Z, (q53) obj2, ge0Var, 24);
            case 25:
                hj hjVar8 = new hj((oy2) obj2, ge0Var, 25);
                hjVar8.Z = obj;
                return hjVar8;
            case 26:
                return new hj((az2) this.Z, (hx3) obj2, ge0Var, 26);
            case 27:
                return new hj((az2) this.Z, (xp) obj2, ge0Var, 27);
            case 28:
                hj hjVar9 = new hj((ah0) obj2, ge0Var, 28);
                hjVar9.Z = obj;
                return hjVar9;
            default:
                return new hj((ProfileAddMethodsFragment) this.Z, (String) obj2, ge0Var, 29);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x05e2  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v42 */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hj.p(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hj(Object obj, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.y0 = obj;
    }
}
