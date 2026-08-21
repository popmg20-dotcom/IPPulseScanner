package defpackage;

import android.text.TextUtils;
import com.tencent.mars.xlog.Xlog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class tw implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ ex f;
    public final /* synthetic */ ArrayList z;

    public /* synthetic */ tw(ex exVar, ArrayList arrayList, int i) {
        this.b = i;
        this.f = exVar;
        this.z = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ed4 ed4Var;
        switch (this.b) {
            case 0:
                ex exVar = this.f;
                ArrayList<kg> arrayList = this.z;
                ArrayList arrayList2 = new ArrayList();
                boolean z = false;
                for (kg kgVar : arrayList) {
                    if (exVar.b.v(kgVar.a)) {
                        ((LinkedHashMap) exVar.b.z).remove(kgVar.a);
                        arrayList2.add(kgVar.a);
                        if (kgVar.b == j43.class) {
                            z = true;
                        }
                    }
                }
                if (arrayList2.isEmpty()) {
                    return;
                }
                exVar.w("Use cases [" + TextUtils.join(", ", arrayList2) + "] now DETACHED for camera", null);
                if (z) {
                    exVar.Z.Z.getClass();
                }
                exVar.s();
                if (exVar.b.t().isEmpty()) {
                    nw nwVar = exVar.Z;
                    dz4 dz4Var = nwVar.C0;
                    boolean z2 = dz4Var.d;
                    dz4Var.d = false;
                    nwVar.i(false);
                } else {
                    exVar.O();
                    exVar.N();
                }
                if (!exVar.b.s().isEmpty()) {
                    exVar.M();
                    exVar.F();
                    if (exVar.c1 == 10) {
                        exVar.E();
                        return;
                    }
                    return;
                }
                exVar.Z.b();
                exVar.F();
                exVar.Z.h(false);
                exVar.C0 = exVar.C();
                exVar.w("Closing camera.", null);
                switch (fw.G(exVar.c1)) {
                    case 3:
                    case 4:
                        r25.j(null, exVar.A0 == null);
                        exVar.G(3);
                        return;
                    case 5:
                    default:
                        exVar.w("close() ignored due to being in state: ".concat(fw.H(exVar.c1)), null);
                        return;
                    case 6:
                    case 7:
                    case 8:
                        if (exVar.y0.a() || ((ed4Var = (ed4) exVar.b1.f) != null && !((AtomicBoolean) ed4Var.z).get())) {
                            z = true;
                        }
                        exVar.b1.n();
                        exVar.G(6);
                        if (z) {
                            r25.j(null, exVar.G0.isEmpty());
                            exVar.u();
                            return;
                        }
                        return;
                    case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    case 10:
                        exVar.G(6);
                        exVar.t();
                        return;
                }
            default:
                ex exVar2 = this.f;
                ArrayList arrayList3 = this.z;
                nw nwVar2 = exVar2.Z;
                try {
                    exVar2.J(arrayList3);
                    return;
                } finally {
                    nwVar2.b();
                }
        }
    }
}
