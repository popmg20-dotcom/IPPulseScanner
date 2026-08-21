package defpackage;

import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ek3 implements l83 {
    public static final k83 b = new k83("DAV:", "resourcetype");
    public static final k83 c = new k83("DAV:", "collection");
    public static final k83 d = new k83("DAV:", "principal");
    public static final k83 e = new k83("urn:ietf:params:xml:ns:carddav", "addressbook");
    public static final k83 f = new k83("urn:ietf:params:xml:ns:caldav", "calendar");
    public static final k83 g = new k83("http://calendarserver.org/ns/", "subscribed");
    public final LinkedHashSet a = new LinkedHashSet();

    public final String toString() {
        return fw.x(new StringBuilder("["), d70.j0(this.a, ", ", null, null, null, 62), ']');
    }
}
