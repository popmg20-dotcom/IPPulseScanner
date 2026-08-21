package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jp0 extends i1 {
    @Override // defpackage.m03
    public final Object a(m60 m60Var, o91 o91Var) throws s12 {
        kp0 kp0VarU = lp0.A0.u();
        try {
            kp0VarU.y(m60Var, o91Var);
            return kp0VarU.I();
        } catch (s12 e) {
            kp0VarU.I();
            throw e;
        } catch (IOException e2) {
            s12 s12Var = new s12(e2.getMessage(), e2);
            kp0VarU.I();
            throw s12Var;
        } catch (vl4 e3) {
            s12 s12VarA = e3.a();
            kp0VarU.I();
            throw s12VarA;
        }
    }
}
