package defpackage;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q51 extends hi4 {
    public static final p51 d = new p51();
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();

    public q51(Class cls) {
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            int i = 0;
            for (Field field : declaredFields) {
                if (field.isEnumConstant()) {
                    declaredFields[i] = field;
                    i++;
                }
            }
            Field[] fieldArr = (Field[]) Arrays.copyOf(declaredFields, i);
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field2 : fieldArr) {
                Enum r5 = (Enum) field2.get(null);
                String strName = r5.name();
                String string = r5.toString();
                et3 et3Var = (et3) field2.getAnnotation(et3.class);
                if (et3Var != null) {
                    strName = et3Var.value();
                    for (String str : et3Var.alternate()) {
                        this.a.put(str, r5);
                    }
                }
                this.a.put(strName, r5);
                this.b.put(string, r5);
                this.c.put(r5, strName);
            }
        } catch (IllegalAccessException e) {
            xe.i(e);
            throw null;
        }
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        if (r62Var.X() == 9) {
            r62Var.N();
            return null;
        }
        String strQ = r62Var.q();
        Enum r0 = (Enum) this.a.get(strQ);
        return r0 == null ? (Enum) this.b.get(strQ) : r0;
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        Enum r2 = (Enum) obj;
        v72Var.Z(r2 == null ? null : (String) this.c.get(r2));
    }
}
