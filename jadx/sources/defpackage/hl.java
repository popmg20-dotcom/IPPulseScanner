package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.util.Objects;
import j$.util.Optional;
import j$.util.function.Function$CC;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.function.Function;
import org.conscrypt.FileClientSessionCache;
import org.eclipse.tm4e.languageconfiguration.internal.model.CharacterPair;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class hl implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ hl(int i) {
        this.a = i;
    }

    public /* synthetic */ Function andThen(Function function) {
        int i = this.a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = 0;
        switch (this.a) {
            case 0:
                return new ArrayList();
            case 1:
                return vh3.a((String) obj);
            case 2:
                return ((ds2) obj).a;
            case 3:
                return ((b01) obj).b;
            case 4:
                return ((b01) obj).z;
            case 5:
                return new ln2(0);
            case 6:
                try {
                    return new g42((String) obj, false);
                } catch (r94 e) {
                    if (!(e.getCause() instanceof q22)) {
                        throw e;
                    }
                    e.printStackTrace();
                    return new g42("^$", false);
                }
            case 7:
                to2 to2Var = (to2) obj;
                int i2 = so2.a;
                if (to2Var == null) {
                    return null;
                }
                return to2Var.getName();
            case 8:
                try {
                    return new bp2((String) obj, false);
                } catch (r94 e2) {
                    if (e2.getCause() != null) {
                        throw e2;
                    }
                    e2.printStackTrace();
                    return new bp2("^$", false);
                }
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                try {
                    return Optional.of(((Class) obj).getMethod("clone", null));
                } catch (Exception unused) {
                    return Optional.empty();
                }
            case 10:
                return new bv2((CharacterPair) obj);
            case 11:
                return ((d9) obj).P();
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return ((oh3) obj).a;
            case 13:
                return ((oh3) obj).b;
            case 14:
                return ((oh3) obj).b;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return new TreeMap(String.CASE_INSENSITIVE_ORDER);
            case 16:
                wr wrVar = (wr) obj;
                if (wrVar == null) {
                    return null;
                }
                return wrVar.a() ? new gh0(wrVar, i) : new gh0(wrVar, 1);
            case 17:
                String string = Objects.toString((String) obj);
                return t84.a(string) ? string.substring(23) : string;
            default:
                return obj.toString();
        }
    }

    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }
}
