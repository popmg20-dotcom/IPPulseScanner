package defpackage;

import android.adservices.measurement.MeasurementManager;
import android.net.Uri;
import android.view.InputEvent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class oj2 extends r25 {
    public final MeasurementManager k;

    public oj2(MeasurementManager measurementManager) {
        this.k = measurementManager;
    }

    public static Object c0(oj2 oj2Var, bo0 bo0Var, ge0 ge0Var) {
        new z00(1, p95.u(ge0Var)).w();
        MeasurementManager measurementManager = oj2Var.k;
        throw null;
    }

    public static Object d0(oj2 oj2Var, ge0 ge0Var) {
        z00 z00Var = new z00(1, p95.u(ge0Var));
        z00Var.w();
        oj2Var.k.getMeasurementApiStatus(new qd(1), new je0(z00Var));
        return z00Var.u();
    }

    public static Object f0(oj2 oj2Var, oz3 oz3Var, ge0 ge0Var) {
        Object objH = p95.h(new gd(oj2Var, null, 11), ge0Var);
        return objH == mf0.b ? objH : xl4.a;
    }

    public static Object g0(oj2 oj2Var, Uri uri, InputEvent inputEvent, ge0 ge0Var) {
        z00 z00Var = new z00(1, p95.u(ge0Var));
        z00Var.w();
        oj2Var.k.registerSource(uri, inputEvent, new qd(1), new je0(z00Var));
        Object objU = z00Var.u();
        return objU == mf0.b ? objU : xl4.a;
    }

    public static Object h0(oj2 oj2Var, Uri uri, ge0 ge0Var) {
        z00 z00Var = new z00(1, p95.u(ge0Var));
        z00Var.w();
        oj2Var.k.registerTrigger(uri, new qd(1), new je0(z00Var));
        Object objU = z00Var.u();
        return objU == mf0.b ? objU : xl4.a;
    }

    public static Object j0(oj2 oj2Var, jt4 jt4Var, ge0 ge0Var) {
        new z00(1, p95.u(ge0Var)).w();
        MeasurementManager measurementManager = oj2Var.k;
        throw null;
    }

    public static Object l0(oj2 oj2Var, kt4 kt4Var, ge0 ge0Var) {
        new z00(1, p95.u(ge0Var)).w();
        MeasurementManager measurementManager = oj2Var.k;
        throw null;
    }

    @Override // defpackage.r25
    public Object L(Uri uri, InputEvent inputEvent, ge0 ge0Var) {
        return g0(this, uri, inputEvent, ge0Var);
    }

    @Override // defpackage.r25
    public Object M(Uri uri, ge0 ge0Var) {
        return h0(this, uri, ge0Var);
    }

    public Object b0(bo0 bo0Var, ge0 ge0Var) {
        return c0(this, bo0Var, ge0Var);
    }

    public Object e0(oz3 oz3Var, ge0 ge0Var) {
        return f0(this, oz3Var, ge0Var);
    }

    public Object i0(jt4 jt4Var, ge0 ge0Var) {
        return j0(this, jt4Var, ge0Var);
    }

    public Object k0(kt4 kt4Var, ge0 ge0Var) {
        return l0(this, kt4Var, ge0Var);
    }

    @Override // defpackage.r25
    public Object y(ge0 ge0Var) {
        return d0(this, ge0Var);
    }
}
