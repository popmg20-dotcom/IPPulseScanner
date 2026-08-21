package defpackage;

import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class qe4 {
    public static on4 a(mn4 mn4Var) {
        return (on4) mn4Var.u(mn4.k0);
    }

    public static int b(mn4 mn4Var) {
        return ((Integer) mn4Var.p(mn4.l0, 0)).intValue();
    }

    public static int c(mn4 mn4Var) {
        return ((Integer) mn4Var.p(mn4.f0, 0)).intValue();
    }

    public static d44 d(mn4 mn4Var) {
        d44 d44Var = (d44) mn4Var.p(mn4.o0, d44.DEFAULT);
        Objects.requireNonNull(d44Var);
        return d44Var;
    }

    public static int e(mn4 mn4Var) {
        return ((Integer) mn4Var.p(mn4.e0, 0)).intValue();
    }

    public static kn4 f(mn4 mn4Var) {
        kn4 kn4Var = (kn4) mn4Var.p(mn4.n0, new kn4());
        Objects.requireNonNull(kn4Var);
        return kn4Var;
    }

    public static int g(mn4 mn4Var) {
        return ((Integer) mn4Var.p(mn4.m0, 0)).intValue();
    }

    public static boolean h(mn4 mn4Var) {
        return ((Boolean) mn4Var.p(mn4.j0, Boolean.FALSE)).booleanValue();
    }

    public static boolean i(mn4 mn4Var) {
        Boolean bool = (Boolean) mn4Var.p(mn4.h0, Boolean.FALSE);
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    public static boolean j(mn4 mn4Var) {
        return ((Boolean) mn4Var.p(mn4.i0, Boolean.FALSE)).booleanValue();
    }

    public static p95 k(int i, int i2, int i3) {
        if (i == -2) {
            return ru0.n;
        }
        int i4 = i - i3;
        if (i4 > 0) {
            return new qu0(i4);
        }
        int i5 = i2 - i3;
        if (i5 > 0) {
            return new qu0(i5);
        }
        return null;
    }

    public static wx3 l(cf3 cf3Var) {
        View view = cf3Var.a;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        p95 p95VarK = k(layoutParams != null ? layoutParams.width : -1, view.getWidth(), view.getPaddingRight() + view.getPaddingLeft());
        if (p95VarK == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        p95 p95VarK2 = k(layoutParams2 != null ? layoutParams2.height : -1, view.getHeight(), view.getPaddingBottom() + view.getPaddingTop());
        if (p95VarK2 == null) {
            return null;
        }
        return new wx3(p95VarK, p95VarK2);
    }

    public static int m(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            default:
                switch (i) {
                    case 20:
                        return 10;
                    case 21:
                        return 11;
                    case 22:
                        return 12;
                    default:
                        return 0;
                }
        }
    }

    public static /* synthetic */ int n(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return 8;
            case 10:
                return 20;
            case 11:
                return 21;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return 22;
            default:
                throw null;
        }
    }

    public static int o(int i, int i2, int i3) {
        return kb5.r(i) + i2 + i3;
    }

    public static int p(int i, int i2, int i3, int i4) {
        return kb5.r(i) + i2 + i3 + i4;
    }

    public static int q(int i, int i2, int i3, int i4, int i5) {
        return Math.max(((i * i2) / i3) + i4, i5);
    }

    public static ClassCastException r(ArrayList arrayList, int i) {
        arrayList.get(i).getClass();
        return new ClassCastException();
    }

    public static /* synthetic */ void s(AutoCloseable autoCloseable) throws Exception {
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (autoCloseable instanceof ExecutorService) {
            l0.u((ExecutorService) autoCloseable);
            return;
        }
        if (autoCloseable instanceof TypedArray) {
            ((TypedArray) autoCloseable).recycle();
            return;
        }
        if (autoCloseable instanceof MediaMetadataRetriever) {
            ((MediaMetadataRetriever) autoCloseable).release();
            return;
        }
        if (autoCloseable instanceof MediaDrm) {
            ((MediaDrm) autoCloseable).release();
            return;
        }
        if (autoCloseable instanceof DrmManagerClient) {
            ((DrmManagerClient) autoCloseable).release();
        } else if (autoCloseable instanceof ContentProviderClient) {
            ((ContentProviderClient) autoCloseable).release();
        } else {
            s53.d();
        }
    }

    public static /* synthetic */ String t(int i) {
        switch (i) {
            case 1:
                return "CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN";
            case 2:
                return "CLIENT_UPLOAD_ELIGIBLE";
            case 3:
                return "MEASUREMENT_SERVICE_NOT_ENABLED";
            case 4:
                return "ANDROID_TOO_OLD";
            case 5:
                return "NON_PLAY_MODE";
            case 6:
                return "SDK_TOO_OLD";
            case 7:
                return "MISSING_JOB_SCHEDULER";
            case 8:
                return "NOT_ENABLED_IN_MANIFEST";
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return "CLIENT_FLAG_OFF";
            case 10:
                return "SERVICE_FLAG_OFF";
            case 11:
                return "PINNED_TO_SERVICE_UPLOAD";
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return "MISSING_SGTM_SERVER_URL";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String u(int i) {
        switch (i) {
            case 1:
                return "Alias";
            case 2:
                return "Anchor";
            case 3:
                return "BlockEnd";
            case 4:
                return "BlockEntry";
            case 5:
                return "BlockMappingStart";
            case 6:
                return "BlockSequenceStart";
            case 7:
                return "Directive";
            case 8:
                return "DocumentEnd";
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return "DocumentStart";
            case 10:
                return "FlowEntry";
            case 11:
                return "FlowMappingEnd";
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return "FlowMappingStart";
            case 13:
                return "FlowSequenceEnd";
            case 14:
                return "FlowSequenceStart";
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return "Key";
            case 16:
                return "Scalar";
            case 17:
                return "StreamEnd";
            case 18:
                return "StreamStart";
            case 19:
                return "Tag";
            case 20:
                return "Comment";
            case 21:
                return "Value";
            default:
                return "null";
        }
    }

    public static d25 v(v15 v15Var, i25 i25Var, ih4 ih4Var, ArrayList arrayList) {
        String str = i25Var.b;
        if (v15Var.c(str)) {
            d25 d25VarA = v15Var.a(str);
            if (d25VarA instanceof s15) {
                return ((s15) d25VarA).j(ih4Var, arrayList);
            }
            xe.k(ha0.x(str, " is not a function"));
            return null;
        }
        if ("hasOwnProperty".equals(str)) {
            je.k0("hasOwnProperty", 1, arrayList);
            return v15Var.c(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).h()) ? d25.v0 : d25.w0;
        }
        xe.k(ha0.n("Object has no function ", str));
        return null;
    }
}
