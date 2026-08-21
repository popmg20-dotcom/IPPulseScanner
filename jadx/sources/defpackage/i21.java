package defpackage;

import android.content.Context;
import android.view.WindowMetrics;
import androidx.window.reflection.Predicate2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i21 implements Predicate2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ v04 c;

    public /* synthetic */ i21(v04 v04Var, Context context, int i) {
        this.a = i;
        this.c = v04Var;
        this.b = context;
    }

    @Override // androidx.window.reflection.Predicate2
    public final boolean test(Object obj) {
        switch (this.a) {
            case 0:
                t04 t04Var = (t04) this.c;
                Context context = this.b;
                WindowMetrics windowMetrics = (WindowMetrics) obj;
                windowMetrics.getClass();
                return t04Var.b(context, windowMetrics);
            default:
                s04 s04Var = (s04) this.c;
                Context context2 = this.b;
                WindowMetrics windowMetrics2 = (WindowMetrics) obj;
                windowMetrics2.getClass();
                return s04Var.b(context2, windowMetrics2);
        }
    }
}
