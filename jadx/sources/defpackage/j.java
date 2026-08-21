package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import com.getsurfboard.R;
import io.netty.channel.internal.ChannelUtils;
import java.io.Closeable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public static final Bitmap.Config a;
    public static final lr1 b;

    static {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            Bitmap.Config unused = Bitmap.Config.RGBA_F16;
        } else {
            Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        }
        if (i >= 26) {
            config = Bitmap.Config.HARDWARE;
        }
        a = config;
        b = new lr1((String[]) new ArrayList(20).toArray(new String[0]));
    }

    public static final void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final String b(MimeTypeMap mimeTypeMap, String str) {
        if (str == null || p44.x0(str)) {
            return null;
        }
        String strR0 = p44.R0(p44.R0(str, '#'), '?');
        return mimeTypeMap.getMimeTypeFromExtension(p44.P0(p44.P0(strR0, '/', strR0), '.', ""));
    }

    public static final jr4 c(ImageView imageView) {
        jr4 jr4Var;
        Object tag = imageView.getTag(R.id.coil_request_manager);
        jr4 jr4Var2 = tag instanceof jr4 ? (jr4) tag : null;
        if (jr4Var2 != null) {
            return jr4Var2;
        }
        synchronized (imageView) {
            try {
                Object tag2 = imageView.getTag(R.id.coil_request_manager);
                jr4Var = tag2 instanceof jr4 ? (jr4) tag2 : null;
                if (jr4Var == null) {
                    jr4Var = new jr4();
                    imageView.addOnAttachStateChangeListener(jr4Var);
                    imageView.setTag(R.id.coil_request_manager, jr4Var);
                }
            } finally {
            }
        }
        return jr4Var;
    }

    public static final boolean d(Uri uri) {
        return n12.c(uri.getScheme(), "file") && n12.c((String) d70.e0(uri.getPathSegments()), "android_asset");
    }

    public static final int e(p95 p95Var, sp3 sp3Var) {
        if (p95Var instanceof qu0) {
            return ((qu0) p95Var).n;
        }
        int iOrdinal = sp3Var.ordinal();
        if (iOrdinal == 0) {
            return Integer.MIN_VALUE;
        }
        if (iOrdinal == 1) {
            return ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        }
        g.d();
        return 0;
    }
}
