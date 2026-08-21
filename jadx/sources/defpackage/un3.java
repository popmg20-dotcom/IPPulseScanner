package defpackage;

import j$.util.DesugarCollections;
import j$.util.Objects;
import j$.util.function.Function$CC;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class un3 implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ Serializable b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ un3(Serializable serializable, Object obj, Object obj2, int i) {
        this.a = i;
        this.b = serializable;
        this.c = obj;
        this.d = obj2;
    }

    public /* synthetic */ Function andThen(Function function) {
        int i = this.a;
        return Function$CC.$default$andThen(this, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        Object umVar;
        boolean z;
        int i = this.a;
        Object obj2 = this.d;
        Object obj3 = this.c;
        Serializable serializable = this.b;
        switch (i) {
            case 0:
                sd3 sd3Var = (sd3) serializable;
                zv1 zv1Var = (zv1) obj3;
                rd3 rd3Var = (rd3) obj2;
                wn3 wn3Var = (wn3) obj;
                sd3Var.f(wn3Var);
                String str = (String) sd3Var.get("match");
                if (str != null) {
                    return new lh2(wn3Var, sd3Var.c(), str, vn3.a(sd3Var.b(), zv1Var, rd3Var));
                }
                String str2 = (String) sd3Var.get("begin");
                boolean zBooleanValue = false;
                if (str2 == null) {
                    if (sd3Var.e() != null) {
                        rd3[] rd3VarArr = {rd3Var, sd3Var.e()};
                        rd3Var = new rd3();
                        for (int i2 = 0; i2 < 2; i2++) {
                            rd3 rd3Var2 = rd3VarArr[i2];
                            if (rd3Var2 != null) {
                                Iterator it = rd3Var2.entrySet().iterator();
                                while (it.hasNext()) {
                                    Map.Entry entry = (Map.Entry) it.next();
                                    rd3Var.put((String) entry.getKey(), (sd3) entry.getValue());
                                }
                            }
                        }
                    }
                    Collection collectionD = sd3Var.d();
                    if (collectionD == null && ((String) sd3Var.get("include")) != null) {
                        sd3 sd3Var2 = new sd3();
                        sd3Var2.g((String) sd3Var.get("include"));
                        Object[] objArr = {sd3Var2};
                        ArrayList arrayList = new ArrayList(1);
                        Object obj4 = objArr[0];
                        Objects.requireNonNull(obj4);
                        arrayList.add(obj4);
                        collectionD = DesugarCollections.unmodifiableList(arrayList);
                    }
                    return new nz1(wn3Var, sd3Var.c(), (String) sd3Var.get("contentName"), vn3.b(collectionD, zv1Var, rd3Var));
                }
                String str3 = (String) sd3Var.get("while");
                if (str3 != null) {
                    String strC = sd3Var.c();
                    String str4 = (String) sd3Var.get("contentName");
                    sd3Var.j("beginCaptures");
                    kd3 kd3Var = (kd3) sd3Var.get("beginCaptures");
                    kd3 kd3VarB = sd3Var.b();
                    if (kd3Var == null) {
                        kd3Var = kd3VarB;
                    }
                    List listA = vn3.a(kd3Var, zv1Var, rd3Var);
                    sd3Var.j("whileCaptures");
                    kd3 kd3Var2 = (kd3) sd3Var.get("whileCaptures");
                    kd3 kd3VarB2 = sd3Var.b();
                    if (kd3Var2 == null) {
                        kd3Var2 = kd3VarB2;
                    }
                    umVar = new vm(wn3Var, strC, str4, str2, listA, str3, vn3.a(kd3Var2, zv1Var, rd3Var), vn3.b(sd3Var.d(), zv1Var, rd3Var));
                } else {
                    String strC2 = sd3Var.c();
                    String str5 = (String) sd3Var.get("contentName");
                    sd3Var.j("beginCaptures");
                    kd3 kd3Var3 = (kd3) sd3Var.get("beginCaptures");
                    kd3 kd3VarB3 = sd3Var.b();
                    if (kd3Var3 == null) {
                        kd3Var3 = kd3VarB3;
                    }
                    List listA2 = vn3.a(kd3Var3, zv1Var, rd3Var);
                    String str6 = (String) sd3Var.get("end");
                    sd3Var.j("endCaptures");
                    kd3 kd3Var4 = (kd3) sd3Var.get("endCaptures");
                    kd3 kd3VarB4 = sd3Var.b();
                    if (kd3Var4 == null) {
                        kd3Var4 = kd3VarB4;
                    }
                    List listA3 = vn3.a(kd3Var4, zv1Var, rd3Var);
                    V v = sd3Var.get("applyEndPatternLast");
                    if (v != 0) {
                        if (v instanceof Boolean) {
                            zBooleanValue = ((Boolean) v).booleanValue();
                        } else {
                            if ((v instanceof Integer) && ((Integer) v).intValue() == 1) {
                                z = true;
                            }
                            umVar = new um(wn3Var, strC2, str5, str2, listA2, str6, listA3, z, vn3.b(sd3Var.d(), zv1Var, rd3Var));
                        }
                        z = zBooleanValue;
                        umVar = new um(wn3Var, strC2, str5, str2, listA2, str6, listA3, z, vn3.b(sd3Var.d(), zv1Var, rd3Var));
                    } else {
                        z = zBooleanValue;
                        umVar = new um(wn3Var, strC2, str5, str2, listA2, str6, listA3, z, vn3.b(sd3Var.d(), zv1Var, rd3Var));
                    }
                }
                return umVar;
            default:
                return new j10((wn3) obj, (String) serializable, (String) obj3, (wn3) obj2);
        }
    }

    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }
}
