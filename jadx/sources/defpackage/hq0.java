package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hq0 extends i1 {
    @Override // defpackage.m03
    public final Object a(m60 m60Var, o91 o91Var) throws s12 {
        iq0 iq0VarJ = mq0.A0.u();
        try {
            iq0VarJ.y(m60Var, o91Var);
            return iq0VarJ.q();
        } catch (s12 e) {
            iq0VarJ.q();
            throw e;
        } catch (IOException e2) {
            s12 s12Var = new s12(e2.getMessage(), e2);
            iq0VarJ.q();
            throw s12Var;
        } catch (vl4 e3) {
            s12 s12VarA = e3.a();
            iq0VarJ.q();
            throw s12VarA;
        }
    }
}
