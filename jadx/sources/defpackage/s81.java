package defpackage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s81 extends v74 implements Function2 {
    public Object A0;
    public Object B0;
    public int C0;
    public int D0;
    public /* synthetic */ Object E0;
    public final /* synthetic */ uh3 F0;
    public final /* synthetic */ String G0;
    public final /* synthetic */ HttpMethod H0;
    public final /* synthetic */ u81 I0;
    public final /* synthetic */ ChannelHandlerContext J0;
    public final /* synthetic */ uh3 K0;
    public final /* synthetic */ FullHttpRequest L0;
    public final /* synthetic */ uh3 M0;
    public final /* synthetic */ uh3 N0;
    public final /* synthetic */ uh3 O0;
    public final /* synthetic */ uh3 P0;
    public final /* synthetic */ uh3 Q0;
    public final /* synthetic */ uh3 R0;
    public final /* synthetic */ uh3 S0;
    public String X;
    public String Y;
    public bh3 Z;
    public Object y0;
    public Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s81(uh3 uh3Var, String str, HttpMethod httpMethod, u81 u81Var, ChannelHandlerContext channelHandlerContext, uh3 uh3Var2, FullHttpRequest fullHttpRequest, uh3 uh3Var3, uh3 uh3Var4, uh3 uh3Var5, uh3 uh3Var6, uh3 uh3Var7, uh3 uh3Var8, uh3 uh3Var9, ge0 ge0Var) {
        super(2, ge0Var);
        this.F0 = uh3Var;
        this.G0 = str;
        this.H0 = httpMethod;
        this.I0 = u81Var;
        this.J0 = channelHandlerContext;
        this.K0 = uh3Var2;
        this.L0 = fullHttpRequest;
        this.M0 = uh3Var3;
        this.N0 = uh3Var4;
        this.O0 = uh3Var5;
        this.P0 = uh3Var6;
        this.Q0 = uh3Var7;
        this.R0 = uh3Var8;
        this.S0 = uh3Var9;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((s81) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        s81 s81Var = new s81(this.F0, this.G0, this.H0, this.I0, this.J0, this.K0, this.L0, this.M0, this.N0, this.O0, this.P0, this.Q0, this.R0, this.S0, ge0Var);
        s81Var.E0 = obj;
        return s81Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:323:0x095b, code lost:
    
        if (defpackage.d73.a(r3, r40) != r13) goto L325;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03f6 A[Catch: all -> 0x003b, Exception -> 0x003e, TryCatch #0 {Exception -> 0x003e, blocks: (B:6:0x0036, B:325:0x095e, B:13:0x0043, B:322:0x0946, B:14:0x0048, B:297:0x0895, B:15:0x004d, B:292:0x0876, B:294:0x087a, B:18:0x0058, B:267:0x07c5, B:21:0x0065, B:264:0x07a9, B:24:0x0082, B:196:0x05a0, B:197:0x05a8, B:199:0x05b2, B:201:0x05ce, B:203:0x05f3, B:205:0x0601, B:207:0x0605, B:208:0x0609, B:211:0x0616, B:27:0x00a1, B:193:0x057b, B:30:0x00c5, B:136:0x03e4, B:137:0x03ec, B:139:0x03f6, B:141:0x0412, B:143:0x0437, B:145:0x0445, B:147:0x0449, B:148:0x044d, B:151:0x045a, B:33:0x00e4, B:132:0x03bc, B:36:0x00ef, B:40:0x010c, B:42:0x0118, B:44:0x0120, B:46:0x0145, B:48:0x0153, B:50:0x0157, B:51:0x015b, B:53:0x0165, B:54:0x0167, B:55:0x017b, B:57:0x0181, B:59:0x01bb, B:61:0x01cb, B:65:0x01da, B:66:0x01e7, B:68:0x01fa, B:71:0x0209, B:73:0x0215, B:75:0x0222, B:77:0x0231, B:79:0x0237, B:81:0x0249, B:83:0x026e, B:85:0x027c, B:87:0x0280, B:89:0x0286, B:92:0x0298, B:95:0x02a6, B:96:0x02ae, B:98:0x02b9, B:101:0x02ca, B:103:0x02d6, B:105:0x02e3, B:107:0x02f2, B:109:0x02f8, B:111:0x030a, B:113:0x032f, B:115:0x033d, B:117:0x0341, B:120:0x0349, B:121:0x0355, B:123:0x0377, B:126:0x037f, B:128:0x038b, B:153:0x0461, B:156:0x0472, B:158:0x047c, B:160:0x04a0, B:163:0x04a8, B:165:0x04b2, B:167:0x04d7, B:169:0x04e5, B:171:0x04e9, B:172:0x04ed, B:174:0x04f3, B:177:0x04fb, B:179:0x0501, B:180:0x050f, B:182:0x0515, B:183:0x0523, B:186:0x0533, B:187:0x053f, B:189:0x054b, B:212:0x061b, B:214:0x0629, B:216:0x0633, B:218:0x063b, B:220:0x0660, B:222:0x066e, B:224:0x0672, B:225:0x0676, B:226:0x0684, B:228:0x0691, B:230:0x069b, B:232:0x06a8, B:234:0x06b7, B:239:0x06c1, B:240:0x06cd, B:242:0x06f4, B:245:0x06fc, B:247:0x071a, B:249:0x073f, B:251:0x074d, B:253:0x0751, B:254:0x0755, B:256:0x075f, B:257:0x076d, B:259:0x0781, B:260:0x078f, B:268:0x07cc, B:270:0x07d9, B:272:0x07e3, B:274:0x07f0, B:276:0x07ff, B:278:0x0805, B:280:0x0819, B:282:0x083e, B:284:0x084c, B:286:0x0850, B:288:0x0856, B:289:0x0864, B:298:0x089c, B:300:0x08a9, B:302:0x08b3, B:304:0x08c0, B:306:0x08cf, B:308:0x08d5, B:310:0x08e9, B:312:0x090e, B:314:0x091c, B:316:0x0920, B:318:0x0926, B:319:0x0934, B:326:0x0965, B:328:0x0972, B:330:0x097c, B:332:0x0989, B:334:0x0998, B:336:0x099e, B:338:0x09b2, B:339:0x09cb, B:341:0x09d9, B:343:0x09dd, B:345:0x09e3, B:346:0x09f1, B:349:0x09ff, B:350:0x0a04, B:351:0x0a0e, B:354:0x0a1d, B:356:0x0a27, B:358:0x0a4d, B:361:0x0a55, B:364:0x0a5d, B:366:0x0a99, B:368:0x0abe, B:370:0x0acc, B:372:0x0ad0, B:373:0x0ad4, B:374:0x0b09, B:375:0x0b19, B:377:0x0b26, B:379:0x0b30, B:381:0x0b3d, B:386:0x0b51, B:387:0x0b5d, B:389:0x0b67, B:390:0x0b77, B:394:0x0b84, B:406:0x0bf2, B:399:0x0bac, B:400:0x0bb4, B:402:0x0bb8, B:405:0x0bbf, B:407:0x0c01, B:408:0x0c11), top: B:422:0x002d, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x05b2 A[Catch: all -> 0x003b, Exception -> 0x003e, TryCatch #0 {Exception -> 0x003e, blocks: (B:6:0x0036, B:325:0x095e, B:13:0x0043, B:322:0x0946, B:14:0x0048, B:297:0x0895, B:15:0x004d, B:292:0x0876, B:294:0x087a, B:18:0x0058, B:267:0x07c5, B:21:0x0065, B:264:0x07a9, B:24:0x0082, B:196:0x05a0, B:197:0x05a8, B:199:0x05b2, B:201:0x05ce, B:203:0x05f3, B:205:0x0601, B:207:0x0605, B:208:0x0609, B:211:0x0616, B:27:0x00a1, B:193:0x057b, B:30:0x00c5, B:136:0x03e4, B:137:0x03ec, B:139:0x03f6, B:141:0x0412, B:143:0x0437, B:145:0x0445, B:147:0x0449, B:148:0x044d, B:151:0x045a, B:33:0x00e4, B:132:0x03bc, B:36:0x00ef, B:40:0x010c, B:42:0x0118, B:44:0x0120, B:46:0x0145, B:48:0x0153, B:50:0x0157, B:51:0x015b, B:53:0x0165, B:54:0x0167, B:55:0x017b, B:57:0x0181, B:59:0x01bb, B:61:0x01cb, B:65:0x01da, B:66:0x01e7, B:68:0x01fa, B:71:0x0209, B:73:0x0215, B:75:0x0222, B:77:0x0231, B:79:0x0237, B:81:0x0249, B:83:0x026e, B:85:0x027c, B:87:0x0280, B:89:0x0286, B:92:0x0298, B:95:0x02a6, B:96:0x02ae, B:98:0x02b9, B:101:0x02ca, B:103:0x02d6, B:105:0x02e3, B:107:0x02f2, B:109:0x02f8, B:111:0x030a, B:113:0x032f, B:115:0x033d, B:117:0x0341, B:120:0x0349, B:121:0x0355, B:123:0x0377, B:126:0x037f, B:128:0x038b, B:153:0x0461, B:156:0x0472, B:158:0x047c, B:160:0x04a0, B:163:0x04a8, B:165:0x04b2, B:167:0x04d7, B:169:0x04e5, B:171:0x04e9, B:172:0x04ed, B:174:0x04f3, B:177:0x04fb, B:179:0x0501, B:180:0x050f, B:182:0x0515, B:183:0x0523, B:186:0x0533, B:187:0x053f, B:189:0x054b, B:212:0x061b, B:214:0x0629, B:216:0x0633, B:218:0x063b, B:220:0x0660, B:222:0x066e, B:224:0x0672, B:225:0x0676, B:226:0x0684, B:228:0x0691, B:230:0x069b, B:232:0x06a8, B:234:0x06b7, B:239:0x06c1, B:240:0x06cd, B:242:0x06f4, B:245:0x06fc, B:247:0x071a, B:249:0x073f, B:251:0x074d, B:253:0x0751, B:254:0x0755, B:256:0x075f, B:257:0x076d, B:259:0x0781, B:260:0x078f, B:268:0x07cc, B:270:0x07d9, B:272:0x07e3, B:274:0x07f0, B:276:0x07ff, B:278:0x0805, B:280:0x0819, B:282:0x083e, B:284:0x084c, B:286:0x0850, B:288:0x0856, B:289:0x0864, B:298:0x089c, B:300:0x08a9, B:302:0x08b3, B:304:0x08c0, B:306:0x08cf, B:308:0x08d5, B:310:0x08e9, B:312:0x090e, B:314:0x091c, B:316:0x0920, B:318:0x0926, B:319:0x0934, B:326:0x0965, B:328:0x0972, B:330:0x097c, B:332:0x0989, B:334:0x0998, B:336:0x099e, B:338:0x09b2, B:339:0x09cb, B:341:0x09d9, B:343:0x09dd, B:345:0x09e3, B:346:0x09f1, B:349:0x09ff, B:350:0x0a04, B:351:0x0a0e, B:354:0x0a1d, B:356:0x0a27, B:358:0x0a4d, B:361:0x0a55, B:364:0x0a5d, B:366:0x0a99, B:368:0x0abe, B:370:0x0acc, B:372:0x0ad0, B:373:0x0ad4, B:374:0x0b09, B:375:0x0b19, B:377:0x0b26, B:379:0x0b30, B:381:0x0b3d, B:386:0x0b51, B:387:0x0b5d, B:389:0x0b67, B:390:0x0b77, B:394:0x0b84, B:406:0x0bf2, B:399:0x0bac, B:400:0x0bb4, B:402:0x0bb8, B:405:0x0bbf, B:407:0x0c01, B:408:0x0c11), top: B:422:0x002d, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x07c3  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x087a A[Catch: all -> 0x003b, Exception -> 0x003e, TryCatch #0 {Exception -> 0x003e, blocks: (B:6:0x0036, B:325:0x095e, B:13:0x0043, B:322:0x0946, B:14:0x0048, B:297:0x0895, B:15:0x004d, B:292:0x0876, B:294:0x087a, B:18:0x0058, B:267:0x07c5, B:21:0x0065, B:264:0x07a9, B:24:0x0082, B:196:0x05a0, B:197:0x05a8, B:199:0x05b2, B:201:0x05ce, B:203:0x05f3, B:205:0x0601, B:207:0x0605, B:208:0x0609, B:211:0x0616, B:27:0x00a1, B:193:0x057b, B:30:0x00c5, B:136:0x03e4, B:137:0x03ec, B:139:0x03f6, B:141:0x0412, B:143:0x0437, B:145:0x0445, B:147:0x0449, B:148:0x044d, B:151:0x045a, B:33:0x00e4, B:132:0x03bc, B:36:0x00ef, B:40:0x010c, B:42:0x0118, B:44:0x0120, B:46:0x0145, B:48:0x0153, B:50:0x0157, B:51:0x015b, B:53:0x0165, B:54:0x0167, B:55:0x017b, B:57:0x0181, B:59:0x01bb, B:61:0x01cb, B:65:0x01da, B:66:0x01e7, B:68:0x01fa, B:71:0x0209, B:73:0x0215, B:75:0x0222, B:77:0x0231, B:79:0x0237, B:81:0x0249, B:83:0x026e, B:85:0x027c, B:87:0x0280, B:89:0x0286, B:92:0x0298, B:95:0x02a6, B:96:0x02ae, B:98:0x02b9, B:101:0x02ca, B:103:0x02d6, B:105:0x02e3, B:107:0x02f2, B:109:0x02f8, B:111:0x030a, B:113:0x032f, B:115:0x033d, B:117:0x0341, B:120:0x0349, B:121:0x0355, B:123:0x0377, B:126:0x037f, B:128:0x038b, B:153:0x0461, B:156:0x0472, B:158:0x047c, B:160:0x04a0, B:163:0x04a8, B:165:0x04b2, B:167:0x04d7, B:169:0x04e5, B:171:0x04e9, B:172:0x04ed, B:174:0x04f3, B:177:0x04fb, B:179:0x0501, B:180:0x050f, B:182:0x0515, B:183:0x0523, B:186:0x0533, B:187:0x053f, B:189:0x054b, B:212:0x061b, B:214:0x0629, B:216:0x0633, B:218:0x063b, B:220:0x0660, B:222:0x066e, B:224:0x0672, B:225:0x0676, B:226:0x0684, B:228:0x0691, B:230:0x069b, B:232:0x06a8, B:234:0x06b7, B:239:0x06c1, B:240:0x06cd, B:242:0x06f4, B:245:0x06fc, B:247:0x071a, B:249:0x073f, B:251:0x074d, B:253:0x0751, B:254:0x0755, B:256:0x075f, B:257:0x076d, B:259:0x0781, B:260:0x078f, B:268:0x07cc, B:270:0x07d9, B:272:0x07e3, B:274:0x07f0, B:276:0x07ff, B:278:0x0805, B:280:0x0819, B:282:0x083e, B:284:0x084c, B:286:0x0850, B:288:0x0856, B:289:0x0864, B:298:0x089c, B:300:0x08a9, B:302:0x08b3, B:304:0x08c0, B:306:0x08cf, B:308:0x08d5, B:310:0x08e9, B:312:0x090e, B:314:0x091c, B:316:0x0920, B:318:0x0926, B:319:0x0934, B:326:0x0965, B:328:0x0972, B:330:0x097c, B:332:0x0989, B:334:0x0998, B:336:0x099e, B:338:0x09b2, B:339:0x09cb, B:341:0x09d9, B:343:0x09dd, B:345:0x09e3, B:346:0x09f1, B:349:0x09ff, B:350:0x0a04, B:351:0x0a0e, B:354:0x0a1d, B:356:0x0a27, B:358:0x0a4d, B:361:0x0a55, B:364:0x0a5d, B:366:0x0a99, B:368:0x0abe, B:370:0x0acc, B:372:0x0ad0, B:373:0x0ad4, B:374:0x0b09, B:375:0x0b19, B:377:0x0b26, B:379:0x0b30, B:381:0x0b3d, B:386:0x0b51, B:387:0x0b5d, B:389:0x0b67, B:390:0x0b77, B:394:0x0b84, B:406:0x0bf2, B:399:0x0bac, B:400:0x0bb4, B:402:0x0bb8, B:405:0x0bbf, B:407:0x0c01, B:408:0x0c11), top: B:422:0x002d, outer: #1 }] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r41) {
        /*
            Method dump skipped, instruction units count: 3230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s81.p(java.lang.Object):java.lang.Object");
    }
}
