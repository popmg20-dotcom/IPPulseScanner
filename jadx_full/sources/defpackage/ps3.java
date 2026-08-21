package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ps3 extends sr3 {
    public final /* synthetic */ AtomicReferenceArray Z;

    public ps3(long j, ps3 ps3Var, int i) {
        super(j, ps3Var, i);
        this.Z = new AtomicReferenceArray(os3.f);
    }

    @Override // defpackage.sr3
    public final int g() {
        return os3.f;
    }

    @Override // defpackage.sr3
    public final void h(int i, cf0 cf0Var) {
        this.Z.set(i, os3.e);
        i();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.A + ", hashCode=" + hashCode() + ']';
    }
}
