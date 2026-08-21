package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.media.CamcorderProfile;
import android.text.TextUtils;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowManager;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import com.getsurfboard.R;
import io.netty.handler.codec.dns.DnsRecord;
import io.sentry.android.core.a1;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class t60 implements ap, oa2, cd1, n90, kv4, bw, rw1, ya1, mc1, y23, sk0 {
    public static t60 B0;
    public static te3 f;
    public static final t60 b = new t60();
    public static final t60 z = new t60();
    public static final t60 A = new t60();
    public static final t60 X = new t60();
    public static final t60 Y = new t60();
    public static final t60 Z = new t60();
    public static final t60 y0 = new t60();
    public static final t60 z0 = new t60();
    public static final t60 A0 = new t60();

    public static dj3 j(String str, pj2 pj2Var) {
        Charset charset = y30.a;
        if (pj2Var != null) {
            uh3 uh3Var = pj2.e;
            Charset charsetA = pj2Var.a(null);
            if (charsetA == null) {
                try {
                    pj2Var = p95.n(pj2Var + "; charset=utf-8");
                } catch (IllegalArgumentException unused) {
                    pj2Var = null;
                }
            } else {
                charset = charsetA;
            }
        }
        byte[] bytes = str.getBytes(charset);
        bytes.getClass();
        int length = bytes.length;
        hz4.a(bytes.length, 0L, length);
        return new dj3(pj2Var, length, bytes);
    }

    public static bu k(String str) {
        if (str.length() % 2 != 0) {
            e04.f("Unexpected hex string: ".concat(str));
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (vo.k(str.charAt(i2 + 1)) + (vo.k(str.charAt(i2)) << 4));
        }
        return new bu(bArr);
    }

    public static bu n(String str) {
        str.getClass();
        byte[] bytes = str.getBytes(y30.a);
        bytes.getClass();
        bu buVar = new bu(bytes);
        buVar.z = str;
        return buVar;
    }

    public static final te3 o(Context context) {
        te3 te3Var = f;
        if (te3Var != null) {
            return te3Var;
        }
        synchronized (b) {
            te3 te3Var2 = f;
            if (te3Var2 != null) {
                return te3Var2;
            }
            context.getApplicationContext();
            te3 te3VarE = new iv1(context).e();
            f = te3VarE;
            return te3VarE;
        }
    }

    public static bu p(byte[] bArr) {
        bu buVar = bu.A;
        int length = bArr.length;
        l72.f(bArr.length, 0L, length);
        return new bu(qe.h0(0, length, bArr));
    }

    @Override // defpackage.kv4
    public jv4 a(Activity activity, eo0 eo0Var) {
        ap.d.getClass();
        return new jv4(new yo(zo.a().h(activity)), eo0Var.d(activity));
    }

    @Override // defpackage.mc1
    public boolean b(tt3 tt3Var) {
        return false;
    }

    @Override // defpackage.kv4
    public jv4 c(Context context, eo0 eo0Var) {
        Context baseContext = context;
        while (true) {
            if (!(baseContext instanceof ContextWrapper)) {
                baseContext = context;
                break;
            }
            if ((baseContext instanceof Activity) || (baseContext instanceof InputMethodService)) {
                break;
            }
            ContextWrapper contextWrapper = (ContextWrapper) baseContext;
            if (contextWrapper.getBaseContext() == null) {
                break;
            }
            baseContext = contextWrapper.getBaseContext();
            baseContext.getClass();
        }
        if (baseContext instanceof Activity) {
            return a((Activity) baseContext, eo0Var);
        }
        if (!(baseContext instanceof InputMethodService) && !(baseContext instanceof Application)) {
            xe.k("Must provide a UiContext or Application Context");
            return null;
        }
        Object systemService = context.getSystemService("window");
        systemService.getClass();
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        defaultDisplay.getClass();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return new jv4(new Rect(0, 0, point.x, point.y), eo0Var.d(context));
    }

    @Override // defpackage.bw
    public CamcorderProfile d(int i, int i2) {
        return CamcorderProfile.get(i, i2);
    }

    @Override // defpackage.y23
    public CharSequence e(Preference preference) {
        CharSequence[] charSequenceArr;
        CharSequence[] charSequenceArr2;
        ListPreference listPreference = (ListPreference) preference;
        int iA = listPreference.A(listPreference.m1);
        if (TextUtils.isEmpty((iA < 0 || (charSequenceArr2 = listPreference.k1) == null) ? null : charSequenceArr2[iA])) {
            return listPreference.b.getString(R.string.not_set);
        }
        int iA2 = listPreference.A(listPreference.m1);
        if (iA2 < 0 || (charSequenceArr = listPreference.k1) == null) {
            return null;
        }
        return charSequenceArr[iA2];
    }

    @Override // defpackage.cd1
    public String f(String str, String str2) {
        n13 n13VarO = fx3.o(str);
        int i = 2;
        if (n13VarO != null) {
            if (System.currentTimeMillis() - n13VarO.d > 86400000) {
                boolean z2 = nj3.a;
                (nj3.a ? nj3.f : nj3.e).a(new bd1(str2, new th1(str, i)));
            }
            return gb4.c0(n13VarO.b);
        }
        boolean z3 = nj3.a;
        String strB = nj3.b(str2, nj3.a);
        ez4.X("save_policy_path", new zc1(str, strB, i));
        return strB;
    }

    @Override // defpackage.n90
    public Object g(rk3 rk3Var) {
        Object objD = rk3Var.d(new fc3(un.class, Executor.class));
        objD.getClass();
        return n12.x((Executor) objD);
    }

    @Override // defpackage.ap
    public Rect h(Activity activity) throws Exception {
        DisplayCutout displayCutoutE;
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (ga5.v(activity)) {
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                objInvoke.getClass();
                rect.set((Rect) objInvoke);
            } else {
                Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                objInvoke2.getClass();
                rect.set((Rect) objInvoke2);
            }
        } catch (Exception e) {
            if (!(e instanceof NoSuchFieldException) && !(e instanceof NoSuchMethodException) && !(e instanceof IllegalAccessException) && !(e instanceof InvocationTargetException)) {
                throw e;
            }
            ap.d.getClass();
            a1.m(zo.b, e);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        if (!ga5.v(activity)) {
            Resources resources = activity.getResources();
            int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
            int i = rect.bottom + dimensionPixelSize;
            if (i == point.y) {
                rect.bottom = i;
            } else {
                int i2 = rect.right + dimensionPixelSize;
                if (i2 == point.x) {
                    rect.right = i2;
                } else if (rect.left == dimensionPixelSize) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !ga5.v(activity) && (displayCutoutE = u9.e(defaultDisplay)) != null) {
            if (rect.left == u9.z(displayCutoutE)) {
                rect.left = 0;
            }
            if (point.x - rect.right == u9.A(displayCutoutE)) {
                rect.right = u9.A(displayCutoutE) + rect.right;
            }
            if (rect.top == u9.B(displayCutoutE)) {
                rect.top = 0;
            }
            if (point.y - rect.bottom == u9.y(displayCutoutE)) {
                rect.bottom = u9.y(displayCutoutE) + rect.bottom;
            }
        }
        return rect;
    }

    public float i(float f2) {
        return 1.0f;
    }

    @Override // defpackage.ya1
    public w90 l(float f2, float f3, float f4) {
        return new w90(fh4.e(f3, f4, f2, DnsRecord.CLASS_ANY, 0), DnsRecord.CLASS_ANY, false);
    }

    @Override // defpackage.rw1
    public String[] m() {
        return new String[]{"TM_CURRENT_LINE", "TM_LINE_INDEX", "TM_LINE_NUMBER", "CURSOR_INDEX", "CURSOR_NUMBER", "TM_CURRENT_WORD", "SELECTION", "TM_SELECTED_TEXT"};
    }

    @Override // defpackage.bw
    public boolean q(int i, int i2) {
        return CamcorderProfile.hasProfile(i, i2);
    }

    @Override // defpackage.sk0
    public int r(int i, int i2, byte[] bArr) {
        return i2;
    }
}
