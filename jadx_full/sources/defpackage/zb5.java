package defpackage;

import io.sentry.android.core.cache.a;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zb5 implements Cloneable {
    public final dc5 b;
    public dc5 f;

    public zb5(dc5 dc5Var) {
        this.b = dc5Var;
        if (dc5Var.d()) {
            xe.k("Default instance must be immutable.");
            throw null;
        }
        this.f = (dc5) dc5Var.m(4);
    }

    public static void a(int i, List list) {
        int size = list.size() - i;
        StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 26);
        sb.append("Element at index ");
        sb.append(size);
        sb.append(" is null.");
        String string = sb.toString();
        int size2 = list.size();
        while (true) {
            size2--;
            if (size2 < i) {
                throw new NullPointerException(string);
            }
            list.remove(size2);
        }
    }

    public static void b(List list, Iterable iterable) {
        Charset charset = nc5.a;
        iterable.getClass();
        if (iterable instanceof md5) {
            list.addAll((Collection) iterable);
            return;
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size);
            } else if (list instanceof pd5) {
                pd5 pd5Var = (pd5) list;
                int i = pd5Var.z + size;
                int length = pd5Var.f.length;
                if (i > length) {
                    if (length != 0) {
                        while (length < i) {
                            length = qe4.q(length, 3, 2, 1, 10);
                        }
                        pd5Var.f = Arrays.copyOf(pd5Var.f, length);
                    } else {
                        pd5Var.f = new Object[Math.max(i, 10)];
                    }
                }
            }
        }
        int size2 = list.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj : iterable) {
                if (obj == null) {
                    a(size2, list);
                    throw null;
                }
                list.add(obj);
            }
            return;
        }
        List list2 = (List) iterable;
        int size3 = list2.size();
        for (int i2 = 0; i2 < size3; i2++) {
            Object obj2 = list2.get(i2);
            if (obj2 == null) {
                a(size2, list);
                throw null;
            }
            list.add(obj2);
        }
    }

    public final void c() {
        if (this.f.d()) {
            return;
        }
        dc5 dc5Var = (dc5) this.b.m(4);
        od5.c.a(dc5Var.getClass()).c(dc5Var, this.f);
        this.f = dc5Var;
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final zb5 clone() {
        zb5 zb5Var = (zb5) this.b.m(5);
        boolean zD = this.f.d();
        dc5 dc5Var = this.f;
        if (zD) {
            dc5Var.getClass();
            od5.c.a(dc5Var.getClass()).g(dc5Var);
            dc5Var.e();
            dc5Var = this.f;
        }
        zb5Var.f = dc5Var;
        return zb5Var;
    }

    public final dc5 e() {
        boolean zD = this.f.d();
        dc5 dc5Var = this.f;
        if (zD) {
            dc5Var.getClass();
            od5.c.a(dc5Var.getClass()).g(dc5Var);
            dc5Var.e();
            dc5Var = this.f;
        }
        dc5Var.getClass();
        boolean zF = true;
        byte bByteValue = ((Byte) dc5Var.m(1)).byteValue();
        if (bByteValue != 1) {
            if (bByteValue == 0) {
                zF = false;
            } else {
                zF = od5.c.a(dc5Var.getClass()).f(dc5Var);
                dc5Var.m(2);
            }
        }
        if (zF) {
            return dc5Var;
        }
        throw new t80("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final void f(dc5 dc5Var) {
        dc5 dc5Var2 = this.b;
        if (dc5Var2.equals(dc5Var)) {
            return;
        }
        if (!this.f.d()) {
            dc5 dc5Var3 = (dc5) dc5Var2.m(4);
            od5.c.a(dc5Var3.getClass()).c(dc5Var3, this.f);
            this.f = dc5Var3;
        }
        dc5 dc5Var4 = this.f;
        od5.c.a(dc5Var4.getClass()).c(dc5Var4, dc5Var);
    }

    public final void g(byte[] bArr, int i, pb5 pb5Var) throws pc5 {
        if (!this.f.d()) {
            dc5 dc5Var = (dc5) this.b.m(4);
            od5.c.a(dc5Var.getClass()).c(dc5Var, this.f);
            this.f = dc5Var;
        }
        try {
            sd5 sd5VarA = od5.c.a(this.f.getClass());
            dc5 dc5Var2 = this.f;
            za5 za5Var = new za5();
            pb5Var.getClass();
            sd5VarA.i(dc5Var2, bArr, 0, i, za5Var);
        } catch (IndexOutOfBoundsException unused) {
            a.d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        } catch (pc5 e) {
            throw e;
        } catch (IOException e2) {
            zo2.o("Reading from byte array should not throw IOException.", e2);
        }
    }
}
