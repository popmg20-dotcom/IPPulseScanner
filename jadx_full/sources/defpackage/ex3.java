package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ex3 extends sj4 implements Serializable {
    public final ConcurrentHashMap A;
    public final HashMap X;
    public final bt3 z;

    public ex3(bt3 bt3Var, nj4 nj4Var, ConcurrentHashMap concurrentHashMap, HashMap map) {
        super(nj4Var, bt3Var.f.b);
        this.z = bt3Var;
        this.A = concurrentHashMap;
        this.X = map;
        bt3Var.f(ah2.ACCEPT_CASE_INSENSITIVE_VALUES);
    }

    @Override // defpackage.sj4
    public final String b(Object obj) {
        return d(obj.getClass());
    }

    @Override // defpackage.sj4
    public final String c(Object obj, Class cls) {
        return obj == null ? d(cls) : d(obj.getClass());
    }

    public final String d(Class cls) {
        if (cls == null) {
            return null;
        }
        Class clsA = sj4.a(cls);
        String name = clsA.getName();
        ConcurrentHashMap concurrentHashMap = this.A;
        String strK = (String) concurrentHashMap.get(name);
        if (strK == null) {
            Class cls2 = this.b.b(null, clsA, rj4.A).L0;
            ah2 ah2Var = ah2.USE_ANNOTATIONS;
            bt3 bt3Var = this.z;
            if (bt3Var.f(ah2Var)) {
                nj4 nj4VarC = bt3Var.c(cls2);
                ((wl) bt3Var.f.f).getClass();
                ul ulVarS = wl.S(bt3Var, nj4VarC);
                if (ulVarS == null) {
                    ulVarS = ul.d(bt3Var, nj4VarC, x8.F(bt3Var, nj4VarC, bt3Var));
                }
                strK = bt3Var.d().K((w8) ulVarS.f);
            }
            if (strK == null) {
                String name2 = cls2.getName();
                int iMax = Math.max(name2.lastIndexOf(46), name2.lastIndexOf(36));
                if (iMax >= 0) {
                    name2 = name2.substring(iMax + 1);
                }
                strK = name2;
            }
            concurrentHashMap.put(name, strK);
        }
        return strK;
    }

    public final String toString() {
        return String.format("[%s; id-to-type=%s]", ex3.class.getName(), this.X);
    }
}
