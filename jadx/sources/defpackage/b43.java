package defpackage;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b43 extends co1 {
    private static final b43 DEFAULT_INSTANCE;
    private static volatile n03 PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private h12 strings_ = x93.A;

    static {
        b43 b43Var = new b43();
        DEFAULT_INSTANCE = b43Var;
        co1.j(b43.class, b43Var);
    }

    public static b43 m() {
        return DEFAULT_INSTANCE;
    }

    public static a43 o() {
        return (a43) ((ao1) DEFAULT_INSTANCE.c(5));
    }

    @Override // defpackage.co1
    public final Object c(int i) {
        n03 bo1Var;
        switch (fw.G(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new qd3(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new b43();
            case 4:
                return new a43(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                n03 n03Var = PARSER;
                if (n03Var != null) {
                    return n03Var;
                }
                synchronized (b43.class) {
                    try {
                        bo1Var = PARSER;
                        if (bo1Var == null) {
                            bo1Var = new bo1();
                            PARSER = bo1Var;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return bo1Var;
            default:
                vp1.q();
                return null;
        }
    }

    public final void l(Set set) {
        h12 h12VarC = this.strings_;
        if (!((x93) h12VarC).b) {
            x93 x93Var = (x93) h12VarC;
            int i = x93Var.z;
            h12VarC = x93Var.c(i == 0 ? 10 : i * 2);
            this.strings_ = h12VarC;
        }
        Charset charset = j12.a;
        if (h12VarC instanceof ArrayList) {
            ((ArrayList) h12VarC).ensureCapacity(set.size() + ((x93) h12VarC).z);
        }
        x93 x93Var2 = (x93) h12VarC;
        int i2 = x93Var2.z;
        for (Object obj : set) {
            if (obj == null) {
                String str = "Element at index " + (x93Var2.z - i2) + " is null.";
                for (int i3 = x93Var2.z - 1; i3 >= i2; i3--) {
                    x93Var2.remove(i3);
                }
                zo2.n(str);
                return;
            }
            x93Var2.add(obj);
        }
    }

    public final h12 n() {
        return this.strings_;
    }
}
