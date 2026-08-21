package defpackage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class sh extends y32 {
    public static final /* synthetic */ long y0 = re.a.objectFieldOffset(sh.class.getDeclaredField("_disposer$volatile"));
    public final z00 X;
    public zv0 Y;
    public final /* synthetic */ uh Z;
    private volatile /* synthetic */ Object _disposer$volatile;

    public sh(uh uhVar, z00 z00Var) {
        this.Z = uhVar;
        this.X = z00Var;
    }

    @Override // defpackage.y32
    public final boolean l() {
        return false;
    }

    @Override // defpackage.y32
    public final void m(Throwable th) {
        z00 z00Var = this.X;
        if (th != null) {
            br1 br1VarH = z00Var.H(new r80(th, false), null);
            if (br1VarH != null) {
                z00Var.m(br1VarH);
                th thVar = (th) re.a.getObjectVolatile(this, y0);
                if (thVar != null) {
                    thVar.a();
                    return;
                }
                return;
            }
            return;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = uh.b;
        uh uhVar = this.Z;
        if (atomicIntegerFieldUpdater.decrementAndGet(uhVar) == 0) {
            fn0[] fn0VarArr = uhVar.a;
            ArrayList arrayList = new ArrayList(fn0VarArr.length);
            for (fn0 fn0Var : fn0VarArr) {
                arrayList.add(fn0Var.n());
            }
            z00Var.d(arrayList);
        }
    }
}
