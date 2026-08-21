package defpackage;

import androidx.window.reflection.Consumer2;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b5 implements Consumer2 {
    public final /* synthetic */ int a = 1;
    public final Object b;

    public b5(f0 f0Var) {
        this.b = f0Var;
    }

    @Override // androidx.window.reflection.Consumer2
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                List list = (List) obj;
                list.getClass();
                ((r21) this.b).f(list);
                break;
            default:
                List list2 = (List) obj;
                list2.getClass();
                ((f0) this.b).g(list2);
                break;
        }
    }

    public b5(g91 g91Var, r21 r21Var) {
        this.b = r21Var;
    }
}
