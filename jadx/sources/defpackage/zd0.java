package defpackage;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zd0 extends uf2 implements Serializable {
    public static final zd0 C0;
    public static final Object D0;
    public final Map A0;
    public final transient HashMap B0;

    static {
        Map map = Collections.EMPTY_MAP;
        C0 = new zd0();
        D0 = new Object();
    }

    public zd0() {
        this.A0 = Collections.EMPTY_MAP;
        this.B0 = null;
    }

    public zd0(HashMap map) {
        this.A0 = Collections.EMPTY_MAP;
        this.B0 = map;
    }
}
