package defpackage;

import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m64 implements l83 {
    public static final k83 c = new k83("urn:ietf:params:xml:ns:carddav", "supported-address-data");
    public static final k83 d = new k83("urn:ietf:params:xml:ns:carddav", "address-data-type");
    public static final k83 e = new k83("urn:ietf:params:xml:ns:caldav", "supported-calendar-data");
    public static final k83 f = new k83("urn:ietf:params:xml:ns:caldav", "calendar-data");
    public static final k83 g = new k83("DAV:", "supported-report-set");
    public static final k83 h = new k83("DAV:", "supported-report");
    public static final k83 i = new k83("DAV:", "report");
    public final /* synthetic */ int a;
    public final LinkedHashSet b;

    public m64(int i2) {
        this.a = i2;
        switch (i2) {
            case 1:
                this.b = new LinkedHashSet();
                break;
            case 2:
                this.b = new LinkedHashSet();
                break;
            default:
                this.b = new LinkedHashSet();
                break;
        }
    }

    public final String toString() {
        switch (this.a) {
        }
        return fw.x(new StringBuilder("["), d70.j0(this.b, ", ", null, null, null, 62), ']');
    }
}
