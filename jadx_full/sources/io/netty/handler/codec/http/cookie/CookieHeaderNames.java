package io.netty.handler.codec.http.cookie;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class CookieHeaderNames {
    public static final String DOMAIN = "Domain";
    public static final String EXPIRES = "Expires";
    public static final String HTTPONLY = "HTTPOnly";
    public static final String MAX_AGE = "Max-Age";
    public static final String PATH = "Path";
    public static final String SAMESITE = "SameSite";
    public static final String SECURE = "Secure";

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public enum SameSite {
        Lax,
        Strict,
        None;

        public static SameSite of(String str) {
            if (str == null) {
                return null;
            }
            for (SameSite sameSite : (SameSite[]) SameSite.class.getEnumConstants()) {
                if (sameSite.name().equalsIgnoreCase(str)) {
                    return sameSite;
                }
            }
            return null;
        }
    }

    private CookieHeaderNames() {
    }
}
