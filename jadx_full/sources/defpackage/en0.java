package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class en0 implements om1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ vv f;

    public /* synthetic */ en0(vv vvVar, int i) {
        this.b = i;
        this.f = vvVar;
    }

    @Override // defpackage.om1
    public final void m(Object obj) {
        int i = this.b;
        vv vvVar = this.f;
        switch (i) {
            case 0:
                List list = (List) obj;
                list.getClass();
                vvVar.b(new ArrayList(list));
                break;
            default:
                try {
                    vvVar.b(obj);
                } catch (Throwable th) {
                    vvVar.d(th);
                    return;
                }
                break;
        }
    }

    @Override // defpackage.om1
    public final void q(Throwable th) {
        int i = this.b;
        vv vvVar = this.f;
        switch (i) {
            case 0:
                if (!(th instanceof TimeoutException)) {
                    vvVar.b(Collections.EMPTY_LIST);
                } else {
                    vvVar.d(th);
                }
                break;
            default:
                vvVar.d(th);
                break;
        }
    }
}
