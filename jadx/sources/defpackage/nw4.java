package defpackage;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nw4 {
    public static final String i = ue2.i("WorkContinuationImpl");
    public final xw4 a;
    public final String b;
    public final o71 c;
    public final List d;
    public final ArrayList e;
    public final ArrayList f = new ArrayList();
    public boolean g;
    public k01 h;

    public nw4(xw4 xw4Var, String str, o71 o71Var, List list, int i2) {
        this.a = xw4Var;
        this.b = str;
        this.c = o71Var;
        this.d = list;
        this.e = new ArrayList(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (o71Var == o71.b && ((ex4) list.get(i3)).b.u != Long.MAX_VALUE) {
                xe.k("Next Schedule Time Override must be used with ExistingPeriodicWorkPolicyUPDATE (preferably) or KEEP");
                throw null;
            }
            String string = ((ex4) list.get(i3)).a.toString();
            string.getClass();
            this.e.add(string);
            this.f.add(string);
        }
    }

    public static HashSet b(nw4 nw4Var) {
        HashSet hashSet = new HashSet();
        nw4Var.getClass();
        return hashSet;
    }

    public final k01 a() {
        if (this.g) {
            ue2.g().j(i, "Already enqueued work ids (" + TextUtils.join(", ", this.e) + ")");
        } else {
            xw4 xw4Var = this.a;
            this.h = p95.w(xw4Var.b.g, "EnqueueRunnable_" + this.c.name(), (la) xw4Var.d.a, new fn(26, this));
        }
        return this.h;
    }
}
