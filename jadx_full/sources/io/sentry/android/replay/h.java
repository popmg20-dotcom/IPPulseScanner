package io.sentry.android.replay;

import defpackage.am1;
import defpackage.r82;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h extends r82 implements am1 {
    public static final h f = new h(1);

    @Override // defpackage.am1
    public final Object g(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        entry.getClass();
        return ((String) entry.getKey()) + '=' + ((String) entry.getValue());
    }
}
