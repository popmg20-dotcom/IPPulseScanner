package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o82 implements Serializable {
    public transient Serializable b;

    public o82(int i, int i2) {
        x43 x43Var = new x43();
        x43Var.c = -1L;
        x43Var.b = 16;
        x43Var.a = 16;
        boolean z = i >= 0;
        int i3 = i53.F0;
        if (!z) {
            s53.d();
            throw null;
        }
        x43Var.b = i;
        long j = i2;
        if (j < 0) {
            s53.d();
            throw null;
        }
        x43Var.c = j;
        x43Var.a = 4;
        if (j >= 0) {
            this.b = new i53(x43Var);
        } else {
            st4.g();
            throw null;
        }
    }
}
