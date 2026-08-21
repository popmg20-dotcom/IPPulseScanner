package defpackage;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.EnumSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m50 {
    public static final m50 e = new m50();
    public final Field a;
    public final Field b;
    public final String c;
    public final String d;

    public m50() {
        String string;
        Field fieldA;
        String string2;
        Field fieldA2 = null;
        try {
            fieldA = a(EnumSet.class, "elementType");
            string = null;
        } catch (Exception e2) {
            string = e2.toString();
            fieldA = null;
        }
        this.a = fieldA;
        this.c = string;
        try {
            string2 = null;
            fieldA2 = a(EnumMap.class, "keyType");
        } catch (Exception e3) {
            string2 = e3.toString();
        }
        this.b = fieldA2;
        this.d = string2;
    }

    public static Field a(Class cls, String str) {
        for (Field field : cls.getDeclaredFields()) {
            if (str.equals(field.getName()) && field.getType() == Class.class) {
                field.setAccessible(true);
                return field;
            }
        }
        xe.q(fw.v("No field named '", str, "' in class '", cls.getName(), "'"));
        return null;
    }
}
