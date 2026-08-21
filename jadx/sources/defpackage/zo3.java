package defpackage;

import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutComponent;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zo3 {
    public final ClassLoader a;
    public final cp1 b;
    public final s23 c;

    public zo3(ClassLoader classLoader, cp1 cp1Var) {
        this.a = classLoader;
        this.b = cp1Var;
        this.c = new s23(classLoader);
    }

    public static final boolean d(zo3 zo3Var) throws ClassNotFoundException {
        Class<?> clsLoadClass = zo3Var.a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
        clsLoadClass.getClass();
        return dw2.H(clsLoadClass.getMethod("addWindowLayoutInfoListener", Context.class, Consumer.class)) && dw2.H(clsLoadClass.getMethod("removeWindowLayoutInfoListener", Consumer.class));
    }

    public final WindowLayoutComponent a() {
        int iA;
        boolean zB = false;
        zB = false;
        zB = false;
        zB = false;
        zB = false;
        zB = false;
        zB = false;
        zB = false;
        if (this.c.c() && r25.W("WindowExtensions#getWindowLayoutComponent is not valid", new yo3(this, zB ? 1 : 0)) && r25.W("FoldingFeature class is not valid", new yo3(this, 1)) && (iA = y91.a()) >= 1) {
            if (iA == 1) {
                zB = c();
            } else if (iA < 5) {
                zB = b();
            } else if (b() && r25.W("DisplayFoldFeature is not valid", new yo3(this, 3)) && r25.W("SupportedWindowFeatures is not valid", new yo3(this, 2)) && r25.W("WindowLayoutComponent#getSupportedWindowFeatures is not valid", new yo3(this, 4))) {
                zB = true;
            }
        }
        if (!zB) {
            return null;
        }
        try {
            return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    public final boolean b() {
        boolean zD;
        if (c()) {
            String str = "WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid";
            try {
                zD = d(this);
                if (!zD) {
                    a1.d("ReflectionGuard", str);
                }
            } catch (ClassNotFoundException unused) {
                a1.d("ReflectionGuard", "ClassNotFound: ".concat(str));
                zD = false;
            } catch (NoSuchFieldException unused2) {
                a1.d("ReflectionGuard", "NoSuchField: ".concat(str));
                zD = false;
            } catch (NoSuchMethodException unused3) {
                a1.d("ReflectionGuard", "NoSuchMethod: ".concat(str));
                zD = false;
            }
            if (zD) {
                return true;
            }
        }
        return false;
    }

    public final boolean c() {
        return r25.W("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new yo3(this, 5));
    }
}
