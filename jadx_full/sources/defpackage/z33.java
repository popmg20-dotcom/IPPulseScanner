package defpackage;

import j$.util.DesugarCollections;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z33 extends co1 {
    private static final z33 DEFAULT_INSTANCE;
    private static volatile n03 PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private sg2 preferences_ = sg2.f;

    static {
        z33 z33Var = new z33();
        DEFAULT_INSTANCE = z33Var;
        co1.j(z33.class, z33Var);
    }

    public static x33 n() {
        return (x33) ((ao1) DEFAULT_INSTANCE.c(5));
    }

    public static z33 o(FileInputStream fileInputStream) {
        z33 z33Var = DEFAULT_INSTANCE;
        o60 o60Var = new o60(fileInputStream);
        p91 p91VarA = p91.a();
        co1 co1VarI = z33Var.i();
        try {
            v93 v93Var = v93.c;
            v93Var.getClass();
            gq3 gq3VarA = v93Var.a(co1VarI.getClass());
            r02 r02Var = (r02) o60Var.b;
            if (r02Var == null) {
                r02Var = new r02(o60Var);
            }
            gq3VarA.h(co1VarI, r02Var, p91VarA);
            gq3VarA.b(co1VarI);
            if (co1.f(co1VarI, true)) {
                return (z33) co1VarI;
            }
            throw new t12(new wl4().getMessage());
        } catch (t12 e) {
            if (e.b) {
                throw new t12(e.getMessage(), e);
            }
            throw e;
        } catch (IOException e2) {
            if (e2.getCause() instanceof t12) {
                throw ((t12) e2.getCause());
            }
            throw new t12(e2.getMessage(), e2);
        } catch (wl4 e3) {
            throw new t12(e3.getMessage());
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof t12) {
                throw ((t12) e4.getCause());
            }
            throw e4;
        }
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
                return new qd3(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", y33.a});
            case 3:
                return new z33();
            case 4:
                return new x33(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                n03 n03Var = PARSER;
                if (n03Var != null) {
                    return n03Var;
                }
                synchronized (z33.class) {
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

    public final Map l() {
        return DesugarCollections.unmodifiableMap(this.preferences_);
    }

    public final sg2 m() {
        sg2 sg2Var = this.preferences_;
        if (sg2Var.b) {
            return sg2Var;
        }
        sg2 sg2VarB = sg2Var.b();
        this.preferences_ = sg2VarB;
        return sg2VarB;
    }
}
