package defpackage;

import android.content.Context;
import android.net.Uri;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.getsurfboard.ui.fragment.settings.AppSettingsFragment;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function2;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hd extends v74 implements Function2 {
    public final /* synthetic */ Object A0;
    public final /* synthetic */ int X;
    public int Y;
    public Object Z;
    public Object y0;
    public Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hd(iv1 iv1Var, Uri uri, po1 po1Var, bh3 bh3Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.X = 8;
        this.y0 = iv1Var;
        this.A0 = uri;
        this.z0 = po1Var;
        this.Z = bh3Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0087, code lost:
    
        if (r15 != r13) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object r(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r14.A0
            j$.util.concurrent.ConcurrentHashMap r0 = (j$.util.concurrent.ConcurrentHashMap) r0
            java.lang.Object r1 = r14.z0
            zz3 r1 = (defpackage.zz3) r1
            java.util.Map r4 = r1.d
            int r2 = r14.Y
            r9 = 0
            xl4 r10 = defpackage.xl4.a
            r11 = 2
            r12 = 1
            mf0 r13 = defpackage.mf0.b
            if (r2 == 0) goto L2b
            if (r2 == r12) goto L23
            if (r2 != r11) goto L1d
            defpackage.n12.S(r15)
            goto L8a
        L1d:
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r14)
            return r9
        L23:
            java.lang.Object r2 = r14.y0
            f82 r2 = (defpackage.f82) r2
            defpackage.n12.S(r15)
            goto L5e
        L2b:
            defpackage.n12.S(r15)
            f82 r8 = new f82
            t53 r15 = r1.b
            java.lang.String r15 = r15.b
            na3 r2 = r1.c
            java.lang.String r2 = r2.getName()
            java.lang.Object r3 = r14.Z
            java.lang.String r3 = (java.lang.String) r3
            r8.<init>(r15, r2, r3)
            boolean r15 = r1.f
            if (r15 == 0) goto L72
            d04 r2 = new d04
            t53 r3 = r1.b
            int r5 = r1.i
            java.lang.String r6 = r1.g
            java.lang.String r7 = r1.h
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r14.y0 = r8
            r14.Y = r12
            java.lang.Object r15 = r2.b(r14)
            if (r15 != r13) goto L5d
            goto L89
        L5d:
            r2 = r8
        L5e:
            e03 r15 = (defpackage.e03) r15
            java.lang.Object r15 = r15.f
            pn0 r15 = (defpackage.pn0) r15
            boolean r15 = r15 instanceof defpackage.ln0
            if (r15 == 0) goto L71
            ln0 r14 = defpackage.ln0.a
            r0.put(r2, r14)
            defpackage.zz3.a(r2, r14)
            return r10
        L71:
            r8 = r2
        L72:
            d04 r2 = new d04
            t53 r3 = r1.b
            int r5 = r1.i
            java.lang.String r6 = r1.g
            java.lang.String r7 = r1.h
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r14.y0 = r9
            r14.Y = r11
            java.lang.Object r15 = r2.b(r14)
            if (r15 != r13) goto L8a
        L89:
            return r13
        L8a:
            e03 r15 = (defpackage.e03) r15
            java.lang.Object r14 = r15.b
            java.lang.Object r1 = r15.f
            r0.put(r14, r1)
            java.lang.Object r14 = r15.b
            f82 r14 = (defpackage.f82) r14
            pn0 r1 = (defpackage.pn0) r1
            defpackage.zz3.a(r14, r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hd.r(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((hd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 1:
                return ((hd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 2:
                return ((hd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 3:
                return ((hd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 4:
                return ((hd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 5:
                return ((hd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 6:
                return ((hd) n((ge0) obj2, (ag1) obj)).p(xl4Var);
            case 7:
                l30 l30Var = (l30) obj;
                Object obj3 = l30Var.a;
                return ((hd) n((ge0) obj2, l30Var)).p(xl4Var);
            case 8:
                return ((hd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return ((hd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 10:
                return ((hd) n((ge0) obj2, (hx3) obj)).p(xl4Var);
            case 11:
                return ((hd) n((ge0) obj2, (ag1) obj)).p(xl4Var);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return ((hd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 13:
                return ((hd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 14:
                return ((hd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return ((hd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            default:
                return ((hd) n((ge0) obj2, (lf0) obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.A0;
        switch (i) {
            case 0:
                hd hdVar = new hd((AppSettingsFragment) this.z0, (u6) this.Z, (Uri) obj2, ge0Var, 0);
                hdVar.y0 = obj;
                return hdVar;
            case 1:
                return new hd((u6) this.Z, (jj) this.y0, ge0Var, (k03) this.z0, (Set) obj2);
            case 2:
                return new hd((BypassConfigActivity) this.Z, (Runnable) obj2, ge0Var, 2);
            case 3:
                return new hd((m20) this.y0, (gx4) this.z0, (AtomicInteger) this.Z, (nc2) obj2, ge0Var, 3);
            case 4:
                return new hd((ConstraintTrackingWorker) this.y0, (tc2) this.z0, (m20) this.Z, (gx4) obj2, ge0Var, 4);
            case 5:
                return new hd((byte[]) this.y0, (xw0) this.z0, (List) this.Z, (o32) obj2, ge0Var, 5);
            case 6:
                hd hdVar2 = new hd((pg1) this.Z, (bv) obj2, ge0Var, 6);
                hdVar2.y0 = obj;
                return hdVar2;
            case 7:
                hd hdVar3 = new hd((bh3) this.Z, (ag1) obj2, ge0Var, 7);
                hdVar3.y0 = obj;
                return hdVar3;
            case 8:
                return new hd((iv1) this.y0, (Uri) obj2, (po1) this.z0, (bh3) this.Z, ge0Var);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new hd((String) this.y0, (String) this.z0, (po1) this.Z, (iv1) obj2, ge0Var, 9);
            case 10:
                hd hdVar4 = new hd((az2) obj2, ge0Var, 10);
                hdVar4.y0 = obj;
                return hdVar4;
            case 11:
                hd hdVar5 = new hd((az2) obj2, ge0Var, 11);
                hdVar5.y0 = obj;
                return hdVar5;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new hd((d83) this.y0, (String) this.z0, (String) this.Z, (x53) obj2, ge0Var, 12);
            case 13:
                hd hdVar6 = new hd((ag1) this.Z, (Function2) obj2, ge0Var, 13);
                hdVar6.y0 = obj;
                return hdVar6;
            case 14:
                return new hd((zz3) this.y0, (String) this.z0, (List) this.Z, (ConcurrentHashMap) obj2, ge0Var, 14);
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return new hd((zz3) this.z0, (String) this.Z, (ConcurrentHashMap) obj2, ge0Var, 15);
            default:
                return new hd((tc2) this.y0, (gx4) this.z0, (uw4) this.Z, (Context) obj2, ge0Var, 16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:148:0x036e, code lost:
    
        if (r0 == r3) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x03cc, code lost:
    
        if (r2 != r3) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0531, code lost:
    
        if (r3.a(r4, r25) == r0) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x0840, code lost:
    
        if (defpackage.ji0.V(r0, r3, r8, r4, r4, r25) == r11) goto L393;
     */
    /* JADX WARN: Code restructure failed: missing block: B:481:?, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0255, code lost:
    
        if (r1.h(r2, r25) == r0) goto L92;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0152  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x014c -> B:42:0x011c). Please report as a decompilation issue!!! */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hd.p(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hd(u6 u6Var, jj jjVar, ge0 ge0Var, k03 k03Var, Set set) {
        super(2, ge0Var);
        this.X = 1;
        this.Z = u6Var;
        this.y0 = jjVar;
        this.z0 = k03Var;
        this.A0 = set;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hd(az2 az2Var, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.A0 = az2Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hd(Object obj, Object obj2, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = obj;
        this.A0 = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hd(Object obj, Object obj2, Object obj3, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.z0 = obj;
        this.Z = obj2;
        this.A0 = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hd(Object obj, Object obj2, Object obj3, Object obj4, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.y0 = obj;
        this.z0 = obj2;
        this.Z = obj3;
        this.A0 = obj4;
    }
}
