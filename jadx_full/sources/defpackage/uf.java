package defpackage;

import android.app.Activity;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.InputEvent;
import android.widget.TextView;
import androidx.fragment.app.a;
import androidx.fragment.app.o;
import androidx.fragment.app.u;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.NATDetectActivity;
import com.getsurfboard.ui.fragment.settings.TwoPanePreferenceFragment;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DefaultDnsQuery;
import io.netty.handler.codec.dns.DefaultDnsQuestion;
import io.netty.handler.codec.dns.DnsOpCode;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
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
    */
    private final Object t(Object obj) throws Throwable {
        v32 v32Var;
        ?? r0 = (n02) ((oj1) this.y0).f;
        ?? r1 = this.Y;
        mf0 mf0Var = mf0.b;
        try {
        } catch (Throwable th) {
            this.Z = th;
            this.Y = 4;
            if (r0.A(r1, this) != mf0Var) {
                throw th;
            }
        }
        if (r1 == 0) {
            n12.S(obj);
            af0 af0VarZ = ((lf0) this.Z).I().Z(pr1.X);
            if (af0VarZ == null) {
                xe.q("Internal error. coroutineScope should've created a job.");
                return null;
            }
            v32 v32Var2 = (v32) af0VarZ;
            this.Z = v32Var2;
            this.Y = 1;
            Object objP = r0.P(v32Var2, this);
            if (objP != mf0Var) {
                v32Var = v32Var2;
                obj = objP;
            }
            return mf0Var;
        }
        if (r1 == 1) {
            v32 v32Var3 = (v32) this.Z;
            n12.S(obj);
            v32Var = v32Var3;
        } else {
            if (r1 != 2) {
                if (r1 == 3) {
                    n12.S(obj);
                    return xl4.a;
                }
                if (r1 != 4) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                Throwable th2 = (Throwable) this.Z;
                n12.S(obj);
                throw th2;
            }
            v32 v32Var4 = (v32) this.Z;
            n12.S(obj);
            r1 = v32Var4;
            this.Z = null;
            this.Y = 3;
            this = r0.A(r1, this);
        }
        if (((Boolean) obj).booleanValue()) {
            am1 am1Var = (am1) this.z0;
            this.Z = v32Var;
            this.Y = 2;
            r1 = v32Var;
            if (am1Var.g(this) != mf0Var) {
                this.Z = null;
                this.Y = 3;
                this = r0.A(r1, this);
            }
            return mf0Var;
        }
        return xl4.a;
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
    */
    private final Object v(Object obj) {
        int i = this.Y;
        if (i == 0) {
            n12.S(obj);
            TwoPanePreferenceFragment twoPanePreferenceFragment = (TwoPanePreferenceFragment) this.Z;
            String str = (String) this.y0;
            String str2 = (String) this.z0;
            r92 lifecycle = twoPanePreferenceFragment.getLifecycle();
            gm0 gm0Var = qv0.a;
            tq1 tq1Var = qf2.a.X;
            cf0 cf0Var = this.f;
            cf0Var.getClass();
            boolean zQ0 = tq1Var.q0(cf0Var);
            q92 q92Var = q92.A;
            if (zQ0) {
                nt ntVar = new nt(5, twoPanePreferenceFragment, str, str2);
                this.Y = 1;
                Object objV = ji0.V(lifecycle, q92Var, zQ0, tq1Var, ntVar, this);
                mf0 mf0Var = mf0.b;
                if (objV == mf0Var) {
                    return mf0Var;
                }
            } else {
                if (lifecycle.b() == q92.b) {
                    vp1.m();
                    return null;
                }
                if (lifecycle.b().compareTo(q92Var) >= 0) {
                    tj1 tj1VarJ = twoPanePreferenceFragment.getChildFragmentManager().J();
                    twoPanePreferenceFragment.requireContext().getClassLoader();
                    o oVarA = tj1VarJ.a(str);
                    oVarA.getClass();
                    if (str2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("highlight_key", str2);
                        oVarA.setArguments(bundle);
                    }
                    if (twoPanePreferenceFragment.getChildFragmentManager().H() > 0) {
                        a aVarG = twoPanePreferenceFragment.getChildFragmentManager().G();
                        aVarG.getClass();
                        twoPanePreferenceFragment.getChildFragmentManager().T(aVarG.t, false);
                    }
                    u childFragmentManager = twoPanePreferenceFragment.getChildFragmentManager();
                    childFragmentManager.getClass();
                    a aVar = new a(childFragmentManager);
                    aVar.p = true;
                    aVar.k(oVarA, R.id.preferences_detail);
                    if (((SlidingPaneLayout) twoPanePreferenceFragment.requireView()).d()) {
                        aVar.f = 4099;
                    }
                    ((SlidingPaneLayout) twoPanePreferenceFragment.requireView()).e();
                    aVar.e();
                }
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
    */
    public final Object p(Object obj) throws Exception {
        ag1 ag1Var;
        Object objJ;
        Iterator it;
        ag1 ag1Var2;
        Object objB0;
        j24 j24Var;
        ag1 ag1Var3;
        j24 j24Var2;
        Object objA;
        List list;
        Object objK;
        pl1 b4Var;
        jy2 jy2Var;
        Iterator it2;
        Object objA2;
        bh3 bh3Var;
        Object objI;
        Object objB;
        bx0 bx0Var;
        uf ufVar = this;
        int i = 7;
        int i2 = 4;
        int i3 = 5;
        int i4 = 0;
        int i5 = 2;
        int i6 = 3;
        int i7 = 1;
        Object obj2 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        Object[] objArr10 = 0;
        switch (ufVar.X) {
            case 0:
                mf0 mf0Var = mf0.b;
                int i8 = ufVar.Y;
                if (i8 == 0) {
                    n12.S(obj);
                    ag1 ag1Var4 = (ag1) ufVar.Z;
                    zf1 zf1Var = (zf1) ufVar.y0;
                    tf tfVar = new tf(i4, ag1Var4, (vf) ufVar.z0);
                    ufVar.Y = 1;
                    if (zf1Var.a(tfVar, ufVar) == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i8 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 1:
                v92 v92Var = (v92) ufVar.z0;
                mf0 mf0Var2 = mf0.b;
                int i9 = ufVar.Y;
                if (i9 == 0) {
                    n12.S(obj);
                    ag1Var = (ag1) ufVar.Z;
                    qt qtVar = (qt) v92Var.b;
                    ufVar.Z = ag1Var;
                    ufVar.Y = 1;
                    objJ = qtVar.j(ufVar);
                    break;
                } else {
                    if (i9 != 1) {
                        if (i9 != 2) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        it = (Iterator) ufVar.y0;
                        ag1Var = (ag1) ufVar.Z;
                        n12.S(obj);
                        while (it.hasNext()) {
                            tz1 tz1Var = (tz1) it.next();
                            ufVar.Z = ag1Var;
                            ufVar.y0 = it;
                            ufVar.Y = 2;
                            if (ag1Var.h(tz1Var, ufVar) == mf0Var2) {
                                return mf0Var2;
                            }
                        }
                        return xl4.a;
                    }
                    ag1Var = (ag1) ufVar.Z;
                    n12.S(obj);
                    objJ = obj;
                }
                ((z14) v92Var.A).start();
                it = ((List) objJ).iterator();
                while (it.hasNext()) {
                }
                return xl4.a;
            case 2:
                mf0 mf0Var3 = mf0.b;
                int i10 = ufVar.Y;
                if (i10 == 0) {
                    n12.S(obj);
                    hx3 hx3Var = (hx3) ufVar.Z;
                    ((x32) ufVar.y0).M(new f0(i3, hx3Var));
                    Function2 function2 = (Function2) ufVar.z0;
                    ufVar.Y = 1;
                    if (function2.k(hx3Var, ufVar) == mf0Var3) {
                        return mf0Var3;
                    }
                } else {
                    if (i10 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 3:
                xl4 xl4Var = xl4.a;
                mf0 mf0Var4 = mf0.b;
                int i11 = ufVar.Y;
                if (i11 == 0) {
                    n12.S(obj);
                    lf0 lf0Var = (lf0) ufVar.Z;
                    ag1 ag1Var5 = (ag1) ufVar.y0;
                    y20 y20VarG = ((b30) ufVar.z0).g(lf0Var);
                    ufVar.Y = 1;
                    Object objS = ez4.s(ag1Var5, y20VarG, true, ufVar);
                    if (objS != mf0Var4) {
                        objS = xl4Var;
                    }
                    if (objS == mf0Var4) {
                        return mf0Var4;
                    }
                } else {
                    if (i11 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4Var;
            case 4:
                mf0 mf0Var5 = mf0.b;
                int i12 = ufVar.Y;
                if (i12 != 0) {
                    if (i12 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                jg4 jg4Var = (jg4) ufVar.Z;
                ig4 ig4Var = ig4.b;
                hj hjVar = new hj((j80) ufVar.y0, (wz2) ufVar.z0, objArr == true ? 1 : 0, i);
                ufVar.Y = 1;
                Object objA3 = jg4Var.a(ig4Var, hjVar, ufVar);
                return objA3 == mf0Var5 ? mf0Var5 : objA3;
            case 5:
                xl4 xl4Var2 = xl4.a;
                lj0 lj0Var = (lj0) ufVar.z0;
                mf0 mf0Var6 = mf0.b;
                int i13 = ufVar.Y;
                if (i13 == 0) {
                    n12.S(obj);
                    ag1Var2 = (ag1) ufVar.Z;
                    ufVar.Z = ag1Var2;
                    ufVar.Y = 1;
                    objB0 = ji0.b0(lj0Var.z.I(), new wi0(lj0Var, objArr2 == true ? 1 : 0, i5), ufVar);
                    if (objB0 != mf0Var6) {
                    }
                    return mf0Var6;
                }
                if (i13 == 1) {
                    ag1Var2 = (ag1) ufVar.Z;
                    n12.S(obj);
                    objB0 = obj;
                } else {
                    if (i13 != 2) {
                        if (i13 == 3) {
                            n12.S(obj);
                            return xl4Var2;
                        }
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    j24Var2 = (fi0) ufVar.y0;
                    ag1Var3 = (ag1) ufVar.Z;
                    n12.S(obj);
                    ag1 ag1Var6 = ag1Var3;
                    j24Var = j24Var2;
                    ag1Var2 = ag1Var6;
                    ng1 ng1Var = new ng1(new av(i6, new tg1(new pg1(new pg1(new wi0(lj0Var, objArr5 == true ? 1 : 0, i4), (m24) lj0Var.y0.f), new tu(i5, objArr4 == true ? 1 : 0, i7), i7), new gd(j24Var, objArr3 == true ? 1 : 0, i6), i7)), new xi0(lj0Var, (ge0) null));
                    ufVar.Z = null;
                    ufVar.y0 = null;
                    ufVar.Y = 3;
                }
                break;
                j24Var = (j24) objB0;
                if (!(j24Var instanceof fi0)) {
                    if (j24Var instanceof yk4) {
                        xe.q("This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542");
                        return null;
                    }
                    if (j24Var instanceof wd3) {
                        throw ((wd3) j24Var).b;
                    }
                    if (!(j24Var instanceof qe1)) {
                        ng1 ng1Var2 = new ng1(new av(i6, new tg1(new pg1(new pg1(new wi0(lj0Var, objArr5 == true ? 1 : 0, i4), (m24) lj0Var.y0.f), new tu(i5, objArr4 == true ? 1 : 0, i7), i7), new gd(j24Var, objArr3 == true ? 1 : 0, i6), i7)), new xi0(lj0Var, (ge0) null));
                        ufVar.Z = null;
                        ufVar.y0 = null;
                        ufVar.Y = 3;
                        break;
                    }
                    return xl4Var2;
                }
                fi0 fi0Var = (fi0) j24Var;
                Object obj3 = fi0Var.b;
                ufVar.Z = ag1Var2;
                ufVar.y0 = fi0Var;
                ufVar.Y = 2;
                if (ag1Var2.h(obj3, ufVar) != mf0Var6) {
                    ag1Var3 = ag1Var2;
                    j24Var2 = j24Var;
                    ag1 ag1Var62 = ag1Var3;
                    j24Var = j24Var2;
                    ag1Var2 = ag1Var62;
                    ng1 ng1Var22 = new ng1(new av(i6, new tg1(new pg1(new pg1(new wi0(lj0Var, objArr5 == true ? 1 : 0, i4), (m24) lj0Var.y0.f), new tu(i5, objArr4 == true ? 1 : 0, i7), i7), new gd(j24Var, objArr3 == true ? 1 : 0, i6), i7)), new xi0(lj0Var, (ge0) null));
                    ufVar.Z = null;
                    ufVar.y0 = null;
                    ufVar.Y = 3;
                    break;
                }
                return mf0Var6;
            case 6:
                lj0 lj0Var2 = (lj0) ufVar.y0;
                mf0 mf0Var7 = mf0.b;
                int i14 = ufVar.Y;
                if (i14 != 0) {
                    if (i14 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                lf0 lf0Var2 = (lf0) ufVar.Z;
                o80 o80VarA = vo.a();
                kl2 kl2Var = new kl2((Function2) ufVar.z0, o80VarA, lj0Var2.y0.s(), lf0Var2.I());
                iv1 iv1Var = lj0Var2.C0;
                Object objE = ((xp) iv1Var.A).e(kl2Var);
                if (objE instanceof j30) {
                    Throwable th = ((j30) objE).a;
                    if (th == null) {
                        throw new c60("Channel was closed normally");
                    }
                    throw th;
                }
                if (objE instanceof k30) {
                    xe.q("Check failed.");
                    return null;
                }
                if (((AtomicInteger) ((cp1) iv1Var.X).f).getAndIncrement() == 0) {
                    ji0.B((lf0) iv1Var.f, null, null, new w53(iv1Var, objArr6 == true ? 1 : 0, 8), 3);
                }
                ufVar.Y = 1;
                Object objJ0 = o80VarA.j0(ufVar);
                return objJ0 == mf0Var7 ? mf0Var7 : objJ0;
            case 7:
                List list2 = (List) ufVar.y0;
                lf0 lf0Var3 = (lf0) ufVar.Z;
                mf0 mf0Var8 = mf0.b;
                int i15 = ufVar.Y;
                if (i15 == 0) {
                    n12.S(obj);
                    try {
                        DefaultDnsQuery defaultDnsQuery = new DefaultDnsQuery(1, DnsOpCode.QUERY);
                        try {
                            defaultDnsQuery.setRecursionDesired(true);
                            defaultDnsQuery.addRecord(DnsSection.QUESTION, (DnsRecord) new DefaultDnsQuestion("getsurfboard.com", DnsRecordType.A, 1));
                            byte[] bArrD = je.D(defaultDnsQuery);
                            defaultDnsQuery.release();
                            if (list2.isEmpty()) {
                                return new uk3(new tk3(new Exception("No resolvers provided")));
                            }
                            xw0 xw0Var = (xw0) ufVar.z0;
                            ArrayList arrayList = new ArrayList(f70.Q(10, list2));
                            Iterator it3 = list2.iterator();
                            while (true) {
                                ge0 ge0Var = null;
                                if (it3.hasNext()) {
                                    String str = (String) it3.next();
                                    gm0 gm0Var = qv0.a;
                                    arrayList.add(ji0.b(lf0Var3, pl0.z, new ej(xw0Var, str, bArrD, ge0Var, 2), 2));
                                } else {
                                    ufVar.Z = null;
                                    ufVar.Y = 1;
                                    objA = yr2.a(arrayList, ufVar);
                                    if (objA == mf0Var8) {
                                        return mf0Var8;
                                    }
                                }
                            }
                        } finally {
                        }
                    } catch (Exception e) {
                        return new uk3(new tk3(e));
                    }
                } else {
                    if (i15 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    objA = obj;
                }
                Iterable iterable = (Iterable) objA;
                iterable.getClass();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj4 : iterable) {
                    if (obj4 != null) {
                        arrayList2.add(obj4);
                    }
                }
                return new uk3(!arrayList2.isEmpty() ? new tk3(new Exception(d70.j0(arrayList2, "\n", null, null, new ji(i3), 30))) : xl4.a);
            case 8:
                lf0 lf0Var4 = (lf0) ufVar.Z;
                mf0 mf0Var9 = mf0.b;
                int i16 = ufVar.Y;
                if (i16 == 0) {
                    n12.S(obj);
                    ma1 ma1Var = (ma1) ufVar.y0;
                    aa1 aa1Var = (aa1) ufVar.z0;
                    r92 lifecycle = ma1Var.getLifecycle();
                    q92 q92Var = q92.X;
                    gm0 gm0Var2 = qv0.a;
                    tq1 tq1Var = qf2.a.X;
                    cf0 cf0Var = ufVar.f;
                    cf0Var.getClass();
                    boolean zQ0 = tq1Var.q0(cf0Var);
                    if (zQ0) {
                        nt ntVar = new nt(i7, lf0Var4, ma1Var, aa1Var);
                        ufVar.Z = null;
                        ufVar.Y = 1;
                        if (ji0.V(lifecycle, q92Var, zQ0, tq1Var, ntVar, ufVar) == mf0Var9) {
                            return mf0Var9;
                        }
                    } else {
                        if (lifecycle.b() == q92.b) {
                            vp1.m();
                            return null;
                        }
                        if (lifecycle.b().compareTo(q92Var) >= 0) {
                            List list3 = (List) d73.b.d();
                            if (list3 != null) {
                                ArrayList arrayListB0 = d70.b0(t53.class, list3);
                                ArrayList arrayList3 = new ArrayList();
                                for (Object obj5 : arrayListB0) {
                                    if (ma1.j(aa1Var, (t53) obj5)) {
                                        arrayList3.add(obj5);
                                    }
                                }
                                ArrayList arrayList4 = new ArrayList(f70.Q(10, arrayList3));
                                Iterator it4 = arrayList3.iterator();
                                while (it4.hasNext()) {
                                    arrayList4.add(((t53) it4.next()).b);
                                }
                                ji0.B(lf0Var4, null, null, new mt((String[]) arrayList4.toArray(new String[0]), objArr7 == true ? 1 : 0, i6), 3);
                            }
                            vs4 vs4Var = (vs4) ws4.c.d();
                            if (vs4Var != null && vs4Var.b && (list = (List) d73.b.d()) != null) {
                                Iterator it5 = d70.b0(t53.class, list).iterator();
                                while (true) {
                                    if (it5.hasNext()) {
                                        Object next = it5.next();
                                        if (n12.c(((t53) next).b, vs4Var.a)) {
                                            obj2 = next;
                                        }
                                    }
                                }
                                t53 t53Var = (t53) obj2;
                                if (t53Var != null && ma1.j(aa1Var, t53Var)) {
                                    if (co4.H()) {
                                        p95.C(R.string.restart_vpn_to_make_changes_take_effect, new Object[0]);
                                    } else {
                                        oy3 oy3VarG = oy3.g(ma1Var.requireView(), R.string.restart_vpn_to_make_changes_take_effect, 0);
                                        oy3VarG.i(R.string.restart, new c3(i6, ma1Var));
                                        oy3VarG.j();
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (i16 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                mf0 mf0Var10 = mf0.b;
                int i17 = ufVar.Y;
                if (i17 == 0) {
                    n12.S(obj);
                    lf0 lf0Var5 = (lf0) ufVar.Z;
                    kg1 kg1Var = (kg1) ufVar.y0;
                    ag1 ag1Var7 = (ag1) ufVar.z0;
                    ufVar.Y = 1;
                    if (kg1Var.e(lf0Var5, ag1Var7, ufVar) == mf0Var10) {
                        return mf0Var10;
                    }
                } else {
                    if (i17 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 10:
                mf0 mf0Var11 = mf0.b;
                int i18 = ufVar.Y;
                if (i18 == 0) {
                    n12.S(obj);
                    Object obj6 = ufVar.Z;
                    em1 em1Var = (em1) ufVar.y0;
                    xu xuVar = (xu) ufVar.z0;
                    ufVar.Y = 1;
                    if (em1Var.e(xuVar, obj6, ufVar) == mf0Var11) {
                        return mf0Var11;
                    }
                } else {
                    if (i18 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 11:
                vv vvVar = (vv) ufVar.z0;
                mf0 mf0Var12 = mf0.b;
                int i19 = ufVar.Y;
                try {
                    if (i19 == 0) {
                        n12.S(obj);
                        lf0 lf0Var6 = (lf0) ufVar.Z;
                        Function2 function22 = (Function2) ufVar.y0;
                        ufVar.Y = 1;
                        objK = function22.k(lf0Var6, ufVar);
                        if (objK == mf0Var12) {
                            return mf0Var12;
                        }
                    } else {
                        if (i19 != 1) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        n12.S(obj);
                        objK = obj;
                    }
                    vvVar.b(objK);
                    break;
                } catch (CancellationException unused) {
                    vvVar.c();
                } catch (Throwable th2) {
                    vvVar.d(th2);
                }
                return xl4.a;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                mf0 mf0Var13 = mf0.b;
                int i20 = ufVar.Y;
                if (i20 == 0) {
                    n12.S(obj);
                    r25 r25Var = ((nj2) ufVar.Z).a;
                    Uri uri = (Uri) ufVar.y0;
                    InputEvent inputEvent = (InputEvent) ufVar.z0;
                    ufVar.Y = 1;
                    if (r25Var.L(uri, inputEvent, ufVar) == mf0Var13) {
                        return mf0Var13;
                    }
                } else {
                    if (i20 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 13:
                NATDetectActivity nATDetectActivity = (NATDetectActivity) ufVar.Z;
                mf0 mf0Var14 = mf0.b;
                int i21 = ufVar.Y;
                if (i21 == 0) {
                    n12.S(obj);
                    h4 h4Var = nATDetectActivity.S0;
                    ge0 ge0Var2 = null;
                    if (h4Var == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((TextView) h4Var.f).setText("");
                    gm0 gm0Var3 = qv0.a;
                    pl0 pl0Var = pl0.z;
                    ej ejVar = new ej(nATDetectActivity, (String) ufVar.y0, (zg3) ufVar.z0, ge0Var2, 6);
                    ufVar.Y = 1;
                    if (ji0.b0(pl0Var, ejVar, ufVar) == mf0Var14) {
                        return mf0Var14;
                    }
                } else {
                    if (i21 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 14:
                xl4 xl4Var3 = xl4.a;
                ir2 ir2Var = (ir2) ufVar.z0;
                ConnectivityManager connectivityManager = ir2Var.a;
                mf0 mf0Var15 = mf0.b;
                int i22 = ufVar.Y;
                if (i22 == 0) {
                    n12.S(obj);
                    q53 q53Var = (q53) ufVar.Z;
                    NetworkRequest networkRequestA = ((mc0) ufVar.y0).a();
                    if (networkRequestA == null) {
                        q53Var.getClass();
                        q53Var.b(null);
                    } else {
                        gj gjVar = new gj(9, ji0.B(q53Var, null, null, new hj(ir2Var, q53Var, objArr8 == true ? 1 : 0, 24), 3), q53Var);
                        if (Build.VERSION.SDK_INT >= 30) {
                            kv3.a.getClass();
                            b4Var = kv3.a(connectivityManager, networkRequestA, gjVar);
                        } else {
                            int i23 = wz1.c;
                            wz1 wz1Var = new wz1(gjVar);
                            xg3 xg3Var = new xg3();
                            try {
                                ue2.g().a(mw4.a, "NetworkRequestConstraintController register callback");
                                connectivityManager.registerNetworkCallback(networkRequestA, wz1Var);
                                xg3Var.b = true;
                            } catch (RuntimeException e2) {
                                if (!w44.d0(e2.getClass().getName(), "TooManyRequestsException", false)) {
                                    throw e2;
                                }
                                ue2.g().d(mw4.a, "NetworkRequestConstraintController couldn't register callback", e2);
                                gjVar.g(new pc0(7));
                            }
                            b4Var = new b4(i5, xg3Var, connectivityManager, wz1Var);
                        }
                        yq1 yq1Var = new yq1(i7, b4Var);
                        ufVar.Y = 1;
                        if (je.g(q53Var, yq1Var, ufVar) == mf0Var15) {
                            return mf0Var15;
                        }
                    }
                    break;
                } else {
                    if (i22 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4Var3;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                mf0 mf0Var16 = mf0.b;
                int i24 = ufVar.Y;
                if (i24 == 0) {
                    n12.S(obj);
                    lf0 lf0Var7 = (lf0) ufVar.Z;
                    z20 z20VarN = ez4.n((xp) ufVar.y0);
                    tf tfVar2 = new tf(i2, (az2) ufVar.z0, lf0Var7);
                    ufVar.Y = 1;
                    if (z20VarN.a(tfVar2, ufVar) == mf0Var16) {
                        return mf0Var16;
                    }
                } else {
                    if (i24 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 16:
                mf0 mf0Var17 = mf0.b;
                switch (ufVar.Y) {
                    case 0:
                        n12.S(obj);
                        jy2 jy2Var2 = (jy2) ufVar.Z;
                        boolean z = jy2Var2 instanceof hy2;
                        if (!z) {
                            if (z) {
                            }
                            return mf0Var17;
                        }
                        hy2 hy2Var = (hy2) jy2Var2;
                        if (hy2Var.a == hd2.b) {
                            rf rfVar = (rf) ufVar.y0;
                            List list4 = hy2Var.b;
                            int i25 = hy2Var.c;
                            int i26 = hy2Var.d;
                            gd2 gd2Var = hy2Var.e;
                            gd2 gd2Var2 = hy2Var.f;
                            oj1 oj1Var = ((kz2) ufVar.z0).c;
                            ufVar.Y = 2;
                            ufVar = this;
                            break;
                        }
                        if (z) {
                            if (jy2Var2 instanceof gy2) {
                                if (((Boolean) ((rf) ufVar.y0).j.i()).booleanValue()) {
                                    ufVar.Y = 5;
                                    if (vf2.E(ufVar) != mf0Var17) {
                                    }
                                }
                                rf rfVar2 = (rf) ufVar.y0;
                                ke0 ke0VarG = rfVar2.d.g((jy2) ufVar.Z);
                                ufVar.Y = 6;
                            } else if (jy2Var2 instanceof iy2) {
                                iy2 iy2Var = (iy2) jy2Var2;
                                ((rf) ufVar.y0).e.M(iy2Var.a, iy2Var.b);
                            }
                            break;
                        } else if (((Boolean) ((rf) ufVar.y0).j.i()).booleanValue()) {
                            ufVar.Y = 3;
                            if (vf2.E(ufVar) != mf0Var17) {
                                rf rfVar3 = (rf) ufVar.y0;
                                ke0 ke0VarG2 = rfVar3.d.g((jy2) ufVar.Z);
                                ufVar.Y = 4;
                            }
                            break;
                        }
                        return mf0Var17;
                        jy2Var = (jy2) ufVar.Z;
                        if ((jy2Var instanceof hy2) || (jy2Var instanceof gy2)) {
                            it2 = ((rf) ufVar.y0).f.iterator();
                            while (it2.hasNext()) {
                                ((pl1) it2.next()).a();
                            }
                        }
                        return xl4.a;
                    case 1:
                    case 2:
                        n12.S(obj);
                        jy2Var = (jy2) ufVar.Z;
                        if (jy2Var instanceof hy2) {
                            it2 = ((rf) ufVar.y0).f.iterator();
                            while (it2.hasNext()) {
                            }
                        }
                        return xl4.a;
                    case 3:
                        n12.S(obj);
                        rf rfVar32 = (rf) ufVar.y0;
                        ke0 ke0VarG22 = rfVar32.d.g((jy2) ufVar.Z);
                        ufVar.Y = 4;
                        break;
                    case 4:
                        n12.S(obj);
                        n02 n02Var = ((rf) ufVar.y0).e;
                        hy2 hy2Var2 = (hy2) ((jy2) ufVar.Z);
                        n02Var.M(hy2Var2.e, hy2Var2.f);
                        b80 b80Var = (b80) ((fe3) ((rf) ufVar.y0).e.A).b.i();
                        gd2 gd2Var3 = b80Var != null ? b80Var.d : null;
                        if (gd2Var3 == null) {
                            xe.q("PagingDataPresenter.combinedLoadStatesCollection.stateFlow should not hold null CombinedLoadStates after Insert event.");
                            return null;
                        }
                        boolean z2 = gd2Var3.b.a;
                        boolean z3 = gd2Var3.c.a;
                        hy2 hy2Var3 = (hy2) ((jy2) ufVar.Z);
                        hd2 hd2Var = hy2Var3.a;
                        Object[] objArr11 = ((hd2Var == hd2.f && z2) || (hd2Var == hd2.z && z3)) ? false : true;
                        List list5 = hy2Var3.b;
                        if (!list5.isEmpty()) {
                            Iterator it6 = list5.iterator();
                            while (true) {
                                if (it6.hasNext()) {
                                    if (!((lg4) it6.next()).b.isEmpty()) {
                                        i7 = 0;
                                    }
                                }
                            }
                        }
                        rf rfVar4 = (rf) ufVar.y0;
                        if (objArr11 != true) {
                            rfVar4.h = false;
                        } else if (rfVar4.h || i7 != 0) {
                            if (i7 == 0) {
                                int i27 = ((rf) ufVar.y0).i;
                                rf rfVar5 = (rf) ufVar.y0;
                                if (i27 >= rfVar5.d.c) {
                                    int i28 = rfVar5.i;
                                    rf rfVar6 = (rf) ufVar.y0;
                                    ez2 ez2Var = rfVar6.d;
                                    if (i28 > ez2Var.c + ez2Var.b) {
                                        rf rfVar7 = (rf) ufVar.y0;
                                        oj1 oj1Var2 = rfVar7.b;
                                        if (oj1Var2 != null) {
                                            oj1Var2.u(rfVar7.d.a(rfVar7.i));
                                        }
                                    } else {
                                        rfVar6.h = false;
                                    }
                                }
                            }
                        }
                        jy2Var = (jy2) ufVar.Z;
                        if (jy2Var instanceof hy2) {
                        }
                        return xl4.a;
                    case 5:
                        n12.S(obj);
                        rf rfVar22 = (rf) ufVar.y0;
                        ke0 ke0VarG3 = rfVar22.d.g((jy2) ufVar.Z);
                        ufVar.Y = 6;
                        break;
                    case 6:
                        n12.S(obj);
                        n02 n02Var2 = ((rf) ufVar.y0).e;
                        ((gy2) ((jy2) ufVar.Z)).getClass();
                        n02Var2.getClass();
                        throw null;
                    default:
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                }
                break;
            case 17:
                mf0 mf0Var18 = mf0.b;
                int i29 = ufVar.Y;
                if (i29 == 0) {
                    n12.S(obj);
                    bh3 bh3Var2 = (bh3) ufVar.y0;
                    q13 q13Var = (q13) ufVar.z0;
                    ufVar.Z = bh3Var2;
                    ufVar.Y = 1;
                    objA2 = q13Var.a(ufVar);
                    if (objA2 == mf0Var18) {
                        return mf0Var18;
                    }
                    bh3Var = bh3Var2;
                } else {
                    if (i29 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bh3Var = (bh3) ufVar.Z;
                    n12.S(obj);
                    objA2 = obj;
                }
                bh3Var.b = objA2;
                return xl4.a;
            case 18:
                vd3 vd3Var = vd3.A;
                t60 t60Var = t60.Y;
                k01 k01Var = k01.A;
                mf0 mf0Var19 = mf0.b;
                int i30 = ufVar.Y;
                if (i30 == 0) {
                    n12.S(obj);
                    if (!xj.c((String) ufVar.Z)) {
                        vd3 vd3Var2 = vd3.Z;
                        String str2 = (String) ufVar.Z;
                        ufVar.Y = 1;
                        if (vd3Var2.x(str2, ufVar) != mf0Var19) {
                        }
                        return mf0Var19;
                    }
                } else {
                    if (i30 != 1) {
                        if (i30 != 2 && i30 != 3) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        n12.S(obj);
                        objI = ((uk3) obj).b;
                        return new uk3(objI);
                    }
                    n12.S(obj);
                }
                if (!xj.c((String) ufVar.Z)) {
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "ProfileFetcher", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "treat content as profile format");
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("ProfileFetcher", "treat content as profile format", null);
                    }
                    byte[] bytes = ((String) ufVar.Z).getBytes(y30.a);
                    bytes.getClass();
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                    String str3 = (String) ufVar.y0;
                    ufVar.Y = 3;
                    objI = c63.i(str3, byteArrayInputStream, k01Var, t60Var, vd3Var, ufVar);
                } else {
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "ProfileFetcher", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "treat content as base64 format");
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("ProfileFetcher", "treat content as base64 format", null);
                    }
                    List listE = s63.e(xj.a(0, (String) ufVar.Z));
                    if (listE.isEmpty()) {
                        xe.k("proxy urls is empty");
                        return null;
                    }
                    LinkedHashMap linkedHashMapA = s63.a(listE);
                    String str4 = (String) ufVar.y0;
                    String str5 = (String) ufVar.z0;
                    ufVar.Y = 2;
                    objI = s63.c(str4, str5, linkedHashMapA, k01Var, t60Var, vd3Var, ufVar);
                }
                break;
            case 19:
                lf0 lf0Var8 = (lf0) ufVar.Z;
                mf0 mf0Var20 = mf0.b;
                int i31 = ufVar.Y;
                if (i31 == 0) {
                    n12.S(obj);
                    ArrayList arrayList5 = new ArrayList();
                    for (String str6 : (ArrayList) ufVar.y0) {
                        gm0 gm0Var4 = qv0.a;
                        arrayList5.add(ji0.B(lf0Var8, pl0.z, null, new p81(str6, objArr10 == true ? 1 : 0, i2), 2));
                    }
                    for (String str7 : (ArrayList) ufVar.z0) {
                        gm0 gm0Var5 = qv0.a;
                        arrayList5.add(ji0.B(lf0Var8, pl0.z, null, new p81(str7, objArr9 == true ? 1 : 0, i3), 2));
                    }
                    ufVar.Z = null;
                    ufVar.Y = 1;
                    if (yr2.P(arrayList5, ufVar) == mf0Var20) {
                        return mf0Var20;
                    }
                } else {
                    if (i31 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 20:
                mf0 mf0Var21 = mf0.b;
                int i32 = ufVar.Y;
                if (i32 == 0) {
                    n12.S(obj);
                    bx0 bx0Var2 = ((d83) ufVar.y0).A;
                    e1 e1Var = d73.a;
                    String str8 = (String) ufVar.z0;
                    ufVar.Z = bx0Var2;
                    ufVar.Y = 1;
                    objB = d73.b(str8, ufVar);
                    if (objB == mf0Var21) {
                        return mf0Var21;
                    }
                    bx0Var = bx0Var2;
                } else {
                    if (i32 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bx0Var = (bx0) ufVar.Z;
                    n12.S(obj);
                    objB = obj;
                }
                bx0Var.g = (String) objB;
                return xl4.a;
            case 21:
                String str9 = (String) ufVar.z0;
                String str10 = (String) ufVar.y0;
                d83 d83Var = (d83) ufVar.Z;
                mf0 mf0Var22 = mf0.b;
                int i33 = ufVar.Y;
                if (i33 == 0) {
                    n12.S(obj);
                    vs4 vs4Var2 = (vs4) ws4.c.d();
                    if (vs4Var2 != null && vs4Var2.b) {
                        d83Var.f = true;
                    }
                    d83Var.A.g = str10;
                    String[] strArr = t23.a;
                    str10.getClass();
                    Set<String> setK = t23.k();
                    if (setK.remove(str9)) {
                        setK.add(str10);
                        SharedPreferences.Editor editorEdit = t23.l().edit();
                        editorEdit.putStringSet("pinned_profile_list", setK);
                        editorEdit.apply();
                    }
                    e1 e1Var2 = d73.a;
                    ufVar.Y = 1;
                    if (d73.i(str9, str10, ufVar) == mf0Var22) {
                        return mf0Var22;
                    }
                } else {
                    if (i33 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 22:
                mf0 mf0Var23 = mf0.b;
                int i34 = ufVar.Y;
                if (i34 != 0) {
                    if (i34 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                jg4 jg4Var2 = (jg4) ufVar.Z;
                String str11 = (String) ufVar.y0;
                gj3 gj3Var = new gj3((sl3) ufVar.z0, i7);
                ufVar.Y = 1;
                Object objB2 = jg4Var2.b(str11, gj3Var, ufVar);
                return objB2 == mf0Var23 ? mf0Var23 : objB2;
            case 23:
                return r(obj);
            case 24:
                return s(obj);
            case 25:
                return t(obj);
            case 26:
                return u(obj);
            case 27:
                return v(obj);
            default:
                wn1 wn1Var = (wn1) ufVar.y0;
                mf0 mf0Var24 = mf0.b;
                int i35 = ufVar.Y;
                if (i35 == 0) {
                    n12.S(obj);
                    q53 q53Var2 = (q53) ufVar.Z;
                    e74 e74Var = new e74(3, q53Var2);
                    ((ot4) wn1Var.f).a((Activity) ufVar.z0, new qd(1), e74Var);
                    qi qiVar = new qi(11, wn1Var, e74Var);
                    ufVar.Y = 1;
                    if (je.g(q53Var2, qiVar, ufVar) == mf0Var24) {
                        return mf0Var24;
                    }
                } else {
                    if (i35 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
        }
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
