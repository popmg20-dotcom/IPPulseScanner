package defpackage;

import android.util.Size;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface hy1 extends zd3 {
    public static final pg B;
    public static final pg C;
    public static final pg D;
    public static final pg E;
    public static final pg F;
    public static final pg G;
    public static final pg v = new pg("camerax.core.imageOutput.targetAspectRatio", ye.class, null);
    public static final pg w;
    public static final pg x;
    public static final pg y;

    static {
        Class cls = Integer.TYPE;
        w = new pg("camerax.core.imageOutput.targetRotation", cls, null);
        x = new pg("camerax.core.imageOutput.appTargetRotation", cls, null);
        y = new pg("camerax.core.imageOutput.mirrorMode", cls, null);
        B = new pg("camerax.core.imageOutput.targetResolution", Size.class, null);
        C = new pg("camerax.core.imageOutput.defaultResolution", Size.class, null);
        D = new pg("camerax.core.imageOutput.maxResolution", Size.class, null);
        E = new pg("camerax.core.imageOutput.supportedResolutions", List.class, null);
        F = new pg("camerax.core.imageOutput.resolutionSelector", sj3.class, null);
        G = new pg("camerax.core.imageOutput.customOrderedResolutions", List.class, null);
    }

    ArrayList A();

    sj3 B();

    Size H();

    Size L();

    boolean R();

    int T();

    Size c0();

    int f0(int i);

    int h0();

    List j();

    sj3 k();

    int q();
}
