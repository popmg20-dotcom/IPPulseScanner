package defpackage;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pb2 extends AbstractMap implements Serializable {
    public static final e1 z0 = new e1(15);
    public final ob2 Y;
    public nb2 Z;
    public final boolean f;
    public nb2 y0;
    public ob2 z;
    public int A = 0;
    public int X = 0;
    public final Comparator b = z0;

    public pb2(boolean z) {
        this.f = z;
        this.Y = new ob2(z);
    }

    public final ob2 a(Object obj, boolean z) {
        int iCompareTo;
        ob2 ob2Var;
        ob2 ob2Var2 = this.z;
        e1 e1Var = z0;
        Comparator comparator = this.b;
        if (ob2Var2 != null) {
            Comparable comparable = comparator == e1Var ? (Comparable) obj : null;
            while (true) {
                Object obj2 = ob2Var2.Y;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (iCompareTo == 0) {
                    return ob2Var2;
                }
                ob2 ob2Var3 = iCompareTo < 0 ? ob2Var2.f : ob2Var2.z;
                if (ob2Var3 == null) {
                    break;
                }
                ob2Var2 = ob2Var3;
            }
        } else {
            iCompareTo = 0;
        }
        ob2 ob2Var4 = ob2Var2;
        if (!z) {
            return null;
        }
        ob2 ob2Var5 = this.Y;
        if (ob2Var4 != null) {
            ob2Var = new ob2(this.f, ob2Var4, obj, ob2Var5, ob2Var5.X);
            if (iCompareTo < 0) {
                ob2Var4.f = ob2Var;
            } else {
                ob2Var4.z = ob2Var;
            }
            b(ob2Var4, true);
        } else {
            if (comparator == e1Var && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            ob2Var = new ob2(this.f, ob2Var4, obj, ob2Var5, ob2Var5.X);
            this.z = ob2Var;
        }
        this.A++;
        this.X++;
        return ob2Var;
    }

    public final void b(ob2 ob2Var, boolean z) {
        while (ob2Var != null) {
            ob2 ob2Var2 = ob2Var.f;
            ob2 ob2Var3 = ob2Var.z;
            int i = ob2Var2 != null ? ob2Var2.z0 : 0;
            int i2 = ob2Var3 != null ? ob2Var3.z0 : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                ob2 ob2Var4 = ob2Var3.f;
                ob2 ob2Var5 = ob2Var3.z;
                int i4 = (ob2Var4 != null ? ob2Var4.z0 : 0) - (ob2Var5 != null ? ob2Var5.z0 : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    e(ob2Var);
                } else {
                    f(ob2Var3);
                    e(ob2Var);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                ob2 ob2Var6 = ob2Var2.f;
                ob2 ob2Var7 = ob2Var2.z;
                int i5 = (ob2Var6 != null ? ob2Var6.z0 : 0) - (ob2Var7 != null ? ob2Var7.z0 : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    f(ob2Var);
                } else {
                    e(ob2Var2);
                    f(ob2Var);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                ob2Var.z0 = i + 1;
                if (z) {
                    return;
                }
            } else {
                ob2Var.z0 = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            ob2Var = ob2Var.b;
        }
    }

    public final void c(ob2 ob2Var, boolean z) {
        ob2 ob2Var2;
        ob2 ob2Var3;
        int i;
        if (z) {
            ob2 ob2Var4 = ob2Var.X;
            ob2Var4.A = ob2Var.A;
            ob2Var.A.X = ob2Var4;
        }
        ob2 ob2Var5 = ob2Var.f;
        ob2 ob2Var6 = ob2Var.z;
        ob2 ob2Var7 = ob2Var.b;
        int i2 = 0;
        if (ob2Var5 == null || ob2Var6 == null) {
            if (ob2Var5 != null) {
                d(ob2Var, ob2Var5);
                ob2Var.f = null;
            } else if (ob2Var6 != null) {
                d(ob2Var, ob2Var6);
                ob2Var.z = null;
            } else {
                d(ob2Var, null);
            }
            b(ob2Var7, false);
            this.A--;
            this.X++;
            return;
        }
        if (ob2Var5.z0 > ob2Var6.z0) {
            ob2 ob2Var8 = ob2Var5.z;
            while (true) {
                ob2 ob2Var9 = ob2Var8;
                ob2Var3 = ob2Var5;
                ob2Var5 = ob2Var9;
                if (ob2Var5 == null) {
                    break;
                } else {
                    ob2Var8 = ob2Var5.z;
                }
            }
        } else {
            ob2 ob2Var10 = ob2Var6.f;
            while (true) {
                ob2Var2 = ob2Var6;
                ob2Var6 = ob2Var10;
                if (ob2Var6 == null) {
                    break;
                } else {
                    ob2Var10 = ob2Var6.f;
                }
            }
            ob2Var3 = ob2Var2;
        }
        c(ob2Var3, false);
        ob2 ob2Var11 = ob2Var.f;
        if (ob2Var11 != null) {
            i = ob2Var11.z0;
            ob2Var3.f = ob2Var11;
            ob2Var11.b = ob2Var3;
            ob2Var.f = null;
        } else {
            i = 0;
        }
        ob2 ob2Var12 = ob2Var.z;
        if (ob2Var12 != null) {
            i2 = ob2Var12.z0;
            ob2Var3.z = ob2Var12;
            ob2Var12.b = ob2Var3;
            ob2Var.z = null;
        }
        ob2Var3.z0 = Math.max(i, i2) + 1;
        d(ob2Var, ob2Var3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.z = null;
        this.A = 0;
        this.X++;
        ob2 ob2Var = this.Y;
        ob2Var.X = ob2Var;
        ob2Var.A = ob2Var;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        ob2 ob2VarA = null;
        if (obj != null) {
            try {
                ob2VarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return ob2VarA != null;
    }

    public final void d(ob2 ob2Var, ob2 ob2Var2) {
        ob2 ob2Var3 = ob2Var.b;
        ob2Var.b = null;
        if (ob2Var2 != null) {
            ob2Var2.b = ob2Var3;
        }
        if (ob2Var3 == null) {
            this.z = ob2Var2;
        } else if (ob2Var3.f == ob2Var) {
            ob2Var3.f = ob2Var2;
        } else {
            ob2Var3.z = ob2Var2;
        }
    }

    public final void e(ob2 ob2Var) {
        ob2 ob2Var2 = ob2Var.f;
        ob2 ob2Var3 = ob2Var.z;
        ob2 ob2Var4 = ob2Var3.f;
        ob2 ob2Var5 = ob2Var3.z;
        ob2Var.z = ob2Var4;
        if (ob2Var4 != null) {
            ob2Var4.b = ob2Var;
        }
        d(ob2Var, ob2Var3);
        ob2Var3.f = ob2Var;
        ob2Var.b = ob2Var3;
        int iMax = Math.max(ob2Var2 != null ? ob2Var2.z0 : 0, ob2Var4 != null ? ob2Var4.z0 : 0) + 1;
        ob2Var.z0 = iMax;
        ob2Var3.z0 = Math.max(iMax, ob2Var5 != null ? ob2Var5.z0 : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        nb2 nb2Var = this.Z;
        if (nb2Var != null) {
            return nb2Var;
        }
        nb2 nb2Var2 = new nb2(this, 0);
        this.Z = nb2Var2;
        return nb2Var2;
    }

    public final void f(ob2 ob2Var) {
        ob2 ob2Var2 = ob2Var.f;
        ob2 ob2Var3 = ob2Var.z;
        ob2 ob2Var4 = ob2Var2.f;
        ob2 ob2Var5 = ob2Var2.z;
        ob2Var.f = ob2Var5;
        if (ob2Var5 != null) {
            ob2Var5.b = ob2Var;
        }
        d(ob2Var, ob2Var2);
        ob2Var2.z = ob2Var;
        ob2Var.b = ob2Var2;
        int iMax = Math.max(ob2Var3 != null ? ob2Var3.z0 : 0, ob2Var5 != null ? ob2Var5.z0 : 0) + 1;
        ob2Var.z0 = iMax;
        ob2Var2.z0 = Math.max(iMax, ob2Var4 != null ? ob2Var4.z0 : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        ob2 ob2VarA;
        if (obj != null) {
            try {
                ob2VarA = a(obj, false);
            } catch (ClassCastException unused) {
                ob2VarA = null;
            }
        } else {
            ob2VarA = null;
        }
        if (ob2VarA != null) {
            return ob2VarA.y0;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        nb2 nb2Var = this.y0;
        if (nb2Var != null) {
            return nb2Var;
        }
        nb2 nb2Var2 = new nb2(this, 1);
        this.y0 = nb2Var2;
        return nb2Var2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            zo2.n("key == null");
            return null;
        }
        if (obj2 == null && !this.f) {
            zo2.n("value == null");
            return null;
        }
        ob2 ob2VarA = a(obj, true);
        Object obj3 = ob2VarA.y0;
        ob2VarA.y0 = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        ob2 ob2VarA;
        if (obj != null) {
            try {
                ob2VarA = a(obj, false);
            } catch (ClassCastException unused) {
                ob2VarA = null;
            }
        } else {
            ob2VarA = null;
        }
        if (ob2VarA != null) {
            c(ob2VarA, true);
        }
        if (ob2VarA != null) {
            return ob2VarA.y0;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.A;
    }
}
