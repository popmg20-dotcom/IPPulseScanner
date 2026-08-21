package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class oa4 {
    public static final oa4 b = new oa4("tag:yaml.org,2002:merge");
    public static final oa4 c = new oa4("tag:yaml.org,2002:set");
    public static final oa4 d = new oa4("tag:yaml.org,2002:binary");
    public static final oa4 e = new oa4("tag:yaml.org,2002:int");
    public static final oa4 f = new oa4("tag:yaml.org,2002:float");
    public static final oa4 g = new oa4("tag:yaml.org,2002:bool");
    public static final oa4 h = new oa4("tag:yaml.org,2002:null");
    public static final oa4 i = new oa4("tag:yaml.org,2002:str");
    public static final oa4 j = new oa4("tag:yaml.org,2002:seq");
    public static final oa4 k = new oa4("tag:yaml.org,2002:map");
    public static final oa4 l = new oa4("tag:yaml.org,2002:comment");
    public static final oa4 m = new oa4("!ENV_VARIABLE");
    public final String a;

    public oa4(String str) {
        Objects.requireNonNull(str, "Tag must be provided.");
        if (str.isEmpty()) {
            xe.k("Tag must not be empty.");
            throw null;
        }
        if (str.trim().length() == str.length()) {
            this.a = dn4.a(str);
        } else {
            xe.k("Tag must not contain leading or trailing spaces.");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof oa4)) {
            return false;
        }
        return this.a.equals(((oa4) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }

    public oa4(Class cls) {
        this.a = "tag:yaml.org,2002:".concat(dn4.a(cls.getName()));
    }
}
