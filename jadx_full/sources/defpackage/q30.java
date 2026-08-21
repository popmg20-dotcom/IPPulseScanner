package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q30 {
    public int a;
    public int b;
    public int c;

    public q30(int i, int i2, int i3) {
        this.a = i3;
        this.b = i;
        this.c = i2;
    }

    public final q30 a() {
        q30 q30Var = new q30();
        q30Var.a = this.a;
        q30Var.b = this.b;
        q30Var.c = this.c;
        return q30Var;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof q30) {
            q30 q30Var = (q30) obj;
            if (q30Var.c == this.c && q30Var.b == this.b && q30Var.a == this.a) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CharPosition(line = ");
        sb.append(this.b);
        sb.append(",column = ");
        sb.append(this.c);
        sb.append(",index = ");
        return fw.w(")", sb, this.a);
    }
}
