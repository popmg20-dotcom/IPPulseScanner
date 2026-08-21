package defpackage;

import io.netty.util.internal.StringUtil;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class hk0 {
    public static final char[] a = {';', '<', '>', '@', '[', '\\', ']', '_', '`', '~', '!', StringUtil.CARRIAGE_RETURN, '\t', StringUtil.COMMA, ':', '\n', '-', '.', '$', '/', StringUtil.DOUBLE_QUOTE, '|', '*', '(', ')', '?', '{', '}', '\''};
    public static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '&', StringUtil.CARRIAGE_RETURN, '\t', StringUtil.COMMA, ':', '#', '-', '.', '$', '/', '+', '%', '*', '=', '^'};
    public static final BigInteger[] c;

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = c;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(bigIntegerValueOf);
            i++;
        }
    }

    public static String a(int[] iArr, int i) throws qi1 {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(c[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw qi1.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b(int[] r16, int[] r17, int r18, defpackage.ed4 r19, int r20) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hk0.b(int[], int[], int, ed4, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x003e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0007 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(int[] r8, int r9, defpackage.ed4 r10) throws defpackage.qi1 {
        /*
            r0 = 15
            int[] r0 = new int[r0]
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            r4 = r8[r1]
            if (r9 >= r4) goto L4b
            if (r2 != 0) goto L4b
            int r5 = r9 + 1
            r6 = r8[r9]
            r7 = 1
            if (r5 != r4) goto L15
            r2 = r7
        L15:
            r4 = 900(0x384, float:1.261E-42)
            if (r6 >= r4) goto L1f
            r0[r3] = r6
            int r3 = r3 + 1
        L1d:
            r9 = r5
            goto L32
        L1f:
            if (r6 == r4) goto L31
            r4 = 901(0x385, float:1.263E-42)
            if (r6 == r4) goto L31
            r4 = 927(0x39f, float:1.299E-42)
            if (r6 == r4) goto L31
            r4 = 928(0x3a0, float:1.3E-42)
            if (r6 == r4) goto L31
            switch(r6) {
                case 922: goto L31;
                case 923: goto L31;
                case 924: goto L31;
                default: goto L30;
            }
        L30:
            goto L1d
        L31:
            r2 = r7
        L32:
            int r4 = r3 % 15
            if (r4 == 0) goto L3c
            r4 = 902(0x386, float:1.264E-42)
            if (r6 == r4) goto L3c
            if (r2 == 0) goto L7
        L3c:
            if (r3 <= 0) goto L7
            java.lang.String r3 = a(r0, r3)
            java.lang.Object r4 = r10.f
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            r4.append(r3)
            r3 = r1
            goto L7
        L4b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hk0.c(int[], int, ed4):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0036. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0039. Please report as an issue. */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public static int d(int[] r11, int r12, defpackage.ed4 r13) {
        /*
            r0 = 0
            r1 = r11[r0]
            int r1 = r1 - r12
            int r1 = r1 * 2
            int[] r2 = new int[r1]
            int[] r1 = new int[r1]
            r3 = 1
            r4 = r0
            r5 = r4
            r6 = r3
        Le:
            r7 = r11[r0]
            if (r12 >= r7) goto L6d
            if (r4 != 0) goto L6d
            int r7 = r12 + 1
            r8 = r11[r12]
            r9 = 900(0x384, float:1.261E-42)
            if (r8 >= r9) goto L2a
            int r12 = r8 / 30
            r2[r5] = r12
            int r12 = r5 + 1
            int r8 = r8 % 30
            r2[r12] = r8
            int r5 = r5 + 2
        L28:
            r12 = r7
            goto Le
        L2a:
            r10 = 913(0x391, float:1.28E-42)
            if (r8 == r10) goto L62
            r10 = 927(0x39f, float:1.299E-42)
            if (r8 == r10) goto L45
            r10 = 928(0x3a0, float:1.3E-42)
            if (r8 == r10) goto L43
            switch(r8) {
                case 900: goto L3d;
                case 901: goto L43;
                case 902: goto L43;
                default: goto L39;
            }
        L39:
            switch(r8) {
                case 922: goto L43;
                case 923: goto L43;
                case 924: goto L43;
                default: goto L3c;
            }
        L3c:
            goto L28
        L3d:
            int r12 = r5 + 1
            r2[r5] = r9
            r5 = r12
            goto L28
        L43:
            r4 = r3
            goto Le
        L45:
            int r6 = b(r2, r1, r5, r13, r6)
            int r12 = r12 + 2
            r1 = r11[r7]
            r13.k(r1)
            r1 = r11[r0]
            if (r12 > r1) goto L5d
            int r1 = r1 - r12
            int r1 = r1 * 2
            int[] r2 = new int[r1]
            int[] r1 = new int[r1]
            r5 = r0
            goto Le
        L5d:
            qi1 r11 = defpackage.qi1.a()
            throw r11
        L62:
            r2[r5] = r10
            int r12 = r12 + 2
            r7 = r11[r7]
            r1[r5] = r7
            int r5 = r5 + 1
            goto Le
        L6d:
            b(r2, r1, r5, r13, r6)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hk0.d(int[], int, ed4):int");
    }
}
