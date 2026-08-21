package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jd1 {
    public jy3 a;
    public boolean b;
    public boolean c;
    public boolean d;

    public static Object l(ft0 ft0Var, Object obj, boolean z) {
        Object objQ;
        if (obj != null && ft0Var.o().b == cw4.MESSAGE) {
            if (ft0Var.y()) {
                if (!(obj instanceof List)) {
                    zo2.v(obj.getClass(), "Repeated field should contains a List but actually contains type: ");
                    return null;
                }
                List arrayList = (List) obj;
                for (int i = 0; i < arrayList.size(); i++) {
                    Object obj2 = arrayList.get(i);
                    if (obj2 instanceof ml2) {
                        ml2 ml2Var = (ml2) obj2;
                        objQ = z ? ml2Var.q() : ml2Var.p();
                    } else {
                        objQ = obj2;
                    }
                    if (objQ != obj2) {
                        if (arrayList == obj) {
                            arrayList = new ArrayList(arrayList);
                        }
                        arrayList.set(i, objQ);
                    }
                }
                return arrayList;
            }
            if (obj instanceof ml2) {
                ml2 ml2Var2 = (ml2) obj;
                return z ? ml2Var2.q() : ml2Var2.p();
            }
        }
        return obj;
    }

    public static void m(jy3 jy3Var, boolean z) {
        int i = jy3Var.f;
        for (int i2 = 0; i2 < i; i2++) {
            ly3 ly3VarC = jy3Var.c(i2);
            ly3VarC.setValue(l((ft0) ly3VarC.getKey(), ly3VarC.getValue(), z));
        }
        for (Map.Entry entry : jy3Var.d()) {
            entry.setValue(l((ft0) entry.getKey(), entry.getValue(), z));
        }
    }

    public static void o(ft0 ft0Var, Object obj) {
        if (kd1.l(ft0Var.o(), obj)) {
            return;
        }
        if (ft0Var.o().b == cw4.MESSAGE && (obj instanceof ml2)) {
            return;
        }
        zo2.p("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(ft0Var.z.Z), ft0Var.o().b, obj.getClass().getName()});
    }

    public final void a(ft0 ft0Var, Object obj) {
        List arrayList;
        d();
        if (!ft0Var.y()) {
            xe.k("addRepeatedField() can only be called on repeated fields.");
            return;
        }
        this.d = this.d || (obj instanceof ml2);
        o(ft0Var, obj);
        Object objG = g(ft0Var);
        if (objG == null) {
            arrayList = new ArrayList();
            this.a.put(ft0Var, arrayList);
        } else {
            arrayList = (List) objG;
        }
        arrayList.add(obj);
    }

    public final kd1 b(boolean z) {
        if (this.a.isEmpty()) {
            return kd1.d;
        }
        this.c = false;
        jy3 jy3VarA = this.a;
        if (this.d) {
            jy3VarA = kd1.a(jy3VarA, false, false);
            m(jy3VarA, z);
        }
        kd1 kd1Var = new kd1(jy3VarA);
        kd1Var.c = this.b;
        return kd1Var;
    }

    public final void c(ft0 ft0Var) {
        d();
        this.a.remove(ft0Var);
        if (this.a.isEmpty()) {
            this.b = false;
        }
    }

    public final void d() {
        if (this.c) {
            return;
        }
        this.a = kd1.a(this.a, true, false);
        this.c = true;
    }

    public final Map e() {
        boolean z = this.b;
        jy3 jy3Var = this.a;
        if (!z) {
            return jy3Var.A ? jy3Var : DesugarCollections.unmodifiableMap(jy3Var);
        }
        jy3 jy3VarA = kd1.a(jy3Var, false, true);
        if (this.a.A) {
            jy3VarA.f();
            return jy3VarA;
        }
        m(jy3VarA, true);
        return jy3VarA;
    }

    public final Object f(ft0 ft0Var) {
        return l(ft0Var, g(ft0Var), true);
    }

    public final Object g(ft0 ft0Var) {
        Object obj = this.a.get(ft0Var);
        return obj instanceof d92 ? ((d92) obj).b() : obj;
    }

    public final boolean h(ft0 ft0Var) {
        if (!ft0Var.y()) {
            return this.a.get(ft0Var) != null;
        }
        xe.k("hasField() can only be called on non-repeated fields.");
        return false;
    }

    public final boolean i() {
        int i = this.a.f;
        int i2 = 0;
        while (true) {
            jy3 jy3Var = this.a;
            if (i2 >= i) {
                Iterator it = jy3Var.d().iterator();
                while (it.hasNext()) {
                    if (!kd1.k((Map.Entry) it.next())) {
                    }
                }
                return true;
            }
            if (!kd1.k(jy3Var.c(i2))) {
                break;
            }
            i2++;
        }
        return false;
    }

    public final void j(kd1 kd1Var) {
        jy3 jy3Var;
        d();
        int i = kd1Var.a.f;
        int i2 = 0;
        while (true) {
            jy3Var = kd1Var.a;
            if (i2 >= i) {
                break;
            }
            k(jy3Var.c(i2));
            i2++;
        }
        Iterator it = jy3Var.d().iterator();
        while (it.hasNext()) {
            k((Map.Entry) it.next());
        }
    }

    public final void k(Map.Entry entry) {
        ft0 ft0Var = (ft0) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof d92;
        if (ft0Var.y()) {
            if (z) {
                xe.q("Lazy fields can not be repeated");
                return;
            }
            List arrayList = (List) g(ft0Var);
            List list = (List) value;
            int size = list.size();
            if (arrayList == null) {
                arrayList = new ArrayList(size);
                this.a.put(ft0Var, arrayList);
            }
            for (int i = 0; i < size; i++) {
                Object obj = list.get(i);
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    byte[] bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    obj = bArr2;
                }
                arrayList.add(obj);
            }
            return;
        }
        if (ft0Var.o().b != cw4.MESSAGE) {
            if (z) {
                xe.q("Lazy fields must be message-valued");
                return;
            }
            jy3 jy3Var = this.a;
            if (value instanceof byte[]) {
                byte[] bArr3 = (byte[]) value;
                byte[] bArr4 = new byte[bArr3.length];
                System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                value = bArr4;
            }
            jy3Var.put(ft0Var, value);
            return;
        }
        Object objG = g(ft0Var);
        if (objG != null) {
            if (z) {
                value = ((d92) value).b();
            }
            if (!(objG instanceof nl2)) {
                ((a1) objG).x((c1) value);
                return;
            }
            ml2 ml2VarU = ((nl2) objG).u();
            ((a1) ml2VarU).x((c1) value);
            this.a.put(ft0Var, ml2VarU.p());
            return;
        }
        jy3 jy3Var2 = this.a;
        if (value instanceof byte[]) {
            byte[] bArr5 = (byte[]) value;
            byte[] bArr6 = new byte[bArr5.length];
            System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
            value = bArr6;
        }
        jy3Var2.put(ft0Var, value);
        if (z) {
            this.b = true;
        }
    }

    public final void n(ft0 ft0Var, Object obj) {
        d();
        if (!ft0Var.y()) {
            o(ft0Var, obj);
        } else {
            if (!(obj instanceof List)) {
                xe.k("Wrong object type used with protocol message reflection.");
                return;
            }
            ArrayList arrayList = new ArrayList((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                Object obj2 = arrayList.get(i);
                o(ft0Var, obj2);
                this.d = this.d || (obj2 instanceof ml2);
            }
            obj = arrayList;
        }
        if (obj instanceof d92) {
            this.b = true;
        }
        this.d = this.d || (obj instanceof ml2);
        this.a.put(ft0Var, obj);
    }
}
