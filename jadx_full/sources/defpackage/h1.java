package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class h1 extends vf2 {
    public final Map Z;
    public final Integer y0;

    public h1(List list, Integer num, Map map) {
        super(4);
        this.Z = map == null ? new HashMap() : map;
        this.y0 = num;
        if (list != null) {
            return;
        }
        new ArrayList();
    }
}
