package io.sentry;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d7 implements k2 {
    public static final d7 f = new d7("00000000-0000-0000-0000-000000000000".replace("-", "").substring(0, 16));
    public volatile String b;

    public d7(String str) {
        Objects.requireNonNull(str, "value is required");
        this.b = str;
    }

    public final String a() {
        String str;
        String str2 = this.b;
        if (str2 != null) {
            return str2;
        }
        synchronized (this) {
            try {
                str = this.b;
                if (str == null) {
                    byte[] bArr = new byte[8];
                    io.sentry.util.n.a().b(bArr);
                    byte b = (byte) (bArr[6] & 15);
                    bArr[6] = b;
                    bArr[6] = (byte) (b | 64);
                    long j = 0;
                    for (int i = 0; i < 8; i++) {
                        j = (j << 8) | ((long) (bArr[i] & 255));
                    }
                    char[] cArr = new char[16];
                    io.sentry.util.r.a(cArr, j);
                    String str3 = new String(cArr);
                    this.b = str3;
                    str = str3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d7.class != obj.getClass()) {
            return false;
        }
        return a().equals(((d7) obj).a());
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
