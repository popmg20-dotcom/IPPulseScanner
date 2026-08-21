package defpackage;

import android.content.Context;
import android.view.View;
import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z10 {
    public final Context a;
    public final View b;
    public final iv1 c;
    public final int d;
    public final zf2 e;
    public final a20 f;
    public final nk2 g;
    public final Stack h;
    public final hg3 i;

    public z10(Context context, View view, iv1 iv1Var) {
        int iE = ek0.e(context, 196);
        zf2 zf2Var = new zf2(12, false);
        this.a = context;
        this.b = view;
        this.c = iv1Var;
        this.d = iE;
        this.e = zf2Var;
        this.f = new a20(context);
        this.g = new nk2(context);
        this.h = new Stack();
        this.i = new hg3();
        zf2Var.f = new v10(0, this);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public final void a(defpackage.nk2 r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z10.a(nk2, boolean):void");
    }
}
