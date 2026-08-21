package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vm2 extends ov2 {
    public static final ov2[] c = new ov2[0];
    public static final nk4[] d = new nk4[0];
    public final /* synthetic */ int a;
    public final ov2[] b;

    public vm2(int i) {
        this.a = i;
        switch (i) {
            case 1:
                ArrayList arrayList = new ArrayList();
                if (arrayList.isEmpty()) {
                    arrayList.add(new zz0(0));
                    arrayList.add(new zz0(2));
                    arrayList.add(new zz0(1));
                }
                this.b = (nk4[]) arrayList.toArray(d);
                break;
            default:
                ArrayList arrayList2 = new ArrayList();
                if (arrayList2.isEmpty()) {
                    arrayList2.add(new vm2(1));
                    arrayList2.add(new g60(false));
                    arrayList2.add(new e60());
                    arrayList2.add(new h60());
                    arrayList2.add(new f60());
                    sw1 sw1Var = new sw1();
                    sw1Var.a = -1;
                    arrayList2.add(sw1Var);
                    arrayList2.add(new fd3());
                    arrayList2.add(new gd3());
                }
                this.b = (ov2[]) arrayList2.toArray(c);
                break;
        }
    }

    @Override // defpackage.ov2
    public final vk3 b(int i, bn bnVar, Map map) throws qs2 {
        int i2 = this.a;
        ov2[] ov2VarArr = this.b;
        switch (i2) {
            case 0:
                for (int i3 = 0; i3 < ov2VarArr.length; i3++) {
                    try {
                        return ov2VarArr[i3].b(i, bnVar, map);
                    } catch (de3 unused) {
                    }
                }
                throw qs2.a();
            default:
                int[] iArrL = nk4.l(bnVar);
                for (nk4 nk4Var : (nk4[]) ov2VarArr) {
                    try {
                        vk3 vk3VarJ = nk4Var.j(i, bnVar, iArrL, map);
                        boolean z = vk3VarJ.d == sj.y0 && vk3VarJ.a.charAt(0) == '0';
                        Collection collection = map == null ? null : (Collection) map.get(fk0.b);
                        sj sjVar = sj.F0;
                        boolean z2 = collection == null || collection.contains(sjVar);
                        if (!z || !z2) {
                            return vk3VarJ;
                        }
                        vk3 vk3Var = new vk3(vk3VarJ.a.substring(1), vk3VarJ.b, vk3VarJ.c, sjVar);
                        vk3Var.a(vk3VarJ.e);
                        return vk3Var;
                    } catch (de3 unused2) {
                    }
                }
                throw qs2.a();
        }
    }

    @Override // defpackage.ov2, defpackage.be3
    public final void reset() {
        int i = this.a;
        int i2 = 0;
        ov2[] ov2VarArr = this.b;
        switch (i) {
            case 0:
                int length = ov2VarArr.length;
                while (i2 < length) {
                    ov2VarArr[i2].reset();
                    i2++;
                }
                break;
            default:
                nk4[] nk4VarArr = (nk4[]) ov2VarArr;
                int length2 = nk4VarArr.length;
                while (i2 < length2) {
                    nk4VarArr[i2].getClass();
                    i2++;
                }
                break;
        }
    }
}
