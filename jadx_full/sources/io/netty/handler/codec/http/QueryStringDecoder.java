package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class QueryStringDecoder {
    private static final int DEFAULT_MAX_PARAMS = 1024;
    private final Charset charset;
    private final int maxParams;
    private Map<String, List<String>> params;
    private String path;
    private int pathEndIdx;
    private final boolean semicolonIsNormalChar;
    private final String uri;

    public QueryStringDecoder(URI uri, Charset charset, int i, boolean z) {
        String str;
        String rawPath = uri.getRawPath();
        rawPath = rawPath == null ? "" : rawPath;
        String rawQuery = uri.getRawQuery();
        if (rawQuery == null) {
            str = rawPath;
        } else {
            str = rawPath + '?' + rawQuery;
        }
        this.uri = str;
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
        this.maxParams = ObjectUtil.checkPositive(i, "maxParams");
        this.semicolonIsNormalChar = z;
        this.pathEndIdx = rawPath.length();
    }

    private static boolean addParam(String str, int i, int i2, int i3, Map<String, List<String>> map, Charset charset) {
        if (i >= i3) {
            return false;
        }
        if (i2 <= i) {
            i2 = i3 + 1;
        }
        String strDecodeComponent = decodeComponent(str, i, i2 - 1, charset, false);
        String strDecodeComponent2 = decodeComponent(str, i2, i3, charset, false);
        List<String> arrayList = map.get(strDecodeComponent);
        if (arrayList == null) {
            arrayList = new ArrayList<>(1);
            map.put(strDecodeComponent, arrayList);
        }
        arrayList.add(strDecodeComponent2);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0064, code lost:
    
        r1 = r1 + 2;
        r5.append(new java.lang.String(r3, 0, r7, r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String decodeComponent(String str, int i, int i2, Charset charset, boolean z) {
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        int i4 = i;
        while (true) {
            if (i4 >= i2) {
                i4 = -1;
                break;
            }
            char cCharAt = str.charAt(i4);
            if (cCharAt == '%' || (cCharAt == '+' && !z)) {
                break;
            }
            i4++;
        }
        if (i4 == -1) {
            return str.substring(i, i2);
        }
        byte[] bArrAllocateUninitializedArray = PlatformDependent.allocateUninitializedArray((i2 - i4) / 3);
        StringBuilder sb = new StringBuilder(i3);
        sb.append((CharSequence) str, i, i4);
        while (i4 < i2) {
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 != '%') {
                if (cCharAt2 == '+' && !z) {
                    cCharAt2 = ' ';
                }
                sb.append(cCharAt2);
            } else {
                int i5 = 0;
                while (true) {
                    int i6 = i4 + 3;
                    if (i6 > i2) {
                        throw new IllegalArgumentException("unterminated escape sequence at index " + i4 + " of: " + str);
                    }
                    int i7 = i5 + 1;
                    bArrAllocateUninitializedArray[i5] = StringUtil.decodeHexByte(str, i4 + 1);
                    if (i6 >= i2 || str.charAt(i6) != '%') {
                        break;
                    }
                    i4 = i6;
                    i5 = i7;
                }
            }
            i4++;
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
    
        if (r11 != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Map<String, List<String>> decodeParams(String str, int i, Charset charset, int i2, boolean z) {
        String str2;
        Charset charset2;
        int length = str.length();
        if (i >= length) {
            return Collections.EMPTY_MAP;
        }
        if (str.charAt(i) == '?') {
            i++;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i3 = i;
        int i4 = i3;
        int i5 = -1;
        while (i4 < length) {
            char cCharAt = str.charAt(i4);
            if (cCharAt == '#') {
                break;
            }
            if (cCharAt == '&') {
                str2 = str;
                charset2 = charset;
                if (addParam(str2, i3, i5, i4, linkedHashMap, charset2) && i2 - 1 == 0) {
                    return linkedHashMap;
                }
                i3 = i4 + 1;
            } else {
                if (cCharAt != ';') {
                    if (cCharAt == '=') {
                        if (i3 == i4) {
                            str2 = str;
                            i3 = i4 + 1;
                        } else if (i5 < i3) {
                            str2 = str;
                            i5 = i4 + 1;
                        }
                        charset2 = charset;
                    }
                }
                str2 = str;
                charset2 = charset;
            }
            i4++;
            str = str2;
            charset = charset2;
        }
        addParam(str, i3, i5, i4, linkedHashMap, charset);
        return linkedHashMap;
    }

    private static int findPathEndIndex(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '?' || cCharAt == '#') {
                return i;
            }
        }
        return length;
    }

    private int pathEndIdx() {
        int i = this.pathEndIdx;
        if (i != -1) {
            return i;
        }
        int iFindPathEndIndex = findPathEndIndex(this.uri);
        this.pathEndIdx = iFindPathEndIndex;
        return iFindPathEndIndex;
    }

    public Map<String, List<String>> parameters() {
        Map<String, List<String>> map = this.params;
        if (map != null) {
            return map;
        }
        Map<String, List<String>> mapDecodeParams = decodeParams(this.uri, pathEndIdx(), this.charset, this.maxParams, this.semicolonIsNormalChar);
        this.params = mapDecodeParams;
        return mapDecodeParams;
    }

    public String path() {
        String str = this.path;
        if (str != null) {
            return str;
        }
        String strDecodeComponent = decodeComponent(this.uri, 0, pathEndIdx(), this.charset, true);
        this.path = strDecodeComponent;
        return strDecodeComponent;
    }

    public String rawPath() {
        return this.uri.substring(0, pathEndIdx());
    }

    public String rawQuery() {
        int iPathEndIdx = pathEndIdx() + 1;
        return iPathEndIdx < this.uri.length() ? this.uri.substring(iPathEndIdx) : "";
    }

    public String toString() {
        return uri();
    }

    public String uri() {
        return this.uri;
    }

    public QueryStringDecoder(String str, boolean z) {
        this(str, HttpConstants.DEFAULT_CHARSET, z);
    }

    public QueryStringDecoder(String str, Charset charset) {
        this(str, charset, true);
    }

    public QueryStringDecoder(String str, Charset charset, boolean z) {
        this(str, charset, z, DEFAULT_MAX_PARAMS);
    }

    public QueryStringDecoder(String str, Charset charset, boolean z, int i) {
        this(str, charset, z, i, false);
    }

    public QueryStringDecoder(String str, Charset charset, boolean z, int i, boolean z2) {
        this.uri = (String) ObjectUtil.checkNotNull(str, "uri");
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
        this.maxParams = ObjectUtil.checkPositive(i, "maxParams");
        this.semicolonIsNormalChar = z2;
        this.pathEndIdx = z ? -1 : 0;
    }

    public QueryStringDecoder(URI uri) {
        this(uri, HttpConstants.DEFAULT_CHARSET);
    }

    public QueryStringDecoder(URI uri, Charset charset) {
        this(uri, charset, DEFAULT_MAX_PARAMS);
    }

    public QueryStringDecoder(URI uri, Charset charset, int i) {
        this(uri, charset, i, false);
    }

    public QueryStringDecoder(String str) {
        this(str, HttpConstants.DEFAULT_CHARSET);
    }

    public static String decodeComponent(String str, Charset charset) {
        if (str == null) {
            return "";
        }
        return decodeComponent(str, 0, str.length(), charset, false);
    }

    public static String decodeComponent(String str) {
        return decodeComponent(str, HttpConstants.DEFAULT_CHARSET);
    }
}
