package defpackage;

import com.getsurfboard.ui.fragment.MemoryUsageFragment;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jk2 implements pl1 {
    public final /* synthetic */ boolean b;
    public final /* synthetic */ MemoryUsageFragment f;

    public jk2(boolean z, MemoryUsageFragment memoryUsageFragment) {
        this.b = z;
        this.f = memoryUsageFragment;
    }

    @Override // defpackage.pl1
    public final Object a() {
        if (this.b) {
            MemoryUsageFragment memoryUsageFragment = this.f;
            dk1 dk1Var = memoryUsageFragment.b;
            dk1Var.getClass();
            dk1Var.g.setVisibility(0);
            dk1 dk1Var2 = memoryUsageFragment.b;
            dk1Var2.getClass();
            dk1Var2.g.setOnClickListener(ik2.b);
        }
        return xl4.a;
    }
}
