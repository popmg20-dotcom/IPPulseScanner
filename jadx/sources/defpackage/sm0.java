package defpackage;

import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.g;
import androidx.fragment.app.u;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sm0 extends r82 implements pl1 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ bh3 X;
    public final /* synthetic */ g f;
    public final /* synthetic */ ViewGroup z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sm0(g gVar, ViewGroup viewGroup, Object obj, bh3 bh3Var) {
        super(0);
        this.f = gVar;
        this.z = viewGroup;
        this.A = obj;
        this.X = bh3Var;
    }

    @Override // defpackage.pl1
    public final Object a() {
        if (u.M(2)) {
            Log.v("FragmentManager", "Attempting to create TransitionSeekController");
        }
        g gVar = this.f;
        uk1 uk1Var = gVar.f;
        ViewGroup viewGroup = this.z;
        Object obj = this.A;
        Object objI = uk1Var.i(viewGroup, obj);
        gVar.q = objI;
        if (objI == null) {
            if (u.M(2)) {
                Log.v("FragmentManager", "TransitionSeekController was not created.");
            }
            gVar.r = true;
        } else {
            this.X.b = new rm0(gVar, obj, viewGroup);
            if (u.M(2)) {
                Log.v("FragmentManager", "Started executing operations from " + gVar.d + " to " + gVar.e);
            }
        }
        return xl4.a;
    }
}
