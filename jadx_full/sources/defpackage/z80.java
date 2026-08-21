package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.p;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z80 implements pl1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ p f;

    public /* synthetic */ z80(p pVar, int i) {
        this.b = i;
        this.f = pVar;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.b;
        p pVar = this.f;
        switch (i) {
            case 0:
                pVar.reportFullyDrawn();
                return xl4.a;
            case 1:
                return new ol1(pVar.Y, new z80(pVar, 0));
            case 2:
                zu0 zu0Var = new zu0();
                pVar.b().c().c.c(zu0Var);
                return zu0Var;
            case 3:
                return new lp3(pVar.getApplication(), pVar, pVar.getIntent() != null ? pVar.getIntent().getExtras() : null);
            default:
                wu2 wu2Var = new wu2(new y80(pVar, 1));
                if (Build.VERSION.SDK_INT >= 33) {
                    if (n12.c(Looper.myLooper(), Looper.getMainLooper())) {
                        pVar.b.a(new a90(wu2Var, pVar));
                    } else {
                        new Handler(Looper.getMainLooper()).post(new s7(18, pVar, wu2Var));
                    }
                }
                return wu2Var;
        }
    }
}
