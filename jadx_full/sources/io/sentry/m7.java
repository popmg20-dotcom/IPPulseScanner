package io.sentry;

import defpackage.fw;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m7 implements k2 {
    public final String A;
    public HashMap X;
    public final io.sentry.protocol.w b;
    public final String f;
    public final String z;

    public m7(io.sentry.protocol.w wVar, String str, String str2, String str3) {
        this.b = wVar;
        this.f = str;
        this.z = str2;
        this.A = str3;
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("event_id");
        this.b.serialize(cVar, iLogger);
        String str = this.f;
        if (str != null) {
            cVar.p("name");
            cVar.y(str);
        }
        String str2 = this.z;
        if (str2 != null) {
            cVar.p("email");
            cVar.y(str2);
        }
        String str3 = this.A;
        if (str3 != null) {
            cVar.p("comments");
            cVar.y(str3);
        }
        HashMap map = this.X;
        if (map != null) {
            for (String str4 : map.keySet()) {
                e.c(this.X, str4, cVar, str4, iLogger);
            }
        }
        cVar.m();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserFeedback{eventId=");
        sb.append(this.b);
        sb.append(", name='");
        sb.append(this.f);
        sb.append("', email='");
        sb.append(this.z);
        sb.append("', comments='");
        return fw.y(sb, this.A, "'}");
    }
}
