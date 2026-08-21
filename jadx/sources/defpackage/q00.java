package defpackage;

import android.os.Handler;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q00 implements ta4 {
    public static final pg A0;
    public static final pg B0;
    public static final pg C0;
    public static final pg D0;
    public static final pg Z;
    public static final pg y0;
    public static final pg z0;
    public final sw2 b;
    public static final pg f = new pg("camerax.core.appConfig.cameraFactoryProvider", mx.class, null);
    public static final pg z = new pg("camerax.core.appConfig.deviceSurfaceManagerProvider", nx.class, null);
    public static final pg A = new pg("camerax.core.appConfig.useCaseConfigFactoryProvider", ox.class, null);
    public static final pg X = new pg("camerax.core.appConfig.cameraExecutor", Executor.class, null);
    public static final pg Y = new pg("camerax.core.appConfig.schedulerHandler", Handler.class, null);

    static {
        Class cls = Integer.TYPE;
        Z = new pg("camerax.core.appConfig.minimumLoggingLevel", cls, null);
        y0 = new pg("camerax.core.appConfig.availableCamerasLimiter", b00.class, null);
        z0 = new pg("camerax.core.appConfig.cameraOpenRetryMaxTimeoutInMillisWhileResuming", Long.TYPE, null);
        A0 = new pg("camerax.core.appConfig.cameraProviderInitRetryPolicy", dl3.class, null);
        B0 = new pg("camerax.core.appConfig.quirksSettings", ic3.class, null);
        C0 = new pg("camerax.core.appConfig.configImplType", cls, null);
        D0 = new pg("camerax.core.appConfig.repeatingStreamForced", Boolean.TYPE, null);
    }

    public q00(sw2 sw2Var) {
        this.b = sw2Var;
    }

    @Override // defpackage.ka0
    public final /* synthetic */ Object C(pg pgVar, ia0 ia0Var) {
        return dw2.o(this, pgVar, ia0Var);
    }

    @Override // defpackage.ta4
    public final /* synthetic */ String F(String str) {
        throw null;
    }

    @Override // defpackage.ka0
    public final /* synthetic */ boolean K(pg pgVar) {
        return dw2.a(this, pgVar);
    }

    @Override // defpackage.ta4
    public final /* synthetic */ String Q() {
        throw null;
    }

    @Override // defpackage.ka0
    public final /* synthetic */ ia0 S(pg pgVar) {
        return dw2.c(this, pgVar);
    }

    public final b00 a() {
        return (b00) this.b.p(y0, null);
    }

    public final mx c() {
        return (mx) this.b.p(f, null);
    }

    public final long d() {
        return ((Long) this.b.p(z0, -1L)).longValue();
    }

    public final nx f() {
        return (nx) this.b.p(z, null);
    }

    public final ox g() {
        return (ox) this.b.p(A, null);
    }

    @Override // defpackage.ka0
    public final /* synthetic */ void l(ed edVar) {
        dw2.b(this, edVar);
    }

    @Override // defpackage.zd3
    public final ka0 m() {
        return this.b;
    }

    @Override // defpackage.ka0
    public final /* synthetic */ Object p(pg pgVar, Object obj) {
        return dw2.n(this, pgVar, obj);
    }

    @Override // defpackage.ka0
    public final /* synthetic */ Set t() {
        return dw2.i(this);
    }

    @Override // defpackage.ka0
    public final /* synthetic */ Object u(pg pgVar) {
        return dw2.m(this, pgVar);
    }

    @Override // defpackage.ka0
    public final /* synthetic */ Set y(pg pgVar) {
        return dw2.d(this, pgVar);
    }
}
