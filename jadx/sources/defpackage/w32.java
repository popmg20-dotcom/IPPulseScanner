package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class w32 extends CancellationException {
    public final transient e42 b;

    public w32(String str, Throwable th, e42 e42Var) {
        super(str);
        this.b = e42Var;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w32)) {
            return false;
        }
        w32 w32Var = (w32) obj;
        if (!n12.c(w32Var.getMessage(), getMessage())) {
            return false;
        }
        Object obj2 = w32Var.b;
        if (obj2 == null) {
            obj2 = is2.f;
        }
        Object obj3 = this.b;
        if (obj3 == null) {
            obj3 = is2.f;
        }
        return n12.c(obj2, obj3) && n12.c(w32Var.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        message.getClass();
        int iHashCode = message.hashCode() * 31;
        Object obj = this.b;
        if (obj == null) {
            obj = is2.f;
        }
        int iHashCode2 = (iHashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        Throwable cause = getCause();
        return iHashCode2 + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("; job=");
        Object obj = this.b;
        if (obj == null) {
            obj = is2.f;
        }
        sb.append(obj);
        return sb.toString();
    }
}
