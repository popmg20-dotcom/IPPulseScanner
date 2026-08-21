package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xs0 extends Exception {
    public xs0(it0 it0Var, String str) {
        super(it0Var.d() + ": " + str);
        it0Var.d();
        it0Var.h();
    }

    public xs0(gt0 gt0Var, String str) {
        super(fw.y(new StringBuilder(gt0Var.f.H()), ": ", str));
        gt0Var.getName();
    }
}
