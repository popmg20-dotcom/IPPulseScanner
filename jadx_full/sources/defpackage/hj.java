package defpackage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.VpnService;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.FileProvider;
import com.getsurfboard.R;
import com.getsurfboard.backup.model.BackupSection;
import com.getsurfboard.ui.activity.DeeplinkActivity;
import com.getsurfboard.ui.fragment.MemoryUsageFragment;
import com.getsurfboard.ui.fragment.ProfileAddMethodsFragment;
import com.getsurfboard.ui.service.SurfboardVpn;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.io.File;
import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
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
    */
    private final Object r(Object obj) {
        h54 h54Var;
        zf1 zf1Var = (zf1) this.Z;
        hv3 hv3Var = (hv3) this.y0;
        mf0 mf0Var = mf0.b;
        int i = this.Y;
        ge0 ge0Var = null;
        int i2 = 2;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    n12.S(obj);
                    this.Y = 3;
                } else if (i != 3 && i != 4) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
            }
            n12.S(obj);
            return xl4.a;
        }
        n12.S(obj);
        if (vv3.b == vv3.a) {
            this.Y = 1;
        } else {
            synchronized (hv3Var) {
                h54Var = hv3Var.A;
                if (h54Var == null) {
                    int i3 = hv3Var.f;
                    h54Var = new h54(1, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, jp.f);
                    h54Var.p(Integer.valueOf(i3));
                    hv3Var.A = h54Var;
                }
            }
            od odVar = new od(i2, ge0Var, i2);
            this.Y = 2;
            if (ye.p(h54Var, odVar, this) != mf0Var) {
                this.Y = 3;
            }
        }
        return mf0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object s(Object obj) {
        int i = this.Y;
        if (i == 0) {
            n12.S(obj);
            tf2 tf2Var = (tf2) this.Z;
            Uri uri = (Uri) this.y0;
            r92 lifecycle = tf2Var.getLifecycle();
            gm0 gm0Var = qv0.a;
            tq1 tq1Var = qf2.a.X;
            cf0 cf0Var = this.f;
            cf0Var.getClass();
            boolean zQ0 = tq1Var.q0(cf0Var);
            q92 q92Var = q92.X;
            if (zQ0) {
                kt ktVar = new kt(4, tf2Var, uri);
                this.Y = 1;
                Object objV = ji0.V(lifecycle, q92Var, zQ0, tq1Var, ktVar, this);
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
                    tf2Var.l(R.id.navigation_profiles);
                    d83 d83Var = tf2Var.A;
                    if (d83Var != null) {
                        String string = uri.toString();
                        string.getClass();
                        d83.l(d83Var, string);
                    }
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object t(Object obj) {
        int i = this.Y;
        if (i == 0) {
            n12.S(obj);
            tf2 tf2Var = (tf2) this.Z;
            String str = (String) this.y0;
            r92 lifecycle = tf2Var.getLifecycle();
            gm0 gm0Var = qv0.a;
            tq1 tq1Var = qf2.a.X;
            cf0 cf0Var = this.f;
            cf0Var.getClass();
            boolean zQ0 = tq1Var.q0(cf0Var);
            q92 q92Var = q92.X;
            if (zQ0) {
                kt ktVar = new kt(5, tf2Var, str);
                this.Y = 1;
                Object objV = ji0.V(lifecycle, q92Var, zQ0, tq1Var, ktVar, this);
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
                    tf2Var.l(R.id.navigation_profiles);
                    d83 d83Var = tf2Var.A;
                    if (d83Var != null) {
                        d83.l(d83Var, str);
                    }
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

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e6, code lost:
    
        if (defpackage.ji0.V(r8, r9, r10, r11, r12, r14) == r7) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object u(Object obj) {
        View view = (View) this.y0;
        MemoryUsageFragment memoryUsageFragment = (MemoryUsageFragment) this.Z;
        int i = this.Y;
        int i2 = 2;
        int i3 = 0;
        ge0 ge0Var = null;
        mf0 mf0Var = mf0.b;
        if (i == 0) {
            n12.S(obj);
            p95.C(R.string.export_hprof_toast, new Object[0]);
            Context context = view.getContext();
            context.getClass();
            this.Y = 1;
            gm0 gm0Var = qv0.a;
            obj = ji0.b0(pl0.z, new hk2(context, ge0Var, i3), this);
            if (obj != mf0Var) {
            }
            return mf0Var;
        }
        if (i != 1) {
            if (i == 2) {
                n12.S(obj);
                return xl4.a;
            }
            xe.q("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        n12.S(obj);
        File file = (File) obj;
        r92 lifecycle = memoryUsageFragment.getLifecycle();
        gm0 gm0Var2 = qv0.a;
        tq1 tq1Var = qf2.a.X;
        cf0 cf0Var = this.f;
        cf0Var.getClass();
        boolean zQ0 = tq1Var.q0(cf0Var);
        q92 q92Var = q92.z;
        if (!zQ0) {
            if (lifecycle.b() == q92.b) {
                vp1.m();
                return null;
            }
            if (lifecycle.b().compareTo(q92Var) >= 0) {
                if (file == null) {
                    p95.C(R.string.unknown_error, new Object[0]);
                } else {
                    Uri uriC = FileProvider.c(view.getContext(), view.getContext().getPackageName() + ".files_provider", file);
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.STREAM", uriC);
                    intent.setType(HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE);
                    intent.addFlags(1);
                    try {
                        view.getContext().startActivity(Intent.createChooser(intent, memoryUsageFragment.getString(R.string.share_hprof)));
                    } catch (ActivityNotFoundException e) {
                        e.printStackTrace();
                        p95.C(R.string.share_failed, new Object[0]);
                    }
                }
            }
            return xl4.a;
        }
        nt ntVar = new nt(i2, file, view, memoryUsageFragment);
        this.Y = 2;
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
    */
    public final Object p(Object obj) throws Throwable {
        Object objA;
        Object objB0;
        Object objB02;
        Throwable thA;
        List listK;
        hu2 hu2Var;
        Object objB;
        int i = 28;
        int i2 = 7;
        Object obj2 = 6;
        char c = 6;
        char c2 = 6;
        char c3 = 6;
        char c4 = 6;
        int i3 = 2;
        int i4 = 1;
        ge0 ge0Var = null;
        switch (this.X) {
            case 0:
                xl4 xl4Var = xl4.a;
                jj jjVar = (jj) this.Z;
                mf0 mf0Var = mf0.b;
                int i5 = this.Y;
                if (i5 == 0) {
                    n12.S(obj);
                    Uri uri = (Uri) this.y0;
                    this.Y = 1;
                    objA = jjVar.a(uri, this);
                    if (objA == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i5 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    objA = obj;
                }
                k03 k03Var = (k03) objA;
                if (k03Var != null) {
                    Context contextRequireContext = jjVar.a.requireContext();
                    contextRequireContext.getClass();
                    zf2 zf2Var = new zf2(i2, contextRequireContext);
                    Set setA = k03Var.a();
                    gj gjVar = new gj(i, jjVar, k03Var);
                    r90 r90VarH = r90.h(LayoutInflater.from(contextRequireContext));
                    MaterialCheckBox materialCheckBox = (MaterialCheckBox) r90VarH.d;
                    MaterialCheckBox materialCheckBox2 = (MaterialCheckBox) r90VarH.e;
                    MaterialCheckBox materialCheckBox3 = (MaterialCheckBox) r90VarH.g;
                    MaterialCheckBox materialCheckBox4 = (MaterialCheckBox) r90VarH.f;
                    ((TextInputLayout) r90VarH.c).setVisibility(8);
                    materialCheckBox4.setVisibility(setA.contains(BackupSection.PROFILES) ? 0 : 8);
                    materialCheckBox3.setVisibility(setA.contains(BackupSection.SETTINGS) ? 0 : 8);
                    materialCheckBox2.setVisibility(setA.contains(BackupSection.METADATA) ? 0 : 8);
                    materialCheckBox.setVisibility(setA.contains(BackupSection.HOSTS) ? 0 : 8);
                    wh2 wh2Var = new wh2(contextRequireContext);
                    wh2Var.x(R.string.backup_select_content);
                    wh2Var.y((LinearLayout) r90VarH.a);
                    wh2Var.u(R.string.cancel, null);
                    wh2Var.w(R.string.import_, new li(gjVar, zf2Var, r90VarH));
                    u6 u6VarH = wh2Var.h();
                    ni niVar = new ni(zf2Var, r90VarH, u6VarH);
                    materialCheckBox4.setOnCheckedChangeListener(niVar);
                    materialCheckBox3.setOnCheckedChangeListener(niVar);
                    materialCheckBox2.setOnCheckedChangeListener(niVar);
                    materialCheckBox.setOnCheckedChangeListener(niVar);
                    u6VarH.setOnShowListener(new mi(zf2Var, r90VarH, u6VarH, i4));
                    u6VarH.show();
                }
                return xl4Var;
            case 1:
                mf0 mf0Var2 = mf0.b;
                int i6 = this.Y;
                if (i6 != 0) {
                    if (i6 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    throw new t80();
                }
                n12.S(obj);
                hv3 hv3Var = pe4.a;
                tf tfVar = new tf(i4, (ek) this.Z, (View) this.y0);
                this.Y = 1;
                hv3Var.a(tfVar, this);
                return mf0Var2;
            case 2:
                mf0 mf0Var3 = mf0.b;
                int i7 = this.Y;
                if (i7 == 0) {
                    n12.S(obj);
                    q53 q53Var = (q53) this.Z;
                    hk hkVar = (hk) this.y0;
                    gk gkVar = new gk(hkVar, q53Var);
                    bc0 bc0Var = hkVar.a;
                    synchronized (bc0Var.c) {
                        try {
                            if (bc0Var.d.add(gkVar)) {
                                if (bc0Var.d.size() == 1) {
                                    bc0Var.e = bc0Var.a();
                                    ue2.g().a(cc0.a, bc0Var.getClass().getSimpleName() + ": initial state = " + bc0Var.e);
                                    bc0Var.c();
                                }
                                Object pc0Var = hkVar.e(bc0Var.e) ? new pc0(hkVar.d()) : oc0.a;
                                q53Var.getClass();
                                q53Var.e(pc0Var);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    qi qiVar = new qi(i4, (hk) this.y0, gkVar);
                    this.Y = 1;
                    if (je.g(q53Var, qiVar, this) == mf0Var3) {
                        return mf0Var3;
                    }
                } else {
                    if (i7 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 3:
                mf0 mf0Var4 = mf0.b;
                int i8 = this.Y;
                if (i8 == 0) {
                    n12.S(obj);
                    ag1 ag1Var = (ag1) this.Z;
                    zg3 zg3Var = new zg3();
                    zg3Var.b = Integer.MIN_VALUE;
                    pg1 pg1Var = new pg1((f54) ((v92) this.y0).z, new tu(i3, ge0Var, i), i4);
                    vu vuVar = new vu(zg3Var, ag1Var);
                    this.Y = 1;
                    if (pg1Var.a(vuVar, this) == mf0Var4) {
                        return mf0Var4;
                    }
                } else {
                    if (i8 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 4:
                xl4 xl4Var2 = xl4.a;
                mf0 mf0Var5 = mf0.b;
                int i9 = this.Y;
                if (i9 == 0) {
                    n12.S(obj);
                    zf1 zf1Var = (zf1) this.Z;
                    xu xuVar = new xu(i, (v92) this.y0);
                    this.Y = 1;
                    Object objA2 = zf1Var.a(new vu(xuVar, new zg3()), this);
                    if (objA2 != mf0Var5) {
                        objA2 = xl4Var2;
                    }
                    if (objA2 == mf0Var5) {
                        return mf0Var5;
                    }
                } else {
                    if (i9 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4Var2;
            case 5:
                mf0 mf0Var6 = mf0.b;
                int i10 = this.Y;
                if (i10 == 0) {
                    n12.S(obj);
                    q53 q53Var2 = (q53) this.Z;
                    b30 b30Var = (b30) this.y0;
                    this.Y = 1;
                    if (b30Var.d(q53Var2, this) == mf0Var6) {
                        return mf0Var6;
                    }
                } else {
                    if (i10 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 6:
                mf0 mf0Var7 = mf0.b;
                int i11 = this.Y;
                if (i11 == 0) {
                    n12.S(obj);
                    ag1 ag1Var2 = (ag1) this.Z;
                    c30 c30Var = (c30) this.y0;
                    this.Y = 1;
                    if (c30Var.h(ag1Var2, this) == mf0Var7) {
                        return mf0Var7;
                    }
                } else {
                    if (i11 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 7:
                j80 j80Var = (j80) this.Z;
                mf0 mf0Var8 = mf0.b;
                int i12 = this.Y;
                if (i12 == 0) {
                    n12.S(obj);
                    sl3 sl3Var = (sl3) j80Var.e;
                    pl3 pl3Var = (pl3) j80Var.d;
                    this.Y = 1;
                    objB0 = ji0.b0(((ce0) pl3Var.f()).b, new w53(pl3Var, new uf(fw.y(new StringBuilder("SELECT COUNT(*) FROM ( "), sl3Var.a, " )"), sl3Var, ge0Var, 22), ge0Var, i2), this);
                    if (objB0 != mf0Var8) {
                    }
                    return mf0Var8;
                }
                if (i12 != 1) {
                    if (i12 == 2) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                objB0 = obj;
                int iIntValue = ((Number) objB0).intValue();
                ((AtomicInteger) j80Var.f).set(iIntValue);
                wz2 wz2Var = (wz2) this.y0;
                sl3 sl3Var2 = (sl3) j80Var.e;
                sp spVar = (sp) j80Var.c;
                this.Y = 2;
                Object objJ = uf2.J(wz2Var, sl3Var2, iIntValue, spVar, this);
                if (objJ != mf0Var8) {
                    return objJ;
                }
                return mf0Var8;
            case 8:
                mf0 mf0Var9 = mf0.b;
                int i13 = this.Y;
                if (i13 != 0) {
                    if (i13 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                Function2 function2 = (Function2) this.Z;
                z13 z13Var = (z13) this.y0;
                this.Y = 1;
                Object objK = function2.k(z13Var, this);
                return objK == mf0Var9 ? mf0Var9 : objK;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                mf0 mf0Var10 = mf0.b;
                int i14 = this.Y;
                if (i14 != 0) {
                    if (i14 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                Function2 function22 = (Function2) this.Z;
                Object obj3 = ((bh3) this.y0).b;
                this.Y = 1;
                Object objK2 = function22.k(obj3, this);
                return objK2 == mf0Var10 ? mf0Var10 : objK2;
            case 10:
                xl4 xl4Var3 = xl4.a;
                mf0 mf0Var11 = mf0.b;
                int i15 = this.Y;
                if (i15 == 0) {
                    n12.S(obj);
                    xh0 xh0Var = (xh0) this.Z;
                    Context context = (Context) this.y0;
                    r92 lifecycle = xh0Var.getLifecycle();
                    q92 q92Var = q92.A;
                    gm0 gm0Var = qv0.a;
                    tq1 tq1Var = qf2.a.X;
                    cf0 cf0Var = this.f;
                    cf0Var.getClass();
                    boolean zQ0 = tq1Var.q0(cf0Var);
                    if (zQ0) {
                        kt ktVar = new kt(i4, context, xh0Var);
                        this.Y = 1;
                        if (ji0.V(lifecycle, q92Var, zQ0, tq1Var, ktVar, this) == mf0Var11) {
                            return mf0Var11;
                        }
                    } else {
                        if (lifecycle.b() == q92.b) {
                            vp1.m();
                            return null;
                        }
                        if (lifecycle.b().compareTo(q92Var) >= 0) {
                            if (n12.c(ws4.a.d(), Boolean.TRUE)) {
                                zw1.d(context);
                            } else {
                                try {
                                    r4 r4Var = xh0Var.f;
                                    if (r4Var == null) {
                                        n12.T("vpnPermissionLauncher");
                                        throw null;
                                    }
                                    r4Var.a(xl4Var3);
                                } catch (ActivityNotFoundException e) {
                                    e.printStackTrace();
                                    j80 j80Var2 = xh0Var.b;
                                    j80Var2.getClass();
                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) j80Var2.a;
                                    coordinatorLayout.getClass();
                                    r25.R(coordinatorLayout, R.string.vpn_module_missing, new Object[0]);
                                }
                            }
                        }
                    }
                } else {
                    if (i15 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4Var3;
            case 11:
                mf0 mf0Var12 = mf0.b;
                int i16 = this.Y;
                if (i16 != 0) {
                    if (i16 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                Function2 function23 = (Function2) this.Z;
                Object obj4 = ((fi0) this.y0).b;
                this.Y = 1;
                Object objK3 = function23.k(obj4, this);
                return objK3 == mf0Var12 ? mf0Var12 : objK3;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                mf0 mf0Var13 = mf0.b;
                int i17 = this.Y;
                if (i17 == 0) {
                    n12.S(obj);
                    kl2 kl2Var = (kl2) this.Z;
                    lj0 lj0Var = (lj0) this.y0;
                    this.Y = 1;
                    if (lj0Var.d(kl2Var, this) == mf0Var13) {
                        return mf0Var13;
                    }
                } else {
                    if (i17 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 13:
                xl4 xl4Var4 = xl4.a;
                DeeplinkActivity deeplinkActivity = (DeeplinkActivity) this.y0;
                DeeplinkActivity deeplinkActivity2 = (DeeplinkActivity) this.Z;
                mf0 mf0Var14 = mf0.b;
                int i18 = this.Y;
                if (i18 == 0) {
                    n12.S(obj);
                    e1 e1Var = d73.a;
                    this.Y = 1;
                    gm0 gm0Var2 = qv0.a;
                    objB02 = ji0.b0(pl0.z, new lt(i3, ge0Var, c), this);
                    if (objB02 == mf0Var14) {
                        return mf0Var14;
                    }
                } else {
                    if (i18 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    objB02 = obj;
                }
                t53 t53Var = (t53) objB02;
                if (t53Var != null) {
                    try {
                        if (VpnService.prepare(deeplinkActivity) != null) {
                            xb5.c("DeeplinkActivity: VpnService.prepare(context) != null");
                            Intent intentS = p95.s(deeplinkActivity, true);
                            intentS.setFlags(intentS.getFlags() + 67108864);
                            intentS.setFlags(intentS.getFlags() + 536870912);
                            intentS.setFlags(intentS.getFlags() + 268435456);
                            deeplinkActivity2.startActivity(intentS);
                        } else {
                            p95.C(R.string.starting_vpn, new Object[0]);
                            try {
                                HashMap mapW = ji0.w(t53Var);
                                if (t23.c(R.string.setting_override_lan_share_key, false)) {
                                    String str = n12.c(t23.u(), t23.b[0]) ? "0.0.0.0" : "127.0.0.1";
                                    listK = e70.K(new InetSocketAddress(str, t23.s()), new InetSocketAddress(str, t23.v()));
                                } else {
                                    listK = null;
                                }
                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                for (ls1 ls1Var : oj0.a.s().a()) {
                                    try {
                                        String str2 = ls1Var.f;
                                        List listL0 = p44.L0(ls1Var.z, new String[]{","}, 6);
                                        ArrayList arrayList = new ArrayList(f70.Q(10, listL0));
                                        Iterator it = listL0.iterator();
                                        while (it.hasNext()) {
                                            arrayList.add(p44.U0((String) it.next()).toString());
                                            break;
                                        }
                                        String[] strArr = (String[]) arrayList.toArray(new String[0]);
                                        e03 e03VarG = ye.g(str2, (String[]) Arrays.copyOf(strArr, strArr.length), null, null, null);
                                        linkedHashMap.put(e03VarG.b, e03VarG.f);
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                boolean zH = t23.q() ? t23.H() : false;
                                Set setE = t23.q() ? t23.e(zH) : k41.b;
                                boolean z = yw1.G0;
                                Object objD = t23.d.d();
                                objD.getClass();
                                rs4 rs4Var = new rs4((xw2) objD, mapW, zH, setE, t23.c(R.string.setting_allow_lan_key, false), t23.c(R.string.setting_auto_fix_dns_poisoning_key, true), t23.i(), t23.c(R.string.setting_bypass_tls_verify_key, false), t23.c(R.string.setting_force_udp_relay_key, false), t23.c(R.string.setting_force_remote_dns_key, true), listK, t23.r(), t23.t(), t23.c(R.string.setting_allow_bypass_key, true), t23.a(), t23.G(), t23.c(R.string.setting_tcp_keep_alive_key, false), t23.j(), linkedHashMap, t23.b());
                                Intent intent = new Intent(deeplinkActivity, (Class<?>) SurfboardVpn.class);
                                k2.l(new FileOutputStream(zw1.b()), t53Var);
                                intent.putExtra("start", true);
                                intent.putExtra("vpn_config", rs4Var);
                                if (yw1.G0) {
                                    try {
                                        v9.z(deeplinkActivity, intent);
                                    } catch (SecurityException e3) {
                                        thA = uk3.a(new tk3(e3));
                                        thA.getClass();
                                        p95.D(r25.D(thA));
                                    }
                                } else {
                                    try {
                                        deeplinkActivity.startService(intent);
                                    } catch (Exception e4) {
                                        thA = uk3.a(new tk3(e4));
                                        thA.getClass();
                                        p95.D(r25.D(thA));
                                    }
                                }
                            } catch (Exception e5) {
                                thA = uk3.a(new tk3(e5));
                                thA.getClass();
                            }
                        }
                    } catch (NullPointerException e6) {
                        e6.printStackTrace();
                        p95.C(R.string.unknown_error, new Object[0]);
                    }
                    deeplinkActivity2.finish();
                    break;
                } else {
                    p95.C(R.string.no_valid_profiles_existed, new Object[0]);
                    deeplinkActivity2.finish();
                }
                return xl4Var4;
            case 14:
                mf0 mf0Var15 = mf0.b;
                int i19 = this.Y;
                if (i19 != 0) {
                    if (i19 == 1) {
                        n12.S(obj);
                        return xl4.a;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                q53 q53Var3 = (q53) this.Z;
                m24 m24Var = (m24) this.y0;
                xu xuVar2 = new xu(5, q53Var3);
                this.Y = 1;
                m24Var.a(xuVar2, this);
                return mf0Var15;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return r(obj);
            case 16:
                on2 on2Var = (on2) this.y0;
                mf0 mf0Var16 = mf0.b;
                int i20 = this.Y;
                try {
                } catch (Throwable th2) {
                    th = th2;
                }
                if (i20 == 0) {
                    n12.S(obj);
                    zn znVar = new zn(i4, (q53) this.Z);
                    try {
                        gm0 gm0Var3 = qv0.a;
                        tq1 tq1Var2 = qf2.a.X;
                        gd gdVar = new gd(on2Var, znVar, ge0Var, c2);
                        this.Z = znVar;
                        this.Y = 1;
                        if (ji0.b0(tq1Var2, gdVar, this) != mf0Var16) {
                            hu2Var = znVar;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        obj2 = znVar;
                        gm0 gm0Var4 = qv0.a;
                        tq1 tq1Var3 = qf2.a.X;
                        is2 is2Var = is2.f;
                        tq1Var3.getClass();
                        cf0 cf0VarW = tj4.W(tq1Var3, is2Var);
                        gd gdVar2 = new gd(on2Var, obj2, ge0Var, i2);
                        this.Z = th;
                        this.Y = 3;
                        if (ji0.b0(cf0VarW, gdVar2, this) != mf0Var16) {
                            throw th;
                        }
                    }
                    return mf0Var16;
                }
                if (i20 != 1) {
                    if (i20 == 2) {
                        n12.S(obj);
                        throw new t80();
                    }
                    if (i20 != 3) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Throwable th4 = (Throwable) this.Z;
                    n12.S(obj);
                    throw th4;
                }
                hu2Var = (hu2) this.Z;
                n12.S(obj);
                this.Z = hu2Var;
                this.Y = 2;
                gb4.l(this);
                return mf0Var16;
            case 17:
                vh1 vh1Var = (vh1) this.Z;
                mf0 mf0Var17 = mf0.b;
                int i21 = this.Y;
                if (i21 == 0) {
                    n12.S(obj);
                    uv uvVar = new uv(new uf(vh1Var.a, (Activity) this.y0, ge0Var, i), c41.b, -2, jp.b);
                    gm0 gm0Var5 = qv0.a;
                    zf1 zf1VarN = ji0.n(new tg1(p95.l(uvVar, qf2.a), vh1Var, i3));
                    xu xuVar3 = new xu(c3, vh1Var);
                    this.Y = 1;
                    if (zf1VarN.a(xuVar3, this) == mf0Var17) {
                        return mf0Var17;
                    }
                } else {
                    if (i21 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 18:
                ed4 ed4Var = (ed4) this.Z;
                mf0 mf0Var18 = mf0.b;
                int i22 = this.Y;
                try {
                    if (i22 == 0) {
                        n12.S(obj);
                        gm0 gm0Var6 = qv0.a;
                        pl0 pl0Var = pl0.z;
                        gt gtVar = new gt((Uri) this.y0, ge0Var, 4);
                        this.Y = 1;
                        if (ji0.b0(pl0Var, gtVar, this) == mf0Var18) {
                            return mf0Var18;
                        }
                    } else {
                        if (i22 != 1) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        n12.S(obj);
                    }
                    po1 po1Var = (po1) ed4Var.f;
                    ji0.B(uf2.t(po1Var), null, null, new ej((iv1) ed4Var.z, po1Var, (bh3) ed4Var.A, null, 4), 3);
                    break;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    po1 po1Var2 = (po1) ed4Var.f;
                    ji0.B(uf2.t(po1Var2), null, null, new mo1((iv1) ed4Var.z, e7, po1Var2, null, 0), 3);
                }
                return xl4.a;
            case 19:
                b32 b32Var = (b32) this.Z;
                ThreadLocal threadLocal = b32Var.b;
                mf0 mf0Var19 = mf0.b;
                int i23 = this.Y;
                try {
                    if (i23 == 0) {
                        n12.S(obj);
                        Object obj5 = threadLocal.get();
                        Boolean bool = Boolean.TRUE;
                        if (n12.c(obj5, bool)) {
                            xe.q("Don't call JavaDataStorage.edit() from within an existing edit() callback.\nThis causes deadlocks, and is generally indicative of a code smell.\nInstead, either pass around the initial `MutablePreferences` instance, or don't do everything in a single callback. ");
                            return null;
                        }
                        threadLocal.set(bool);
                        qi0 qi0Var = b32Var.c;
                        ah0 ah0Var = new ah0((am1) this.y0, ge0Var, i3);
                        this.Y = 1;
                        objB = qi0Var.b(new hj(ah0Var, ge0Var, i), this);
                        if (objB == mf0Var19) {
                            return mf0Var19;
                        }
                    } else {
                        if (i23 != 1) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        n12.S(obj);
                        objB = obj;
                    }
                    return (rn2) objB;
                } finally {
                    threadLocal.set(Boolean.FALSE);
                }
            case 20:
                return s(obj);
            case 21:
                return t(obj);
            case 22:
                mf0 mf0Var20 = mf0.b;
                int i24 = this.Y;
                if (i24 == 0) {
                    n12.S(obj);
                    r25 r25Var = ((nj2) this.Z).a;
                    Uri uri2 = (Uri) this.y0;
                    this.Y = 1;
                    if (r25Var.M(uri2, this) == mf0Var20) {
                        return mf0Var20;
                    }
                } else {
                    if (i24 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 23:
                return u(obj);
            case 24:
                mf0 mf0Var21 = mf0.b;
                int i25 = this.Y;
                if (i25 == 0) {
                    n12.S(obj);
                    this.Y = 1;
                    if (gb4.E(1000L, this) == mf0Var21) {
                        return mf0Var21;
                    }
                } else {
                    if (i25 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                ue2.g().a(mw4.a, "NetworkRequestConstraintController didn't receive neither onCapabilitiesChanged/onLost callback, sending `ConstraintsNotMet` after 1000 ms");
                ((q53) this.y0).e(new pc0(7));
                return xl4.a;
            case 25:
                return v(obj);
            case 26:
                return w(obj);
            case 27:
                return x(obj);
            case 28:
                return y(obj);
            default:
                mf0 mf0Var22 = mf0.b;
                int i26 = this.Y;
                if (i26 == 0) {
                    n12.S(obj);
                    ProfileAddMethodsFragment profileAddMethodsFragment = (ProfileAddMethodsFragment) this.Z;
                    String str3 = (String) this.y0;
                    r92 lifecycle2 = profileAddMethodsFragment.getLifecycle();
                    q92 q92Var2 = q92.X;
                    gm0 gm0Var7 = qv0.a;
                    tq1 tq1Var4 = qf2.a.X;
                    cf0 cf0Var2 = this.f;
                    cf0Var2.getClass();
                    boolean zQ02 = tq1Var4.q0(cf0Var2);
                    if (zQ02) {
                        kt ktVar2 = new kt(c4, profileAddMethodsFragment, str3);
                        this.Y = 1;
                        if (ji0.V(lifecycle2, q92Var2, zQ02, tq1Var4, ktVar2, this) == mf0Var22) {
                            return mf0Var22;
                        }
                    } else {
                        if (lifecycle2.b() == q92.b) {
                            vp1.m();
                            return null;
                        }
                        if (lifecycle2.b().compareTo(q92Var2) >= 0) {
                            d83 d83Var = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var != null) {
                                d83.l(d83Var, str3);
                            }
                        }
                    }
                } else {
                    if (i26 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hj(Object obj, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.y0 = obj;
    }
}
