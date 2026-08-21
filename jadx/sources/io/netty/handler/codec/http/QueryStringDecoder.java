package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
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
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String decodeComponent(java.lang.String r9, int r10, int r11, java.nio.charset.Charset r12, boolean r13) {
        /*
            int r0 = r11 - r10
            if (r0 > 0) goto L7
            java.lang.String r9 = ""
            return r9
        L7:
            r1 = r10
        L8:
            r2 = 43
            r3 = -1
            r4 = 37
            if (r1 >= r11) goto L1d
            char r5 = r9.charAt(r1)
            if (r5 == r4) goto L1e
            if (r5 != r2) goto L1a
            if (r13 != 0) goto L1a
            goto L1e
        L1a:
            int r1 = r1 + 1
            goto L8
        L1d:
            r1 = r3
        L1e:
            if (r1 != r3) goto L25
            java.lang.String r9 = r9.substring(r10, r11)
            return r9
        L25:
            int r3 = r11 - r1
            int r3 = r3 / 3
            byte[] r3 = io.netty.util.internal.PlatformDependent.allocateUninitializedArray(r3)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r0)
            r5.append(r9, r10, r1)
        L35:
            if (r1 >= r11) goto L8d
            char r10 = r9.charAt(r1)
            if (r10 == r4) goto L48
            if (r10 != r2) goto L44
            if (r13 == 0) goto L42
            goto L44
        L42:
            r10 = 32
        L44:
            r5.append(r10)
            goto L6e
        L48:
            r10 = 0
            r0 = r10
        L4a:
            int r6 = r1 + 3
            if (r6 > r11) goto L71
            int r7 = r0 + 1
            int r8 = r1 + 1
            byte r8 = io.netty.util.internal.StringUtil.decodeHexByte(r9, r8)
            r3[r0] = r8
            if (r6 >= r11) goto L64
            char r0 = r9.charAt(r6)
            if (r0 == r4) goto L61
            goto L64
        L61:
            r1 = r6
            r0 = r7
            goto L4a
        L64:
            int r1 = r1 + 2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3, r10, r7, r12)
            r5.append(r0)
        L6e:
            int r1 = r1 + 1
            goto L35
        L71:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "unterminated escape sequence at index "
            r11.<init>(r12)
            r11.append(r1)
            java.lang.String r12 = " of: "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10.<init>(r9)
            throw r10
        L8d:
            java.lang.String r9 = r5.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.QueryStringDecoder.decodeComponent(java.lang.String, int, int, java.nio.charset.Charset, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
    
        if (r11 != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.Map<java.lang.String, java.util.List<java.lang.String>> decodeParams(java.lang.String r7, int r8, java.nio.charset.Charset r9, int r10, boolean r11) {
        /*
            int r0 = r7.length()
            if (r8 < r0) goto L9
            java.util.Map r7 = java.util.Collections.EMPTY_MAP
            return r7
        L9:
            char r1 = r7.charAt(r8)
            r2 = 63
            if (r1 != r2) goto L13
            int r8 = r8 + 1
        L13:
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>()
            r1 = -1
            r2 = r8
            r4 = r2
            r3 = r1
        L1c:
            if (r4 >= r0) goto L5b
            char r8 = r7.charAt(r4)
            r1 = 35
            if (r8 == r1) goto L5b
            r1 = 38
            if (r8 == r1) goto L46
            r1 = 59
            if (r8 == r1) goto L42
            r1 = 61
            if (r8 == r1) goto L33
            goto L44
        L33:
            if (r2 != r4) goto L3b
            int r8 = r4 + 1
            r1 = r7
            r2 = r8
        L39:
            r6 = r9
            goto L56
        L3b:
            if (r3 >= r2) goto L44
            int r8 = r4 + 1
            r1 = r7
            r3 = r8
            goto L39
        L42:
            if (r11 == 0) goto L46
        L44:
            r1 = r7
            goto L39
        L46:
            r1 = r7
            r6 = r9
            boolean r7 = addParam(r1, r2, r3, r4, r5, r6)
            if (r7 == 0) goto L53
            int r10 = r10 + (-1)
            if (r10 != 0) goto L53
            return r5
        L53:
            int r7 = r4 + 1
            r2 = r7
        L56:
            int r4 = r4 + 1
            r7 = r1
            r9 = r6
            goto L1c
        L5b:
            r1 = r7
            r6 = r9
            addParam(r1, r2, r3, r4, r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.QueryStringDecoder.decodeParams(java.lang.String, int, java.nio.charset.Charset, int, boolean):java.util.Map");
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
