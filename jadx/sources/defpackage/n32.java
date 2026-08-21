package defpackage;

import com.getsurfboard.vpn.Jni;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n32 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Jni f;

    public /* synthetic */ n32(Jni jni, int i) {
        this.b = i;
        this.f = jni;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        Jni jni = this.f;
        switch (i) {
            case 0:
                dg4.p.f(jni.i);
                break;
            default:
                dg4.p.j(jni.i);
                break;
        }
    }
}
