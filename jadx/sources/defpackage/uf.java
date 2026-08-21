package defpackage;

import android.app.Activity;
import android.net.Uri;
import android.view.InputEvent;
import android.widget.TextView;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.NATDetectActivity;
import com.getsurfboard.ui.fragment.settings.TwoPanePreferenceFragment;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function2;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uf extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public Object Z;
    public Object y0;
    public final /* synthetic */ Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uf(b84 b84Var, String str, int i, String[] strArr, ge0 ge0Var) {
        super(2, ge0Var);
        this.X = 26;
        this.Z = b84Var;
        this.y0 = str;
        this.Y = i;
        this.z0 = strArr;
    }

    private final Object r(Object obj) {
        o80 o80Var;
        int i = this.Y;
        if (i == 0) {
            n12.S(obj);
            lf0 lf0Var = (lf0) this.Z;
            o80 o80Var2 = (o80) this.y0;
            Function2 function2 = (Function2) this.z0;
            try {
                this.Z = o80Var2;
                this.Y = 1;
                obj = function2.k(lf0Var, this);
                mf0 mf0Var = mf0.b;
                if (obj == mf0Var) {
                    return mf0Var;
                }
                o80Var = o80Var2;
            } catch (Throwable th) {
                th = th;
                o80Var = o80Var2;
                obj = new tk3(th);
            }
        } else {
            if (i != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            o80Var = (o80) this.Z;
            try {
                n12.S(obj);
            } catch (Throwable th2) {
                th = th2;
                obj = new tk3(th);
            }
        }
        Throwable thA = uk3.a(obj);
        if (thA == null) {
            o80Var.S(obj);
        } else {
            o80Var.getClass();
            o80Var.S(new r80(thA, false));
        }
        return xl4.a;
    }

    private final Object s(Object obj) {
        int i = this.Y;
        if (i == 0) {
            n12.S(obj);
            hx3 hx3Var = new hx3((lf0) this.Z, (xp) this.y0);
            Function2 function2 = (Function2) this.z0;
            this.Y = 1;
            Object objK = function2.k(hx3Var, this);
            mf0 mf0Var = mf0.b;
            if (objK == mf0Var) {
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

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
    
        if (r9 != r7) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [n02] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [v32] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v6, types: [v32] */
    /* JADX WARN: Type inference failed for: r9v0, types: [ie0, java.lang.Object, uf] */
    /* JADX WARN: Type inference failed for: r9v1, types: [ie0, uf] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object t(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = r9.y0
            oj1 r0 = (defpackage.oj1) r0
            java.lang.Object r0 = r0.f
            n02 r0 = (defpackage.n02) r0
            int r1 = r9.Y
            r2 = 0
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            mf0 r7 = defpackage.mf0.b
            if (r1 == 0) goto L41
            if (r1 == r6) goto L39
            if (r1 == r5) goto L2f
            if (r1 == r4) goto L2a
            if (r1 == r3) goto L21
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r9)
            return r2
        L21:
            java.lang.Object r9 = r9.Z
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            defpackage.n12.S(r10)
            goto L92
        L2a:
            defpackage.n12.S(r10)
            goto L93
        L2f:
            java.lang.Object r1 = r9.Z
            v32 r1 = (defpackage.v32) r1
            defpackage.n12.S(r10)     // Catch: java.lang.Throwable -> L37
            goto L7b
        L37:
            r10 = move-exception
            goto L86
        L39:
            java.lang.Object r1 = r9.Z
            v32 r1 = (defpackage.v32) r1
            defpackage.n12.S(r10)
            goto L64
        L41:
            defpackage.n12.S(r10)
            java.lang.Object r10 = r9.Z
            lf0 r10 = (defpackage.lf0) r10
            cf0 r10 = r10.I()
            pr1 r1 = defpackage.pr1.X
            af0 r10 = r10.Z(r1)
            if (r10 == 0) goto L96
            v32 r10 = (defpackage.v32) r10
            r9.Z = r10
            r9.Y = r6
            java.lang.Object r1 = r0.P(r10, r9)
            if (r1 != r7) goto L61
            goto L90
        L61:
            r8 = r1
            r1 = r10
            r10 = r8
        L64:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L93
            java.lang.Object r10 = r9.z0     // Catch: java.lang.Throwable -> L37
            am1 r10 = (defpackage.am1) r10     // Catch: java.lang.Throwable -> L37
            r9.Z = r1     // Catch: java.lang.Throwable -> L37
            r9.Y = r5     // Catch: java.lang.Throwable -> L37
            java.lang.Object r10 = r10.g(r9)     // Catch: java.lang.Throwable -> L37
            if (r10 != r7) goto L7b
            goto L90
        L7b:
            r9.Z = r2
            r9.Y = r4
            java.lang.Object r9 = r0.A(r1, r9)
            if (r9 != r7) goto L93
            goto L90
        L86:
            r9.Z = r10
            r9.Y = r3
            java.lang.Object r9 = r0.A(r1, r9)
            if (r9 != r7) goto L91
        L90:
            return r7
        L91:
            r9 = r10
        L92:
            throw r9
        L93:
            xl4 r9 = defpackage.xl4.a
            return r9
        L96:
            java.lang.String r9 = "Internal error. coroutineScope should've created a job."
            defpackage.xe.q(r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uf.t(java.lang.Object):java.lang.Object");
    }

    private final Object u(Object obj) {
        n12.S(obj);
        b84 b84Var = (b84) this.Z;
        ed4 ed4Var = b84Var.I0;
        if (ed4Var == null) {
            n12.T("binding");
            throw null;
        }
        ((TextView) ed4Var.A).setText(b84Var.getString(R.string.fetching_media_from_console_template, ((String) this.y0) + "(" + (this.Y + 1) + "/" + ((String[]) this.z0).length + ")"));
        return xl4.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object v(java.lang.Object r11) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uf.v(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) throws Exception {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((uf) n((ge0) obj2, (ag1) obj)).p(xl4Var);
            case 1:
                return ((uf) n((ge0) obj2, (ag1) obj)).p(xl4Var);
            case 2:
                return ((uf) n((ge0) obj2, (hx3) obj)).p(xl4Var);
            case 3:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 4:
                return ((uf) n((ge0) obj2, (jg4) obj)).p(xl4Var);
            case 5:
                return ((uf) n((ge0) obj2, (ag1) obj)).p(xl4Var);
            case 6:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 7:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 8:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 10:
                return ((uf) n((ge0) obj2, obj)).p(xl4Var);
            case 11:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 13:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 14:
                return ((uf) n((ge0) obj2, (q53) obj)).p(xl4Var);
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 16:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 17:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 18:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 19:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 20:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 21:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 22:
                return ((uf) n((ge0) obj2, (jg4) obj)).p(xl4Var);
            case 23:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 24:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 25:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 26:
                ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return xl4Var;
            case 27:
                return ((uf) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            default:
                return ((uf) n((ge0) obj2, (q53) obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.z0;
        switch (i) {
            case 0:
                uf ufVar = new uf((zf1) this.y0, ge0Var, (vf) obj2);
                ufVar.Z = obj;
                return ufVar;
            case 1:
                uf ufVar2 = new uf((v92) obj2, ge0Var, 1);
                ufVar2.Z = obj;
                return ufVar2;
            case 2:
                uf ufVar3 = new uf((x32) this.y0, (Function2) obj2, ge0Var, 2);
                ufVar3.Z = obj;
                return ufVar3;
            case 3:
                uf ufVar4 = new uf((ag1) this.y0, (b30) obj2, ge0Var, 3);
                ufVar4.Z = obj;
                return ufVar4;
            case 4:
                uf ufVar5 = new uf((j80) this.y0, (wz2) obj2, ge0Var, 4);
                ufVar5.Z = obj;
                return ufVar5;
            case 5:
                uf ufVar6 = new uf((lj0) obj2, ge0Var, 5);
                ufVar6.Z = obj;
                return ufVar6;
            case 6:
                uf ufVar7 = new uf((lj0) this.y0, (Function2) obj2, ge0Var, 6);
                ufVar7.Z = obj;
                return ufVar7;
            case 7:
                uf ufVar8 = new uf((List) this.y0, (xw0) obj2, ge0Var, 7);
                ufVar8.Z = obj;
                return ufVar8;
            case 8:
                uf ufVar9 = new uf((ma1) this.y0, (aa1) obj2, ge0Var, 8);
                ufVar9.Z = obj;
                return ufVar9;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                uf ufVar10 = new uf((kg1) this.y0, (ag1) obj2, ge0Var, 9);
                ufVar10.Z = obj;
                return ufVar10;
            case 10:
                uf ufVar11 = new uf((em1) this.y0, (xu) obj2, ge0Var, 10);
                ufVar11.Z = obj;
                return ufVar11;
            case 11:
                uf ufVar12 = new uf((Function2) this.y0, (vv) obj2, ge0Var, 11);
                ufVar12.Z = obj;
                return ufVar12;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new uf((nj2) this.Z, (Uri) this.y0, (InputEvent) obj2, ge0Var, 12);
            case 13:
                return new uf((NATDetectActivity) this.Z, (String) this.y0, (zg3) obj2, ge0Var, 13);
            case 14:
                uf ufVar13 = new uf((mc0) this.y0, (ir2) obj2, ge0Var, 14);
                ufVar13.Z = obj;
                return ufVar13;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                uf ufVar14 = new uf((xp) this.y0, (az2) obj2, ge0Var, 15);
                ufVar14.Z = obj;
                return ufVar14;
            case 16:
                return new uf((jy2) this.Z, (rf) this.y0, (kz2) obj2, ge0Var, 16);
            case 17:
                return new uf((bh3) this.y0, (q13) obj2, ge0Var, 17);
            case 18:
                return new uf((String) this.Z, (String) this.y0, (String) obj2, ge0Var, 18);
            case 19:
                uf ufVar15 = new uf((ArrayList) this.y0, (ArrayList) obj2, ge0Var, 19);
                ufVar15.Z = obj;
                return ufVar15;
            case 20:
                return new uf((d83) this.y0, (String) obj2, ge0Var, 20);
            case 21:
                return new uf((d83) this.Z, (String) this.y0, (String) obj2, ge0Var, 21);
            case 22:
                uf ufVar16 = new uf((String) this.y0, (sl3) obj2, ge0Var, 22);
                ufVar16.Z = obj;
                return ufVar16;
            case 23:
                uf ufVar17 = new uf((o80) this.y0, (Function2) obj2, ge0Var, 23);
                ufVar17.Z = obj;
                return ufVar17;
            case 24:
                uf ufVar18 = new uf((xp) this.y0, (Function2) obj2, ge0Var, 24);
                ufVar18.Z = obj;
                return ufVar18;
            case 25:
                uf ufVar19 = new uf((oj1) this.y0, (am1) obj2, ge0Var, 25);
                ufVar19.Z = obj;
                return ufVar19;
            case 26:
                return new uf((b84) this.Z, (String) this.y0, this.Y, (String[]) obj2, ge0Var);
            case 27:
                return new uf((TwoPanePreferenceFragment) this.Z, (String) this.y0, (String) obj2, ge0Var, 27);
            default:
                uf ufVar20 = new uf((wn1) this.y0, (Activity) obj2, ge0Var, 28);
                ufVar20.Z = obj;
                return ufVar20;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x0269, code lost:
    
        if (r0 == r12) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02c9, code lost:
    
        if (r0 == r12) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0361, code lost:
    
        if (r0.b(r1, r3, r3, true, r6, r2, r8, r27) == r12) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0397, code lost:
    
        if (r0.c(r1, r5) != r12) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x048f, code lost:
    
        if (r0.c(r1, r5) != r12) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:466:0x0a3d, code lost:
    
        if (defpackage.r25.v(r3, r1, r5) == r2) goto L467;
     */
    /* JADX WARN: Code restructure failed: missing block: B:513:0x0b23, code lost:
    
        if (r3 == r1) goto L520;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04d6 A[LOOP:3: B:219:0x04d0->B:221:0x04d6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x07e5  */
    /* JADX WARN: Removed duplicated region for block: B:518:0x0b39  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r28) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 3024
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uf.p(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uf(zf1 zf1Var, ge0 ge0Var, vf vfVar) {
        super(2, ge0Var);
        this.X = 0;
        this.y0 = zf1Var;
        this.z0 = vfVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ uf(Object obj, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.z0 = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ uf(Object obj, Object obj2, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.y0 = obj;
        this.z0 = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ uf(Object obj, Object obj2, Object obj3, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = obj;
        this.y0 = obj2;
        this.z0 = obj3;
    }
}
