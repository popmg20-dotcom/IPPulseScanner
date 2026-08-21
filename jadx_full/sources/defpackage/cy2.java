package defpackage;

import j$.util.Collection;
import j$.util.stream.Collectors;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cy2 extends om implements Comparable {
    public static final ue2 C0 = new ue2(1, false);
    public final p83 A;
    public transient o83 A0;
    public transient ue2 B0;
    public final p83 X;
    public ha Y;
    public ha Z;
    public final bt3 f;
    public ha y0;
    public final cu2 z;
    public ha z0;

    public cy2(cy2 cy2Var, p83 p83Var) {
        this.f = cy2Var.f;
        this.z = cy2Var.z;
        this.X = cy2Var.X;
        this.A = p83Var;
        this.Y = cy2Var.Y;
        this.Z = cy2Var.Z;
        this.y0 = cy2Var.y0;
        this.z0 = cy2Var.z0;
    }

    public static boolean p(ha haVar) {
        while (haVar != null) {
            p83 p83Var = (p83) haVar.c;
            if (p83Var != null && !p83Var.b.isEmpty()) {
                return true;
            }
            haVar = (ha) haVar.b;
        }
        return false;
    }

    public static boolean q(ha haVar) {
        p83 p83Var;
        while (haVar != null) {
            if (!haVar.f && (p83Var = (p83) haVar.c) != null && !p83Var.b.isEmpty()) {
                return true;
            }
            haVar = (ha) haVar.b;
        }
        return false;
    }

    public static boolean r(ha haVar) {
        while (haVar != null) {
            if (haVar.f) {
                return true;
            }
            haVar = (ha) haVar.b;
        }
        return false;
    }

    public static boolean s(ha haVar) {
        while (haVar != null) {
            if (haVar.e) {
                return true;
            }
            haVar = (ha) haVar.b;
        }
        return false;
    }

    public static ha t(ha haVar, cp1 cp1Var) {
        c9 c9Var = (c9) ((c9) haVar.g).T(cp1Var);
        ha haVar2 = (ha) haVar.b;
        if (haVar2 != null) {
            haVar = haVar.f(t(haVar2, cp1Var));
        }
        return c9Var == haVar.g ? haVar : new ha(c9Var, (ha) haVar.b, (p83) haVar.c, haVar.d, haVar.e, haVar.f);
    }

    public static Set v(ha haVar, Set set) {
        while (haVar != null) {
            p83 p83Var = (p83) haVar.c;
            if (haVar.d && p83Var != null) {
                if (set == null) {
                    set = new HashSet();
                }
                set.add(p83Var);
            }
            haVar = (ha) haVar.b;
        }
        return set;
    }

    public static cp1 w(ha haVar) {
        cp1 cp1Var = ((c9) haVar.g).C0;
        ha haVar2 = (ha) haVar.b;
        return haVar2 != null ? cp1.Z(cp1Var, w(haVar2)) : cp1Var;
    }

    public static int x(d9 d9Var) {
        String name = d9Var.E0.getName();
        if (!name.startsWith("get") || name.length() <= 3) {
            return (!name.startsWith("is") || name.length() <= 2) ? 3 : 2;
        }
        return 1;
    }

    public static boolean y(ha haVar, p83 p83Var) {
        while (haVar != null) {
            if (haVar.d && p83Var.equals((p83) haVar.c)) {
                return true;
            }
            haVar = (ha) haVar.b;
        }
        return false;
    }

    public static cp1 z(int i, ha... haVarArr) {
        cp1 cp1VarW = w(haVarArr[i]);
        do {
            i++;
            if (i >= haVarArr.length) {
                return cp1VarW;
            }
        } while (haVarArr[i] == null);
        return cp1.Z(cp1VarW, z(i, haVarArr));
    }

    public final d9 A(d9 d9Var, d9 d9Var2) {
        Class<?> declaringClass = d9Var.E0.getDeclaringClass();
        Class<?> declaringClass2 = d9Var2.E0.getDeclaringClass();
        if (declaringClass != declaringClass2) {
            if (!declaringClass.isAssignableFrom(declaringClass2)) {
                if (!declaringClass2.isAssignableFrom(declaringClass)) {
                }
            }
        }
        String name = d9Var2.E0.getName();
        char c = 2;
        char c2 = (!name.startsWith("set") || name.length() <= 3) ? (char) 2 : (char) 1;
        String name2 = d9Var.E0.getName();
        if (name2.startsWith("set") && name2.length() > 3) {
            c = 1;
        }
        if (c2 != c) {
            return c2 < c ? d9Var2 : d9Var;
        }
        cu2 cu2Var = this.z;
        if (cu2Var == null) {
            return null;
        }
        return cu2Var.b0(d9Var, d9Var2);
    }

    public final boolean B() {
        return r(this.Y) || r(this.y0) || r(this.z0) || r(this.Z);
    }

    public final boolean C() {
        return s(this.Y) || s(this.y0) || s(this.z0) || s(this.Z);
    }

    @Override // defpackage.om
    public final boolean a() {
        if (this.Z != null || this.z0 != null) {
            return true;
        }
        ha haVar = this.Y;
        return haVar != null && s(haVar);
    }

    @Override // defpackage.om
    public final t52 b() {
        c9 c9VarE = e();
        cu2 cu2Var = this.z;
        t52 t52VarX = cu2Var == null ? null : cu2Var.x(c9VarE);
        return t52VarX == null ? t52.X : t52VarX;
    }

    @Override // defpackage.om
    public final ue2 c() {
        ha haVar;
        ue2 ue2Var = this.B0;
        ue2 ue2Var2 = C0;
        if (ue2Var != null) {
            if (ue2Var == ue2Var2) {
                return null;
            }
            return ue2Var;
        }
        cu2 cu2Var = this.z;
        if (cu2Var != null) {
            ha haVar2 = this.y0;
            ue2VarB = haVar2 != null ? cu2Var.B((c9) haVar2.g) : null;
            if (ue2VarB == null && (haVar = this.Y) != null) {
                ue2VarB = cu2Var.B((c9) haVar.g);
            }
        }
        if (ue2VarB != null) {
            ue2Var2 = ue2VarB;
        }
        this.B0 = ue2Var2;
        return ue2VarB;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        cy2 cy2Var = (cy2) obj;
        if (this.Z != null) {
            if (cy2Var.Z == null) {
                return -1;
            }
        } else if (cy2Var.Z != null) {
            return 1;
        }
        return getName().compareTo(cy2Var.getName());
    }

    @Override // defpackage.om
    public final Class[] d() {
        ha haVar;
        cu2 cu2Var = this.z;
        if (cu2Var == null) {
            return null;
        }
        ha haVar2 = this.y0;
        Class[] clsArrN = haVar2 != null ? cu2Var.N((c9) haVar2.g) : null;
        return (clsArrN != null || (haVar = this.Y) == null) ? clsArrN : cu2Var.N((c9) haVar.g);
    }

    @Override // defpackage.om
    public final h9 f() {
        ha haVar = this.Z;
        if (haVar == null) {
            return null;
        }
        do {
            h9 h9Var = (h9) haVar.g;
            if (h9Var.D0 instanceof y8) {
                return h9Var;
            }
            haVar = (ha) haVar.b;
        } while (haVar != null);
        return (h9) this.Z.g;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    @Override // defpackage.om
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final a9 g() {
        ha haVar = this.Y;
        if (haVar == null) {
            return null;
        }
        a9 a9Var = (a9) haVar.g;
        for (ha haVar2 = (ha) haVar.b; haVar2 != null; haVar2 = (ha) haVar2.b) {
            a9 a9Var2 = (a9) haVar2.g;
            Class<?> declaringClass = a9Var.D0.getDeclaringClass();
            Class<?> declaringClass2 = a9Var2.D0.getDeclaringClass();
            if (declaringClass == declaringClass2) {
                boolean zIsStatic = Modifier.isStatic(a9Var.p());
                if (zIsStatic == Modifier.isStatic(a9Var2.p())) {
                    a71.i("Multiple fields representing property \"", getName(), "\": ", a9Var.P(), " vs ", a9Var2.P());
                    return null;
                }
                if (zIsStatic) {
                    a9Var = a9Var2;
                }
            } else if (!declaringClass.isAssignableFrom(declaringClass2)) {
                if (declaringClass2.isAssignableFrom(declaringClass)) {
                    continue;
                }
            }
        }
        return a9Var;
    }

    @Override // defpackage.om
    public final String getName() {
        p83 p83Var = this.A;
        if (p83Var == null) {
            return null;
        }
        return p83Var.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
    @Override // defpackage.om
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d9 h() {
        ha haVar = this.y0;
        if (haVar == null) {
            return null;
        }
        ha haVar2 = (ha) haVar.b;
        if (haVar2 == null) {
            return (d9) haVar.g;
        }
        while (true) {
            Object obj = haVar.g;
            if (haVar2 == null) {
                this.y0 = haVar.h();
                return (d9) obj;
            }
            Object obj2 = haVar2.g;
            d9 d9Var = (d9) obj;
            Class<?> declaringClass = d9Var.E0.getDeclaringClass();
            d9 d9Var2 = (d9) obj2;
            Class<?> declaringClass2 = d9Var2.E0.getDeclaringClass();
            if (declaringClass == declaringClass2) {
                int iX = x(d9Var2);
                int iX2 = x(d9Var);
                if (iX == iX2) {
                    a71.i("Conflicting getter definitions for property \"", getName(), "\": ", d9Var.P(), " vs ", d9Var2.P());
                    return null;
                }
                if (iX < iX2) {
                    haVar = haVar2;
                }
            } else if (!declaringClass.isAssignableFrom(declaringClass2)) {
                if (declaringClass2.isAssignableFrom(declaringClass)) {
                    continue;
                }
            }
            haVar2 = (ha) haVar2.b;
        }
    }

    @Override // defpackage.om
    public final o83 i() {
        c9 c9Var;
        o83 o83Var = this.A0;
        if (o83Var == null) {
            ha haVar = this.y0;
            if (haVar != null) {
                c9Var = (c9) haVar.g;
            } else {
                ha haVar2 = this.Y;
                c9Var = haVar2 != null ? (c9) haVar2.g : null;
            }
            if (c9Var == null) {
                o83 o83Var2 = o83.y0;
                this.A0 = o83Var2;
                return o83Var2;
            }
            cu2 cu2Var = this.z;
            Boolean boolV = cu2Var.V(c9Var);
            String strU = cu2Var.u(c9Var);
            Integer numZ = cu2Var.z(c9Var);
            String strT = cu2Var.t(c9Var);
            if (boolV == null && numZ == null && strT == null) {
                o83 o83Var3 = o83.y0;
                if (strU != null) {
                    o83Var3 = new o83(o83Var3.b, strU, o83Var3.f, o83Var3.z, null, o83Var3.A, o83Var3.X);
                }
                this.A0 = o83Var3;
                return o83Var3;
            }
            o83 o83Var4 = o83.Y;
            o83Var = (strU == null && numZ == null && strT == null) ? boolV == null ? o83.y0 : boolV.booleanValue() ? o83.Y : o83.Z : new o83(boolV, strU, numZ, strT, null, null, null);
            this.A0 = o83Var;
        }
        return o83Var;
    }

    @Override // defpackage.om
    public final nj4 j() {
        xb5 xb5VarH = h();
        return (xb5VarH == null && (xb5VarH = g()) == null) ? rj4.J0 : xb5VarH.x();
    }

    @Override // defpackage.om
    public final Class k() {
        return j().L0;
    }

    @Override // defpackage.om
    public final d9 l() {
        Object obj;
        ha haVar = this.z0;
        if (haVar == null) {
            return null;
        }
        ha haVar2 = (ha) haVar.b;
        if (haVar2 == null) {
            return (d9) haVar.g;
        }
        while (true) {
            Object obj2 = haVar.g;
            if (haVar2 == null) {
                this.z0 = haVar.h();
                return (d9) obj2;
            }
            ha haVar3 = (ha) haVar2.b;
            Object obj3 = haVar2.g;
            d9 d9VarA = A((d9) obj2, (d9) obj3);
            if (d9VarA != obj2) {
                if (d9VarA != obj3) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(obj2);
                    arrayList.add(obj3);
                    while (true) {
                        obj = haVar.g;
                        if (haVar3 == null) {
                            break;
                        }
                        Object obj4 = haVar3.g;
                        d9 d9VarA2 = A((d9) obj, (d9) obj4);
                        if (d9VarA2 != obj) {
                            if (d9VarA2 == obj4) {
                                arrayList.clear();
                                haVar = haVar3;
                            } else {
                                arrayList.add(obj4);
                            }
                        }
                        haVar3 = (ha) haVar3.b;
                    }
                    if (arrayList.isEmpty()) {
                        this.z0 = haVar.h();
                        return (d9) obj;
                    }
                    xe.k(fw.u("Conflicting setter definitions for property \"", getName(), "\": ", (String) Collection.EL.stream(arrayList).map(new hl(11)).collect(Collectors.joining(" vs "))));
                    return null;
                }
                haVar = haVar2;
            }
            haVar2 = haVar3;
        }
    }

    @Override // defpackage.om
    public final void m() {
        e();
    }

    @Override // defpackage.om
    public final boolean n() {
        if (p(this.Y) || p(this.y0) || p(this.z0)) {
            return true;
        }
        for (ha haVar = this.Z; haVar != null; haVar = (ha) haVar.b) {
            if (((p83) haVar.c) != null && haVar.d) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.om
    public final boolean o() {
        ha haVar;
        cu2 cu2Var = this.z;
        if (cu2Var != null) {
            ha haVar2 = this.y0;
            boolZ = haVar2 != null ? cu2Var.Z((c9) haVar2.g) : null;
            if (boolZ == null && (haVar = this.Y) != null) {
                boolZ = cu2Var.Z((c9) haVar.g);
            }
        }
        return boolZ != null && boolZ.booleanValue();
    }

    public final String toString() {
        return "[Property '" + this.A + "'; ctors: " + this.Z + ", field(s): " + this.Y + ", getter(s): " + this.y0 + ", setter(s): " + this.z0 + "]";
    }

    public final void u(Set set, HashMap map, ha haVar) {
        String strC;
        for (ha haVar2 = haVar; haVar2 != null; haVar2 = (ha) haVar2.b) {
            p83 p83Var = (p83) haVar2.c;
            if (haVar2.d && p83Var != null) {
                cy2 cy2Var = (cy2) map.get(p83Var);
                if (cy2Var == null) {
                    cy2Var = new cy2(this.f, this.z, this.X, p83Var);
                    map.put(p83Var, cy2Var);
                }
                if (haVar == this.Y) {
                    cy2Var.Y = haVar2.f(cy2Var.Y);
                } else if (haVar == this.y0) {
                    cy2Var.y0 = haVar2.f(cy2Var.y0);
                } else if (haVar == this.z0) {
                    cy2Var.z0 = haVar2.f(cy2Var.z0);
                } else {
                    if (haVar != this.Z) {
                        s53.j(this, "Internal error: mismatched accessors, property: ");
                        return;
                    }
                    cy2Var.Z = haVar2.f(cy2Var.Z);
                }
            } else if (haVar2.e) {
                StringBuilder sb = new StringBuilder("Conflicting/ambiguous property name definitions (implicit name ");
                p83 p83Var2 = this.A;
                if (p83Var2 == null) {
                    Annotation[] annotationArr = n50.a;
                    strC = "[null]";
                } else {
                    strC = n50.c(p83Var2.b);
                }
                sb.append(strC);
                sb.append("): found multiple explicit names: ");
                sb.append(set);
                sb.append(", but also implicit accessor: ");
                sb.append(haVar2);
                throw new IllegalStateException(sb.toString());
            }
        }
    }

    public cy2(bt3 bt3Var, cu2 cu2Var, p83 p83Var, p83 p83Var2) {
        this.f = bt3Var;
        this.z = cu2Var;
        this.X = p83Var;
        this.A = p83Var2;
    }
}
