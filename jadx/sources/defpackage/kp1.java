package defpackage;

import android.content.Context;
import android.os.Build;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class kp1 {
    public final Context a;
    public final String b;
    public final w7 c;
    public final fb4 d;
    public final x9 e;
    public final int f;
    public final t60 g;
    public final tp1 h;

    public kp1(Context context, w7 w7Var, fb4 fb4Var, jp1 jp1Var) {
        tj4.j(context, "Null context is not permitted.");
        tj4.j(w7Var, "Api must not be null.");
        tj4.j(jp1Var, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        tj4.j(applicationContext, "The provided context did not have an application context.");
        this.a = applicationContext;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : null;
        this.b = attributionTag;
        this.c = w7Var;
        this.d = fb4Var;
        this.e = new x9(w7Var, fb4Var, attributionTag);
        tp1 tp1VarE = tp1.e(applicationContext);
        this.h = tp1VarE;
        this.f = tp1VarE.h.getAndIncrement();
        this.g = jp1Var.a;
        s05 s05Var = tp1VarE.m;
        s05Var.sendMessage(s05Var.obtainMessage(7, this));
    }

    public final ed4 a() {
        ed4 ed4Var = new ed4((char) 0, 11);
        Set set = Collections.EMPTY_SET;
        me meVar = (me) ed4Var.f;
        if (meVar == null) {
            meVar = new me(0);
            ed4Var.f = meVar;
        }
        meVar.addAll(set);
        Context context = this.a;
        ed4Var.A = context.getClass().getName();
        ed4Var.z = context.getPackageName();
        return ed4Var;
    }
}
