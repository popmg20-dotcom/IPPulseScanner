package defpackage;

import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.g;
import androidx.fragment.app.u;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rm0 extends r82 implements pl1 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ ViewGroup X;
    public final /* synthetic */ int f = 0;
    public final /* synthetic */ g z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rm0(g gVar, Object obj, ViewGroup viewGroup) {
        super(0);
        this.z = gVar;
        this.A = obj;
        this.X = viewGroup;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    @Override // defpackage.pl1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a() {
        int i = this.f;
        xl4 xl4Var = xl4.a;
        ViewGroup viewGroup = this.X;
        Object obj = this.A;
        g gVar = this.z;
        switch (i) {
            case 0:
                gVar.f.e(viewGroup, obj);
                break;
            default:
                ArrayList arrayList = gVar.c;
                uk1 uk1Var = gVar.f;
                if (!arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (!((tm0) it.next()).a.g) {
                            if (u.M(2)) {
                                Log.v("FragmentManager", "Completing animating immediately");
                            }
                            b10 b10Var = new b10();
                            uk1Var.u(((tm0) arrayList.get(0)).a.c, obj, b10Var, new d4(18, gVar));
                            b10Var.a();
                            break;
                        }
                    }
                    if (u.M(2)) {
                    }
                    Object obj2 = gVar.q;
                    obj2.getClass();
                    uk1Var.d(obj2, new s7(24, gVar, viewGroup));
                } else {
                    if (u.M(2)) {
                        Log.v("FragmentManager", "Animating to start");
                    }
                    Object obj22 = gVar.q;
                    obj22.getClass();
                    uk1Var.d(obj22, new s7(24, gVar, viewGroup));
                }
                break;
        }
        return xl4Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rm0(g gVar, ViewGroup viewGroup, Object obj) {
        super(0);
        this.z = gVar;
        this.X = viewGroup;
        this.A = obj;
    }
}
