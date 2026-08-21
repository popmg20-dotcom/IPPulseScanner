package defpackage;

import android.graphics.Rect;
import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yo {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    static {
        new yo(0, 0, 0, 0);
    }

    public yo(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        if (i > i3) {
            e04.f(fw.s(i, i3, "Left must be less than or equal to right, left: ", ", right: "));
            throw null;
        }
        if (i2 <= i4) {
            return;
        }
        e04.f(fw.s(i2, i4, "top must be less than or equal to bottom, top: ", ", bottom: "));
        throw null;
    }

    public final int a() {
        return this.d - this.b;
    }

    public final int b() {
        return this.c - this.a;
    }

    public final Rect c() {
        return new Rect(this.a, this.b, this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!yo.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        yo yoVar = (yo) obj;
        return this.a == yoVar.a && this.b == yoVar.b && this.c == yoVar.c && this.d == yoVar.d;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(yo.class.getSimpleName());
        sb.append(" { [");
        sb.append(this.a);
        sb.append(StringUtil.COMMA);
        sb.append(this.b);
        sb.append(StringUtil.COMMA);
        sb.append(this.c);
        sb.append(StringUtil.COMMA);
        return fw.w("] }", sb, this.d);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public yo(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        rect.getClass();
    }
}
