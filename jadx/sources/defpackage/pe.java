package defpackage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pe extends hi4 {
    public static final oe c = new oe();
    public final Class a;
    public final xg2 b;

    public pe(iq1 iq1Var, hi4 hi4Var, Class cls) {
        this.b = new xg2(iq1Var, hi4Var, cls);
        this.a = cls;
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        if (r62Var.X() == 9) {
            r62Var.N();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        r62Var.B0();
        while (r62Var.hasNext()) {
            arrayList.add(this.b.c.b(r62Var));
        }
        r62Var.w0();
        int size = arrayList.size();
        Class cls = this.a;
        if (!cls.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) cls, size);
        for (int i = 0; i < size; i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        if (obj == null) {
            v72Var.C();
            return;
        }
        v72Var.B0();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.b.c(v72Var, Array.get(obj, i));
        }
        v72Var.w0();
    }
}
