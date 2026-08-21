package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bl1 implements er1, kp3, pq4 {
    public fa2 A = null;
    public ip3 X = null;
    public final o b;
    public final oq4 f;
    public final j z;

    public bl1(o oVar, oq4 oq4Var, j jVar) {
        this.b = oVar;
        this.f = oq4Var;
        this.z = jVar;
    }

    public final void a(p92 p92Var) {
        this.A.f(p92Var);
    }

    public final void c() {
        if (this.A == null) {
            this.A = new fa2(this);
            jp3 jp3Var = new jp3(this, new fn(22, this));
            this.X = new ip3(jp3Var);
            jp3Var.a();
            this.z.run();
        }
    }

    @Override // defpackage.er1
    public final dg0 getDefaultViewModelCreationExtras() {
        Application application;
        o oVar = this.b;
        Context applicationContext = oVar.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        in2 in2Var = new in2(0);
        LinkedHashMap linkedHashMap = in2Var.a;
        if (application != null) {
            linkedHashMap.put(lq4.e, application);
        }
        linkedHashMap.put(cp3.a, oVar);
        linkedHashMap.put(cp3.b, this);
        if (oVar.getArguments() != null) {
            linkedHashMap.put(cp3.c, oVar.getArguments());
        }
        return in2Var;
    }

    @Override // defpackage.da2
    public final r92 getLifecycle() {
        c();
        return this.A;
    }

    @Override // defpackage.kp3
    public final hp3 getSavedStateRegistry() {
        c();
        return this.X.b;
    }

    @Override // defpackage.pq4
    public final oq4 getViewModelStore() {
        c();
        return this.f;
    }
}
