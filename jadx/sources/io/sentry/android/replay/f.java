package io.sentry.android.replay;

import defpackage.ye;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Comparator {
    public final /* synthetic */ int b;

    public /* synthetic */ f(int i) {
        this.b = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.b) {
            case 0:
                return ye.f(Long.valueOf(((k) obj).b), Long.valueOf(((k) obj2).b));
            default:
                return ye.f(Long.valueOf(((io.sentry.rrweb.b) obj).f), Long.valueOf(((io.sentry.rrweb.b) obj2).f));
        }
    }
}
