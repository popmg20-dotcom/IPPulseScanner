package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bm4 extends i1 {
    @Override // defpackage.m03
    public final Object a(m60 m60Var, o91 o91Var) throws s12 {
        yl4 yl4VarP = yl4.p();
        try {
            yl4VarP.v(m60Var);
            return yl4VarP.p();
        } catch (s12 e) {
            yl4VarP.p();
            throw e;
        } catch (IOException e2) {
            s12 s12Var = new s12(e2.getMessage(), e2);
            yl4VarP.p();
            throw s12Var;
        }
    }
}
