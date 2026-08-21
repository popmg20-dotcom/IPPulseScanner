package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class by2 {
    public final bt3 a;
    public final b10 b;
    public final nj4 c;
    public final w8 d;
    public final ls4 e;
    public final cu2 f;
    public final boolean g;
    public final boolean h;
    public boolean i;
    public LinkedHashMap j;
    public List k;
    public v62 l;
    public LinkedList m;
    public LinkedList n;
    public LinkedList o;
    public LinkedList p;
    public LinkedList q;
    public LinkedList r;
    public LinkedHashMap s;
    public e52 t;

    public by2(bt3 bt3Var, nj4 nj4Var, w8 w8Var, b10 b10Var) {
        ls4 ls4Var;
        this.a = bt3Var;
        this.c = nj4Var;
        this.d = w8Var;
        this.h = n50.s(nj4Var.L0);
        if (bt3Var.f(ah2.USE_ANNOTATIONS)) {
            this.g = true;
            this.f = bt3Var.d();
        } else {
            this.g = false;
            this.f = ns2.b;
        }
        Class cls = nj4Var.L0;
        if (n50.p(cls)) {
            ls4Var = ls4.Z;
        } else {
            long j = bt3Var.b;
            long j2 = zg2.A0;
            long j3 = j & j2;
            r42 r42Var = r42.b;
            ls4 ls4Var2 = ls4.Y;
            if (j3 != j2) {
                boolean zF = bt3Var.f(ah2.AUTO_DETECT_FIELDS);
                r42 r42Var2 = r42.z;
                if (!zF) {
                    r42 r42Var3 = r42.f;
                    ls4Var2 = new ls4(r42Var3, r42Var3, r42Var, r42Var, r42Var2);
                }
                if (!bt3Var.f(ah2.AUTO_DETECT_GETTERS) && ls4Var2.b != r42Var2) {
                    ls4Var2 = new ls4(r42Var2, ls4Var2.f, ls4Var2.z, ls4Var2.A, ls4Var2.X);
                }
                if (!bt3Var.f(ah2.AUTO_DETECT_IS_GETTERS) && ls4Var2.f != r42Var2) {
                    ls4 ls4Var3 = new ls4(ls4Var2.b, r42Var2, ls4Var2.z, ls4Var2.A, ls4Var2.X);
                    r42Var2 = r42Var2;
                    ls4Var2 = ls4Var3;
                }
                if (!bt3Var.f(ah2.AUTO_DETECT_SETTERS) && ls4Var2.z != r42Var2) {
                    r42 r42Var4 = r42Var2;
                    r42Var2 = r42Var4;
                    ls4Var2 = new ls4(ls4Var2.b, ls4Var2.f, r42Var4, ls4Var2.A, ls4Var2.X);
                }
                if (!bt3Var.f(ah2.AUTO_DETECT_CREATORS) && ls4Var2.A != r42Var2) {
                    ls4Var2 = new ls4(ls4Var2.b, ls4Var2.f, ls4Var2.z, r42Var2, ls4Var2.X);
                }
            }
            if (n50.s(cls) && bt3Var.f(ah2.AUTO_DETECT_CREATORS) && ls4Var2.A != r42Var) {
                ls4 ls4Var4 = ls4Var2;
                ls4Var2 = new ls4(ls4Var4.b, ls4Var4.f, ls4Var4.z, r42Var, ls4Var4.X);
            }
            ls4Var = ls4Var2;
        }
        this.e = bt3Var.d().b(w8Var, ls4Var);
        this.b = b10Var;
    }

    public static boolean g(LinkedList linkedList) {
        do {
            c9 c9Var = (c9) linkedList.get(0);
            c9 c9Var2 = (c9) linkedList.get(1);
            if (c9Var instanceof a9) {
                if (!(c9Var2 instanceof d9)) {
                    return false;
                }
                linkedList.remove(0);
            } else {
                if (!(c9Var instanceof d9) || !(c9Var2 instanceof a9)) {
                    return false;
                }
                linkedList.remove(1);
            }
        } while (linkedList.size() > 1);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(defpackage.v62 r10, java.util.List r11, java.util.LinkedHashMap r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.by2.a(v62, java.util.List, java.util.LinkedHashMap, boolean):void");
    }

    public final List c(List list) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i9 i9Var = (i9) it.next();
            arrayList.add(new k23(i9Var, this.g ? this.f.d(this.a, i9Var) : null));
        }
        return arrayList;
    }

    public final void d(u22 u22Var, c9 c9Var) {
        if (u22Var == null) {
            return;
        }
        Object obj = u22Var.b;
        LinkedHashMap linkedHashMap = this.s;
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
            this.s = linkedHashMap;
        }
        c9 c9Var2 = (c9) linkedHashMap.put(obj, c9Var);
        if (c9Var2 == null || c9Var2.getClass() != c9Var.getClass()) {
            return;
        }
        i("Duplicate injectable value with id '%s' (of type %s)", obj, n50.e(obj));
        throw null;
    }

    public final cy2 e(LinkedHashMap linkedHashMap, p83 p83Var) {
        String str = p83Var.b;
        cy2 cy2Var = (cy2) linkedHashMap.get(str);
        if (cy2Var != null) {
            return cy2Var;
        }
        cy2 cy2Var2 = new cy2(this.a, this.f, p83Var, p83Var);
        linkedHashMap.put(str, cy2Var2);
        return cy2Var2;
    }

    public final cy2 f(LinkedHashMap linkedHashMap, String str) {
        cy2 cy2Var = (cy2) linkedHashMap.get(str);
        if (cy2Var != null) {
            return cy2Var;
        }
        cu2 cu2Var = this.f;
        p83 p83VarA = p83.a(str);
        cy2 cy2Var2 = new cy2(this.a, cu2Var, p83VarA, p83VarA);
        linkedHashMap.put(str, cy2Var2);
        return cy2Var2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:335:0x05de, code lost:
    
        if (r2.a(r6) == false) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x05e1, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0611, code lost:
    
        if (r7.B() != false) goto L357;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0670  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x07b7  */
    /* JADX WARN: Removed duplicated region for block: B:740:0x043f A[EDGE_INSN: B:740:0x043f->B:224:0x043f BREAK  A[LOOP:2: B:219:0x0429->B:742:0x0429], SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instruction units count: 3104
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.by2.h():void");
    }

    public final void i(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new IllegalArgumentException("Problem with definition of " + this.d + ": " + str);
    }

    public final String b(String str) {
        return str;
    }
}
