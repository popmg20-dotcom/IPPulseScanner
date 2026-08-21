package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x05 implements Runnable {
    public final /* synthetic */ d45 A;
    public final /* synthetic */ int b;
    public final /* synthetic */ String f;
    public final /* synthetic */ long z;

    public /* synthetic */ x05(d45 d45Var, String str, long j, int i) {
        this.b = i;
        this.f = str;
        this.z = j;
        this.A = d45Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        long j = this.z;
        String str = this.f;
        d45 d45Var = this.A;
        switch (i) {
            case 0:
                d45Var.V0();
                tj4.f(str);
                ie ieVar = d45Var.Y;
                if (ieVar.isEmpty()) {
                    d45Var.Z = j;
                }
                Integer num = (Integer) ieVar.get(str);
                if (num != null) {
                    ieVar.put(str, Integer.valueOf(num.intValue() + 1));
                } else if (ieVar.z < 100) {
                    ieVar.put(str, 1);
                    d45Var.X.put(str, Long.valueOf(j));
                } else {
                    t65 t65Var = ((k85) d45Var.f).Y;
                    k85.h(t65Var);
                    t65Var.C0.a("Too many ads visible");
                }
                break;
            default:
                d45Var.V0();
                tj4.f(str);
                ie ieVar2 = d45Var.Y;
                Integer num2 = (Integer) ieVar2.get(str);
                k85 k85Var = (k85) d45Var.f;
                if (num2 == null) {
                    t65 t65Var2 = k85Var.Y;
                    k85.h(t65Var2);
                    t65Var2.z0.b(str, "Call to endAdUnitExposure for unknown ad unit id");
                } else {
                    yb5 yb5Var = k85Var.C0;
                    t65 t65Var3 = k85Var.Y;
                    k85.g(yb5Var);
                    rb5 rb5VarB1 = yb5Var.b1(false);
                    int iIntValue = num2.intValue() - 1;
                    if (iIntValue != 0) {
                        ieVar2.put(str, Integer.valueOf(iIntValue));
                    } else {
                        ieVar2.remove(str);
                        ie ieVar3 = d45Var.X;
                        Long l = (Long) ieVar3.get(str);
                        if (l == null) {
                            k85.h(t65Var3);
                            t65Var3.z0.a("First ad unit exposure time was never set");
                        } else {
                            long jLongValue = j - l.longValue();
                            ieVar3.remove(str);
                            d45Var.a1(str, jLongValue, rb5VarB1);
                        }
                        if (ieVar2.isEmpty()) {
                            long j2 = d45Var.Z;
                            if (j2 != 0) {
                                d45Var.Z0(j - j2, rb5VarB1);
                                d45Var.Z = 0L;
                            } else {
                                k85.h(t65Var3);
                                t65Var3.z0.a("First ad exposure time was never set");
                            }
                        }
                    }
                }
                break;
        }
    }
}
