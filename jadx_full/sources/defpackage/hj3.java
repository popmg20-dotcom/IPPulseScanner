package defpackage;

import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hj3 {
    public final ue1 a;
    public final sl3 b;
    public final pl3 c;
    public final j80 d;
    public final /* synthetic */ ij3 e;

    public hj3(sl3 sl3Var, ij3 ij3Var, pl3 pl3Var, String[] strArr) {
        this.e = ij3Var;
        ji jiVar = new ji(19);
        ue1 ue1Var = new ue1();
        ue1Var.b = jiVar;
        ue1Var.A = new o84(0);
        ue1Var.z = new ArrayList();
        this.a = ue1Var;
        this.b = sl3Var;
        this.c = pl3Var;
        this.d = new j80(strArr, this, new sp(3, this, hj3.class, "convertRows", "convertRows(Landroidx/room/RoomRawQuery;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0, 2));
    }

    public final void a() {
        ue1 ue1Var = this.a;
        boolean z = false;
        if (!ue1Var.f) {
            synchronized (((o84) ue1Var.A)) {
                if (!ue1Var.f) {
                    z = true;
                    ue1Var.f = true;
                    List listY0 = d70.y0((ArrayList) ue1Var.z);
                    ((ArrayList) ue1Var.z).clear();
                    ji jiVar = (ji) ue1Var.b;
                    Iterator it = listY0.iterator();
                    while (it.hasNext()) {
                        jiVar.g(it.next());
                    }
                }
            }
        }
        if (z && Build.ID != null && Log.isLoggable("Paging", 3)) {
            Log.d("Paging", "Invalidated PagingSource " + this, null);
        }
    }

    public final void b(pl1 pl1Var) {
        boolean z;
        ue1 ue1Var = this.a;
        if (ue1Var.f) {
            ((ji) ue1Var.b).g(pl1Var);
            return;
        }
        synchronized (((o84) ue1Var.A)) {
            if (ue1Var.f) {
                z = true;
            } else {
                ((ArrayList) ue1Var.z).add(pl1Var);
                z = false;
            }
        }
        if (z) {
            ((ji) ue1Var.b).g(pl1Var);
        }
    }
}
