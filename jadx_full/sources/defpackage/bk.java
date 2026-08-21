package defpackage;

import j$.util.DesugarCollections;
import j$.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class bk implements Supplier {
    public static final xo2 F0 = xo2.X;
    public static final ji3 G0 = ji3.X;
    public static final kl0 H0 = kl0.a;
    public static final List I0 = DesugarCollections.unmodifiableList(Arrays.asList(xq.G0, xq.z0, xq.D0, xq.F0, xq.A0, xq.B0, xq.y0, xq.C0, xq.E0));
    public static final List J0 = DesugarCollections.unmodifiableList(Arrays.asList(wr.H0, wr.I0, wr.E0, wr.G0, wr.F0, wr.B0, wr.C0, wr.D0, wr.A0, wr.z0, wr.y0, wr.Z, wr.Y, wr.X, wr.A, wr.z, wr.f));
    public static final List K0 = DesugarCollections.unmodifiableList(Arrays.asList(ds.y0, ds.A0, ds.Y, ds.Z, ds.z0, ds.X));
    public static final List L0 = DesugarCollections.unmodifiableList(Arrays.asList(ws.y0, ws.A0, ws.C0, ws.F0, ws.Y, ws.A, ws.Z, ws.z0, ws.B0, ws.E0, ws.D0, ws.G0, ws.X, ws.z, ws.f));
    public static final zm0 M0 = zm0.X;
    public List A;
    public kl0 A0;
    public List B0;
    public ji3 C0;
    public zm0 D0;
    public im0 E0;
    public List X;
    public List Y;
    public ux3 Z;
    public f14 b;
    public List f;
    public List y0;
    public List z;
    public xo2 z0;

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final h14 b() {
        kt3 kt3Var = (kt3) this;
        if (kt3Var.z == null) {
            kt3Var.z = (List) ga5.G(kt3.W0).filter(new sm(1)).collect(Collectors.toList());
        }
        if (kt3Var.Z == null) {
            nr3.h();
            if (nr3.c("BC") != null) {
                o1 o1Var = to.f;
                if (!o1Var.g()) {
                    o1Var = l32.f;
                }
                kt3Var.Z = new ux3(o1Var);
            }
        }
        if (kt3Var.z == null) {
            kt3Var.z = l0.v(I0);
        }
        if (kt3Var.X == null) {
            kt3Var.X = l0.v(K0);
        }
        if (kt3Var.z0 == null) {
            kt3Var.z0 = F0;
        }
        if (kt3Var.C0 == null) {
            kt3Var.C0 = G0;
        }
        if (kt3Var.A0 == null) {
            kt3Var.A0 = H0;
        }
        if (kt3Var.D0 == null) {
            kt3Var.D0 = M0;
        }
        if (kt3Var.A == null) {
            kt3Var.A = l0.v(kt3.U0);
        }
        if (kt3Var.Y == null) {
            kt3Var.Y = l0.v(L0);
        }
        if (kt3Var.f == null) {
            hl hlVar = kt3.P0;
            kt3Var.f = l0.w(J0);
        }
        if (kt3Var.E0 == null) {
            kt3Var.E0 = kt3.V0;
        }
        if (kt3Var.y0 == null) {
            kt3Var.y0 = kt3.Q0;
        }
        if (kt3Var.B0 == null) {
            kt3Var.B0 = kt3.R0;
        }
        if (kt3Var.N0 == null) {
            kt3Var.N0 = kt3.S0;
        }
        if (kt3Var.O0 == null) {
            kt3Var.O0 = kt3.T0;
        }
        if (kt3Var.b == null) {
            kt3Var.b = h14.X0;
        }
        h14 h14Var = new h14();
        h14Var.y0 = kt3Var.f;
        h14Var.D0 = kt3Var.Z;
        h14Var.z0 = kt3Var.z;
        h14Var.A0 = kt3Var.A;
        h14Var.B0 = kt3Var.X;
        h14Var.E0 = kt3Var.y0;
        h14Var.H0 = kt3Var.z0;
        h14Var.U0 = kt3Var.N0;
        h14Var.V0 = kt3Var.O0;
        return h14Var;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return b();
    }
}
