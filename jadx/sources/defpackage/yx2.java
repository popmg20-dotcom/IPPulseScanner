package defpackage;

import io.netty.channel.internal.ChannelUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yx2 implements be3 {
    public static final vk3[] b = new vk3[0];
    public final /* synthetic */ int a;

    public /* synthetic */ yx2(int i) {
        this.a = i;
    }

    public static int b(xk3 xk3Var, xk3 xk3Var2) {
        if (xk3Var == null || xk3Var2 == null) {
            return 0;
        }
        return (int) Math.abs(xk3Var.a - xk3Var2.a);
    }

    public static int c(xk3 xk3Var, xk3 xk3Var2) {
        return (xk3Var == null || xk3Var2 == null) ? ChannelUtils.WRITE_STATUS_SNDBUF_FULL : (int) Math.abs(xk3Var.a - xk3Var2.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x029f, code lost:
    
        r9 = r15.Y();
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02a3, code lost:
    
        if (r9 != null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02a5, code lost:
    
        r32 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02a8, code lost:
    
        if (r25 == 0) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02aa, code lost:
    
        r12 = r25.Y();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02ae, code lost:
    
        if (r12 != null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02b0, code lost:
    
        r32 = r4;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02b3, code lost:
    
        r14 = r9.b;
        r32 = r4;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02b9, code lost:
    
        if (r14 == r12.b) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02bb, code lost:
    
        r4 = r9.c;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02bf, code lost:
    
        if (r4 == r12.c) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02c1, code lost:
    
        r4 = r9.f;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02c5, code lost:
    
        if (r4 == r12.f) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02c7, code lost:
    
        r9 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02ca, code lost:
    
        if (r25 != 0) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02cd, code lost:
    
        r9 = r25.Y();
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02d1, code lost:
    
        if (r9 != 0) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02d4, code lost:
    
        r4 = defpackage.ay2.a(r15);
        r12 = defpackage.ay2.a(r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02dc, code lost:
    
        if (r4 != null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02de, code lost:
    
        r20 = r8;
        r4 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02e2, code lost:
    
        if (r12 != null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02e4, code lost:
    
        r20 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02e7, code lost:
    
        r20 = r8;
        r4 = new defpackage.xo(r4.a, r4.b, r4.c, r12.d, r12.e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0304, code lost:
    
        r8 = new defpackage.lw2((defpackage.tj) r9, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0309, code lost:
    
        if (r8 == 0) goto L463;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x030b, code lost:
    
        r4 = r8.b;
        r9 = (defpackage.eg0[]) r8.d;
        r12 = (defpackage.xo) r8.e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0315, code lost:
    
        if (r11 == 0) goto L471;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0317, code lost:
    
        if (r12 == null) goto L472;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x031b, code lost:
    
        if (r12.h < r13) goto L474;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x031f, code lost:
    
        if (r12.i <= r10) goto L473;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0321, code lost:
    
        r7 = r21;
        r8 = r23;
        r9 = r24;
        r13 = r30;
        r4 = r32;
        r11 = 0;
        r21 = r20;
        r20 = r19;
        r15 = r15;
        r25 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0333, code lost:
    
        r8.e = r7;
        r11 = r4 + 1;
        r9[0] = r15;
        r9[r11] = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x033d, code lost:
    
        if (r15 == 0) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x033f, code lost:
    
        r22 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0342, code lost:
    
        r22 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0344, code lost:
    
        r12 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0346, code lost:
    
        if (r12 > r11) goto L476;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0348, code lost:
    
        if (r22 == 0) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x034a, code lost:
    
        r14 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x034c, code lost:
    
        r14 = r11 - r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0350, code lost:
    
        if (r9[r14] == 0) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0352, code lost:
    
        r38 = r0;
        r33 = r12;
        r35 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x035e, code lost:
    
        if (r14 == 0) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0360, code lost:
    
        if (r14 != r11) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0363, code lost:
    
        r15 = new defpackage.eg0(r7);
        r33 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x036b, code lost:
    
        r33 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x036f, code lost:
    
        if (r14 != 0) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0371, code lost:
    
        r12 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0374, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0375, code lost:
    
        r15 = new defpackage.pt0(r7, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0378, code lost:
    
        r9[r14] = r15;
        r12 = r13;
        r35 = r12;
        r25 = r23;
        r26 = r24;
        r13 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0382, code lost:
    
        if (r12 > r10) goto L477;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0384, code lost:
    
        if (r22 == 0) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0386, code lost:
    
        r20 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0388, code lost:
    
        r36 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x038b, code lost:
    
        r20 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x038e, code lost:
    
        r10 = r14 - r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0390, code lost:
    
        if (r10 < 0) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0392, code lost:
    
        r37 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0396, code lost:
    
        if (r10 > (r4 + 1)) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0398, code lost:
    
        r14 = r9[r10];
        r38 = r0;
        r0 = ((defpackage.tj[]) r14.z)[r14.L(r12)];
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03a7, code lost:
    
        r38 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03aa, code lost:
    
        r37 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x03ad, code lost:
    
        r0 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x03af, code lost:
    
        if (r0 == 0) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x03b1, code lost:
    
        if (r22 == 0) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x03b3, code lost:
    
        r0 = r0.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x03b7, code lost:
    
        r0 = r0.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x03bb, code lost:
    
        r0 = r9[r37].K(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x03c1, code lost:
    
        if (r0 == null) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x03c3, code lost:
    
        if (r22 == 0) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x03c5, code lost:
    
        r0 = r0.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x03c9, code lost:
    
        r0 = r0.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x03cc, code lost:
    
        if (r10 < 0) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x03d0, code lost:
    
        if (r10 > (r4 + 1)) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x03d2, code lost:
    
        r0 = r9[r10].K(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x03d8, code lost:
    
        if (r0 == null) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x03da, code lost:
    
        if (r22 == 0) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x03dc, code lost:
    
        r0 = r0.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x03df, code lost:
    
        r0 = r0.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x03e2, code lost:
    
        r10 = r37;
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x03e5, code lost:
    
        r10 = r10 - r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x03e7, code lost:
    
        if (r10 < 0) goto L480;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x03eb, code lost:
    
        if (r10 > (r4 + 1)) goto L478;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x03ed, code lost:
    
        r14 = (defpackage.tj[]) r9[r10].z;
        r21 = r0;
        r0 = r14.length;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x03f9, code lost:
    
        if (r10 >= r0) goto L481;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x03fb, code lost:
    
        r24 = r0;
        r0 = r14[r10];
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x03ff, code lost:
    
        if (r0 == null) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0401, code lost:
    
        r10 = r0.b;
        r0 = r0.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0405, code lost:
    
        if (r22 == 0) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0407, code lost:
    
        r14 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0409, code lost:
    
        r14 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x040a, code lost:
    
        r0 = ((r0 - r10) * (r20 * r21)) + r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0411, code lost:
    
        r10 = r10 + 1;
        r0 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0416, code lost:
    
        r0 = r21 + 1;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x041b, code lost:
    
        r0 = (defpackage.xo) r8.e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x041f, code lost:
    
        if (r22 == 0) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0421, code lost:
    
        r0 = r0.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0424, code lost:
    
        r0 = r0.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0426, code lost:
    
        if (r0 < 0) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x042a, code lost:
    
        if (r0 <= r7.g) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x042e, code lost:
    
        r23 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0432, code lost:
    
        if (r13 != (-1)) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0434, code lost:
    
        r14 = r25;
        r0 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0438, code lost:
    
        r20 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x043b, code lost:
    
        r23 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x043d, code lost:
    
        r10 = defpackage.ay2.c(r19, r7.f, r7.g, r22, r23, r12, r25, r26);
        r14 = r25;
        r0 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x044f, code lost:
    
        if (r10 == null) goto L215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0451, code lost:
    
        r13 = r10.b;
        r20 = r7;
        r7 = r10.c;
        ((defpackage.tj[]) r15.z)[r15.L(r12)] = r10;
        r7 = java.lang.Math.min(r14, r7 - r13);
        r0 = java.lang.Math.max(r0, r7 - r13);
        r25 = r7;
        r13 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0473, code lost:
    
        r26 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0476, code lost:
    
        r25 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0479, code lost:
    
        r12 = r12 + 1;
        r7 = r20;
        r10 = r36;
        r14 = r37;
        r0 = r38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0485, code lost:
    
        r38 = r0;
        r24 = r26;
        r23 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0491, code lost:
    
        r12 = r33 + 1;
        r7 = r7;
        r13 = r35;
        r10 = r10;
        r0 = r38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x049d, code lost:
    
        r38 = r0;
        r0 = (defpackage.tj) r8.c;
        r7 = r0.f;
        r13 = new int[2];
        r13[r17] = r4 + 2;
        r13[0] = r7;
        r10 = (defpackage.uj[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) defpackage.uj.class, r13);
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x04ba, code lost:
    
        if (r12 >= r10.length) goto L482;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x04bc, code lost:
    
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x04bd, code lost:
    
        r14 = r10[r12];
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x04c0, code lost:
    
        if (r13 >= r14.length) goto L483;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x04c2, code lost:
    
        r14[r13] = new defpackage.uj();
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x04cc, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x04cf, code lost:
    
        r18 = 0;
        r8.b(r9[0]);
        r8.b(r9[r11]);
        r12 = 928;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x04dd, code lost:
    
        r13 = r9[r18];
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x04df, code lost:
    
        if (r13 == 0) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x04e1, code lost:
    
        r14 = r9[r11];
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x04e3, code lost:
    
        if (r14 != 0) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x04e8, code lost:
    
        r13 = (defpackage.tj[]) r13.z;
        r14 = (defpackage.tj[]) r14.z;
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x04f2, code lost:
    
        if (r15 >= r13.length) goto L486;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x04f4, code lost:
    
        r8 = r13[r15];
        r20 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x04f8, code lost:
    
        if (r8 == null) goto L487;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x04fa, code lost:
    
        r13 = r14[r15];
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x04fc, code lost:
    
        if (r13 == null) goto L488;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0502, code lost:
    
        if (r8.f != r13.f) goto L489;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0504, code lost:
    
        r8 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0506, code lost:
    
        if (r8 > r4) goto L490;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0508, code lost:
    
        r13 = ((defpackage.tj[]) r9[r8].z)[r15];
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0510, code lost:
    
        if (r13 != null) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0512, code lost:
    
        r21 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0515, code lost:
    
        r21 = r8;
        r8 = r20[r15].f;
        r13.f = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0521, code lost:
    
        if (r13.b(r8) != false) goto L493;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0523, code lost:
    
        ((defpackage.tj[]) r9[r21].z)[r15] = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x052b, code lost:
    
        r8 = r21 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x052e, code lost:
    
        r15 = r15 + 1;
        r13 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0533, code lost:
    
        r8 = r9[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0535, code lost:
    
        if (r8 != 0) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0537, code lost:
    
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0539, code lost:
    
        r8 = (defpackage.tj[]) r8.z;
        r13 = 0;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0540, code lost:
    
        if (r13 >= r8.length) goto L526;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0542, code lost:
    
        r15 = r8[r13];
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0544, code lost:
    
        if (r15 != null) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0546, code lost:
    
        r20 = r8;
        r21 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x054b, code lost:
    
        r15 = r15.f;
        r20 = r8;
        r21 = r13;
        r8 = r17;
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0554, code lost:
    
        if (r8 >= r11) goto L528;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0556, code lost:
    
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0559, code lost:
    
        if (r13 >= 2) goto L529;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x055b, code lost:
    
        r8 = ((defpackage.tj[]) r9[r22].z)[r21];
        r23 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0565, code lost:
    
        if (r8 == null) goto L531;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x056d, code lost:
    
        if (r8.b(r8.f) != false) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0573, code lost:
    
        if (r8.b(r15) == false) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0575, code lost:
    
        r8.f = r15;
        r23 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x057a, code lost:
    
        r23 = r23 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0584, code lost:
    
        if (r8.b(r8.f) != false) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0586, code lost:
    
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0588, code lost:
    
        r13 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x058a, code lost:
    
        r8 = r22 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x058d, code lost:
    
        r13 = r21 + 1;
        r8 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x0592, code lost:
    
        r8 = r9[r11];
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0594, code lost:
    
        if (r8 != 0) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0596, code lost:
    
        r20 = r14;
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x059a, code lost:
    
        r8 = (defpackage.tj[]) r8.z;
        r20 = r14;
        r13 = 0;
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x05a3, code lost:
    
        if (r13 >= r8.length) goto L520;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x05a5, code lost:
    
        r14 = r8[r13];
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x05a7, code lost:
    
        if (r14 != null) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x05a9, code lost:
    
        r21 = r8;
        r23 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x05ae, code lost:
    
        r14 = r14.f;
        r21 = r8;
        r22 = r11;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x05b5, code lost:
    
        r23 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x05b7, code lost:
    
        if (r22 <= 0) goto L522;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x05ba, code lost:
    
        if (r8 >= 2) goto L523;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x05bc, code lost:
    
        r13 = ((defpackage.tj[]) r9[r22].z)[r23];
        r24 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x05c6, code lost:
    
        if (r13 == null) goto L525;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x05ce, code lost:
    
        if (r13.b(r13.f) != false) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x05d4, code lost:
    
        if (r13.b(r14) == false) goto L306;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x05d6, code lost:
    
        r13.f = r14;
        r24 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x05db, code lost:
    
        r24 = r24 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x05e5, code lost:
    
        if (r13.b(r13.f) != false) goto L310;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x05e7, code lost:
    
        r15 = r15 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x05e9, code lost:
    
        r8 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x05eb, code lost:
    
        r22 = r22 - 1;
        r13 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x05f0, code lost:
    
        r13 = r23 + 1;
        r8 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x05f5, code lost:
    
        r8 = r20 + r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x05f7, code lost:
    
        if (r8 != 0) goto L317;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x05f9, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x05fa, code lost:
    
        r21 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x05fe, code lost:
    
        r13 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x0600, code lost:
    
        if (r13 >= r11) goto L512;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x0602, code lost:
    
        r14 = (defpackage.tj[]) r9[r13].z;
        r20 = r8;
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x060c, code lost:
    
        if (r15 >= r14.length) goto L513;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x060e, code lost:
    
        r8 = r14[r15];
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0610, code lost:
    
        if (r8 != null) goto L327;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x0612, code lost:
    
        r21 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0614, code lost:
    
        r24 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0616, code lost:
    
        r26 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x061a, code lost:
    
        r21 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x0622, code lost:
    
        if (r8.b(r8.f) != false) goto L325;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x0624, code lost:
    
        r8 = r14[r15];
        r11 = (defpackage.tj[]) r9[r13 - 1].z;
        r11 = r9[r13 + 1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0634, code lost:
    
        if (r11 == 0) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x0636, code lost:
    
        r22 = (defpackage.tj[]) r11.z;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x063d, code lost:
    
        r22 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x063f, code lost:
    
        r24 = r13;
        r13 = new defpackage.tj[14];
        r13[2] = r11[r15];
        r13[r39] = r22[r15];
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x064f, code lost:
    
        if (r15 <= 0) goto L336;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x0651, code lost:
    
        r25 = r15 - 1;
        r13[0] = r14[r25];
        r13[r30] = r11[r25];
        r13[r40] = r22[r25];
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0663, code lost:
    
        if (r15 <= r17) goto L339;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0665, code lost:
    
        r11 = r15 - 2;
        r13[r29] = r14[r11];
        r13[10] = r11[r11];
        r13[11] = r22[r11];
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x067c, code lost:
    
        if (r15 >= (r14.length - 1)) goto L342;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x067e, code lost:
    
        r11 = r15 + 1;
        r13[1] = r14[r11];
        r13[6] = r11[r11];
        r13[7] = r22[r11];
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x0691, code lost:
    
        if (r15 >= (r14.length - 2)) goto L345;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x0693, code lost:
    
        r11 = r15 + 2;
        r13[9] = r14[r11];
        r13[12] = r11[r11];
        r13[13] = r22[r11];
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x06a7, code lost:
    
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x06ac, code lost:
    
        if (r11 >= 14) goto L517;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x06ae, code lost:
    
        r13 = r13[r11];
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x06b0, code lost:
    
        if (r13 != null) goto L352;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x06b2, code lost:
    
        r23 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x06b4, code lost:
    
        r26 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x06b7, code lost:
    
        r23 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x06bf, code lost:
    
        if (r13.b(r13.f) == false) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x06c1, code lost:
    
        r26 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x06c7, code lost:
    
        if (r13.d != r8.d) goto L519;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x06c9, code lost:
    
        r8.f = r13.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x06ce, code lost:
    
        r11 = r23 + 1;
        r14 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x06d3, code lost:
    
        r15 = r15 + 1;
        r11 = r21;
        r13 = r24;
        r14 = r26;
        r17 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x06df, code lost:
    
        r13 = r13 + 1;
        r8 = r20;
        r17 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x06ef, code lost:
    
        if (r8 <= 0) goto L484;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x06f1, code lost:
    
        if (r8 < r12) goto L364;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x06f4, code lost:
    
        r12 = r8;
        r11 = r21;
        r17 = 1;
        r18 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x06fd, code lost:
    
        r8 = r9.length;
        r11 = 0;
        r12 = 0;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x0700, code lost:
    
        if (r11 >= r8) goto L494;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x0702, code lost:
    
        r13 = r9[r11];
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x0704, code lost:
    
        if (r13 == 0) goto L495;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0706, code lost:
    
        r13 = (defpackage.tj[]) r13.z;
        r14 = r13.length;
        r15 = 0;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x070c, code lost:
    
        if (r15 >= r14) goto L496;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x070e, code lost:
    
        r20 = r8;
        r8 = r13[r15];
        r21 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x0714, code lost:
    
        if (r8 == null) goto L379;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x0716, code lost:
    
        r9 = r8.f;
        r22 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x071a, code lost:
    
        if (r9 < 0) goto L498;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x071d, code lost:
    
        if (r9 < r10.length) goto L378;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x0720, code lost:
    
        r10[r9][r12].b(r8.e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x072a, code lost:
    
        r22 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x072c, code lost:
    
        r15 = r15 + 1;
        r8 = r20;
        r9 = r21;
        r11 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x0735, code lost:
    
        r12 = r12 + 1;
        r11 = r11 + 1;
        r8 = r8;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x0744, code lost:
    
        r8 = r10[0][1];
        r9 = r8.a();
        r0 = r0.c;
        r12 = r4 * r7;
        r13 = r12 - (2 << r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x075a, code lost:
    
        if (r9.length != 0) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x075c, code lost:
    
        if (r13 < 1) goto L464;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0760, code lost:
    
        if (r13 > 928) goto L465;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x0762, code lost:
    
        r8.b(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x076a, code lost:
    
        throw defpackage.qs2.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x0771, code lost:
    
        if (r9[0] == r13) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x0773, code lost:
    
        if (r13 < 1) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x0775, code lost:
    
        if (r13 > 928) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x0777, code lost:
    
        r8.b(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x077a, code lost:
    
        r8 = new java.util.ArrayList();
        r9 = new int[r12];
        r11 = new java.util.ArrayList();
        r12 = new java.util.ArrayList();
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x078c, code lost:
    
        if (r13 >= r7) goto L501;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x078e, code lost:
    
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x078f, code lost:
    
        if (r14 >= r4) goto L502;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x0791, code lost:
    
        r19 = r14 + 1;
        r15 = r10[r13][r19].a();
        r20 = (r13 * r4) + r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x07a0, code lost:
    
        if (r15.length != 0) goto L402;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x07a2, code lost:
    
        r8.add(java.lang.Integer.valueOf(r20));
        r21 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x07ac, code lost:
    
        r21 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x07b0, code lost:
    
        if (r15.length != 1) goto L405;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x07b2, code lost:
    
        r9[r20] = r15[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x07b9, code lost:
    
        r12.add(java.lang.Integer.valueOf(r20));
        r11.add(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x07c3, code lost:
    
        r14 = r19;
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x07c8, code lost:
    
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x07cd, code lost:
    
        r4 = r11.size();
        r7 = new int[r4][];
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x07d4, code lost:
    
        if (r10 >= r4) goto L506;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x07d6, code lost:
    
        r7[r10] = (int[]) r11.get(r10);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x07e1, code lost:
    
        r4 = defpackage.vo.N(r8);
        r8 = defpackage.vo.N(r12);
        r10 = r8.length;
        r11 = new int[r10];
        r12 = 100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x07ee, code lost:
    
        r13 = r12 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x07f0, code lost:
    
        if (r12 <= 0) goto L466;
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x07f2, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x07f3, code lost:
    
        if (r12 >= r10) goto L449;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x07f5, code lost:
    
        r9[r8[r12]] = r7[r12][r11[r12]];
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x0802, code lost:
    
        r0 = defpackage.ay2.b(r0, r9, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x0806, code lost:
    
        r12 = r16;
        r4 = new defpackage.vk3(r0.b, r12, r6, defpackage.sj.B0);
        r4.b(r3, r0.d);
        r4.b(r2, r0.e);
        r4.b(defpackage.wk3.X, r0.f);
        r0 = (defpackage.zx2) r0.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x0826, code lost:
    
        if (r0 == null) goto L470;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x0828, code lost:
    
        r4.b(defpackage.wk3.A0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x082d, code lost:
    
        r4.b(defpackage.wk3.b, java.lang.Integer.valueOf(r5.b));
        r4.b(r1, "]L0");
        r14 = r38;
        r14.add(r4);
        r16 = r12;
        r0 = r14;
        r10 = r29;
        r13 = r30;
        r4 = r32;
        r17 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x084f, code lost:
    
        r14 = r38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x0853, code lost:
    
        if (r10 != 0) goto L424;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x0855, code lost:
    
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x0856, code lost:
    
        if (r15 < r10) goto L426;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x0858, code lost:
    
        r12 = r11[r15];
        r19 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x0863, code lost:
    
        if (r12 < (r7[r15].length - 1)) goto L511;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x0865, code lost:
    
        r11[r15] = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x086a, code lost:
    
        r11[r15] = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x0870, code lost:
    
        if (r15 != (r10 - 1)) goto L431;
     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x0872, code lost:
    
        r15 = r15 + 1;
        r0 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x087c, code lost:
    
        throw defpackage.d40.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x087d, code lost:
    
        r19 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x0881, code lost:
    
        r12 = r13;
        r38 = r14;
        r0 = r19;
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x088e, code lost:
    
        throw defpackage.d40.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:439:0x0893, code lost:
    
        throw defpackage.d40.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:441:0x0898, code lost:
    
        throw defpackage.qs2.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x0899, code lost:
    
        r0 = (defpackage.vk3[]) r0.toArray(defpackage.yx2.b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:443:0x08a3, code lost:
    
        if (r0.length == 0) goto L447;
     */
    /* JADX WARN: Code restructure failed: missing block: B:444:0x08a5, code lost:
    
        r6 = r0[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:445:0x08a9, code lost:
    
        if (r6 == null) goto L447;
     */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x08b0, code lost:
    
        throw defpackage.qs2.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:532:?, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b3, code lost:
    
        r4 = ((java.util.ArrayList) r5.c).iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bf, code lost:
    
        if (r4.hasNext() == false) goto L462;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01c1, code lost:
    
        r6 = (defpackage.xk3[]) r4.next();
        r19 = (defpackage.cn) r5.d;
        r7 = r6[r13];
        r22 = r6[r40];
        r21 = r6[6];
        r24 = r6[7];
        r8 = java.lang.Math.min(java.lang.Math.min(c(r6[0], r7), (c(r6[6], r6[2]) * 17) / 18), java.lang.Math.min(c(r6[r17], r6[r40]), (c(r6[7], r6[r39]) * 17) / 18));
        r9 = java.lang.Math.max(java.lang.Math.max(b(r6[0], r6[r13]), (b(r6[6], r6[2]) * 17) / 18), java.lang.Math.max(b(r6[r17], r6[r40]), (b(r6[7], r6[r39]) * 17) / 18));
        r11 = defpackage.ay2.a;
        r20 = r19;
        r21 = r7;
        r7 = r21;
        r29 = r10;
        r15 = r16;
        r25 = r15;
        r11 = r17;
        r12 = new defpackage.xo(r20, r21, r22, r21, r24);
        r15 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x025f, code lost:
    
        r10 = r12.i;
        r30 = r13;
        r13 = r12.h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0265, code lost:
    
        if (r21 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0267, code lost:
    
        r23 = r8;
        r24 = r9;
        r19 = r20;
        r20 = r12;
        r15 = defpackage.ay2.d(r19, r20, r21, true, r23, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0275, code lost:
    
        r8 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0278, code lost:
    
        r23 = r8;
        r24 = r9;
        r19 = r20;
        r20 = r12;
        r15 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0281, code lost:
    
        if (r7 == null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0283, code lost:
    
        r21 = r7;
        r25 = defpackage.ay2.d(r19, r20, r21, false, r23, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x028b, code lost:
    
        r7 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x028e, code lost:
    
        r21 = r7;
        r25 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0291, code lost:
    
        if (r15 != 0) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0293, code lost:
    
        if (r25 != 0) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0295, code lost:
    
        r32 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0297, code lost:
    
        r20 = r8;
        r8 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x029d, code lost:
    
        if (r15 == 0) goto L102;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v101 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36, types: [tj] */
    /* JADX WARN: Type inference failed for: r0v37, types: [eg0] */
    /* JADX WARN: Type inference failed for: r0v57, types: [eg0] */
    /* JADX WARN: Type inference failed for: r11v15, types: [eg0] */
    /* JADX WARN: Type inference failed for: r11v18, types: [eg0] */
    /* JADX WARN: Type inference failed for: r12v26, types: [eg0] */
    /* JADX WARN: Type inference failed for: r12v27, types: [eg0] */
    /* JADX WARN: Type inference failed for: r12v48 */
    /* JADX WARN: Type inference failed for: r12v49, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v50 */
    /* JADX WARN: Type inference failed for: r13v24, types: [eg0] */
    /* JADX WARN: Type inference failed for: r13v47, types: [eg0] */
    /* JADX WARN: Type inference failed for: r13v56, types: [eg0] */
    /* JADX WARN: Type inference failed for: r13v7, types: [eg0] */
    /* JADX WARN: Type inference failed for: r14v16, types: [eg0] */
    /* JADX WARN: Type inference failed for: r14v39, types: [eg0] */
    /* JADX WARN: Type inference failed for: r14v48, types: [eg0] */
    /* JADX WARN: Type inference failed for: r14v61, types: [eg0] */
    /* JADX WARN: Type inference failed for: r15v40 */
    /* JADX WARN: Type inference failed for: r15v52 */
    /* JADX WARN: Type inference failed for: r15v53 */
    /* JADX WARN: Type inference failed for: r15v54 */
    /* JADX WARN: Type inference failed for: r15v55 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8, types: [pt0] */
    /* JADX WARN: Type inference failed for: r21v22 */
    /* JADX WARN: Type inference failed for: r21v23 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v16 */
    /* JADX WARN: Type inference failed for: r22v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v16 */
    /* JADX WARN: Type inference failed for: r25v17 */
    /* JADX WARN: Type inference failed for: r25v18 */
    /* JADX WARN: Type inference failed for: r25v2, types: [pt0] */
    /* JADX WARN: Type inference failed for: r8v12, types: [lw2] */
    /* JADX WARN: Type inference failed for: r8v13, types: [eg0] */
    /* JADX WARN: Type inference failed for: r8v20, types: [eg0] */
    /* JADX WARN: Type inference failed for: r8v27, types: [eg0] */
    /* JADX WARN: Type inference failed for: r8v72, types: [eg0] */
    /* JADX WARN: Type inference failed for: r8v74, types: [tj[]] */
    /* JADX WARN: Type inference failed for: r8v77 */
    /* JADX WARN: Type inference failed for: r8v88 */
    /* JADX WARN: Type inference failed for: r9v11, types: [tj] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v15, types: [eg0[]] */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /* JADX WARN: Type inference failed for: r9v36 */
    /* JADX WARN: Type inference failed for: r9v37 */
    /* JADX WARN: Type inference failed for: r9v38 */
    /* JADX WARN: Type inference failed for: r9v39 */
    @Override // defpackage.be3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.vk3 a(defpackage.lb r40) throws defpackage.qs2, defpackage.d40, defpackage.qi1 {
        /*
            Method dump skipped, instruction units count: 2232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yx2.a(lb):vk3");
    }

    @Override // defpackage.be3
    public final void reset() {
        int i = this.a;
    }

    private final void d() {
    }

    private final void e() {
    }
}
