package io.netty.util.concurrent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class BlockingOperationException extends IllegalStateException {
    private static final long serialVersionUID = 2462223247762460301L;

    public BlockingOperationException() {
    }

    public BlockingOperationException(String str) {
        super(str);
    }

    public BlockingOperationException(Throwable th) {
        super(th);
    }

    public BlockingOperationException(String str, Throwable th) {
        super(str, th);
    }
}
