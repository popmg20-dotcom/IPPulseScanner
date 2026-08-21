package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class x32 extends e42 {
    public final boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x32(v32 v32Var) {
        super(true);
        boolean z = true;
        L(v32Var);
        Unsafe unsafe = re.a;
        long j = e42.b;
        g40 g40Var = (g40) unsafe.getObjectVolatile(this, j);
        h40 h40Var = g40Var instanceof h40 ? (h40) g40Var : null;
        if (h40Var == null) {
            z = false;
            break;
        }
        e42 e42VarK = h40Var.k();
        while (!e42VarK.D()) {
            g40 g40Var2 = (g40) re.a.getObjectVolatile(e42VarK, j);
            h40 h40Var2 = g40Var2 instanceof h40 ? (h40) g40Var2 : null;
            if (h40Var2 == null) {
                z = false;
                break;
            }
            e42VarK = h40Var2.k();
        }
        this.z = z;
    }

    @Override // defpackage.e42
    public final boolean D() {
        return this.z;
    }

    @Override // defpackage.e42
    public final boolean E() {
        return true;
    }
}
