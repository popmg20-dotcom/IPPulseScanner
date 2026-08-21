package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.util.function.Predicate$CC;
import java.util.function.Predicate;
import org.conscrypt.FileClientSessionCache;
import org.eclipse.tm4e.languageconfiguration.internal.model.AutoClosingPair;
import org.eclipse.tm4e.languageconfiguration.internal.model.AutoClosingPairConditional;
import org.eclipse.tm4e.languageconfiguration.internal.model.CharacterPair;
import org.eclipse.tm4e.languageconfiguration.internal.model.LanguageConfiguration;
import org.eclipse.tm4e.languageconfiguration.internal.model.OnEnterRule;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class sm implements Predicate {
    public final /* synthetic */ int a;

    public /* synthetic */ sm(int i) {
        this.a = i;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.a;
        return Predicate$CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        int i = this.a;
        return Predicate$CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.a;
        return Predicate$CC.$default$or(this, predicate);
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.a) {
            case 0:
                om omVar = (om) obj;
                return (omVar.a() || omVar.n()) ? false : true;
            case 1:
                return ((yr) obj).g();
            case 2:
                return LanguageConfiguration.lambda$load$8((AutoClosingPairConditional) obj);
            case 3:
                return LanguageConfiguration.lambda$load$9((CharacterPair) obj);
            case 4:
                return LanguageConfiguration.lambda$load$10((OnEnterRule) obj);
            case 5:
                return LanguageConfiguration.lambda$load$11((AutoClosingPair) obj);
            case 6:
                return LanguageConfiguration.lambda$load$12((CharacterPair) obj);
            case 7:
                return ((nw2) obj).g();
            case 8:
                return ((nw2) ((to2) obj)).g();
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return ((CharacterPair) obj) != null;
            case 10:
                String str = (String) obj;
                return (str == null ? "" : str.trim()).toLowerCase().contains("android");
            case 11:
                ((z1) obj).Y0();
                throw null;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                ((z1) obj).Y0();
                throw null;
            case 13:
                ((z1) obj).Y0();
                throw null;
            case 14:
                ((z1) obj).Y0();
                throw null;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                ((z1) obj).Y0();
                throw null;
            case 16:
                ((z1) obj).Y0();
                throw null;
            default:
                return t84.a((String) obj);
        }
    }

    public /* synthetic */ sm(String str, int i) {
        this.a = i;
    }
}
