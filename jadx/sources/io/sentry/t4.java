package io.sentry;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class t4 {
    public io.sentry.protocol.r A;
    public transient Throwable A0;
    public String B0;
    public String C0;
    public List D0;
    public io.sentry.protocol.f E0;
    public AbstractMap F0;
    public AbstractMap X;
    public String Y;
    public String Z;
    public io.sentry.protocol.w b;
    public final io.sentry.protocol.e f;
    public String y0;
    public io.sentry.protocol.u z;
    public io.sentry.protocol.j0 z0;

    public t4(io.sentry.protocol.w wVar) {
        this.f = new io.sentry.protocol.e();
        this.b = wVar;
    }

    public final Throwable a() {
        Throwable th = this.A0;
        return th instanceof io.sentry.exception.a ? ((io.sentry.exception.a) th).f : th;
    }

    public final void b(String str, String str2) {
        AbstractMap map = this.X;
        if (map == null) {
            map = new HashMap();
            this.X = map;
        }
        if (str == null) {
            return;
        }
        if (str2 == null) {
            map.remove(str);
        } else {
            map.put(str, str2);
        }
    }

    public final void c(Map map) {
        this.X = map != null ? new HashMap(map) : null;
    }

    public t4() {
        this(new io.sentry.protocol.w());
    }
}
