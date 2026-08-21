package io.sentry.android.replay;

import defpackage.ek0;
import defpackage.vw0;
import defpackage.z82;
import io.sentry.n2;
import io.sentry.p6;
import io.sentry.y3;
import j$.util.DesugarCollections;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b implements y3 {
    public static final z82 c = ek0.v(a.z);
    public static final HashSet d;
    public String a;
    public final Map b = DesugarCollections.synchronizedMap(new vw0());

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("status_code");
        hashSet.add("method");
        hashSet.add("response_content_length");
        hashSet.add("request_content_length");
        hashSet.add("http.response_content_length");
        hashSet.add("http.request_content_length");
        d = hashSet;
    }

    public b(p6 p6Var) {
        p6Var.setBeforeBreadcrumb(new n2(this, p6Var.getBeforeBreadcrumb()));
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0232  */
    @Override // io.sentry.y3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.sentry.rrweb.b a(io.sentry.g r10) {
        /*
            Method dump skipped, instruction units count: 922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.b.a(io.sentry.g):io.sentry.rrweb.b");
    }
}
