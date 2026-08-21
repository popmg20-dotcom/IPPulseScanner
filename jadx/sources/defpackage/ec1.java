package defpackage;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ec1 extends zi1 {
    public final f0 f;
    public boolean z;

    public ec1(vx3 vx3Var, f0 f0Var) {
        super(vx3Var);
        this.f = f0Var;
    }

    @Override // defpackage.vx3
    public final void a0(hp hpVar, long j) throws EOFException {
        if (this.z) {
            hpVar.z0(j);
            return;
        }
        try {
            this.b.a0(hpVar, j);
        } catch (IOException e) {
            this.z = true;
            this.f.g(e);
        }
    }

    @Override // defpackage.zi1, defpackage.vx3, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            super.close();
        } catch (IOException e) {
            this.z = true;
            this.f.g(e);
        }
    }

    @Override // defpackage.zi1, defpackage.vx3, java.io.Flushable
    public final void flush() {
        try {
            super.flush();
        } catch (IOException e) {
            this.z = true;
            this.f.g(e);
        }
    }
}
