package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xa3 extends r82 implements pl1 {
    public final /* synthetic */ int f;
    public final /* synthetic */ ya3 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ xa3(ya3 ya3Var, int i) {
        super(0);
        this.f = i;
        this.z = ya3Var;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.f;
        ya3 ya3Var = this.z;
        switch (i) {
            case 0:
                return ya3Var.requireActivity().getViewModelStore();
            case 1:
                return ya3Var.requireActivity().getDefaultViewModelCreationExtras();
            default:
                return (mq4) ya3Var.requireActivity().K0.getValue();
        }
    }
}
