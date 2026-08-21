package defpackage;

import j$.util.Objects;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sz1 extends l34 implements ee0 {
    public static final sz1 X = new sz1(0);
    public static final sz1 Y = new sz1(1);
    public final /* synthetic */ int A;
    public final Boolean z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sz1(int i) {
        this(List.class);
        this.A = i;
        switch (i) {
            case 1:
                this(Collection.class);
                break;
            default:
                break;
        }
    }

    public static void o(List list, i52 i52Var, gt3 gt3Var, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                String str = (String) list.get(i2);
                if (str == null) {
                    gt3Var.h(i52Var);
                } else {
                    i52Var.G0(str);
                }
            } catch (Exception e) {
                l34.m(gt3Var, e, list, i2);
                throw null;
            }
        }
    }

    public static void p(Collection collection, i52 i52Var, gt3 gt3Var) throws IOException {
        int i = 0;
        try {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str == null) {
                    gt3Var.h(i52Var);
                } else {
                    i52Var.G0(str);
                }
                i++;
            }
        } catch (Exception e) {
            l34.m(gt3Var, e, collection, i);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // defpackage.ee0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b72 a(gt3 gt3Var, nm nmVar) {
        b72 b72VarD;
        Object objC;
        if (nmVar != null) {
            cu2 cu2VarD = gt3Var.b.d();
            c9 c9VarA = nmVar.a();
            b72VarD = (c9VarA == null || (objC = cu2VarD.c(c9VarA)) == null) ? null : gt3Var.D(c9VarA, objC);
        }
        e52 e52VarK = l34.k(gt3Var, nmVar, this.b);
        Boolean boolB = e52VarK != null ? e52VarK.b(b52.b) : null;
        b72 b72VarJ = l34.j(gt3Var, nmVar, b72VarD);
        if (b72VarJ == null) {
            b72VarJ = gt3Var.j(String.class, nmVar);
        }
        if (!n50.q(b72VarJ)) {
            return new x60(gt3Var.s().b(null, String.class, rj4.A), true, null, b72VarJ);
        }
        if (Objects.equals(boolB, this.z)) {
            return this;
        }
        switch (this.A) {
            case 0:
                return new sz1(this, boolB, 0);
            default:
                return new sz1(this, boolB, 1);
        }
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        return ((Collection) obj).isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        if (r4 == java.lang.Boolean.TRUE) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        if (r4 == java.lang.Boolean.TRUE) goto L21;
     */
    @Override // defpackage.b72
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) throws IOException {
        int i = this.A;
        Boolean bool = this.z;
        switch (i) {
            case 0:
                List list = (List) obj;
                int size = list.size();
                if (size == 1) {
                    if (bool == null) {
                        if (!gt3Var.b.h(dt3.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) {
                        }
                        o(list, i52Var, gt3Var, 1);
                    }
                }
                i52Var.r0(list);
                o(list, i52Var, gt3Var, size);
                i52Var.I();
                break;
            default:
                Collection collection = (Collection) obj;
                if (collection.size() == 1) {
                    if (bool == null) {
                        if (!gt3Var.b.h(dt3.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) {
                        }
                        p(collection, i52Var, gt3Var);
                    }
                }
                i52Var.r0(collection);
                p(collection, i52Var, gt3Var);
                i52Var.I();
                break;
        }
    }

    @Override // defpackage.b72
    public final void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) throws IOException {
        switch (this.A) {
            case 0:
                List list = (List) obj;
                e10 e10VarE = zj4Var.e(i52Var, zj4Var.d(list, g72.X));
                i52Var.s(list);
                o(list, i52Var, gt3Var, list.size());
                zj4Var.f(i52Var, e10VarE);
                break;
            default:
                Collection collection = (Collection) obj;
                e10 e10VarE2 = zj4Var.e(i52Var, zj4Var.d(collection, g72.X));
                i52Var.s(collection);
                p(collection, i52Var, gt3Var);
                zj4Var.f(i52Var, e10VarE2);
                break;
        }
    }

    public sz1(Class cls) {
        super(cls, 0);
        this.z = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sz1(sz1 sz1Var, Boolean bool, int i) {
        super(sz1Var);
        this.A = i;
        this.z = bool;
    }
}
