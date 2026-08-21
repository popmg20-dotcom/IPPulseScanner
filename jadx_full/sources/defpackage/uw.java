package defpackage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class uw implements Runnable {
    public final /* synthetic */ Object A;
    public final /* synthetic */ Object X;
    public final /* synthetic */ Object Y;
    public final /* synthetic */ Object Z;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ uw(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
        this.X = obj4;
        this.Y = obj5;
        this.Z = obj6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.b) {
            case 0:
                ex exVar = (ex) this.f;
                String str = (String) this.z;
                tt3 tt3Var = (tt3) this.A;
                mn4 mn4Var = (mn4) this.X;
                ih ihVar = (ih) this.Y;
                List list = (List) this.Z;
                exVar.w("Use case " + str + " RESET", null);
                exVar.b.H(str, tt3Var, mn4Var, ihVar, list);
                exVar.s();
                exVar.F();
                exVar.M();
                if (exVar.c1 == 10) {
                    exVar.E();
                }
                break;
            case 1:
                ex exVar2 = (ex) this.f;
                String str2 = (String) this.z;
                tt3 tt3Var2 = (tt3) this.A;
                mn4 mn4Var2 = (mn4) this.X;
                ih ihVar2 = (ih) this.Y;
                List list2 = (List) this.Z;
                exVar2.w("Use case " + str2 + " UPDATED", null);
                exVar2.b.H(str2, tt3Var2, mn4Var2, ihVar2, list2);
                exVar2.M();
                break;
            case 2:
                ex exVar3 = (ex) this.f;
                String str3 = (String) this.z;
                tt3 tt3Var3 = (tt3) this.A;
                mn4 mn4Var3 = (mn4) this.X;
                ih ihVar3 = (ih) this.Y;
                List list3 = (List) this.Z;
                exVar3.w("Use case " + str3 + " ACTIVE", null);
                LinkedHashMap linkedHashMap = (LinkedHashMap) exVar3.b.z;
                jn4 jn4Var = (jn4) linkedHashMap.get(str3);
                if (jn4Var == null) {
                    jn4Var = new jn4(tt3Var3, mn4Var3, ihVar3, list3);
                    linkedHashMap.put(str3, jn4Var);
                }
                jn4Var.f = true;
                exVar3.b.H(str3, tt3Var3, mn4Var3, ihVar3, list3);
                exVar3.M();
                break;
            default:
                ((v92) this.f).g((mz) this.z, (mz) this.A, (c74) this.X, (c74) this.Y, (Map.Entry) this.Z);
                break;
        }
    }
}
