package defpackage;

import android.transition.Transition;
import androidx.fragment.app.a0;
import androidx.fragment.app.f;
import androidx.fragment.app.o;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tm0 extends f {
    public final Object b;
    public final boolean c;
    public final Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tm0(a0 a0Var, boolean z, boolean z2) {
        super(a0Var);
        o oVar = a0Var.c;
        this.b = a0Var.a == 2 ? z ? oVar.getReenterTransition() : oVar.getEnterTransition() : z ? oVar.getReturnTransition() : oVar.getExitTransition();
        this.c = a0Var.a == 2 ? z ? oVar.getAllowReturnTransitionOverlap() : oVar.getAllowEnterTransitionOverlap() : true;
        this.d = z2 ? z ? oVar.getSharedElementReturnTransition() : oVar.getSharedElementEnterTransition() : null;
    }

    public final uk1 b() {
        Object obj = this.b;
        uk1 uk1VarC = c(obj);
        Object obj2 = this.d;
        uk1 uk1VarC2 = c(obj2);
        if (uk1VarC == null || uk1VarC2 == null || uk1VarC == uk1VarC2) {
            return uk1VarC == null ? uk1VarC2 : uk1VarC;
        }
        throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + this.a.c + " returned Transition " + obj + " which uses a different Transition  type than its shared element transition " + obj2).toString());
    }

    public final uk1 c(Object obj) {
        if (obj == null) {
            return null;
        }
        tk1 tk1Var = ok1.a;
        if (obj instanceof Transition) {
            return tk1Var;
        }
        uk1 uk1Var = ok1.b;
        if (uk1Var != null && uk1Var.g(obj)) {
            return uk1Var;
        }
        StringBuilder sb = new StringBuilder("Transition ");
        sb.append(obj);
        o oVar = this.a.c;
        sb.append(" for fragment ");
        sb.append(oVar);
        sb.append(" is not a valid framework Transition or AndroidX Transition");
        throw new IllegalArgumentException(sb.toString());
    }
}
