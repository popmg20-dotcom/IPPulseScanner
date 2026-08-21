package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i01 implements dd0 {
    public final /* synthetic */ int a;
    public Object b;

    public /* synthetic */ i01(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.dd0
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                ((dd0) this.b).getClass();
                ((dd0) this.b).accept(obj);
                return;
            case 1:
                ei1 ei1Var = (ei1) obj;
                if (ei1Var == null) {
                    ei1Var = new ei1(-3);
                }
                ((lb) this.b).E(ei1Var);
                return;
            default:
                ei1 ei1Var2 = (ei1) obj;
                synchronized (fi1.c) {
                    try {
                        xw3 xw3Var = fi1.d;
                        ArrayList arrayList = (ArrayList) xw3Var.get((String) this.b);
                        if (arrayList == null) {
                            return;
                        }
                        xw3Var.remove((String) this.b);
                        for (int i = 0; i < arrayList.size(); i++) {
                            ((dd0) arrayList.get(i)).accept(ei1Var2);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }

    public /* synthetic */ i01() {
        this.a = 0;
    }
}
