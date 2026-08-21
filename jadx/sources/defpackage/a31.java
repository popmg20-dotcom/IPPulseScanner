package defpackage;

import android.util.Log;
import androidx.window.extensions.WindowExtensions;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class a31 {
    public static ActivityEmbeddingComponent a() {
        if (!c()) {
            return b();
        }
        ClassLoader classLoader = b31.class.getClassLoader();
        if (classLoader != null) {
            cp1 cp1Var = new cp1(classLoader);
            WindowExtensions windowExtensions = WindowExtensionsProvider.getWindowExtensions();
            windowExtensions.getClass();
            ActivityEmbeddingComponent activityEmbeddingComponentA = new lo3(classLoader, cp1Var, windowExtensions).a();
            if (activityEmbeddingComponentA != null) {
                return activityEmbeddingComponentA;
            }
        }
        return b();
    }

    public static ActivityEmbeddingComponent b() {
        Object objNewProxyInstance = Proxy.newProxyInstance(b31.class.getClassLoader(), new Class[]{ActivityEmbeddingComponent.class}, new z21());
        objNewProxyInstance.getClass();
        return (ActivityEmbeddingComponent) objNewProxyInstance;
    }

    public static boolean c() {
        try {
            ClassLoader classLoader = b31.class.getClassLoader();
            if (classLoader == null) {
                return false;
            }
            cp1 cp1Var = new cp1(classLoader);
            WindowExtensions windowExtensions = WindowExtensionsProvider.getWindowExtensions();
            windowExtensions.getClass();
            return new lo3(classLoader, cp1Var, windowExtensions).a() != null;
        } catch (NoClassDefFoundError unused) {
            Log.d("EmbeddingCompat", "Embedding extension version not found");
            return false;
        } catch (UnsupportedOperationException unused2) {
            Log.d("EmbeddingCompat", "Stub Extension");
            return false;
        }
    }
}
