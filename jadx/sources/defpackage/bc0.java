package defpackage;

import android.content.Context;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class bc0 {
    public final ih4 a;
    public final Context b;
    public final Object c;
    public final LinkedHashSet d;
    public Object e;

    public bc0(Context context, ih4 ih4Var) {
        this.a = ih4Var;
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        this.b = applicationContext;
        this.c = new Object();
        this.d = new LinkedHashSet();
    }

    public abstract Object a();

    public final void b(Object obj) {
        synchronized (this.c) {
            Object obj2 = this.e;
            if (obj2 == null || !obj2.equals(obj)) {
                this.e = obj;
                ((fs1) this.a.d).execute(new s7(21, d70.y0(this.d), this));
            }
        }
    }

    public abstract void c();

    public abstract void d();
}
