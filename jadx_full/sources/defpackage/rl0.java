package defpackage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ServiceLoader;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class rl0 extends r0 {
    public static final we2 Y = xe2.c(rl0.class);
    public r0 X;

    public static r0 X0() {
        r0 r0VarY0;
        r0 r0VarY02;
        String name = r0.class.getName();
        String property = System.getProperty(name);
        if (ga5.t(property)) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null && (r0VarY02 = Y0(name, ServiceLoader.load(r0.class, contextClassLoader))) != null) {
                return r0VarY02;
            }
            ClassLoader classLoader = rl0.class.getClassLoader();
            if (contextClassLoader == classLoader || (r0VarY0 = Y0(name, ServiceLoader.load(r0.class, classLoader))) == null) {
                return null;
            }
            return r0VarY0;
        }
        Set set = zr.A;
        int i = so2.a;
        zr zrVar = (zr) ((ga5.t(property) || ga5.u(set)) ? null : (to2) ga5.G(set).filter(new ro2(0, property)).findFirst().orElse(null));
        if (zrVar != null) {
            return (r0) r0.class.cast(zrVar.a());
        }
        ClassLoader contextClassLoader2 = Thread.currentThread().getContextClassLoader();
        we2 we2Var = Y;
        if (contextClassLoader2 != null) {
            try {
                return (r0) r0.class.cast(contextClassLoader2.loadClass(property).getDeclaredConstructor(null).newInstance(null));
            } catch (Throwable th) {
                we2Var.trace("Exception while loading factory " + property, th);
            }
        }
        ClassLoader classLoader2 = rl0.class.getClassLoader();
        if (contextClassLoader2 != classLoader2) {
            try {
                return (r0) r0.class.cast(classLoader2.loadClass(property).getDeclaredConstructor(null).newInstance(null));
            } catch (Throwable th2) {
                we2Var.trace("Exception while loading factory " + property, th2);
            }
        }
        xe.q(ha0.n("Unable to create instance of class ", property));
        return null;
    }

    public static r0 Y0(String str, ServiceLoader serviceLoader) {
        we2 we2Var = Y;
        Iterator it = serviceLoader.iterator();
        LinkedList linkedList = new LinkedList();
        while (it.hasNext()) {
            try {
                try {
                    linkedList.add((r0) it.next());
                } catch (Throwable th) {
                    we2Var.warn("Exception while instantiating factory from ServiceLoader", th);
                }
            } catch (Throwable th2) {
                we2Var.warn("Exception while loading factory from ServiceLoader", th2);
            }
        }
        int size = linkedList.size();
        if (size <= 0) {
            return null;
        }
        if (size == 1) {
            return (r0) linkedList.removeFirst();
        }
        we2Var.error("Multiple ({}) registered instances detected:", Integer.valueOf(size));
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            we2Var.error("===> {}", ((r0) it2.next()).getClass().getName());
        }
        StringBuilder sbD = dw2.D("Multiple (", size, ") registered ");
        sbD.append(r0.class.getSimpleName());
        sbD.append(" instances detected. Please use -D");
        sbD.append(str);
        sbD.append("=...factory class.. to select one or remove the extra providers from the classpath");
        throw new IllegalStateException(sbD.toString());
    }

    @Override // defpackage.r0
    public final void W0(h14 h14Var) {
        r0 r0Var;
        synchronized (this) {
            try {
                r0Var = this.X;
                if (r0Var == null) {
                    r0 r0VarX0 = X0();
                    this.X = r0VarX0;
                    if (r0VarX0 == null) {
                        r0 r0VarA = zr.z.a();
                        this.X = r0VarA;
                        ((we2) this.f).info("No detected/configured IoServiceFactoryFactory; using {}", r0VarA.getClass().getSimpleName());
                    } else {
                        ((we2) this.f).info("Using {}", r0VarX0.getClass().getSimpleName());
                    }
                    r0Var = this.X;
                }
            } finally {
            }
        }
        r0Var.W0(h14Var);
    }
}
