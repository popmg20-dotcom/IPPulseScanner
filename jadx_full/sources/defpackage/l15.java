package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l15 extends Exception {
    public final ab0 b;

    public l15(ab0 ab0Var) {
        if ((ab0Var.f == 0 || ab0Var.z == null) ? false : true) {
            this.b = ab0Var;
        } else {
            xe.k("ResolvableConnectionException can only be created with a connection result containing a resolution.");
            throw null;
        }
    }
}
