package defpackage;

import android.util.Log;
import androidx.window.extensions.WindowExtensionsProvider;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class y91 {
    public static final String a = dh3.a(y91.class).c();

    public static int a() {
        uo4 uo4Var = uo4.f;
        uo4 uo4Var2 = uf2.f;
        String str = a;
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        } catch (NoClassDefFoundError unused) {
            if (uo4Var2 != uo4Var) {
                return 0;
            }
            Log.d(str, "Embedding extension version not found");
            return 0;
        } catch (NullPointerException unused2) {
            if (uo4Var2 != uo4Var) {
                return 0;
            }
            Log.d(str, "Error with Extension implementation");
            return 0;
        } catch (UnsupportedOperationException unused3) {
            if (uo4Var2 != uo4Var) {
                return 0;
            }
            Log.d(str, "Stub Extension");
            return 0;
        }
    }
}
