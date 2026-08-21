package net.i2p.crypto.eddsa.math;

import defpackage.xe;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FieldElement implements Serializable {
    public final Field b;

    public FieldElement(Field field) {
        if (field != null) {
            this.b = field;
        } else {
            xe.k("field cannot be null");
            throw null;
        }
    }

    public abstract FieldElement a(FieldElement fieldElement);

    public FieldElement b() {
        return a(this.b.f);
    }

    public abstract FieldElement c(FieldElement fieldElement, int i);

    public FieldElement d(FieldElement fieldElement) {
        return g(fieldElement.e());
    }

    public abstract FieldElement e();

    public abstract boolean f();

    public abstract FieldElement g(FieldElement fieldElement);

    public abstract FieldElement h();

    public abstract FieldElement i();

    public abstract FieldElement j();

    public abstract FieldElement k();

    public abstract FieldElement l(FieldElement fieldElement);

    public FieldElement m() {
        return l(this.b.f);
    }
}
