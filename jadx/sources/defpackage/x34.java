package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class x34 extends IOException {
    public final t51 b;

    public x34(t51 t51Var) {
        super("stream was reset: " + t51Var);
        this.b = t51Var;
    }
}
