package io.sentry.protocol;

import defpackage.xe;
import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w implements k2 {
    public static final w f = new w("00000000-0000-0000-0000-000000000000".replace("-", ""));
    public volatile String b;

    public w(String str) {
        String str2 = str.equals("0000-0000") ? "00000000-0000-0000-0000-000000000000" : str;
        if (str2.length() == 32 || str2.length() == 36) {
            this.b = str2.length() == 36 ? str2.replace("-", "") : str2;
        } else {
            xe.k("String representation of SentryId has either 32 (UUID no dashes) or 36 characters long (completed UUID). Received: ".concat(str));
            throw null;
        }
    }

    public final String a() {
        String strF;
        String str = this.b;
        if (str != null) {
            return str;
        }
        synchronized (this) {
            try {
                strF = this.b;
                if (strF == null) {
                    strF = io.sentry.config.a.f();
                    this.b = strF;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return strF;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w.class != obj.getClass()) {
            return false;
        }
        return a().equals(((w) obj).a());
    }

    public final int hashCode() {
        return a().hashCode();
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) {
        ((io.sentry.internal.debugmeta.c) n3Var).y(a());
    }

    public final String toString() {
        return a();
    }
}
