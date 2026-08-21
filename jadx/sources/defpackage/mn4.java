package defpackage;

import android.util.Range;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface mn4 extends ta4, dy1 {
    public static final pg a0 = new pg("camerax.core.useCase.defaultSessionConfig", tt3.class, null);
    public static final pg b0 = new pg("camerax.core.useCase.defaultCaptureConfig", f10.class, null);
    public static final pg c0 = new pg("camerax.core.useCase.sessionConfigUnpacker", ux.class, null);
    public static final pg d0 = new pg("camerax.core.useCase.captureConfigUnpacker", jx.class, null);
    public static final pg e0;
    public static final pg f0;
    public static final pg g0;
    public static final pg h0;
    public static final pg i0;
    public static final pg j0;
    public static final pg k0;
    public static final pg l0;
    public static final pg m0;
    public static final pg n0;
    public static final pg o0;

    static {
        Class cls = Integer.TYPE;
        e0 = new pg("camerax.core.useCase.surfaceOccupancyPriority", cls, null);
        f0 = new pg("camerax.core.useCase.sessionType", cls, null);
        g0 = new pg("camerax.core.useCase.targetFrameRate", Range.class, null);
        h0 = new pg("camerax.core.useCase.isStrictFrameRateRequired", Boolean.class, null);
        Class cls2 = Boolean.TYPE;
        i0 = new pg("camerax.core.useCase.zslDisabled", cls2, null);
        j0 = new pg("camerax.core.useCase.highResolutionDisabled", cls2, null);
        k0 = new pg("camerax.core.useCase.captureType", on4.class, null);
        l0 = new pg("camerax.core.useCase.previewStabilizationMode", cls, null);
        m0 = new pg("camerax.core.useCase.videoStabilizationMode", cls, null);
        n0 = new pg("camerax.core.useCase.takePictureManagerProvider", kn4.class, null);
        o0 = new pg("camerax.core.useCase.streamUseCase", d44.class, null);
    }

    tt3 E();

    d44 J();

    on4 M();

    int N();

    Range O(Range range);

    int W();

    boolean X();

    int b();

    boolean b0();

    boolean e0();

    kn4 r();

    tt3 v();

    int w();

    ux x();

    boolean z();
}
