package defpackage;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ge1 implements Closeable {
    public static final x72 b;

    static {
        x72 x72Var;
        try {
            Class.forName("java.nio.file.Files");
            x72Var = new vr2();
        } catch (ClassNotFoundException unused) {
            x72Var = new x72();
        }
        b = x72Var;
        String str = u03.f;
        String property = System.getProperty("java.io.tmpdir");
        property.getClass();
        pr1.q(property);
        ClassLoader classLoader = zj3.class.getClassLoader();
        classLoader.getClass();
        new zj3(classLoader);
    }

    public final void C(u03 u03Var) {
        u03Var.getClass();
        x(u03Var);
    }

    public final boolean F(u03 u03Var) {
        u03Var.getClass();
        return N(u03Var) != null;
    }

    public abstract List I(u03 u03Var);

    public final no0 M(u03 u03Var) throws FileNotFoundException {
        u03Var.getClass();
        no0 no0VarN = N(u03Var);
        if (no0VarN != null) {
            return no0VarN;
        }
        a71.f(u03Var, "no such file: ");
        return null;
    }

    public abstract no0 N(u03 u03Var);

    public abstract w72 Q(u03 u03Var);

    public abstract vx3 U(u03 u03Var);

    public abstract lz3 X(u03 u03Var);

    public abstract vx3 g(u03 u03Var);

    public abstract void n(u03 u03Var, u03 u03Var2);

    public abstract void s(u03 u03Var);

    public abstract void x(u03 u03Var);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
