package defpackage;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import android.content.res.loader.ResourcesProvider;
import android.graphics.Rect;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.ext.SdkExtensions;
import android.system.Os;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import io.sentry.android.core.a1;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class j2 {
    public static boolean a(ContextThemeWrapper contextThemeWrapper, HashMap map) throws Throwable {
        FileDescriptor fileDescriptorMemfd_create;
        ResourcesLoader resourcesLoader = null;
        try {
            byte[] bArrD = gb4.D(contextThemeWrapper, map);
            Log.i("ColorResLoaderCreator", "Table created, length: " + bArrD.length);
            if (bArrD.length != 0) {
                try {
                    fileDescriptorMemfd_create = Os.memfd_create("temp.arsc", 0);
                    try {
                        if (fileDescriptorMemfd_create == null) {
                            a1.n("ColorResLoaderCreator", "Cannot create memory file descriptor.");
                            if (fileDescriptorMemfd_create != null) {
                                Os.close(fileDescriptorMemfd_create);
                            }
                        } else {
                            FileOutputStream fileOutputStream = new FileOutputStream(fileDescriptorMemfd_create);
                            try {
                                fileOutputStream.write(bArrD);
                                ParcelFileDescriptor parcelFileDescriptorDup = ParcelFileDescriptor.dup(fileDescriptorMemfd_create);
                                try {
                                    ResourcesLoader resourcesLoader2 = new ResourcesLoader();
                                    resourcesLoader2.addProvider(ResourcesProvider.loadFromTable(parcelFileDescriptorDup, null));
                                    if (parcelFileDescriptorDup != null) {
                                        parcelFileDescriptorDup.close();
                                    }
                                    fileOutputStream.close();
                                    Os.close(fileDescriptorMemfd_create);
                                    resourcesLoader = resourcesLoader2;
                                } finally {
                                }
                            } finally {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileDescriptorMemfd_create != null) {
                            Os.close(fileDescriptorMemfd_create);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileDescriptorMemfd_create = null;
                }
            }
        } catch (Exception e) {
            a1.e("ColorResLoaderCreator", "Failed to create the ColorResourcesTableCreator.", e);
        }
        if (resourcesLoader == null) {
            return false;
        }
        contextThemeWrapper.getResources().addLoaders(resourcesLoader);
        return true;
    }

    public static Context b(Context context, String str) {
        return context.createAttributionContext(str);
    }

    public static Icon c(Uri uri) {
        return Icon.createWithAdaptiveBitmapContentUri(uri);
    }

    public static String d(Context context) {
        return context.getAttributionTag();
    }

    public static Rect e(WindowMetrics windowMetrics) {
        Rect bounds = windowMetrics.getBounds();
        bounds.getClass();
        return bounds;
    }

    public static Rect f(WindowManager windowManager) {
        return windowManager.getCurrentWindowMetrics().getBounds();
    }

    public static void g(int i) {
        SdkExtensions.getExtensionVersion(i);
    }

    public static CharSequence h(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getStateDescription();
    }

    public static String i(q4 q4Var) {
        q4Var.getClass();
        if (q4Var instanceof p4) {
            return "image/*";
        }
        if (q4Var instanceof o4) {
            return null;
        }
        g.d();
        return null;
    }

    public static boolean j() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            return true;
        }
        return i >= 30 && SdkExtensions.getExtensionVersion(30) >= 2;
    }

    public static void k(Window window, boolean z) {
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z ? systemUiVisibility & (-257) : systemUiVisibility | 256);
        window.setDecorFitsSystemWindows(z);
    }

    public static void l(Window window, boolean z) {
        window.setDecorFitsSystemWindows(z);
    }

    public static void m(EditorInfo editorInfo, CharSequence charSequence) {
        editorInfo.setInitialSurroundingSubText(charSequence, 0);
    }

    public static void n(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        accessibilityNodeInfo.setStateDescription(charSequence);
    }
}
