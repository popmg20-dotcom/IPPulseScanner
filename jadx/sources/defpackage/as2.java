package defpackage;

import j$.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class as2 {
    public static final v62 d = new v62(new dt(8));
    public int a;
    public long b;
    public Integer c;

    public static as2 a(int i, long j) {
        v62 v62Var = d;
        as2 as2Var = (as2) ((ArrayBlockingQueue) v62Var.z).poll();
        if (as2Var == null) {
            return (as2) ((dt) v62Var.f).k(Integer.valueOf(i), Long.valueOf(j));
        }
        as2Var.a = i;
        as2Var.b = j;
        return as2Var;
    }

    public final boolean equals(Object obj) {
        if (obj == null || as2.class != obj.getClass()) {
            return false;
        }
        as2 as2Var = (as2) obj;
        return this.a == as2Var.a && this.b == as2Var.b && Objects.equals(this.c, as2Var.c);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.a), Long.valueOf(this.b), this.c);
    }

    public final String toString() {
        return "NoExtSpanImpl{column=" + this.a + ", style=" + this.b + ", extra=" + this.c + '}';
    }
}
