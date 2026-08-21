package defpackage;

import java.lang.reflect.Proxy;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s23 {
    public final ClassLoader a;

    public /* synthetic */ s23(ClassLoader classLoader) {
        this.a = classLoader;
    }

    public Object a(j50 j50Var, j50 j50Var2, Function2 function2) throws ClassNotFoundException {
        q23 q23Var = new q23(j50Var, j50Var2, function2);
        ClassLoader classLoader = this.a;
        Class<?> clsLoadClass = classLoader.loadClass("java.util.function.Predicate");
        clsLoadClass.getClass();
        Object objNewProxyInstance = Proxy.newProxyInstance(classLoader, new Class[]{clsLoadClass}, q23Var);
        objNewProxyInstance.getClass();
        return objNewProxyInstance;
    }

    public Object b(j50 j50Var, am1 am1Var) throws ClassNotFoundException {
        r23 r23Var = new r23(j50Var, am1Var);
        ClassLoader classLoader = this.a;
        Class<?> clsLoadClass = classLoader.loadClass("java.util.function.Predicate");
        clsLoadClass.getClass();
        Object objNewProxyInstance = Proxy.newProxyInstance(classLoader, new Class[]{clsLoadClass}, r23Var);
        objNewProxyInstance.getClass();
        return objNewProxyInstance;
    }

    public boolean c() {
        try {
            this.a.loadClass("androidx.window.extensions.WindowExtensionsProvider").getClass();
            return r25.W("WindowExtensionsProvider#getWindowExtensions is not valid", new fn(20, this));
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            return false;
        }
    }
}
