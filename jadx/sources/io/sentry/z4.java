package io.sentry;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.concurrent.Callable;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z4 implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ io.sentry.internal.debugmeta.c b;

    public /* synthetic */ z4(io.sentry.internal.debugmeta.c cVar, int i) {
        this.a = i;
        this.b = cVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.a;
        io.sentry.internal.debugmeta.c cVar = this.b;
        switch (i) {
            case 0:
                return Integer.valueOf(cVar.o().length);
            case 1:
                return cVar.o();
            case 2:
                return Integer.valueOf(cVar.o().length);
            case 3:
                return cVar.o();
            case 4:
                return Integer.valueOf(cVar.o().length);
            case 5:
                return cVar.o();
            case 6:
                return Integer.valueOf(cVar.o().length);
            case 7:
                return Integer.valueOf(cVar.o().length);
            case 8:
                return cVar.o();
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return Integer.valueOf(cVar.o().length);
            case 10:
                return cVar.o();
            case 11:
                return Integer.valueOf(cVar.o().length);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return cVar.o();
            case 13:
                return Integer.valueOf(cVar.o().length);
            case 14:
                return cVar.o();
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return cVar.o();
            case 16:
                return Integer.valueOf(cVar.o().length);
            case 17:
                return cVar.o();
            case 18:
                return Integer.valueOf(cVar.o().length);
            default:
                return cVar.o();
        }
    }
}
