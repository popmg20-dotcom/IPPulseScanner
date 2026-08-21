package defpackage;

import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v93 {
    public static final v93 c = new v93();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final zf2 a = new zf2(0);

    public final gq3 a(Class cls) {
        q91 q91Var;
        gq3 gq3VarW;
        Class cls2;
        j12.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.b;
        gq3 gq3Var = (gq3) concurrentHashMap.get(cls);
        if (gq3Var != null) {
            return gq3Var;
        }
        Class cls3 = hq3.a;
        if (!co1.class.isAssignableFrom(cls) && (cls2 = hq3.a) != null && !cls2.isAssignableFrom(cls)) {
            xe.k("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            return null;
        }
        qd3 qd3VarA = ((yf2) this.a.f).a(cls);
        if ((qd3VarA.d & 2) == 2) {
            if (co1.class.isAssignableFrom(cls)) {
                gq3VarW = new tl2(hq3.c, r91.a, qd3VarA.a);
            } else {
                em4 em4Var = hq3.b;
                q91 q91Var2 = r91.b;
                if (q91Var2 == null) {
                    xe.q("Protobuf runtime is not correctly loaded.");
                    return null;
                }
                gq3VarW = new tl2(em4Var, q91Var2, qd3VarA.a);
            }
        } else if (co1.class.isAssignableFrom(cls)) {
            gq3VarW = sl2.w(qd3VarA, rr2.b, xb2.b, hq3.c, fw.G(qd3VarA.a()) != 1 ? r91.a : null, ug2.b);
        } else {
            qr2 qr2Var = rr2.a;
            wb2 wb2Var = xb2.a;
            em4 em4Var2 = hq3.b;
            if (fw.G(qd3VarA.a()) != 1) {
                q91 q91Var3 = r91.b;
                if (q91Var3 == null) {
                    xe.q("Protobuf runtime is not correctly loaded.");
                    return null;
                }
                q91Var = q91Var3;
            } else {
                q91Var = null;
            }
            gq3VarW = sl2.w(qd3VarA, qr2Var, wb2Var, em4Var2, q91Var, ug2.a);
        }
        gq3 gq3Var2 = (gq3) concurrentHashMap.putIfAbsent(cls, gq3VarW);
        return gq3Var2 != null ? gq3Var2 : gq3VarW;
    }
}
