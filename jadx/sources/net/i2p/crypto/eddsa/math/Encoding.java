package net.i2p.crypto.eddsa.math;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Encoding {
    public Field b;

    public synchronized void a(Field field) {
        if (this.b != null) {
            throw new IllegalStateException("already set");
        }
        this.b = field;
    }
}
