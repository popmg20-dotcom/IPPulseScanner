package defpackage;

import android.app.BroadcastOptions;
import android.app.Service;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import io.netty.handler.codec.http.HttpHeaders;
import io.sentry.android.core.u;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ff5 implements m95 {
    public static volatile ff5 b1;
    public e75 A;
    public o75 B0;
    public final k85 C0;
    public boolean E0;
    public long F0;
    public ArrayList G0;
    public int I0;
    public int J0;
    public boolean K0;
    public boolean L0;
    public boolean M0;
    public FileLock N0;
    public FileChannel O0;
    public ArrayList P0;
    public ArrayList Q0;
    public final HashMap S0;
    public final HashMap T0;
    public final HashMap U0;
    public rb5 W0;
    public ge5 X;
    public String X0;
    public e15 Y;
    public td5 Y0;
    public final z65 Z;
    public long Z0;
    public final x75 b;
    public final z65 f;
    public z65 y0;
    public m25 z;
    public fd5 z0;
    public final AtomicBoolean D0 = new AtomicBoolean(false);
    public final LinkedList H0 = new LinkedList();
    public final HashMap V0 = new HashMap();
    public final jf4 a1 = new jf4(9, this);
    public long R0 = -1;
    public final te5 A0 = new te5(this);

    public ff5(m31 m31Var) {
        this.C0 = k85.m(m31Var.a, null, null);
        z65 z65Var = new z65(this, 2);
        z65Var.X0();
        this.Z = z65Var;
        z65 z65Var2 = new z65(this, 0);
        z65Var2.X0();
        this.f = z65Var2;
        x75 x75Var = new x75(this);
        x75Var.X0();
        this.b = x75Var;
        this.S0 = new HashMap();
        this.T0 = new HashMap();
        this.U0 = new HashMap();
        C().e1(new qz4(this, m31Var));
    }

    public static final void A(v75 v75Var, String str) {
        List listH = v75Var.h();
        for (int i = 0; i < listH.size(); i++) {
            if (str.equals(((b85) listH.get(i)).o())) {
                v75Var.m(i);
                return;
            }
        }
    }

    public static String J(String str, Map map) {
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                if (((List) entry.getValue()).isEmpty()) {
                    return null;
                }
                return (String) ((List) entry.getValue()).get(0);
            }
        }
        return null;
    }

    public static void P(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
    }

    public static final boolean Q(tg5 tg5Var) {
        return !TextUtils.isEmpty(tg5Var.f);
    }

    public static final void R(pe5 pe5Var) {
        if (pe5Var == null) {
            xe.q("Upload Component not created");
        } else {
            if (pe5Var.Y) {
                return;
            }
            xe.q("Component not initialized: ".concat(String.valueOf(pe5Var.getClass())));
        }
    }

    public static final Boolean S(tg5 tg5Var) {
        Boolean bool = tg5Var.G0;
        String str = tg5Var.T0;
        if (!TextUtils.isEmpty(str)) {
            int iOrdinal = ((o95) ub4.g(str).b).ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                return null;
            }
            if (iOrdinal == 2) {
                return Boolean.TRUE;
            }
            if (iOrdinal == 3) {
                return Boolean.FALSE;
            }
        }
        return bool;
    }

    public static ff5 y(Service service) {
        tj4.i(service.getApplicationContext());
        if (b1 == null) {
            synchronized (ff5.class) {
                try {
                    if (b1 == null) {
                        b1 = new ff5(new m31(service));
                    }
                } finally {
                }
            }
        }
        return b1;
    }

    public static final void z(v75 v75Var, int i, String str) {
        List listH = v75Var.h();
        for (int i2 = 0; i2 < listH.size(); i2++) {
            if ("_err".equals(((b85) listH.get(i2)).o())) {
                return;
            }
        }
        z75 z75VarZ = b85.z();
        z75VarZ.h("_err");
        z75VarZ.j(i);
        b85 b85Var = (b85) z75VarZ.e();
        z75 z75VarZ2 = b85.z();
        z75VarZ2.h("_ev");
        z75VarZ2.i(str);
        b85 b85Var2 = (b85) z75VarZ2.e();
        v75Var.k(b85Var);
        v75Var.k(b85Var2);
    }

    public final int B(String str, rz4 rz4Var) {
        o95 o95VarZ0;
        x75 x75Var = this.b;
        a65 a65VarQ1 = x75Var.q1(str);
        r95 r95Var = r95.AD_PERSONALIZATION;
        if (a65VarQ1 == null) {
            rz4Var.f(r95Var, z15.FAILSAFE);
            return 1;
        }
        m25 m25Var = this.z;
        R(m25Var);
        b75 b75VarX1 = m25Var.X1(str);
        if (b75VarX1 == null || ((o95) ub4.g(b75VarX1.s()).b) != o95.POLICY || (o95VarZ0 = x75Var.Z0(str, r95Var)) == o95.UNINITIALIZED) {
            rz4Var.f(r95Var, z15.REMOTE_DEFAULT);
            if (x75Var.p1(str, r95Var)) {
                return 0;
            }
        } else {
            rz4Var.f(r95Var, z15.REMOTE_ENFORCED_DEFAULT);
            if (o95VarZ0 == o95.GRANTED) {
                return 0;
            }
        }
        return 1;
    }

    @Override // defpackage.m95
    public final f85 C() {
        k85 k85Var = this.C0;
        tj4.i(k85Var);
        f85 f85Var = k85Var.Z;
        k85.h(f85Var);
        return f85Var;
    }

    public final HashMap D(w75 w75Var) {
        Serializable serializableK1;
        HashMap map = new HashMap();
        h0();
        HashMap map2 = new HashMap();
        for (b85 b85Var : w75Var.n()) {
            if (b85Var.o().startsWith("gad_") && (serializableK1 = z65.k1(b85Var)) != null) {
                map2.put(b85Var.o(), serializableK1);
            }
        }
        for (Map.Entry entry : map2.entrySet()) {
            map.put((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return map;
    }

    public final void E() {
        C().V0();
        if (this.H0.isEmpty()) {
            return;
        }
        td5 td5Var = this.Y0;
        int i = 2;
        if (td5Var == null) {
            td5 td5Var2 = new td5(this, this.C0, i);
            this.Y0 = td5Var2;
            td5Var = td5Var2;
        }
        if (td5Var.c != 0) {
            return;
        }
        z0().getClass();
        long jMax = Math.max(0L, ((long) ((Integer) r55.C0.a(null)).intValue()) - (SystemClock.elapsedRealtime() - this.Z0));
        n().H0.b(Long.valueOf(jMax), "Scheduling notify next app runnable, delay in ms");
        td5 td5Var3 = this.Y0;
        if (td5Var3 == null) {
            td5 td5Var4 = new td5(this, this.C0, i);
            this.Y0 = td5Var4;
            td5Var3 = td5Var4;
        }
        td5Var3.b(jMax);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(40:8|(3:9|10|(4:12|13|(4:15|(1:22)|25|474)(18:26|27|(2:35|(3:37|(1:44)(1:43)|45)(0))(1:34)|46|(2:48|(3:50|(4:53|(1:479)(2:59|476)|60|51)|475))|61|62|(4:64|65|(0)(1:71)|(7:117|(5:121|(2:123|489)(2:124|(2:126|488)(1:490))|127|118|119)|487|128|(2:131|(3:137|(1:139)(2:140|(3:142|(3:145|(1:147)(1:506)|143)|505))|148)(2:135|136))(1:130)|149|(2:151|(6:(2:156|(6:158|159|193|(9:195|(4:198|(2:211|(2:213|492)(1:494))(5:202|(5:205|(2:208|206)|496|209|203)|495|210|493)|214|196)|491|215|(4:218|(3:498|220|501)(1:500)|499|216)|497|221|(2:224|222)|502)(1:225)|226|473))|160|193|(0)(0)|226|473)(7:161|162|192|193|(0)(0)|226|473))(2:163|(8:165|(6:(2:170|(6:172|159|193|(0)(0)|226|473))|173|193|(0)(0)|226|473)|162|192|193|(0)(0)|226|473)(7:174|(2:185|(2:186|(2:188|(2:504|190)(1:191))(1:503)))(0)|192|193|(0)(0)|226|473)))(3:136|149|(0)(0)))(1:72)|70|(3:73|74|(5:76|(1:78)(3:80|(2:82|481)|83)|79|482|83)(1:480))|84|(1:87)|(1:89)|90|(1:92)(1:93)|94|(4:99|(4:102|(2:104|485)(2:105|(2:107|484)(1:486))|108|100)|483|(1:(1:114)(1:115))(1:(1:111)(2:112|(0)(0))))|(0)(0))|227)(1:472))|228|(3:230|(2:232|(2:234|509)(2:235|(1:510)(3:237|(1:239)(1:240)|(1:512)(2:244|508))))(0)|245)|507|246|(3:247|248|(1:513)(2:250|(2:514|252)(1:515)))|253|(1:255)(2:256|(1:258))|259|(1:261)(1:262)|263|(1:265)(1:266)|267|(6:270|(1:272)|273|(2:275|517)(1:518)|276|268)|516|277|(2:282|(1:286))(1:281)|287|(1:289)|290|(1:292)|293|(2:295|(1:301))|302|(9:304|(9:308|309|(4:311|(2:313|(1:315))(1:316)|(1:333)(5:320|(1:324)|326|(1:331)(1:330)|332)|334)(3:337|(4:469|339|344|(4:346|(2:347|(2:349|(3:523|351|(1:353)(1:354))(1:524))(1:522))|355|(1:357)(6:358|(2:360|(1:362))(1:363)|364|(1:366)(1:368)|367|(5:370|(1:378)|379|336|521)(4:380|(3:382|(1:384)|385)(4:386|(1:388)(1:389)|390|(3:392|(1:394)|395)(2:396|(1:398)))|399|520)))(2:355|(0)(0)))(3:343|344|(0)(0))|400)|335|336|521|400|305|306)|519|401|(1:403)|404|(2:407|405)|525|408)(1:409)|410|(1:412)(13:414|(9:416|(1:418)(1:419)|420|(1:422)(1:423)|424|(1:426)(1:427)|428|(1:430)(1:431)|432)|433|(3:435|(2:441|(1:443)(1:444))(1:440)|445)|446|(3:(2:450|527)(1:528)|451|447)|526|452|(1:454)|455|467|456|460)|413|433|(0)|446|(1:447)|526|452|(0)|455|467|456|460) */
    /* JADX WARN: Code restructure failed: missing block: B:458:0x0f18, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:459:0x0f19, code lost:
    
        ((defpackage.k85) r2.f).n().z0.c("Failed to remove unused event metadata. appId", defpackage.t65.Z0(r1), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03e7 A[Catch: all -> 0x011d, TryCatch #2 {all -> 0x011d, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00dd, B:20:0x00f6, B:22:0x0100, B:227:0x0708, B:26:0x0130, B:29:0x0142, B:31:0x0148, B:46:0x018c, B:48:0x019e, B:51:0x01c3, B:53:0x01c9, B:55:0x01d9, B:57:0x01e7, B:59:0x01f7, B:60:0x0202, B:61:0x0205, B:64:0x021d, B:73:0x024e, B:76:0x0258, B:78:0x0266, B:83:0x02c1, B:80:0x028e, B:82:0x02a0, B:87:0x02d0, B:89:0x02f6, B:90:0x031a, B:92:0x034f, B:94:0x0355, B:97:0x0361, B:99:0x0396, B:100:0x03b1, B:102:0x03b7, B:104:0x03c5, B:108:0x03d9, B:105:0x03cd, B:111:0x03e0, B:114:0x03e7, B:115:0x0406, B:117:0x041f, B:118:0x042b, B:121:0x0435, B:127:0x0458, B:124:0x0447, B:149:0x04d2, B:151:0x04de, B:154:0x04ef, B:156:0x0500, B:158:0x050c, B:193:0x05d7, B:195:0x05dd, B:196:0x05e9, B:198:0x05ef, B:200:0x05ff, B:202:0x0609, B:203:0x061c, B:205:0x0622, B:206:0x063b, B:208:0x0641, B:209:0x065f, B:210:0x066d, B:214:0x0694, B:211:0x0673, B:213:0x067f, B:215:0x069b, B:216:0x06b8, B:218:0x06be, B:220:0x06d1, B:221:0x06de, B:222:0x06e2, B:224:0x06e8, B:226:0x06f4, B:163:0x0529, B:165:0x0537, B:168:0x054a, B:170:0x055b, B:172:0x0567, B:174:0x0577, B:176:0x0586, B:179:0x0592, B:181:0x059c, B:183:0x05a6, B:186:0x05b1, B:188:0x05b7, B:190:0x05c7, B:191:0x05d2, B:131:0x0460, B:133:0x046c, B:135:0x0478, B:148:0x04bc, B:140:0x0494, B:143:0x04a6, B:145:0x04ac, B:147:0x04b6, B:35:0x0152, B:37:0x015f, B:39:0x016d, B:41:0x0173, B:45:0x017e, B:230:0x0722, B:232:0x0734, B:234:0x073d, B:245:0x076d, B:235:0x0745, B:237:0x074e, B:239:0x0754, B:242:0x0760, B:244:0x0768, B:246:0x0770, B:247:0x077c, B:250:0x0784, B:252:0x0796, B:253:0x07a1, B:255:0x07a9, B:259:0x07d6, B:261:0x07f2, B:263:0x0805, B:265:0x0821, B:267:0x0834, B:268:0x0850, B:270:0x0856, B:272:0x086e, B:273:0x087c, B:275:0x088c, B:276:0x089a, B:277:0x089d, B:279:0x08e7, B:281:0x08ed, B:287:0x0918, B:289:0x0920, B:290:0x093e, B:292:0x0944, B:293:0x0958, B:295:0x096f, B:297:0x0980, B:299:0x0992, B:301:0x099c, B:302:0x099f, B:304:0x09fa, B:305:0x0a0d, B:308:0x0a15, B:311:0x0a34, B:313:0x0a4d, B:315:0x0a64, B:318:0x0a6c, B:320:0x0a70, B:322:0x0a74, B:324:0x0a7e, B:326:0x0a87, B:328:0x0a8b, B:330:0x0a91, B:332:0x0a9c, B:334:0x0aaa, B:400:0x0d10, B:337:0x0ab5, B:339:0x0ad3, B:344:0x0aee, B:346:0x0b10, B:347:0x0b18, B:349:0x0b1e, B:351:0x0b30, B:357:0x0b57, B:358:0x0b78, B:360:0x0b84, B:362:0x0b9c, B:364:0x0bdd, B:370:0x0bf9, B:372:0x0c04, B:374:0x0c08, B:376:0x0c0c, B:378:0x0c10, B:379:0x0c1c, B:380:0x0c23, B:382:0x0c29, B:384:0x0c41, B:385:0x0c46, B:399:0x0d0d, B:386:0x0c84, B:388:0x0c8a, B:392:0x0c9d, B:394:0x0cb9, B:395:0x0cc0, B:398:0x0d01, B:389:0x0c8f, B:355:0x0b41, B:342:0x0ad9, B:401:0x0d1c, B:403:0x0d2c, B:404:0x0d40, B:405:0x0d48, B:407:0x0d4e, B:410:0x0d69, B:412:0x0d7b, B:433:0x0e29, B:435:0x0e2f, B:437:0x0e44, B:440:0x0e4b, B:445:0x0e8c, B:441:0x0e5a, B:443:0x0e68, B:444:0x0e75, B:446:0x0e9b, B:447:0x0eb4, B:450:0x0ebc, B:451:0x0ec1, B:452:0x0ed1, B:454:0x0eeb, B:455:0x0f06, B:456:0x0f0e, B:460:0x0f2c, B:459:0x0f19, B:414:0x0d95, B:416:0x0d9b, B:418:0x0dab, B:420:0x0db2, B:426:0x0dc8, B:428:0x0dcf, B:430:0x0e1a, B:432:0x0e21, B:431:0x0e1e, B:427:0x0dcc, B:419:0x0daf, B:282:0x08fd, B:284:0x0903, B:286:0x0909, B:266:0x0831, B:262:0x0802, B:256:0x07af, B:258:0x07b5, B:461:0x0f35), top: B:471:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0406 A[Catch: all -> 0x011d, TryCatch #2 {all -> 0x011d, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00dd, B:20:0x00f6, B:22:0x0100, B:227:0x0708, B:26:0x0130, B:29:0x0142, B:31:0x0148, B:46:0x018c, B:48:0x019e, B:51:0x01c3, B:53:0x01c9, B:55:0x01d9, B:57:0x01e7, B:59:0x01f7, B:60:0x0202, B:61:0x0205, B:64:0x021d, B:73:0x024e, B:76:0x0258, B:78:0x0266, B:83:0x02c1, B:80:0x028e, B:82:0x02a0, B:87:0x02d0, B:89:0x02f6, B:90:0x031a, B:92:0x034f, B:94:0x0355, B:97:0x0361, B:99:0x0396, B:100:0x03b1, B:102:0x03b7, B:104:0x03c5, B:108:0x03d9, B:105:0x03cd, B:111:0x03e0, B:114:0x03e7, B:115:0x0406, B:117:0x041f, B:118:0x042b, B:121:0x0435, B:127:0x0458, B:124:0x0447, B:149:0x04d2, B:151:0x04de, B:154:0x04ef, B:156:0x0500, B:158:0x050c, B:193:0x05d7, B:195:0x05dd, B:196:0x05e9, B:198:0x05ef, B:200:0x05ff, B:202:0x0609, B:203:0x061c, B:205:0x0622, B:206:0x063b, B:208:0x0641, B:209:0x065f, B:210:0x066d, B:214:0x0694, B:211:0x0673, B:213:0x067f, B:215:0x069b, B:216:0x06b8, B:218:0x06be, B:220:0x06d1, B:221:0x06de, B:222:0x06e2, B:224:0x06e8, B:226:0x06f4, B:163:0x0529, B:165:0x0537, B:168:0x054a, B:170:0x055b, B:172:0x0567, B:174:0x0577, B:176:0x0586, B:179:0x0592, B:181:0x059c, B:183:0x05a6, B:186:0x05b1, B:188:0x05b7, B:190:0x05c7, B:191:0x05d2, B:131:0x0460, B:133:0x046c, B:135:0x0478, B:148:0x04bc, B:140:0x0494, B:143:0x04a6, B:145:0x04ac, B:147:0x04b6, B:35:0x0152, B:37:0x015f, B:39:0x016d, B:41:0x0173, B:45:0x017e, B:230:0x0722, B:232:0x0734, B:234:0x073d, B:245:0x076d, B:235:0x0745, B:237:0x074e, B:239:0x0754, B:242:0x0760, B:244:0x0768, B:246:0x0770, B:247:0x077c, B:250:0x0784, B:252:0x0796, B:253:0x07a1, B:255:0x07a9, B:259:0x07d6, B:261:0x07f2, B:263:0x0805, B:265:0x0821, B:267:0x0834, B:268:0x0850, B:270:0x0856, B:272:0x086e, B:273:0x087c, B:275:0x088c, B:276:0x089a, B:277:0x089d, B:279:0x08e7, B:281:0x08ed, B:287:0x0918, B:289:0x0920, B:290:0x093e, B:292:0x0944, B:293:0x0958, B:295:0x096f, B:297:0x0980, B:299:0x0992, B:301:0x099c, B:302:0x099f, B:304:0x09fa, B:305:0x0a0d, B:308:0x0a15, B:311:0x0a34, B:313:0x0a4d, B:315:0x0a64, B:318:0x0a6c, B:320:0x0a70, B:322:0x0a74, B:324:0x0a7e, B:326:0x0a87, B:328:0x0a8b, B:330:0x0a91, B:332:0x0a9c, B:334:0x0aaa, B:400:0x0d10, B:337:0x0ab5, B:339:0x0ad3, B:344:0x0aee, B:346:0x0b10, B:347:0x0b18, B:349:0x0b1e, B:351:0x0b30, B:357:0x0b57, B:358:0x0b78, B:360:0x0b84, B:362:0x0b9c, B:364:0x0bdd, B:370:0x0bf9, B:372:0x0c04, B:374:0x0c08, B:376:0x0c0c, B:378:0x0c10, B:379:0x0c1c, B:380:0x0c23, B:382:0x0c29, B:384:0x0c41, B:385:0x0c46, B:399:0x0d0d, B:386:0x0c84, B:388:0x0c8a, B:392:0x0c9d, B:394:0x0cb9, B:395:0x0cc0, B:398:0x0d01, B:389:0x0c8f, B:355:0x0b41, B:342:0x0ad9, B:401:0x0d1c, B:403:0x0d2c, B:404:0x0d40, B:405:0x0d48, B:407:0x0d4e, B:410:0x0d69, B:412:0x0d7b, B:433:0x0e29, B:435:0x0e2f, B:437:0x0e44, B:440:0x0e4b, B:445:0x0e8c, B:441:0x0e5a, B:443:0x0e68, B:444:0x0e75, B:446:0x0e9b, B:447:0x0eb4, B:450:0x0ebc, B:451:0x0ec1, B:452:0x0ed1, B:454:0x0eeb, B:455:0x0f06, B:456:0x0f0e, B:460:0x0f2c, B:459:0x0f19, B:414:0x0d95, B:416:0x0d9b, B:418:0x0dab, B:420:0x0db2, B:426:0x0dc8, B:428:0x0dcf, B:430:0x0e1a, B:432:0x0e21, B:431:0x0e1e, B:427:0x0dcc, B:419:0x0daf, B:282:0x08fd, B:284:0x0903, B:286:0x0909, B:266:0x0831, B:262:0x0802, B:256:0x07af, B:258:0x07b5, B:461:0x0f35), top: B:471:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x041f A[Catch: all -> 0x011d, TryCatch #2 {all -> 0x011d, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00dd, B:20:0x00f6, B:22:0x0100, B:227:0x0708, B:26:0x0130, B:29:0x0142, B:31:0x0148, B:46:0x018c, B:48:0x019e, B:51:0x01c3, B:53:0x01c9, B:55:0x01d9, B:57:0x01e7, B:59:0x01f7, B:60:0x0202, B:61:0x0205, B:64:0x021d, B:73:0x024e, B:76:0x0258, B:78:0x0266, B:83:0x02c1, B:80:0x028e, B:82:0x02a0, B:87:0x02d0, B:89:0x02f6, B:90:0x031a, B:92:0x034f, B:94:0x0355, B:97:0x0361, B:99:0x0396, B:100:0x03b1, B:102:0x03b7, B:104:0x03c5, B:108:0x03d9, B:105:0x03cd, B:111:0x03e0, B:114:0x03e7, B:115:0x0406, B:117:0x041f, B:118:0x042b, B:121:0x0435, B:127:0x0458, B:124:0x0447, B:149:0x04d2, B:151:0x04de, B:154:0x04ef, B:156:0x0500, B:158:0x050c, B:193:0x05d7, B:195:0x05dd, B:196:0x05e9, B:198:0x05ef, B:200:0x05ff, B:202:0x0609, B:203:0x061c, B:205:0x0622, B:206:0x063b, B:208:0x0641, B:209:0x065f, B:210:0x066d, B:214:0x0694, B:211:0x0673, B:213:0x067f, B:215:0x069b, B:216:0x06b8, B:218:0x06be, B:220:0x06d1, B:221:0x06de, B:222:0x06e2, B:224:0x06e8, B:226:0x06f4, B:163:0x0529, B:165:0x0537, B:168:0x054a, B:170:0x055b, B:172:0x0567, B:174:0x0577, B:176:0x0586, B:179:0x0592, B:181:0x059c, B:183:0x05a6, B:186:0x05b1, B:188:0x05b7, B:190:0x05c7, B:191:0x05d2, B:131:0x0460, B:133:0x046c, B:135:0x0478, B:148:0x04bc, B:140:0x0494, B:143:0x04a6, B:145:0x04ac, B:147:0x04b6, B:35:0x0152, B:37:0x015f, B:39:0x016d, B:41:0x0173, B:45:0x017e, B:230:0x0722, B:232:0x0734, B:234:0x073d, B:245:0x076d, B:235:0x0745, B:237:0x074e, B:239:0x0754, B:242:0x0760, B:244:0x0768, B:246:0x0770, B:247:0x077c, B:250:0x0784, B:252:0x0796, B:253:0x07a1, B:255:0x07a9, B:259:0x07d6, B:261:0x07f2, B:263:0x0805, B:265:0x0821, B:267:0x0834, B:268:0x0850, B:270:0x0856, B:272:0x086e, B:273:0x087c, B:275:0x088c, B:276:0x089a, B:277:0x089d, B:279:0x08e7, B:281:0x08ed, B:287:0x0918, B:289:0x0920, B:290:0x093e, B:292:0x0944, B:293:0x0958, B:295:0x096f, B:297:0x0980, B:299:0x0992, B:301:0x099c, B:302:0x099f, B:304:0x09fa, B:305:0x0a0d, B:308:0x0a15, B:311:0x0a34, B:313:0x0a4d, B:315:0x0a64, B:318:0x0a6c, B:320:0x0a70, B:322:0x0a74, B:324:0x0a7e, B:326:0x0a87, B:328:0x0a8b, B:330:0x0a91, B:332:0x0a9c, B:334:0x0aaa, B:400:0x0d10, B:337:0x0ab5, B:339:0x0ad3, B:344:0x0aee, B:346:0x0b10, B:347:0x0b18, B:349:0x0b1e, B:351:0x0b30, B:357:0x0b57, B:358:0x0b78, B:360:0x0b84, B:362:0x0b9c, B:364:0x0bdd, B:370:0x0bf9, B:372:0x0c04, B:374:0x0c08, B:376:0x0c0c, B:378:0x0c10, B:379:0x0c1c, B:380:0x0c23, B:382:0x0c29, B:384:0x0c41, B:385:0x0c46, B:399:0x0d0d, B:386:0x0c84, B:388:0x0c8a, B:392:0x0c9d, B:394:0x0cb9, B:395:0x0cc0, B:398:0x0d01, B:389:0x0c8f, B:355:0x0b41, B:342:0x0ad9, B:401:0x0d1c, B:403:0x0d2c, B:404:0x0d40, B:405:0x0d48, B:407:0x0d4e, B:410:0x0d69, B:412:0x0d7b, B:433:0x0e29, B:435:0x0e2f, B:437:0x0e44, B:440:0x0e4b, B:445:0x0e8c, B:441:0x0e5a, B:443:0x0e68, B:444:0x0e75, B:446:0x0e9b, B:447:0x0eb4, B:450:0x0ebc, B:451:0x0ec1, B:452:0x0ed1, B:454:0x0eeb, B:455:0x0f06, B:456:0x0f0e, B:460:0x0f2c, B:459:0x0f19, B:414:0x0d95, B:416:0x0d9b, B:418:0x0dab, B:420:0x0db2, B:426:0x0dc8, B:428:0x0dcf, B:430:0x0e1a, B:432:0x0e21, B:431:0x0e1e, B:427:0x0dcc, B:419:0x0daf, B:282:0x08fd, B:284:0x0903, B:286:0x0909, B:266:0x0831, B:262:0x0802, B:256:0x07af, B:258:0x07b5, B:461:0x0f35), top: B:471:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04de A[Catch: all -> 0x011d, TryCatch #2 {all -> 0x011d, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00dd, B:20:0x00f6, B:22:0x0100, B:227:0x0708, B:26:0x0130, B:29:0x0142, B:31:0x0148, B:46:0x018c, B:48:0x019e, B:51:0x01c3, B:53:0x01c9, B:55:0x01d9, B:57:0x01e7, B:59:0x01f7, B:60:0x0202, B:61:0x0205, B:64:0x021d, B:73:0x024e, B:76:0x0258, B:78:0x0266, B:83:0x02c1, B:80:0x028e, B:82:0x02a0, B:87:0x02d0, B:89:0x02f6, B:90:0x031a, B:92:0x034f, B:94:0x0355, B:97:0x0361, B:99:0x0396, B:100:0x03b1, B:102:0x03b7, B:104:0x03c5, B:108:0x03d9, B:105:0x03cd, B:111:0x03e0, B:114:0x03e7, B:115:0x0406, B:117:0x041f, B:118:0x042b, B:121:0x0435, B:127:0x0458, B:124:0x0447, B:149:0x04d2, B:151:0x04de, B:154:0x04ef, B:156:0x0500, B:158:0x050c, B:193:0x05d7, B:195:0x05dd, B:196:0x05e9, B:198:0x05ef, B:200:0x05ff, B:202:0x0609, B:203:0x061c, B:205:0x0622, B:206:0x063b, B:208:0x0641, B:209:0x065f, B:210:0x066d, B:214:0x0694, B:211:0x0673, B:213:0x067f, B:215:0x069b, B:216:0x06b8, B:218:0x06be, B:220:0x06d1, B:221:0x06de, B:222:0x06e2, B:224:0x06e8, B:226:0x06f4, B:163:0x0529, B:165:0x0537, B:168:0x054a, B:170:0x055b, B:172:0x0567, B:174:0x0577, B:176:0x0586, B:179:0x0592, B:181:0x059c, B:183:0x05a6, B:186:0x05b1, B:188:0x05b7, B:190:0x05c7, B:191:0x05d2, B:131:0x0460, B:133:0x046c, B:135:0x0478, B:148:0x04bc, B:140:0x0494, B:143:0x04a6, B:145:0x04ac, B:147:0x04b6, B:35:0x0152, B:37:0x015f, B:39:0x016d, B:41:0x0173, B:45:0x017e, B:230:0x0722, B:232:0x0734, B:234:0x073d, B:245:0x076d, B:235:0x0745, B:237:0x074e, B:239:0x0754, B:242:0x0760, B:244:0x0768, B:246:0x0770, B:247:0x077c, B:250:0x0784, B:252:0x0796, B:253:0x07a1, B:255:0x07a9, B:259:0x07d6, B:261:0x07f2, B:263:0x0805, B:265:0x0821, B:267:0x0834, B:268:0x0850, B:270:0x0856, B:272:0x086e, B:273:0x087c, B:275:0x088c, B:276:0x089a, B:277:0x089d, B:279:0x08e7, B:281:0x08ed, B:287:0x0918, B:289:0x0920, B:290:0x093e, B:292:0x0944, B:293:0x0958, B:295:0x096f, B:297:0x0980, B:299:0x0992, B:301:0x099c, B:302:0x099f, B:304:0x09fa, B:305:0x0a0d, B:308:0x0a15, B:311:0x0a34, B:313:0x0a4d, B:315:0x0a64, B:318:0x0a6c, B:320:0x0a70, B:322:0x0a74, B:324:0x0a7e, B:326:0x0a87, B:328:0x0a8b, B:330:0x0a91, B:332:0x0a9c, B:334:0x0aaa, B:400:0x0d10, B:337:0x0ab5, B:339:0x0ad3, B:344:0x0aee, B:346:0x0b10, B:347:0x0b18, B:349:0x0b1e, B:351:0x0b30, B:357:0x0b57, B:358:0x0b78, B:360:0x0b84, B:362:0x0b9c, B:364:0x0bdd, B:370:0x0bf9, B:372:0x0c04, B:374:0x0c08, B:376:0x0c0c, B:378:0x0c10, B:379:0x0c1c, B:380:0x0c23, B:382:0x0c29, B:384:0x0c41, B:385:0x0c46, B:399:0x0d0d, B:386:0x0c84, B:388:0x0c8a, B:392:0x0c9d, B:394:0x0cb9, B:395:0x0cc0, B:398:0x0d01, B:389:0x0c8f, B:355:0x0b41, B:342:0x0ad9, B:401:0x0d1c, B:403:0x0d2c, B:404:0x0d40, B:405:0x0d48, B:407:0x0d4e, B:410:0x0d69, B:412:0x0d7b, B:433:0x0e29, B:435:0x0e2f, B:437:0x0e44, B:440:0x0e4b, B:445:0x0e8c, B:441:0x0e5a, B:443:0x0e68, B:444:0x0e75, B:446:0x0e9b, B:447:0x0eb4, B:450:0x0ebc, B:451:0x0ec1, B:452:0x0ed1, B:454:0x0eeb, B:455:0x0f06, B:456:0x0f0e, B:460:0x0f2c, B:459:0x0f19, B:414:0x0d95, B:416:0x0d9b, B:418:0x0dab, B:420:0x0db2, B:426:0x0dc8, B:428:0x0dcf, B:430:0x0e1a, B:432:0x0e21, B:431:0x0e1e, B:427:0x0dcc, B:419:0x0daf, B:282:0x08fd, B:284:0x0903, B:286:0x0909, B:266:0x0831, B:262:0x0802, B:256:0x07af, B:258:0x07b5, B:461:0x0f35), top: B:471:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0529 A[Catch: all -> 0x011d, TryCatch #2 {all -> 0x011d, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00dd, B:20:0x00f6, B:22:0x0100, B:227:0x0708, B:26:0x0130, B:29:0x0142, B:31:0x0148, B:46:0x018c, B:48:0x019e, B:51:0x01c3, B:53:0x01c9, B:55:0x01d9, B:57:0x01e7, B:59:0x01f7, B:60:0x0202, B:61:0x0205, B:64:0x021d, B:73:0x024e, B:76:0x0258, B:78:0x0266, B:83:0x02c1, B:80:0x028e, B:82:0x02a0, B:87:0x02d0, B:89:0x02f6, B:90:0x031a, B:92:0x034f, B:94:0x0355, B:97:0x0361, B:99:0x0396, B:100:0x03b1, B:102:0x03b7, B:104:0x03c5, B:108:0x03d9, B:105:0x03cd, B:111:0x03e0, B:114:0x03e7, B:115:0x0406, B:117:0x041f, B:118:0x042b, B:121:0x0435, B:127:0x0458, B:124:0x0447, B:149:0x04d2, B:151:0x04de, B:154:0x04ef, B:156:0x0500, B:158:0x050c, B:193:0x05d7, B:195:0x05dd, B:196:0x05e9, B:198:0x05ef, B:200:0x05ff, B:202:0x0609, B:203:0x061c, B:205:0x0622, B:206:0x063b, B:208:0x0641, B:209:0x065f, B:210:0x066d, B:214:0x0694, B:211:0x0673, B:213:0x067f, B:215:0x069b, B:216:0x06b8, B:218:0x06be, B:220:0x06d1, B:221:0x06de, B:222:0x06e2, B:224:0x06e8, B:226:0x06f4, B:163:0x0529, B:165:0x0537, B:168:0x054a, B:170:0x055b, B:172:0x0567, B:174:0x0577, B:176:0x0586, B:179:0x0592, B:181:0x059c, B:183:0x05a6, B:186:0x05b1, B:188:0x05b7, B:190:0x05c7, B:191:0x05d2, B:131:0x0460, B:133:0x046c, B:135:0x0478, B:148:0x04bc, B:140:0x0494, B:143:0x04a6, B:145:0x04ac, B:147:0x04b6, B:35:0x0152, B:37:0x015f, B:39:0x016d, B:41:0x0173, B:45:0x017e, B:230:0x0722, B:232:0x0734, B:234:0x073d, B:245:0x076d, B:235:0x0745, B:237:0x074e, B:239:0x0754, B:242:0x0760, B:244:0x0768, B:246:0x0770, B:247:0x077c, B:250:0x0784, B:252:0x0796, B:253:0x07a1, B:255:0x07a9, B:259:0x07d6, B:261:0x07f2, B:263:0x0805, B:265:0x0821, B:267:0x0834, B:268:0x0850, B:270:0x0856, B:272:0x086e, B:273:0x087c, B:275:0x088c, B:276:0x089a, B:277:0x089d, B:279:0x08e7, B:281:0x08ed, B:287:0x0918, B:289:0x0920, B:290:0x093e, B:292:0x0944, B:293:0x0958, B:295:0x096f, B:297:0x0980, B:299:0x0992, B:301:0x099c, B:302:0x099f, B:304:0x09fa, B:305:0x0a0d, B:308:0x0a15, B:311:0x0a34, B:313:0x0a4d, B:315:0x0a64, B:318:0x0a6c, B:320:0x0a70, B:322:0x0a74, B:324:0x0a7e, B:326:0x0a87, B:328:0x0a8b, B:330:0x0a91, B:332:0x0a9c, B:334:0x0aaa, B:400:0x0d10, B:337:0x0ab5, B:339:0x0ad3, B:344:0x0aee, B:346:0x0b10, B:347:0x0b18, B:349:0x0b1e, B:351:0x0b30, B:357:0x0b57, B:358:0x0b78, B:360:0x0b84, B:362:0x0b9c, B:364:0x0bdd, B:370:0x0bf9, B:372:0x0c04, B:374:0x0c08, B:376:0x0c0c, B:378:0x0c10, B:379:0x0c1c, B:380:0x0c23, B:382:0x0c29, B:384:0x0c41, B:385:0x0c46, B:399:0x0d0d, B:386:0x0c84, B:388:0x0c8a, B:392:0x0c9d, B:394:0x0cb9, B:395:0x0cc0, B:398:0x0d01, B:389:0x0c8f, B:355:0x0b41, B:342:0x0ad9, B:401:0x0d1c, B:403:0x0d2c, B:404:0x0d40, B:405:0x0d48, B:407:0x0d4e, B:410:0x0d69, B:412:0x0d7b, B:433:0x0e29, B:435:0x0e2f, B:437:0x0e44, B:440:0x0e4b, B:445:0x0e8c, B:441:0x0e5a, B:443:0x0e68, B:444:0x0e75, B:446:0x0e9b, B:447:0x0eb4, B:450:0x0ebc, B:451:0x0ec1, B:452:0x0ed1, B:454:0x0eeb, B:455:0x0f06, B:456:0x0f0e, B:460:0x0f2c, B:459:0x0f19, B:414:0x0d95, B:416:0x0d9b, B:418:0x0dab, B:420:0x0db2, B:426:0x0dc8, B:428:0x0dcf, B:430:0x0e1a, B:432:0x0e21, B:431:0x0e1e, B:427:0x0dcc, B:419:0x0daf, B:282:0x08fd, B:284:0x0903, B:286:0x0909, B:266:0x0831, B:262:0x0802, B:256:0x07af, B:258:0x07b5, B:461:0x0f35), top: B:471:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05dd A[Catch: all -> 0x011d, TryCatch #2 {all -> 0x011d, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00dd, B:20:0x00f6, B:22:0x0100, B:227:0x0708, B:26:0x0130, B:29:0x0142, B:31:0x0148, B:46:0x018c, B:48:0x019e, B:51:0x01c3, B:53:0x01c9, B:55:0x01d9, B:57:0x01e7, B:59:0x01f7, B:60:0x0202, B:61:0x0205, B:64:0x021d, B:73:0x024e, B:76:0x0258, B:78:0x0266, B:83:0x02c1, B:80:0x028e, B:82:0x02a0, B:87:0x02d0, B:89:0x02f6, B:90:0x031a, B:92:0x034f, B:94:0x0355, B:97:0x0361, B:99:0x0396, B:100:0x03b1, B:102:0x03b7, B:104:0x03c5, B:108:0x03d9, B:105:0x03cd, B:111:0x03e0, B:114:0x03e7, B:115:0x0406, B:117:0x041f, B:118:0x042b, B:121:0x0435, B:127:0x0458, B:124:0x0447, B:149:0x04d2, B:151:0x04de, B:154:0x04ef, B:156:0x0500, B:158:0x050c, B:193:0x05d7, B:195:0x05dd, B:196:0x05e9, B:198:0x05ef, B:200:0x05ff, B:202:0x0609, B:203:0x061c, B:205:0x0622, B:206:0x063b, B:208:0x0641, B:209:0x065f, B:210:0x066d, B:214:0x0694, B:211:0x0673, B:213:0x067f, B:215:0x069b, B:216:0x06b8, B:218:0x06be, B:220:0x06d1, B:221:0x06de, B:222:0x06e2, B:224:0x06e8, B:226:0x06f4, B:163:0x0529, B:165:0x0537, B:168:0x054a, B:170:0x055b, B:172:0x0567, B:174:0x0577, B:176:0x0586, B:179:0x0592, B:181:0x059c, B:183:0x05a6, B:186:0x05b1, B:188:0x05b7, B:190:0x05c7, B:191:0x05d2, B:131:0x0460, B:133:0x046c, B:135:0x0478, B:148:0x04bc, B:140:0x0494, B:143:0x04a6, B:145:0x04ac, B:147:0x04b6, B:35:0x0152, B:37:0x015f, B:39:0x016d, B:41:0x0173, B:45:0x017e, B:230:0x0722, B:232:0x0734, B:234:0x073d, B:245:0x076d, B:235:0x0745, B:237:0x074e, B:239:0x0754, B:242:0x0760, B:244:0x0768, B:246:0x0770, B:247:0x077c, B:250:0x0784, B:252:0x0796, B:253:0x07a1, B:255:0x07a9, B:259:0x07d6, B:261:0x07f2, B:263:0x0805, B:265:0x0821, B:267:0x0834, B:268:0x0850, B:270:0x0856, B:272:0x086e, B:273:0x087c, B:275:0x088c, B:276:0x089a, B:277:0x089d, B:279:0x08e7, B:281:0x08ed, B:287:0x0918, B:289:0x0920, B:290:0x093e, B:292:0x0944, B:293:0x0958, B:295:0x096f, B:297:0x0980, B:299:0x0992, B:301:0x099c, B:302:0x099f, B:304:0x09fa, B:305:0x0a0d, B:308:0x0a15, B:311:0x0a34, B:313:0x0a4d, B:315:0x0a64, B:318:0x0a6c, B:320:0x0a70, B:322:0x0a74, B:324:0x0a7e, B:326:0x0a87, B:328:0x0a8b, B:330:0x0a91, B:332:0x0a9c, B:334:0x0aaa, B:400:0x0d10, B:337:0x0ab5, B:339:0x0ad3, B:344:0x0aee, B:346:0x0b10, B:347:0x0b18, B:349:0x0b1e, B:351:0x0b30, B:357:0x0b57, B:358:0x0b78, B:360:0x0b84, B:362:0x0b9c, B:364:0x0bdd, B:370:0x0bf9, B:372:0x0c04, B:374:0x0c08, B:376:0x0c0c, B:378:0x0c10, B:379:0x0c1c, B:380:0x0c23, B:382:0x0c29, B:384:0x0c41, B:385:0x0c46, B:399:0x0d0d, B:386:0x0c84, B:388:0x0c8a, B:392:0x0c9d, B:394:0x0cb9, B:395:0x0cc0, B:398:0x0d01, B:389:0x0c8f, B:355:0x0b41, B:342:0x0ad9, B:401:0x0d1c, B:403:0x0d2c, B:404:0x0d40, B:405:0x0d48, B:407:0x0d4e, B:410:0x0d69, B:412:0x0d7b, B:433:0x0e29, B:435:0x0e2f, B:437:0x0e44, B:440:0x0e4b, B:445:0x0e8c, B:441:0x0e5a, B:443:0x0e68, B:444:0x0e75, B:446:0x0e9b, B:447:0x0eb4, B:450:0x0ebc, B:451:0x0ec1, B:452:0x0ed1, B:454:0x0eeb, B:455:0x0f06, B:456:0x0f0e, B:460:0x0f2c, B:459:0x0f19, B:414:0x0d95, B:416:0x0d9b, B:418:0x0dab, B:420:0x0db2, B:426:0x0dc8, B:428:0x0dcf, B:430:0x0e1a, B:432:0x0e21, B:431:0x0e1e, B:427:0x0dcc, B:419:0x0daf, B:282:0x08fd, B:284:0x0903, B:286:0x0909, B:266:0x0831, B:262:0x0802, B:256:0x07af, B:258:0x07b5, B:461:0x0f35), top: B:471:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x06f2  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0745 A[Catch: all -> 0x011d, TryCatch #2 {all -> 0x011d, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00dd, B:20:0x00f6, B:22:0x0100, B:227:0x0708, B:26:0x0130, B:29:0x0142, B:31:0x0148, B:46:0x018c, B:48:0x019e, B:51:0x01c3, B:53:0x01c9, B:55:0x01d9, B:57:0x01e7, B:59:0x01f7, B:60:0x0202, B:61:0x0205, B:64:0x021d, B:73:0x024e, B:76:0x0258, B:78:0x0266, B:83:0x02c1, B:80:0x028e, B:82:0x02a0, B:87:0x02d0, B:89:0x02f6, B:90:0x031a, B:92:0x034f, B:94:0x0355, B:97:0x0361, B:99:0x0396, B:100:0x03b1, B:102:0x03b7, B:104:0x03c5, B:108:0x03d9, B:105:0x03cd, B:111:0x03e0, B:114:0x03e7, B:115:0x0406, B:117:0x041f, B:118:0x042b, B:121:0x0435, B:127:0x0458, B:124:0x0447, B:149:0x04d2, B:151:0x04de, B:154:0x04ef, B:156:0x0500, B:158:0x050c, B:193:0x05d7, B:195:0x05dd, B:196:0x05e9, B:198:0x05ef, B:200:0x05ff, B:202:0x0609, B:203:0x061c, B:205:0x0622, B:206:0x063b, B:208:0x0641, B:209:0x065f, B:210:0x066d, B:214:0x0694, B:211:0x0673, B:213:0x067f, B:215:0x069b, B:216:0x06b8, B:218:0x06be, B:220:0x06d1, B:221:0x06de, B:222:0x06e2, B:224:0x06e8, B:226:0x06f4, B:163:0x0529, B:165:0x0537, B:168:0x054a, B:170:0x055b, B:172:0x0567, B:174:0x0577, B:176:0x0586, B:179:0x0592, B:181:0x059c, B:183:0x05a6, B:186:0x05b1, B:188:0x05b7, B:190:0x05c7, B:191:0x05d2, B:131:0x0460, B:133:0x046c, B:135:0x0478, B:148:0x04bc, B:140:0x0494, B:143:0x04a6, B:145:0x04ac, B:147:0x04b6, B:35:0x0152, B:37:0x015f, B:39:0x016d, B:41:0x0173, B:45:0x017e, B:230:0x0722, B:232:0x0734, B:234:0x073d, B:245:0x076d, B:235:0x0745, B:237:0x074e, B:239:0x0754, B:242:0x0760, B:244:0x0768, B:246:0x0770, B:247:0x077c, B:250:0x0784, B:252:0x0796, B:253:0x07a1, B:255:0x07a9, B:259:0x07d6, B:261:0x07f2, B:263:0x0805, B:265:0x0821, B:267:0x0834, B:268:0x0850, B:270:0x0856, B:272:0x086e, B:273:0x087c, B:275:0x088c, B:276:0x089a, B:277:0x089d, B:279:0x08e7, B:281:0x08ed, B:287:0x0918, B:289:0x0920, B:290:0x093e, B:292:0x0944, B:293:0x0958, B:295:0x096f, B:297:0x0980, B:299:0x0992, B:301:0x099c, B:302:0x099f, B:304:0x09fa, B:305:0x0a0d, B:308:0x0a15, B:311:0x0a34, B:313:0x0a4d, B:315:0x0a64, B:318:0x0a6c, B:320:0x0a70, B:322:0x0a74, B:324:0x0a7e, B:326:0x0a87, B:328:0x0a8b, B:330:0x0a91, B:332:0x0a9c, B:334:0x0aaa, B:400:0x0d10, B:337:0x0ab5, B:339:0x0ad3, B:344:0x0aee, B:346:0x0b10, B:347:0x0b18, B:349:0x0b1e, B:351:0x0b30, B:357:0x0b57, B:358:0x0b78, B:360:0x0b84, B:362:0x0b9c, B:364:0x0bdd, B:370:0x0bf9, B:372:0x0c04, B:374:0x0c08, B:376:0x0c0c, B:378:0x0c10, B:379:0x0c1c, B:380:0x0c23, B:382:0x0c29, B:384:0x0c41, B:385:0x0c46, B:399:0x0d0d, B:386:0x0c84, B:388:0x0c8a, B:392:0x0c9d, B:394:0x0cb9, B:395:0x0cc0, B:398:0x0d01, B:389:0x0c8f, B:355:0x0b41, B:342:0x0ad9, B:401:0x0d1c, B:403:0x0d2c, B:404:0x0d40, B:405:0x0d48, B:407:0x0d4e, B:410:0x0d69, B:412:0x0d7b, B:433:0x0e29, B:435:0x0e2f, B:437:0x0e44, B:440:0x0e4b, B:445:0x0e8c, B:441:0x0e5a, B:443:0x0e68, B:444:0x0e75, B:446:0x0e9b, B:447:0x0eb4, B:450:0x0ebc, B:451:0x0ec1, B:452:0x0ed1, B:454:0x0eeb, B:455:0x0f06, B:456:0x0f0e, B:460:0x0f2c, B:459:0x0f19, B:414:0x0d95, B:416:0x0d9b, B:418:0x0dab, B:420:0x0db2, B:426:0x0dc8, B:428:0x0dcf, B:430:0x0e1a, B:432:0x0e21, B:431:0x0e1e, B:427:0x0dcc, B:419:0x0daf, B:282:0x08fd, B:284:0x0903, B:286:0x0909, B:266:0x0831, B:262:0x0802, B:256:0x07af, B:258:0x07b5, B:461:0x0f35), top: B:471:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0b10 A[Catch: all -> 0x011d, TryCatch #2 {all -> 0x011d, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00dd, B:20:0x00f6, B:22:0x0100, B:227:0x0708, B:26:0x0130, B:29:0x0142, B:31:0x0148, B:46:0x018c, B:48:0x019e, B:51:0x01c3, B:53:0x01c9, B:55:0x01d9, B:57:0x01e7, B:59:0x01f7, B:60:0x0202, B:61:0x0205, B:64:0x021d, B:73:0x024e, B:76:0x0258, B:78:0x0266, B:83:0x02c1, B:80:0x028e, B:82:0x02a0, B:87:0x02d0, B:89:0x02f6, B:90:0x031a, B:92:0x034f, B:94:0x0355, B:97:0x0361, B:99:0x0396, B:100:0x03b1, B:102:0x03b7, B:104:0x03c5, B:108:0x03d9, B:105:0x03cd, B:111:0x03e0, B:114:0x03e7, B:115:0x0406, B:117:0x041f, B:118:0x042b, B:121:0x0435, B:127:0x0458, B:124:0x0447, B:149:0x04d2, B:151:0x04de, B:154:0x04ef, B:156:0x0500, B:158:0x050c, B:193:0x05d7, B:195:0x05dd, B:196:0x05e9, B:198:0x05ef, B:200:0x05ff, B:202:0x0609, B:203:0x061c, B:205:0x0622, B:206:0x063b, B:208:0x0641, B:209:0x065f, B:210:0x066d, B:214:0x0694, B:211:0x0673, B:213:0x067f, B:215:0x069b, B:216:0x06b8, B:218:0x06be, B:220:0x06d1, B:221:0x06de, B:222:0x06e2, B:224:0x06e8, B:226:0x06f4, B:163:0x0529, B:165:0x0537, B:168:0x054a, B:170:0x055b, B:172:0x0567, B:174:0x0577, B:176:0x0586, B:179:0x0592, B:181:0x059c, B:183:0x05a6, B:186:0x05b1, B:188:0x05b7, B:190:0x05c7, B:191:0x05d2, B:131:0x0460, B:133:0x046c, B:135:0x0478, B:148:0x04bc, B:140:0x0494, B:143:0x04a6, B:145:0x04ac, B:147:0x04b6, B:35:0x0152, B:37:0x015f, B:39:0x016d, B:41:0x0173, B:45:0x017e, B:230:0x0722, B:232:0x0734, B:234:0x073d, B:245:0x076d, B:235:0x0745, B:237:0x074e, B:239:0x0754, B:242:0x0760, B:244:0x0768, B:246:0x0770, B:247:0x077c, B:250:0x0784, B:252:0x0796, B:253:0x07a1, B:255:0x07a9, B:259:0x07d6, B:261:0x07f2, B:263:0x0805, B:265:0x0821, B:267:0x0834, B:268:0x0850, B:270:0x0856, B:272:0x086e, B:273:0x087c, B:275:0x088c, B:276:0x089a, B:277:0x089d, B:279:0x08e7, B:281:0x08ed, B:287:0x0918, B:289:0x0920, B:290:0x093e, B:292:0x0944, B:293:0x0958, B:295:0x096f, B:297:0x0980, B:299:0x0992, B:301:0x099c, B:302:0x099f, B:304:0x09fa, B:305:0x0a0d, B:308:0x0a15, B:311:0x0a34, B:313:0x0a4d, B:315:0x0a64, B:318:0x0a6c, B:320:0x0a70, B:322:0x0a74, B:324:0x0a7e, B:326:0x0a87, B:328:0x0a8b, B:330:0x0a91, B:332:0x0a9c, B:334:0x0aaa, B:400:0x0d10, B:337:0x0ab5, B:339:0x0ad3, B:344:0x0aee, B:346:0x0b10, B:347:0x0b18, B:349:0x0b1e, B:351:0x0b30, B:357:0x0b57, B:358:0x0b78, B:360:0x0b84, B:362:0x0b9c, B:364:0x0bdd, B:370:0x0bf9, B:372:0x0c04, B:374:0x0c08, B:376:0x0c0c, B:378:0x0c10, B:379:0x0c1c, B:380:0x0c23, B:382:0x0c29, B:384:0x0c41, B:385:0x0c46, B:399:0x0d0d, B:386:0x0c84, B:388:0x0c8a, B:392:0x0c9d, B:394:0x0cb9, B:395:0x0cc0, B:398:0x0d01, B:389:0x0c8f, B:355:0x0b41, B:342:0x0ad9, B:401:0x0d1c, B:403:0x0d2c, B:404:0x0d40, B:405:0x0d48, B:407:0x0d4e, B:410:0x0d69, B:412:0x0d7b, B:433:0x0e29, B:435:0x0e2f, B:437:0x0e44, B:440:0x0e4b, B:445:0x0e8c, B:441:0x0e5a, B:443:0x0e68, B:444:0x0e75, B:446:0x0e9b, B:447:0x0eb4, B:450:0x0ebc, B:451:0x0ec1, B:452:0x0ed1, B:454:0x0eeb, B:455:0x0f06, B:456:0x0f0e, B:460:0x0f2c, B:459:0x0f19, B:414:0x0d95, B:416:0x0d9b, B:418:0x0dab, B:420:0x0db2, B:426:0x0dc8, B:428:0x0dcf, B:430:0x0e1a, B:432:0x0e21, B:431:0x0e1e, B:427:0x0dcc, B:419:0x0daf, B:282:0x08fd, B:284:0x0903, B:286:0x0909, B:266:0x0831, B:262:0x0802, B:256:0x07af, B:258:0x07b5, B:461:0x0f35), top: B:471:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0b41 A[Catch: all -> 0x011d, EDGE_INSN: B:522:0x0b41->B:355:0x0b41 BREAK  A[LOOP:16: B:347:0x0b18->B:524:?], TryCatch #2 {all -> 0x011d, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00dd, B:20:0x00f6, B:22:0x0100, B:227:0x0708, B:26:0x0130, B:29:0x0142, B:31:0x0148, B:46:0x018c, B:48:0x019e, B:51:0x01c3, B:53:0x01c9, B:55:0x01d9, B:57:0x01e7, B:59:0x01f7, B:60:0x0202, B:61:0x0205, B:64:0x021d, B:73:0x024e, B:76:0x0258, B:78:0x0266, B:83:0x02c1, B:80:0x028e, B:82:0x02a0, B:87:0x02d0, B:89:0x02f6, B:90:0x031a, B:92:0x034f, B:94:0x0355, B:97:0x0361, B:99:0x0396, B:100:0x03b1, B:102:0x03b7, B:104:0x03c5, B:108:0x03d9, B:105:0x03cd, B:111:0x03e0, B:114:0x03e7, B:115:0x0406, B:117:0x041f, B:118:0x042b, B:121:0x0435, B:127:0x0458, B:124:0x0447, B:149:0x04d2, B:151:0x04de, B:154:0x04ef, B:156:0x0500, B:158:0x050c, B:193:0x05d7, B:195:0x05dd, B:196:0x05e9, B:198:0x05ef, B:200:0x05ff, B:202:0x0609, B:203:0x061c, B:205:0x0622, B:206:0x063b, B:208:0x0641, B:209:0x065f, B:210:0x066d, B:214:0x0694, B:211:0x0673, B:213:0x067f, B:215:0x069b, B:216:0x06b8, B:218:0x06be, B:220:0x06d1, B:221:0x06de, B:222:0x06e2, B:224:0x06e8, B:226:0x06f4, B:163:0x0529, B:165:0x0537, B:168:0x054a, B:170:0x055b, B:172:0x0567, B:174:0x0577, B:176:0x0586, B:179:0x0592, B:181:0x059c, B:183:0x05a6, B:186:0x05b1, B:188:0x05b7, B:190:0x05c7, B:191:0x05d2, B:131:0x0460, B:133:0x046c, B:135:0x0478, B:148:0x04bc, B:140:0x0494, B:143:0x04a6, B:145:0x04ac, B:147:0x04b6, B:35:0x0152, B:37:0x015f, B:39:0x016d, B:41:0x0173, B:45:0x017e, B:230:0x0722, B:232:0x0734, B:234:0x073d, B:245:0x076d, B:235:0x0745, B:237:0x074e, B:239:0x0754, B:242:0x0760, B:244:0x0768, B:246:0x0770, B:247:0x077c, B:250:0x0784, B:252:0x0796, B:253:0x07a1, B:255:0x07a9, B:259:0x07d6, B:261:0x07f2, B:263:0x0805, B:265:0x0821, B:267:0x0834, B:268:0x0850, B:270:0x0856, B:272:0x086e, B:273:0x087c, B:275:0x088c, B:276:0x089a, B:277:0x089d, B:279:0x08e7, B:281:0x08ed, B:287:0x0918, B:289:0x0920, B:290:0x093e, B:292:0x0944, B:293:0x0958, B:295:0x096f, B:297:0x0980, B:299:0x0992, B:301:0x099c, B:302:0x099f, B:304:0x09fa, B:305:0x0a0d, B:308:0x0a15, B:311:0x0a34, B:313:0x0a4d, B:315:0x0a64, B:318:0x0a6c, B:320:0x0a70, B:322:0x0a74, B:324:0x0a7e, B:326:0x0a87, B:328:0x0a8b, B:330:0x0a91, B:332:0x0a9c, B:334:0x0aaa, B:400:0x0d10, B:337:0x0ab5, B:339:0x0ad3, B:344:0x0aee, B:346:0x0b10, B:347:0x0b18, B:349:0x0b1e, B:351:0x0b30, B:357:0x0b57, B:358:0x0b78, B:360:0x0b84, B:362:0x0b9c, B:364:0x0bdd, B:370:0x0bf9, B:372:0x0c04, B:374:0x0c08, B:376:0x0c0c, B:378:0x0c10, B:379:0x0c1c, B:380:0x0c23, B:382:0x0c29, B:384:0x0c41, B:385:0x0c46, B:399:0x0d0d, B:386:0x0c84, B:388:0x0c8a, B:392:0x0c9d, B:394:0x0cb9, B:395:0x0cc0, B:398:0x0d01, B:389:0x0c8f, B:355:0x0b41, B:342:0x0ad9, B:401:0x0d1c, B:403:0x0d2c, B:404:0x0d40, B:405:0x0d48, B:407:0x0d4e, B:410:0x0d69, B:412:0x0d7b, B:433:0x0e29, B:435:0x0e2f, B:437:0x0e44, B:440:0x0e4b, B:445:0x0e8c, B:441:0x0e5a, B:443:0x0e68, B:444:0x0e75, B:446:0x0e9b, B:447:0x0eb4, B:450:0x0ebc, B:451:0x0ec1, B:452:0x0ed1, B:454:0x0eeb, B:455:0x0f06, B:456:0x0f0e, B:460:0x0f2c, B:459:0x0f19, B:414:0x0d95, B:416:0x0d9b, B:418:0x0dab, B:420:0x0db2, B:426:0x0dc8, B:428:0x0dcf, B:430:0x0e1a, B:432:0x0e21, B:431:0x0e1e, B:427:0x0dcc, B:419:0x0daf, B:282:0x08fd, B:284:0x0903, B:286:0x0909, B:266:0x0831, B:262:0x0802, B:256:0x07af, B:258:0x07b5, B:461:0x0f35), top: B:471:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0b57 A[Catch: all -> 0x011d, TryCatch #2 {all -> 0x011d, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00dd, B:20:0x00f6, B:22:0x0100, B:227:0x0708, B:26:0x0130, B:29:0x0142, B:31:0x0148, B:46:0x018c, B:48:0x019e, B:51:0x01c3, B:53:0x01c9, B:55:0x01d9, B:57:0x01e7, B:59:0x01f7, B:60:0x0202, B:61:0x0205, B:64:0x021d, B:73:0x024e, B:76:0x0258, B:78:0x0266, B:83:0x02c1, B:80:0x028e, B:82:0x02a0, B:87:0x02d0, B:89:0x02f6, B:90:0x031a, B:92:0x034f, B:94:0x0355, B:97:0x0361, B:99:0x0396, B:100:0x03b1, B:102:0x03b7, B:104:0x03c5, B:108:0x03d9, B:105:0x03cd, B:111:0x03e0, B:114:0x03e7, B:115:0x0406, B:117:0x041f, B:118:0x042b, B:121:0x0435, B:127:0x0458, B:124:0x0447, B:149:0x04d2, B:151:0x04de, B:154:0x04ef, B:156:0x0500, B:158:0x050c, B:193:0x05d7, B:195:0x05dd, B:196:0x05e9, B:198:0x05ef, B:200:0x05ff, B:202:0x0609, B:203:0x061c, B:205:0x0622, B:206:0x063b, B:208:0x0641, B:209:0x065f, B:210:0x066d, B:214:0x0694, B:211:0x0673, B:213:0x067f, B:215:0x069b, B:216:0x06b8, B:218:0x06be, B:220:0x06d1, B:221:0x06de, B:222:0x06e2, B:224:0x06e8, B:226:0x06f4, B:163:0x0529, B:165:0x0537, B:168:0x054a, B:170:0x055b, B:172:0x0567, B:174:0x0577, B:176:0x0586, B:179:0x0592, B:181:0x059c, B:183:0x05a6, B:186:0x05b1, B:188:0x05b7, B:190:0x05c7, B:191:0x05d2, B:131:0x0460, B:133:0x046c, B:135:0x0478, B:148:0x04bc, B:140:0x0494, B:143:0x04a6, B:145:0x04ac, B:147:0x04b6, B:35:0x0152, B:37:0x015f, B:39:0x016d, B:41:0x0173, B:45:0x017e, B:230:0x0722, B:232:0x0734, B:234:0x073d, B:245:0x076d, B:235:0x0745, B:237:0x074e, B:239:0x0754, B:242:0x0760, B:244:0x0768, B:246:0x0770, B:247:0x077c, B:250:0x0784, B:252:0x0796, B:253:0x07a1, B:255:0x07a9, B:259:0x07d6, B:261:0x07f2, B:263:0x0805, B:265:0x0821, B:267:0x0834, B:268:0x0850, B:270:0x0856, B:272:0x086e, B:273:0x087c, B:275:0x088c, B:276:0x089a, B:277:0x089d, B:279:0x08e7, B:281:0x08ed, B:287:0x0918, B:289:0x0920, B:290:0x093e, B:292:0x0944, B:293:0x0958, B:295:0x096f, B:297:0x0980, B:299:0x0992, B:301:0x099c, B:302:0x099f, B:304:0x09fa, B:305:0x0a0d, B:308:0x0a15, B:311:0x0a34, B:313:0x0a4d, B:315:0x0a64, B:318:0x0a6c, B:320:0x0a70, B:322:0x0a74, B:324:0x0a7e, B:326:0x0a87, B:328:0x0a8b, B:330:0x0a91, B:332:0x0a9c, B:334:0x0aaa, B:400:0x0d10, B:337:0x0ab5, B:339:0x0ad3, B:344:0x0aee, B:346:0x0b10, B:347:0x0b18, B:349:0x0b1e, B:351:0x0b30, B:357:0x0b57, B:358:0x0b78, B:360:0x0b84, B:362:0x0b9c, B:364:0x0bdd, B:370:0x0bf9, B:372:0x0c04, B:374:0x0c08, B:376:0x0c0c, B:378:0x0c10, B:379:0x0c1c, B:380:0x0c23, B:382:0x0c29, B:384:0x0c41, B:385:0x0c46, B:399:0x0d0d, B:386:0x0c84, B:388:0x0c8a, B:392:0x0c9d, B:394:0x0cb9, B:395:0x0cc0, B:398:0x0d01, B:389:0x0c8f, B:355:0x0b41, B:342:0x0ad9, B:401:0x0d1c, B:403:0x0d2c, B:404:0x0d40, B:405:0x0d48, B:407:0x0d4e, B:410:0x0d69, B:412:0x0d7b, B:433:0x0e29, B:435:0x0e2f, B:437:0x0e44, B:440:0x0e4b, B:445:0x0e8c, B:441:0x0e5a, B:443:0x0e68, B:444:0x0e75, B:446:0x0e9b, B:447:0x0eb4, B:450:0x0ebc, B:451:0x0ec1, B:452:0x0ed1, B:454:0x0eeb, B:455:0x0f06, B:456:0x0f0e, B:460:0x0f2c, B:459:0x0f19, B:414:0x0d95, B:416:0x0d9b, B:418:0x0dab, B:420:0x0db2, B:426:0x0dc8, B:428:0x0dcf, B:430:0x0e1a, B:432:0x0e21, B:431:0x0e1e, B:427:0x0dcc, B:419:0x0daf, B:282:0x08fd, B:284:0x0903, B:286:0x0909, B:266:0x0831, B:262:0x0802, B:256:0x07af, B:258:0x07b5, B:461:0x0f35), top: B:471:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0b78 A[Catch: all -> 0x011d, TryCatch #2 {all -> 0x011d, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00dd, B:20:0x00f6, B:22:0x0100, B:227:0x0708, B:26:0x0130, B:29:0x0142, B:31:0x0148, B:46:0x018c, B:48:0x019e, B:51:0x01c3, B:53:0x01c9, B:55:0x01d9, B:57:0x01e7, B:59:0x01f7, B:60:0x0202, B:61:0x0205, B:64:0x021d, B:73:0x024e, B:76:0x0258, B:78:0x0266, B:83:0x02c1, B:80:0x028e, B:82:0x02a0, B:87:0x02d0, B:89:0x02f6, B:90:0x031a, B:92:0x034f, B:94:0x0355, B:97:0x0361, B:99:0x0396, B:100:0x03b1, B:102:0x03b7, B:104:0x03c5, B:108:0x03d9, B:105:0x03cd, B:111:0x03e0, B:114:0x03e7, B:115:0x0406, B:117:0x041f, B:118:0x042b, B:121:0x0435, B:127:0x0458, B:124:0x0447, B:149:0x04d2, B:151:0x04de, B:154:0x04ef, B:156:0x0500, B:158:0x050c, B:193:0x05d7, B:195:0x05dd, B:196:0x05e9, B:198:0x05ef, B:200:0x05ff, B:202:0x0609, B:203:0x061c, B:205:0x0622, B:206:0x063b, B:208:0x0641, B:209:0x065f, B:210:0x066d, B:214:0x0694, B:211:0x0673, B:213:0x067f, B:215:0x069b, B:216:0x06b8, B:218:0x06be, B:220:0x06d1, B:221:0x06de, B:222:0x06e2, B:224:0x06e8, B:226:0x06f4, B:163:0x0529, B:165:0x0537, B:168:0x054a, B:170:0x055b, B:172:0x0567, B:174:0x0577, B:176:0x0586, B:179:0x0592, B:181:0x059c, B:183:0x05a6, B:186:0x05b1, B:188:0x05b7, B:190:0x05c7, B:191:0x05d2, B:131:0x0460, B:133:0x046c, B:135:0x0478, B:148:0x04bc, B:140:0x0494, B:143:0x04a6, B:145:0x04ac, B:147:0x04b6, B:35:0x0152, B:37:0x015f, B:39:0x016d, B:41:0x0173, B:45:0x017e, B:230:0x0722, B:232:0x0734, B:234:0x073d, B:245:0x076d, B:235:0x0745, B:237:0x074e, B:239:0x0754, B:242:0x0760, B:244:0x0768, B:246:0x0770, B:247:0x077c, B:250:0x0784, B:252:0x0796, B:253:0x07a1, B:255:0x07a9, B:259:0x07d6, B:261:0x07f2, B:263:0x0805, B:265:0x0821, B:267:0x0834, B:268:0x0850, B:270:0x0856, B:272:0x086e, B:273:0x087c, B:275:0x088c, B:276:0x089a, B:277:0x089d, B:279:0x08e7, B:281:0x08ed, B:287:0x0918, B:289:0x0920, B:290:0x093e, B:292:0x0944, B:293:0x0958, B:295:0x096f, B:297:0x0980, B:299:0x0992, B:301:0x099c, B:302:0x099f, B:304:0x09fa, B:305:0x0a0d, B:308:0x0a15, B:311:0x0a34, B:313:0x0a4d, B:315:0x0a64, B:318:0x0a6c, B:320:0x0a70, B:322:0x0a74, B:324:0x0a7e, B:326:0x0a87, B:328:0x0a8b, B:330:0x0a91, B:332:0x0a9c, B:334:0x0aaa, B:400:0x0d10, B:337:0x0ab5, B:339:0x0ad3, B:344:0x0aee, B:346:0x0b10, B:347:0x0b18, B:349:0x0b1e, B:351:0x0b30, B:357:0x0b57, B:358:0x0b78, B:360:0x0b84, B:362:0x0b9c, B:364:0x0bdd, B:370:0x0bf9, B:372:0x0c04, B:374:0x0c08, B:376:0x0c0c, B:378:0x0c10, B:379:0x0c1c, B:380:0x0c23, B:382:0x0c29, B:384:0x0c41, B:385:0x0c46, B:399:0x0d0d, B:386:0x0c84, B:388:0x0c8a, B:392:0x0c9d, B:394:0x0cb9, B:395:0x0cc0, B:398:0x0d01, B:389:0x0c8f, B:355:0x0b41, B:342:0x0ad9, B:401:0x0d1c, B:403:0x0d2c, B:404:0x0d40, B:405:0x0d48, B:407:0x0d4e, B:410:0x0d69, B:412:0x0d7b, B:433:0x0e29, B:435:0x0e2f, B:437:0x0e44, B:440:0x0e4b, B:445:0x0e8c, B:441:0x0e5a, B:443:0x0e68, B:444:0x0e75, B:446:0x0e9b, B:447:0x0eb4, B:450:0x0ebc, B:451:0x0ec1, B:452:0x0ed1, B:454:0x0eeb, B:455:0x0f06, B:456:0x0f0e, B:460:0x0f2c, B:459:0x0f19, B:414:0x0d95, B:416:0x0d9b, B:418:0x0dab, B:420:0x0db2, B:426:0x0dc8, B:428:0x0dcf, B:430:0x0e1a, B:432:0x0e21, B:431:0x0e1e, B:427:0x0dcc, B:419:0x0daf, B:282:0x08fd, B:284:0x0903, B:286:0x0909, B:266:0x0831, B:262:0x0802, B:256:0x07af, B:258:0x07b5, B:461:0x0f35), top: B:471:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:435:0x0e2f A[Catch: all -> 0x011d, TryCatch #2 {all -> 0x011d, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00dd, B:20:0x00f6, B:22:0x0100, B:227:0x0708, B:26:0x0130, B:29:0x0142, B:31:0x0148, B:46:0x018c, B:48:0x019e, B:51:0x01c3, B:53:0x01c9, B:55:0x01d9, B:57:0x01e7, B:59:0x01f7, B:60:0x0202, B:61:0x0205, B:64:0x021d, B:73:0x024e, B:76:0x0258, B:78:0x0266, B:83:0x02c1, B:80:0x028e, B:82:0x02a0, B:87:0x02d0, B:89:0x02f6, B:90:0x031a, B:92:0x034f, B:94:0x0355, B:97:0x0361, B:99:0x0396, B:100:0x03b1, B:102:0x03b7, B:104:0x03c5, B:108:0x03d9, B:105:0x03cd, B:111:0x03e0, B:114:0x03e7, B:115:0x0406, B:117:0x041f, B:118:0x042b, B:121:0x0435, B:127:0x0458, B:124:0x0447, B:149:0x04d2, B:151:0x04de, B:154:0x04ef, B:156:0x0500, B:158:0x050c, B:193:0x05d7, B:195:0x05dd, B:196:0x05e9, B:198:0x05ef, B:200:0x05ff, B:202:0x0609, B:203:0x061c, B:205:0x0622, B:206:0x063b, B:208:0x0641, B:209:0x065f, B:210:0x066d, B:214:0x0694, B:211:0x0673, B:213:0x067f, B:215:0x069b, B:216:0x06b8, B:218:0x06be, B:220:0x06d1, B:221:0x06de, B:222:0x06e2, B:224:0x06e8, B:226:0x06f4, B:163:0x0529, B:165:0x0537, B:168:0x054a, B:170:0x055b, B:172:0x0567, B:174:0x0577, B:176:0x0586, B:179:0x0592, B:181:0x059c, B:183:0x05a6, B:186:0x05b1, B:188:0x05b7, B:190:0x05c7, B:191:0x05d2, B:131:0x0460, B:133:0x046c, B:135:0x0478, B:148:0x04bc, B:140:0x0494, B:143:0x04a6, B:145:0x04ac, B:147:0x04b6, B:35:0x0152, B:37:0x015f, B:39:0x016d, B:41:0x0173, B:45:0x017e, B:230:0x0722, B:232:0x0734, B:234:0x073d, B:245:0x076d, B:235:0x0745, B:237:0x074e, B:239:0x0754, B:242:0x0760, B:244:0x0768, B:246:0x0770, B:247:0x077c, B:250:0x0784, B:252:0x0796, B:253:0x07a1, B:255:0x07a9, B:259:0x07d6, B:261:0x07f2, B:263:0x0805, B:265:0x0821, B:267:0x0834, B:268:0x0850, B:270:0x0856, B:272:0x086e, B:273:0x087c, B:275:0x088c, B:276:0x089a, B:277:0x089d, B:279:0x08e7, B:281:0x08ed, B:287:0x0918, B:289:0x0920, B:290:0x093e, B:292:0x0944, B:293:0x0958, B:295:0x096f, B:297:0x0980, B:299:0x0992, B:301:0x099c, B:302:0x099f, B:304:0x09fa, B:305:0x0a0d, B:308:0x0a15, B:311:0x0a34, B:313:0x0a4d, B:315:0x0a64, B:318:0x0a6c, B:320:0x0a70, B:322:0x0a74, B:324:0x0a7e, B:326:0x0a87, B:328:0x0a8b, B:330:0x0a91, B:332:0x0a9c, B:334:0x0aaa, B:400:0x0d10, B:337:0x0ab5, B:339:0x0ad3, B:344:0x0aee, B:346:0x0b10, B:347:0x0b18, B:349:0x0b1e, B:351:0x0b30, B:357:0x0b57, B:358:0x0b78, B:360:0x0b84, B:362:0x0b9c, B:364:0x0bdd, B:370:0x0bf9, B:372:0x0c04, B:374:0x0c08, B:376:0x0c0c, B:378:0x0c10, B:379:0x0c1c, B:380:0x0c23, B:382:0x0c29, B:384:0x0c41, B:385:0x0c46, B:399:0x0d0d, B:386:0x0c84, B:388:0x0c8a, B:392:0x0c9d, B:394:0x0cb9, B:395:0x0cc0, B:398:0x0d01, B:389:0x0c8f, B:355:0x0b41, B:342:0x0ad9, B:401:0x0d1c, B:403:0x0d2c, B:404:0x0d40, B:405:0x0d48, B:407:0x0d4e, B:410:0x0d69, B:412:0x0d7b, B:433:0x0e29, B:435:0x0e2f, B:437:0x0e44, B:440:0x0e4b, B:445:0x0e8c, B:441:0x0e5a, B:443:0x0e68, B:444:0x0e75, B:446:0x0e9b, B:447:0x0eb4, B:450:0x0ebc, B:451:0x0ec1, B:452:0x0ed1, B:454:0x0eeb, B:455:0x0f06, B:456:0x0f0e, B:460:0x0f2c, B:459:0x0f19, B:414:0x0d95, B:416:0x0d9b, B:418:0x0dab, B:420:0x0db2, B:426:0x0dc8, B:428:0x0dcf, B:430:0x0e1a, B:432:0x0e21, B:431:0x0e1e, B:427:0x0dcc, B:419:0x0daf, B:282:0x08fd, B:284:0x0903, B:286:0x0909, B:266:0x0831, B:262:0x0802, B:256:0x07af, B:258:0x07b5, B:461:0x0f35), top: B:471:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0eba  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0eeb A[Catch: all -> 0x011d, TryCatch #2 {all -> 0x011d, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00dd, B:20:0x00f6, B:22:0x0100, B:227:0x0708, B:26:0x0130, B:29:0x0142, B:31:0x0148, B:46:0x018c, B:48:0x019e, B:51:0x01c3, B:53:0x01c9, B:55:0x01d9, B:57:0x01e7, B:59:0x01f7, B:60:0x0202, B:61:0x0205, B:64:0x021d, B:73:0x024e, B:76:0x0258, B:78:0x0266, B:83:0x02c1, B:80:0x028e, B:82:0x02a0, B:87:0x02d0, B:89:0x02f6, B:90:0x031a, B:92:0x034f, B:94:0x0355, B:97:0x0361, B:99:0x0396, B:100:0x03b1, B:102:0x03b7, B:104:0x03c5, B:108:0x03d9, B:105:0x03cd, B:111:0x03e0, B:114:0x03e7, B:115:0x0406, B:117:0x041f, B:118:0x042b, B:121:0x0435, B:127:0x0458, B:124:0x0447, B:149:0x04d2, B:151:0x04de, B:154:0x04ef, B:156:0x0500, B:158:0x050c, B:193:0x05d7, B:195:0x05dd, B:196:0x05e9, B:198:0x05ef, B:200:0x05ff, B:202:0x0609, B:203:0x061c, B:205:0x0622, B:206:0x063b, B:208:0x0641, B:209:0x065f, B:210:0x066d, B:214:0x0694, B:211:0x0673, B:213:0x067f, B:215:0x069b, B:216:0x06b8, B:218:0x06be, B:220:0x06d1, B:221:0x06de, B:222:0x06e2, B:224:0x06e8, B:226:0x06f4, B:163:0x0529, B:165:0x0537, B:168:0x054a, B:170:0x055b, B:172:0x0567, B:174:0x0577, B:176:0x0586, B:179:0x0592, B:181:0x059c, B:183:0x05a6, B:186:0x05b1, B:188:0x05b7, B:190:0x05c7, B:191:0x05d2, B:131:0x0460, B:133:0x046c, B:135:0x0478, B:148:0x04bc, B:140:0x0494, B:143:0x04a6, B:145:0x04ac, B:147:0x04b6, B:35:0x0152, B:37:0x015f, B:39:0x016d, B:41:0x0173, B:45:0x017e, B:230:0x0722, B:232:0x0734, B:234:0x073d, B:245:0x076d, B:235:0x0745, B:237:0x074e, B:239:0x0754, B:242:0x0760, B:244:0x0768, B:246:0x0770, B:247:0x077c, B:250:0x0784, B:252:0x0796, B:253:0x07a1, B:255:0x07a9, B:259:0x07d6, B:261:0x07f2, B:263:0x0805, B:265:0x0821, B:267:0x0834, B:268:0x0850, B:270:0x0856, B:272:0x086e, B:273:0x087c, B:275:0x088c, B:276:0x089a, B:277:0x089d, B:279:0x08e7, B:281:0x08ed, B:287:0x0918, B:289:0x0920, B:290:0x093e, B:292:0x0944, B:293:0x0958, B:295:0x096f, B:297:0x0980, B:299:0x0992, B:301:0x099c, B:302:0x099f, B:304:0x09fa, B:305:0x0a0d, B:308:0x0a15, B:311:0x0a34, B:313:0x0a4d, B:315:0x0a64, B:318:0x0a6c, B:320:0x0a70, B:322:0x0a74, B:324:0x0a7e, B:326:0x0a87, B:328:0x0a8b, B:330:0x0a91, B:332:0x0a9c, B:334:0x0aaa, B:400:0x0d10, B:337:0x0ab5, B:339:0x0ad3, B:344:0x0aee, B:346:0x0b10, B:347:0x0b18, B:349:0x0b1e, B:351:0x0b30, B:357:0x0b57, B:358:0x0b78, B:360:0x0b84, B:362:0x0b9c, B:364:0x0bdd, B:370:0x0bf9, B:372:0x0c04, B:374:0x0c08, B:376:0x0c0c, B:378:0x0c10, B:379:0x0c1c, B:380:0x0c23, B:382:0x0c29, B:384:0x0c41, B:385:0x0c46, B:399:0x0d0d, B:386:0x0c84, B:388:0x0c8a, B:392:0x0c9d, B:394:0x0cb9, B:395:0x0cc0, B:398:0x0d01, B:389:0x0c8f, B:355:0x0b41, B:342:0x0ad9, B:401:0x0d1c, B:403:0x0d2c, B:404:0x0d40, B:405:0x0d48, B:407:0x0d4e, B:410:0x0d69, B:412:0x0d7b, B:433:0x0e29, B:435:0x0e2f, B:437:0x0e44, B:440:0x0e4b, B:445:0x0e8c, B:441:0x0e5a, B:443:0x0e68, B:444:0x0e75, B:446:0x0e9b, B:447:0x0eb4, B:450:0x0ebc, B:451:0x0ec1, B:452:0x0ed1, B:454:0x0eeb, B:455:0x0f06, B:456:0x0f0e, B:460:0x0f2c, B:459:0x0f19, B:414:0x0d95, B:416:0x0d9b, B:418:0x0dab, B:420:0x0db2, B:426:0x0dc8, B:428:0x0dcf, B:430:0x0e1a, B:432:0x0e21, B:431:0x0e1e, B:427:0x0dcc, B:419:0x0daf, B:282:0x08fd, B:284:0x0903, B:286:0x0909, B:266:0x0831, B:262:0x0802, B:256:0x07af, B:258:0x07b5, B:461:0x0f35), top: B:471:0x0019, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean F(long r48, java.lang.String r50) {
        /*
            Method dump skipped, instruction units count: 3917
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ff5.F(long, java.lang.String):boolean");
    }

    public final void G(l85 l85Var, long j, boolean z) {
        mf5 mf5Var;
        String str = true != z ? "_lte" : "_se";
        m25 m25Var = this.z;
        R(m25Var);
        mf5 mf5VarP1 = m25Var.P1(l85Var.o(), str);
        if (mf5VarP1 != null) {
            Object obj = mf5VarP1.e;
            String strO = l85Var.o();
            z0().getClass();
            mf5Var = new mf5(strO, "auto", str, System.currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j));
        } else {
            String strO2 = l85Var.o();
            z0().getClass();
            mf5Var = new mf5(strO2, "auto", str, System.currentTimeMillis(), Long.valueOf(j));
        }
        z85 z85VarY = a95.y();
        z85VarY.c();
        ((a95) z85VarY.f).A(str);
        z0().getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        z85VarY.c();
        ((a95) z85VarY.f).z(jCurrentTimeMillis);
        Object obj2 = mf5Var.e;
        long jLongValue = ((Long) obj2).longValue();
        z85VarY.c();
        ((a95) z85VarY.f).D(jLongValue);
        a95 a95Var = (a95) z85VarY.e();
        int iJ1 = z65.J1(str, l85Var);
        if (iJ1 >= 0) {
            l85Var.c();
            ((n85) l85Var.f).a0(iJ1, a95Var);
        } else {
            l85Var.c();
            ((n85) l85Var.f).b0(a95Var);
        }
        if (j > 0) {
            m25 m25Var2 = this.z;
            R(m25Var2);
            m25Var2.O1(mf5Var);
            n().H0.c("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", obj2);
        }
    }

    public final boolean H(v75 v75Var, v75 v75Var2) {
        tj4.d("_e".equals(v75Var.n()));
        h0();
        b85 b85VarD1 = z65.d1("_sc", (w75) v75Var.e());
        String strQ = b85VarD1 == null ? null : b85VarD1.q();
        h0();
        b85 b85VarD12 = z65.d1("_pc", (w75) v75Var2.e());
        String strQ2 = b85VarD12 != null ? b85VarD12.q() : null;
        if (strQ2 == null || !strQ2.equals(strQ)) {
            return false;
        }
        tj4.d("_e".equals(v75Var.n()));
        h0();
        b85 b85VarD13 = z65.d1("_et", (w75) v75Var.e());
        if (b85VarD13 == null || !b85VarD13.r() || b85VarD13.s() <= 0) {
            return true;
        }
        long jS = b85VarD13.s();
        h0();
        b85 b85VarD14 = z65.d1("_et", (w75) v75Var2.e());
        if (b85VarD14 != null && b85VarD14.s() > 0) {
            jS += b85VarD14.s();
        }
        h0();
        z65.b1(v75Var2, "_et", Long.valueOf(jS));
        h0();
        z65.b1(v75Var, "_fr", 1L);
        return true;
    }

    public final boolean I() {
        C().V0();
        j0();
        m25 m25Var = this.z;
        R(m25Var);
        if (m25Var.F1("select count(1) > 0 from raw_events", null) != 0) {
            return true;
        }
        m25 m25Var2 = this.z;
        R(m25Var2);
        return !TextUtils.isEmpty(m25Var2.d1());
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K() {
        /*
            Method dump skipped, instruction units count: 1049
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ff5.K():void");
    }

    public final void L() {
        C().V0();
        if (this.K0 || this.L0 || this.M0) {
            n().H0.d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.K0), Boolean.valueOf(this.L0), Boolean.valueOf(this.M0));
            return;
        }
        n().H0.a("Stopping uploading service(s)");
        ArrayList arrayList = this.G0;
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        ArrayList arrayList2 = this.G0;
        tj4.i(arrayList2);
        arrayList2.clear();
    }

    public final Boolean M(b75 b75Var) {
        try {
            long jP = b75Var.P();
            k85 k85Var = this.C0;
            if (jP != -2147483648L) {
                if (b75Var.P() == ay4.a(k85Var.b).a(0, b75Var.D()).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = ay4.a(k85Var.b).a(0, b75Var.D()).versionName;
                String strN = b75Var.N();
                if (strN != null && strN.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final tg5 N(String str) {
        m25 m25Var = this.z;
        R(m25Var);
        b75 b75VarX1 = m25Var.X1(str);
        if (b75VarX1 != null) {
            k85 k85Var = b75VarX1.a;
            if (!TextUtils.isEmpty(b75VarX1.N())) {
                Boolean boolM = M(b75VarX1);
                if (boolM != null && !boolM.booleanValue()) {
                    n().z0.b(t65.Z0(str), "App version does not match; dropping. appId");
                    return null;
                }
                String strG = b75VarX1.G();
                String strN = b75VarX1.N();
                long jP = b75VarX1.P();
                f85 f85Var = k85Var.Z;
                k85.h(f85Var);
                f85Var.V0();
                String str2 = b75VarX1.l;
                f85 f85Var2 = k85Var.Z;
                k85.h(f85Var2);
                f85Var2.V0();
                long j = b75VarX1.m;
                f85 f85Var3 = k85Var.Z;
                k85.h(f85Var3);
                f85Var3.V0();
                long j2 = b75VarX1.n;
                f85 f85Var4 = k85Var.Z;
                k85.h(f85Var4);
                f85Var4.V0();
                boolean z = b75VarX1.o;
                String strJ = b75VarX1.J();
                f85 f85Var5 = k85Var.Z;
                k85.h(f85Var5);
                f85Var5.V0();
                boolean z2 = b75VarX1.p;
                Boolean boolW = b75VarX1.w();
                long jB = b75VarX1.b();
                f85 f85Var6 = k85Var.Z;
                k85.h(f85Var6);
                f85Var6.V0();
                ArrayList arrayList = b75VarX1.s;
                String strG2 = a(str).g();
                boolean zY = b75VarX1.y();
                f85 f85Var7 = k85Var.Z;
                k85.h(f85Var7);
                f85Var7.V0();
                long j3 = b75VarX1.v;
                int i = a(str).b;
                String str3 = m0(str).b;
                f85 f85Var8 = k85Var.Z;
                k85.h(f85Var8);
                f85Var8.V0();
                int i2 = b75VarX1.x;
                f85 f85Var9 = k85Var.Z;
                k85.h(f85Var9);
                f85Var9.V0();
                return new tg5(str, strG, strN, jP, str2, j, j2, (String) null, z, false, strJ, 0L, 0, z2, false, boolW, jB, (List) arrayList, strG2, "", (String) null, zY, j3, i, str3, i2, b75VarX1.B, b75VarX1.C(), b75VarX1.s(), 0L, b75VarX1.t());
            }
        }
        n().G0.b(str, "No app data available; dropping");
        return null;
    }

    public final boolean O(String str, String str2) {
        m25 m25Var = this.z;
        R(m25Var);
        w25 w25VarT1 = m25Var.t1("events", str, str2);
        return w25VarT1 == null || w25VarT1.c < 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T(defpackage.kf5 r24, defpackage.tg5 r25) {
        /*
            Method dump skipped, instruction units count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ff5.T(kf5, tg5):void");
    }

    @Override // defpackage.m95
    public final d84 U() {
        return this.C0.z;
    }

    public final void V(String str, tg5 tg5Var) {
        C().V0();
        j0();
        boolean zQ = Q(tg5Var);
        String str2 = tg5Var.b;
        if (zQ) {
            if (!tg5Var.y0) {
                a0(tg5Var);
                return;
            }
            Boolean boolS = S(tg5Var);
            if ("_npa".equals(str) && boolS != null) {
                n().G0.a("Falling back to manifest metadata value for ad personalization");
                z0().getClass();
                T(new kf5(System.currentTimeMillis(), Long.valueOf(true != boolS.booleanValue() ? 0L : 1L), "_npa", "auto"), tg5Var);
                return;
            }
            q65 q65Var = n().G0;
            k85 k85Var = this.C0;
            q65Var.b(k85Var.A0.c(str), "Removing user property");
            m25 m25Var = this.z;
            R(m25Var);
            m25Var.H1();
            try {
                a0(tg5Var);
                if ("_id".equals(str)) {
                    m25 m25Var2 = this.z;
                    R(m25Var2);
                    tj4.i(str2);
                    m25Var2.N1(str2, "_lair");
                }
                m25 m25Var3 = this.z;
                R(m25Var3);
                tj4.i(str2);
                m25Var3.N1(str2, str);
                m25 m25Var4 = this.z;
                R(m25Var4);
                m25Var4.I1();
                n().G0.b(k85Var.A0.c(str), "User property removed");
                m25 m25Var5 = this.z;
                R(m25Var5);
                m25Var5.J1();
            } catch (Throwable th) {
                m25 m25Var6 = this.z;
                R(m25Var6);
                m25Var6.J1();
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x042c A[Catch: all -> 0x00c4, TryCatch #1 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cb, B:38:0x00db, B:40:0x00ea, B:46:0x00ff, B:48:0x010c, B:50:0x0119, B:53:0x0122, B:56:0x0139, B:59:0x0152, B:62:0x0176, B:65:0x0183, B:67:0x019b, B:105:0x0274, B:107:0x029f, B:108:0x02a2, B:110:0x02c1, B:151:0x0389, B:152:0x038c, B:154:0x0399, B:155:0x03a9, B:166:0x044f, B:113:0x02d8, B:118:0x02f7, B:120:0x02ff, B:122:0x0305, B:126:0x0318, B:130:0x032a, B:134:0x0335, B:137:0x0348, B:142:0x036d, B:144:0x0372, B:146:0x037a, B:148:0x0380, B:140:0x035b, B:128:0x0323, B:116:0x02e5, B:69:0x01aa, B:71:0x01d4, B:72:0x01df, B:74:0x01e6, B:76:0x01ec, B:78:0x01f6, B:80:0x01fc, B:82:0x0202, B:84:0x0208, B:85:0x020d, B:87:0x021f, B:89:0x0225, B:95:0x0235, B:101:0x023f, B:102:0x0250, B:103:0x025c, B:104:0x0268, B:156:0x03c2, B:158:0x03f6, B:159:0x03f9, B:161:0x0406, B:162:0x0414, B:163:0x042c, B:165:0x0433, B:54:0x012d, B:49:0x0116, B:42:0x00f4, B:45:0x00fc), top: B:173:0x00a4, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010c A[Catch: all -> 0x00c4, TryCatch #1 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cb, B:38:0x00db, B:40:0x00ea, B:46:0x00ff, B:48:0x010c, B:50:0x0119, B:53:0x0122, B:56:0x0139, B:59:0x0152, B:62:0x0176, B:65:0x0183, B:67:0x019b, B:105:0x0274, B:107:0x029f, B:108:0x02a2, B:110:0x02c1, B:151:0x0389, B:152:0x038c, B:154:0x0399, B:155:0x03a9, B:166:0x044f, B:113:0x02d8, B:118:0x02f7, B:120:0x02ff, B:122:0x0305, B:126:0x0318, B:130:0x032a, B:134:0x0335, B:137:0x0348, B:142:0x036d, B:144:0x0372, B:146:0x037a, B:148:0x0380, B:140:0x035b, B:128:0x0323, B:116:0x02e5, B:69:0x01aa, B:71:0x01d4, B:72:0x01df, B:74:0x01e6, B:76:0x01ec, B:78:0x01f6, B:80:0x01fc, B:82:0x0202, B:84:0x0208, B:85:0x020d, B:87:0x021f, B:89:0x0225, B:95:0x0235, B:101:0x023f, B:102:0x0250, B:103:0x025c, B:104:0x0268, B:156:0x03c2, B:158:0x03f6, B:159:0x03f9, B:161:0x0406, B:162:0x0414, B:163:0x042c, B:165:0x0433, B:54:0x012d, B:49:0x0116, B:42:0x00f4, B:45:0x00fc), top: B:173:0x00a4, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0116 A[Catch: all -> 0x00c4, TryCatch #1 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cb, B:38:0x00db, B:40:0x00ea, B:46:0x00ff, B:48:0x010c, B:50:0x0119, B:53:0x0122, B:56:0x0139, B:59:0x0152, B:62:0x0176, B:65:0x0183, B:67:0x019b, B:105:0x0274, B:107:0x029f, B:108:0x02a2, B:110:0x02c1, B:151:0x0389, B:152:0x038c, B:154:0x0399, B:155:0x03a9, B:166:0x044f, B:113:0x02d8, B:118:0x02f7, B:120:0x02ff, B:122:0x0305, B:126:0x0318, B:130:0x032a, B:134:0x0335, B:137:0x0348, B:142:0x036d, B:144:0x0372, B:146:0x037a, B:148:0x0380, B:140:0x035b, B:128:0x0323, B:116:0x02e5, B:69:0x01aa, B:71:0x01d4, B:72:0x01df, B:74:0x01e6, B:76:0x01ec, B:78:0x01f6, B:80:0x01fc, B:82:0x0202, B:84:0x0208, B:85:0x020d, B:87:0x021f, B:89:0x0225, B:95:0x0235, B:101:0x023f, B:102:0x0250, B:103:0x025c, B:104:0x0268, B:156:0x03c2, B:158:0x03f6, B:159:0x03f9, B:161:0x0406, B:162:0x0414, B:163:0x042c, B:165:0x0433, B:54:0x012d, B:49:0x0116, B:42:0x00f4, B:45:0x00fc), top: B:173:0x00a4, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0122 A[Catch: all -> 0x00c4, TRY_ENTER, TryCatch #1 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cb, B:38:0x00db, B:40:0x00ea, B:46:0x00ff, B:48:0x010c, B:50:0x0119, B:53:0x0122, B:56:0x0139, B:59:0x0152, B:62:0x0176, B:65:0x0183, B:67:0x019b, B:105:0x0274, B:107:0x029f, B:108:0x02a2, B:110:0x02c1, B:151:0x0389, B:152:0x038c, B:154:0x0399, B:155:0x03a9, B:166:0x044f, B:113:0x02d8, B:118:0x02f7, B:120:0x02ff, B:122:0x0305, B:126:0x0318, B:130:0x032a, B:134:0x0335, B:137:0x0348, B:142:0x036d, B:144:0x0372, B:146:0x037a, B:148:0x0380, B:140:0x035b, B:128:0x0323, B:116:0x02e5, B:69:0x01aa, B:71:0x01d4, B:72:0x01df, B:74:0x01e6, B:76:0x01ec, B:78:0x01f6, B:80:0x01fc, B:82:0x0202, B:84:0x0208, B:85:0x020d, B:87:0x021f, B:89:0x0225, B:95:0x0235, B:101:0x023f, B:102:0x0250, B:103:0x025c, B:104:0x0268, B:156:0x03c2, B:158:0x03f6, B:159:0x03f9, B:161:0x0406, B:162:0x0414, B:163:0x042c, B:165:0x0433, B:54:0x012d, B:49:0x0116, B:42:0x00f4, B:45:0x00fc), top: B:173:0x00a4, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012d A[Catch: all -> 0x00c4, TryCatch #1 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cb, B:38:0x00db, B:40:0x00ea, B:46:0x00ff, B:48:0x010c, B:50:0x0119, B:53:0x0122, B:56:0x0139, B:59:0x0152, B:62:0x0176, B:65:0x0183, B:67:0x019b, B:105:0x0274, B:107:0x029f, B:108:0x02a2, B:110:0x02c1, B:151:0x0389, B:152:0x038c, B:154:0x0399, B:155:0x03a9, B:166:0x044f, B:113:0x02d8, B:118:0x02f7, B:120:0x02ff, B:122:0x0305, B:126:0x0318, B:130:0x032a, B:134:0x0335, B:137:0x0348, B:142:0x036d, B:144:0x0372, B:146:0x037a, B:148:0x0380, B:140:0x035b, B:128:0x0323, B:116:0x02e5, B:69:0x01aa, B:71:0x01d4, B:72:0x01df, B:74:0x01e6, B:76:0x01ec, B:78:0x01f6, B:80:0x01fc, B:82:0x0202, B:84:0x0208, B:85:0x020d, B:87:0x021f, B:89:0x0225, B:95:0x0235, B:101:0x023f, B:102:0x0250, B:103:0x025c, B:104:0x0268, B:156:0x03c2, B:158:0x03f6, B:159:0x03f9, B:161:0x0406, B:162:0x0414, B:163:0x042c, B:165:0x0433, B:54:0x012d, B:49:0x0116, B:42:0x00f4, B:45:0x00fc), top: B:173:0x00a4, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0139 A[Catch: all -> 0x00c4, TRY_LEAVE, TryCatch #1 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cb, B:38:0x00db, B:40:0x00ea, B:46:0x00ff, B:48:0x010c, B:50:0x0119, B:53:0x0122, B:56:0x0139, B:59:0x0152, B:62:0x0176, B:65:0x0183, B:67:0x019b, B:105:0x0274, B:107:0x029f, B:108:0x02a2, B:110:0x02c1, B:151:0x0389, B:152:0x038c, B:154:0x0399, B:155:0x03a9, B:166:0x044f, B:113:0x02d8, B:118:0x02f7, B:120:0x02ff, B:122:0x0305, B:126:0x0318, B:130:0x032a, B:134:0x0335, B:137:0x0348, B:142:0x036d, B:144:0x0372, B:146:0x037a, B:148:0x0380, B:140:0x035b, B:128:0x0323, B:116:0x02e5, B:69:0x01aa, B:71:0x01d4, B:72:0x01df, B:74:0x01e6, B:76:0x01ec, B:78:0x01f6, B:80:0x01fc, B:82:0x0202, B:84:0x0208, B:85:0x020d, B:87:0x021f, B:89:0x0225, B:95:0x0235, B:101:0x023f, B:102:0x0250, B:103:0x025c, B:104:0x0268, B:156:0x03c2, B:158:0x03f6, B:159:0x03f9, B:161:0x0406, B:162:0x0414, B:163:0x042c, B:165:0x0433, B:54:0x012d, B:49:0x0116, B:42:0x00f4, B:45:0x00fc), top: B:173:0x00a4, inners: #0, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void W(defpackage.tg5 r35) {
        /*
            Method dump skipped, instruction units count: 1129
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ff5.W(tg5):void");
    }

    public final void X(q15 q15Var, tg5 tg5Var) {
        z25 z25Var;
        tj4.f(q15Var.b);
        tj4.i(q15Var.f);
        tj4.i(q15Var.z);
        tj4.f(q15Var.z.f);
        C().V0();
        j0();
        if (Q(tg5Var)) {
            if (!tg5Var.y0) {
                a0(tg5Var);
                return;
            }
            q15 q15Var2 = new q15(q15Var);
            boolean z = false;
            q15Var2.X = false;
            m25 m25Var = this.z;
            R(m25Var);
            m25Var.H1();
            try {
                m25 m25Var2 = this.z;
                R(m25Var2);
                String str = q15Var2.b;
                tj4.i(str);
                q15 q15VarT1 = m25Var2.T1(str, q15Var2.z.f);
                k85 k85Var = this.C0;
                if (q15VarT1 != null && !q15VarT1.f.equals(q15Var2.f)) {
                    n().C0.d("Updating a conditional user property with different origin. name, origin, origin (from DB)", k85Var.A0.c(q15Var2.z.f), q15Var2.f, q15VarT1.f);
                }
                if (q15VarT1 != null && q15VarT1.X) {
                    q15Var2.f = q15VarT1.f;
                    q15Var2.A = q15VarT1.A;
                    q15Var2.y0 = q15VarT1.y0;
                    q15Var2.Y = q15VarT1.Y;
                    q15Var2.z0 = q15VarT1.z0;
                    q15Var2.X = true;
                    kf5 kf5Var = q15Var2.z;
                    q15Var2.z = new kf5(q15VarT1.z.z, kf5Var.a(), kf5Var.f, q15VarT1.z.Y);
                } else if (TextUtils.isEmpty(q15Var2.Y)) {
                    kf5 kf5Var2 = q15Var2.z;
                    q15Var2.z = new kf5(q15Var2.A, kf5Var2.a(), kf5Var2.f, q15Var2.z.Y);
                    q15Var2.X = true;
                    z = true;
                }
                if (q15Var2.X) {
                    kf5 kf5Var3 = q15Var2.z;
                    String str2 = q15Var2.b;
                    tj4.i(str2);
                    String str3 = q15Var2.f;
                    String str4 = kf5Var3.f;
                    long j = kf5Var3.z;
                    Object objA = kf5Var3.a();
                    tj4.i(objA);
                    mf5 mf5Var = new mf5(str2, str3, str4, j, objA);
                    Object obj = mf5Var.e;
                    String str5 = mf5Var.c;
                    m25 m25Var3 = this.z;
                    R(m25Var3);
                    if (m25Var3.O1(mf5Var)) {
                        n().G0.d("User property updated immediately", q15Var2.b, k85Var.A0.c(str5), obj);
                    } else {
                        n().z0.d("(2)Too many active user properties, ignoring", t65.Z0(q15Var2.b), k85Var.A0.c(str5), obj);
                    }
                    if (z && (z25Var = q15Var2.z0) != null) {
                        g(new z25(z25Var, q15Var2.A), tg5Var);
                    }
                }
                m25 m25Var4 = this.z;
                R(m25Var4);
                if (m25Var4.S1(q15Var2)) {
                    n().G0.d("Conditional property added", q15Var2.b, k85Var.A0.c(q15Var2.z.f), q15Var2.z.a());
                } else {
                    n().z0.d("Too many conditional properties, ignoring", t65.Z0(q15Var2.b), k85Var.A0.c(q15Var2.z.f), q15Var2.z.a());
                }
                m25 m25Var5 = this.z;
                R(m25Var5);
                m25Var5.I1();
                m25 m25Var6 = this.z;
                R(m25Var6);
                m25Var6.J1();
            } catch (Throwable th) {
                m25 m25Var7 = this.z;
                R(m25Var7);
                m25Var7.J1();
                throw th;
            }
        }
    }

    public final void Y(q15 q15Var, tg5 tg5Var) {
        tj4.f(q15Var.b);
        tj4.i(q15Var.z);
        tj4.f(q15Var.z.f);
        C().V0();
        j0();
        if (Q(tg5Var)) {
            if (!tg5Var.y0) {
                a0(tg5Var);
                return;
            }
            m25 m25Var = this.z;
            R(m25Var);
            m25Var.H1();
            try {
                a0(tg5Var);
                String str = q15Var.b;
                tj4.i(str);
                m25 m25Var2 = this.z;
                R(m25Var2);
                q15 q15VarT1 = m25Var2.T1(str, q15Var.z.f);
                k85 k85Var = this.C0;
                if (q15VarT1 != null) {
                    n().G0.c("Removing conditional user property", q15Var.b, k85Var.A0.c(q15Var.z.f));
                    m25 m25Var3 = this.z;
                    R(m25Var3);
                    m25Var3.U1(str, q15Var.z.f);
                    if (q15VarT1.X) {
                        m25 m25Var4 = this.z;
                        R(m25Var4);
                        m25Var4.N1(str, q15Var.z.f);
                    }
                    z25 z25Var = q15Var.B0;
                    if (z25Var != null) {
                        y25 y25Var = z25Var.f;
                        z25 z25VarZ1 = i0().z1(z25Var.b, y25Var != null ? y25Var.l() : null, q15VarT1.f, z25Var.A, true);
                        tj4.i(z25VarZ1);
                        g(z25VarZ1, tg5Var);
                    }
                } else {
                    n().C0.c("Conditional user property doesn't exist", t65.Z0(q15Var.b), k85Var.A0.c(q15Var.z.f));
                }
                m25 m25Var5 = this.z;
                R(m25Var5);
                m25Var5.I1();
                m25 m25Var6 = this.z;
                R(m25Var6);
                m25Var6.J1();
            } catch (Throwable th) {
                m25 m25Var7 = this.z;
                R(m25Var7);
                m25Var7.J1();
                throw th;
            }
        }
    }

    public final void Z(tg5 tg5Var, long j) throws Throwable {
        m25 m25Var = this.z;
        R(m25Var);
        String str = tg5Var.b;
        tj4.i(str);
        b75 b75VarX1 = m25Var.X1(str);
        if (b75VarX1 != null) {
            i0();
            String str2 = tg5Var.f;
            String strG = b75VarX1.G();
            boolean zIsEmpty = TextUtils.isEmpty(str2);
            boolean zIsEmpty2 = TextUtils.isEmpty(strG);
            if (!zIsEmpty && !zIsEmpty2) {
                tj4.i(str2);
                if (!str2.equals(strG)) {
                    n().C0.b(t65.Z0(b75VarX1.D()), "New GMP App Id passed in. Removing cached database data. appId");
                    m25 m25Var2 = this.z;
                    R(m25Var2);
                    k85 k85Var = (k85) m25Var2.f;
                    String strD = b75VarX1.D();
                    m25Var2.W0();
                    m25Var2.V0();
                    tj4.f(strD);
                    try {
                        SQLiteDatabase sQLiteDatabaseK1 = m25Var2.K1();
                        String[] strArr = {strD};
                        int iDelete = sQLiteDatabaseK1.delete("events", "app_id=?", strArr) + sQLiteDatabaseK1.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseK1.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseK1.delete("apps", "app_id=?", strArr) + sQLiteDatabaseK1.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseK1.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseK1.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseK1.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseK1.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseK1.delete("consent_settings", "app_id=?", strArr) + sQLiteDatabaseK1.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseK1.delete("trigger_uris", "app_id=?", strArr);
                        if (k85Var.A.f1(null, r55.i1)) {
                            iDelete += sQLiteDatabaseK1.delete("no_data_mode_events", "app_id=?", strArr);
                        }
                        if (iDelete > 0) {
                            t65 t65Var = k85Var.Y;
                            k85.h(t65Var);
                            t65Var.H0.c("Deleted application data. app, records", strD, Integer.valueOf(iDelete));
                        }
                    } catch (SQLiteException e) {
                        t65 t65Var2 = k85Var.Y;
                        k85.h(t65Var2);
                        t65Var2.z0.c("Error deleting application data. appId, error", t65.Z0(strD), e);
                    }
                    b75VarX1 = null;
                }
            }
        }
        if (b75VarX1 != null) {
            boolean z = (b75VarX1.P() == -2147483648L || b75VarX1.P() == tg5Var.A0) ? false : true;
            String strN = b75VarX1.N();
            if (z || ((b75VarX1.P() != -2147483648L || strN == null || strN.equals(tg5Var.z)) ? false : true)) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", strN);
                z25 z25Var = new z25("_au", new y25(bundle), "auto", j);
                if (c0().f1(null, r55.d1)) {
                    d(z25Var, tg5Var);
                } else {
                    e(z25Var, tg5Var);
                }
            }
        }
    }

    public final t95 a(String str) {
        t95 t95Var = t95.c;
        C().V0();
        j0();
        HashMap map = this.S0;
        t95 t95VarO1 = (t95) map.get(str);
        if (t95VarO1 == null) {
            m25 m25Var = this.z;
            R(m25Var);
            t95VarO1 = m25Var.o1(str);
            if (t95VarO1 == null) {
                t95VarO1 = t95.c;
            }
            C().V0();
            j0();
            map.put(str, t95VarO1);
            m25 m25Var2 = this.z;
            R(m25Var2);
            m25Var2.q1(str, t95VarO1);
        }
        return t95VarO1;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x028e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.b75 a0(defpackage.tg5 r13) {
        /*
            Method dump skipped, instruction units count: 680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ff5.a0(tg5):b75");
    }

    public final long b() {
        z0().getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        fd5 fd5Var = this.z0;
        fd5Var.W0();
        fd5Var.V0();
        u uVar = fd5Var.D0;
        long jA = uVar.a();
        if (jA == 0) {
            qf5 qf5Var = ((k85) fd5Var.f).z0;
            k85.f(qf5Var);
            jA = ((long) qf5Var.U1().nextInt(86400000)) + 1;
            uVar.b(jA);
        }
        return ((((jCurrentTimeMillis + jA) / 1000) / 60) / 60) / 24;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    public final List b0(Bundle bundle, tg5 tg5Var) {
        int[] iArr;
        C().V0();
        mg5.a();
        x15 x15VarC0 = c0();
        String str = tg5Var.b;
        if (!x15VarC0.f1(str, r55.Q0) || str == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    n().z0.a("Uri sources and timestamps do not match");
                } else {
                    int i = 0;
                    while (i < intArray.length) {
                        m25 m25Var = this.z;
                        R(m25Var);
                        k85 k85Var = (k85) m25Var.f;
                        int i2 = intArray[i];
                        long j = longArray[i];
                        tj4.f(str);
                        m25Var.V0();
                        m25Var.W0();
                        try {
                            iArr = intArray;
                        } catch (SQLiteException e) {
                            e = e;
                            iArr = intArray;
                        }
                        try {
                            int iDelete = m25Var.K1().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i2), String.valueOf(j)});
                            t65 t65Var = k85Var.Y;
                            k85.h(t65Var);
                            q65 q65Var = t65Var.H0;
                            StringBuilder sb = new StringBuilder(String.valueOf(iDelete).length() + 46);
                            sb.append("Pruned ");
                            sb.append(iDelete);
                            sb.append(" trigger URIs. appId, source, timestamp");
                            q65Var.d(sb.toString(), str, Integer.valueOf(i2), Long.valueOf(j));
                        } catch (SQLiteException e2) {
                            e = e2;
                            t65 t65Var2 = k85Var.Y;
                            k85.h(t65Var2);
                            t65Var2.z0.c("Error pruning trigger URIs. appId", t65.Z0(str), e);
                        }
                        i++;
                        intArray = iArr;
                    }
                }
            }
        }
        m25 m25Var2 = this.z;
        R(m25Var2);
        String str2 = tg5Var.b;
        tj4.f(str2);
        m25Var2.V0();
        m25Var2.W0();
        ?? arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = m25Var2.K1().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str2}, null, null, "rowid", null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string == null) {
                            string = "";
                        }
                        arrayList.add(new ee5(cursorQuery.getInt(2), cursorQuery.getLong(1), string));
                    } while (cursorQuery.moveToNext());
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            t65 t65Var3 = ((k85) m25Var2.f).Y;
            k85.h(t65Var3);
            t65Var3.z0.c("Error querying trigger uris. appId", t65.Z0(str2), e3);
            arrayList = Collections.EMPTY_LIST;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    public final void c(String str, z25 z25Var) {
        m25 m25Var = this.z;
        R(m25Var);
        b75 b75VarX1 = m25Var.X1(str);
        if (b75VarX1 != null) {
            k85 k85Var = b75VarX1.a;
            if (!TextUtils.isEmpty(b75VarX1.N())) {
                Boolean boolM = M(b75VarX1);
                if (boolM == null) {
                    if (!"_ui".equals(z25Var.b)) {
                        n().C0.b(t65.Z0(str), "Could not find package. appId");
                    }
                } else if (!boolM.booleanValue()) {
                    n().z0.b(t65.Z0(str), "App version does not match; dropping event. appId");
                    return;
                }
                String strG = b75VarX1.G();
                String strN = b75VarX1.N();
                long jP = b75VarX1.P();
                f85 f85Var = k85Var.Z;
                k85.h(f85Var);
                f85Var.V0();
                String str2 = b75VarX1.l;
                f85 f85Var2 = k85Var.Z;
                k85.h(f85Var2);
                f85Var2.V0();
                long j = b75VarX1.m;
                f85 f85Var3 = k85Var.Z;
                k85.h(f85Var3);
                f85Var3.V0();
                long j2 = b75VarX1.n;
                f85 f85Var4 = k85Var.Z;
                k85.h(f85Var4);
                f85Var4.V0();
                boolean z = b75VarX1.o;
                String strJ = b75VarX1.J();
                f85 f85Var5 = k85Var.Z;
                k85.h(f85Var5);
                f85Var5.V0();
                boolean z2 = b75VarX1.p;
                Boolean boolW = b75VarX1.w();
                long jB = b75VarX1.b();
                f85 f85Var6 = k85Var.Z;
                k85.h(f85Var6);
                f85Var6.V0();
                ArrayList arrayList = b75VarX1.s;
                String strG2 = a(str).g();
                boolean zY = b75VarX1.y();
                f85 f85Var7 = k85Var.Z;
                k85.h(f85Var7);
                f85Var7.V0();
                long j3 = b75VarX1.v;
                int i = a(str).b;
                String str3 = m0(str).b;
                f85 f85Var8 = k85Var.Z;
                k85.h(f85Var8);
                f85Var8.V0();
                int i2 = b75VarX1.x;
                f85 f85Var9 = k85Var.Z;
                k85.h(f85Var9);
                f85Var9.V0();
                d(z25Var, new tg5(str, strG, strN, jP, str2, j, j2, (String) null, z, false, strJ, 0L, 0, z2, false, boolW, jB, (List) arrayList, strG2, "", (String) null, zY, j3, i, str3, i2, b75VarX1.B, b75VarX1.C(), b75VarX1.s(), 0L, b75VarX1.t()));
                return;
            }
        }
        n().G0.b(str, "No app data available; dropping event");
    }

    public final x15 c0() {
        k85 k85Var = this.C0;
        tj4.i(k85Var);
        return k85Var.A;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0080: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:129), block:B:18:0x0080 */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(defpackage.z25 r11, defpackage.tg5 r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ff5.d(z25, tg5):void");
    }

    public final x75 d0() {
        x75 x75Var = this.b;
        R(x75Var);
        return x75Var;
    }

    public final void e(z25 z25Var, tg5 tg5Var) {
        z25 z25Var2;
        List listW1;
        k85 k85Var;
        List listW12;
        List<q15> listW13;
        String str;
        tj4.i(tg5Var);
        String str2 = tg5Var.b;
        tj4.f(str2);
        C().V0();
        j0();
        long j = z25Var.A;
        oe3 oe3VarB = oe3.b(z25Var);
        C().V0();
        qf5.O1((this.W0 == null || (str = this.X0) == null || !str.equals(str2)) ? null : this.W0, (Bundle) oe3VarB.e, false);
        z25 z25VarD = oe3VarB.d();
        h0();
        if (TextUtils.isEmpty(tg5Var.f)) {
            return;
        }
        if (!tg5Var.y0) {
            a0(tg5Var);
            return;
        }
        List list = tg5Var.I0;
        if (list != null) {
            String str3 = z25VarD.b;
            if (!list.contains(str3)) {
                n().G0.d("Dropping non-safelisted event. appId, event name, origin", str2, z25VarD.b, z25VarD.z);
                return;
            } else {
                Bundle bundleL = z25VarD.f.l();
                bundleL.putLong("ga_safelisted", 1L);
                z25Var2 = new z25(str3, new y25(bundleL), z25VarD.z, z25VarD.A);
            }
        } else {
            z25Var2 = z25VarD;
        }
        m25 m25Var = this.z;
        R(m25Var);
        m25Var.H1();
        try {
            String str4 = z25Var2.b;
            if ("_s".equals(str4)) {
                m25 m25Var2 = this.z;
                R(m25Var2);
                if (!m25Var2.k1(str2, "_s") && z25Var2.f.b.getLong("_sid") != 0) {
                    m25 m25Var3 = this.z;
                    R(m25Var3);
                    if (m25Var3.k1(str2, "_f")) {
                        m25 m25Var4 = this.z;
                        R(m25Var4);
                        m25Var4.n1(str2, null, "_sid", f(str2, z25Var2));
                    } else {
                        m25 m25Var5 = this.z;
                        R(m25Var5);
                        if (m25Var5.k1(str2, "_v")) {
                            m25 m25Var42 = this.z;
                            R(m25Var42);
                            m25Var42.n1(str2, null, "_sid", f(str2, z25Var2));
                        } else {
                            m25 m25Var6 = this.z;
                            R(m25Var6);
                            z0().getClass();
                            m25Var6.n1(str2, Long.valueOf(System.currentTimeMillis() - 15000), "_sid", f(str2, z25Var2));
                        }
                    }
                }
            }
            m25 m25Var7 = this.z;
            R(m25Var7);
            tj4.f(str2);
            m25Var7.V0();
            m25Var7.W0();
            if (j < 0) {
                t65 t65Var = ((k85) m25Var7.f).Y;
                k85.h(t65Var);
                t65Var.C0.c("Invalid time querying timed out conditional properties", t65.Z0(str2), Long.valueOf(j));
                listW1 = Collections.EMPTY_LIST;
            } else {
                listW1 = m25Var7.W1("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
            }
            Iterator it = listW1.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                k85Var = this.C0;
                if (!zHasNext) {
                    break;
                }
                q15 q15Var = (q15) it.next();
                if (q15Var != null) {
                    n().H0.d("User property timed out", q15Var.b, k85Var.A0.c(q15Var.z.f), q15Var.z.a());
                    z25 z25Var3 = q15Var.Z;
                    if (z25Var3 != null) {
                        g(new z25(z25Var3, j), tg5Var);
                    }
                    m25 m25Var8 = this.z;
                    R(m25Var8);
                    m25Var8.U1(str2, q15Var.z.f);
                }
            }
            m25 m25Var9 = this.z;
            R(m25Var9);
            tj4.f(str2);
            m25Var9.V0();
            m25Var9.W0();
            if (j < 0) {
                t65 t65Var2 = ((k85) m25Var9.f).Y;
                k85.h(t65Var2);
                t65Var2.C0.c("Invalid time querying expired conditional properties", t65.Z0(str2), Long.valueOf(j));
                listW12 = Collections.EMPTY_LIST;
            } else {
                listW12 = m25Var9.W1("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
            }
            ArrayList arrayList = new ArrayList(listW12.size());
            Iterator it2 = listW12.iterator();
            while (it2.hasNext()) {
                q15 q15Var2 = (q15) it2.next();
                if (q15Var2 != null) {
                    Iterator it3 = it2;
                    n().H0.d("User property expired", q15Var2.b, k85Var.A0.c(q15Var2.z.f), q15Var2.z.a());
                    m25 m25Var10 = this.z;
                    R(m25Var10);
                    m25Var10.N1(str2, q15Var2.z.f);
                    z25 z25Var4 = q15Var2.B0;
                    if (z25Var4 != null) {
                        arrayList.add(z25Var4);
                    }
                    m25 m25Var11 = this.z;
                    R(m25Var11);
                    m25Var11.U1(str2, q15Var2.z.f);
                    it2 = it3;
                }
            }
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                g(new z25((z25) it4.next(), j), tg5Var);
            }
            m25 m25Var12 = this.z;
            R(m25Var12);
            tj4.f(str2);
            tj4.f(str4);
            m25Var12.V0();
            m25Var12.W0();
            if (j < 0) {
                k85 k85Var2 = (k85) m25Var12.f;
                t65 t65Var3 = k85Var2.Y;
                k85.h(t65Var3);
                t65Var3.C0.d("Invalid time querying triggered conditional properties", t65.Z0(str2), k85Var2.A0.a(str4), Long.valueOf(j));
                listW13 = Collections.EMPTY_LIST;
            } else {
                listW13 = m25Var12.W1("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j)});
            }
            ArrayList arrayList2 = new ArrayList(listW13.size());
            for (q15 q15Var3 : listW13) {
                if (q15Var3 != null) {
                    kf5 kf5Var = q15Var3.z;
                    String str5 = q15Var3.b;
                    tj4.i(str5);
                    String str6 = q15Var3.f;
                    String str7 = kf5Var.f;
                    Object objA = kf5Var.a();
                    tj4.i(objA);
                    mf5 mf5Var = new mf5(str5, str6, str7, j, objA);
                    Object obj = mf5Var.e;
                    String str8 = mf5Var.c;
                    m25 m25Var13 = this.z;
                    R(m25Var13);
                    if (m25Var13.O1(mf5Var)) {
                        n().H0.d("User property triggered", q15Var3.b, k85Var.A0.c(str8), obj);
                    } else {
                        n().z0.d("Too many active user properties, ignoring", t65.Z0(q15Var3.b), k85Var.A0.c(str8), obj);
                    }
                    z25 z25Var5 = q15Var3.z0;
                    if (z25Var5 != null) {
                        arrayList2.add(z25Var5);
                    }
                    q15Var3.z = new kf5(mf5Var);
                    q15Var3.X = true;
                    m25 m25Var14 = this.z;
                    R(m25Var14);
                    m25Var14.S1(q15Var3);
                }
            }
            g(z25Var2, tg5Var);
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                g(new z25((z25) it5.next(), j), tg5Var);
            }
            m25 m25Var15 = this.z;
            R(m25Var15);
            m25Var15.I1();
            m25 m25Var16 = this.z;
            R(m25Var16);
            m25Var16.J1();
        } catch (Throwable th) {
            m25 m25Var17 = this.z;
            R(m25Var17);
            m25Var17.J1();
            throw th;
        }
    }

    public final m25 e0() {
        m25 m25Var = this.z;
        R(m25Var);
        return m25Var;
    }

    public final Bundle f(String str, z25 z25Var) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", z25Var.f.b.getLong("_sid"));
        m25 m25Var = this.z;
        R(m25Var);
        mf5 mf5VarP1 = m25Var.P1(str, "_sno");
        if (mf5VarP1 != null) {
            Object obj = mf5VarP1.e;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    public final e75 f0() {
        e75 e75Var = this.A;
        if (e75Var != null) {
            return e75Var;
        }
        xe.q("Network broadcast receiver not created");
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:76|(11:78|(0)(1:81)|82|89|(1:91)|93|(0)(0)|102|(0)(0)|162|163)|80|83|387|84|88|82|89|(0)(0)|93|(0)(0)|102|(0)(0)|162|163) */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02f8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02f9, code lost:
    
        ((defpackage.k85) r5.f).n().z0.c("Error pruning currencies. appId", defpackage.t65.Z0(r13), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x03d5 A[Catch: all -> 0x01e8, TryCatch #7 {all -> 0x01e8, blocks: (B:37:0x01c9, B:40:0x01d6, B:42:0x01de, B:48:0x01ec, B:93:0x0361, B:102:0x0397, B:104:0x03d5, B:106:0x03db, B:107:0x03f0, B:109:0x03fb, B:111:0x0413, B:113:0x0419, B:114:0x042e, B:117:0x044d, B:121:0x046f, B:122:0x0484, B:123:0x048d, B:126:0x04aa, B:127:0x04be, B:129:0x04c6, B:131:0x04d0, B:133:0x04d6, B:134:0x04dd, B:136:0x04ea, B:138:0x04f2, B:140:0x04fa, B:142:0x0502, B:143:0x050e, B:144:0x051b, B:146:0x0543, B:155:0x0567, B:156:0x057a, B:158:0x05a7, B:161:0x05d1, B:165:0x061d, B:168:0x064b, B:170:0x0678, B:171:0x067b, B:173:0x0681, B:175:0x0689, B:177:0x068f, B:179:0x0697, B:181:0x069d, B:185:0x06ac, B:188:0x06ba, B:190:0x06c3, B:192:0x06cf, B:195:0x06fe, B:197:0x0707, B:201:0x071c, B:206:0x0729, B:241:0x07a4, B:242:0x07ab, B:244:0x07ce, B:247:0x07d7, B:251:0x07e4, B:252:0x0800, B:254:0x0806, B:256:0x0820, B:258:0x082c, B:260:0x0839, B:267:0x086a, B:271:0x0874, B:272:0x0877, B:274:0x0884, B:275:0x0887, B:286:0x08cb, B:265:0x0858, B:245:0x07d1, B:209:0x0732, B:213:0x073f, B:217:0x074d, B:221:0x075b, B:225:0x0769, B:229:0x0777, B:233:0x0783, B:237:0x0791, B:167:0x063e, B:152:0x054e, B:96:0x0371, B:97:0x037d, B:99:0x0383, B:101:0x0391, B:56:0x020c, B:59:0x021a, B:61:0x022f, B:67:0x0247, B:72:0x0275, B:74:0x027b, B:76:0x0289, B:78:0x0297, B:81:0x02a0, B:89:0x0327, B:91:0x0331, B:83:0x02cd, B:84:0x02e6, B:88:0x030c, B:87:0x02f9, B:70:0x0253, B:71:0x026f), top: B:401:0x01c9, inners: #0, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x079e  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0874 A[Catch: all -> 0x01e8, TryCatch #7 {all -> 0x01e8, blocks: (B:37:0x01c9, B:40:0x01d6, B:42:0x01de, B:48:0x01ec, B:93:0x0361, B:102:0x0397, B:104:0x03d5, B:106:0x03db, B:107:0x03f0, B:109:0x03fb, B:111:0x0413, B:113:0x0419, B:114:0x042e, B:117:0x044d, B:121:0x046f, B:122:0x0484, B:123:0x048d, B:126:0x04aa, B:127:0x04be, B:129:0x04c6, B:131:0x04d0, B:133:0x04d6, B:134:0x04dd, B:136:0x04ea, B:138:0x04f2, B:140:0x04fa, B:142:0x0502, B:143:0x050e, B:144:0x051b, B:146:0x0543, B:155:0x0567, B:156:0x057a, B:158:0x05a7, B:161:0x05d1, B:165:0x061d, B:168:0x064b, B:170:0x0678, B:171:0x067b, B:173:0x0681, B:175:0x0689, B:177:0x068f, B:179:0x0697, B:181:0x069d, B:185:0x06ac, B:188:0x06ba, B:190:0x06c3, B:192:0x06cf, B:195:0x06fe, B:197:0x0707, B:201:0x071c, B:206:0x0729, B:241:0x07a4, B:242:0x07ab, B:244:0x07ce, B:247:0x07d7, B:251:0x07e4, B:252:0x0800, B:254:0x0806, B:256:0x0820, B:258:0x082c, B:260:0x0839, B:267:0x086a, B:271:0x0874, B:272:0x0877, B:274:0x0884, B:275:0x0887, B:286:0x08cb, B:265:0x0858, B:245:0x07d1, B:209:0x0732, B:213:0x073f, B:217:0x074d, B:221:0x075b, B:225:0x0769, B:229:0x0777, B:233:0x0783, B:237:0x0791, B:167:0x063e, B:152:0x054e, B:96:0x0371, B:97:0x037d, B:99:0x0383, B:101:0x0391, B:56:0x020c, B:59:0x021a, B:61:0x022f, B:67:0x0247, B:72:0x0275, B:74:0x027b, B:76:0x0289, B:78:0x0297, B:81:0x02a0, B:89:0x0327, B:91:0x0331, B:83:0x02cd, B:84:0x02e6, B:88:0x030c, B:87:0x02f9, B:70:0x0253, B:71:0x026f), top: B:401:0x01c9, inners: #0, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0884 A[Catch: all -> 0x01e8, TryCatch #7 {all -> 0x01e8, blocks: (B:37:0x01c9, B:40:0x01d6, B:42:0x01de, B:48:0x01ec, B:93:0x0361, B:102:0x0397, B:104:0x03d5, B:106:0x03db, B:107:0x03f0, B:109:0x03fb, B:111:0x0413, B:113:0x0419, B:114:0x042e, B:117:0x044d, B:121:0x046f, B:122:0x0484, B:123:0x048d, B:126:0x04aa, B:127:0x04be, B:129:0x04c6, B:131:0x04d0, B:133:0x04d6, B:134:0x04dd, B:136:0x04ea, B:138:0x04f2, B:140:0x04fa, B:142:0x0502, B:143:0x050e, B:144:0x051b, B:146:0x0543, B:155:0x0567, B:156:0x057a, B:158:0x05a7, B:161:0x05d1, B:165:0x061d, B:168:0x064b, B:170:0x0678, B:171:0x067b, B:173:0x0681, B:175:0x0689, B:177:0x068f, B:179:0x0697, B:181:0x069d, B:185:0x06ac, B:188:0x06ba, B:190:0x06c3, B:192:0x06cf, B:195:0x06fe, B:197:0x0707, B:201:0x071c, B:206:0x0729, B:241:0x07a4, B:242:0x07ab, B:244:0x07ce, B:247:0x07d7, B:251:0x07e4, B:252:0x0800, B:254:0x0806, B:256:0x0820, B:258:0x082c, B:260:0x0839, B:267:0x086a, B:271:0x0874, B:272:0x0877, B:274:0x0884, B:275:0x0887, B:286:0x08cb, B:265:0x0858, B:245:0x07d1, B:209:0x0732, B:213:0x073f, B:217:0x074d, B:221:0x075b, B:225:0x0769, B:229:0x0777, B:233:0x0783, B:237:0x0791, B:167:0x063e, B:152:0x054e, B:96:0x0371, B:97:0x037d, B:99:0x0383, B:101:0x0391, B:56:0x020c, B:59:0x021a, B:61:0x022f, B:67:0x0247, B:72:0x0275, B:74:0x027b, B:76:0x0289, B:78:0x0297, B:81:0x02a0, B:89:0x0327, B:91:0x0331, B:83:0x02cd, B:84:0x02e6, B:88:0x030c, B:87:0x02f9, B:70:0x0253, B:71:0x026f), top: B:401:0x01c9, inners: #0, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0955  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x099b A[Catch: all -> 0x092d, TryCatch #9 {all -> 0x092d, blocks: (B:278:0x089d, B:280:0x08a8, B:282:0x08b6, B:284:0x08c0, B:287:0x08d4, B:289:0x08de, B:291:0x08ea, B:293:0x08f4, B:295:0x0902, B:297:0x091a, B:301:0x0935, B:303:0x0943, B:304:0x094c, B:306:0x0958, B:308:0x099b, B:311:0x09a6, B:312:0x09b0, B:313:0x09b1, B:315:0x09bb, B:281:0x08ad), top: B:404:0x089d }] */
    /* JADX WARN: Removed duplicated region for block: B:315:0x09bb A[Catch: all -> 0x092d, TRY_LEAVE, TryCatch #9 {all -> 0x092d, blocks: (B:278:0x089d, B:280:0x08a8, B:282:0x08b6, B:284:0x08c0, B:287:0x08d4, B:289:0x08de, B:291:0x08ea, B:293:0x08f4, B:295:0x0902, B:297:0x091a, B:301:0x0935, B:303:0x0943, B:304:0x094c, B:306:0x0958, B:308:0x099b, B:311:0x09a6, B:312:0x09b0, B:313:0x09b1, B:315:0x09bb, B:281:0x08ad), top: B:404:0x089d }] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0a1f  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0a2a A[Catch: all -> 0x09e7, TryCatch #6 {all -> 0x09e7, blocks: (B:317:0x09c2, B:319:0x09d9, B:323:0x09ea, B:325:0x0a22, B:327:0x0a2a, B:329:0x0a34, B:330:0x0a3e, B:332:0x0a48, B:333:0x0a52, B:334:0x0a5b, B:336:0x0a61, B:338:0x0aab, B:340:0x0abd, B:344:0x0adc, B:346:0x0aec, B:343:0x0acc, B:350:0x0aff, B:351:0x0b41, B:352:0x0b4c, B:353:0x0b5e, B:355:0x0b64, B:364:0x0bab, B:365:0x0bf3, B:367:0x0c04, B:381:0x0c63, B:372:0x0c1c, B:373:0x0c1f, B:358:0x0b72, B:360:0x0b98, B:378:0x0c38, B:379:0x0c4f, B:380:0x0c50), top: B:399:0x09c2, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0a48 A[Catch: all -> 0x09e7, TryCatch #6 {all -> 0x09e7, blocks: (B:317:0x09c2, B:319:0x09d9, B:323:0x09ea, B:325:0x0a22, B:327:0x0a2a, B:329:0x0a34, B:330:0x0a3e, B:332:0x0a48, B:333:0x0a52, B:334:0x0a5b, B:336:0x0a61, B:338:0x0aab, B:340:0x0abd, B:344:0x0adc, B:346:0x0aec, B:343:0x0acc, B:350:0x0aff, B:351:0x0b41, B:352:0x0b4c, B:353:0x0b5e, B:355:0x0b64, B:364:0x0bab, B:365:0x0bf3, B:367:0x0c04, B:381:0x0c63, B:372:0x0c1c, B:373:0x0c1f, B:358:0x0b72, B:360:0x0b98, B:378:0x0c38, B:379:0x0c4f, B:380:0x0c50), top: B:399:0x09c2, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0a61 A[Catch: all -> 0x09e7, TryCatch #6 {all -> 0x09e7, blocks: (B:317:0x09c2, B:319:0x09d9, B:323:0x09ea, B:325:0x0a22, B:327:0x0a2a, B:329:0x0a34, B:330:0x0a3e, B:332:0x0a48, B:333:0x0a52, B:334:0x0a5b, B:336:0x0a61, B:338:0x0aab, B:340:0x0abd, B:344:0x0adc, B:346:0x0aec, B:343:0x0acc, B:350:0x0aff, B:351:0x0b41, B:352:0x0b4c, B:353:0x0b5e, B:355:0x0b64, B:364:0x0bab, B:365:0x0bf3, B:367:0x0c04, B:381:0x0c63, B:372:0x0c1c, B:373:0x0c1f, B:358:0x0b72, B:360:0x0b98, B:378:0x0c38, B:379:0x0c4f, B:380:0x0c50), top: B:399:0x09c2, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0af7  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0b64 A[Catch: all -> 0x09e7, TryCatch #6 {all -> 0x09e7, blocks: (B:317:0x09c2, B:319:0x09d9, B:323:0x09ea, B:325:0x0a22, B:327:0x0a2a, B:329:0x0a34, B:330:0x0a3e, B:332:0x0a48, B:333:0x0a52, B:334:0x0a5b, B:336:0x0a61, B:338:0x0aab, B:340:0x0abd, B:344:0x0adc, B:346:0x0aec, B:343:0x0acc, B:350:0x0aff, B:351:0x0b41, B:352:0x0b4c, B:353:0x0b5e, B:355:0x0b64, B:364:0x0bab, B:365:0x0bf3, B:367:0x0c04, B:381:0x0c63, B:372:0x0c1c, B:373:0x0c1f, B:358:0x0b72, B:360:0x0b98, B:378:0x0c38, B:379:0x0c4f, B:380:0x0c50), top: B:399:0x09c2, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0c04 A[Catch: all -> 0x09e7, SQLiteException -> 0x0c18, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x0c18, blocks: (B:365:0x0bf3, B:367:0x0c04), top: B:389:0x0bf3, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0c1a  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0b72 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0331 A[Catch: all -> 0x01e8, TryCatch #7 {all -> 0x01e8, blocks: (B:37:0x01c9, B:40:0x01d6, B:42:0x01de, B:48:0x01ec, B:93:0x0361, B:102:0x0397, B:104:0x03d5, B:106:0x03db, B:107:0x03f0, B:109:0x03fb, B:111:0x0413, B:113:0x0419, B:114:0x042e, B:117:0x044d, B:121:0x046f, B:122:0x0484, B:123:0x048d, B:126:0x04aa, B:127:0x04be, B:129:0x04c6, B:131:0x04d0, B:133:0x04d6, B:134:0x04dd, B:136:0x04ea, B:138:0x04f2, B:140:0x04fa, B:142:0x0502, B:143:0x050e, B:144:0x051b, B:146:0x0543, B:155:0x0567, B:156:0x057a, B:158:0x05a7, B:161:0x05d1, B:165:0x061d, B:168:0x064b, B:170:0x0678, B:171:0x067b, B:173:0x0681, B:175:0x0689, B:177:0x068f, B:179:0x0697, B:181:0x069d, B:185:0x06ac, B:188:0x06ba, B:190:0x06c3, B:192:0x06cf, B:195:0x06fe, B:197:0x0707, B:201:0x071c, B:206:0x0729, B:241:0x07a4, B:242:0x07ab, B:244:0x07ce, B:247:0x07d7, B:251:0x07e4, B:252:0x0800, B:254:0x0806, B:256:0x0820, B:258:0x082c, B:260:0x0839, B:267:0x086a, B:271:0x0874, B:272:0x0877, B:274:0x0884, B:275:0x0887, B:286:0x08cb, B:265:0x0858, B:245:0x07d1, B:209:0x0732, B:213:0x073f, B:217:0x074d, B:221:0x075b, B:225:0x0769, B:229:0x0777, B:233:0x0783, B:237:0x0791, B:167:0x063e, B:152:0x054e, B:96:0x0371, B:97:0x037d, B:99:0x0383, B:101:0x0391, B:56:0x020c, B:59:0x021a, B:61:0x022f, B:67:0x0247, B:72:0x0275, B:74:0x027b, B:76:0x0289, B:78:0x0297, B:81:0x02a0, B:89:0x0327, B:91:0x0331, B:83:0x02cd, B:84:0x02e6, B:88:0x030c, B:87:0x02f9, B:70:0x0253, B:71:0x026f), top: B:401:0x01c9, inners: #0, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0371 A[Catch: all -> 0x01e8, TryCatch #7 {all -> 0x01e8, blocks: (B:37:0x01c9, B:40:0x01d6, B:42:0x01de, B:48:0x01ec, B:93:0x0361, B:102:0x0397, B:104:0x03d5, B:106:0x03db, B:107:0x03f0, B:109:0x03fb, B:111:0x0413, B:113:0x0419, B:114:0x042e, B:117:0x044d, B:121:0x046f, B:122:0x0484, B:123:0x048d, B:126:0x04aa, B:127:0x04be, B:129:0x04c6, B:131:0x04d0, B:133:0x04d6, B:134:0x04dd, B:136:0x04ea, B:138:0x04f2, B:140:0x04fa, B:142:0x0502, B:143:0x050e, B:144:0x051b, B:146:0x0543, B:155:0x0567, B:156:0x057a, B:158:0x05a7, B:161:0x05d1, B:165:0x061d, B:168:0x064b, B:170:0x0678, B:171:0x067b, B:173:0x0681, B:175:0x0689, B:177:0x068f, B:179:0x0697, B:181:0x069d, B:185:0x06ac, B:188:0x06ba, B:190:0x06c3, B:192:0x06cf, B:195:0x06fe, B:197:0x0707, B:201:0x071c, B:206:0x0729, B:241:0x07a4, B:242:0x07ab, B:244:0x07ce, B:247:0x07d7, B:251:0x07e4, B:252:0x0800, B:254:0x0806, B:256:0x0820, B:258:0x082c, B:260:0x0839, B:267:0x086a, B:271:0x0874, B:272:0x0877, B:274:0x0884, B:275:0x0887, B:286:0x08cb, B:265:0x0858, B:245:0x07d1, B:209:0x0732, B:213:0x073f, B:217:0x074d, B:221:0x075b, B:225:0x0769, B:229:0x0777, B:233:0x0783, B:237:0x0791, B:167:0x063e, B:152:0x054e, B:96:0x0371, B:97:0x037d, B:99:0x0383, B:101:0x0391, B:56:0x020c, B:59:0x021a, B:61:0x022f, B:67:0x0247, B:72:0x0275, B:74:0x027b, B:76:0x0289, B:78:0x0297, B:81:0x02a0, B:89:0x0327, B:91:0x0331, B:83:0x02cd, B:84:0x02e6, B:88:0x030c, B:87:0x02f9, B:70:0x0253, B:71:0x026f), top: B:401:0x01c9, inners: #0, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(defpackage.z25 r60, defpackage.tg5 r61) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ff5.g(z25, tg5):void");
    }

    public final e15 g0() {
        e15 e15Var = this.Y;
        R(e15Var);
        return e15Var;
    }

    public final void h(b75 b75Var, l85 l85Var) {
        rz4 rz4Var;
        a95 a95Var;
        int i;
        z15 z15Var;
        C().V0();
        j0();
        String strZ0 = ((n85) l85Var.f).z0();
        EnumMap enumMap = new EnumMap(r95.class);
        int length = strZ0.length();
        int length2 = r95.values().length;
        z15 z15Var2 = z15.UNSET;
        int i2 = 0;
        if (length < length2 || strZ0.charAt(0) != '1') {
            rz4Var = new rz4(2);
        } else {
            r95[] r95VarArrValues = r95.values();
            int length3 = r95VarArrValues.length;
            int i3 = 0;
            int i4 = 1;
            while (i3 < length3) {
                r95 r95Var = r95VarArrValues[i3];
                int i5 = i4 + 1;
                char cCharAt = strZ0.charAt(i4);
                z15[] z15VarArrValues = z15.values();
                int length4 = z15VarArrValues.length;
                while (true) {
                    if (i2 >= length4) {
                        z15Var = z15Var2;
                        break;
                    }
                    z15Var = z15VarArrValues[i2];
                    if (z15Var.b == cCharAt) {
                        break;
                    } else {
                        i2++;
                    }
                }
                enumMap.put(r95Var, z15Var);
                i3++;
                i4 = i5;
                i2 = 0;
            }
            rz4Var = new rz4(enumMap);
        }
        String strD = b75Var.D();
        C().V0();
        j0();
        t95 t95VarA = a(strD);
        EnumMap enumMap2 = t95VarA.a;
        r95 r95Var2 = r95.AD_STORAGE;
        o95 o95Var = (o95) enumMap2.get(r95Var2);
        o95 o95Var2 = o95.UNINITIALIZED;
        if (o95Var == null) {
            o95Var = o95Var2;
        }
        int i6 = t95VarA.b;
        int iOrdinal = o95Var.ordinal();
        z15 z15Var3 = z15.REMOTE_ENFORCED_DEFAULT;
        z15 z15Var4 = z15.FAILSAFE;
        if (iOrdinal == 1) {
            rz4Var.f(r95Var2, z15Var3);
        } else if (iOrdinal == 2 || iOrdinal == 3) {
            rz4Var.e(r95Var2, i6);
        } else {
            rz4Var.f(r95Var2, z15Var4);
        }
        r95 r95Var3 = r95.ANALYTICS_STORAGE;
        o95 o95Var3 = (o95) enumMap2.get(r95Var3);
        if (o95Var3 != null) {
            o95Var2 = o95Var3;
        }
        int iOrdinal2 = o95Var2.ordinal();
        if (iOrdinal2 == 1) {
            rz4Var.f(r95Var3, z15Var3);
        } else if (iOrdinal2 == 2 || iOrdinal2 == 3) {
            rz4Var.e(r95Var3, i6);
        } else {
            rz4Var.f(r95Var3, z15Var4);
        }
        String strD2 = b75Var.D();
        C().V0();
        j0();
        o25 o25VarO0 = o0(strD2, m0(strD2), a(strD2), rz4Var);
        String str = o25VarO0.d;
        Boolean bool = o25VarO0.c;
        tj4.i(bool);
        boolean zBooleanValue = bool.booleanValue();
        l85Var.c();
        ((n85) l85Var.f).d1(zBooleanValue);
        if (!TextUtils.isEmpty(str)) {
            l85Var.c();
            ((n85) l85Var.f).e1(str);
        }
        C().V0();
        j0();
        Iterator it = DesugarCollections.unmodifiableList(((n85) l85Var.f).S1()).iterator();
        while (true) {
            if (it.hasNext()) {
                a95Var = (a95) it.next();
                if ("_npa".equals(a95Var.p())) {
                    break;
                }
            } else {
                a95Var = null;
                break;
            }
        }
        if (a95Var != null) {
            EnumMap enumMap3 = (EnumMap) rz4Var.f;
            r95 r95Var4 = r95.AD_PERSONALIZATION;
            z15 z15Var5 = (z15) enumMap3.get(r95Var4);
            if (z15Var5 == null) {
                z15Var5 = z15Var2;
            }
            if (z15Var5 == z15Var2) {
                m25 m25Var = this.z;
                R(m25Var);
                mf5 mf5VarP1 = m25Var.P1(b75Var.D(), "_npa");
                z15 z15Var6 = z15.MANIFEST;
                z15 z15Var7 = z15.API;
                if (mf5VarP1 != null) {
                    String str2 = mf5VarP1.b;
                    if ("tcf".equals(str2)) {
                        rz4Var.f(r95Var4, z15.TCF);
                    } else if ("app".equals(str2)) {
                        rz4Var.f(r95Var4, z15Var7);
                    } else {
                        rz4Var.f(r95Var4, z15Var6);
                    }
                } else {
                    Boolean boolW = b75Var.w();
                    if (boolW == null || ((boolW.booleanValue() && a95Var.t() != 1) || !(boolW.booleanValue() || a95Var.t() == 0))) {
                        rz4Var.f(r95Var4, z15Var7);
                    } else {
                        rz4Var.f(r95Var4, z15Var6);
                    }
                }
            }
        } else {
            int iB = B(b75Var.D(), rz4Var);
            z85 z85VarY = a95.y();
            z85VarY.c();
            ((a95) z85VarY.f).A("_npa");
            z0().getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            z85VarY.c();
            ((a95) z85VarY.f).z(jCurrentTimeMillis);
            z85VarY.c();
            ((a95) z85VarY.f).D(iB);
            a95 a95Var2 = (a95) z85VarY.e();
            l85Var.c();
            ((n85) l85Var.f).b0(a95Var2);
            n().H0.c("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(iB));
        }
        String string = rz4Var.toString();
        l85Var.c();
        ((n85) l85Var.f).c1(string);
        String strD3 = b75Var.D();
        x75 x75Var = this.b;
        x75Var.V0();
        x75Var.b1(strD3);
        a65 a65VarQ1 = x75Var.q1(strD3);
        boolean z = a65VarQ1 == null || !a65VarQ1.q() || a65VarQ1.r();
        List listY = l85Var.Y();
        for (int i7 = 0; i7 < listY.size(); i7++) {
            if ("_tcf".equals(((w75) listY.get(i7)).q())) {
                v75 v75Var = (v75) ((w75) listY.get(i7)).g();
                List listH = v75Var.h();
                int i8 = 0;
                while (true) {
                    if (i8 >= listH.size()) {
                        break;
                    }
                    if ("_tcfd".equals(((b85) listH.get(i8)).o())) {
                        String strQ = ((b85) listH.get(i8)).q();
                        if (z && strQ.length() > 4) {
                            char[] charArray = strQ.toCharArray();
                            int i9 = 1;
                            while (true) {
                                if (i9 >= 64) {
                                    i = 0;
                                    break;
                                } else {
                                    if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i9)) {
                                        i = i9;
                                        break;
                                    }
                                    i9++;
                                }
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i | 1);
                            strQ = String.valueOf(charArray);
                        }
                        z75 z75VarZ = b85.z();
                        z75VarZ.h("_tcfd");
                        z75VarZ.i(strQ);
                        v75Var.c();
                        ((w75) v75Var.f).y(i8, (b85) z75VarZ.e());
                    } else {
                        i8++;
                    }
                }
                l85Var.a0(i7, v75Var);
                return;
            }
        }
    }

    public final z65 h0() {
        z65 z65Var = this.Z;
        R(z65Var);
        return z65Var;
    }

    public final void i(b75 b75Var, l85 l85Var) {
        Serializable serializableK1;
        C().V0();
        j0();
        w65 w65VarM = d75.M();
        k85 k85Var = b75Var.a;
        f85 f85Var = k85Var.Z;
        k85.h(f85Var);
        f85Var.V0();
        byte[] bArr = b75Var.H;
        if (bArr != null) {
            try {
                w65VarM = (w65) z65.I1(w65VarM, bArr);
            } catch (pc5 unused) {
                n().C0.b(t65.Z0(b75Var.D()), "Failed to parse locally stored ad campaign info. appId");
            }
        }
        Iterator it = l85Var.Y().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            w75 w75Var = (w75) it.next();
            if (w75Var.q().equals("_cmp")) {
                b85 b85VarD1 = z65.d1("gclid", w75Var);
                Serializable serializableK12 = b85VarD1 == null ? null : z65.k1(b85VarD1);
                if (serializableK12 == null) {
                    serializableK12 = "";
                }
                String str = (String) serializableK12;
                b85 b85VarD12 = z65.d1("gbraid", w75Var);
                Serializable serializableK13 = b85VarD12 == null ? null : z65.k1(b85VarD12);
                if (serializableK13 == null) {
                    serializableK13 = "";
                }
                String str2 = (String) serializableK13;
                b85 b85VarD13 = z65.d1("gad_source", w75Var);
                Serializable serializableK14 = b85VarD13 == null ? null : z65.k1(b85VarD13);
                String str3 = (String) (serializableK14 != null ? serializableK14 : "");
                String[] strArrSplit = ((String) r55.h1.a(null)).split(",");
                h0();
                HashMap map = new HashMap();
                for (b85 b85Var : w75Var.n()) {
                    if (Arrays.asList(strArrSplit).contains(b85Var.o()) && (serializableK1 = z65.k1(b85Var)) != null) {
                        map.put(b85Var.o(), serializableK1);
                    }
                }
                if (!map.isEmpty()) {
                    b85 b85VarD14 = z65.d1("click_timestamp", w75Var);
                    Serializable serializableK15 = b85VarD14 == null ? null : z65.k1(b85VarD14);
                    long jLongValue = ((Long) (serializableK15 != null ? serializableK15 : 0L)).longValue();
                    if (jLongValue <= 0) {
                        jLongValue = w75Var.s();
                    }
                    b85 b85VarD15 = z65.d1("_cis", w75Var);
                    if ("referrer API v2".equals(b85VarD15 != null ? z65.k1(b85VarD15) : null)) {
                        if (jLongValue > ((d75) w65VarM.f).L()) {
                            if (str.isEmpty()) {
                                w65VarM.c();
                                ((d75) w65VarM.f).o();
                            } else {
                                w65VarM.c();
                                ((d75) w65VarM.f).n(str);
                            }
                            if (str2.isEmpty()) {
                                w65VarM.c();
                                ((d75) w65VarM.f).q();
                            } else {
                                w65VarM.c();
                                ((d75) w65VarM.f).p(str2);
                            }
                            if (str3.isEmpty()) {
                                w65VarM.c();
                                ((d75) w65VarM.f).s();
                            } else {
                                w65VarM.c();
                                ((d75) w65VarM.f).r(str3);
                            }
                            w65VarM.c();
                            ((d75) w65VarM.f).t(jLongValue);
                            w65VarM.c();
                            ((d75) w65VarM.f).v().clear();
                            HashMap mapD = D(w75Var);
                            w65VarM.c();
                            ((d75) w65VarM.f).v().putAll(mapD);
                        }
                    } else if (jLongValue > ((d75) w65VarM.f).D()) {
                        if (str.isEmpty()) {
                            w65VarM.c();
                            ((d75) w65VarM.f).P();
                        } else {
                            w65VarM.c();
                            ((d75) w65VarM.f).O(str);
                        }
                        if (str2.isEmpty()) {
                            w65VarM.c();
                            ((d75) w65VarM.f).R();
                        } else {
                            w65VarM.c();
                            ((d75) w65VarM.f).Q(str2);
                        }
                        if (str3.isEmpty()) {
                            w65VarM.c();
                            ((d75) w65VarM.f).T();
                        } else {
                            w65VarM.c();
                            ((d75) w65VarM.f).S(str3);
                        }
                        w65VarM.c();
                        ((d75) w65VarM.f).U(jLongValue);
                        w65VarM.c();
                        ((d75) w65VarM.f).u().clear();
                        HashMap mapD2 = D(w75Var);
                        w65VarM.c();
                        ((d75) w65VarM.f).u().putAll(mapD2);
                    }
                }
            }
        }
        if (!((d75) w65VarM.e()).equals(d75.N())) {
            d75 d75Var = (d75) w65VarM.e();
            l85Var.c();
            ((n85) l85Var.f).i1(d75Var);
        }
        byte[] bArrA = ((d75) w65VarM.e()).a();
        f85 f85Var2 = k85Var.Z;
        k85.h(f85Var2);
        f85Var2.V0();
        b75Var.Q |= b75Var.H != bArrA;
        b75Var.H = bArrA;
        if (b75Var.o()) {
            m25 m25Var = this.z;
            R(m25Var);
            m25Var.Y1(b75Var, false);
        }
        if (c0().f1(null, r55.g1)) {
            m25 m25Var2 = this.z;
            R(m25Var2);
            m25Var2.N1(b75Var.D(), "_lgclid");
        }
    }

    public final qf5 i0() {
        k85 k85Var = this.C0;
        tj4.i(k85Var);
        qf5 qf5Var = k85Var.z0;
        k85.f(qf5Var);
        return qf5Var;
    }

    public final String j(t95 t95Var) {
        if (!t95Var.i(r95.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        i0().U1().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final void j0() {
        if (this.D0.get()) {
            return;
        }
        xe.q("UploadController is not initialized");
    }

    public final void k(ArrayList arrayList) {
        tj4.d(!arrayList.isEmpty());
        if (this.P0 != null) {
            n().z0.a("Set uploading progress before finishing the previous upload");
        } else {
            this.P0 = new ArrayList(arrayList);
        }
    }

    public final void k0(tg5 tg5Var) {
        C().V0();
        j0();
        String str = tg5Var.b;
        tj4.f(str);
        t95 t95VarC = t95.c(tg5Var.O0, tg5Var.J0);
        a(str);
        n().H0.c("Setting storage consent for package", str, t95VarC);
        C().V0();
        j0();
        this.S0.put(str, t95VarC);
        m25 m25Var = this.z;
        R(m25Var);
        m25Var.q1(str, t95VarC);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ab A[Catch: all -> 0x0028, TryCatch #4 {all -> 0x0028, blocks: (B:3:0x000e, B:5:0x001b, B:8:0x002b, B:10:0x0031, B:11:0x003e, B:13:0x0046, B:14:0x004b, B:16:0x0056, B:17:0x0063, B:19:0x006e, B:20:0x007e, B:22:0x00a8, B:24:0x00ae, B:25:0x00b1, B:27:0x00ca, B:28:0x00df, B:30:0x00f0, B:32:0x00f6, B:35:0x010b, B:45:0x012a, B:47:0x012f, B:48:0x0132, B:49:0x0133, B:50:0x0138, B:55:0x017d, B:71:0x01a5, B:73:0x01ab, B:75:0x01b6, B:79:0x01c1, B:80:0x01c4, B:33:0x00fb, B:37:0x010f, B:42:0x0117), top: B:91:0x000e, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r11v0, types: [ff5] */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v22, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v25, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.database.Cursor] */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            Method dump skipped, instruction units count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ff5.l():void");
    }

    public final void l0(tg5 tg5Var) {
        C().V0();
        j0();
        String str = tg5Var.b;
        tj4.f(str);
        o25 o25VarB = o25.b(tg5Var.P0);
        n().H0.c("Setting DMA consent for package", str, o25VarB);
        C().V0();
        j0();
        o95 o95VarA = o25.c(100, n0(str)).a();
        this.T0.put(str, o25VarB);
        m25 m25Var = this.z;
        R(m25Var);
        tj4.i(str);
        tj4.i(o25VarB);
        m25Var.V0();
        m25Var.W0();
        t95 t95VarO1 = m25Var.o1(str);
        t95 t95Var = t95.c;
        if (t95VarO1 == t95Var) {
            m25Var.q1(str, t95Var);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", o25VarB.b);
        m25Var.s1(contentValues);
        o95 o95VarA2 = o25.c(100, n0(str)).a();
        C().V0();
        j0();
        o95 o95Var = o95.GRANTED;
        o95 o95Var2 = o95.DENIED;
        boolean z = o95VarA == o95Var2 && o95VarA2 == o95Var;
        boolean z2 = o95VarA == o95Var && o95VarA2 == o95Var2;
        if (z || z2) {
            n().H0.b(str, "Generated _dcu event for");
            Bundle bundle = new Bundle();
            m25 m25Var2 = this.z;
            R(m25Var2);
            if (m25Var2.Z1(b(), str, false, false, false, false).f < c0().d1(str, r55.n0)) {
                bundle.putLong("_r", 1L);
                m25 m25Var3 = this.z;
                R(m25Var3);
                n().H0.c("_dcu realtime event count", str, Long.valueOf(m25Var3.Z1(b(), str, false, false, true, false).f));
            }
            this.a1.b(str, "_dcu", bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f A[PHI: r0 r11 r23 r24
      0x006f: PHI (r0v114 java.util.List) = (r0v8 java.util.List), (r0v136 java.util.List) binds: [B:108:0x021d, B:16:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x006f: PHI (r11v55 android.database.Cursor) = (r11v5 android.database.Cursor), (r11v57 android.database.Cursor) binds: [B:108:0x021d, B:16:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x006f: PHI (r23v18 ??) = (r23v36 ??), (r23v37 ??) binds: [B:108:0x021d, B:16:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x006f: PHI (r24v19 long) = (r24v2 long), (r24v20 long) binds: [B:108:0x021d, B:16:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x05e9  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0640  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x079d  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x07ef  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x07fd  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0a61  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x07e3 A[EDGE_INSN: B:438:0x07e3->B:313:0x07e3 BREAK  A[LOOP:4: B:259:0x063c->B:312:0x07d5], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:440:0x07d5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:475:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:477:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:478:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v58 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r14v13, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r23v10 */
    /* JADX WARN: Type inference failed for: r23v17 */
    /* JADX WARN: Type inference failed for: r23v18 */
    /* JADX WARN: Type inference failed for: r23v19 */
    /* JADX WARN: Type inference failed for: r23v2, types: [k85] */
    /* JADX WARN: Type inference failed for: r23v21 */
    /* JADX WARN: Type inference failed for: r23v22 */
    /* JADX WARN: Type inference failed for: r23v23 */
    /* JADX WARN: Type inference failed for: r23v24 */
    /* JADX WARN: Type inference failed for: r23v25 */
    /* JADX WARN: Type inference failed for: r23v26 */
    /* JADX WARN: Type inference failed for: r23v27, types: [k85] */
    /* JADX WARN: Type inference failed for: r23v28 */
    /* JADX WARN: Type inference failed for: r23v29 */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v30 */
    /* JADX WARN: Type inference failed for: r23v31 */
    /* JADX WARN: Type inference failed for: r23v32 */
    /* JADX WARN: Type inference failed for: r23v33 */
    /* JADX WARN: Type inference failed for: r23v35 */
    /* JADX WARN: Type inference failed for: r23v36 */
    /* JADX WARN: Type inference failed for: r23v37 */
    /* JADX WARN: Type inference failed for: r23v38 */
    /* JADX WARN: Type inference failed for: r23v39 */
    /* JADX WARN: Type inference failed for: r23v40 */
    /* JADX WARN: Type inference failed for: r23v41 */
    /* JADX WARN: Type inference failed for: r23v42 */
    /* JADX WARN: Type inference failed for: r23v43 */
    /* JADX WARN: Type inference failed for: r23v44 */
    /* JADX WARN: Type inference failed for: r23v45 */
    /* JADX WARN: Type inference failed for: r23v46 */
    /* JADX WARN: Type inference failed for: r23v47 */
    /* JADX WARN: Type inference failed for: r23v48 */
    /* JADX WARN: Type inference failed for: r23v49 */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r23v50 */
    /* JADX WARN: Type inference failed for: r31v0, types: [ff5] */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26, types: [k85] */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(long r32, java.lang.String r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2736
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ff5.m(long, java.lang.String):void");
    }

    public final o25 m0(String str) {
        C().V0();
        j0();
        HashMap map = this.T0;
        o25 o25Var = (o25) map.get(str);
        if (o25Var != null) {
            return o25Var;
        }
        m25 m25Var = this.z;
        R(m25Var);
        tj4.i(str);
        m25Var.V0();
        m25Var.W0();
        o25 o25VarB = o25.b(m25Var.r1("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}));
        map.put(str, o25VarB);
        return o25VarB;
    }

    @Override // defpackage.m95
    public final t65 n() {
        k85 k85Var = this.C0;
        tj4.i(k85Var);
        t65 t65Var = k85Var.Y;
        k85.h(t65Var);
        return t65Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    public final Bundle n0(String str) {
        C().V0();
        j0();
        x75 x75Var = this.b;
        R(x75Var);
        if (x75Var.q1(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        t95 t95VarA = a(str);
        Bundle bundle2 = new Bundle();
        Iterator it = t95VarA.a.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            int iOrdinal = ((o95) entry.getValue()).ordinal();
            String str2 = iOrdinal != 2 ? iOrdinal != 3 ? null : "granted" : "denied";
            if (str2 != null) {
                bundle2.putString(((r95) entry.getKey()).b, str2);
            }
        }
        bundle.putAll(bundle2);
        o25 o25VarO0 = o0(str, m0(str), t95VarA, new rz4(2));
        Bundle bundle3 = new Bundle();
        for (Map.Entry entry2 : o25VarO0.e.entrySet()) {
            int iOrdinal2 = ((o95) entry2.getValue()).ordinal();
            String str3 = iOrdinal2 != 2 ? iOrdinal2 != 3 ? null : "granted" : "denied";
            if (str3 != null) {
                bundle3.putString(((r95) entry2.getKey()).b, str3);
            }
        }
        Boolean bool = o25VarO0.c;
        if (bool != null) {
            bundle3.putString("is_dma_region", bool.toString());
        }
        String str4 = o25VarO0.d;
        if (str4 != null) {
            bundle3.putString("cps_display_str", str4);
        }
        bundle.putAll(bundle3);
        m25 m25Var = this.z;
        R(m25Var);
        mf5 mf5VarP1 = m25Var.P1(str, "_npa");
        bundle.putString("ad_personalization", 1 != (mf5VarP1 != null ? mf5VarP1.e.equals(1L) : B(str, new rz4(2))) ? "granted" : "denied");
        return bundle;
    }

    public final boolean o(String str, String str2) {
        m25 m25Var = this.z;
        R(m25Var);
        b75 b75VarX1 = m25Var.X1(str);
        HashMap map = this.V0;
        if (b75VarX1 != null && i0().x1(str, b75VarX1.C())) {
            map.remove(str2);
            return true;
        }
        cf5 cf5Var = (cf5) map.get(str2);
        if (cf5Var != null) {
            cf5Var.a.z0().getClass();
            if (System.currentTimeMillis() < cf5Var.c) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.o25 o0(java.lang.String r11, defpackage.o25 r12, defpackage.t95 r13, defpackage.rz4 r14) {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ff5.o0(java.lang.String, o25, t95, rz4):o25");
    }

    public final void p(String str) {
        C().V0();
        j0();
        this.M0 = true;
        try {
            k85 k85Var = this.C0;
            k85Var.getClass();
            Boolean bool = k85Var.j().y0;
            if (bool == null) {
                n().C0.a("Upload data called on the client side before use of service was decided");
            } else if (bool.booleanValue()) {
                n().z0.a("Upload called in the client side when service should be used");
            } else if (this.F0 > 0) {
                K();
            } else {
                z65 z65Var = this.f;
                R(z65Var);
                if (z65Var.p1()) {
                    m25 m25Var = this.z;
                    R(m25Var);
                    if (m25Var.b1(str)) {
                        m25 m25Var2 = this.z;
                        R(m25Var2);
                        tj4.f(str);
                        m25Var2.V0();
                        m25Var2.W0();
                        List listA1 = m25Var2.a1(str, le5.a(qb5.GOOGLE_SIGNAL), 1);
                        if5 if5Var = listA1.isEmpty() ? null : (if5) listA1.get(0);
                        if (if5Var != null) {
                            j85 j85Var = if5Var.b;
                            n().H0.d("[sgtm] Uploading data from upload queue. appId, type, url", str, if5Var.e, if5Var.c);
                            byte[] bArrA = j85Var.a();
                            int i = 2;
                            if (Log.isLoggable(n().b1(), 2)) {
                                z65 z65Var2 = this.Z;
                                R(z65Var2);
                                n().H0.d("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(bArrA.length), z65Var2.y1(j85Var));
                            }
                            re5 re5Var = new re5(if5Var.c, if5Var.d, if5Var.e, null);
                            this.L0 = true;
                            z65 z65Var3 = this.f;
                            R(z65Var3);
                            z65Var3.t1(str, re5Var, j85Var, new ab5(this, str, if5Var, i));
                        }
                    } else {
                        n().H0.b(str, "[sgtm] Upload queue has no batches for appId");
                    }
                } else {
                    n().H0.a("Network not connected, ignoring upload request");
                    K();
                }
            }
            this.M0 = false;
            L();
        } catch (Throwable th) {
            this.M0 = false;
            L();
            throw th;
        }
    }

    public final void q(String str, boolean z, Long l, Long l2) {
        m25 m25Var = this.z;
        R(m25Var);
        b75 b75VarX1 = m25Var.X1(str);
        if (b75VarX1 != null) {
            k85 k85Var = b75VarX1.a;
            f85 f85Var = k85Var.Z;
            k85.h(f85Var);
            f85Var.V0();
            b75VarX1.Q |= b75VarX1.y != z;
            b75VarX1.y = z;
            f85 f85Var2 = k85Var.Z;
            k85.h(f85Var2);
            f85Var2.V0();
            b75VarX1.Q |= !Objects.equals(b75VarX1.z, l);
            b75VarX1.z = l;
            f85 f85Var3 = k85Var.Z;
            k85.h(f85Var3);
            f85Var3.V0();
            b75VarX1.Q |= !Objects.equals(b75VarX1.A, l2);
            b75VarX1.A = l2;
            if (b75VarX1.o()) {
                m25 m25Var2 = this.z;
                R(m25Var2);
                m25Var2.Y1(b75VarX1, false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(java.lang.String r9, defpackage.l85 r10) {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ff5.r(java.lang.String, l85):void");
    }

    @Override // defpackage.m95
    public final Context r0() {
        return this.C0.b;
    }

    public final void s(l85 l85Var, sb1 sb1Var) {
        String strP1;
        String strP12;
        for (int i = 0; i < l85Var.Z(); i++) {
            v75 v75Var = (v75) ((n85) l85Var.f).R1(i).g();
            Iterator it = v75Var.h().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if ("_c".equals(((b85) it.next()).o())) {
                    if (((n85) sb1Var.f).E0() >= c0().d1(((n85) sb1Var.f).n(), r55.m0)) {
                        int iD1 = c0().d1(((n85) sb1Var.f).n(), r55.z0);
                        LinkedList linkedList = this.H0;
                        z65 z65Var = this.Z;
                        if (iD1 > 0) {
                            m25 m25Var = this.z;
                            R(m25Var);
                            if (m25Var.Z1(b(), ((n85) sb1Var.f).n(), false, false, false, true).g > iD1) {
                                z75 z75VarZ = b85.z();
                                z75VarZ.h("_tnr");
                                z75VarZ.j(1L);
                                v75Var.k((b85) z75VarZ.e());
                            } else {
                                if (c0().f1(((n85) sb1Var.f).n(), r55.S0)) {
                                    strP12 = i0().P1();
                                    z75 z75VarZ2 = b85.z();
                                    z75VarZ2.h("_tu");
                                    z75VarZ2.i(strP12);
                                    v75Var.k((b85) z75VarZ2.e());
                                } else {
                                    strP12 = null;
                                }
                                z75 z75VarZ3 = b85.z();
                                z75VarZ3.h("_tr");
                                z75VarZ3.j(1L);
                                v75Var.k((b85) z75VarZ3.e());
                                R(z65Var);
                                ee5 ee5VarW1 = z65Var.w1(((n85) sb1Var.f).n(), l85Var, v75Var, strP12);
                                if (ee5VarW1 != null) {
                                    n().H0.c("Generated trigger URI. appId, uri", ((n85) sb1Var.f).n(), ee5VarW1.b);
                                    m25 m25Var2 = this.z;
                                    R(m25Var2);
                                    m25Var2.p1(((n85) sb1Var.f).n(), ee5VarW1);
                                    if (!linkedList.contains(((n85) sb1Var.f).n())) {
                                        linkedList.add(((n85) sb1Var.f).n());
                                    }
                                }
                            }
                        } else {
                            if (c0().f1(((n85) sb1Var.f).n(), r55.S0)) {
                                strP1 = i0().P1();
                                z75 z75VarZ4 = b85.z();
                                z75VarZ4.h("_tu");
                                z75VarZ4.i(strP1);
                                v75Var.k((b85) z75VarZ4.e());
                            } else {
                                strP1 = null;
                            }
                            z75 z75VarZ5 = b85.z();
                            z75VarZ5.h("_tr");
                            z75VarZ5.j(1L);
                            v75Var.k((b85) z75VarZ5.e());
                            R(z65Var);
                            ee5 ee5VarW12 = z65Var.w1(((n85) sb1Var.f).n(), l85Var, v75Var, strP1);
                            if (ee5VarW12 != null) {
                                n().H0.c("Generated trigger URI. appId, uri", ((n85) sb1Var.f).n(), ee5VarW12.b);
                                m25 m25Var3 = this.z;
                                R(m25Var3);
                                m25Var3.p1(((n85) sb1Var.f).n(), ee5VarW12);
                                if (!linkedList.contains(((n85) sb1Var.f).n())) {
                                    linkedList.add(((n85) sb1Var.f).n());
                                }
                            }
                        }
                    }
                    w75 w75Var = (w75) v75Var.e();
                    l85Var.c();
                    ((n85) l85Var.f).V(i, w75Var);
                }
            }
        }
    }

    public final void t(String str, z75 z75Var, Bundle bundle, String str2) {
        q55 q55Var;
        int iMax;
        List listUnmodifiableList = DesugarCollections.unmodifiableList(Arrays.asList("_o", "_sn", "_sc", "_si"));
        if (qf5.v1(((b85) z75Var.f).o()) || qf5.v1(str)) {
            x15 x15VarC0 = c0();
            x15VarC0.getClass();
            q55Var = r55.i0;
            iMax = Math.max(Math.max(Math.min(x15VarC0.d1(str2, q55Var), 500), 100), 256);
        } else {
            x15 x15VarC02 = c0();
            x15VarC02.getClass();
            q55Var = r55.i0;
            iMax = Math.max(Math.min(x15VarC02.d1(str2, q55Var), 500), 100);
        }
        long j = iMax;
        long jCodePointCount = ((b85) z75Var.f).q().codePointCount(0, ((b85) z75Var.f).q().length());
        i0();
        String strO = ((b85) z75Var.f).o();
        c0();
        String strA1 = qf5.a1(40, strO, true);
        if (jCodePointCount <= j || listUnmodifiableList.contains(((b85) z75Var.f).o())) {
            return;
        }
        if ("_ev".equals(((b85) z75Var.f).o())) {
            i0();
            String strQ = ((b85) z75Var.f).q();
            x15 x15VarC03 = c0();
            x15VarC03.getClass();
            bundle.putString("_ev", qf5.a1(Math.max(Math.max(Math.min(x15VarC03.d1(str2, q55Var), 500), 100), 256), strQ, true));
            return;
        }
        n().E0.c("Param value is too long; discarded. Name, value length", strA1, Long.valueOf(jCodePointCount));
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", strA1);
                bundle.putLong("_el", jCodePointCount);
            }
        }
        bundle.remove(((b85) z75Var.f).o());
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0153 A[EDGE_INSN: B:106:0x0153->B:52:0x0153 BREAK  A[LOOP:0: B:33:0x00f5->B:108:0x00f5], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070 A[Catch: all -> 0x0018, TryCatch #3 {all -> 0x0018, blocks: (B:4:0x0015, B:8:0x001d, B:16:0x0032, B:21:0x0082, B:20:0x0070, B:22:0x008f, B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:81:0x021e, B:83:0x0231, B:85:0x023c, B:93:0x025b, B:87:0x0242, B:89:0x024b, B:91:0x0251, B:92:0x0255, B:94:0x025e, B:95:0x0266, B:30:0x00d9, B:96:0x0267), top: B:105:0x0015, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008f A[Catch: all -> 0x0018, PHI: r0
      0x008f: PHI (r0v2 int) = (r0v0 int), (r0v35 int) binds: [B:9:0x0025, B:15:0x0030] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #3 {all -> 0x0018, blocks: (B:4:0x0015, B:8:0x001d, B:16:0x0032, B:21:0x0082, B:20:0x0070, B:22:0x008f, B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:81:0x021e, B:83:0x0231, B:85:0x023c, B:93:0x025b, B:87:0x0242, B:89:0x024b, B:91:0x0251, B:92:0x0255, B:94:0x025e, B:95:0x0266, B:30:0x00d9, B:96:0x0267), top: B:105:0x0015, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c8 A[Catch: all -> 0x0018, SQLiteException -> 0x00b7, TryCatch #1 {SQLiteException -> 0x00b7, blocks: (B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:81:0x021e, B:83:0x0231, B:85:0x023c, B:93:0x025b, B:87:0x0242, B:89:0x024b, B:91:0x0251, B:92:0x0255, B:94:0x025e, B:95:0x0266, B:30:0x00d9), top: B:102:0x00a4, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d9 A[Catch: all -> 0x0018, SQLiteException -> 0x00b7, TryCatch #1 {SQLiteException -> 0x00b7, blocks: (B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:81:0x021e, B:83:0x0231, B:85:0x023c, B:93:0x025b, B:87:0x0242, B:89:0x024b, B:91:0x0251, B:92:0x0255, B:94:0x025e, B:95:0x0266, B:30:0x00d9), top: B:102:0x00a4, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ff A[Catch: all -> 0x0150, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0150, blocks: (B:32:0x00ec, B:33:0x00f5, B:36:0x00ff, B:39:0x0113, B:41:0x011f, B:42:0x0121, B:46:0x0138, B:48:0x0142, B:52:0x0153, B:53:0x0158, B:55:0x015e, B:57:0x0171, B:59:0x0188, B:60:0x018a, B:62:0x019c, B:64:0x01b8, B:66:0x01dc, B:67:0x01eb, B:68:0x01ef, B:70:0x01f5, B:71:0x01fc, B:74:0x020a, B:76:0x020e, B:79:0x0215, B:80:0x0216), top: B:101:0x00ec, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015e A[Catch: all -> 0x0150, TryCatch #0 {all -> 0x0150, blocks: (B:32:0x00ec, B:33:0x00f5, B:36:0x00ff, B:39:0x0113, B:41:0x011f, B:42:0x0121, B:46:0x0138, B:48:0x0142, B:52:0x0153, B:53:0x0158, B:55:0x015e, B:57:0x0171, B:59:0x0188, B:60:0x018a, B:62:0x019c, B:64:0x01b8, B:66:0x01dc, B:67:0x01eb, B:68:0x01ef, B:70:0x01f5, B:71:0x01fc, B:74:0x020a, B:76:0x020e, B:79:0x0215, B:80:0x0216), top: B:101:0x00ec, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b8 A[Catch: all -> 0x0150, TryCatch #0 {all -> 0x0150, blocks: (B:32:0x00ec, B:33:0x00f5, B:36:0x00ff, B:39:0x0113, B:41:0x011f, B:42:0x0121, B:46:0x0138, B:48:0x0142, B:52:0x0153, B:53:0x0158, B:55:0x015e, B:57:0x0171, B:59:0x0188, B:60:0x018a, B:62:0x019c, B:64:0x01b8, B:66:0x01dc, B:67:0x01eb, B:68:0x01ef, B:70:0x01f5, B:71:0x01fc, B:74:0x020a, B:76:0x020e, B:79:0x0215, B:80:0x0216), top: B:101:0x00ec, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01f5 A[Catch: all -> 0x0150, TRY_LEAVE, TryCatch #0 {all -> 0x0150, blocks: (B:32:0x00ec, B:33:0x00f5, B:36:0x00ff, B:39:0x0113, B:41:0x011f, B:42:0x0121, B:46:0x0138, B:48:0x0142, B:52:0x0153, B:53:0x0158, B:55:0x015e, B:57:0x0171, B:59:0x0188, B:60:0x018a, B:62:0x019c, B:64:0x01b8, B:66:0x01dc, B:67:0x01eb, B:68:0x01ef, B:70:0x01f5, B:71:0x01fc, B:74:0x020a, B:76:0x020e, B:79:0x0215, B:80:0x0216), top: B:101:0x00ec, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0231 A[Catch: all -> 0x0018, SQLiteException -> 0x00b7, TryCatch #1 {SQLiteException -> 0x00b7, blocks: (B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:81:0x021e, B:83:0x0231, B:85:0x023c, B:93:0x025b, B:87:0x0242, B:89:0x024b, B:91:0x0251, B:92:0x0255, B:94:0x025e, B:95:0x0266, B:30:0x00d9), top: B:102:0x00a4, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0242 A[Catch: all -> 0x0018, SQLiteException -> 0x00b7, TryCatch #1 {SQLiteException -> 0x00b7, blocks: (B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:81:0x021e, B:83:0x0231, B:85:0x023c, B:93:0x025b, B:87:0x0242, B:89:0x024b, B:91:0x0251, B:92:0x0255, B:94:0x025e, B:95:0x0266, B:30:0x00d9), top: B:102:0x00a4, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(boolean r18, int r19, java.lang.Throwable r20, byte[] r21, java.lang.String r22, java.util.List r23) {
        /*
            Method dump skipped, instruction units count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ff5.u(boolean, int, java.lang.Throwable, byte[], java.lang.String, java.util.List):void");
    }

    public final void v(b75 b75Var) {
        ie ieVar;
        ie ieVar2;
        C().V0();
        if (TextUtils.isEmpty(b75Var.G())) {
            String strD = b75Var.D();
            tj4.i(strD);
            w(strD, 204, null, null, null);
            return;
        }
        String strD2 = b75Var.D();
        tj4.i(strD2);
        n().H0.b(strD2, "Fetching remote configuration");
        x75 x75Var = this.b;
        R(x75Var);
        j65 j65VarH1 = x75Var.h1(strD2);
        R(x75Var);
        x75Var.V0();
        String str = (String) x75Var.G0.get(strD2);
        if (j65VarH1 != null) {
            if (TextUtils.isEmpty(str)) {
                ieVar2 = null;
            } else {
                ieVar2 = new ie(0);
                ieVar2.put("If-Modified-Since", str);
            }
            R(x75Var);
            x75Var.V0();
            String str2 = (String) x75Var.H0.get(strD2);
            if (!TextUtils.isEmpty(str2)) {
                if (ieVar2 == null) {
                    ieVar2 = new ie(0);
                }
                ieVar2.put(HttpHeaders.Names.IF_NONE_MATCH, str2);
            }
            ieVar = ieVar2;
        } else {
            ieVar = null;
        }
        this.K0 = true;
        z65 z65Var = this.f;
        R(z65Var);
        rz4 rz4Var = new rz4(7, this);
        k85 k85Var = (k85) z65Var.f;
        z65Var.V0();
        z65Var.W0();
        te5 te5Var = z65Var.X.A0;
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder builderAppendQueryParameter = builder.scheme((String) r55.f.a(null)).encodedAuthority((String) r55.g.a(null)).path("config/app/".concat(String.valueOf(b75Var.G()))).appendQueryParameter("platform", "android");
        ((k85) te5Var.f).A.a1();
        builderAppendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(133005L)).appendQueryParameter("runtime_version", "0");
        String string = builder.build().toString();
        try {
            URL url = new URI(string).toURL();
            f85 f85Var = k85Var.Z;
            k85.h(f85Var);
            f85Var.h1(new x65(z65Var, b75Var.D(), url, (byte[]) null, ieVar, rz4Var));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.c("Failed to parse config URL. Not fetching. appId", t65.Z0(b75Var.D()), string);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x015a A[Catch: all -> 0x005f, TryCatch #1 {all -> 0x005f, blocks: (B:8:0x0030, B:18:0x004e, B:55:0x015d, B:26:0x006c, B:31:0x00c8, B:30:0x00b6, B:32:0x00cd, B:36:0x00de, B:40:0x00f4, B:42:0x010c, B:44:0x0127, B:46:0x0130, B:48:0x0136, B:49:0x013a, B:51:0x0143, B:53:0x0152, B:54:0x015a, B:43:0x0118, B:37:0x00e5, B:39:0x00ee), top: B:64:0x0030, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(java.lang.String r10, int r11, java.lang.Throwable r12, byte[] r13, java.util.Map r14) {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ff5.w(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    public final void x() {
        C().V0();
        j0();
        if (this.E0) {
            return;
        }
        this.E0 = true;
        C().V0();
        FileLock fileLock = this.N0;
        k85 k85Var = this.C0;
        if (fileLock == null || !fileLock.isValid()) {
            x15 x15Var = ((k85) this.z.f).A;
            try {
                FileChannel channel = new RandomAccessFile(new File(new File(k85Var.b.getFilesDir(), "google_app_measurement.db").getPath()), "rw").getChannel();
                this.O0 = channel;
                FileLock fileLockTryLock = channel.tryLock();
                this.N0 = fileLockTryLock;
                if (fileLockTryLock == null) {
                    n().z0.a("Storage concurrent data access panic");
                    return;
                }
                n().H0.a("Storage concurrent access okay");
            } catch (FileNotFoundException e) {
                n().z0.b(e, "Failed to acquire storage lock");
                return;
            } catch (IOException e2) {
                n().z0.b(e2, "Failed to access storage lock file");
                return;
            } catch (OverlappingFileLockException e3) {
                n().C0.b(e3, "Storage lock already acquired");
                return;
            }
        } else {
            n().H0.a("Storage concurrent access okay");
        }
        FileChannel fileChannel = this.O0;
        C().V0();
        int i = 0;
        if (fileChannel == null || !fileChannel.isOpen()) {
            n().z0.a("Bad channel to read from");
        } else {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0L);
                int i2 = fileChannel.read(byteBufferAllocate);
                if (i2 == 4) {
                    byteBufferAllocate.flip();
                    i = byteBufferAllocate.getInt();
                } else if (i2 != -1) {
                    n().C0.b(Integer.valueOf(i2), "Unexpected data length. Bytes read");
                }
            } catch (IOException e4) {
                n().z0.b(e4, "Failed to read from channel");
            }
        }
        d65 d65VarL = k85Var.l();
        d65VarL.W0();
        int i3 = d65VarL.y0;
        C().V0();
        if (i > i3) {
            n().z0.c("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i3));
            return;
        }
        if (i < i3) {
            FileChannel fileChannel2 = this.O0;
            C().V0();
            if (fileChannel2 == null || !fileChannel2.isOpen()) {
                n().z0.a("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                byteBufferAllocate2.putInt(i3);
                byteBufferAllocate2.flip();
                try {
                    fileChannel2.truncate(0L);
                    fileChannel2.write(byteBufferAllocate2);
                    fileChannel2.force(true);
                    if (fileChannel2.size() != 4) {
                        n().z0.b(Long.valueOf(fileChannel2.size()), "Error writing to channel. Bytes written");
                    }
                    n().H0.c("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i3));
                    return;
                } catch (IOException e5) {
                    n().z0.b(e5, "Failed to write to channel");
                }
            }
            n().z0.c("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i3));
        }
    }

    @Override // defpackage.m95
    public final wl3 z0() {
        k85 k85Var = this.C0;
        tj4.i(k85Var);
        return k85Var.B0;
    }
}
