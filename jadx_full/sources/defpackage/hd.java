package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.o;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.getsurfboard.R;
import com.getsurfboard.backup.model.BackupSection;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.getsurfboard.ui.fragment.settings.AppSettingsFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DefaultDnsQuery;
import io.netty.handler.codec.dns.DefaultDnsResponse;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.netty.handler.codec.rtsp.RtspHeaders;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
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
    */
    private final Object r(Object obj) {
        f82 f82Var;
        f82 f82Var2;
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.A0;
        zz3 zz3Var = (zz3) this.z0;
        Map map = zz3Var.d;
        int i = this.Y;
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        if (i == 0) {
            n12.S(obj);
            f82Var = new f82(zz3Var.b.b, zz3Var.c.getName(), (String) this.Z);
            if (zz3Var.f) {
                d04 d04Var = new d04(zz3Var.b, map, zz3Var.i, zz3Var.g, zz3Var.h, f82Var);
                this.y0 = f82Var;
                this.Y = 1;
                obj = d04Var.b(this);
                if (obj != mf0Var) {
                    f82Var2 = f82Var;
                }
            } else {
                d04 d04Var2 = new d04(zz3Var.b, map, zz3Var.i, zz3Var.g, zz3Var.h, f82Var);
                this.y0 = null;
                this.Y = 2;
                obj = d04Var2.b(this);
            }
            return mf0Var;
        }
        if (i != 1) {
            if (i != 2) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n12.S(obj);
            e03 e03Var = (e03) obj;
            Object obj2 = e03Var.b;
            Object obj3 = e03Var.f;
            concurrentHashMap.put(obj2, obj3);
            zz3.a((f82) e03Var.b, (pn0) obj3);
            return xl4Var;
        }
        f82Var2 = (f82) this.y0;
        n12.S(obj);
        if (((pn0) ((e03) obj).f) instanceof ln0) {
            ln0 ln0Var = ln0.a;
            concurrentHashMap.put(f82Var2, ln0Var);
            zz3.a(f82Var2, ln0Var);
            return xl4Var;
        }
        f82Var = f82Var2;
        d04 d04Var22 = new d04(zz3Var.b, map, zz3Var.i, zz3Var.g, zz3Var.h, f82Var);
        this.y0 = null;
        this.Y = 2;
        obj = d04Var22.b(this);
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
    */
    public final Object p(Object obj) throws Throwable {
        Object tk3Var;
        Object objB0;
        bh3 bh3Var;
        Object objB02;
        bh3 bh3Var2;
        String str;
        Object objA;
        DnsQuestion dnsQuestion;
        Object objH;
        e03 e03VarC;
        String strName;
        ag1 ag1Var;
        bh3 bh3Var3;
        bh3 bh3Var4;
        bh3 bh3Var5;
        hx3 hx3Var;
        bz2 bz2Var;
        yn2 yn2Var;
        fd2 fd2VarK;
        ag1 ag1Var2;
        bz2 bz2Var2;
        yn2 yn2Var2;
        v32 v32VarB;
        rp rpVar;
        v32 v32Var;
        Object objB;
        rp rpVar2;
        Object objA2;
        int i = 9;
        int i2 = 2;
        int i3 = 1;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object obj2 = null;
        Object[] objArr9 = 0;
        Object obj3 = null;
        switch (this.X) {
            case 0:
                xl4 xl4Var = xl4.a;
                AppSettingsFragment appSettingsFragment = (AppSettingsFragment) this.z0;
                mf0 mf0Var = mf0.b;
                int i4 = this.Y;
                try {
                    if (i4 == 0) {
                        n12.S(obj);
                        Uri uri = (Uri) this.A0;
                        gm0 gm0Var = qv0.a;
                        pl0 pl0Var = pl0.z;
                        gd gdVar = new gd(appSettingsFragment, uri, objArr == true ? 1 : 0, i);
                        this.y0 = null;
                        this.Y = 1;
                        if (ji0.b0(pl0Var, gdVar, this) == mf0Var) {
                            return mf0Var;
                        }
                    } else {
                        if (i4 != 1) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        n12.S(obj);
                    }
                    tk3Var = xl4Var;
                    break;
                } catch (Throwable th) {
                    tk3Var = new tk3(th);
                }
                appSettingsFragment.pendingExportSections = k41.b;
                appSettingsFragment.pendingExportPassword = null;
                ((u6) this.Z).dismiss();
                if (tk3Var instanceof tk3) {
                    Throwable thA = uk3.a(tk3Var);
                    thA.getClass();
                    xb5.L(thA);
                    String message = thA.getMessage();
                    if (message == null) {
                        message = thA.getClass().getSimpleName();
                    }
                    String string = appSettingsFragment.getString(R.string.backup_export_failed, message);
                    string.getClass();
                    p95.D(string);
                } else {
                    oy3.h(appSettingsFragment.requireView(), appSettingsFragment.getString(R.string.backup_export_success) + ". " + appSettingsFragment.getString(R.string.backup_sensitive_warning), 0).j();
                }
                return xl4Var;
            case 1:
                u6 u6Var = (u6) this.Z;
                jj jjVar = (jj) this.y0;
                o oVar = jjVar.a;
                mf0 mf0Var2 = mf0.b;
                int i5 = this.Y;
                if (i5 == 0) {
                    n12.S(obj);
                    gm0 gm0Var2 = qv0.a;
                    pl0 pl0Var2 = pl0.z;
                    fj fjVar = new fj(u6Var, jjVar, null, (k03) this.z0, (Set) this.A0);
                    this.Y = 1;
                    objB0 = ji0.b0(pl0Var2, fjVar, this);
                    if (objB0 == mf0Var2) {
                        return mf0Var2;
                    }
                } else {
                    if (i5 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    objB0 = obj;
                }
                u6Var.dismiss();
                Context contextRequireContext = oVar.requireContext();
                contextRequireContext.getClass();
                ArrayList arrayList = new ArrayList();
                for (gr3 gr3Var : ((jz1) objB0).a) {
                    BackupSection backupSection = gr3Var.a;
                    List list = gr3Var.c;
                    String string2 = oVar.getString(jj.b(backupSection));
                    string2.getClass();
                    String string3 = oVar.getString(R.string.backup_report_section_template, string2, Integer.valueOf(gr3Var.b));
                    string3.getClass();
                    arrayList.add(string3);
                    String str2 = gr3Var.d;
                    if (str2 != null) {
                        String string4 = oVar.getString(R.string.backup_report_error_template, str2);
                        string4.getClass();
                        arrayList.add(string4);
                    }
                    if (!list.isEmpty()) {
                        String string5 = oVar.getString(R.string.backup_report_skipped_template, d70.j0(list, "; ", null, null, null, 62));
                        string5.getClass();
                        arrayList.add(string5);
                    }
                }
                String strJ0 = d70.j0(arrayList, "\n", null, null, null, 62);
                wh2 wh2Var = new wh2(contextRequireContext);
                wh2Var.x(R.string.backup_import_finished);
                ((p6) wh2Var.z).g = strJ0;
                wh2Var.w(R.string.confirm, null);
                wh2Var.r();
                return xl4.a;
            case 2:
                BypassConfigActivity bypassConfigActivity = (BypassConfigActivity) this.Z;
                mf0 mf0Var3 = mf0.b;
                int i6 = this.Y;
                if (i6 == 0) {
                    n12.S(obj);
                    boolean zH = co4.H();
                    y3 y3Var = bypassConfigActivity.S0;
                    if (zH) {
                        if (y3Var == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((Toolbar) y3Var.c).getMenu().findItem(R.id.select_toggle).setVisible(false);
                    } else {
                        if (y3Var == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((ExtendedFloatingActionButton) y3Var.k).v(1);
                    }
                    bh3Var = new bh3();
                    this.y0 = bh3Var;
                    this.z0 = bh3Var;
                    this.Y = 1;
                    int i7 = BypassConfigActivity.Y0;
                    objB02 = ji0.b0(qv0.a, new ht(bypassConfigActivity, null), this);
                    if (objB02 != mf0Var3) {
                        bh3Var2 = bh3Var;
                    }
                    return mf0Var3;
                }
                if (i6 != 1) {
                    if (i6 != 2) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    return xl4.a;
                }
                bh3Var = (bh3) this.z0;
                bh3 bh3Var6 = (bh3) this.y0;
                n12.S(obj);
                bh3Var2 = bh3Var6;
                objB02 = obj;
                bh3Var.b = objB02;
                Runnable runnable = (Runnable) this.A0;
                fa2 fa2Var = bypassConfigActivity.b;
                q92 q92Var = q92.z;
                gm0 gm0Var3 = qv0.a;
                tq1 tq1Var = qf2.a.X;
                cf0 cf0Var = this.f;
                cf0Var.getClass();
                boolean zQ0 = tq1Var.q0(cf0Var);
                if (!zQ0) {
                    q92 q92Var2 = fa2Var.c;
                    if (q92Var2 == q92.b) {
                        vp1.m();
                        return null;
                    }
                    if (q92Var2.compareTo(q92Var) >= 0) {
                        y3 y3Var2 = bypassConfigActivity.S0;
                        if (y3Var2 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((LoadingIndicator) y3Var2.h).setVisibility(0);
                        y3 y3Var3 = bypassConfigActivity.S0;
                        if (y3Var3 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((Toolbar) y3Var3.c).setSubtitle(bypassConfigActivity.getString(R.string.loading));
                        String str3 = bypassConfigActivity.U0;
                        if (str3 != null) {
                            Iterable iterable = (Iterable) bh3Var2.b;
                            ArrayList arrayList2 = new ArrayList();
                            for (Object obj4 : iterable) {
                                xs xsVar = (xs) obj4;
                                if (!p44.o0(xsVar.b, str3, true)) {
                                    String str4 = xsVar.a.packageName;
                                    str4.getClass();
                                    if (p44.o0(str4, str3, true)) {
                                    }
                                }
                                arrayList2.add(obj4);
                            }
                            bh3Var2.b = arrayList2;
                        }
                        if (((List) bh3Var2.b).isEmpty() && ((str = bypassConfigActivity.U0) == null || str.length() == 0)) {
                            y3 y3Var4 = bypassConfigActivity.S0;
                            if (y3Var4 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((TextView) y3Var4.f).setVisibility(0);
                            y3 y3Var5 = bypassConfigActivity.S0;
                            if (y3Var5 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((MaterialButton) y3Var5.e).setVisibility(0);
                        } else {
                            y3 y3Var6 = bypassConfigActivity.S0;
                            if (y3Var6 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((TextView) y3Var6.f).setVisibility(8);
                            y3 y3Var7 = bypassConfigActivity.S0;
                            if (y3Var7 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((MaterialButton) y3Var7.e).setVisibility(8);
                        }
                        bypassConfigActivity.E((List) bh3Var2.b);
                        bypassConfigActivity.X0.s((List) bh3Var2.b, new g33(bypassConfigActivity, bh3Var2, runnable, 1, false));
                    }
                    return xl4.a;
                }
                nt ntVar = new nt(i, bypassConfigActivity, bh3Var2, runnable);
                this.y0 = null;
                this.z0 = null;
                this.Y = 2;
                break;
            case 3:
                mf0 mf0Var4 = mf0.b;
                int i8 = this.Y;
                if (i8 == 0) {
                    n12.S(obj);
                    m20 m20Var = (m20) this.y0;
                    gx4 gx4Var = (gx4) this.z0;
                    this.Y = 1;
                    objA = ic0.a(m20Var, gx4Var, this);
                    if (objA == mf0Var4) {
                        return mf0Var4;
                    }
                } else {
                    if (i8 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    objA = obj;
                }
                ((AtomicInteger) this.Z).set(((Number) objA).intValue());
                ((nc2) this.A0).cancel(true);
                return xl4.a;
            case 4:
                mf0 mf0Var5 = mf0.b;
                int i9 = this.Y;
                if (i9 != 0) {
                    if (i9 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.y0;
                tc2 tc2Var = (tc2) this.z0;
                m20 m20Var2 = (m20) this.Z;
                gx4 gx4Var2 = (gx4) this.A0;
                this.Y = 1;
                Object objD = constraintTrackingWorker.d(tc2Var, m20Var2, gx4Var2, this);
                return objD == mf0Var5 ? mf0Var5 : objD;
            case 5:
                xl4 xl4Var2 = xl4.a;
                mf0 mf0Var6 = mf0.b;
                int i10 = this.Y;
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                    String strN = ha0.n("All servers failed: ", e.getMessage());
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "DoHResolver", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("DoHResolver", strN, null);
                    }
                }
                if (i10 == 0) {
                    n12.S(obj);
                    byte[] bArr = (byte[]) this.y0;
                    i = bArr.length >= 2 ? ((bArr[0] & 255) << 8) | (bArr[1] & 255) : 0;
                    DefaultDnsQuery defaultDnsQueryR = je.R(bArr);
                    try {
                        pj2 pj2Var = xw0.e;
                        if (defaultDnsQueryR != null) {
                            dnsQuestion = (DnsQuestion) defaultDnsQueryR.recordAt(DnsSection.QUESTION);
                            break;
                        } else {
                            dnsQuestion = null;
                        }
                        if (defaultDnsQueryR != null) {
                            defaultDnsQueryR.release();
                        }
                        String strG0 = (dnsQuestion == null || (strName = dnsQuestion.name()) == null) ? null : p44.G0(".", strName);
                        DnsRecordType dnsRecordTypeType = dnsQuestion != null ? dnsQuestion.type() : null;
                        if (strG0 != null && dnsRecordTypeType != null && (e03VarC = ((xw0) this.z0).c(strG0, dnsRecordTypeType, i)) != null) {
                            ((o32) this.A0).k((DefaultDnsResponse) e03VarC.b, (byte[]) e03VarC.f);
                        } else if (strG0 != null) {
                            xw0 xw0Var = (xw0) this.z0;
                            byte[] bArr2 = (byte[]) this.y0;
                            List list2 = (List) this.Z;
                            this.Y = 1;
                            xw0Var.getClass();
                            objH = p95.h(new aj(list2, xw0Var, strG0, bArr2, null), this);
                            if (objH == mf0Var6) {
                                return mf0Var6;
                            }
                        }
                        return xl4Var2;
                    } finally {
                    }
                } else {
                    if (i10 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    objH = obj;
                }
                e03 e03Var = (e03) objH;
                if (e03Var != null) {
                    xw0 xw0Var2 = (xw0) this.z0;
                    o32 o32Var = (o32) this.A0;
                    DefaultDnsResponse defaultDnsResponse = (DefaultDnsResponse) e03Var.b;
                    byte[] bArr3 = (byte[]) e03Var.f;
                    xw0Var2.a(defaultDnsResponse, bArr3);
                    o32Var.k(defaultDnsResponse, bArr3);
                }
                return xl4Var2;
            case 6:
                mf0 mf0Var7 = mf0.b;
                int i11 = this.Y;
                if (i11 == 0) {
                    n12.S(obj);
                    ag1Var = (ag1) this.y0;
                    bh3Var3 = new bh3();
                    bh3Var3.b = null;
                    this.y0 = ag1Var;
                    this.z0 = bh3Var3;
                    this.Y = 1;
                    if (ag1Var.h(null, this) != mf0Var7) {
                    }
                    return mf0Var7;
                }
                if (i11 != 1) {
                    if (i11 == 2) {
                        n12.S(obj);
                        return xl4.a;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bh3Var3 = (bh3) this.z0;
                ag1Var = (ag1) this.y0;
                n12.S(obj);
                pg1 pg1Var = (pg1) this.Z;
                eg1 eg1Var = new eg1(bh3Var3, (bv) this.A0, ag1Var, i3);
                this.y0 = null;
                this.z0 = null;
                this.Y = 2;
                break;
            case 7:
                mf0 mf0Var8 = mf0.b;
                int i12 = this.Y;
                if (i12 == 0) {
                    n12.S(obj);
                    Object obj5 = ((l30) this.y0).a;
                    bh3Var4 = (bh3) this.Z;
                    boolean z = obj5 instanceof k30;
                    if (!z) {
                        bh3Var4.b = obj5;
                    }
                    ag1 ag1Var3 = (ag1) this.A0;
                    if (z) {
                        j30 j30Var = obj5 instanceof j30 ? (j30) obj5 : null;
                        Throwable th2 = j30Var != null ? j30Var.a : null;
                        if (th2 != null) {
                            throw th2;
                        }
                        Object obj6 = bh3Var4.b;
                        if (obj6 != null) {
                            Object obj7 = obj6 != at2.a ? obj6 : null;
                            this.y0 = obj5;
                            this.z0 = bh3Var4;
                            this.Y = 1;
                            if (ag1Var3.h(obj7, this) == mf0Var8) {
                                return mf0Var8;
                            }
                            bh3Var5 = bh3Var4;
                        }
                        bh3Var4.b = at2.c;
                    }
                    return xl4.a;
                }
                if (i12 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bh3Var5 = (bh3) this.z0;
                n12.S(obj);
                bh3Var4 = bh3Var5;
                bh3Var4.b = at2.c;
                return xl4.a;
            case 8:
                xl4 xl4Var3 = xl4.a;
                mf0 mf0Var9 = mf0.b;
                int i13 = this.Y;
                if (i13 == 0) {
                    n12.S(obj);
                    ((LoadingIndicator) ((iv1) this.y0).A).setVisibility(0);
                    ((MaterialButton) ((iv1) this.y0).X).setEnabled(false);
                    ((MaterialButton) ((iv1) this.y0).z).setEnabled(false);
                    ko1 ko1Var = ko1.a;
                    Uri uri2 = (Uri) this.A0;
                    ed4 ed4Var = new ed4(25, (po1) this.z0, (iv1) this.y0, (bh3) this.Z);
                    this.Y = 1;
                    String str5 = "verifyAndPrepareFile: " + uri2;
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "GeoIPConfig", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str5);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("GeoIPConfig", str5, null);
                    }
                    gm0 gm0Var4 = qv0.a;
                    Object objB03 = ji0.b0(qf2.a, new hj(ed4Var, uri2, objArr2 == true ? 1 : 0, 18), this);
                    if (objB03 != mf0Var9) {
                        objB03 = xl4Var3;
                    }
                    if (objB03 == mf0Var9) {
                        return mf0Var9;
                    }
                } else {
                    if (i13 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4Var3;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                po1 po1Var = (po1) this.Z;
                String str6 = (String) this.z0;
                String str7 = (String) this.y0;
                xl4 xl4Var4 = xl4.a;
                mf0 mf0Var10 = mf0.b;
                int i14 = this.Y;
                if (i14 == 0) {
                    n12.S(obj);
                    if (str7 != null && n12.c(str6, str7)) {
                        ko1 ko1Var2 = ko1.a;
                        this.Y = 1;
                        gm0 gm0Var5 = qv0.a;
                        Object objB04 = ji0.b0(pl0.z, new p81(str7, objArr3 == true ? 1 : 0, i2), this);
                        if (objB04 != mf0Var10) {
                            objB04 = xl4Var4;
                        }
                        break;
                    } else {
                        String str8 = (str6 == null || str6.length() == 0) ? null : str6;
                        if (str8 != null) {
                            ko1 ko1Var3 = ko1.a;
                            boolean z2 = str8.equals(ko1.b.getString(RtspHeaders.Values.URL, null));
                            iv1 iv1Var = (iv1) this.A0;
                            this.Y = 2;
                            ((LoadingIndicator) iv1Var.A).setVisibility(0);
                            ((MaterialButton) iv1Var.X).setEnabled(false);
                            ((MaterialButton) iv1Var.z).setEnabled(false);
                            ji0.B(uf2.t(po1Var), null, null, new oo1(str8, z2, po1Var, iv1Var, (ge0) null), 3);
                        }
                        iv1 iv1Var2 = (iv1) this.A0;
                        this.Y = 2;
                        ((LoadingIndicator) iv1Var2.A).setVisibility(0);
                        ((MaterialButton) iv1Var2.X).setEnabled(false);
                        ((MaterialButton) iv1Var2.z).setEnabled(false);
                        ji0.B(uf2.t(po1Var), null, null, new oo1(str8, z2, po1Var, iv1Var2, (ge0) null), 3);
                        break;
                    }
                    return mf0Var10;
                }
                if (i14 == 1) {
                    n12.S(obj);
                    Dialog dialog = po1Var.C0;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    p95.C(R.string.pls_restart_app_to_take_effect, new Object[0]);
                } else {
                    if (i14 != 2) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4Var4;
            case 10:
                az2 az2Var = (az2) this.A0;
                mf0 mf0Var11 = mf0.b;
                int i15 = this.Y;
                if (i15 == 0) {
                    n12.S(obj);
                    hx3Var = (hx3) this.y0;
                    if (!az2Var.f.compareAndSet(false, true)) {
                        xe.q("Attempt to collect twice from pageEventFlow, which is an illegal operation. Did you forget to call Flow<PagingData<*>>.cachedIn(coroutineScope)?");
                        return null;
                    }
                    ji0.B(hx3Var, null, null, new hj(az2Var, hx3Var, objArr6 == true ? 1 : 0, 26), 3);
                    xp xpVarA = uf2.a(0, null, null, 6);
                    ji0.B(hx3Var, null, null, new hj(az2Var, xpVarA, objArr5 == true ? 1 : 0, 27), 3);
                    ji0.B(hx3Var, null, null, new uf(xpVarA, az2Var, objArr4 == true ? 1 : 0, 15), 3);
                    this.y0 = hx3Var;
                    this.z0 = null;
                    this.Z = null;
                    this.Y = 2;
                    if (az2Var.c(this) != mf0Var11) {
                    }
                    return mf0Var11;
                }
                if (i15 == 1) {
                    bz2 bz2Var3 = (bz2) ((yn2) this.Z);
                    if (((bz2) this.z0) != null) {
                        st4.n();
                        return null;
                    }
                    n12.S(obj);
                    bz2Var3.b.a(null);
                    throw null;
                }
                if (i15 != 2) {
                    if (i15 != 3) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    yn2Var = (yn2) this.Z;
                    bz2Var = (bz2) this.z0;
                    hx3Var = (hx3) this.y0;
                    n12.S(obj);
                    try {
                        fd2VarK = bz2Var.b.j.k(hd2.b);
                        yn2Var.n(null);
                        if (!(fd2VarK instanceof cd2)) {
                            az2Var.k(hx3Var);
                        }
                        return xl4.a;
                    } finally {
                    }
                }
                hx3 hx3Var2 = (hx3) this.y0;
                n12.S(obj);
                hx3Var = hx3Var2;
                bz2Var = az2Var.h;
                yn2 yn2Var3 = bz2Var.a;
                this.y0 = hx3Var;
                this.z0 = bz2Var;
                this.Z = yn2Var3;
                this.Y = 3;
                if (yn2Var3.g(this) != mf0Var11) {
                    yn2Var = yn2Var3;
                    fd2VarK = bz2Var.b.j.k(hd2.b);
                    yn2Var.n(null);
                    if (!(fd2VarK instanceof cd2)) {
                    }
                    return xl4.a;
                }
                return mf0Var11;
            case 11:
                mf0 mf0Var12 = mf0.b;
                int i16 = this.Y;
                try {
                    if (i16 == 0) {
                        n12.S(obj);
                        ag1Var2 = (ag1) this.y0;
                        bz2Var2 = ((az2) this.A0).h;
                        yn2Var2 = bz2Var2.a;
                        this.y0 = bz2Var2;
                        this.z0 = yn2Var2;
                        this.Z = ag1Var2;
                        this.Y = 1;
                        if (yn2Var2.g(this) != mf0Var12) {
                        }
                        return mf0Var12;
                    }
                    if (i16 != 1) {
                        if (i16 == 2) {
                            n12.S(obj);
                            return xl4.a;
                        }
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ag1Var2 = (ag1) this.Z;
                    yn2Var2 = (yn2) this.z0;
                    bz2Var2 = (bz2) this.y0;
                    n12.S(obj);
                    gd2 gd2VarO = bz2Var2.b.j.O();
                    yn2Var2.n(null);
                    iy2 iy2Var = new iy2(gd2VarO, null);
                    this.y0 = null;
                    this.z0 = null;
                    this.Z = null;
                    this.Y = 2;
                } finally {
                }
                break;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                xl4 xl4Var5 = xl4.a;
                String str9 = (String) this.Z;
                d83 d83Var = (d83) this.y0;
                mf0 mf0Var13 = mf0.b;
                int i17 = this.Y;
                try {
                    try {
                        if (i17 == 0) {
                            n12.S(obj);
                            y3 y3Var8 = d83Var.b;
                            y3Var8.getClass();
                            ((LinearProgressIndicator) y3Var8.g).e();
                            e1 e1Var = d73.a;
                            p12 p12VarC = d73.c((String) this.z0, str9, ((x53) this.A0).getMessage());
                            this.Y = 1;
                            gm0 gm0Var6 = qv0.a;
                            Object objB05 = ji0.b0(pl0.z, new gd(p12VarC, str9, objArr7 == true ? 1 : 0, 14), this);
                            if (objB05 != mf0Var13) {
                                objB05 = xl4Var5;
                            }
                            if (objB05 == mf0Var13) {
                                return mf0Var13;
                            }
                        } else {
                            if (i17 != 1) {
                                xe.q("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            n12.S(obj);
                        }
                        y3 y3Var9 = d83Var.b;
                        y3Var9.getClass();
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var9.a;
                        coordinatorLayout.getClass();
                        r25.R(coordinatorLayout, R.string.invalid_profile_imported, new Object[0]);
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        CharSequence text = d83Var.getText(R.string.unknown_error);
                        text.getClass();
                        d83Var.o(e2, text, null, null, null);
                        break;
                    }
                    return xl4Var5;
                } finally {
                    y3 y3Var10 = d83Var.b;
                    y3Var10.getClass();
                    ((LinearProgressIndicator) y3Var10.g).b();
                }
            case 13:
                mf0 mf0Var14 = mf0.b;
                int i18 = this.Y;
                if (i18 == 0) {
                    n12.S(obj);
                    lf0 lf0Var = (lf0) this.y0;
                    xp xpVarA2 = uf2.a(0, null, null, 6);
                    v32VarB = ji0.B(lf0Var, null, null, new w53(xpVarA2, (Function2) this.A0, objArr8 == true ? 1 : 0, i), 3);
                    rpVar = new rp(xpVarA2);
                } else {
                    if (i18 == 1) {
                        rpVar2 = (rp) this.z0;
                        v32 v32Var2 = (v32) this.y0;
                        n12.S(obj);
                        v32Var = v32Var2;
                        objB = obj;
                        if (((Boolean) objB).booleanValue()) {
                            v32Var.g(null);
                            return xl4.a;
                        }
                        Object objC = rpVar2.c();
                        ag1 ag1Var4 = (ag1) this.Z;
                        this.y0 = v32Var;
                        this.z0 = rpVar2;
                        this.Y = 2;
                        if (ag1Var4.h(objC, this) != mf0Var14) {
                            v32 v32Var3 = v32Var;
                            rpVar = rpVar2;
                            v32VarB = v32Var3;
                        }
                        return mf0Var14;
                    }
                    if (i18 != 2) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    rp rpVar3 = (rp) this.z0;
                    v32 v32Var4 = (v32) this.y0;
                    n12.S(obj);
                    rpVar = rpVar3;
                    v32VarB = v32Var4;
                }
                this.y0 = v32VarB;
                this.z0 = rpVar;
                this.Y = 1;
                objB = rpVar.b(this);
                if (objB != mf0Var14) {
                    rp rpVar4 = rpVar;
                    v32Var = v32VarB;
                    rpVar2 = rpVar4;
                    if (((Boolean) objB).booleanValue()) {
                    }
                }
                return mf0Var14;
            case 14:
                mf0 mf0Var15 = mf0.b;
                int i19 = this.Y;
                if (i19 == 0) {
                    n12.S(obj);
                    zz3 zz3Var = (zz3) this.y0;
                    String str10 = (String) this.z0;
                    List list3 = (List) this.Z;
                    ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.A0;
                    this.Y = 1;
                    if (zz3Var.e(str10, list3, concurrentHashMap, this) == mf0Var15) {
                        return mf0Var15;
                    }
                } else {
                    if (i19 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return r(obj);
            default:
                String str11 = ((gx4) this.z0).c;
                tc2 tc2Var2 = (tc2) this.y0;
                mf0 mf0Var16 = mf0.b;
                int i20 = this.Y;
                if (i20 == 0) {
                    n12.S(obj);
                    yv yvVarA = tc2Var2.a();
                    this.Y = 1;
                    objA2 = zx4.a(yvVarA, tc2Var2, this);
                    if (objA2 != mf0Var16) {
                    }
                    return mf0Var16;
                }
                if (i20 != 1) {
                    if (i20 == 2) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                objA2 = obj;
                ni1 ni1Var = (ni1) objA2;
                if (ni1Var == null) {
                    xe.q(ha0.o("Worker was marked important (", str11, ") but did not provide ForegroundInfo"));
                    return null;
                }
                ue2.g().a(sw4.a, "Updating notification for " + str11);
                uw4 uw4Var = (uw4) this.Z;
                Context context = (Context) this.A0;
                UUID uuid = tc2Var2.b.a;
                la laVar = (la) uw4Var.a.a;
                tw4 tw4Var = new tw4(uw4Var, uuid, ni1Var, context);
                laVar.getClass();
                yv yvVarM = fx3.m(new ed(i, laVar, tw4Var));
                this.Y = 2;
                Object objK = gb4.k(yvVarM, this);
                if (objK != mf0Var16) {
                    return objK;
                }
                return mf0Var16;
        }
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
