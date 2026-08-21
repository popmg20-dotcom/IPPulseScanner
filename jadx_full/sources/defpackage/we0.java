package defpackage;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class we0 implements Iterable, z72 {
    public final /* synthetic */ int b;
    public final Object f;

    public we0() {
        this.b = 0;
        this.f = new CopyOnWriteArrayList();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                Iterator it = ((CopyOnWriteArrayList) obj).iterator();
                it.getClass();
                return it;
            default:
                return new co0((do0) obj);
        }
    }

    public we0(do0 do0Var) {
        this.b = 1;
        this.f = do0Var;
    }
}
