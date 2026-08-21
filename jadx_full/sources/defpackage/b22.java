package defpackage;

import j$.time.Duration;
import j$.util.Optional;
import java.net.SocketTimeoutException;
import java.nio.channels.Channel;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b22 extends k70 implements Channel {
    public abstract wk0 W0(boolean z);

    public abstract boolean X0();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws SocketTimeoutException {
        Duration duration;
        boolean zX0;
        Optional optionalOf;
        if (isClosed() || X0()) {
            return;
        }
        wk0 wk0VarW0 = W0(true);
        if (this instanceof v83) {
            j83 j83Var = k80.a;
            Object objB = x83.b((v83) this, j83Var.b);
            if (objB != null) {
                Long lC = x83.c(objB);
                optionalOf = Optional.of(lC != null ? Duration.ofMillis(lC.longValue()) : null);
            } else {
                optionalOf = j83Var.z;
            }
            duration = (Duration) optionalOf.get();
        } else {
            duration = (Duration) k80.a.z.get();
        }
        u00[] u00VarArr = new u00[0];
        if (duration != null) {
            wk0VarW0.getClass();
            zX0 = wk0VarW0.X0(duration.toMillis(), u00VarArr);
        } else {
            zX0 = wk0VarW0.X0(Long.MAX_VALUE, u00VarArr);
        }
        if (zX0) {
            return;
        }
        throw new SocketTimeoutException("Failed to receive closure confirmation within " + duration + " millis");
    }

    public abstract boolean isClosed();

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return (isClosed() || X0()) ? false : true;
    }
}
