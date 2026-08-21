package net.i2p.crypto.eddsa.math.bigint;

import java.io.Serializable;
import java.math.BigInteger;
import net.i2p.crypto.eddsa.math.Field;
import net.i2p.crypto.eddsa.math.FieldElement;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class BigIntegerFieldElement extends FieldElement implements Serializable {
    public final BigInteger f;

    public BigIntegerFieldElement(Field field, BigInteger bigInteger) {
        super(field);
        this.f = bigInteger;
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement a(FieldElement fieldElement) {
        BigInteger bigIntegerAdd = this.f.add(((BigIntegerFieldElement) fieldElement).f);
        Field field = this.b;
        return new BigIntegerFieldElement(field, bigIntegerAdd).n(field.z);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement b() {
        BigInteger bigIntegerAdd = this.f.add(BigInteger.ONE);
        Field field = this.b;
        return new BigIntegerFieldElement(field, bigIntegerAdd).n(field.z);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement c(FieldElement fieldElement, int i) {
        return i == 0 ? this : fieldElement;
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement d(FieldElement fieldElement) {
        BigInteger bigIntegerDivide = this.f.divide(((BigIntegerFieldElement) fieldElement).f);
        Field field = this.b;
        return new BigIntegerFieldElement(field, bigIntegerDivide).n(field.z);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement e() {
        Field field = this.b;
        return new BigIntegerFieldElement(field, this.f.modInverse(((BigIntegerFieldElement) field.z).f));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof BigIntegerFieldElement) {
            return this.f.equals(((BigIntegerFieldElement) obj).f);
        }
        return false;
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final boolean f() {
        return !this.f.equals(BigInteger.ZERO);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement g(FieldElement fieldElement) {
        BigInteger bigIntegerMultiply = this.f.multiply(((BigIntegerFieldElement) fieldElement).f);
        Field field = this.b;
        return new BigIntegerFieldElement(field, bigIntegerMultiply).n(field.z);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement h() {
        return this.b.z.l(this);
    }

    public final int hashCode() {
        return this.f.hashCode();
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement i() {
        Field field = this.b;
        FieldElement fieldElement = field.A;
        FieldElement fieldElement2 = field.z;
        return new BigIntegerFieldElement(field, this.f.modPow(((BigIntegerFieldElement) fieldElement).f, ((BigIntegerFieldElement) fieldElement2).f));
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement j() {
        return g(this);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement k() {
        FieldElement fieldElementG = g(this);
        return fieldElementG.a(fieldElementG);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement l(FieldElement fieldElement) {
        BigInteger bigIntegerSubtract = this.f.subtract(((BigIntegerFieldElement) fieldElement).f);
        Field field = this.b;
        return new BigIntegerFieldElement(field, bigIntegerSubtract).n(field.z);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement m() {
        BigInteger bigIntegerSubtract = this.f.subtract(BigInteger.ONE);
        Field field = this.b;
        return new BigIntegerFieldElement(field, bigIntegerSubtract).n(field.z);
    }

    public final BigIntegerFieldElement n(FieldElement fieldElement) {
        return new BigIntegerFieldElement(this.b, this.f.mod(((BigIntegerFieldElement) fieldElement).f));
    }

    public final String toString() {
        return "[BigIntegerFieldElement val=" + this.f + "]";
    }
}
