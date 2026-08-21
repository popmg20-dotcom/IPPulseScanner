package io.sentry.android.replay.viewhierarchy;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import defpackage.n12;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static Boolean a;
    public static io.sentry.internal.debugmeta.c b;

    public static List a(LayoutNode layoutNode) throws IllegalAccessException, InvocationTargetException {
        Boolean bool = a;
        Boolean bool2 = Boolean.FALSE;
        if (n12.c(bool, bool2)) {
            return layoutNode.getChildren$ui();
        }
        if (n12.c(bool, Boolean.TRUE)) {
            Method method = (Method) b().f;
            method.getClass();
            Object objInvoke = method.invoke(layoutNode, null);
            objInvoke.getClass();
            return (List) objInvoke;
        }
        if (bool != null) {
            defpackage.g.d();
            return null;
        }
        try {
            List children$ui = layoutNode.getChildren$ui();
            a = bool2;
            return children$ui;
        } catch (NoSuchMethodError unused) {
            a = Boolean.TRUE;
            Method method2 = (Method) b().f;
            method2.getClass();
            Object objInvoke2 = method2.invoke(layoutNode, null);
            objInvoke2.getClass();
            return (List) objInvoke2;
        }
    }

    public static io.sentry.internal.debugmeta.c b() {
        Method declaredMethod;
        io.sentry.internal.debugmeta.c cVar = b;
        if (cVar != null) {
            return cVar;
        }
        Method method = null;
        try {
            declaredMethod = LayoutNode.class.getDeclaredMethod("getChildren$ui_release", null);
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
            declaredMethod = null;
        }
        try {
            Method declaredMethod2 = LayoutNode.class.getDeclaredMethod("getOuterCoordinator$ui_release", null);
            declaredMethod2.setAccessible(true);
            method = declaredMethod2;
        } catch (NoSuchMethodException unused2) {
        }
        io.sentry.internal.debugmeta.c cVar2 = new io.sentry.internal.debugmeta.c(declaredMethod, method);
        b = cVar2;
        return cVar2;
    }

    public static boolean c(LayoutNode layoutNode) throws IllegalAccessException, InvocationTargetException {
        layoutNode.getClass();
        Boolean bool = a;
        Boolean bool2 = Boolean.FALSE;
        if (n12.c(bool, bool2)) {
            return layoutNode.getOuterCoordinator$ui().isTransparent();
        }
        if (n12.c(bool, Boolean.TRUE)) {
            Method method = (Method) b().z;
            method.getClass();
            Object objInvoke = method.invoke(layoutNode, null);
            objInvoke.getClass();
            return ((NodeCoordinator) objInvoke).isTransparent();
        }
        if (bool != null) {
            defpackage.g.d();
            return false;
        }
        try {
            boolean zIsTransparent = layoutNode.getOuterCoordinator$ui().isTransparent();
            a = bool2;
            return zIsTransparent;
        } catch (NoSuchMethodError unused) {
            a = Boolean.TRUE;
            Method method2 = (Method) b().z;
            method2.getClass();
            Object objInvoke2 = method2.invoke(layoutNode, null);
            objInvoke2.getClass();
            return ((NodeCoordinator) objInvoke2).isTransparent();
        }
    }
}
