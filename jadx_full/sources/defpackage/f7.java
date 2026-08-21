package defpackage;

import io.netty.util.internal.StringUtil;
import j$.util.Objects;
import java.util.HashSet;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class f7 {
    public static final HashSet b;
    public static final Pattern c;
    public final String a;

    static {
        HashSet hashSet = new HashSet();
        b = hashSet;
        c = Pattern.compile("\\s");
        hashSet.add('[');
        hashSet.add(']');
        hashSet.add('{');
        hashSet.add('}');
        hashSet.add(Character.valueOf(StringUtil.COMMA));
        hashSet.add('*');
        hashSet.add('&');
    }

    public f7(String str) {
        if (str.isEmpty()) {
            xe.k("Empty anchor.");
            throw null;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (b.contains(Character.valueOf(cCharAt))) {
                throw new e31("Invalid character '" + cCharAt + "' in the anchor: " + str);
            }
        }
        if (c.matcher(str).find()) {
            throw new e31("Anchor may not contain spaces: ".concat(str));
        }
        this.a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f7.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((f7) obj).a);
    }

    public final int hashCode() {
        return Objects.hash(this.a);
    }

    public final String toString() {
        return this.a;
    }
}
