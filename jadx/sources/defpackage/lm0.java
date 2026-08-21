package defpackage;

import androidx.fragment.app.a0;
import androidx.fragment.app.h;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lm0 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ h f;
    public final /* synthetic */ a0 z;

    public /* synthetic */ lm0(h hVar, a0 a0Var, int i) {
        this.b = i;
        this.f = hVar;
        this.z = a0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        a0 a0Var = this.z;
        h hVar = this.f;
        switch (i) {
            case 0:
                hVar.a(a0Var);
                break;
            default:
                hVar.b.remove(a0Var);
                hVar.c.remove(a0Var);
                break;
        }
    }
}
