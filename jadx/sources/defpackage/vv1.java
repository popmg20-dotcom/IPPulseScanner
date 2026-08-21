package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vv1 implements AutoCloseable {
    public final qv A;
    public byte[] X;
    public char[] Y;
    public final Object b;
    public final mp f;
    public boolean z = true;
    public boolean Z = false;

    public vv1(qv qvVar, mp mpVar, xd0 xd0Var) {
        this.A = qvVar;
        this.f = mpVar;
        this.b = xd0Var.b;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.Z) {
            return;
        }
        this.Z = true;
        if (this.z) {
            this.z = false;
            this.f.getClass();
        }
    }

    public final void g(byte[] bArr) {
        byte[] bArr2 = this.X;
        if (bArr != bArr2 && bArr.length < bArr2.length) {
            xe.k("Trying to release buffer smaller than original");
            return;
        }
        this.X = null;
        AtomicReferenceArray atomicReferenceArray = this.f.a;
        byte[] bArr3 = (byte[]) atomicReferenceArray.get(3);
        if (bArr3 == null || bArr.length > bArr3.length) {
            atomicReferenceArray.set(3, bArr);
        }
    }
}
