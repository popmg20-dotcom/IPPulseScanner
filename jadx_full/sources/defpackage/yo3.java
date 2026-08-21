package defpackage;

import android.app.Activity;
import android.graphics.Rect;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yo3 implements pl1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ zo3 f;

    public /* synthetic */ yo3(zo3 zo3Var, int i) {
        this.b = i;
        this.f = zo3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018a  */
    @Override // defpackage.pl1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a() throws NoSuchMethodException, ClassNotFoundException {
        int i = this.b;
        Class<?> cls = Integer.TYPE;
        Class<?> clsJ0 = null;
        zo3 zo3Var = this.f;
        boolean z = false;
        switch (i) {
            case 0:
                Class<?> clsLoadClass = zo3Var.c.a.loadClass("androidx.window.extensions.WindowExtensions");
                clsLoadClass.getClass();
                Method method = clsLoadClass.getMethod("getWindowLayoutComponent", null);
                Class<?> clsLoadClass2 = zo3Var.a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
                clsLoadClass2.getClass();
                method.getClass();
                return Boolean.valueOf(Modifier.isPublic(method.getModifiers()) && method.getReturnType().equals(clsLoadClass2));
            case 1:
                Class<?> clsLoadClass3 = zo3Var.a.loadClass("androidx.window.extensions.layout.FoldingFeature");
                clsLoadClass3.getClass();
                Method method2 = clsLoadClass3.getMethod("getBounds", null);
                Method method3 = clsLoadClass3.getMethod("getType", null);
                Method method4 = clsLoadClass3.getMethod("getState", null);
                method2.getClass();
                Class cls2 = dh3.a(Rect.class).a;
                if (dw2.G(cls2, method2, cls2) && Modifier.isPublic(method2.getModifiers())) {
                    method3.getClass();
                    Class cls3 = dh3.a(cls).a;
                    if (dw2.G(cls3, method3, cls3) && Modifier.isPublic(method3.getModifiers())) {
                        method4.getClass();
                        Class cls4 = dh3.a(cls).a;
                        if (!dw2.G(cls4, method4, cls4) || !Modifier.isPublic(method4.getModifiers())) {
                        }
                    }
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                ClassLoader classLoader = zo3Var.a;
                Class<?> clsLoadClass4 = classLoader.loadClass("androidx.window.extensions.layout.SupportedWindowFeatures");
                clsLoadClass4.getClass();
                Method method5 = clsLoadClass4.getMethod("getDisplayFoldFeatures", null);
                Type genericReturnType = method5.getGenericReturnType();
                genericReturnType.getClass();
                Type type = ((ParameterizedType) genericReturnType).getActualTypeArguments()[0];
                type.getClass();
                Class cls5 = (Class) type;
                if (Modifier.isPublic(method5.getModifiers()) && method5.getReturnType().equals(List.class)) {
                    Class<?> clsLoadClass5 = classLoader.loadClass("androidx.window.extensions.layout.DisplayFoldFeature");
                    clsLoadClass5.getClass();
                    if (!cls5.equals(clsLoadClass5)) {
                    }
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 3:
                Class<?> clsLoadClass6 = zo3Var.a.loadClass("androidx.window.extensions.layout.DisplayFoldFeature");
                clsLoadClass6.getClass();
                Method method6 = clsLoadClass6.getMethod("getType", null);
                Method method7 = clsLoadClass6.getMethod("hasProperty", cls);
                Method method8 = clsLoadClass6.getMethod("hasProperties", int[].class);
                if (dw2.H(method6) && dw2.G(cls, method6, cls) && dw2.H(method7)) {
                    Class cls6 = Boolean.TYPE;
                    if (!dw2.G(cls6, method7, cls6) || !dw2.H(method8) || !method8.getReturnType().equals(cls6)) {
                    }
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 4:
                ClassLoader classLoader2 = zo3Var.a;
                Class<?> clsLoadClass7 = classLoader2.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
                clsLoadClass7.getClass();
                Method method9 = clsLoadClass7.getMethod("getSupportedWindowFeatures", null);
                method9.getClass();
                if (Modifier.isPublic(method9.getModifiers())) {
                    Class<?> clsLoadClass8 = classLoader2.loadClass("androidx.window.extensions.layout.SupportedWindowFeatures");
                    z = dw2.G(clsLoadClass8, method9, clsLoadClass8);
                }
                return Boolean.valueOf(z);
            default:
                try {
                    clsJ0 = zo3Var.b.j0();
                    break;
                } catch (ClassNotFoundException unused) {
                }
                if (clsJ0 != null) {
                    Class<?> clsLoadClass9 = zo3Var.a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
                    clsLoadClass9.getClass();
                    z = dw2.H(clsLoadClass9.getMethod("addWindowLayoutInfoListener", Activity.class, clsJ0)) && dw2.H(clsLoadClass9.getMethod("removeWindowLayoutInfoListener", clsJ0));
                }
                return Boolean.valueOf(z);
        }
    }
}
