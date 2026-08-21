package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Rational;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.view.PreviewView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.o;
import androidx.fragment.app.u;
import androidx.profileinstaller.ProfileInstallReceiver;
import com.getsurfboard.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import io.sentry.android.core.a1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oj1 implements l4, wv, b1, pk3, sv, om1, lk2, ou0, qi0, i43, a73, gp4, mu2 {
    public final /* synthetic */ int b;
    public final Object f;

    public oj1(nn2 nn2Var) {
        this.b = 9;
        this.f = new int[0];
        int[] iArr = nn2Var.b;
        long[] jArr = nn2Var.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128) {
                        ((int[]) this.f)[i2] = iArr[(i << 3) + i4];
                        i2++;
                    }
                    j >>= 8;
                }
                if (i3 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public static l54 D(e10 e10Var, ry1 ry1Var, tj2 tj2Var, uj2 uj2Var) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ry1Var.a.getResources(), uj2Var.a);
        Map map = uj2Var.b;
        Object obj = map.get("coil#disk_cache_key");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("coil#is_sampled");
        Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        boolean z = false;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        Bitmap.Config config = j.a;
        if (e10Var != null && e10Var.f) {
            z = true;
        }
        return new l54(bitmapDrawable, ry1Var, pi0.b, tj2Var, str, zBooleanValue, z);
    }

    public static String F(oj1 oj1Var) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) oj1Var.f).iterator();
        while (it.hasNext()) {
            arrayList.add(((hc3) it.next()).getClass().getSimpleName());
        }
        StringBuilder sb = new StringBuilder();
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            while (true) {
                sb.append((CharSequence) it2.next());
                if (!it2.hasNext()) {
                    break;
                }
                sb.append((CharSequence) " | ");
            }
        }
        return sb.toString();
    }

    public ArrayList A(Class cls) {
        ArrayList arrayList = new ArrayList();
        for (hc3 hc3Var : (ArrayList) this.f) {
            if (cls.isAssignableFrom(hc3Var.getClass())) {
                arrayList.add(hc3Var);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0151 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x013e A[PHI: r16 r18
      0x013e: PHI (r16v1 uj2) = (r16v0 uj2), (r16v0 uj2), (r16v2 uj2) binds: [B:89:0x013b, B:84:0x012f, B:77:0x011c] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r18v2 double) = (r18v1 double), (r18v1 double), (r18v3 double) binds: [B:89:0x013b, B:84:0x012f, B:77:0x011c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x014c A[PHI: r16
      0x014c: PHI (r16v3 uj2) = (r16v1 uj2), (r16v1 uj2), (r16v5 uj2) binds: [B:98:0x014a, B:94:0x0143, B:53:0x00af] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public uj2 B(ry1 ry1Var, tj2 tj2Var, wx3 wx3Var, sp3 sp3Var) {
        uj2 uj2VarH;
        double d;
        uj2 uj2Var;
        boolean zEquals;
        uj2 uj2Var2;
        if (ry1Var.k.b) {
            we3 we3Var = (we3) ((te3) this.f).c.getValue();
            if (we3Var == null) {
                uj2VarH = null;
                if (uj2VarH != null) {
                    Bitmap bitmap = uj2VarH.a;
                    Bitmap.Config config = bitmap.getConfig();
                    if (config == null) {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    if (n02.v(ry1Var, config)) {
                        Object obj = uj2VarH.b.get("coil#is_sampled");
                        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
                        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                        if (n12.c(wx3Var, wx3.c)) {
                            uj2Var = null;
                            zEquals = !zBooleanValue;
                        } else {
                            String str = (String) tj2Var.f.get("coil#transformation_size");
                            if (str != null) {
                                zEquals = str.equals(wx3Var.toString());
                            } else {
                                int width = bitmap.getWidth();
                                int height = bitmap.getHeight();
                                p95 p95Var = wx3Var.a;
                                int i = p95Var instanceof qu0 ? ((qu0) p95Var).n : Integer.MAX_VALUE;
                                p95 p95Var2 = wx3Var.b;
                                int i2 = p95Var2 instanceof qu0 ? ((qu0) p95Var2).n : Integer.MAX_VALUE;
                                double dJ = uf2.j(width, height, i, i2, sp3Var);
                                boolean zA = h.a(ry1Var);
                                if (zA) {
                                    double d2 = dJ > 1.0d ? 1.0d : dJ;
                                    uj2Var = null;
                                    d = 1.0d;
                                    if (Math.abs(((double) i) - (((double) width) * d2)) > 1.0d && Math.abs(((double) i2) - (d2 * ((double) height))) > 1.0d) {
                                        if ((dJ != d && !zA) || (dJ > d && zBooleanValue)) {
                                        }
                                    }
                                } else {
                                    d = 1.0d;
                                    uj2Var = null;
                                    if ((i != Integer.MIN_VALUE && i != Integer.MAX_VALUE && Math.abs(i - width) > 1) || (i2 != Integer.MIN_VALUE && i2 != Integer.MAX_VALUE && Math.abs(i2 - height) > 1)) {
                                    }
                                }
                            }
                        }
                        return !zEquals ? uj2VarH : uj2Var;
                    }
                    zEquals = false;
                    uj2Var = null;
                    if (!zEquals) {
                    }
                }
            } else {
                uj2VarH = we3Var.a.h(tj2Var);
                if (uj2VarH == null) {
                    t6 t6Var = we3Var.b;
                    synchronized (t6Var) {
                        try {
                            ArrayList arrayList = (ArrayList) ((LinkedHashMap) t6Var.z).get(tj2Var);
                            if (arrayList == null) {
                                uj2VarH = null;
                            } else {
                                int size = arrayList.size();
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= size) {
                                        uj2Var2 = null;
                                        break;
                                    }
                                    df3 df3Var = (df3) arrayList.get(i3);
                                    Bitmap bitmap2 = (Bitmap) df3Var.b.get();
                                    uj2Var2 = bitmap2 != null ? new uj2(bitmap2, df3Var.c) : null;
                                    if (uj2Var2 != null) {
                                        break;
                                    }
                                    i3++;
                                }
                                int i4 = t6Var.f;
                                t6Var.f = i4 + 1;
                                if (i4 >= 10) {
                                    t6Var.g();
                                }
                                uj2VarH = uj2Var2;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                if (uj2VarH != null) {
                }
            }
        }
        return null;
    }

    public tj2 C(ry1 ry1Var, Object obj, rw2 rw2Var, z51 z51Var) {
        String string;
        Map linkedHashMap;
        long j;
        h41 h41Var = h41.b;
        ry1Var.getClass();
        List list = ((te3) this.f).f.c;
        int size = list.size();
        int i = 0;
        while (true) {
            if (i < size) {
                e03 e03Var = (e03) list.get(i);
                zc zcVar = (zc) e03Var.b;
                if (((Class) e03Var.f).isAssignableFrom(obj.getClass())) {
                    zcVar.getClass();
                    switch (zcVar.a) {
                        case 0:
                            PackageInfo packageInfo = (PackageInfo) obj;
                            Context context = rw2Var.a;
                            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                            long jG = u9.g(packageInfo);
                            UserHandle userHandleP = ga5.p(applicationInfo.uid);
                            StringBuilder sb = new StringBuilder();
                            sb.append(applicationInfo.packageName);
                            sb.append(":");
                            sb.append(jG);
                            sb.append(":");
                            ArrayMap arrayMap = un4.a;
                            synchronized (arrayMap) {
                                try {
                                    long[] jArr = (long[]) arrayMap.get(userHandleP);
                                    if (jArr == null) {
                                        jArr = new long[2];
                                        arrayMap.put(userHandleP, jArr);
                                    }
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    if (jArr[1] + 1000 <= jCurrentTimeMillis) {
                                        jArr[0] = ((UserManager) context.getSystemService("user")).getSerialNumberForUser(userHandleP);
                                        jArr[1] = jCurrentTimeMillis;
                                    }
                                    j = jArr[0];
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            sb.append(j);
                            string = sb.toString();
                            break;
                        case 1:
                            File file = (File) obj;
                            string = file.getPath() + ':' + file.lastModified();
                            break;
                        default:
                            Uri uri = (Uri) obj;
                            if (!n12.c(uri.getScheme(), "android.resource")) {
                                string = uri.toString();
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(uri);
                                sb2.append('-');
                                Configuration configuration = rw2Var.a.getResources().getConfiguration();
                                Bitmap.Config config = j.a;
                                sb2.append(configuration.uiMode & 48);
                                string = sb2.toString();
                            }
                            break;
                    }
                    if (string != null) {
                    }
                }
                i++;
            } else {
                string = null;
            }
        }
        if (string == null) {
            return null;
        }
        Map map = ry1Var.u.b;
        if (map.isEmpty()) {
            linkedHashMap = h41Var;
        } else {
            linkedHashMap = new LinkedHashMap();
            Iterator it = map.entrySet().iterator();
            if (it.hasNext()) {
                ((Map.Entry) it.next()).getValue().getClass();
                st4.n();
                return null;
            }
        }
        return linkedHashMap.isEmpty() ? new tj2(string, h41Var) : new tj2(string, new LinkedHashMap(linkedHashMap));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, oj1] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object E(ej0 ej0Var, ie0 ie0Var) {
        sx3 sx3Var;
        if (ie0Var instanceof sx3) {
            sx3Var = (sx3) ie0Var;
            int i = sx3Var.Y;
            if ((i & Integer.MIN_VALUE) != 0) {
                sx3Var.Y = i - Integer.MIN_VALUE;
            } else {
                sx3Var = new sx3(this, ie0Var);
            }
        }
        Object obj = sx3Var.A;
        int i2 = sx3Var.Y;
        ge0 ge0Var = null;
        try {
            if (i2 == 0) {
                n12.S(obj);
                uf ufVar = new uf(this, ej0Var, ge0Var, 25);
                sx3Var.Y = 1;
                Object objH = p95.h(ufVar, sx3Var);
                mf0 mf0Var = mf0.b;
                this = objH;
                if (objH == mf0Var) {
                    return mf0Var;
                }
            } else {
                if (i2 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                this = this;
            }
        } catch (px3 e) {
            if (e.b != this) {
                throw e;
            }
        }
        return xl4.a;
    }

    @Override // defpackage.lk2
    public boolean V(nk2 nk2Var, sk2 sk2Var) {
        up2 up2Var = (up2) this.f;
        if (up2Var.z0 == null || sk2Var.a != up2Var.getSelectedItemId()) {
            sp2 sp2Var = ((up2) this.f).y0;
            if (sp2Var == null || ((tf2) sp2Var).j(sk2Var)) {
                return false;
            }
        } else {
            tf2 tf2Var = (tf2) ((up2) this.f).z0;
            tf2Var.getClass();
            int i = sk2Var.a;
            Object obj = i == R.id.navigation_dashboard ? tf2Var.z : i == R.id.navigation_proxygroups ? tf2Var.X : i == R.id.navigation_profiles ? tf2Var.A : i == R.id.navigation_tools ? tf2Var.Y : null;
            if (obj == null) {
                zo2.m(sk2Var.e, "can not find fragment for ");
                return false;
            }
            if (obj instanceof jv2) {
                ((jv2) obj).c();
                return true;
            }
            String str = obj + " not implement " + jv2.class;
            if (fy4.b) {
                Xlog.logWrite2(0L, 3, "main", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.o("main", str, null);
                return true;
            }
        }
        return true;
    }

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        NavigationView navigationView = (NavigationView) this.f;
        Rect rect = navigationView.f;
        if (rect == null) {
            rect = new Rect();
            navigationView.f = rect;
        }
        int iB = bv4Var.b();
        yu4 yu4Var = bv4Var.a;
        rect.set(iB, bv4Var.d(), bv4Var.c(), bv4Var.a());
        mq2 mq2Var = navigationView.C0;
        mq2Var.getClass();
        int iD = bv4Var.d();
        if (mq2Var.Q0 != iD) {
            mq2Var.Q0 = iD;
            int i = (mq2Var.f.getChildCount() <= 0 && mq2Var.O0) ? mq2Var.Q0 : 0;
            NavigationMenuView navigationMenuView = mq2Var.b;
            navigationMenuView.setPadding(0, i, 0, navigationMenuView.getPaddingBottom());
        }
        NavigationMenuView navigationMenuView2 = mq2Var.b;
        navigationMenuView2.setPadding(0, navigationMenuView2.getPaddingTop(), 0, bv4Var.a());
        wp4.b(mq2Var.f, bv4Var);
        navigationView.setWillNotDraw(yu4Var.m().equals(t02.e) || navigationView.b == null);
        navigationView.postInvalidateOnAnimation();
        return yu4Var.c();
    }

    @Override // defpackage.gp4
    public int a(View view) {
        return ag3.E(view) - ((ViewGroup.MarginLayoutParams) ((bg3) view.getLayoutParams())).topMargin;
    }

    @Override // defpackage.qi0
    public Object b(Function2 function2, hj hjVar) {
        return ((qi0) this.f).b(new b33(function2, null, 0), hjVar);
    }

    @Override // defpackage.gp4
    public int c() {
        return ((ag3) this.f).J();
    }

    @Override // defpackage.b1
    public void d() {
        ((kn1) this.f).S();
    }

    @Override // defpackage.i43
    public void e(j74 j74Var) {
        t43 o74Var;
        if (!co4.E()) {
            v9.i(((PreviewView) this.f).getContext()).execute(new xy0(14, this, j74Var));
            return;
        }
        ez4.o("PreviewView", "Surface requested by Preview.");
        mz mzVar = j74Var.d;
        ((PreviewView) this.f).C0 = mzVar.r();
        u43 u43Var = ((PreviewView) this.f).B0;
        Rect rectH = mzVar.r().h();
        u43Var.getClass();
        new Rational(rectH.width(), rectH.height());
        synchronized (u43Var) {
            u43Var.b = rectH;
        }
        j74Var.b(v9.i(((PreviewView) this.f).getContext()), new m10(6, this, mzVar, j74Var));
        PreviewView previewView = (PreviewView) this.f;
        t43 t43Var = previewView.f;
        q43 q43Var = previewView.b;
        if (!(t43Var instanceof o74) || PreviewView.b(j74Var, q43Var)) {
            PreviewView previewView2 = (PreviewView) this.f;
            boolean zB = PreviewView.b(j74Var, previewView2.b);
            PreviewView previewView3 = (PreviewView) this.f;
            o43 o43Var = previewView3.A;
            if (zB) {
                ad4 ad4Var = new ad4(previewView3, o43Var);
                ad4Var.i = false;
                ad4Var.k = new AtomicReference();
                o74Var = ad4Var;
            } else {
                o74Var = new o74(previewView3, o43Var);
            }
            previewView2.f = o74Var;
        }
        kz kzVarR = mzVar.r();
        PreviewView previewView4 = (PreviewView) this.f;
        n43 n43Var = new n43(kzVarR, previewView4.z0, previewView4.f);
        ((PreviewView) this.f).A0.set(n43Var);
        mzVar.a().a(v9.i(((PreviewView) this.f).getContext()), n43Var);
        ((PreviewView) this.f).f.e(j74Var, new m10(7, this, n43Var, mzVar));
        PreviewView previewView5 = (PreviewView) this.f;
        if (previewView5.indexOfChild(previewView5.z) == -1) {
            PreviewView previewView6 = (PreviewView) this.f;
            previewView6.addView(previewView6.z);
        }
    }

    @Override // defpackage.pk3
    public void f(ns4 ns4Var) {
        jr2 jr2Var;
        qp1 qp1Var = (qp1) this.f;
        u6 u6Var = qp1Var.b;
        if (u6Var != null) {
            u6Var.dismiss();
        }
        qp1Var.b = null;
        if (ns4Var == null || (jr2Var = ns4Var.b) == null || jr2Var.a != 400) {
            if (!qp1Var.f) {
                p95.C(R.string.google_api_check_failed, new Object[0]);
            }
            qp1Var.j();
        } else {
            if (qp1Var.f) {
                return;
            }
            wh2 wh2Var = new wh2(qp1Var.requireContext());
            p6 p6Var = (p6) wh2Var.z;
            wh2Var.x(R.string.warning);
            p6Var.c = R.drawable.ic_round_warning_amber_24;
            wh2Var.t(R.string.google_traffic_send_to_mainland_china);
            wh2Var.w(R.string.i_got_it, null);
            wh2Var.v(R.string.report, new y5(2, qp1Var));
            p6Var.p = new np1(qp1Var, 1);
            qp1Var.b = wh2Var.r();
        }
    }

    @Override // defpackage.ou0
    public boolean g(float f) {
        if (f == 0.0f) {
            return false;
        }
        r();
        ((NestedScrollView) this.f).j((int) f);
        return true;
    }

    @Override // defpackage.qi0
    public zf1 getData() {
        return ((qi0) this.f).getData();
    }

    @Override // defpackage.l4
    public void h(Object obj) {
        k4 k4Var = (k4) obj;
        u uVar = (u) this.f;
        wj1 wj1Var = (wj1) uVar.G.pollFirst();
        if (wj1Var == null) {
            a1.n("FragmentManager", "No IntentSenders were started for " + this);
            return;
        }
        String str = wj1Var.b;
        int i = wj1Var.f;
        o oVarC = uVar.c.c(str);
        if (oVarC != null) {
            oVarC.onActivityResult(i, k4Var.b, k4Var.f);
            return;
        }
        a1.n("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
    }

    @Override // defpackage.ou0
    public float i() {
        return -((NestedScrollView) this.f).getVerticalScrollFactorCompat();
    }

    @Override // defpackage.a73
    public void j() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // defpackage.a73
    public void k(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            a1.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.f).setResultCode(i);
    }

    @Override // defpackage.gp4
    public int l() {
        ag3 ag3Var = (ag3) this.f;
        return ag3Var.o - ag3Var.G();
    }

    @Override // defpackage.om1
    public void m(Object obj) {
    }

    @Override // defpackage.wv
    public Object n(vv vvVar) {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 3:
                pm1 pm1Var = (pm1) obj;
                r25.j("The result can only set once!", pm1Var.f == null);
                pm1Var.f = vvVar;
                return "FutureChain[" + pm1Var + "]";
            default:
                yb2 yb2Var = (yb2) obj;
                r25.j("The result can only set once!", yb2Var.Y == null);
                yb2Var.Y = vvVar;
                return "ListFuture[" + this + "]";
        }
    }

    @Override // defpackage.sv
    public void o(le3 le3Var, IOException iOException) {
        ((z00) this.f).d(new tk3(iOException));
    }

    @Override // defpackage.pk3
    public void p(Object obj) {
        qp1 qp1Var = (qp1) this.f;
        u6 u6Var = qp1Var.b;
        if (u6Var != null) {
            u6Var.dismiss();
        }
        qp1Var.b = null;
        if (qp1Var.f) {
            return;
        }
        wh2 wh2Var = new wh2(qp1Var.requireContext());
        p6 p6Var = (p6) wh2Var.z;
        wh2Var.t(R.string.google_api_check_success);
        p6Var.c = R.drawable.ic_round_celebration_24;
        wh2Var.x(R.string.congratulation);
        wh2Var.w(R.string.i_got_it, null);
        p6Var.p = new np1(qp1Var, 0);
        qp1Var.b = wh2Var.r();
    }

    @Override // defpackage.om1
    public void q(Throwable th) throws Exception {
        ((my1) this.f).close();
    }

    @Override // defpackage.ou0
    public void r() {
        ((NestedScrollView) this.f).A.abortAnimation();
    }

    @Override // defpackage.gp4
    public View s(int i) {
        return ((ag3) this.f).u(i);
    }

    @Override // defpackage.sv
    public void t(le3 le3Var, kk3 kk3Var) {
        z00 z00Var = (z00) this.f;
        try {
            if (kk3Var.H0) {
                z00Var.d(new yu1(kk3Var.Z.C(), kk3Var.Y.c()));
                return;
            }
            z00Var.d(new tk3(new IOException("HTTP " + kk3Var.A)));
        } catch (Exception e) {
            z00Var.d(new tk3(e));
        }
    }

    public void u(as4 as4Var) {
        wn1 wn1Var = ((az2) this.f).e;
        wn1Var.getClass();
        iv1 iv1Var = (iv1) wn1Var.f;
        yr4 yr4Var = as4Var instanceof yr4 ? (yr4) as4Var : null;
        synchronized (((o84) iv1Var.X)) {
            if (yr4Var != null) {
                try {
                    iv1Var.A = yr4Var;
                } catch (Throwable th) {
                    throw th;
                }
            }
            eg0 eg0Var = (eg0) iv1Var.f;
            eg0 eg0Var2 = (eg0) iv1Var.z;
            if (je.e0(as4Var, (as4) eg0Var.f, hd2.f)) {
                eg0Var.T(as4Var);
            }
            if (je.e0(as4Var, (as4) eg0Var2.f, hd2.z)) {
                eg0Var2.T(as4Var);
            }
        }
    }

    @Override // defpackage.gp4
    public int v(View view) {
        return ag3.y(view) + ((ViewGroup.MarginLayoutParams) ((bg3) view.getLayoutParams())).bottomMargin;
    }

    public ye0 w(ye0 ye0Var) {
        return ye0Var instanceof mi3 ? ye0Var : new g6(-((yi2) this.f).h(), ye0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void x(nh4 nh4Var, ie0 ie0Var) {
        gu2 gu2Var;
        if (ie0Var instanceof gu2) {
            gu2Var = (gu2) ie0Var;
            int i = gu2Var.Y;
            if ((i & Integer.MIN_VALUE) != 0) {
                gu2Var.Y = i - Integer.MIN_VALUE;
            } else {
                gu2Var = new gu2(this, ie0Var);
            }
        }
        Object obj = gu2Var.A;
        int i2 = gu2Var.Y;
        if (i2 != 0) {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return;
            } else {
                n12.S(obj);
                throw new t80();
            }
        }
        n12.S(obj);
        m24 m24Var = (m24) this.f;
        gu2Var.Y = 1;
        m24Var.a(nh4Var, gu2Var);
    }

    public boolean y(Class cls) {
        Iterator it = ((ArrayList) this.f).iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(((hc3) it.next()).getClass())) {
                return true;
            }
        }
        return false;
    }

    public hc3 z(Class cls) {
        for (hc3 hc3Var : (ArrayList) this.f) {
            if (hc3Var.getClass() == cls) {
                return hc3Var;
            }
        }
        return null;
    }

    @Override // defpackage.lk2
    public void a0(nk2 nk2Var) {
    }

    public /* synthetic */ oj1(MaterialCardView materialCardView, TextView textView, int i) {
        this.b = i;
        this.f = textView;
    }

    public /* synthetic */ oj1(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    public oj1(te3 te3Var, n02 n02Var) {
        this.b = 12;
        this.f = te3Var;
    }

    public oj1(List list) {
        this.b = 22;
        this.f = new ArrayList(list);
    }

    public oj1(byte b, int i) {
        this.b = i;
        switch (i) {
            case 26:
                this.f = new n02(this);
                break;
            default:
                this.f = (ExtraCroppingQuirk) xt0.a.z(ExtraCroppingQuirk.class);
                break;
        }
    }

    public oj1(iz4 iz4Var) {
        this.b = 29;
        this.f = new ThreadPoolExecutor(0, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, 60L, TimeUnit.SECONDS, new SynchronousQueue(), iz4Var);
    }

    public oj1(int i) {
        this.b = 16;
        this.f = n24.a(new int[i]);
    }
}
