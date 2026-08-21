package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class u05 {
    public Boolean a;
    public boolean b;
    public final /* synthetic */ tk c;
    public final int d;
    public final Bundle e;
    public final /* synthetic */ tk f;

    public u05(tk tkVar, int i, Bundle bundle) {
        this.f = tkVar;
        Boolean bool = Boolean.TRUE;
        this.c = tkVar;
        this.a = bool;
        this.b = false;
        this.d = i;
        this.e = bundle;
    }

    public abstract boolean a();

    public abstract void b(ab0 ab0Var);

    public final void c() {
        d();
        tk tkVar = this.c;
        synchronized (tkVar.C0) {
            tkVar.C0.remove(this);
        }
    }

    public final void d() {
        synchronized (this) {
            this.a = null;
        }
    }
}
