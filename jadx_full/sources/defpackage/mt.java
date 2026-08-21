package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.FileProvider;
import androidx.fragment.app.a;
import androidx.fragment.app.u;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.getsurfboard.ui.activity.HostsListActivity;
import com.getsurfboard.ui.activity.MainActivity;
import com.getsurfboard.ui.activity.RecentRequestsActivity;
import com.getsurfboard.ui.activity.SettingsActivity;
import com.getsurfboard.ui.fragment.FdCountFragment;
import com.getsurfboard.ui.fragment.MemoryUsageFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textview.MaterialTextView;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.functions.Function2;
import org.conscrypt.FileClientSessionCache;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mt extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public /* synthetic */ Object Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mt(Object obj, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) throws Throwable {
        int i = this.X;
        mf0 mf0Var = mf0.b;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 1:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 2:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 3:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 4:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 5:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 6:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 7:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 8:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 10:
                ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return mf0Var;
            case 11:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 13:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 14:
                return ((mt) n((ge0) obj2, (ag1) obj)).p(xl4Var);
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 16:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 17:
                ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return mf0Var;
            case 18:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 19:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            default:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = 2;
        switch (this.X) {
            case 0:
                return new mt((BypassConfigActivity) this.Z, ge0Var, 0);
            case 1:
                return new mt((ConstraintTrackingWorker) this.Z, ge0Var, 1);
            case 2:
                return new mt((a81) this.Z, ge0Var, i);
            case 3:
                return new mt((String[]) this.Z, ge0Var, 3);
            case 4:
                return new mt((FdCountFragment) this.Z, ge0Var, 4);
            case 5:
                return new mt((pg1) this.Z, ge0Var, 5);
            case 6:
                return new mt((qp1) this.Z, ge0Var, 6);
            case 7:
                return new mt((HostsListActivity) this.Z, ge0Var, 7);
            case 8:
                return new mt((b32) this.Z, ge0Var, 8);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new mt((se2) this.Z, ge0Var, 9);
            case 10:
                return new mt((MainActivity) this.Z, ge0Var, 10);
            case 11:
                return new mt((tf2) this.Z, ge0Var, 11);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new mt((nj2) this.Z, ge0Var, 12);
            case 13:
                return new mt((MemoryUsageFragment) this.Z, ge0Var, 13);
            case 14:
                mt mtVar = new mt(i, ge0Var);
                mtVar.Z = obj;
                return mtVar;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return new mt((RecentRequestsActivity) this.Z, ge0Var, 15);
            case 16:
                return new mt((o80) this.Z, ge0Var, 16);
            case 17:
                return new mt((SettingsActivity) this.Z, ge0Var, 17);
            case 18:
                return new mt((zz3) this.Z, ge0Var, 18);
            case 19:
                return new mt((b84) this.Z, ge0Var, 19);
            default:
                return new mt((vh4) this.Z, ge0Var, 20);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x0266, code lost:
    
        if (defpackage.ji0.V(r2, r3, r8, r4, r4, r23) == r10) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0608, code lost:
    
        if (defpackage.ji0.V(r2, r3, r8, r4, r4, r23) == r7) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x07cc, code lost:
    
        if (defpackage.ji0.V(r1, r3, r13, r4, r4, r23) == r12) goto L383;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) throws Throwable {
        Object objB0;
        Object objB02;
        Object objB03;
        Object objQ;
        ge2[] ge2VarArr;
        Object objB04;
        MenuItem checkedItem;
        Object objB05;
        ag1 ag1Var;
        ni3 ni3Var;
        int i = 3;
        int i2 = 6;
        int i3 = 5;
        int i4 = 2;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        ge0 ge0Var = null;
        switch (this.X) {
            case 0:
                BypassConfigActivity bypassConfigActivity = (BypassConfigActivity) this.Z;
                mf0 mf0Var = mf0.b;
                int i5 = this.Y;
                try {
                } catch (JSONException e) {
                    e.printStackTrace();
                    y3 y3Var = bypassConfigActivity.S0;
                    if (y3Var == null) {
                        n12.T("binding");
                        throw null;
                    }
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var.a;
                    coordinatorLayout.getClass();
                    r25.R(coordinatorLayout, R.string.import_failed, new Object[0]);
                }
                if (i5 == 0) {
                    n12.S(obj);
                    gm0 gm0Var = qv0.a;
                    pl0 pl0Var = pl0.z;
                    lt ltVar = new lt(i4, ge0Var, objArr == true ? 1 : 0);
                    this.Y = 1;
                    objB0 = ji0.b0(pl0Var, ltVar, this);
                    if (objB0 == mf0Var) {
                    }
                    return mf0Var;
                }
                if (i5 != 1) {
                    if (i5 == 2) {
                        n12.S(obj);
                        return xl4.a;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                objB0 = obj;
                e03 e03Var = (e03) objB0;
                fa2 fa2Var = bypassConfigActivity.b;
                q92 q92Var = q92.z;
                gm0 gm0Var2 = qv0.a;
                tq1 tq1Var = qf2.a.X;
                cf0 cf0Var = this.f;
                cf0Var.getClass();
                boolean zQ0 = tq1Var.q0(cf0Var);
                if (!zQ0) {
                    q92 q92Var2 = fa2Var.c;
                    if (q92Var2 == q92.b) {
                        throw new x92(null);
                    }
                    if (q92Var2.compareTo(q92Var) >= 0) {
                        boolean zBooleanValue = ((Boolean) e03Var.b).booleanValue();
                        HashSet hashSet = (HashSet) e03Var.f;
                        y3 y3Var2 = bypassConfigActivity.S0;
                        if (zBooleanValue) {
                            if (y3Var2 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            MenuItem menuItemFindItem = ((Toolbar) y3Var2.c).getMenu().findItem(R.id.white_list_mode);
                            if (menuItemFindItem != null) {
                                menuItemFindItem.setChecked(true);
                            }
                        } else {
                            if (y3Var2 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            MenuItem menuItemFindItem2 = ((Toolbar) y3Var2.c).getMenu().findItem(R.id.black_list_mode);
                            if (menuItemFindItem2 != null) {
                                menuItemFindItem2.setChecked(true);
                            }
                        }
                        t23.D(zBooleanValue);
                        t23.w(t23.H(), hashSet);
                        f33 f33Var = new f33(3, bypassConfigActivity);
                        int i6 = BypassConfigActivity.Y0;
                        bypassConfigActivity.C(f33Var);
                    }
                    return xl4.a;
                }
                kt ktVar = new kt(objArr2 == true ? 1 : 0, e03Var, bypassConfigActivity);
                this.Y = 2;
                break;
            case 1:
                mf0 mf0Var2 = mf0.b;
                int i7 = this.Y;
                if (i7 != 0) {
                    if (i7 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.Z;
                this.Y = 1;
                Object objE = constraintTrackingWorker.e(this);
                return objE == mf0Var2 ? mf0Var2 : objE;
            case 2:
                a81 a81Var = (a81) this.Z;
                mf0 mf0Var3 = mf0.b;
                int i8 = this.Y;
                if (i8 == 0) {
                    n12.S(obj);
                    gm0 gm0Var3 = qv0.a;
                    pl0 pl0Var2 = pl0.z;
                    lt ltVar2 = new lt(i4, ge0Var, i4);
                    this.Y = 1;
                    objB02 = ji0.b0(pl0Var2, ltVar2, this);
                    if (objB02 == mf0Var3) {
                        return mf0Var3;
                    }
                } else {
                    if (i8 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    objB02 = obj;
                }
                List list = (List) objB02;
                a81Var.z.r(list);
                v92 v92Var = a81Var.b;
                v92Var.getClass();
                ((MaterialTextView) v92Var.f).setVisibility(list.isEmpty() ? 0 : 8);
                return xl4.a;
            case 3:
                mf0 mf0Var4 = mf0.b;
                int i9 = this.Y;
                if (i9 == 0) {
                    n12.S(obj);
                    e1 e1Var = d73.a;
                    String[] strArr = (String[]) this.Z;
                    String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
                    this.Y = 1;
                    String string = Arrays.toString(strArr2);
                    string.getClass();
                    String strConcat = "reloadProfilesLocally: ".concat(string);
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("ProfileManager", strConcat, null);
                    }
                    gm0 gm0Var4 = qv0.a;
                    if (ji0.b0(pl0.z, new gt(strArr2, ge0Var, i), this) == mf0Var4) {
                        return mf0Var4;
                    }
                } else {
                    if (i9 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 4:
                mf0 mf0Var5 = mf0.b;
                int i10 = this.Y;
                if (i10 == 0) {
                    n12.S(obj);
                    gm0 gm0Var5 = qv0.a;
                    pl0 pl0Var3 = pl0.z;
                    lt ltVar3 = new lt(i4, ge0Var, i);
                    this.Y = 1;
                    objB03 = ji0.b0(pl0Var3, ltVar3, this);
                    if (objB03 != mf0Var5) {
                    }
                    return mf0Var5;
                }
                if (i10 != 1) {
                    if (i10 == 2) {
                        n12.S(obj);
                        return xl4.a;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                objB03 = obj;
                int iIntValue = ((Number) objB03).intValue();
                FdCountFragment fdCountFragment = (FdCountFragment) this.Z;
                r92 lifecycle = fdCountFragment.getLifecycle();
                q92 q92Var3 = q92.X;
                gm0 gm0Var6 = qv0.a;
                tq1 tq1Var2 = qf2.a.X;
                cf0 cf0Var2 = this.f;
                cf0Var2.getClass();
                boolean zQ02 = tq1Var2.q0(cf0Var2);
                if (!zQ02) {
                    if (lifecycle.b() == q92.b) {
                        vp1.m();
                        return null;
                    }
                    if (lifecycle.b().compareTo(q92Var3) >= 0) {
                        oj1 oj1Var = fdCountFragment.b;
                        oj1Var.getClass();
                        ((MaterialTextView) oj1Var.f).setText(String.valueOf(iIntValue));
                        View view = fdCountFragment.getView();
                        if (view != null) {
                            view.postDelayed(fdCountFragment.f, 3000L);
                        }
                    }
                    return xl4.a;
                }
                fc1 fc1Var = new fc1(fdCountFragment, iIntValue);
                this.Y = 2;
                break;
            case 5:
                xl4 xl4Var = xl4.a;
                mf0 mf0Var6 = mf0.b;
                int i11 = this.Y;
                if (i11 == 0) {
                    n12.S(obj);
                    pg1 pg1Var = (pg1) this.Z;
                    this.Y = 1;
                    Object objA = pg1Var.a(os2.b, this);
                    if (objA != mf0Var6) {
                        objA = xl4Var;
                    }
                    if (objA == mf0Var6) {
                        return mf0Var6;
                    }
                } else {
                    if (i11 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4Var;
            case 6:
                mf0 mf0Var7 = mf0.b;
                int i12 = this.Y;
                if (i12 == 0) {
                    n12.S(obj);
                    qp1 qp1Var = (qp1) this.Z;
                    r92 lifecycle2 = qp1Var.getLifecycle();
                    q92 q92Var4 = q92.X;
                    gm0 gm0Var7 = qv0.a;
                    tq1 tq1Var3 = qf2.a.X;
                    cf0 cf0Var3 = this.f;
                    cf0Var3.getClass();
                    boolean zQ03 = tq1Var3.q0(cf0Var3);
                    if (zQ03) {
                        v10 v10Var = new v10(2, qp1Var);
                        this.Y = 1;
                        if (ji0.V(lifecycle2, q92Var4, zQ03, tq1Var3, v10Var, this) == mf0Var7) {
                            return mf0Var7;
                        }
                    } else {
                        if (lifecycle2.b() == q92.b) {
                            vp1.m();
                            return null;
                        }
                        if (lifecycle2.b().compareTo(q92Var4) >= 0) {
                            try {
                                u parentFragmentManager = qp1Var.getParentFragmentManager();
                                parentFragmentManager.getClass();
                                a aVar = new a(parentFragmentManager);
                                aVar.j(qp1Var);
                                aVar.l(false, pp1.f);
                                aVar.e();
                            } catch (IllegalStateException e2) {
                                e2.printStackTrace();
                            }
                            break;
                        }
                    }
                } else {
                    if (i12 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 7:
                xl4 xl4Var2 = xl4.a;
                mf0 mf0Var8 = mf0.b;
                int i13 = this.Y;
                if (i13 == 0) {
                    n12.S(obj);
                    HostsListActivity hostsListActivity = (HostsListActivity) this.Z;
                    this.Y = 1;
                    int i14 = HostsListActivity.a1;
                    gm0 gm0Var8 = qv0.a;
                    Object objB06 = ji0.b0(pl0.z, new gt(hostsListActivity, ge0Var, i3), this);
                    if (objB06 != mf0Var8) {
                        objB06 = xl4Var2;
                    }
                    if (objB06 == mf0Var8) {
                        return mf0Var8;
                    }
                } else {
                    if (i13 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4Var2;
            case 8:
                mf0 mf0Var9 = mf0.b;
                int i15 = this.Y;
                if (i15 == 0) {
                    n12.S(obj);
                    zf1 data = ((b32) this.Z).c.getData();
                    this.Y = 1;
                    objQ = ye.q(data, this);
                    if (objQ == mf0Var9) {
                        return mf0Var9;
                    }
                } else {
                    if (i15 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    objQ = obj;
                }
                rn2 rn2Var = (rn2) objQ;
                return rn2Var != null ? rn2Var.a() : h41.b;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                mf0 mf0Var10 = mf0.b;
                int i16 = this.Y;
                if (i16 == 0) {
                    n12.S(obj);
                    File externalCacheDir = ((se2) this.Z).requireContext().getExternalCacheDir();
                    oe2 oe2Var = ((se2) this.Z).z;
                    synchronized (oe2Var.f) {
                        ge2VarArr = (ge2[]) oe2Var.e.toArray(new ge2[0]);
                    }
                    this.Y = 1;
                    gm0 gm0Var9 = qv0.a;
                    objB04 = ji0.b0(pl0.z, new gd(externalCacheDir, ge2VarArr, ge0Var, 4), this);
                    if (objB04 == mf0Var10) {
                        return mf0Var10;
                    }
                } else {
                    if (i16 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    objB04 = obj;
                }
                File file = (File) objB04;
                if (file == null) {
                    te2 te2Var = ((se2) this.Z).b;
                    if (te2Var == null) {
                        n12.T("binding");
                        throw null;
                    }
                    oy3.g(te2Var.g, R.string.logcat_viewer_create_log_file_failed, -1).j();
                } else {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType(HttpPostBodyUtil.DEFAULT_TEXT_CONTENT_TYPE);
                    intent.putExtra("android.intent.extra.STREAM", FileProvider.c(((se2) this.Z).requireContext(), ((se2) this.Z).requireContext().getPackageName() + ".logcat_fileprovider", file));
                    boolean zIsEmpty = ((se2) this.Z).requireContext().getPackageManager().queryIntentActivities(intent, 0).isEmpty();
                    se2 se2Var = (se2) this.Z;
                    if (zIsEmpty) {
                        te2 te2Var2 = se2Var.b;
                        if (te2Var2 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        oy3.g(te2Var2.g, R.string.logcat_viewer_not_support_on_this_device, -1).j();
                    } else {
                        se2Var.startActivity(intent);
                    }
                }
                return xl4.a;
            case 10:
                mf0 mf0Var11 = mf0.b;
                int i17 = this.Y;
                if (i17 != 0) {
                    if (i17 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    throw new t80();
                }
                n12.S(obj);
                hv3 hv3Var = m70.a;
                xu xuVar = new xu(7, (MainActivity) this.Z);
                this.Y = 1;
                hv3Var.a(xuVar, this);
                return mf0Var11;
            case 11:
                mf0 mf0Var12 = mf0.b;
                int i18 = this.Y;
                if (i18 == 0) {
                    n12.S(obj);
                    tf2 tf2Var = (tf2) this.Z;
                    r92 lifecycle3 = tf2Var.getLifecycle();
                    q92 q92Var5 = q92.X;
                    gm0 gm0Var10 = qv0.a;
                    tq1 tq1Var4 = qf2.a.X;
                    cf0 cf0Var4 = this.f;
                    cf0Var4.getClass();
                    boolean zQ04 = tq1Var4.q0(cf0Var4);
                    if (zQ04) {
                        cj cjVar = new cj(i4, tf2Var);
                        this.Y = 1;
                        if (ji0.V(lifecycle3, q92Var5, zQ04, tq1Var4, cjVar, this) == mf0Var12) {
                            return mf0Var12;
                        }
                    } else {
                        if (lifecycle3.b() == q92.b) {
                            vp1.m();
                            return null;
                        }
                        if (lifecycle3.b().compareTo(q92Var5) >= 0) {
                            ed4 ed4Var = tf2Var.b;
                            ed4Var.getClass();
                            up2 up2Var = (up2) ed4Var.z;
                            if (up2Var == null || up2Var.getSelectedItemId() != R.id.navigation_dashboard) {
                                ed4 ed4Var2 = tf2Var.b;
                                ed4Var2.getClass();
                                up2 up2Var2 = (up2) ed4Var2.z;
                                if (up2Var2 != null) {
                                    up2Var2.setSelectedItemId(R.id.navigation_dashboard);
                                }
                            }
                            ed4 ed4Var3 = tf2Var.b;
                            ed4Var3.getClass();
                            NavigationView navigationView = (NavigationView) ed4Var3.A;
                            if (navigationView == null || (checkedItem = navigationView.getCheckedItem()) == null || checkedItem.getItemId() != R.id.navigation_dashboard) {
                                ed4 ed4Var4 = tf2Var.b;
                                ed4Var4.getClass();
                                NavigationView navigationView2 = (NavigationView) ed4Var4.A;
                                if (navigationView2 != null) {
                                    navigationView2.setCheckedItem(R.id.navigation_dashboard);
                                }
                            }
                            xh0 xh0Var = tf2Var.z;
                            if (xh0Var != null) {
                                Context contextRequireContext = tf2Var.requireContext();
                                contextRequireContext.getClass();
                                xh0Var.j(contextRequireContext);
                            }
                        }
                    }
                } else {
                    if (i18 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                mf0 mf0Var13 = mf0.b;
                int i19 = this.Y;
                if (i19 != 0) {
                    if (i19 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                r25 r25Var = ((nj2) this.Z).a;
                this.Y = 1;
                Object objY = r25Var.y(this);
                return objY == mf0Var13 ? mf0Var13 : objY;
            case 13:
                MemoryUsageFragment memoryUsageFragment = (MemoryUsageFragment) this.Z;
                mf0 mf0Var14 = mf0.b;
                int i20 = this.Y;
                if (i20 == 0) {
                    n12.S(obj);
                    Context contextRequireContext2 = memoryUsageFragment.requireContext();
                    contextRequireContext2.getClass();
                    this.Y = 1;
                    gm0 gm0Var11 = qv0.a;
                    objB05 = ji0.b0(pl0.z, new gt(contextRequireContext2, ge0Var, i2), this);
                    if (objB05 != mf0Var14) {
                    }
                    return mf0Var14;
                }
                if (i20 != 1) {
                    if (i20 == 2) {
                        n12.S(obj);
                        return xl4.a;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                objB05 = obj;
                boolean zBooleanValue2 = ((Boolean) objB05).booleanValue();
                r92 lifecycle4 = memoryUsageFragment.getLifecycle();
                q92 q92Var6 = q92.z;
                gm0 gm0Var12 = qv0.a;
                tq1 tq1Var5 = qf2.a.X;
                cf0 cf0Var5 = this.f;
                cf0Var5.getClass();
                boolean zQ05 = tq1Var5.q0(cf0Var5);
                if (!zQ05) {
                    if (lifecycle4.b() == q92.b) {
                        vp1.m();
                        return null;
                    }
                    if (lifecycle4.b().compareTo(q92Var6) >= 0) {
                        if (zBooleanValue2) {
                            dk1 dk1Var = memoryUsageFragment.b;
                            dk1Var.getClass();
                            dk1Var.g.setVisibility(0);
                            dk1 dk1Var2 = memoryUsageFragment.b;
                            dk1Var2.getClass();
                            dk1Var2.g.setOnClickListener(ik2.b);
                        }
                    }
                    return xl4.a;
                }
                jk2 jk2Var = new jk2(zBooleanValue2, memoryUsageFragment);
                this.Y = 2;
                break;
            case 14:
                mf0 mf0Var15 = mf0.b;
                int i21 = this.Y;
                if (i21 == 0) {
                    n12.S(obj);
                    ag1Var = (ag1) this.Z;
                    ni3Var = null;
                } else {
                    if (i21 != 1) {
                        if (i21 == 2) {
                            n12.S(obj);
                            return xl4.a;
                        }
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ag1Var = (ag1) this.Z;
                    n12.S(obj);
                    ni3Var = (ni3) obj;
                }
                Boolean boolValueOf = Boolean.valueOf(ni3Var == ni3.b);
                this.Z = null;
                this.Y = 2;
                if (ag1Var.h(boolValueOf, this) == mf0Var15) {
                    return mf0Var15;
                }
                return xl4.a;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                RecentRequestsActivity recentRequestsActivity = (RecentRequestsActivity) this.Z;
                mf0 mf0Var16 = mf0.b;
                int i22 = this.Y;
                if (i22 == 0) {
                    n12.S(obj);
                    int i23 = RecentRequestsActivity.X0;
                    h30 h30Var = recentRequestsActivity.y().c;
                    w53 w53Var = new w53(recentRequestsActivity, ge0Var, i2);
                    this.Y = 1;
                    if (r25.k(h30Var, w53Var, this) == mf0Var16) {
                        return mf0Var16;
                    }
                } else {
                    if (i22 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 16:
                mf0 mf0Var17 = mf0.b;
                int i24 = this.Y;
                if (i24 != 0) {
                    if (i24 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                o80 o80Var = (o80) this.Z;
                this.Y = 1;
                Object objJ0 = o80Var.j0(this);
                return objJ0 == mf0Var17 ? mf0Var17 : objJ0;
            case 17:
                mf0 mf0Var18 = mf0.b;
                int i25 = this.Y;
                if (i25 != 0) {
                    if (i25 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    throw new t80();
                }
                n12.S(obj);
                hv3 hv3Var2 = m70.a;
                xu xuVar2 = new xu(10, (SettingsActivity) this.Z);
                this.Y = 1;
                hv3Var2.a(xuVar2, this);
                return mf0Var18;
            case 18:
                mf0 mf0Var19 = mf0.b;
                int i26 = this.Y;
                try {
                    if (i26 == 0) {
                        n12.S(obj);
                        zz3 zz3Var = (zz3) this.Z;
                        this.Y = 1;
                        if (zz3Var.c(this) == mf0Var19) {
                            return mf0Var19;
                        }
                    } else {
                        if (i26 != 1) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        n12.S(obj);
                    }
                    break;
                } catch (Exception e3) {
                    String strN = ha0.n("Speedometer run failed: ", e3.getMessage());
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "Speedometer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("Speedometer", strN, null);
                    }
                    ((zz3) this.Z).b(null, null);
                }
                return xl4.a;
            case 19:
                mf0 mf0Var20 = mf0.b;
                int i27 = this.Y;
                if (i27 == 0) {
                    n12.S(obj);
                    b84 b84Var = (b84) this.Z;
                    r92 lifecycle5 = b84Var.getLifecycle();
                    q92 q92Var7 = q92.X;
                    gm0 gm0Var13 = qv0.a;
                    tq1 tq1Var6 = qf2.a.X;
                    cf0 cf0Var6 = this.f;
                    cf0Var6.getClass();
                    boolean zQ06 = tq1Var6.q0(cf0Var6);
                    if (zQ06) {
                        cj cjVar2 = new cj(i3, b84Var);
                        this.Y = 1;
                        if (ji0.V(lifecycle5, q92Var7, zQ06, tq1Var6, cjVar2, this) == mf0Var20) {
                            return mf0Var20;
                        }
                    } else {
                        if (lifecycle5.b() == q92.b) {
                            vp1.m();
                            return null;
                        }
                        if (lifecycle5.b().compareTo(q92Var7) >= 0) {
                            b84Var.j(false, false);
                        }
                    }
                } else {
                    if (i27 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            default:
                mf0 mf0Var21 = mf0.b;
                int i28 = this.Y;
                if (i28 == 0) {
                    n12.S(obj);
                    vh4 vh4Var = (vh4) this.Z;
                    this.Y = 1;
                    if (vh4Var.g(this) == mf0Var21) {
                        return mf0Var21;
                    }
                } else {
                    if (i28 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mt(int i, ge0 ge0Var) {
        super(i, ge0Var);
        this.X = 14;
    }
}
