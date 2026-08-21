package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import io.sentry.n5;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u implements k2 {
    public CopyOnWriteArraySet A;
    public HashMap X;
    public String b;
    public String f;
    public CopyOnWriteArraySet z;

    public u(String str, String str2) {
        this.b = str;
        this.f = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && u.class == obj.getClass()) {
            u uVar = (u) obj;
            if (this.b.equals(uVar.b) && this.f.equals(uVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.f});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("name");
        cVar.y(this.b);
        cVar.p("version");
        cVar.y(this.f);
        CopyOnWriteArraySet copyOnWriteArraySet = this.z;
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = n5.d().b;
        }
        CopyOnWriteArraySet copyOnWriteArraySet2 = this.A;
        if (copyOnWriteArraySet2 == null) {
            copyOnWriteArraySet2 = n5.d().a;
        }
        if (!copyOnWriteArraySet.isEmpty()) {
            cVar.p("packages");
            cVar.v(iLogger, copyOnWriteArraySet);
        }
        if (!copyOnWriteArraySet2.isEmpty()) {
            cVar.p("integrations");
            cVar.v(iLogger, copyOnWriteArraySet2);
        }
        HashMap map = this.X;
        if (map != null) {
            for (String str : map.keySet()) {
                io.sentry.e.c(this.X, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
