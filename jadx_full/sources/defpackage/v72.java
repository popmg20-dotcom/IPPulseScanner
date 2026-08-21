package defpackage;

import j$.util.Objects;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class v72 implements Closeable, Flushable {
    public static final Pattern C0 = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    public static final String[] D0 = new String[128];
    public static final String[] E0;
    public si1 A;
    public String A0;
    public boolean B0;
    public String X;
    public String Y;
    public boolean Z;
    public final Writer b;
    public int[] f;
    public int y0;
    public int z;
    public boolean z0;

    static {
        for (int i = 0; i <= 31; i++) {
            D0[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = D0;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        E0 = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public v72(Writer writer) {
        int[] iArrCopyOf = new int[32];
        this.f = iArrCopyOf;
        this.z = 0;
        if (iArrCopyOf.length == 0) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, 0);
            this.f = iArrCopyOf;
        }
        int i = this.z;
        this.z = i + 1;
        iArrCopyOf[i] = 6;
        this.y0 = 2;
        this.B0 = true;
        Objects.requireNonNull(writer, "out == null");
        this.b = writer;
        I(si1.d);
    }

    public void B0() throws IOException {
        i0();
        g();
        int i = this.z;
        int[] iArrCopyOf = this.f;
        if (i == iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i * 2);
            this.f = iArrCopyOf;
        }
        int i2 = this.z;
        this.z = i2 + 1;
        iArrCopyOf[i2] = 1;
        this.b.write(91);
    }

    public v72 C() {
        if (this.A0 != null) {
            if (!this.B0) {
                this.A0 = null;
                return this;
            }
            i0();
        }
        g();
        this.b.write("null");
        return this;
    }

    public final int F() {
        int i = this.z;
        if (i != 0) {
            return this.f[i - 1];
        }
        xe.q("JsonWriter is closed.");
        return 0;
    }

    public final void I(si1 si1Var) {
        Objects.requireNonNull(si1Var);
        this.A = si1Var;
        this.Y = ",";
        if (si1Var.c) {
            this.X = ": ";
            if (si1Var.a.isEmpty()) {
                this.Y = ", ";
            }
        } else {
            this.X = ":";
        }
        this.Z = this.A.a.isEmpty() && this.A.b.isEmpty();
    }

    public final void M(int i) {
        if (i == 0) {
            throw null;
        }
        this.y0 = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void N(String str) throws IOException {
        String str2;
        String[] strArr = this.z0 ? E0 : D0;
        Writer writer = this.b;
        writer.write(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i < i2) {
                        writer.write(str, i, i2 - i);
                    }
                    writer.write(str2);
                    i = i2 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                }
                writer.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            writer.write(str, i, length - i);
        }
        writer.write(34);
    }

    public void Q(double d) throws IOException {
        i0();
        if (this.y0 == 1 || !(Double.isNaN(d) || Double.isInfinite(d))) {
            g();
            this.b.append((CharSequence) Double.toString(d));
        } else {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
    }

    public void U(long j) throws IOException {
        i0();
        g();
        this.b.write(Long.toString(j));
    }

    public void V() throws IOException {
        n(3, 5, '}');
    }

    public void X(Number number) throws IOException {
        if (number == null) {
            C();
            return;
        }
        i0();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (cls != Integer.class && cls != Long.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class) {
            if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
                if (this.y0 != 1) {
                    xe.k("Numeric values must be finite, but was ".concat(string));
                    return;
                }
            } else if (cls != Float.class && cls != Double.class && !C0.matcher(string).matches()) {
                ad0.k("String created by ", cls, " is not a valid JSON number: ", string);
                return;
            }
        }
        g();
        this.b.append((CharSequence) string);
    }

    public void Z(String str) throws IOException {
        if (str == null) {
            C();
            return;
        }
        i0();
        g();
        N(str);
    }

    public void c0(boolean z) throws IOException {
        i0();
        g();
        this.b.write(z ? "true" : "false");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
        int i = this.z;
        if (i > 1 || (i == 1 && this.f[i - 1] != 7)) {
            vp1.i("Incomplete document");
        } else {
            this.z = 0;
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.z != 0) {
            this.b.flush();
        } else {
            xe.q("JsonWriter is closed.");
        }
    }

    public final void g() throws IOException {
        int iF = F();
        if (iF == 1) {
            this.f[this.z - 1] = 2;
            x();
            return;
        }
        Writer writer = this.b;
        if (iF == 2) {
            writer.append((CharSequence) this.Y);
            x();
            return;
        }
        if (iF == 4) {
            writer.append((CharSequence) this.X);
            this.f[this.z - 1] = 5;
            return;
        }
        if (iF != 6) {
            if (iF != 7) {
                xe.q("Nesting problem.");
                return;
            } else if (this.y0 != 1) {
                xe.q("JSON must have only one top-level value.");
                return;
            }
        }
        this.f[this.z - 1] = 7;
    }

    public final void i0() throws IOException {
        if (this.A0 != null) {
            int iF = F();
            if (iF == 5) {
                this.b.write(this.Y);
            } else if (iF != 3) {
                xe.q("Nesting problem.");
                return;
            }
            x();
            this.f[this.z - 1] = 4;
            N(this.A0);
            this.A0 = null;
        }
    }

    public final void n(int i, int i2, char c) throws IOException {
        int iF = F();
        if (iF != i2 && iF != i) {
            xe.q("Nesting problem.");
            return;
        }
        if (this.A0 != null) {
            zo2.v(this.A0, "Dangling name: ");
            return;
        }
        this.z--;
        if (iF == i2) {
            x();
        }
        this.b.write(c);
    }

    public void p0() throws IOException {
        i0();
        g();
        int i = this.z;
        int[] iArrCopyOf = this.f;
        if (i == iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i * 2);
            this.f = iArrCopyOf;
        }
        int i2 = this.z;
        this.z = i2 + 1;
        iArrCopyOf[i2] = 3;
        this.b.write(123);
    }

    public void s(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.A0 != null) {
            xe.q("Already wrote a name, expecting a value.");
            return;
        }
        int iF = F();
        if (iF == 3 || iF == 5) {
            this.A0 = str;
        } else {
            xe.q("Please begin an object before writing a name.");
        }
    }

    public void w0() throws IOException {
        n(1, 2, ']');
    }

    public final void x() throws IOException {
        if (this.Z) {
            return;
        }
        String str = this.A.a;
        Writer writer = this.b;
        writer.write(str);
        int i = this.z;
        for (int i2 = 1; i2 < i; i2++) {
            writer.write(this.A.b);
        }
    }
}
