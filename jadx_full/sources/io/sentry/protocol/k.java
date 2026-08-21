package io.sentry.protocol;

import io.netty.handler.codec.rtsp.RtspHeaders;
import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k implements k2 {
    public w A;
    public w X;
    public String Y;
    public AbstractMap Z;
    public String b;
    public String f;
    public String z;

    public k(String str) {
        if (str.length() > 4096) {
            this.b = str.substring(0, 4096);
        } else {
            this.b = str;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return io.sentry.util.b.i(this.b, kVar.b) && io.sentry.util.b.i(this.f, kVar.f) && io.sentry.util.b.i(this.z, kVar.z) && io.sentry.util.b.i(this.A, kVar.A) && io.sentry.util.b.i(this.X, kVar.X) && io.sentry.util.b.i(this.Y, kVar.Y) && io.sentry.util.b.i(this.Z, kVar.Z);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.f, this.z, this.A, this.X, this.Y, this.Z});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("message");
        cVar.y(this.b);
        if (this.f != null) {
            cVar.p("contact_email");
            cVar.y(this.f);
        }
        if (this.z != null) {
            cVar.p("name");
            cVar.y(this.z);
        }
        if (this.A != null) {
            cVar.p("associated_event_id");
            this.A.serialize(cVar, iLogger);
        }
        if (this.X != null) {
            cVar.p("replay_id");
            this.X.serialize(cVar, iLogger);
        }
        if (this.Y != null) {
            cVar.p(RtspHeaders.Values.URL);
            cVar.y(this.Y);
        }
        AbstractMap abstractMap = this.Z;
        if (abstractMap != null) {
            for (String str : abstractMap.keySet()) {
                Object obj = this.Z.get(str);
                cVar.p(str);
                cVar.v(iLogger, obj);
            }
        }
        cVar.m();
    }

    public final String toString() {
        return "Feedback{message='" + this.b + "', contactEmail='" + this.f + "', name='" + this.z + "', associatedEventId=" + this.A + ", replayId=" + this.X + ", url='" + this.Y + "', unknown=" + this.Z + '}';
    }
}
