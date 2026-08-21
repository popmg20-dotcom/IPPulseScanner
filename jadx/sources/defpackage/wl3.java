package defpackage;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import com.getsurfboard.R;
import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.dns.DnsRecord;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wl3 implements ap, ad1, n90, bf0, fg, yt, y23, za1, hf1, ar1, pk3 {
    public static wl3 A0;
    public static wl3 f;
    public final /* synthetic */ int b;
    public static final wl3 z = new wl3(1);
    public static final wl3 A = new wl3(2);
    public static final wl3 X = new wl3(3);
    public static final wl3 Y = new wl3(4);
    public static final wl3 Z = new wl3(5);
    public static final String[] y0 = {"select", "load-balance", "url-test", "fallback", "smart", "subnet", "ssid"};
    public static final wl3 z0 = new wl3(7);

    public wl3(nw nwVar, sy syVar, oj1 oj1Var, at3 at3Var, xq1 xq1Var) {
        this.b = 11;
        Integer num = (Integer) syVar.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num != null) {
            num.intValue();
        }
        new o84(oj1Var);
        gb4.R(new fx(syVar, 1));
    }

    public static ArrayList k(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ba3) obj) != ba3.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(f70.Q(10, arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ba3) it.next()).b);
        }
        return arrayList2;
    }

    public static byte[] o(List list) {
        hp hpVar = new hp();
        for (String str : k(list)) {
            hpVar.J0(str.length());
            hpVar.Q0(str);
        }
        return hpVar.X(hpVar.f);
    }

    @Override // defpackage.yt
    public byte[] a(int i, int i2, byte[] bArr) {
        return Arrays.copyOfRange(bArr, i, i2 + i);
    }

    @Override // defpackage.ar1
    public boolean b(wx3 wx3Var) {
        p95 p95Var = wx3Var.a;
        boolean z2 = p95Var instanceof qu0;
        int i = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        if ((z2 ? ((qu0) p95Var).n : Integer.MAX_VALUE) <= 100) {
            return false;
        }
        p95 p95Var2 = wx3Var.b;
        if (p95Var2 instanceof qu0) {
            i = ((qu0) p95Var2).n;
        }
        return i > 100;
    }

    @Override // defpackage.fg
    public void c(gl1 gl1Var) {
        gl1Var.getClass();
        gl1Var.C("UPDATE WorkSpec SET `last_enqueue_time` = -1 WHERE `last_enqueue_time` = 0");
    }

    @Override // defpackage.hf1
    public boolean d(aw awVar) {
        return awVar.c > awVar.e;
    }

    @Override // defpackage.y23
    public CharSequence e(Preference preference) {
        EditTextPreference editTextPreference = (EditTextPreference) preference;
        return TextUtils.isEmpty(editTextPreference.k1) ? editTextPreference.b.getString(R.string.not_set) : editTextPreference.k1;
    }

    @Override // defpackage.pk3
    public void f(ns4 ns4Var) {
        ns4Var.getClass();
        ns4Var.printStackTrace();
        cr2.f(cr2.a, new ei0(i24.z, null));
    }

    @Override // defpackage.n90
    public Object g(rk3 rk3Var) {
        Object objD = rk3Var.d(new fc3(ha2.class, Executor.class));
        objD.getClass();
        return n12.x((Executor) objD);
    }

    @Override // defpackage.ap
    public Rect h(Activity activity) {
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!ga5.v(activity)) {
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            Resources resources = activity.getResources();
            int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
            int i = rect.bottom + dimensionPixelSize;
            if (i == point.y) {
                rect.bottom = i;
                return rect;
            }
            int i2 = rect.right + dimensionPixelSize;
            if (i2 == point.x) {
                rect.right = i2;
            }
        }
        return rect;
    }

    @Override // defpackage.hf1
    public aw i(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float fD = eh4.d(f6, f8, f3, f4, f2, true);
        float f9 = fD / f6;
        float f10 = fD / f8;
        return new aw(f9, f10, f5 * f9, fD, f7 * f10, fD);
    }

    @Override // defpackage.ar1
    public boolean j() {
        boolean z2;
        synchronized (od1.a) {
            try {
                int i = od1.c;
                od1.c = i + 1;
                if (i >= 30 || SystemClock.uptimeMillis() > od1.d + 30000) {
                    od1.c = 0;
                    od1.d = SystemClock.uptimeMillis();
                    String[] list = od1.b.list();
                    if (list == null) {
                        list = new String[0];
                    }
                    od1.e = list.length < 800;
                }
                z2 = od1.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    @Override // defpackage.za1
    public w90 l(float f2, float f3, float f4) {
        switch (this.b) {
            case 17:
                return new w90(DnsRecord.CLASS_ANY, eh4.e(f3, f4, f2, 0, DnsRecord.CLASS_ANY), true);
            default:
                float fH = ha0.h(f4, f3, 0.35f, f3);
                return new w90(eh4.e(f3, fH, f2, DnsRecord.CLASS_ANY, 0), eh4.e(fH, f4, f2, 0, DnsRecord.CLASS_ANY), false);
        }
    }

    @Override // defpackage.ad1
    public String m(String str, String str2) throws IOException {
        str.getClass();
        str2.getClass();
        hx0 hx0VarQ = vo.q(str);
        byte[] bArr = hx0VarQ != null ? hx0VarQ.b : null;
        if (bArr != null) {
            return gb4.c0(bArr);
        }
        g.g("can not find local domain set: ".concat(str2));
        return null;
    }

    @Override // defpackage.hf1
    public void n(RectF rectF, float f2, aw awVar) {
        float fAbs = (Math.abs(awVar.e - awVar.c) / 2.0f) * f2;
        rectF.left += fAbs;
        rectF.right -= fAbs;
    }

    @Override // defpackage.pk3
    public void p(Object obj) {
        Object next;
        String str = (String) obj;
        str.getClass();
        String strConcat = "CloudflareCGITrace: ".concat(str);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "NetworkDetector", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("NetworkDetector", strConcat, null);
        }
        Iterator it = p44.B0(str).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (w44.j0((String) next, "ip=", false)) {
                    break;
                }
            }
        }
        String str2 = (String) next;
        String strSubstring = str2 != null ? str2.substring(3) : null;
        if (xz1.a(strSubstring)) {
            cr2.f(cr2.a, new ei0(i24.f, strSubstring));
        } else {
            cr2.f(cr2.a, new ei0(i24.z, null));
        }
    }

    public String toString() {
        switch (this.b) {
            case 29:
                return "SharingStarted.Lazily";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ wl3(int i) {
        this.b = i;
    }
}
