package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e74 implements dd0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ e74(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.dd0
    public final void accept(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                oh ohVar = (oh) obj;
                for (Map.Entry entry : ((Map) obj2).entrySet()) {
                    int i2 = ohVar.b - ((bh) entry.getKey()).f;
                    if (((bh) entry.getKey()).g) {
                        i2 = -i2;
                    }
                    int i3 = kg4.i(i2);
                    c74 c74Var = (c74) entry.getValue();
                    c74Var.getClass();
                    co4.S(new yk0(c74Var, i3, -1, 1));
                }
                break;
            case 1:
                m10 m10Var = (m10) obj2;
                ez4.o("SurfaceViewImpl", "Safe to release surface.");
                if (m10Var != null) {
                    m10Var.e();
                }
                break;
            case 2:
                ((vv) obj2).b((nh) obj);
                break;
            default:
                ((q53) obj2).e((iv4) obj);
                break;
        }
    }
}
