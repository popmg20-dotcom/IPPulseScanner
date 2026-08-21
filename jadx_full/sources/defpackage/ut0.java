package defpackage;

import android.app.Notification;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.NetworkRequest;
import android.os.Build;
import android.view.Display;
import android.view.RoundedCorner;
import androidx.work.impl.background.systemjob.SystemJobService;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import java.util.Locale;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ut0 {
    public static int[] a(NetworkRequest networkRequest) {
        networkRequest.getClass();
        int[] capabilities = networkRequest.getCapabilities();
        capabilities.getClass();
        return capabilities;
    }

    public static bm3 b(Display display, int i) {
        RoundedCorner roundedCorner;
        int i2;
        if (Build.VERSION.SDK_INT < 31 || (roundedCorner = display.getRoundedCorner(i)) == null) {
            return null;
        }
        int position = roundedCorner.getPosition();
        if (position != 0) {
            i2 = 1;
            if (position != 1) {
                i2 = 2;
                if (position != 2) {
                    i2 = 3;
                    if (position != 3) {
                        xe.k(dw2.A(position, "Invalid position: "));
                        return null;
                    }
                }
            }
        } else {
            i2 = 0;
        }
        return new bm3(i2, roundedCorner.getRadius(), roundedCorner.getCenter());
    }

    public static int c(JobParameters jobParameters) {
        int stopReason = jobParameters.getStopReason();
        String str = SystemJobService.X;
        switch (stopReason) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
            case 10:
            case 11:
            case FileClientSessionCache.MAX_SIZE /* 12 */:
            case 13:
            case 14:
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return stopReason;
            default:
                return -512;
        }
    }

    public static o04 d(Context context) {
        PackageManager.Property property;
        uo4 uo4Var = uo4.f;
        uo4 uo4Var2 = uf2.f;
        o04 o04Var = o04.d;
        try {
            property = context.getPackageManager().getProperty("android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED", context.getPackageName());
            property.getClass();
        } catch (PackageManager.NameNotFoundException unused) {
            if (uo4Var2 == uo4Var) {
                a1.n("EmbeddingBackend", "android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED must be set and enabled in AndroidManifest.xml to use splits APIs.");
            }
        } catch (Exception e) {
            if (uo4Var2 == uo4Var) {
                a1.e("EmbeddingBackend", "PackageManager.getProperty is not supported", e);
            }
        }
        if (property.isBoolean()) {
            return property.getBoolean() ? o04.b : o04.c;
        }
        if (uo4Var2 == uo4Var) {
            a1.n("EmbeddingBackend", "android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED must have a boolean value");
            return o04Var;
        }
        return o04Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean e() {
        if (Build.VERSION.SDK_INT >= 31 && "Spreadtrum".equalsIgnoreCase(Build.SOC_MANUFACTURER)) {
            return true;
        }
        String str = Build.HARDWARE;
        str.getClass();
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        lowerCase.getClass();
        if (w44.j0(lowerCase, "ums", false)) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        str2.getClass();
        if (!str2.equalsIgnoreCase("Itel")) {
            String str3 = Build.BRAND;
            str3.getClass();
            if (str3.equalsIgnoreCase("Itel")) {
                String lowerCase2 = str.toLowerCase(locale);
                lowerCase2.getClass();
                if (w44.j0(lowerCase2, "sp", false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Typeface f(Configuration configuration, Typeface typeface) {
        int i;
        if (Build.VERSION.SDK_INT < 31 || (i = configuration.fontWeightAdjustment) == Integer.MAX_VALUE || i == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, tj4.m(typeface.getWeight() + configuration.fontWeightAdjustment, 1, 1000), typeface.isItalic());
    }

    public static void g(Notification.Action.Builder builder) {
        builder.setAuthenticationRequired(false);
    }

    public static int[] h(NetworkRequest networkRequest) {
        networkRequest.getClass();
        int[] transportTypes = networkRequest.getTransportTypes();
        transportTypes.getClass();
        return transportTypes;
    }
}
