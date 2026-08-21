package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class jt2 {
    public static final /* synthetic */ int a = 0;

    static {
        List listAsList = Arrays.asList(Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE);
        if (ga5.u(listAsList)) {
            List list = Collections.EMPTY_LIST;
        } else {
            DesugarCollections.unmodifiableList(new ArrayList(listAsList));
        }
    }
}
