package defpackage;

import j$.util.Optional;
import j$.util.function.Consumer$CC;
import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class t90 implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ t90(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Consumer
    /* JADX INFO: renamed from: accept */
    public final void n(Object obj) {
        String str;
        int i = this.a;
        Object obj2 = this.c;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                pp3 pp3Var = (pp3) obj2;
                f7 f7Var = (f7) obj;
                ((u90) obj3).z.put(f7Var, pp3Var);
                pp3Var.d = Optional.of(f7Var);
                break;
            case 1:
                dh2 dh2Var = (dh2) obj2;
                f7 f7Var2 = (f7) obj;
                ((u90) obj3).z.put(f7Var2, dh2Var);
                dh2Var.d = Optional.of(f7Var2);
                break;
            case 2:
                us3 us3Var = (us3) obj2;
                f7 f7Var3 = (f7) obj;
                ((u90) obj3).z.put(f7Var3, us3Var);
                us3Var.d = Optional.of(f7Var3);
                break;
            default:
                xp1 xp1Var = (xp1) obj3;
                ArrayList arrayList = (ArrayList) obj2;
                od3 od3VarB = xp1Var.b((String) obj, null);
                if (od3VarB != null && (str = (String) od3VarB.get("injectionSelector")) != null) {
                    xp1Var.a(arrayList, str, new nd3(od3VarB), xp1Var);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.a;
        return Consumer$CC.$default$andThen(this, consumer);
    }
}
