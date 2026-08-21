package defpackage;

import android.content.Context;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ue2 implements wz0 {
    public static final Object f = new Object();
    public static volatile ue2 z;
    public int b;

    public ue2(int i) {
        switch (i) {
            case 7:
                this.b = 300;
                break;
            case 8:
            default:
                this.b = 1;
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                this.b = y91.a();
                break;
        }
    }

    public static ue2 g() {
        ue2 ue2Var;
        synchronized (f) {
            try {
                if (z == null) {
                    z = new ue2(3, false);
                }
                ue2Var = z;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ue2Var;
    }

    public static String i(String str) {
        int length = str.length();
        StringBuilder sbB = fw.B(23, "WM-");
        if (length >= 20) {
            sbB.append(str.substring(0, 20));
        } else {
            sbB.append(str);
        }
        return sbB.toString();
    }

    public void a(String str, String str2) {
        if (this.b <= 3) {
            Log.d(str, str2);
        }
    }

    @Override // defpackage.wz0
    public int b(Context context, String str, boolean z2) {
        return 0;
    }

    @Override // defpackage.wz0
    public int c(Context context, String str) {
        return this.b;
    }

    public void d(String str, String str2, Throwable th) {
        if (this.b <= 3) {
            Log.d(str, str2, th);
        }
    }

    public void e(String str, String str2) {
        if (this.b <= 6) {
            a1.d(str, str2);
        }
    }

    public void f(String str, String str2, Throwable th) {
        if (this.b <= 6) {
            a1.e(str, str2, th);
        }
    }

    public void h(String str, String str2) {
        if (this.b <= 4) {
            Log.i(str, str2);
        }
    }

    public void j(String str, String str2) {
        if (this.b <= 5) {
            a1.n(str, str2);
        }
    }

    public /* synthetic */ ue2(int i, boolean z2) {
        this.b = i;
    }
}
