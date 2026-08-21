package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lz0 extends i1 {
    public final /* synthetic */ nz0 b;

    public lz0(nz0 nz0Var) {
        this.b = nz0Var;
    }

    @Override // defpackage.m03
    public final Object a(m60 m60Var, o91 o91Var) throws s12 {
        mz0 mz0Var = new mz0(this.b.z);
        try {
            mz0Var.M(m60Var, o91Var);
            return mz0Var.q();
        } catch (s12 e) {
            mz0Var.q();
            throw e;
        } catch (IOException e2) {
            s12 s12Var = new s12(e2.getMessage(), e2);
            mz0Var.q();
            throw s12Var;
        }
    }
}
