package io.netty.handler.codec;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class MessageAggregationException extends IllegalStateException {
    private static final long serialVersionUID = -1995826182950310255L;

    public MessageAggregationException() {
    }

    public MessageAggregationException(String str) {
        super(str);
    }

    public MessageAggregationException(String str, Throwable th) {
        super(str, th);
    }

    public MessageAggregationException(Throwable th) {
        super(th);
    }
}
