package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class l91 extends o91 {
    public static final l91 h = new l91(0);
    public final Map d;
    public final Map e;
    public final Map f;
    public final Map g;

    public l91() {
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
    }

    public final void b(xn1 xn1Var) {
        k91 k91Var;
        Map map;
        Map map2;
        xn1Var.getClass();
        ft0 ft0VarB = xn1Var.b();
        c1 c1Var = xn1Var.b;
        if (ft0VarB.r().b != ct0.MESSAGE) {
            k91Var = new k91(xn1Var.b(), null);
        } else {
            if (c1Var == null) {
                zo2.v(xn1Var.b().X, "Registered message-type extension had null default instance: ");
                return;
            }
            k91Var = new k91(xn1Var.b(), c1Var);
        }
        ft0 ft0Var = k91Var.a;
        if (!ft0Var.z.Q()) {
            xe.k("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
            return;
        }
        int iG = fw.G(1);
        if (iG == 0) {
            map = this.d;
            map2 = this.f;
        } else {
            if (iG != 1) {
                return;
            }
            map = this.e;
            map2 = this.g;
        }
        map.put(ft0Var.X, k91Var);
        map2.put(new j91(ft0Var.B0, ft0Var.z.Z), k91Var);
        if (ft0Var.B0.n().Z && ft0Var.r() == et0.A && ft0Var.v() && ft0Var.m() == ft0Var.p()) {
            map.put(ft0Var.p().A, k91Var);
        }
    }

    public l91(int i) {
        super(o91.c);
        Map map = Collections.EMPTY_MAP;
        this.d = map;
        this.e = map;
        this.f = map;
        this.g = map;
    }
}
