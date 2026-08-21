package defpackage;

import j$.util.Objects;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k62 extends y42 {
    public final Serializable b;

    public k62(Boolean bool) {
        Objects.requireNonNull(bool);
        this.b = bool;
    }

    public static boolean g(k62 k62Var) {
        Serializable serializable = k62Var.b;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // defpackage.y42
    public final boolean a() {
        Serializable serializable = this.b;
        return serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(d());
    }

    @Override // defpackage.y42
    public final int b() {
        return this.b instanceof Number ? f().intValue() : Integer.parseInt(d());
    }

    @Override // defpackage.y42
    public final String d() {
        Serializable serializable = this.b;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return f().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public final BigInteger e() {
        Serializable serializable = this.b;
        if (serializable instanceof BigInteger) {
            return (BigInteger) serializable;
        }
        if (g(this)) {
            return BigInteger.valueOf(f().longValue());
        }
        String strD = d();
        fx3.d(strD);
        return new BigInteger(strD);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k62.class != obj.getClass()) {
            return false;
        }
        k62 k62Var = (k62) obj;
        Serializable serializable = k62Var.b;
        boolean zG = g(this);
        Serializable serializable2 = this.b;
        if (zG && g(k62Var)) {
            return ((serializable2 instanceof BigInteger) || (serializable instanceof BigInteger)) ? e().equals(k62Var.e()) : f().longValue() == k62Var.f().longValue();
        }
        if (!(serializable2 instanceof Number) || !(serializable instanceof Number)) {
            return serializable2.equals(serializable);
        }
        if ((serializable2 instanceof BigDecimal) && (serializable instanceof BigDecimal)) {
            return (serializable2 instanceof BigDecimal ? (BigDecimal) serializable2 : fx3.z(d())).compareTo(serializable instanceof BigDecimal ? (BigDecimal) serializable : fx3.z(k62Var.d())) == 0;
        }
        double dDoubleValue = serializable2 instanceof Number ? f().doubleValue() : Double.parseDouble(d());
        double dDoubleValue2 = serializable instanceof Number ? k62Var.f().doubleValue() : Double.parseDouble(k62Var.d());
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public final Number f() {
        Serializable serializable = this.b;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new y82((String) serializable);
        }
        vp1.n("Primitive is neither a number nor a string");
        return null;
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        if (g(this)) {
            jDoubleToLongBits = f().longValue();
        } else {
            Serializable serializable = this.b;
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(f().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public k62(Number number) {
        Objects.requireNonNull(number);
        this.b = number;
    }

    public k62(String str) {
        Objects.requireNonNull(str);
        this.b = str;
    }
}
