package defpackage;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class rb1 extends ua4 {
    public final /* synthetic */ hm3 e;
    public final /* synthetic */ sb1 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rb1(String str, hm3 hm3Var, sb1 sb1Var) {
        super(str);
        this.e = hm3Var;
        this.f = sb1Var;
    }

    @Override // defpackage.ua4
    public final long a() throws InterruptedException {
        gm3 gm3Var;
        hm3 hm3Var = this.e;
        try {
            gm3Var = hm3Var.c();
        } catch (Throwable th) {
            gm3Var = new gm3(hm3Var, null, th, 2);
        }
        sb1 sb1Var = this.f;
        if (!((CopyOnWriteArrayList) sb1Var.A).contains(hm3Var)) {
            return -1L;
        }
        ((LinkedBlockingDeque) sb1Var.X).put(gm3Var);
        return -1L;
    }
}
