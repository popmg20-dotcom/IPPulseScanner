package defpackage;

import j$.util.Optional;
import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class aa4 extends u94 {
    public static final aa4 c = new aa4();
    public static final uf4 d;

    static {
        HashMap map = new HashMap();
        d = new uf4(new HashMap(), new cm(4), new cm(6), new cm(5), new bd2(), map, Optional.empty(), new v62(0));
    }

    @Override // defpackage.u94
    public final Map b(StringReader stringReader) {
        Object objB;
        uf4 uf4Var = d;
        cm2 cm2Var = new cm2(uf4Var);
        s03 s03Var = new s03(uf4Var, new w34(uf4Var, stringReader));
        u90 u90Var = new u90(uf4Var, s03Var);
        s03Var.next();
        Optional optionalEmpty = Optional.empty();
        if (!s03Var.a(10)) {
            optionalEmpty = Optional.of(u90Var.next());
        }
        if (optionalEmpty.isPresent()) {
            ds2 ds2Var = (ds2) optionalEmpty.get();
            ed4 ed4Var = u90Var.Y;
            ed4Var.o();
            ed4Var.q();
            ds2Var.getClass();
            ed4 ed4Var2 = u90Var.X;
            ed4Var2.o();
            ed4Var2.q();
        }
        if (!s03Var.a(10)) {
            throw new v90("expected a single document in the stream", optionalEmpty.flatMap(new hl(2)), "but found another document", s03Var.next().a, null);
        }
        s03Var.next();
        if (!optionalEmpty.isPresent() || oa4.h.equals(((ds2) optionalEmpty.get()).b)) {
            objB = ((rc0) ((HashMap) cm2Var.f).get(oa4.h)).b((ds2) optionalEmpty.orElse(null));
        } else {
            ds2 ds2Var2 = (ds2) optionalEmpty.get();
            HashSet hashSet = (HashSet) cm2Var.A;
            HashMap map = (HashMap) cm2Var.z;
            try {
                try {
                    objB = cm2Var.h(ds2Var2);
                    cm2Var.m();
                    map.clear();
                    hashSet.clear();
                } catch (hy4 e) {
                    throw e;
                } catch (RuntimeException e2) {
                    throw new hy4(e2);
                }
            } catch (Throwable th) {
                map.clear();
                hashSet.clear();
                throw th;
            }
        }
        return (Map) objB;
    }
}
