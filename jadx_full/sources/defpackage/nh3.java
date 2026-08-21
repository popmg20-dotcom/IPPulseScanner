package defpackage;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nh3 implements ii4 {
    public final k42 A;
    public final List X;
    public final lb b;
    public final int f;
    public final u61 z;

    public nh3(lb lbVar, int i, u61 u61Var, k42 k42Var, List list) {
        this.b = lbVar;
        this.f = i;
        this.z = u61Var;
        this.A = k42Var;
        this.X = list;
    }

    public static void b(Class cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + hh3.c(field) + " and " + hh3.c(field2) + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("duplicate-fields"));
    }

    @Override // defpackage.ii4
    public final hi4 a(iq1 iq1Var, bk4 bk4Var) {
        Class cls = bk4Var.a;
        if (!Object.class.isAssignableFrom(cls)) {
            return null;
        }
        ez4 ez4Var = hh3.a;
        if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
            return new fq1(2);
        }
        co4.u(this.X);
        return hh3.a.I(cls) ? new mh3(cls, c(iq1Var, bk4Var, cls, true)) : new kh3(this.b.t(bk4Var, true), c(iq1Var, bk4Var, cls, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c5  */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r26v1 */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r26v5 */
    /* JADX WARN: Type inference failed for: r27v0 */
    /* JADX WARN: Type inference failed for: r27v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r29v0, types: [nh3] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final lh3 c(iq1 iq1Var, bk4 bk4Var, Class cls, boolean z) {
        ?? r26;
        ?? r262;
        Method method;
        et3 et3Var;
        List listAsList;
        String name;
        boolean z2;
        ?? SingletonList;
        i42 i42Var;
        iq1 iq1Var2;
        boolean z3;
        Field field;
        ?? r27;
        hi4 hi4VarD;
        ih3 ih3Var;
        if (cls.isInterface()) {
            return lh3.c;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        bk4 bk4Var2 = bk4Var;
        Class cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            if (cls2 != cls && declaredFields.length > 0) {
                co4.u(this.X);
            }
            int length = declaredFields.length;
            ?? r14 = 0;
            int i = 0;
            while (i < length) {
                Field field2 = declaredFields[i];
                boolean zD = d(field2, true);
                boolean zD2 = d(field2, r14);
                if (zD || zD2) {
                    if (!z) {
                        r26 = zD2;
                    } else if (Modifier.isStatic(field2.getModifiers())) {
                        r26 = r14;
                    } else {
                        Method methodU = hh3.a.u(cls2, field2);
                        hh3.f(methodU);
                        if (methodU.getAnnotation(et3.class) != null && field2.getAnnotation(et3.class) == null) {
                            throw new l52(ha0.o("@SerializedName on ", hh3.d(methodU, r14), " is not supported"));
                        }
                        r262 = zD2;
                        method = methodU;
                        if (method == null) {
                            hh3.f(field2);
                        }
                        Type typeV = l72.V(bk4Var2.b, cls2, field2.getGenericType(), new HashMap());
                        et3Var = (et3) field2.getAnnotation(et3.class);
                        if (et3Var != null) {
                            switch (this.f) {
                                case 1:
                                    name = field2.getName();
                                    break;
                                case 2:
                                    name = ha0.f(field2.getName());
                                    break;
                                case 3:
                                    name = ha0.f(ha0.e(field2.getName(), ' '));
                                    break;
                                case 4:
                                    name = ha0.e(field2.getName(), '_').toUpperCase(Locale.ENGLISH);
                                    break;
                                case 5:
                                    name = ha0.e(field2.getName(), '_').toLowerCase(Locale.ENGLISH);
                                    break;
                                case 6:
                                    name = ha0.e(field2.getName(), '-').toLowerCase(Locale.ENGLISH);
                                    break;
                                default:
                                    name = ha0.e(field2.getName(), '.').toLowerCase(Locale.ENGLISH);
                                    break;
                            }
                            listAsList = Collections.EMPTY_LIST;
                        } else {
                            String strValue = et3Var.value();
                            listAsList = Arrays.asList(et3Var.alternate());
                            name = strValue;
                        }
                        if (listAsList.isEmpty()) {
                            z2 = true;
                            ArrayList arrayList = new ArrayList(listAsList.size() + 1);
                            arrayList.add(name);
                            arrayList.addAll(listAsList);
                            SingletonList = arrayList;
                        } else {
                            z2 = true;
                            SingletonList = Collections.singletonList(name);
                        }
                        String str = (String) SingletonList.get(r14);
                        bk4 bk4Var3 = new bk4(typeV);
                        Class cls3 = bk4Var3.a;
                        ?? r22 = (cls3 == null && cls3.isPrimitive()) ? z2 : r14;
                        int modifiers = field2.getModifiers();
                        ?? r23 = (Modifier.isStatic(modifiers) || !Modifier.isFinal(modifiers)) ? r14 : z2;
                        i42Var = (i42) field2.getAnnotation(i42.class);
                        if (i42Var == null) {
                            field = field2;
                            z3 = z2;
                            r27 = SingletonList;
                            iq1Var2 = iq1Var;
                            hi4VarD = this.A.b(this.b, iq1Var2, bk4Var3, i42Var, false);
                        } else {
                            iq1Var2 = iq1Var;
                            z3 = z2;
                            field = field2;
                            r27 = SingletonList;
                            hi4VarD = null;
                        }
                        ?? r2 = hi4VarD == null ? z3 : r14;
                        if (hi4VarD == null) {
                            hi4VarD = iq1Var2.d(bk4Var3);
                        }
                        ih3 ih3Var2 = new ih3(str, field, method, zD ? hi4VarD : r2 != 0 ? hi4VarD : new xg2(iq1Var2, hi4VarD, bk4Var3.b), hi4VarD, r22, r23);
                        Field field3 = field;
                        if (r262 != 0) {
                            for (String str2 : r27) {
                                ih3 ih3Var3 = (ih3) linkedHashMap.put(str2, ih3Var2);
                                if (ih3Var3 != null) {
                                    b(cls, str2, ih3Var3.b, field3);
                                    throw null;
                                }
                            }
                        }
                        if (zD && (ih3Var = (ih3) linkedHashMap2.put(str, ih3Var2)) != null) {
                            b(cls, str, ih3Var.b, field3);
                            throw null;
                        }
                    }
                    method = null;
                    r262 = r26;
                    if (method == null) {
                    }
                    Type typeV2 = l72.V(bk4Var2.b, cls2, field2.getGenericType(), new HashMap());
                    et3Var = (et3) field2.getAnnotation(et3.class);
                    if (et3Var != null) {
                    }
                    if (listAsList.isEmpty()) {
                    }
                    String str3 = (String) SingletonList.get(r14);
                    bk4 bk4Var32 = new bk4(typeV2);
                    Class cls32 = bk4Var32.a;
                    if (cls32 == null) {
                        int modifiers2 = field2.getModifiers();
                        if (Modifier.isStatic(modifiers2)) {
                            i42Var = (i42) field2.getAnnotation(i42.class);
                            if (i42Var == null) {
                            }
                            if (hi4VarD == null) {
                            }
                            if (hi4VarD == null) {
                            }
                            if (zD) {
                            }
                            ih3 ih3Var22 = new ih3(str3, field, method, zD ? hi4VarD : r2 != 0 ? hi4VarD : new xg2(iq1Var2, hi4VarD, bk4Var32.b), hi4VarD, r22, r23);
                            Field field32 = field;
                            if (r262 != 0) {
                            }
                            if (zD) {
                                continue;
                            }
                        }
                    }
                }
                i++;
                r14 = 0;
            }
            bk4Var2 = new bk4(l72.V(bk4Var2.b, cls2, cls2.getGenericSuperclass(), new HashMap()));
            cls2 = bk4Var2.a;
        }
        return new lh3(new ArrayList(linkedHashMap2.values()), linkedHashMap);
    }

    public final boolean d(Field field, boolean z) {
        boolean z2;
        x81 x81Var;
        u61 u61Var = this.z;
        u61Var.getClass();
        if ((136 & field.getModifiers()) == 0 && !field.isSynthetic() && ((!u61Var.b || ((x81Var = (x81) field.getAnnotation(x81.class)) != null && (!z ? !x81Var.deserialize() : !x81Var.serialize()))) && !u61Var.c(field.getType(), z))) {
            List list = z ? u61Var.f : u61Var.z;
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    throw dw2.z(it);
                }
            }
            z2 = false;
        } else {
            z2 = true;
        }
        return !z2;
    }
}
