package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.FrameMetricsAggregator;
import io.sentry.a2;
import io.sentry.android.core.p0;
import io.sentry.d4;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.s4;
import io.sentry.transport.f;
import io.sentry.util.e;
import io.sentry.z6;
import java.io.IOException;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class st4 implements a2, e, d4, f {
    public final /* synthetic */ int b;

    public /* synthetic */ st4(int i) {
        this.b = i;
    }

    public static /* synthetic */ void g() {
        throw new IllegalStateException();
    }

    public static /* synthetic */ void i(Object obj, String str) throws IOException {
        throw new IOException(str + obj);
    }

    public static /* synthetic */ void j(String str) throws qy4 {
        throw new qy4(str);
    }

    public static /* synthetic */ void k(String str, Object obj, Object obj2) {
        throw new NumberFormatException(str + obj + obj2);
    }

    public static /* synthetic */ void l(String str, Throwable th) {
        throw new IllegalArgumentException(str, th);
    }

    public static /* synthetic */ void m(StringBuilder sb, Object obj) {
        sb.append(obj);
        throw new IllegalStateException(sb.toString());
    }

    public static /* synthetic */ void n() {
        throw new ClassCastException();
    }

    public static /* synthetic */ void o(Object obj, String str) {
        throw new IllegalArgumentException((str + obj).toString());
    }

    public static /* synthetic */ void p(String str, Object obj, Object obj2) {
        throw new IllegalArgumentException(str + obj + obj2);
    }

    @Override // io.sentry.a2
    public Object a() {
        return null;
    }

    @Override // io.sentry.transport.f
    public long c() {
        return SystemClock.uptimeMillis();
    }

    public Object d(Context context) {
        String string = null;
        switch (this.b) {
            case 22:
                return p0.g(context);
            case 23:
                try {
                    return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                } catch (Throwable unused) {
                    return null;
                }
            case 24:
                try {
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    int i = applicationInfo.labelRes;
                    if (i == 0) {
                        CharSequence charSequence = applicationInfo.nonLocalizedLabel;
                        string = charSequence != null ? charSequence.toString() : context.getPackageManager().getApplicationLabel(applicationInfo).toString();
                    } else {
                        string = context.getString(i);
                    }
                    break;
                } catch (Throwable unused2) {
                }
                return string;
            case 25:
                return p0.h(context);
            default:
                try {
                    return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                } catch (Throwable unused3) {
                    return null;
                }
        }
    }

    @Override // io.sentry.util.e
    public Object e() {
        switch (this.b) {
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return p6.empty();
            case 13:
                return p6.empty();
            case 18:
                return new s4();
            case 20:
                return new FrameMetricsAggregator();
            default:
                try {
                    return Build.MODEL.split(" ", -1)[0];
                } catch (Throwable unused) {
                    p5 p5Var = p5.DEBUG;
                    return null;
                }
        }
    }

    @Override // io.sentry.d4
    public void b(z6 z6Var) {
    }
}
