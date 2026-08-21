package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class do3 implements be2, Serializable {
    public transient we2 b;

    @Override // defpackage.be2
    public final void debug(String str) {
        this.b.debug(String.valueOf(str));
    }

    @Override // defpackage.be2
    public final void error(String str) {
        this.b.error(String.valueOf(str));
    }

    @Override // defpackage.be2
    public final void info(String str) {
        this.b.info(String.valueOf(str));
    }

    @Override // defpackage.be2
    public final boolean isDebugEnabled() {
        return this.b.isDebugEnabled();
    }

    @Override // defpackage.be2
    public final boolean isErrorEnabled() {
        return this.b.isErrorEnabled();
    }

    @Override // defpackage.be2
    public final boolean isInfoEnabled() {
        return this.b.isInfoEnabled();
    }

    @Override // defpackage.be2
    public final boolean isTraceEnabled() {
        return this.b.isTraceEnabled();
    }

    @Override // defpackage.be2
    public final boolean isWarnEnabled() {
        return this.b.isWarnEnabled();
    }

    @Override // defpackage.be2
    public final void trace(String str) {
        this.b.trace(String.valueOf(str));
    }

    @Override // defpackage.be2
    public final void warn(String str) {
        this.b.warn(String.valueOf(str));
    }

    @Override // defpackage.be2
    public final void debug(String str, Throwable th) {
        this.b.debug(String.valueOf(str), th);
    }

    @Override // defpackage.be2
    public final void error(String str, Throwable th) {
        this.b.error(String.valueOf(str), th);
    }

    @Override // defpackage.be2
    public final void info(String str, Throwable th) {
        this.b.info(String.valueOf(str), th);
    }

    @Override // defpackage.be2
    public final void trace(String str, Throwable th) {
        this.b.trace(String.valueOf(str), th);
    }

    @Override // defpackage.be2
    public final void warn(String str, Throwable th) {
        this.b.warn(String.valueOf(str), th);
    }
}
