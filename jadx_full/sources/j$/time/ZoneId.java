package j$.time;

import j$.time.temporal.TemporalAccessor;
import j$.util.Objects;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ZoneId implements Serializable {
    public static final Map a;
    private static final long serialVersionUID = 8352817235686L;

    static {
        Map.Entry[] entryArr = {a.M("ACT", "Australia/Darwin"), a.M("AET", "Australia/Sydney"), a.M("AGT", "America/Argentina/Buenos_Aires"), a.M("ART", "Africa/Cairo"), a.M("AST", "America/Anchorage"), a.M("BET", "America/Sao_Paulo"), a.M("BST", "Asia/Dhaka"), a.M("CAT", "Africa/Harare"), a.M("CNT", "America/St_Johns"), a.M("CST", "America/Chicago"), a.M("CTT", "Asia/Shanghai"), a.M("EAT", "Africa/Addis_Ababa"), a.M("ECT", "Europe/Paris"), a.M("IET", "America/Indiana/Indianapolis"), a.M("IST", "Asia/Kolkata"), a.M("JST", "Asia/Tokyo"), a.M("MIT", "Pacific/Apia"), a.M("NET", "Asia/Yerevan"), a.M("NST", "Pacific/Auckland"), a.M("PLT", "Asia/Karachi"), a.M("PNT", "America/Phoenix"), a.M("PRT", "America/Puerto_Rico"), a.M("PST", "America/Los_Angeles"), a.M("SST", "Pacific/Guadalcanal"), a.M("VST", "Asia/Ho_Chi_Minh"), a.M("EST", "-05:00"), a.M("MST", "-07:00"), a.M("HST", "-10:00")};
        HashMap map = new HashMap(28);
        for (int i = 0; i < 28; i++) {
            Map.Entry entry = entryArr[i];
            Object objRequireNonNull = Objects.requireNonNull(entry.getKey());
            if (map.put(objRequireNonNull, Objects.requireNonNull(entry.getValue())) != null) {
                throw new IllegalArgumentException("duplicate key: " + objRequireNonNull);
            }
        }
        a = Collections.unmodifiableMap(map);
    }

    public ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != y.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static ZoneId A(TemporalAccessor temporalAccessor) {
        ZoneId zoneId = (ZoneId) temporalAccessor.m(j$.time.temporal.r.e);
        if (zoneId != null) {
            return zoneId;
        }
        h.g("Unable to obtain ZoneId from TemporalAccessor: ", temporalAccessor, " of type ", temporalAccessor.getClass().getName());
        return null;
    }

    public static ZoneId D(String str, boolean z) {
        Objects.requireNonNull(str, "zoneId");
        return (str.length() <= 1 || str.startsWith("+") || str.startsWith("-")) ? ZoneOffset.H(str) : (str.startsWith("UTC") || str.startsWith("GMT")) ? F(str, 3, z) : str.startsWith("UT") ? F(str, 2, z) : y.H(str, z);
    }

    public static ZoneId E(String str, ZoneOffset zoneOffset) {
        Objects.requireNonNull(str, "prefix");
        Objects.requireNonNull(zoneOffset, "offset");
        if (str.isEmpty()) {
            return zoneOffset;
        }
        if (!str.equals("GMT") && !str.equals("UTC") && !str.equals("UT")) {
            h.c("prefix should be GMT, UTC or UT, is: ".concat(str));
            return null;
        }
        if (zoneOffset.b != 0) {
            str = str.concat(zoneOffset.c);
        }
        return new y(str, zoneOffset.C());
    }

    public static ZoneId F(String str, int i, boolean z) {
        String strSubstring = str.substring(0, i);
        if (str.length() == i) {
            return E(strSubstring, ZoneOffset.UTC);
        }
        if (str.charAt(i) != '+' && str.charAt(i) != '-') {
            return y.H(str, z);
        }
        try {
            ZoneOffset zoneOffsetH = ZoneOffset.H(str.substring(i));
            return zoneOffsetH == ZoneOffset.UTC ? E(strSubstring, zoneOffsetH) : E(strSubstring, zoneOffsetH);
        } catch (c e) {
            throw new c("Invalid ID for offset-based ZoneId: ".concat(str), e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new t((byte) 7, this);
    }

    public abstract String B();

    public abstract j$.time.zone.f C();

    public abstract void G(DataOutput dataOutput);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return B().equals(((ZoneId) obj).B());
        }
        return false;
    }

    public int hashCode() {
        return B().hashCode();
    }

    public String toString() {
        return B();
    }
}
