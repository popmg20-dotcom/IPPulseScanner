package defpackage;

import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class lt3 extends k70 implements to2 {
    public static final lt3 X;

    static {
        lt3 lt3Var = new lt3();
        if (ke0.t(h23.class, new CopyOnWriteArraySet()) == null) {
            X = lt3Var;
        } else {
            st4.n();
            throw null;
        }
    }

    @Override // defpackage.to2
    public final String getName() {
        return "ssh-connection";
    }
}
