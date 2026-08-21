package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cm3 extends fx3 {
    @Override // defpackage.fx3
    public final void l(xu3 xu3Var, float f, float f2) {
        float f3 = f2 * f;
        xu3Var.d(f3, 180.0f, 90.0f);
        float f4 = f3 * 2.0f;
        tu3 tu3Var = new tu3(0.0f, 0.0f, f4, f4);
        tu3Var.f = 180.0f;
        tu3Var.g = 90.0f;
        xu3Var.f.add(tu3Var);
        ru3 ru3Var = new ru3(tu3Var);
        xu3Var.a(180.0f);
        xu3Var.g.add(ru3Var);
        xu3Var.d = 270.0f;
        float f5 = (0.0f + f4) * 0.5f;
        float f6 = (f4 - 0.0f) / 2.0f;
        xu3Var.b = (((float) Math.cos(Math.toRadians(270.0d))) * f6) + f5;
        xu3Var.c = (f6 * ((float) Math.sin(Math.toRadians(270.0d)))) + f5;
    }
}
