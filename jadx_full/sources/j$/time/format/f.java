package j$.time.format;

import j$.util.Objects;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends h {
    public final boolean g;

    public f(j$.time.temporal.q qVar) {
        this(qVar, 0, 9, true, 0);
        Objects.requireNonNull(qVar, "field");
        j$.time.temporal.u uVarK = qVar.k();
        if (uVarK.a == uVarK.b && uVarK.c == uVarK.d) {
            return;
        }
        j$.time.h.c(j$.time.d.a("Field must have a fixed set of values: ", qVar));
        throw null;
    }

    @Override // j$.time.format.h
    public final boolean a(p pVar) {
        return pVar.c && this.b == this.c && !this.g;
    }

    @Override // j$.time.format.h
    public final h b() {
        if (this.e == -1) {
            return this;
        }
        return new f(this.a, this.b, this.c, this.g, -1);
    }

    @Override // j$.time.format.h
    public final h c(int i) {
        return new f(this.a, this.b, this.c, this.g, this.e + i);
    }

    @Override // j$.time.format.h, j$.time.format.e
    public final boolean h(r rVar, StringBuilder sb) {
        j$.time.temporal.q qVar = this.a;
        Long lA = rVar.a(qVar);
        if (lA == null) {
            return false;
        }
        u uVar = rVar.b.c;
        long jLongValue = lA.longValue();
        j$.time.temporal.u uVarK = qVar.k();
        uVarK.b(jLongValue, qVar);
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(uVarK.a);
        BigDecimal bigDecimalAdd = BigDecimal.valueOf(uVarK.d).subtract(bigDecimalValueOf).add(BigDecimal.ONE);
        BigDecimal bigDecimalSubtract = BigDecimal.valueOf(jLongValue).subtract(bigDecimalValueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal bigDecimalDivide = bigDecimalSubtract.divide(bigDecimalAdd, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (bigDecimalDivide.compareTo(bigDecimal) != 0) {
            bigDecimal = bigDecimalDivide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimalDivide.stripTrailingZeros();
        }
        int iScale = bigDecimal.scale();
        boolean z = this.g;
        int i = this.b;
        if (iScale != 0) {
            String strSubstring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i), this.c), roundingMode).toPlainString().substring(2);
            uVar.getClass();
            if (z) {
                sb.append('.');
            }
            sb.append(strSubstring);
            return true;
        }
        if (i > 0) {
            if (z) {
                uVar.getClass();
                sb.append('.');
            }
            for (int i2 = 0; i2 < i; i2++) {
                uVar.getClass();
                sb.append('0');
            }
        }
        return true;
    }

    @Override // j$.time.format.h, j$.time.format.e
    public final int i(p pVar, CharSequence charSequence, int i) {
        boolean z = pVar.c;
        u uVar = pVar.a.c;
        int i2 = (z || a(pVar)) ? this.b : 0;
        int i3 = (pVar.c || a(pVar)) ? this.c : 9;
        int length = charSequence.length();
        if (i != length) {
            if (this.g) {
                char cCharAt = charSequence.charAt(i);
                uVar.getClass();
                if (cCharAt == '.') {
                    i++;
                } else if (i2 > 0) {
                    return ~i;
                }
            }
            int i4 = i;
            int i5 = i2 + i4;
            if (i5 > length) {
                return ~i4;
            }
            int iMin = Math.min(i3 + i4, length);
            int i6 = 0;
            int i7 = i4;
            while (true) {
                if (i7 >= iMin) {
                    break;
                }
                int i8 = i7 + 1;
                char cCharAt2 = charSequence.charAt(i7);
                uVar.getClass();
                int i9 = cCharAt2 - '0';
                if (i9 < 0 || i9 > 9) {
                    i9 = -1;
                }
                if (i9 >= 0) {
                    i6 = (i6 * 10) + i9;
                    i7 = i8;
                } else if (i8 < i5) {
                    return ~i4;
                }
            }
            BigDecimal bigDecimalMovePointLeft = new BigDecimal(i6).movePointLeft(i7 - i4);
            j$.time.temporal.u uVarK = this.a.k();
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(uVarK.a);
            return pVar.f(this.a, bigDecimalMovePointLeft.multiply(BigDecimal.valueOf(uVarK.d).subtract(bigDecimalValueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(bigDecimalValueOf).longValueExact(), i4, i7);
        }
        if (i2 > 0) {
            return ~i;
        }
        return i;
    }

    @Override // j$.time.format.h
    public final String toString() {
        return "Fraction(" + this.a + "," + this.b + "," + this.c + (this.g ? ",DecimalPoint" : "") + ")";
    }

    public f(j$.time.temporal.q qVar, int i, int i2, boolean z, int i3) {
        super(qVar, i, i2, x.NOT_NEGATIVE, i3);
        this.g = z;
    }
}
