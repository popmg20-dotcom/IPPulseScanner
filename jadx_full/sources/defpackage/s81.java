package defpackage;

import android.os.Process;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import java.io.File;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
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
    */
    public final Object p(Object obj) {
        String str;
        int i;
        String str2;
        String str3;
        boolean z;
        String str4;
        t53 t53Var;
        String str5;
        String str6;
        String str7;
        String strDecode;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        Object objB;
        String str13;
        String strD;
        String str14;
        String str15;
        String str16;
        bh3 bh3Var;
        String str17;
        String str18;
        String str19;
        String strD2;
        String str20;
        String str21;
        String strD3;
        Object objN;
        int i2;
        int i3;
        Object obj2;
        ChannelHandlerContext channelHandlerContext;
        String str22;
        String str23;
        u81 u81Var;
        String strDecode2;
        String str24;
        String str25;
        String strD4;
        Object objN2;
        u81 u81Var2;
        e03 e03Var;
        String str26;
        ChannelHandlerContext channelHandlerContext2;
        Object obj3;
        int i4;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        gj gjVar;
        u81 u81Var3;
        String str33;
        Throwable thA;
        String str34;
        String str35;
        ko0 ko0Var;
        Throwable thA2;
        String str36;
        String str37;
        gj gjVar2;
        String str38;
        ke2 ke2Var = ke2.DEBUG;
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        try {
            try {
            } catch (Exception e) {
                e.printStackTrace();
                String str39 = "API Error: " + e.getMessage();
                if (fy4.b) {
                    Xlog.logWrite2(0L, ke2Var.a(), "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str39);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("ExplorerServer", str39, null);
                }
                u81 u81Var4 = this.I0;
                ChannelHandlerContext channelHandlerContext3 = this.J0;
                HttpResponseStatus httpResponseStatus = HttpResponseStatus.INTERNAL_SERVER_ERROR;
                httpResponseStatus.getClass();
                u81Var4.s(channelHandlerContext3, httpResponseStatus, e.getMessage());
            }
            switch (this.D0) {
                case 0:
                    n12.S(obj);
                    uh3 uh3Var = this.F0;
                    String str40 = this.G0;
                    str40.getClass();
                    if (uh3Var.c(str40) != null) {
                        i = 0;
                        str = "API: Copying file: ";
                        if (n12.c(this.H0, HttpMethod.GET)) {
                            if (fy4.b) {
                                Xlog.logWrite2(0L, ke2Var.a(), "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "API: Listing files");
                                str31 = "ExplorerServer";
                                str32 = "API: Listing files";
                            } else {
                                str31 = "ExplorerServer";
                                str32 = "API: Listing files";
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d(str31, str32, null);
                            }
                            Iterable<zk> iterable = (List) d73.b.d();
                            if (iterable == null) {
                                iterable = g41.b;
                            }
                            q42 q42Var = new q42();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                            for (zk zkVar : iterable) {
                                g62 g62Var = new g62();
                                g62Var.g("id", zkVar.getName());
                                g62Var.g("name", zkVar.getName() + ".conf");
                                e1 e1Var = d73.a;
                                File fileG = d73.g(zkVar.getName());
                                g62Var.g("updatedAt", fileG.exists() ? simpleDateFormat.format(new Date(fileG.lastModified())) : "");
                                g62Var.f("editable", Boolean.valueOf(zkVar.j() == null));
                                q42Var.b.add(g62Var);
                            }
                            u81.F(this.J0, this.I0.f.g(q42Var));
                        }
                        return xl4Var;
                    }
                    str = "API: Copying file: ";
                    i = 0;
                    uh3 uh3Var2 = this.K0;
                    String str41 = this.G0;
                    str41.getClass();
                    if (uh3Var2.c(str41) != null) {
                        str2 = "id";
                        if (n12.c(this.H0, HttpMethod.GET)) {
                            uh3 uh3Var3 = this.K0;
                            String str42 = this.G0;
                            str42.getClass();
                            uh2 uh2VarA = uh3.a(uh3Var3, str42);
                            String strDecode3 = (uh2VarA == null || (str30 = (String) ((sh2) uh2VarA.a()).get(1)) == null) ? null : URLDecoder.decode(str30, "UTF-8");
                            String str43 = "API: Getting content for file: " + strDecode3;
                            if (fy4.b) {
                                Xlog.logWrite2(0L, ke2Var.a(), "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str43);
                                str28 = "ExplorerServer";
                                str29 = str43;
                            } else {
                                str28 = "ExplorerServer";
                                str29 = str43;
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d(str28, str29, null);
                            }
                            if (strDecode3 == null) {
                                u81 u81Var5 = this.I0;
                                ChannelHandlerContext channelHandlerContext4 = this.J0;
                                HttpResponseStatus httpResponseStatus2 = HttpResponseStatus.BAD_REQUEST;
                                httpResponseStatus2.getClass();
                                u81Var5.s(channelHandlerContext4, httpResponseStatus2, null);
                            } else {
                                File fileG2 = d73.g(strDecode3);
                                boolean zExists = fileG2.exists();
                                u81 u81Var6 = this.I0;
                                ChannelHandlerContext channelHandlerContext5 = this.J0;
                                if (zExists) {
                                    u81.M(channelHandlerContext5, le1.U(fileG2));
                                } else {
                                    HttpResponseStatus httpResponseStatus3 = HttpResponseStatus.NOT_FOUND;
                                    httpResponseStatus3.getClass();
                                    u81Var6.s(channelHandlerContext5, httpResponseStatus3, null);
                                }
                            }
                        }
                        return xl4Var;
                    }
                    str2 = "id";
                    uh3 uh3Var4 = this.K0;
                    String str44 = this.G0;
                    str44.getClass();
                    if (uh3Var4.c(str44) != null) {
                        str3 = "API: Renaming file: ";
                        if (n12.c(this.H0, HttpMethod.POST)) {
                            uh3 uh3Var5 = this.K0;
                            String str45 = this.G0;
                            str45.getClass();
                            uh2 uh2VarA2 = uh3.a(uh3Var5, str45);
                            strDecode2 = (uh2VarA2 == null || (str27 = (String) ((sh2) uh2VarA2.a()).get(1)) == null) ? null : URLDecoder.decode(str27, "UTF-8");
                            String str46 = "API: Saving content for file: " + strDecode2;
                            if (fy4.b) {
                                Xlog.logWrite2(0L, ke2Var.a(), "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str46);
                                str24 = "ExplorerServer";
                                str25 = str46;
                            } else {
                                str24 = "ExplorerServer";
                                str25 = str46;
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d(str24, str25, null);
                            }
                            u81 u81Var7 = this.I0;
                            if (strDecode2 == null) {
                                ChannelHandlerContext channelHandlerContext6 = this.J0;
                                HttpResponseStatus httpResponseStatus4 = HttpResponseStatus.BAD_REQUEST;
                                httpResponseStatus4.getClass();
                                u81Var7.s(channelHandlerContext6, httpResponseStatus4, null);
                                return xl4Var;
                            }
                            iq1 iq1Var = u81Var7.f;
                            String string = this.L0.content().toString(CharsetUtil.UTF_8);
                            iq1Var.getClass();
                            y42 y42VarH = ((g62) iq1Var.c(string, new bk4(g62.class))).h("content");
                            if (y42VarH == null || (strD4 = y42VarH.d()) == null) {
                                strD4 = "";
                            }
                            objN2 = u81.N(strDecode2, strD4);
                            u81 u81Var8 = this.I0;
                            ChannelHandlerContext channelHandlerContext7 = this.J0;
                            if (!(objN2 instanceof tk3)) {
                                e03 e03Var2 = (e03) objN2;
                                e1 e1Var2 = d73.a;
                                e03[] e03VarArr = new e03[1];
                                e03VarArr[i] = e03Var2;
                                this.E0 = null;
                                this.X = strDecode2;
                                this.Y = null;
                                this.Z = null;
                                this.y0 = objN2;
                                this.z0 = u81Var8;
                                this.A0 = channelHandlerContext7;
                                this.B0 = e03Var2;
                                this.C0 = i;
                                this.D0 = 1;
                                if (d73.j(e03VarArr, this) == mf0Var) {
                                    return mf0Var;
                                }
                                u81Var2 = u81Var8;
                                e03Var = e03Var2;
                                str26 = strDecode2;
                                channelHandlerContext2 = channelHandlerContext7;
                                obj3 = objN2;
                                i4 = 0;
                                e1 e1Var3 = d73.a;
                                gjVar = new gj(3, str26, e03Var);
                                this.E0 = null;
                                this.X = str26;
                                this.Y = null;
                                this.Z = null;
                                this.y0 = obj3;
                                this.z0 = u81Var2;
                                this.A0 = channelHandlerContext2;
                                this.B0 = null;
                                this.C0 = i4;
                                this.D0 = 2;
                                if (d73.a(gjVar, this) != mf0Var) {
                                    return mf0Var;
                                }
                                u81Var3 = u81Var2;
                                str33 = str26;
                                u81Var3.getClass();
                                u81.F(channelHandlerContext2, "{\"success\": true}");
                                objN2 = obj3;
                                strDecode2 = str33;
                            }
                            u81 u81Var9 = this.I0;
                            ChannelHandlerContext channelHandlerContext8 = this.J0;
                            thA = uk3.a(objN2);
                            if (thA != null) {
                                String str47 = "Validation failed for file: " + strDecode2 + ", error: " + thA.getMessage();
                                if (fy4.b) {
                                    Xlog.logWrite2(0L, ke2Var.a(), "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str47);
                                    str34 = "ExplorerServer";
                                    str35 = str47;
                                } else {
                                    str34 = "ExplorerServer";
                                    str35 = str47;
                                }
                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                    Log.d(str34, str35, null);
                                }
                                HttpResponseStatus httpResponseStatus5 = HttpResponseStatus.BAD_REQUEST;
                                httpResponseStatus5.getClass();
                                String message = thA.getMessage();
                                if (message == null) {
                                    message = "Invalid profile format";
                                }
                                u81Var9.s(channelHandlerContext8, httpResponseStatus5, message);
                            }
                            return xl4Var;
                        }
                    } else {
                        str3 = "API: Renaming file: ";
                    }
                    uh3 uh3Var6 = this.F0;
                    String str48 = this.G0;
                    str48.getClass();
                    if (uh3Var6.c(str48) != null && n12.c(this.H0, HttpMethod.POST)) {
                        iq1 iq1Var2 = this.I0.f;
                        String string2 = this.L0.content().toString(CharsetUtil.UTF_8);
                        iq1Var2.getClass();
                        g62 g62Var2 = (g62) iq1Var2.c(string2, new bk4(g62.class));
                        y42 y42VarH2 = g62Var2.h("name");
                        if (y42VarH2 == null || (strD2 = y42VarH2.d()) == null) {
                            strD2 = "";
                        }
                        String strConcat = "API: Creating new file: ".concat(strD2);
                        if (fy4.b) {
                            Xlog.logWrite2(0L, ke2Var.a(), "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                            str20 = "ExplorerServer";
                            str21 = strConcat;
                        } else {
                            str20 = "ExplorerServer";
                            str21 = strConcat;
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d(str20, str21, null);
                        }
                        y42 y42VarH3 = g62Var2.h("content");
                        if (y42VarH3 == null || (strD3 = y42VarH3.d()) == null) {
                            strD3 = "";
                        }
                        if (strD2.length() == 0) {
                            u81 u81Var10 = this.I0;
                            ChannelHandlerContext channelHandlerContext9 = this.J0;
                            HttpResponseStatus httpResponseStatus6 = HttpResponseStatus.BAD_REQUEST;
                            httpResponseStatus6.getClass();
                            u81Var10.s(channelHandlerContext9, httpResponseStatus6, null);
                        } else if (w44.d0(strD2, ".conf", false)) {
                            String strS0 = p44.S0(strD2, ".conf");
                            boolean zExists2 = d73.g(strS0).exists();
                            u81 u81Var11 = this.I0;
                            if (zExists2) {
                                ChannelHandlerContext channelHandlerContext10 = this.J0;
                                HttpResponseStatus httpResponseStatus7 = HttpResponseStatus.BAD_REQUEST;
                                httpResponseStatus7.getClass();
                                u81Var11.s(channelHandlerContext10, httpResponseStatus7, "Profile name already exists");
                            } else {
                                objN = u81.N(strS0, strD3);
                                u81 u81Var12 = this.I0;
                                ChannelHandlerContext channelHandlerContext11 = this.J0;
                                if (!(objN instanceof tk3)) {
                                    e03[] e03VarArr2 = {(e03) objN};
                                    this.E0 = null;
                                    this.X = null;
                                    this.Y = strD2;
                                    this.Z = null;
                                    this.y0 = strS0;
                                    this.z0 = objN;
                                    this.A0 = u81Var12;
                                    this.B0 = channelHandlerContext11;
                                    i2 = 0;
                                    this.C0 = 0;
                                    i3 = 3;
                                    this.D0 = 3;
                                    if (d73.j(e03VarArr2, this) == mf0Var) {
                                        return mf0Var;
                                    }
                                    obj2 = objN;
                                    channelHandlerContext = channelHandlerContext11;
                                    str22 = strD2;
                                    str23 = strS0;
                                    u81Var = u81Var12;
                                    e1 e1Var4 = d73.a;
                                    ko0Var = new ko0(str23, i3);
                                    this.E0 = null;
                                    this.X = null;
                                    this.Y = str22;
                                    this.Z = null;
                                    this.y0 = null;
                                    this.z0 = obj2;
                                    this.A0 = u81Var;
                                    this.B0 = channelHandlerContext;
                                    this.C0 = i2;
                                    this.D0 = 4;
                                    if (d73.a(ko0Var, this) == mf0Var) {
                                        return mf0Var;
                                    }
                                    u81Var.getClass();
                                    u81.F(channelHandlerContext, "{\"success\": true}");
                                    objN = obj2;
                                    strD2 = str22;
                                }
                                u81 u81Var13 = this.I0;
                                ChannelHandlerContext channelHandlerContext12 = this.J0;
                                thA2 = uk3.a(objN);
                                if (thA2 != null) {
                                    String str49 = "Validation failed for new file: " + strD2 + ", error: " + thA2.getMessage();
                                    if (fy4.b) {
                                        Xlog.logWrite2(0L, ke2Var.a(), "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str49);
                                        str36 = "ExplorerServer";
                                        str37 = str49;
                                    } else {
                                        str36 = "ExplorerServer";
                                        str37 = str49;
                                    }
                                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                        Log.d(str36, str37, null);
                                    }
                                    HttpResponseStatus httpResponseStatus8 = HttpResponseStatus.BAD_REQUEST;
                                    httpResponseStatus8.getClass();
                                    String message2 = thA2.getMessage();
                                    if (message2 == null) {
                                        message2 = "Invalid profile format";
                                    }
                                    u81Var13.s(channelHandlerContext12, httpResponseStatus8, message2);
                                }
                            }
                        } else {
                            u81 u81Var14 = this.I0;
                            ChannelHandlerContext channelHandlerContext13 = this.J0;
                            HttpResponseStatus httpResponseStatus9 = HttpResponseStatus.BAD_REQUEST;
                            httpResponseStatus9.getClass();
                            u81Var14.s(channelHandlerContext13, httpResponseStatus9, "Profile name must end with .conf");
                        }
                        return xl4Var;
                    }
                    uh3 uh3Var7 = this.M0;
                    String str50 = this.G0;
                    str50.getClass();
                    if (uh3Var7.c(str50) == null || !n12.c(this.H0, HttpMethod.POST)) {
                        uh3 uh3Var8 = this.N0;
                        String str51 = this.G0;
                        str51.getClass();
                        if (uh3Var8.c(str51) == null || !n12.c(this.H0, HttpMethod.POST)) {
                            uh3 uh3Var9 = this.O0;
                            String str52 = this.G0;
                            str52.getClass();
                            if (uh3Var9.c(str52) == null || !n12.c(this.H0, HttpMethod.POST)) {
                                uh3 uh3Var10 = this.P0;
                                String str53 = this.G0;
                                str53.getClass();
                                if (uh3Var10.c(str53) == null || !n12.c(this.H0, HttpMethod.DELETE)) {
                                    uh3 uh3Var11 = this.Q0;
                                    String str54 = this.G0;
                                    str54.getClass();
                                    if (uh3Var11.c(str54) == null || !n12.c(this.H0, HttpMethod.GET)) {
                                        uh3 uh3Var12 = this.R0;
                                        String str55 = this.G0;
                                        str55.getClass();
                                        if (uh3Var12.c(str55) == null || !n12.c(this.H0, HttpMethod.POST)) {
                                            uh3 uh3Var13 = this.S0;
                                            String str56 = this.G0;
                                            str56.getClass();
                                            if (uh3Var13.c(str56) == null || !n12.c(this.H0, HttpMethod.GET)) {
                                                u81 u81Var15 = this.I0;
                                                ChannelHandlerContext channelHandlerContext14 = this.J0;
                                                HttpResponseStatus httpResponseStatus10 = HttpResponseStatus.NOT_FOUND;
                                                httpResponseStatus10.getClass();
                                                u81Var15.s(channelHandlerContext14, httpResponseStatus10, null);
                                            } else {
                                                uh3 uh3Var14 = this.S0;
                                                String str57 = this.G0;
                                                str57.getClass();
                                                uh2 uh2VarA3 = uh3.a(uh3Var14, str57);
                                                if (uh2VarA3 != null) {
                                                    z = true;
                                                    str4 = (String) ((sh2) uh2VarA3.a()).get(1);
                                                } else {
                                                    z = true;
                                                    str4 = null;
                                                }
                                                u81 u81Var16 = this.I0;
                                                if (str4 == null) {
                                                    ChannelHandlerContext channelHandlerContext15 = this.J0;
                                                    HttpResponseStatus httpResponseStatus11 = HttpResponseStatus.BAD_REQUEST;
                                                    httpResponseStatus11.getClass();
                                                    u81Var16.s(channelHandlerContext15, httpResponseStatus11, null);
                                                } else {
                                                    lz1 lz1Var = (lz1) u81Var16.A.get(str4);
                                                    if (lz1Var == null) {
                                                        u81 u81Var17 = this.I0;
                                                        ChannelHandlerContext channelHandlerContext16 = this.J0;
                                                        HttpResponseStatus httpResponseStatus12 = HttpResponseStatus.NOT_FOUND;
                                                        httpResponseStatus12.getClass();
                                                        u81Var17.s(channelHandlerContext16, httpResponseStatus12, "Task not found");
                                                    } else {
                                                        g62 g62Var3 = new g62();
                                                        if (lz1Var.b == kz1.A) {
                                                            z = false;
                                                        }
                                                        g62Var3.f("success", Boolean.valueOf(z));
                                                        String lowerCase = lz1Var.b.name().toLowerCase(Locale.ROOT);
                                                        lowerCase.getClass();
                                                        g62Var3.g("status", lowerCase);
                                                        int iOrdinal = lz1Var.b.ordinal();
                                                        if (iOrdinal == 2) {
                                                            e03 e03Var3 = lz1Var.c;
                                                            if (e03Var3 != null && (t53Var = (t53) e03Var3.b) != null) {
                                                                q42 q42Var2 = new q42();
                                                                g62 g62Var4 = new g62();
                                                                g62Var4.g("name", t53Var.getName() + ".conf");
                                                                g62Var4.g(str2, t53Var.getName());
                                                                q42Var2.b.add(g62Var4);
                                                                g62Var3.e("profiles", q42Var2);
                                                            }
                                                            u81 u81Var18 = this.I0;
                                                            ChannelHandlerContext channelHandlerContext17 = this.J0;
                                                            HttpResponseStatus httpResponseStatus13 = HttpResponseStatus.INTERNAL_SERVER_ERROR;
                                                            httpResponseStatus13.getClass();
                                                            u81Var18.s(channelHandlerContext17, httpResponseStatus13, "Inconsistent task state");
                                                        } else if (iOrdinal == 3) {
                                                            g62Var3.g("error", lz1Var.d);
                                                        }
                                                        u81.F(this.J0, this.I0.f.g(g62Var3));
                                                    }
                                                }
                                            }
                                        } else {
                                            iq1 iq1Var3 = this.I0.f;
                                            String string3 = this.L0.content().toString(CharsetUtil.UTF_8);
                                            iq1Var3.getClass();
                                            y42 y42VarH4 = ((g62) iq1Var3.c(string3, new bk4(g62.class))).h(RtspHeaders.Values.URL);
                                            String strD5 = y42VarH4 != null ? y42VarH4.d() : null;
                                            if (strD5 == null || p44.x0(strD5)) {
                                                u81 u81Var19 = this.I0;
                                                ChannelHandlerContext channelHandlerContext18 = this.J0;
                                                HttpResponseStatus httpResponseStatus14 = HttpResponseStatus.BAD_REQUEST;
                                                httpResponseStatus14.getClass();
                                                u81Var19.s(channelHandlerContext18, httpResponseStatus14, "URL is required");
                                            } else {
                                                String string4 = UUID.randomUUID().toString();
                                                string4.getClass();
                                                String strT0 = p44.T0(12, string4);
                                                lz1 lz1Var2 = new lz1(strT0);
                                                this.I0.A.put(strT0, lz1Var2);
                                                this.I0.g();
                                                String str58 = "API: Import URL task " + strT0 + " created for: " + strD5;
                                                if (fy4.b) {
                                                    Xlog.logWrite2(0L, ke2Var.a(), "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str58);
                                                    str5 = "ExplorerServer";
                                                    str6 = str58;
                                                } else {
                                                    str5 = "ExplorerServer";
                                                    str6 = str58;
                                                }
                                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                    Log.d(str5, str6, null);
                                                }
                                                g62 g62Var5 = new g62();
                                                g62Var5.f("success", Boolean.TRUE);
                                                g62Var5.g("taskId", strT0);
                                                u81 u81Var20 = this.I0;
                                                ChannelHandlerContext channelHandlerContext19 = this.J0;
                                                String strG = u81Var20.f.g(g62Var5);
                                                HttpResponseStatus httpResponseStatus15 = HttpResponseStatus.CREATED;
                                                httpResponseStatus15.getClass();
                                                u81.I(channelHandlerContext19, httpResponseStatus15, strG);
                                                ji0.B(p95.a(qv0.a()), null, null, new d51(lz1Var2, strD5, strT0, null), 3);
                                            }
                                        }
                                    } else {
                                        uh3 uh3Var15 = this.Q0;
                                        String str59 = this.G0;
                                        str59.getClass();
                                        uh2 uh2VarA4 = uh3.a(uh3Var15, str59);
                                        String strDecode4 = (uh2VarA4 == null || (str7 = (String) ((sh2) uh2VarA4.a()).get(1)) == null) ? null : URLDecoder.decode(str7, "UTF-8");
                                        String str60 = "API: Downloading file: " + strDecode4;
                                        if (fy4.b) {
                                            Xlog.logWrite2(0L, ke2Var.a(), "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str60);
                                        }
                                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                            Log.d("ExplorerServer", str60, null);
                                        }
                                        if (strDecode4 == null) {
                                            u81 u81Var21 = this.I0;
                                            ChannelHandlerContext channelHandlerContext20 = this.J0;
                                            HttpResponseStatus httpResponseStatus16 = HttpResponseStatus.BAD_REQUEST;
                                            httpResponseStatus16.getClass();
                                            u81Var21.s(channelHandlerContext20, httpResponseStatus16, null);
                                        } else {
                                            File fileG3 = d73.g(strDecode4);
                                            boolean zExists3 = fileG3.exists();
                                            u81 u81Var22 = this.I0;
                                            ChannelHandlerContext channelHandlerContext21 = this.J0;
                                            if (zExists3) {
                                                u81.C(channelHandlerContext21, fileG3);
                                            } else {
                                                HttpResponseStatus httpResponseStatus17 = HttpResponseStatus.NOT_FOUND;
                                                httpResponseStatus17.getClass();
                                                u81Var22.s(channelHandlerContext21, httpResponseStatus17, null);
                                            }
                                        }
                                    }
                                } else {
                                    uh3 uh3Var16 = this.P0;
                                    String str61 = this.G0;
                                    str61.getClass();
                                    uh2 uh2VarA5 = uh3.a(uh3Var16, str61);
                                    strDecode = (uh2VarA5 == null || (str10 = (String) ((sh2) uh2VarA5.a()).get(1)) == null) ? null : URLDecoder.decode(str10, "UTF-8");
                                    String str62 = "API: Deleting file: " + strDecode;
                                    if (fy4.b) {
                                        Xlog.logWrite2(0L, ke2Var.a(), "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str62);
                                        str8 = "ExplorerServer";
                                        str9 = str62;
                                    } else {
                                        str8 = "ExplorerServer";
                                        str9 = str62;
                                    }
                                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                        Log.d(str8, str9, null);
                                    }
                                    if (strDecode != null) {
                                        e1 e1Var5 = d73.a;
                                        this.E0 = null;
                                        this.X = strDecode;
                                        this.D0 = 9;
                                        if (d73.d(strDecode, this) != mf0Var) {
                                            e1 e1Var6 = d73.a;
                                            ko0 ko0Var2 = new ko0(strDecode, 5);
                                            this.E0 = null;
                                            this.X = null;
                                            this.D0 = 10;
                                            break;
                                        }
                                        return mf0Var;
                                    }
                                    u81 u81Var23 = this.I0;
                                    ChannelHandlerContext channelHandlerContext22 = this.J0;
                                    HttpResponseStatus httpResponseStatus18 = HttpResponseStatus.BAD_REQUEST;
                                    httpResponseStatus18.getClass();
                                    u81Var23.s(channelHandlerContext22, httpResponseStatus18, null);
                                }
                            } else {
                                uh3 uh3Var17 = this.O0;
                                String str63 = this.G0;
                                str63.getClass();
                                uh2 uh2VarA6 = uh3.a(uh3Var17, str63);
                                String strDecode5 = (uh2VarA6 == null || (str13 = (String) ((sh2) uh2VarA6.a()).get(1)) == null) ? null : URLDecoder.decode(str13, "UTF-8");
                                String str64 = str + strDecode5;
                                if (fy4.b) {
                                    Xlog.logWrite2(0L, ke2Var.a(), "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str64);
                                    str11 = "ExplorerServer";
                                    str12 = str64;
                                } else {
                                    str11 = "ExplorerServer";
                                    str12 = str64;
                                }
                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                    Log.d(str11, str12, null);
                                }
                                if (strDecode5 != null) {
                                    e1 e1Var7 = d73.a;
                                    this.E0 = null;
                                    this.X = null;
                                    this.D0 = 7;
                                    objB = d73.b(strDecode5, this);
                                    if (objB != mf0Var) {
                                        str38 = (String) objB;
                                        if (str38 != null) {
                                            e1 e1Var8 = d73.a;
                                            ko0 ko0Var3 = new ko0(str38, 4);
                                            this.E0 = null;
                                            this.X = null;
                                            this.Y = null;
                                            this.D0 = 8;
                                            if (d73.a(ko0Var3, this) == mf0Var) {
                                            }
                                        }
                                        u81.F(this.J0, "{\"success\": true}");
                                    }
                                    return mf0Var;
                                }
                                u81 u81Var24 = this.I0;
                                ChannelHandlerContext channelHandlerContext23 = this.J0;
                                HttpResponseStatus httpResponseStatus19 = HttpResponseStatus.BAD_REQUEST;
                                httpResponseStatus19.getClass();
                                u81Var24.s(channelHandlerContext23, httpResponseStatus19, null);
                            }
                        } else {
                            uh3 uh3Var18 = this.N0;
                            String str65 = this.G0;
                            str65.getClass();
                            uh2 uh2VarA7 = uh3.a(uh3Var18, str65);
                            String strDecode6 = (uh2VarA7 == null || (str17 = (String) ((sh2) uh2VarA7.a()).get(1)) == null) ? null : URLDecoder.decode(str17, "UTF-8");
                            u81 u81Var25 = this.I0;
                            if (strDecode6 == null) {
                                ChannelHandlerContext channelHandlerContext24 = this.J0;
                                HttpResponseStatus httpResponseStatus20 = HttpResponseStatus.BAD_REQUEST;
                                httpResponseStatus20.getClass();
                                u81Var25.s(channelHandlerContext24, httpResponseStatus20, null);
                            } else {
                                iq1 iq1Var4 = u81Var25.f;
                                String string5 = this.L0.content().toString(CharsetUtil.UTF_8);
                                iq1Var4.getClass();
                                g62 g62Var6 = (g62) iq1Var4.c(string5, new bk4(g62.class));
                                bh3 bh3Var2 = new bh3();
                                y42 y42VarH5 = g62Var6.h("name");
                                if (y42VarH5 == null || (strD = y42VarH5.d()) == null) {
                                    strD = "";
                                }
                                bh3Var2.b = strD;
                                String str66 = str3 + strDecode6 + " to " + ((Object) strD);
                                if (fy4.b) {
                                    Xlog.logWrite2(0L, ke2Var.a(), "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str66);
                                    str14 = "ExplorerServer";
                                    str15 = str66;
                                } else {
                                    str14 = "ExplorerServer";
                                    str15 = str66;
                                }
                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                    Log.d(str14, str15, null);
                                }
                                if (w44.d0((String) bh3Var2.b, ".conf", false)) {
                                    String strS02 = p44.S0((String) bh3Var2.b, ".conf");
                                    bh3Var2.b = strS02;
                                    if (d73.g(strS02).exists()) {
                                        u81 u81Var26 = this.I0;
                                        ChannelHandlerContext channelHandlerContext25 = this.J0;
                                        HttpResponseStatus httpResponseStatus21 = HttpResponseStatus.BAD_REQUEST;
                                        httpResponseStatus21.getClass();
                                        u81Var26.s(channelHandlerContext25, httpResponseStatus21, "Profile name already exists");
                                    } else {
                                        String str67 = (String) bh3Var2.b;
                                        this.E0 = null;
                                        this.X = strDecode6;
                                        this.Y = null;
                                        this.Z = bh3Var2;
                                        this.D0 = 5;
                                        if (d73.i(strDecode6, str67, this) == mf0Var) {
                                            return mf0Var;
                                        }
                                        str16 = strDecode6;
                                        bh3Var = bh3Var2;
                                        e1 e1Var9 = d73.a;
                                        gjVar2 = new gj(4, bh3Var, str16);
                                        this.E0 = null;
                                        this.X = null;
                                        this.Y = null;
                                        this.Z = null;
                                        this.D0 = 6;
                                        if (d73.a(gjVar2, this) == mf0Var) {
                                            return mf0Var;
                                        }
                                        u81.F(this.J0, "{\"success\": true}");
                                    }
                                } else {
                                    u81 u81Var27 = this.I0;
                                    ChannelHandlerContext channelHandlerContext26 = this.J0;
                                    HttpResponseStatus httpResponseStatus22 = HttpResponseStatus.BAD_REQUEST;
                                    httpResponseStatus22.getClass();
                                    u81Var27.s(channelHandlerContext26, httpResponseStatus22, "Profile name must end with .conf");
                                }
                            }
                        }
                    } else {
                        if (fy4.b) {
                            Xlog.logWrite2(0L, ke2Var.a(), "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "API: Uploading file");
                            str18 = "ExplorerServer";
                            str19 = "API: Uploading file";
                        } else {
                            str18 = "ExplorerServer";
                            str19 = "API: Uploading file";
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d(str18, str19, null);
                        }
                        u81 u81Var28 = this.I0;
                        ChannelHandlerContext channelHandlerContext27 = this.J0;
                        FullHttpRequest fullHttpRequest = this.L0;
                        fullHttpRequest.getClass();
                        u81Var28.n(channelHandlerContext27, fullHttpRequest);
                    }
                    return xl4Var;
                case 1:
                    int i5 = this.C0;
                    e03Var = (e03) this.B0;
                    ChannelHandlerContext channelHandlerContext28 = (ChannelHandlerContext) this.A0;
                    u81Var2 = (u81) this.z0;
                    Object obj4 = this.y0;
                    str26 = this.X;
                    n12.S(obj);
                    i4 = i5;
                    channelHandlerContext2 = channelHandlerContext28;
                    obj3 = obj4;
                    e1 e1Var32 = d73.a;
                    gjVar = new gj(3, str26, e03Var);
                    this.E0 = null;
                    this.X = str26;
                    this.Y = null;
                    this.Z = null;
                    this.y0 = obj3;
                    this.z0 = u81Var2;
                    this.A0 = channelHandlerContext2;
                    this.B0 = null;
                    this.C0 = i4;
                    this.D0 = 2;
                    if (d73.a(gjVar, this) != mf0Var) {
                    }
                    break;
                case 2:
                    channelHandlerContext2 = (ChannelHandlerContext) this.A0;
                    u81Var3 = (u81) this.z0;
                    obj3 = this.y0;
                    str33 = this.X;
                    n12.S(obj);
                    u81Var3.getClass();
                    u81.F(channelHandlerContext2, "{\"success\": true}");
                    objN2 = obj3;
                    strDecode2 = str33;
                    u81 u81Var92 = this.I0;
                    ChannelHandlerContext channelHandlerContext82 = this.J0;
                    thA = uk3.a(objN2);
                    if (thA != null) {
                    }
                    return xl4Var;
                case 3:
                    int i6 = this.C0;
                    ChannelHandlerContext channelHandlerContext29 = (ChannelHandlerContext) this.B0;
                    u81 u81Var29 = (u81) this.A0;
                    Object obj5 = this.z0;
                    String str68 = (String) this.y0;
                    String str69 = this.Y;
                    n12.S(obj);
                    i2 = i6;
                    channelHandlerContext = channelHandlerContext29;
                    u81Var = u81Var29;
                    obj2 = obj5;
                    str23 = str68;
                    str22 = str69;
                    i3 = 3;
                    e1 e1Var42 = d73.a;
                    ko0Var = new ko0(str23, i3);
                    this.E0 = null;
                    this.X = null;
                    this.Y = str22;
                    this.Z = null;
                    this.y0 = null;
                    this.z0 = obj2;
                    this.A0 = u81Var;
                    this.B0 = channelHandlerContext;
                    this.C0 = i2;
                    this.D0 = 4;
                    if (d73.a(ko0Var, this) == mf0Var) {
                    }
                    u81Var.getClass();
                    u81.F(channelHandlerContext, "{\"success\": true}");
                    objN = obj2;
                    strD2 = str22;
                    u81 u81Var132 = this.I0;
                    ChannelHandlerContext channelHandlerContext122 = this.J0;
                    thA2 = uk3.a(objN);
                    if (thA2 != null) {
                    }
                    return xl4Var;
                case 4:
                    channelHandlerContext = (ChannelHandlerContext) this.B0;
                    u81Var = (u81) this.A0;
                    obj2 = this.z0;
                    str22 = this.Y;
                    n12.S(obj);
                    u81Var.getClass();
                    u81.F(channelHandlerContext, "{\"success\": true}");
                    objN = obj2;
                    strD2 = str22;
                    u81 u81Var1322 = this.I0;
                    ChannelHandlerContext channelHandlerContext1222 = this.J0;
                    thA2 = uk3.a(objN);
                    if (thA2 != null) {
                    }
                    return xl4Var;
                case 5:
                    bh3Var = this.Z;
                    str16 = this.X;
                    n12.S(obj);
                    e1 e1Var92 = d73.a;
                    gjVar2 = new gj(4, bh3Var, str16);
                    this.E0 = null;
                    this.X = null;
                    this.Y = null;
                    this.Z = null;
                    this.D0 = 6;
                    if (d73.a(gjVar2, this) == mf0Var) {
                    }
                    u81.F(this.J0, "{\"success\": true}");
                    return xl4Var;
                case 6:
                    n12.S(obj);
                    u81.F(this.J0, "{\"success\": true}");
                    return xl4Var;
                case 7:
                    n12.S(obj);
                    objB = obj;
                    str38 = (String) objB;
                    if (str38 != null) {
                    }
                    u81.F(this.J0, "{\"success\": true}");
                    return xl4Var;
                case 8:
                    n12.S(obj);
                    u81.F(this.J0, "{\"success\": true}");
                    return xl4Var;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    strDecode = this.X;
                    n12.S(obj);
                    e1 e1Var62 = d73.a;
                    ko0 ko0Var22 = new ko0(strDecode, 5);
                    this.E0 = null;
                    this.X = null;
                    this.D0 = 10;
                    break;
                case 10:
                    n12.S(obj);
                    u81.F(this.J0, "{\"success\": true}");
                    return xl4Var;
                default:
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        } finally {
            ReferenceCountUtil.release(this.L0);
        }
    }
}
