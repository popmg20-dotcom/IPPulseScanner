package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.util.Objects;
import j$.util.Optional;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class re4 {
    public final Optional a;
    public final Optional b;

    public re4(Optional optional, Optional optional2) {
        Objects.requireNonNull(optional);
        Objects.requireNonNull(optional2);
        this.a = optional;
        this.b = optional2;
    }

    public abstract int a();

    public String toString() {
        switch (a()) {
            case 1:
                return "<alias>";
            case 2:
                return "<anchor>";
            case 3:
                return "<block end>";
            case 4:
                return "-";
            case 5:
                return "<block mapping start>";
            case 6:
                return "<block sequence start>";
            case 7:
                return "<directive>";
            case 8:
                return "<document end>";
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return "<document start>";
            case 10:
                return ",";
            case 11:
                return "}";
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return "{";
            case 13:
                return "]";
            case 14:
                return "[";
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return "?";
            case 16:
                return "<scalar>";
            case 17:
                return "<stream end>";
            case 18:
                return "<stream start>";
            case 19:
                return "<tag>";
            case 20:
                return "#";
            case 21:
                return ":";
            default:
                throw null;
        }
    }
}
