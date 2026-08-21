package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d6 implements l83 {
    public static final k83 b = new k83("urn:ietf:params:xml:ns:carddav", "addressbook-description");
    public String a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d6) && n12.c(this.a, ((d6) obj).a);
    }

    public final int hashCode() {
        String str = this.a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return fw.x(new StringBuilder("AddressbookDescription(description="), this.a, ')');
    }
}
