package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class rd4 implements bf0 {
    public final ThreadLocal b;

    public rd4(ThreadLocal threadLocal) {
        this.b = threadLocal;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof rd4) && this.b.equals(((rd4) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "ThreadLocalKey(threadLocal=" + this.b + ')';
    }
}
