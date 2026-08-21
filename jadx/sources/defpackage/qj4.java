package defpackage;

import io.netty.util.internal.StringUtil;
import java.io.Serializable;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qj4 implements Serializable {
    public static final String[] X;
    public static final nj4[] Y;
    public static final qj4 Z;
    public final int A;
    public final String[] b;
    public final nj4[] f;
    public final String[] z;

    static {
        String[] strArr = new String[0];
        X = strArr;
        nj4[] nj4VarArr = new nj4[0];
        Y = nj4VarArr;
        Z = new qj4(strArr, nj4VarArr, null);
    }

    public qj4(String[] strArr, nj4[] nj4VarArr, String[] strArr2) {
        strArr = strArr == null ? X : strArr;
        this.b = strArr;
        nj4VarArr = nj4VarArr == null ? Y : nj4VarArr;
        this.f = nj4VarArr;
        if (strArr.length == nj4VarArr.length) {
            this.z = strArr2;
            this.A = Arrays.hashCode(nj4VarArr);
        } else {
            StringBuilder sb = new StringBuilder("Mismatching names (");
            sb.append(strArr.length);
            sb.append("), types (");
            xe.k(fw.w(")", sb, nj4VarArr.length));
            throw null;
        }
    }

    public static qj4 a(nj4 nj4Var, Class cls) {
        TypeVariable[] typeParameters;
        if (cls == Collection.class) {
            typeParameters = pj4.b;
        } else if (cls == List.class) {
            typeParameters = pj4.d;
        } else if (cls == ArrayList.class) {
            typeParameters = pj4.e;
        } else if (cls == AbstractList.class) {
            typeParameters = pj4.a;
        } else if (cls == Iterable.class) {
            typeParameters = pj4.c;
        } else {
            TypeVariable[] typeVariableArr = pj4.a;
            typeParameters = cls.getTypeParameters();
        }
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 1) {
            return new qj4(new String[]{typeParameters[0].getName()}, new nj4[]{nj4Var}, null);
        }
        e04.e(length, cls.getName(), " with 1 type parameter: class expects ");
        return null;
    }

    public static qj4 b(Class cls, nj4 nj4Var, nj4 nj4Var2) {
        TypeVariable[] typeParameters;
        if (cls == Map.class) {
            typeParameters = pj4.f;
        } else if (cls == HashMap.class) {
            typeParameters = pj4.g;
        } else if (cls == LinkedHashMap.class) {
            typeParameters = pj4.h;
        } else {
            TypeVariable[] typeVariableArr = pj4.a;
            typeParameters = cls.getTypeParameters();
        }
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 2) {
            return new qj4(new String[]{typeParameters[0].getName(), typeParameters[1].getName()}, new nj4[]{nj4Var, nj4Var2}, null);
        }
        e04.e(length, cls.getName(), " with 2 type parameters: class expects ");
        return null;
    }

    public static qj4 c(Class cls, nj4[] nj4VarArr) {
        String[] strArr;
        int length = nj4VarArr.length;
        if (length == 1) {
            return a(nj4VarArr[0], cls);
        }
        if (length == 2) {
            return b(cls, nj4VarArr[0], nj4VarArr[1]);
        }
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length == 0) {
            strArr = X;
        } else {
            int length2 = typeParameters.length;
            strArr = new String[length2];
            for (int i = 0; i < length2; i++) {
                strArr[i] = typeParameters[i].getName();
            }
        }
        if (strArr.length == nj4VarArr.length) {
            return new qj4(strArr, nj4VarArr, null);
        }
        StringBuilder sb = new StringBuilder("Cannot create TypeBindings for class ");
        sb.append(cls.getName());
        sb.append(" with ");
        sb.append(nj4VarArr.length);
        sb.append(" type parameter");
        sb.append(nj4VarArr.length == 1 ? "" : "s");
        sb.append(": class expects ");
        sb.append(strArr.length);
        throw new IllegalArgumentException(sb.toString());
    }

    public final nj4 d(int i) {
        if (i < 0) {
            return null;
        }
        nj4[] nj4VarArr = this.f;
        if (i >= nj4VarArr.length) {
            return null;
        }
        nj4 nj4Var = nj4VarArr[i];
        return nj4Var == null ? rj4.J0 : nj4Var;
    }

    public final List e() {
        nj4[] nj4VarArr = this.f;
        if (nj4VarArr.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List listAsList = Arrays.asList(nj4VarArr);
        if (!listAsList.contains(null)) {
            return listAsList;
        }
        ArrayList arrayList = new ArrayList(listAsList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == null) {
                arrayList.set(i, rj4.J0);
            }
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!n50.n(obj, qj4.class)) {
            return false;
        }
        qj4 qj4Var = (qj4) obj;
        return this.A == qj4Var.A && Arrays.equals(this.f, qj4Var.f);
    }

    public final boolean f() {
        return this.f.length == 0;
    }

    public final int hashCode() {
        return this.A;
    }

    public final String toString() {
        nj4[] nj4VarArr = this.f;
        if (nj4VarArr.length == 0) {
            return "<>";
        }
        StringBuilder sb = new StringBuilder("<");
        int length = nj4VarArr.length;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(StringUtil.COMMA);
            }
            nj4 nj4Var = nj4VarArr[i];
            if (nj4Var == null) {
                sb.append("?");
            } else {
                StringBuilder sb2 = new StringBuilder(40);
                nj4Var.a0(sb2);
                sb.append(sb2.toString());
            }
        }
        sb.append('>');
        return sb.toString();
    }
}
