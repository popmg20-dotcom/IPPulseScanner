package io.netty.handler.ssl;

import defpackage.fw;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SniCompletionEvent extends SslCompletionEvent {
    private final String hostname;

    public SniCompletionEvent(String str) {
        this.hostname = str;
    }

    public String hostname() {
        return this.hostname;
    }

    @Override // io.netty.handler.ssl.SslCompletionEvent
    public String toString() {
        Throwable thCause = cause();
        if (thCause == null) {
            return fw.y(new StringBuilder("SniCompletionEvent(SUCCESS='"), this.hostname, "'\")");
        }
        return "SniCompletionEvent(" + thCause + ')';
    }

    public SniCompletionEvent(String str, Throwable th) {
        super(th);
        this.hostname = str;
    }

    public SniCompletionEvent(Throwable th) {
        this(null, th);
    }
}
