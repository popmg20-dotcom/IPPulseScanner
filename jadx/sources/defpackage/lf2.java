package defpackage;

import org.bouncycastle.pqc.crypto.mlkem.MLKEMParameters;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class lf2 {
    public static final Object a(int i) {
        return MLKEMParameters.ml_kem_768;
    }

    public static final Object b(int i) {
        return MLKEMParameters.ml_kem_1024;
    }

    public static final boolean c(int i) {
        return (i != 1 ? b(i) : a(i)) != null;
    }
}
