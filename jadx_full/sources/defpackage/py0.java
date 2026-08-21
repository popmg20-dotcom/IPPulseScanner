package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class py0 implements ss3, qy0 {
    public final ss3 a;
    public final int b;

    public py0(ss3 ss3Var, int i) {
        ss3Var.getClass();
        this.a = ss3Var;
        this.b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // defpackage.qy0
    public final ss3 a(int i) {
        int i2 = this.b + i;
        return i2 < 0 ? new py0(this, i) : new py0(this.a, i2);
    }

    @Override // defpackage.ss3
    public final Iterator iterator() {
        return new w0(this);
    }
}
