package defpackage;

import android.content.Context;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ae0 {
    public volatile Object a;
    public final Object b;

    public ae0() {
        this.b = new CopyOnWriteArraySet();
    }

    public Object a(Context context) {
        if (this.a == null) {
            synchronized (this) {
                try {
                    if (this.a == null) {
                        this.a = ((st4) this.b).d(context);
                    }
                } finally {
                }
            }
        }
        return this.a;
    }

    public ae0(st4 st4Var) {
        this.a = null;
        this.b = st4Var;
    }
}
