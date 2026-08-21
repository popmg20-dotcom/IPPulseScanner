package defpackage;

import io.netty.util.internal.StringUtil;
import j$.util.DesugarCollections;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class bd4 {
    public final ConcurrentHashMap a = new ConcurrentHashMap();
    public final l70 b;
    public final z44 c;
    public final fd4 d;

    public bd4(l70 l70Var, z44 z44Var, fd4 fd4Var) {
        this.b = l70Var;
        this.d = fd4Var;
        this.c = z44Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Collection] */
    public static bd4 a(td3 td3Var, List list) {
        ?? arrayList;
        List listUnmodifiableList;
        int i;
        int i2;
        ArrayList arrayList2;
        if (td3Var == null) {
            arrayList = Collections.EMPTY_LIST;
        } else {
            Collection<td3> collection = (Collection) td3Var.get("settings");
            if (collection == null) {
                collection = (Collection) td3Var.get("tokenColors");
            }
            if (collection == null) {
                arrayList = Collections.EMPTY_LIST;
            } else {
                arrayList = new ArrayList();
                int i3 = -1;
                for (td3 td3Var2 : collection) {
                    td3 td3Var3 = (td3) td3Var2.get("settings");
                    if (td3Var3 != null) {
                        int i4 = i3 + 1;
                        Object obj = td3Var2.get("scope");
                        int i5 = 1;
                        if (obj instanceof String) {
                            listUnmodifiableList = m44.c(((String) obj).replaceAll("^,+", "").replaceAll(",+$", ""), StringUtil.COMMA);
                        } else if (obj instanceof List) {
                            listUnmodifiableList = (List) obj;
                        } else {
                            ArrayList arrayList3 = new ArrayList(1);
                            Object obj2 = new Object[]{""}[0];
                            Objects.requireNonNull(obj2);
                            arrayList3.add(obj2);
                            listUnmodifiableList = DesugarCollections.unmodifiableList(arrayList3);
                        }
                        Object obj3 = td3Var3.get("fontStyle");
                        if (obj3 instanceof String) {
                            int i6 = 0;
                            for (String str : m44.b((String) obj3)) {
                                str.getClass();
                                switch (str) {
                                    case "italic":
                                        i6 |= 1;
                                        break;
                                    case "underline":
                                        i6 |= 4;
                                        break;
                                    case "strikethrough":
                                        i6 |= 8;
                                        break;
                                    case "bold":
                                        i6 |= 2;
                                        break;
                                }
                            }
                            i = i6;
                        } else {
                            i = -1;
                        }
                        String str2 = (String) td3Var3.get("foreground");
                        String str3 = (str2 == null || !m44.a(str2)) ? null : str2;
                        String str4 = (String) td3Var3.get("background");
                        String str5 = (str4 == null || !m44.a(str4)) ? null : str4;
                        int size = listUnmodifiableList.size();
                        int i7 = 0;
                        while (i7 < size) {
                            List listC = m44.c(((String) listUnmodifiableList.get(i7)).trim(), ' ');
                            String str6 = (String) listC.get(listC.size() - i5);
                            if (listC.size() > i5) {
                                i2 = i5;
                                arrayList2 = new ArrayList(listC.subList(0, listC.size() - 1));
                                Collections.reverse(arrayList2);
                            } else {
                                i2 = i5;
                                arrayList2 = null;
                            }
                            arrayList.add(new l03(str6, arrayList2, i4, i, str3, str5));
                            i7++;
                            i5 = i2;
                        }
                        i3 = i4;
                    }
                }
            }
        }
        ArrayList arrayList4 = new ArrayList((Collection) arrayList);
        Collections.sort(arrayList4, new i60(12));
        String str7 = "@default";
        String str8 = "#ffffff";
        int i8 = 0;
        while (!arrayList4.isEmpty() && ((l03) arrayList4.get(0)).a.isEmpty()) {
            l03 l03Var = (l03) arrayList4.remove(0);
            int i9 = l03Var.d;
            if (i9 != -1) {
                i8 = i9;
            }
            String str9 = l03Var.e;
            if (str9 != null) {
                str7 = str9;
            }
            String str10 = l03Var.f;
            if (str10 != null) {
                str8 = str10;
            }
        }
        l70 l70Var = new l70(list);
        int iA = l70Var.a(str7);
        int iA2 = l70Var.a(str8);
        z44 z44Var = (i8 == -1 && iA == 0 && iA2 == 0) ? z44.d : new z44(i8, iA, iA2);
        fd4 fd4Var = new fd4(new gd4(0, null, -1, 0, 0), Collections.EMPTY_LIST);
        int size2 = arrayList4.size();
        for (int i10 = 0; i10 < size2; i10++) {
            l03 l03Var2 = (l03) arrayList4.get(i10);
            fd4Var.a(0, l03Var2.a, l03Var2.b, l03Var2.d, l70Var.a(l03Var2.e), l70Var.a(l03Var2.f));
        }
        return new bd4(l70Var, z44Var, fd4Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006e A[EDGE_INSN: B:36:0x006e->B:24:0x006e BREAK  A[LOOP:0: B:3:0x0018->B:39:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[LOOP:0: B:3:0x0018->B:39:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final z44 b(v62 v62Var) {
        Object next;
        boolean z;
        Iterator it = ((List) ConcurrentMap.EL.computeIfAbsent(this.a, (String) v62Var.z, new um0(3, this.d))).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            List list = ((gd4) next).b;
            if (list == null) {
                z = true;
                break;
                if (!z) {
                    break;
                }
            } else {
                z = false;
                String str = (String) list.get(0);
                int i = 0;
                for (v62 v62Var2 = (v62) v62Var.f; v62Var2 != null; v62Var2 = (v62) v62Var2.f) {
                    String str2 = (String) v62Var2.z;
                    if (str.equals(str2) || (str2.startsWith(str) && str2.charAt(str.length()) == '.')) {
                        i++;
                        if (i == list.size()) {
                            z = true;
                            break;
                        }
                        str = (String) list.get(i);
                    }
                }
                if (!z) {
                }
            }
        }
        gd4 gd4Var = (gd4) next;
        if (gd4Var == null) {
            return null;
        }
        int i2 = gd4Var.c;
        int i3 = gd4Var.d;
        int i4 = gd4Var.e;
        return (i2 == -1 && i3 == 0 && i4 == 0) ? z44.d : new z44(i2, i3, i4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bd4)) {
            return false;
        }
        bd4 bd4Var = (bd4) obj;
        return this.b.equals(bd4Var.b) && this.c.equals(bd4Var.c) && this.d.equals(bd4Var.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + 31) * 31)) * 31);
    }
}
