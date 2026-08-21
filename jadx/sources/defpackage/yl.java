package defpackage;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class yl implements bg, e12 {
    public static final String X;
    public static final AtomicInteger Y;
    public s20 A;
    public final String b;
    public final String f;
    public s20 z;

    static {
        String string = UUID.randomUUID().toString();
        string.getClass();
        X = gb4.N(string);
        Y = new AtomicInteger(1);
    }

    public yl(String str, String str2) {
        this.b = str;
        this.f = str2;
    }

    @Override // defpackage.e12
    public final kk3 a(ve3 ve3Var) {
        cm2 cm2VarB;
        cm2 cm2Var = ve3Var.e;
        cm2Var.getClass();
        if (((lr1) cm2Var.A).a("Authorization") == null && (cm2VarB = b(cm2Var, null)) != null) {
            cm2Var = cm2VarB;
        }
        return ve3Var.b(cm2Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.cm2 b(defpackage.cm2 r26, defpackage.kk3 r27) {
        /*
            Method dump skipped, instruction units count: 1180
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yl.b(cm2, kk3):cm2");
    }

    @Override // defpackage.bg
    public final cm2 h(em3 em3Var, kk3 kk3Var) {
        return b(kk3Var.b, kk3Var);
    }
}
