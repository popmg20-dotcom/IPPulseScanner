package io.netty.channel;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class EventLoopException extends ChannelException {
    private static final long serialVersionUID = -8969100344583703616L;

    public EventLoopException() {
    }

    public EventLoopException(String str, Throwable th) {
        super(str, th);
    }

    public EventLoopException(String str) {
        super(str);
    }

    public EventLoopException(Throwable th) {
        super(th);
    }
}
