package defpackage;

import android.app.AlarmManager;
import android.app.BroadcastOptions;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import io.netty.handler.codec.http.HttpHeaders;
import io.sentry.android.core.a1;
import io.sentry.android.core.u;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
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
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;

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
    */
    public final boolean F(long j, String str) {
        boolean z;
        int i;
        Long l;
        k85 k85Var;
        long j2;
        k85 k85Var2;
        int i2;
        ArrayList arrayList;
        int i3;
        int iDelete;
        long j3;
        Long l2;
        long j4;
        int iM1;
        k85 k85Var3;
        sb1 sb1Var;
        long jP;
        String str2;
        String str3;
        boolean z2;
        int i4;
        String str4;
        String str5;
        int i5;
        int i6;
        String str6;
        int i7;
        int i8;
        int i9;
        boolean z3;
        ff5 ff5Var = this;
        String str7 = "1";
        String str8 = "_ai";
        String str9 = "purchase";
        String str10 = "items";
        Long l3 = 1L;
        ff5Var.e0().H1();
        try {
            sb1 sb1Var2 = new sb1(ff5Var);
            ff5Var.e0().D1(str, j, ff5Var.R0, sb1Var2);
            sb1 sb1Var3 = sb1Var2;
            ArrayList arrayList2 = (ArrayList) sb1Var3.A;
            if (arrayList2 == null || arrayList2.isEmpty()) {
                e0().I1();
                z = false;
            } else {
                l85 l85Var = (l85) ((n85) sb1Var3.f).g();
                l85Var.c();
                ((n85) l85Var.f).Y();
                int i10 = -1;
                int i11 = -1;
                int i12 = 0;
                int i13 = 0;
                boolean z4 = false;
                boolean z5 = false;
                v75 v75Var = null;
                v75 v75Var2 = null;
                while (true) {
                    int size = ((ArrayList) sb1Var3.A).size();
                    i = i13;
                    l = l3;
                    k85Var = ff5Var.C0;
                    String str11 = str10;
                    if (i12 >= size) {
                        break;
                    }
                    v75 v75Var3 = (v75) ((w75) ((ArrayList) sb1Var3.A).get(i12)).g();
                    int i14 = i12;
                    int i15 = i10;
                    if (ff5Var.d0().k1(((n85) sb1Var3.f).n(), v75Var3.n())) {
                        ff5Var.n().C0.c("Dropping blocked raw event. appId", t65.Z0(((n85) sb1Var3.f).n()), k85Var.A0.a(v75Var3.n()));
                        if (!str7.equals(ff5Var.d0().j0(((n85) sb1Var3.f).n(), "measurement.upload.blacklist_internal")) && !str7.equals(ff5Var.d0().j0(((n85) sb1Var3.f).n(), "measurement.upload.blacklist_public")) && !"_err".equals(v75Var3.n())) {
                            ff5Var.i0();
                            qf5.l1(ff5Var.a1, ((n85) sb1Var3.f).n(), 11, "_ev", v75Var3.n(), 0);
                        }
                        str2 = str7;
                        str5 = str8;
                        str4 = str9;
                        i13 = i;
                        str6 = str11;
                        i7 = i14;
                        i10 = i15;
                    } else {
                        String strN = v75Var3.n();
                        str2 = str7;
                        if (strN.equals(str9) || strN.equals("_iap") || strN.equals("ecommerce_purchase")) {
                            z75 z75VarZ = b85.z();
                            str3 = "_et";
                            z75VarZ.h("_ct");
                            if (!z4) {
                                String strN2 = ((n85) sb1Var3.f).n();
                                String str12 = (ff5Var.O(strN2, str9) && ff5Var.O(strN2, "_iap") && ff5Var.O(strN2, "ecommerce_purchase")) ? "new" : "returning";
                                z75VarZ.i(str12);
                                v75Var3.k((b85) z75VarZ.e());
                                z4 = true;
                            }
                        } else {
                            str3 = "_et";
                        }
                        if (v75Var3.n().equals(n12.Z(str8, xb5.z0, xb5.Z))) {
                            v75Var3.c();
                            ((w75) v75Var3.f).D(str8);
                            ff5Var.n().H0.a("Renaming ad_impression to _ai");
                            if (Log.isLoggable(ff5Var.n().b1(), 5)) {
                                for (int i16 = 0; i16 < v75Var3.i(); i16++) {
                                    if ("ad_platform".equals(v75Var3.j(i16).o()) && !v75Var3.j(i16).q().isEmpty() && "admob".equalsIgnoreCase(v75Var3.j(i16).q())) {
                                        ff5Var.n().E0.a("AdMob ad impression logged from app. Potentially duplicative.");
                                    }
                                }
                            }
                        }
                        boolean zL1 = ff5Var.d0().l1(((n85) sb1Var3.f).n(), v75Var3.n());
                        if (zL1) {
                            z2 = zL1;
                        } else {
                            ff5Var.h0();
                            String strN3 = v75Var3.n();
                            tj4.f(strN3);
                            z2 = zL1;
                            if (strN3.hashCode() != 95027 || !strN3.equals("_ui")) {
                                str5 = str8;
                                str4 = str9;
                                i4 = i11;
                                z2 = false;
                            }
                            if (!z2) {
                                ArrayList arrayList3 = new ArrayList(v75Var3.h());
                                int i17 = -1;
                                int i18 = -1;
                                for (int i19 = 0; i19 < arrayList3.size(); i19++) {
                                    if ("value".equals(((b85) arrayList3.get(i19)).o())) {
                                        i17 = i19;
                                    } else if ("currency".equals(((b85) arrayList3.get(i19)).o())) {
                                        i18 = i19;
                                    }
                                }
                                if (i17 != -1) {
                                    if (((b85) arrayList3.get(i17)).r() || ((b85) arrayList3.get(i17)).v()) {
                                        if (i18 != -1) {
                                            String strQ = ((b85) arrayList3.get(i18)).q();
                                            if (strQ.length() == 3) {
                                                int iCharCount = 0;
                                                while (iCharCount < strQ.length()) {
                                                    int iCodePointAt = strQ.codePointAt(iCharCount);
                                                    if (Character.isLetter(iCodePointAt)) {
                                                        iCharCount += Character.charCount(iCodePointAt);
                                                    }
                                                }
                                            }
                                        }
                                        ff5Var.n().E0.a("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                        v75Var3.m(i17);
                                        A(v75Var3, "_c");
                                        z(v75Var3, 19, "currency");
                                        break;
                                    }
                                    ff5Var.n().E0.a("Value must be specified with a numeric type.");
                                    v75Var3.m(i17);
                                    A(v75Var3, "_c");
                                    z(v75Var3, 18, "value");
                                }
                                if ("_e".equals(v75Var3.n())) {
                                    i5 = i4;
                                    if ("_vs".equals(v75Var3.n())) {
                                        ff5Var.h0();
                                        if (z65.d1(str3, (w75) v75Var3.e()) == null) {
                                            if (v75Var != null && Math.abs(v75Var.o() - v75Var3.o()) <= 1000) {
                                                v75 v75Var4 = (v75) v75Var.clone();
                                                if (ff5Var.H(v75Var4, v75Var3)) {
                                                    l85Var.a0(i15, v75Var4);
                                                    i10 = i15;
                                                    i11 = i5;
                                                    v75Var = null;
                                                    v75Var2 = null;
                                                    if (v75Var3.i() != 0) {
                                                    }
                                                    i7 = i14;
                                                    ((ArrayList) sb1Var3.A).set(i7, (w75) v75Var3.e());
                                                    l85Var.b0(v75Var3);
                                                    i13 = i + 1;
                                                }
                                            }
                                            i10 = i15;
                                            v75Var2 = v75Var3;
                                            i11 = i;
                                            if (v75Var3.i() != 0) {
                                            }
                                            i7 = i14;
                                            ((ArrayList) sb1Var3.A).set(i7, (w75) v75Var3.e());
                                            l85Var.b0(v75Var3);
                                            i13 = i + 1;
                                        }
                                        i6 = i15;
                                        i10 = i6;
                                        i11 = i5;
                                        if (v75Var3.i() != 0) {
                                        }
                                        i7 = i14;
                                        ((ArrayList) sb1Var3.A).set(i7, (w75) v75Var3.e());
                                        l85Var.b0(v75Var3);
                                        i13 = i + 1;
                                    } else {
                                        i6 = i15;
                                        if (ff5Var.c0().f1(null, r55.k1) && (("_f".equals(v75Var3.n()) || "_v".equals(v75Var3.n())) && ("_f".equals(v75Var3.n()) || "_v".equals(v75Var3.n())))) {
                                            int i20 = 0;
                                            while (true) {
                                                if (i20 >= v75Var3.i()) {
                                                    break;
                                                }
                                                b85 b85VarJ = v75Var3.j(i20);
                                                if ("_elt".equals(b85VarJ.o())) {
                                                    v75Var3.q(b85VarJ.s());
                                                    v75Var3.m(i20);
                                                    break;
                                                }
                                                i20++;
                                            }
                                        }
                                        i10 = i6;
                                        i11 = i5;
                                        if (v75Var3.i() != 0) {
                                        }
                                        i7 = i14;
                                        ((ArrayList) sb1Var3.A).set(i7, (w75) v75Var3.e());
                                        l85Var.b0(v75Var3);
                                        i13 = i + 1;
                                    }
                                } else {
                                    ff5Var.h0();
                                    if (z65.d1("_fr", (w75) v75Var3.e()) == null) {
                                        if (v75Var2 != null && Math.abs(v75Var2.o() - v75Var3.o()) <= 1000) {
                                            v75 v75Var5 = (v75) v75Var2.clone();
                                            if (ff5Var.H(v75Var3, v75Var5)) {
                                                int i21 = i4;
                                                l85Var.a0(i21, v75Var5);
                                                i11 = i21;
                                                i10 = i15;
                                                v75Var = null;
                                                v75Var2 = null;
                                                if (v75Var3.i() != 0) {
                                                    ff5Var.h0();
                                                    Bundle bundleC1 = z65.c1(v75Var3.h());
                                                    int i22 = 0;
                                                    while (i22 < v75Var3.i()) {
                                                        b85 b85VarJ2 = v75Var3.j(i22);
                                                        String str13 = str11;
                                                        if (!b85VarJ2.o().equals(str13) || b85VarJ2.x().isEmpty()) {
                                                            i8 = i22;
                                                            if (!b85VarJ2.o().equals(str13)) {
                                                                ff5Var.t(v75Var3.n(), (z75) b85VarJ2.g(), bundleC1, ((n85) sb1Var3.f).n());
                                                            }
                                                        } else {
                                                            String strN4 = ((n85) sb1Var3.f).n();
                                                            List listX = b85VarJ2.x();
                                                            Bundle[] bundleArr = new Bundle[listX.size()];
                                                            int i23 = 0;
                                                            while (i23 < listX.size()) {
                                                                b85 b85Var = (b85) listX.get(i23);
                                                                ff5Var.h0();
                                                                Bundle bundleC12 = z65.c1(b85Var.x());
                                                                Iterator it = b85Var.x().iterator();
                                                                while (it.hasNext()) {
                                                                    ff5Var.t(v75Var3.n(), (z75) ((b85) it.next()).g(), bundleC12, strN4);
                                                                    i22 = i22;
                                                                    listX = listX;
                                                                }
                                                                bundleArr[i23] = bundleC12;
                                                                i23++;
                                                                i22 = i22;
                                                                listX = listX;
                                                            }
                                                            i8 = i22;
                                                            bundleC1.putParcelableArray(str13, bundleArr);
                                                        }
                                                        i22 = i8 + 1;
                                                        str11 = str13;
                                                    }
                                                    str6 = str11;
                                                    v75Var3.c();
                                                    ((w75) v75Var3.f).B();
                                                    z65 z65VarH0 = ff5Var.h0();
                                                    ArrayList arrayList4 = new ArrayList();
                                                    for (String str14 : bundleC1.keySet()) {
                                                        z75 z75VarZ2 = b85.z();
                                                        z75VarZ2.h(str14);
                                                        Object obj = bundleC1.get(str14);
                                                        if (obj != null) {
                                                            z65VarH0.v1(z75VarZ2, obj);
                                                            arrayList4.add((b85) z75VarZ2.e());
                                                        }
                                                    }
                                                    Iterator it2 = arrayList4.iterator();
                                                    while (it2.hasNext()) {
                                                        v75Var3.k((b85) it2.next());
                                                    }
                                                } else {
                                                    str6 = str11;
                                                }
                                                i7 = i14;
                                                ((ArrayList) sb1Var3.A).set(i7, (w75) v75Var3.e());
                                                l85Var.b0(v75Var3);
                                                i13 = i + 1;
                                            }
                                        }
                                        i11 = i4;
                                        v75Var = v75Var3;
                                        i10 = i;
                                        if (v75Var3.i() != 0) {
                                        }
                                        i7 = i14;
                                        ((ArrayList) sb1Var3.A).set(i7, (w75) v75Var3.e());
                                        l85Var.b0(v75Var3);
                                        i13 = i + 1;
                                    } else {
                                        i5 = i4;
                                        i6 = i15;
                                        i10 = i6;
                                        i11 = i5;
                                        if (v75Var3.i() != 0) {
                                        }
                                        i7 = i14;
                                        ((ArrayList) sb1Var3.A).set(i7, (w75) v75Var3.e());
                                        l85Var.b0(v75Var3);
                                        i13 = i + 1;
                                    }
                                }
                            } else if ("_e".equals(v75Var3.n())) {
                            }
                        }
                        str5 = str8;
                        int i24 = 0;
                        boolean z6 = false;
                        boolean z7 = false;
                        while (true) {
                            str4 = str9;
                            if (i24 >= v75Var3.i()) {
                                break;
                            }
                            if ("_c".equals(v75Var3.j(i24).o())) {
                                z75 z75Var = (z75) v75Var3.j(i24).g();
                                i9 = i11;
                                z3 = z7;
                                z75Var.j(1L);
                                b85 b85Var2 = (b85) z75Var.e();
                                v75Var3.c();
                                ((w75) v75Var3.f).y(i24, b85Var2);
                                z6 = true;
                            } else {
                                i9 = i11;
                                z3 = z7;
                                if ("_r".equals(v75Var3.j(i24).o())) {
                                    z75 z75Var2 = (z75) v75Var3.j(i24).g();
                                    z75Var2.j(1L);
                                    b85 b85Var3 = (b85) z75Var2.e();
                                    v75Var3.c();
                                    ((w75) v75Var3.f).y(i24, b85Var3);
                                    z7 = true;
                                }
                                i24++;
                                str9 = str4;
                                i11 = i9;
                            }
                            z7 = z3;
                            i24++;
                            str9 = str4;
                            i11 = i9;
                        }
                        i4 = i11;
                        boolean z8 = z7;
                        if (!z6 && z2) {
                            ff5Var.n().H0.b(k85Var.A0.a(v75Var3.n()), "Marking event as conversion");
                            z75 z75VarZ3 = b85.z();
                            z75VarZ3.h("_c");
                            z75VarZ3.j(1L);
                            v75Var3.l(z75VarZ3);
                        }
                        if (!z8) {
                            ff5Var.n().H0.b(k85Var.A0.a(v75Var3.n()), "Marking event as real-time");
                            z75 z75VarZ4 = b85.z();
                            z75VarZ4.h("_r");
                            z75VarZ4.j(1L);
                            v75Var3.l(z75VarZ4);
                        }
                        if (ff5Var.e0().Z1(ff5Var.b(), ((n85) sb1Var3.f).n(), false, true, false, false).e > ff5Var.c0().d1(((n85) sb1Var3.f).n(), r55.p)) {
                            A(v75Var3, "_r");
                        } else {
                            z5 = true;
                        }
                        if (qf5.V1(v75Var3.n()) && z2 && ff5Var.e0().Z1(ff5Var.b(), ((n85) sb1Var3.f).n(), true, false, false, false).c > ff5Var.c0().d1(((n85) sb1Var3.f).n(), r55.o)) {
                            ff5Var.n().C0.b(t65.Z0(((n85) sb1Var3.f).n()), "Too many conversions. Not logging as conversion. appId");
                            boolean z9 = false;
                            z75 z75Var3 = null;
                            int i25 = -1;
                            for (int i26 = 0; i26 < v75Var3.i(); i26++) {
                                b85 b85VarJ3 = v75Var3.j(i26);
                                if ("_c".equals(b85VarJ3.o())) {
                                    z75Var3 = (z75) b85VarJ3.g();
                                    i25 = i26;
                                } else if ("_err".equals(b85VarJ3.o())) {
                                    z9 = true;
                                }
                            }
                            if (z9) {
                                if (z75Var3 != null) {
                                    v75Var3.m(i25);
                                } else {
                                    z75Var3 = null;
                                    if (z75Var3 == null) {
                                    }
                                }
                            } else if (z75Var3 == null) {
                                z75 z75Var4 = (z75) z75Var3.clone();
                                z75Var4.h("_err");
                                z75Var4.j(10L);
                                b85 b85Var4 = (b85) z75Var4.e();
                                v75Var3.c();
                                ((w75) v75Var3.f).y(i25, b85Var4);
                            } else {
                                ff5Var.n().z0.b(t65.Z0(((n85) sb1Var3.f).n()), "Did not find conversion parameter. appId");
                            }
                        }
                        if (!z2) {
                        }
                    }
                    i12 = i7 + 1;
                    str10 = str6;
                    l3 = l;
                    str7 = str2;
                    str8 = str5;
                    str9 = str4;
                }
                long j5 = 0;
                long jLongValue = 0;
                int i27 = i;
                int i28 = 0;
                while (i28 < i27) {
                    w75 w75VarR1 = ((n85) l85Var.f).R1(i28);
                    if ("_e".equals(w75VarR1.q())) {
                        ff5Var.h0();
                        if (z65.d1("_fr", w75VarR1) != null) {
                            l85Var.c0(i28);
                            i27--;
                            i28--;
                        } else {
                            ff5Var.h0();
                            b85 b85VarD1 = z65.d1("_et", w75VarR1);
                            if (b85VarD1 != null) {
                                Long lValueOf = b85VarD1.r() ? Long.valueOf(b85VarD1.s()) : null;
                                if (lValueOf != null && lValueOf.longValue() > 0) {
                                    jLongValue += lValueOf.longValue();
                                }
                            }
                        }
                    }
                    i28++;
                }
                ff5Var.G(l85Var, jLongValue, false);
                Iterator it3 = l85Var.Y().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    if ("_s".equals(((w75) it3.next()).q())) {
                        ff5Var.e0().N1(l85Var.o(), "_se");
                        break;
                    }
                }
                if (z65.J1("_sid", l85Var) >= 0) {
                    ff5Var.G(l85Var, jLongValue, true);
                } else {
                    int iJ1 = z65.J1("_se", l85Var);
                    if (iJ1 >= 0) {
                        l85Var.c();
                        ((n85) l85Var.f).c0(iJ1);
                        ff5Var.n().z0.b(t65.Z0(((n85) sb1Var3.f).n()), "Session engagement user property is in the bundle without session ID. appId");
                    }
                }
                String strN5 = ((n85) sb1Var3.f).n();
                ff5Var.C().V0();
                ff5Var.j0();
                b75 b75VarX1 = ff5Var.e0().X1(strN5);
                if (b75VarX1 == null) {
                    ff5Var.n().z0.b(t65.Z0(strN5), "Cannot fix consent fields without appInfo. appId");
                } else {
                    ff5Var.h(b75VarX1, l85Var);
                }
                String strN6 = ((n85) sb1Var3.f).n();
                ff5Var.C().V0();
                ff5Var.j0();
                b75 b75VarX12 = ff5Var.e0().X1(strN6);
                if (b75VarX12 == null) {
                    ff5Var.n().C0.b(t65.Z0(strN6), "Cannot populate ad_campaign_info without appInfo. appId");
                } else {
                    ff5Var.i(b75VarX12, l85Var);
                }
                l85Var.c();
                ((n85) l85Var.f).f0(Long.MAX_VALUE);
                l85Var.c();
                ((n85) l85Var.f).g0(Long.MIN_VALUE);
                for (int i29 = 0; i29 < l85Var.Z(); i29++) {
                    w75 w75VarR12 = ((n85) l85Var.f).R1(i29);
                    if (w75VarR12.s() < ((n85) l85Var.f).Y1()) {
                        long jS = w75VarR12.s();
                        l85Var.c();
                        ((n85) l85Var.f).f0(jS);
                    }
                    if (w75VarR12.s() > ((n85) l85Var.f).a2()) {
                        long jS2 = w75VarR12.s();
                        l85Var.c();
                        ((n85) l85Var.f).g0(jS2);
                    }
                }
                l85Var.Q();
                t95 t95Var = t95.c;
                t95 t95VarJ = ff5Var.a(((n85) sb1Var3.f).n()).j(t95.c(100, ((n85) sb1Var3.f).s0()));
                t95 t95VarA1 = ff5Var.e0().A1(((n85) sb1Var3.f).n());
                ff5Var.e0().z1(((n85) sb1Var3.f).n(), t95VarJ);
                r95 r95Var = r95.ANALYTICS_STORAGE;
                if (!t95VarJ.i(r95Var) && t95VarA1.i(r95Var)) {
                    ff5Var.e0().L1(((n85) sb1Var3.f).n());
                } else if (t95VarJ.i(r95Var) && !t95VarA1.i(r95Var)) {
                    ff5Var.e0().M1(((n85) sb1Var3.f).n());
                }
                r95 r95Var2 = r95.AD_STORAGE;
                if (!t95VarJ.i(r95Var2)) {
                    l85Var.c();
                    ((n85) l85Var.f).x1();
                    l85Var.c();
                    ((n85) l85Var.f).z1();
                    l85Var.c();
                    ((n85) l85Var.f).Q0();
                }
                if (!t95VarJ.i(r95Var)) {
                    l85Var.c();
                    ((n85) l85Var.f).B1();
                    l85Var.c();
                    ((n85) l85Var.f).X0();
                }
                mg5.a();
                if (ff5Var.c0().f1(((n85) sb1Var3.f).n(), r55.Q0)) {
                    ff5Var.i0();
                    if (qf5.t1(((n85) sb1Var3.f).n()) && ff5Var.a(((n85) sb1Var3.f).n()).i(r95Var2) && ((n85) sb1Var3.f).x0()) {
                        ff5Var.s(l85Var, sb1Var3);
                    }
                }
                l85Var.c();
                ((n85) l85Var.f).J1();
                l85Var.N(ff5Var.g0().Z0(l85Var.o(), l85Var.Y(), DesugarCollections.unmodifiableList(((n85) l85Var.f).S1()), Long.valueOf(((n85) l85Var.f).Y1()), Long.valueOf(((n85) l85Var.f).a2()), !t95VarJ.i(r95Var)));
                if (ff5Var.c0().X0(((n85) sb1Var3.f).n())) {
                    HashMap map = new HashMap();
                    ArrayList arrayList5 = new ArrayList();
                    SecureRandom secureRandomU1 = ff5Var.i0().U1();
                    int i30 = 0;
                    while (i30 < l85Var.Z()) {
                        v75 v75Var6 = (v75) ((n85) l85Var.f).R1(i30).g();
                        if (v75Var6.n().equals("_ep")) {
                            ff5Var.h0();
                            String str15 = (String) z65.e1("_en", (w75) v75Var6.e());
                            w25 w25VarT1 = (w25) map.get(str15);
                            if (w25VarT1 == null) {
                                m25 m25VarE0 = ff5Var.e0();
                                j3 = j5;
                                String strN7 = ((n85) sb1Var3.f).n();
                                tj4.i(str15);
                                w25VarT1 = m25VarE0.t1("events", strN7, str15);
                                if (w25VarT1 != null) {
                                    map.put(str15, w25VarT1);
                                }
                            } else {
                                j3 = j5;
                            }
                            if (w25VarT1 == null || w25VarT1.i != null) {
                                l2 = l;
                            } else {
                                Long l4 = w25VarT1.j;
                                if (l4 != null && l4.longValue() > 1) {
                                    ff5Var.h0();
                                    z65.b1(v75Var6, "_sr", l4);
                                }
                                Boolean bool = w25VarT1.k;
                                if (bool == null || !bool.booleanValue()) {
                                    l2 = l;
                                } else {
                                    ff5Var.h0();
                                    l2 = l;
                                    z65.b1(v75Var6, "_efs", l2);
                                }
                                arrayList5.add((w75) v75Var6.e());
                            }
                            l85Var.a0(i30, v75Var6);
                        } else {
                            j3 = j5;
                            l2 = l;
                            x75 x75VarD0 = ff5Var.d0();
                            String strN8 = ((n85) sb1Var3.f).n();
                            String strJ0 = x75VarD0.j0(strN8, "measurement.account.time_zone_offset_minutes");
                            if (TextUtils.isEmpty(strJ0)) {
                                j4 = j3;
                                i0();
                                long j6 = j4 * 60000;
                                long jO = (v75Var6.o() + j6) / 86400000;
                                w75 w75Var = (w75) v75Var6.e();
                                if (TextUtils.isEmpty("_dbg")) {
                                }
                            } else {
                                try {
                                    j4 = Long.parseLong(strJ0);
                                } catch (NumberFormatException e) {
                                    ((k85) x75VarD0.f).n().C0.c("Unable to parse timezone offset. appId", t65.Z0(strN8), e);
                                    j4 = j3;
                                }
                                i0();
                                long j62 = j4 * 60000;
                                long jO2 = (v75Var6.o() + j62) / 86400000;
                                w75 w75Var2 = (w75) v75Var6.e();
                                if (TextUtils.isEmpty("_dbg")) {
                                    Iterator it4 = w75Var2.n().iterator();
                                    while (true) {
                                        if (!it4.hasNext()) {
                                            break;
                                        }
                                        b85 b85Var5 = (b85) it4.next();
                                        if ("_dbg".equals(b85Var5.o())) {
                                            if (l2.equals(Long.valueOf(b85Var5.s()))) {
                                                iM1 = 1;
                                            }
                                        }
                                    }
                                    iM1 = d0().m1(((n85) sb1Var3.f).n(), v75Var6.n());
                                    if (iM1 > 0) {
                                        n().C0.c("Sample rate must be positive. event, rate", v75Var6.n(), Integer.valueOf(iM1));
                                        arrayList5.add((w75) v75Var6.e());
                                        l85Var.a0(i30, v75Var6);
                                    } else {
                                        w25 w25VarB = (w25) map.get(v75Var6.n());
                                        if (w25VarB == null) {
                                            k85Var3 = k85Var;
                                            w25VarB = e0().t1("events", ((n85) sb1Var3.f).n(), v75Var6.n());
                                            if (w25VarB == null) {
                                                n().C0.c("Event being bundled has no eventAggregate. appId, eventName", ((n85) sb1Var3.f).n(), v75Var6.n());
                                                w25VarB = new w25(((n85) sb1Var3.f).n(), v75Var6.n(), 1L, 1L, 1L, v75Var6.o(), 0L, null, null, null, null);
                                            }
                                        } else {
                                            k85Var3 = k85Var;
                                        }
                                        h0();
                                        Long l5 = (Long) z65.e1("_eid", (w75) v75Var6.e());
                                        boolean z10 = l5 != null;
                                        if (iM1 == 1) {
                                            arrayList5.add((w75) v75Var6.e());
                                            if (z10 && (w25VarB.i != null || w25VarB.j != null || w25VarB.k != null)) {
                                                map.put(v75Var6.n(), w25VarB.b(null, null, null));
                                            }
                                            l85Var.a0(i30, v75Var6);
                                            l = l2;
                                            sb1Var = sb1Var3;
                                        } else {
                                            if (secureRandomU1.nextInt(iM1) == 0) {
                                                h0();
                                                sb1Var = sb1Var3;
                                                Long lValueOf2 = Long.valueOf(iM1);
                                                z65.b1(v75Var6, "_sr", lValueOf2);
                                                arrayList5.add((w75) v75Var6.e());
                                                if (z10) {
                                                    w25VarB = w25VarB.b(null, lValueOf2, null);
                                                }
                                                map.put(v75Var6.n(), new w25(w25VarB.a, w25VarB.b, w25VarB.c, w25VarB.d, w25VarB.e, w25VarB.f, v75Var6.o(), Long.valueOf(jO2), w25VarB.i, w25VarB.j, w25VarB.k));
                                                l = l2;
                                            } else {
                                                sb1Var = sb1Var3;
                                                Long l6 = w25VarB.h;
                                                if (l6 != null) {
                                                    jP = l6.longValue();
                                                } else {
                                                    i0();
                                                    jP = (j62 + v75Var6.p()) / 86400000;
                                                }
                                                if (jP != jO2) {
                                                    h0();
                                                    z65.b1(v75Var6, "_efs", l2);
                                                    h0();
                                                    Long lValueOf3 = Long.valueOf(iM1);
                                                    z65.b1(v75Var6, "_sr", lValueOf3);
                                                    arrayList5.add((w75) v75Var6.e());
                                                    if (z10) {
                                                        w25VarB = w25VarB.b(null, lValueOf3, Boolean.TRUE);
                                                    }
                                                    l = l2;
                                                    map.put(v75Var6.n(), new w25(w25VarB.a, w25VarB.b, w25VarB.c, w25VarB.d, w25VarB.e, w25VarB.f, v75Var6.o(), Long.valueOf(jO2), w25VarB.i, w25VarB.j, w25VarB.k));
                                                } else {
                                                    l = l2;
                                                    if (z10) {
                                                        map.put(v75Var6.n(), w25VarB.b(l5, null, null));
                                                    }
                                                }
                                            }
                                            l85Var.a0(i30, v75Var6);
                                        }
                                    }
                                } else {
                                    iM1 = d0().m1(((n85) sb1Var3.f).n(), v75Var6.n());
                                    if (iM1 > 0) {
                                    }
                                }
                            }
                            i30++;
                            ff5Var = this;
                            j5 = j3;
                            k85Var = k85Var3;
                            sb1Var3 = sb1Var;
                        }
                        l = l2;
                        k85Var3 = k85Var;
                        sb1Var = sb1Var3;
                        i30++;
                        ff5Var = this;
                        j5 = j3;
                        k85Var = k85Var3;
                        sb1Var3 = sb1Var;
                    }
                    j2 = j5;
                    k85Var2 = k85Var;
                    sb1 sb1Var4 = sb1Var3;
                    if (arrayList5.size() < l85Var.Z()) {
                        l85Var.c();
                        ((n85) l85Var.f).Y();
                        l85Var.c();
                        ((n85) l85Var.f).X(arrayList5);
                    }
                    Iterator it5 = map.entrySet().iterator();
                    while (it5.hasNext()) {
                        e0().u1("events", (w25) ((Map.Entry) it5.next()).getValue());
                    }
                    sb1Var3 = sb1Var4;
                } else {
                    j2 = 0;
                    k85Var2 = k85Var;
                }
                String strN9 = ((n85) sb1Var3.f).n();
                b75 b75VarX13 = e0().X1(strN9);
                if (b75VarX13 == null) {
                    n().z0.b(t65.Z0(((n85) sb1Var3.f).n()), "Bundling raw events w/o app info. appId");
                } else {
                    if (l85Var.Z() > 0) {
                        f85 f85Var = b75VarX13.a.Z;
                        k85.h(f85Var);
                        f85Var.V0();
                        long j7 = b75VarX13.i;
                        if (j7 != j2) {
                            l85Var.h(j7);
                        } else {
                            l85Var.i();
                        }
                        f85 f85Var2 = b75VarX13.a.Z;
                        k85.h(f85Var2);
                        f85Var2.V0();
                        long j8 = b75VarX13.h;
                        if (j8 != j2) {
                            j7 = j8;
                        }
                        if (j7 != j2) {
                            l85Var.f0(j7);
                        } else {
                            l85Var.g0();
                        }
                        b75VarX13.h(l85Var.Z());
                        f85 f85Var3 = b75VarX13.a.Z;
                        k85.h(f85Var3);
                        f85Var3.V0();
                        int i31 = (int) b75VarX13.F;
                        l85Var.c();
                        ((n85) l85Var.f).h1(i31);
                        f85 f85Var4 = b75VarX13.a.Z;
                        k85.h(f85Var4);
                        f85Var4.V0();
                        l85Var.y((int) b75VarX13.g);
                        b75VarX13.L(((n85) l85Var.f).Y1());
                        b75VarX13.M(((n85) l85Var.f).a2());
                        String strU = b75VarX13.u();
                        if (strU != null) {
                            l85Var.H(strU);
                        } else {
                            l85Var.J();
                        }
                        i2 = 0;
                        e0().Y1(b75VarX13, false);
                    }
                    if (l85Var.Z() > 0) {
                        k85Var2.getClass();
                        j65 j65VarH1 = d0().h1(((n85) sb1Var3.f).n());
                        if (j65VarH1 != null && j65VarH1.n()) {
                            long jO3 = j65VarH1.o();
                            l85Var.c();
                            ((n85) l85Var.f).O0(jO3);
                        } else if (((n85) sb1Var3.f).C().isEmpty()) {
                            l85Var.c();
                            ((n85) l85Var.f).O0(-1L);
                        } else {
                            n().C0.b(t65.Z0(((n85) sb1Var3.f).n()), "Did not find measurement config or missing version info. appId");
                        }
                        e0().c2((n85) l85Var.e(), z5);
                    }
                    m25 m25VarE02 = e0();
                    arrayList = (ArrayList) sb1Var3.z;
                    tj4.i(arrayList);
                    m25VarE02.V0();
                    m25VarE02.W0();
                    StringBuilder sb = new StringBuilder("rowid in (");
                    for (i3 = i2; i3 < arrayList.size(); i3++) {
                        if (i3 != 0) {
                            sb.append(",");
                        }
                        sb.append(((Long) arrayList.get(i3)).longValue());
                    }
                    sb.append(")");
                    iDelete = m25VarE02.K1().delete("raw_events", sb.toString(), null);
                    if (iDelete != arrayList.size()) {
                        ((k85) m25VarE02.f).n().z0.c("Deleted fewer rows from raw events table than expected", Integer.valueOf(iDelete), Integer.valueOf(arrayList.size()));
                    }
                    m25 m25VarE03 = e0();
                    m25VarE03.K1().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{strN9, strN9});
                    e0().I1();
                    z = true;
                }
                i2 = 0;
                if (l85Var.Z() > 0) {
                }
                m25 m25VarE022 = e0();
                arrayList = (ArrayList) sb1Var3.z;
                tj4.i(arrayList);
                m25VarE022.V0();
                m25VarE022.W0();
                StringBuilder sb2 = new StringBuilder("rowid in (");
                while (i3 < arrayList.size()) {
                }
                sb2.append(")");
                iDelete = m25VarE022.K1().delete("raw_events", sb2.toString(), null);
                if (iDelete != arrayList.size()) {
                }
                m25 m25VarE032 = e0();
                m25VarE032.K1().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{strN9, strN9});
                e0().I1();
                z = true;
            }
            e0().J1();
            return z;
        } catch (Throwable th) {
            e0().J1();
            throw th;
        }
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
    */
    public final void K() {
        boolean z;
        long jMax;
        long jMax2;
        Integer num;
        int iIntValue;
        z65 z65Var = this.Z;
        C().V0();
        j0();
        if (this.F0 > 0) {
            z0().getClass();
            long jAbs = 3600000 - Math.abs(SystemClock.elapsedRealtime() - this.F0);
            if (jAbs > 0) {
                n().H0.b(Long.valueOf(jAbs), "Upload has been suspended. Will update scheduling later in approximately ms");
                f0().a();
                ge5 ge5Var = this.X;
                R(ge5Var);
                ge5Var.Z0();
                return;
            }
            this.F0 = 0L;
        }
        if (!this.C0.c() || !I()) {
            n().H0.a("Nothing to upload or uploading impossible");
            f0().a();
            ge5 ge5Var2 = this.X;
            R(ge5Var2);
            ge5Var2.Z0();
            return;
        }
        z0().getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        c0();
        long jMax3 = Math.max(0L, ((Long) r55.P.a(null)).longValue());
        m25 m25Var = this.z;
        R(m25Var);
        if (m25Var.F1("select count(1) > 0 from raw_events where realtime = 1", null) != 0) {
            z = true;
        } else {
            m25 m25Var2 = this.z;
            R(m25Var2);
            if (m25Var2.F1("select count(1) > 0 from queue where has_realtime = 1", null) == 0) {
                z = false;
            }
        }
        if (z) {
            String strZ0 = c0().Z0("debug.firebase.analytics.app");
            if (TextUtils.isEmpty(strZ0) || ".none.".equals(strZ0)) {
                c0();
                jMax = Math.max(0L, ((Long) r55.J.a(null)).longValue());
            } else {
                c0();
                jMax = Math.max(0L, ((Long) r55.K.a(null)).longValue());
            }
        } else {
            c0();
            jMax = Math.max(0L, ((Long) r55.I.a(null)).longValue());
        }
        long jA = this.z0.B0.a();
        long jA2 = this.z0.C0.a();
        m25 m25Var3 = this.z;
        R(m25Var3);
        long jG1 = m25Var3.G1("select max(bundle_end_timestamp) from queue", null, 0L);
        m25 m25Var4 = this.z;
        R(m25Var4);
        long jMax4 = Math.max(jG1, m25Var4.G1("select max(timestamp) from raw_events", null, 0L));
        if (jMax4 == 0) {
            jMax2 = 0;
        } else {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = jCurrentTimeMillis - Math.abs(jA - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jA2 - jCurrentTimeMillis);
            long jMin = jMax3 + jAbs2;
            long jMax5 = Math.max(jAbs3, jAbs4);
            if (z && jMax5 > 0) {
                jMin = Math.min(jAbs2, jMax5) + jMax;
            }
            R(z65Var);
            jMax2 = !z65Var.F1(jMax5, jMax) ? jMax5 + jMax : jMin;
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                int i = 0;
                while (true) {
                    c0();
                    if (i >= Math.min(20, Math.max(0, ((Integer) r55.R.a(null)).intValue()))) {
                        break;
                    }
                    c0();
                    jMax2 += Math.max(0L, ((Long) r55.Q.a(null)).longValue()) * (1 << i);
                    if (jMax2 > jAbs4) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        if (jMax2 == 0) {
            n().H0.a("Next upload time is 0");
            f0().a();
            ge5 ge5Var3 = this.X;
            R(ge5Var3);
            ge5Var3.Z0();
            return;
        }
        z65 z65Var2 = this.f;
        R(z65Var2);
        if (!z65Var2.p1()) {
            n().H0.a("No network");
            e75 e75VarF0 = f0();
            ff5 ff5Var = e75VarF0.a;
            ff5Var.j0();
            ff5Var.C().V0();
            if (!e75VarF0.b) {
                ff5Var.C0.b.registerReceiver(e75VarF0, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                z65 z65Var3 = ff5Var.f;
                R(z65Var3);
                e75VarF0.c = z65Var3.p1();
                ff5Var.n().H0.b(Boolean.valueOf(e75VarF0.c), "Registering connectivity change receiver. Network connected");
                e75VarF0.b = true;
            }
            ge5 ge5Var4 = this.X;
            R(ge5Var4);
            ge5Var4.Z0();
            return;
        }
        long jA3 = this.z0.A0.a();
        c0();
        long jMax6 = Math.max(0L, ((Long) r55.G.a(null)).longValue());
        R(z65Var);
        if (!z65Var.F1(jA3, jMax6)) {
            jMax2 = Math.max(jMax2, jA3 + jMax6);
        }
        f0().a();
        z0().getClass();
        long jCurrentTimeMillis2 = jMax2 - System.currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            c0();
            jCurrentTimeMillis2 = Math.max(0L, ((Long) r55.L.a(null)).longValue());
            u uVar = this.z0.B0;
            z0().getClass();
            uVar.b(System.currentTimeMillis());
        }
        n().H0.b(Long.valueOf(jCurrentTimeMillis2), "Upload scheduled in approximately ms");
        ge5 ge5Var5 = this.X;
        R(ge5Var5);
        ge5Var5.W0();
        k85 k85Var = (k85) ge5Var5.f;
        k85Var.getClass();
        t65 t65Var = k85Var.Y;
        Context context = k85Var.b;
        if (!qf5.N1(context)) {
            k85.h(t65Var);
            t65Var.G0.a("Receiver not registered/enabled");
        }
        if (!qf5.o1(context)) {
            k85.h(t65Var);
            t65Var.G0.a("Service not registered/enabled");
        }
        ge5Var5.Z0();
        k85.h(t65Var);
        t65Var.H0.b(Long.valueOf(jCurrentTimeMillis2), "Scheduling upload, millis");
        k85Var.B0.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime() + jCurrentTimeMillis2;
        if (jCurrentTimeMillis2 < Math.max(0L, ((Long) r55.M.a(null)).longValue())) {
            td5 td5Var = ge5Var5.y0;
            if (td5Var == null) {
                td5 td5Var2 = new td5(ge5Var5, ge5Var5.X.C0, 1);
                ge5Var5.y0 = td5Var2;
                td5Var = td5Var2;
            }
            if (td5Var.c == 0) {
                td5 td5Var3 = ge5Var5.y0;
                if (td5Var3 == null) {
                    td5 td5Var4 = new td5(ge5Var5, ge5Var5.X.C0, 1);
                    ge5Var5.y0 = td5Var4;
                    td5Var3 = td5Var4;
                }
                td5Var3.b(jCurrentTimeMillis2);
            }
        }
        if (Build.VERSION.SDK_INT < 24) {
            AlarmManager alarmManager = ge5Var5.Z;
            if (alarmManager != null) {
                alarmManager.setInexactRepeating(2, jElapsedRealtime, Math.max(((Long) r55.H.a(null)).longValue(), jCurrentTimeMillis2), ge5Var5.c1());
                return;
            }
            return;
        }
        ComponentName componentName = new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iB1 = ge5Var5.b1();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        JobInfo jobInfoBuild = new JobInfo.Builder(iB1, componentName).setMinimumLatency(jCurrentTimeMillis2).setOverrideDeadline(jCurrentTimeMillis2 + jCurrentTimeMillis2).setExtras(persistableBundle).build();
        Method method = p35.a;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        jobScheduler.getClass();
        Method method2 = p35.a;
        if (method2 == null || context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) {
            jobScheduler.schedule(jobInfoBuild);
            return;
        }
        Method method3 = p35.b;
        if (method3 != null) {
            try {
                num = (Integer) method3.invoke(UserHandle.class, null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    a1.e("JobSchedulerCompat", "myUserId invocation illegal", e);
                }
            }
            iIntValue = num != null ? num.intValue() : 0;
        }
        try {
        } catch (IllegalAccessException | InvocationTargetException e2) {
            a1.e("UploadAlarm", "error calling scheduleAsPackage", e2);
            jobScheduler.schedule(jobInfoBuild);
        }
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
    */
    public final void T(kf5 kf5Var, tg5 tg5Var) {
        String str;
        long jLongValue;
        C().V0();
        j0();
        boolean zQ = Q(tg5Var);
        String str2 = tg5Var.b;
        if (zQ) {
            if (!tg5Var.y0) {
                a0(tg5Var);
                return;
            }
            qf5 qf5VarI0 = i0();
            String str3 = kf5Var.f;
            int iC2 = qf5VarI0.c2(str3);
            jf4 jf4Var = this.a1;
            if (iC2 != 0) {
                i0();
                c0();
                String strA1 = qf5.a1(24, str3, true);
                int length = str3 != null ? str3.length() : 0;
                i0();
                qf5.l1(jf4Var, tg5Var.b, iC2, "_ev", strA1, length);
                return;
            }
            int iI1 = i0().i1(kf5Var.a(), str3);
            if (iI1 != 0) {
                i0();
                c0();
                String strA12 = qf5.a1(24, str3, true);
                Object objA = kf5Var.a();
                int length2 = (objA == null || !((objA instanceof String) || (objA instanceof CharSequence))) ? 0 : objA.toString().length();
                i0();
                qf5.l1(jf4Var, tg5Var.b, iI1, "_ev", strA12, length2);
                return;
            }
            Object objJ1 = i0().j1(kf5Var.a(), str3);
            if (objJ1 != null) {
                if ("_sid".equals(str3)) {
                    long j = kf5Var.z;
                    String str4 = kf5Var.Y;
                    tj4.i(str2);
                    m25 m25Var = this.z;
                    R(m25Var);
                    mf5 mf5VarP1 = m25Var.P1(str2, "_sno");
                    if (mf5VarP1 != null) {
                        Object obj = mf5VarP1.e;
                        if (obj instanceof Long) {
                            jLongValue = ((Long) obj).longValue();
                            str = "_sid";
                        } else {
                            if (mf5VarP1 != null) {
                                n().C0.b(mf5VarP1.e, "Retrieved last session number from database does not contain a valid (long) value");
                            }
                            m25 m25Var2 = this.z;
                            R(m25Var2);
                            w25 w25VarT1 = m25Var2.t1("events", str2, "_s");
                            if (w25VarT1 != null) {
                                q65 q65Var = n().H0;
                                str = "_sid";
                                long j2 = w25VarT1.c;
                                q65Var.b(Long.valueOf(j2), "Backfill the session number. Last used session number");
                                jLongValue = j2;
                            } else {
                                str = "_sid";
                                jLongValue = 0;
                            }
                        }
                        T(new kf5(j, Long.valueOf(jLongValue + 1), "_sno", str4), tg5Var);
                    }
                } else {
                    str = "_sid";
                }
                tj4.i(str2);
                String str5 = kf5Var.Y;
                tj4.i(str5);
                mf5 mf5Var = new mf5(str2, str5, str3, kf5Var.z, objJ1);
                q65 q65Var2 = n().H0;
                k85 k85Var = this.C0;
                k65 k65Var = k85Var.A0;
                String str6 = mf5Var.c;
                q65Var2.c("Setting user property", k65Var.c(str6), objJ1);
                m25 m25Var3 = this.z;
                R(m25Var3);
                m25Var3.H1();
                try {
                    boolean zEquals = "_id".equals(str6);
                    Object obj2 = mf5Var.e;
                    if (zEquals) {
                        m25 m25Var4 = this.z;
                        R(m25Var4);
                        mf5 mf5VarP12 = m25Var4.P1(str2, "_id");
                        if (mf5VarP12 != null && !obj2.equals(mf5VarP12.e)) {
                            m25 m25Var5 = this.z;
                            R(m25Var5);
                            m25Var5.N1(str2, "_lair");
                        }
                    }
                    a0(tg5Var);
                    m25 m25Var6 = this.z;
                    R(m25Var6);
                    boolean zO1 = m25Var6.O1(mf5Var);
                    if (str.equals(str3)) {
                        z65 z65Var = this.Z;
                        R(z65Var);
                        String str7 = tg5Var.L0;
                        long jG1 = TextUtils.isEmpty(str7) ? 0L : z65Var.G1(str7.getBytes(Charset.forName("UTF-8")));
                        m25 m25Var7 = this.z;
                        R(m25Var7);
                        b75 b75VarX1 = m25Var7.X1(str2);
                        if (b75VarX1 != null) {
                            b75VarX1.A(jG1);
                            if (b75VarX1.o()) {
                                m25 m25Var8 = this.z;
                                R(m25Var8);
                                m25Var8.Y1(b75VarX1, false);
                            }
                        }
                    }
                    m25 m25Var9 = this.z;
                    R(m25Var9);
                    m25Var9.I1();
                    if (!zO1) {
                        n().z0.c("Too many unique user properties are set. Ignoring user property", k85Var.A0.c(str6), obj2);
                        i0();
                        qf5.l1(jf4Var, str2, 9, null, null, 0);
                    }
                    m25 m25Var10 = this.z;
                    R(m25Var10);
                    m25Var10.J1();
                } catch (Throwable th) {
                    m25 m25Var11 = this.z;
                    R(m25Var11);
                    m25Var11.J1();
                    throw th;
                }
            }
        }
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
    */
    public final void W(tg5 tg5Var) {
        long j;
        long j2;
        w25 w25VarT1;
        boolean z;
        k85 k85Var;
        String str;
        int i;
        PackageInfo packageInfoA;
        tg5 tg5Var2;
        ApplicationInfo applicationInfo;
        long j3;
        int i2;
        k85 k85Var2 = this.C0;
        C().V0();
        j0();
        tj4.i(tg5Var);
        boolean z2 = tg5Var.F0;
        String str2 = tg5Var.b;
        tj4.f(str2);
        if (Q(tg5Var)) {
            m25 m25Var = this.z;
            R(m25Var);
            b75 b75VarX1 = m25Var.X1(str2);
            if (b75VarX1 != null && TextUtils.isEmpty(b75VarX1.G()) && !TextUtils.isEmpty(tg5Var.f)) {
                b75VarX1.f(0L);
                m25 m25Var2 = this.z;
                R(m25Var2);
                m25Var2.Y1(b75VarX1, false);
                x75 x75Var = this.b;
                R(x75Var);
                x75Var.V0();
                x75Var.B0.remove(str2);
            }
            if (!tg5Var.y0) {
                a0(tg5Var);
                return;
            }
            long jCurrentTimeMillis = tg5Var.C0;
            if (jCurrentTimeMillis == 0) {
                z0().getClass();
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            long j4 = jCurrentTimeMillis;
            int i3 = tg5Var.D0;
            if (i3 != 0 && i3 != 1) {
                n().C0.c("Incorrect app type, assuming installed app. appId, appType", t65.Z0(str2), Integer.valueOf(i3));
                i3 = 0;
            }
            m25 m25Var3 = this.z;
            R(m25Var3);
            m25Var3.H1();
            try {
                m25 m25Var4 = this.z;
                R(m25Var4);
                mf5 mf5VarP1 = m25Var4.P1(str2, "_npa");
                Boolean boolS = S(tg5Var);
                if (mf5VarP1 != null) {
                    j = 1;
                    if (!"auto".equals(mf5VarP1.b)) {
                        j2 = j4;
                        if (c0().f1(null, r55.c1)) {
                            Z(tg5Var, j2);
                        } else {
                            Z(tg5Var, tg5Var.U0);
                            j2 = j2;
                        }
                        a0(tg5Var);
                        m25 m25Var5 = this.z;
                        if (i3 != 0) {
                            R(m25Var5);
                            w25VarT1 = m25Var5.t1("events", str2, "_f");
                            z = false;
                        } else {
                            R(m25Var5);
                            w25VarT1 = m25Var5.t1("events", str2, "_v");
                            z = true;
                        }
                        if (w25VarT1 != null) {
                            long j5 = ((j2 / 3600000) + j) * 3600000;
                            if (z) {
                                Long lValueOf = Long.valueOf(j5);
                                long j6 = j2;
                                T(new kf5(j6, lValueOf, "_fvt", "auto"), tg5Var);
                                C().V0();
                                j0();
                                Bundle bundle = new Bundle();
                                bundle.putLong("_c", 1L);
                                bundle.putLong("_r", 1L);
                                bundle.putLong("_et", 1L);
                                if (z2) {
                                    bundle.putLong("_dac", 1L);
                                }
                                if (c0().f1(null, r55.k1)) {
                                    z0().getClass();
                                    bundle.putLong("_elt", System.currentTimeMillis());
                                }
                                d(new z25("_v", new y25(bundle), "auto", j6), tg5Var);
                            } else {
                                Long lValueOf2 = Long.valueOf(j5);
                                long j7 = j2;
                                T(new kf5(j7, lValueOf2, "_fot", "auto"), tg5Var);
                                C().V0();
                                o75 o75Var = this.B0;
                                tj4.i(o75Var);
                                k85 k85Var3 = o75Var.a;
                                if (str2 == null || str2.isEmpty()) {
                                    k85Var = k85Var2;
                                    str = "_elt";
                                    i = 1;
                                    t65 t65Var = k85Var3.Y;
                                    k85.h(t65Var);
                                    t65Var.D0.a("Install Referrer Reporter was called with invalid app package name");
                                } else {
                                    str = "_elt";
                                    f85 f85Var = k85Var3.Z;
                                    Context context = k85Var3.b;
                                    t65 t65Var2 = k85Var3.Y;
                                    k85.h(f85Var);
                                    f85Var.V0();
                                    if (o75Var.a()) {
                                        n75 n75Var = new n75(o75Var, str2);
                                        f85 f85Var2 = k85Var3.Z;
                                        k85.h(f85Var2);
                                        f85Var2.V0();
                                        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                        k85Var = k85Var2;
                                        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                        PackageManager packageManager = context.getPackageManager();
                                        if (packageManager == null) {
                                            k85.h(t65Var2);
                                            t65Var2.D0.a("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                        } else {
                                            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
                                            if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                                                i = 1;
                                                k85.h(t65Var2);
                                                t65Var2.F0.a("Play Service for fetching Install Referrer is unavailable on device");
                                            } else {
                                                ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                                                if (serviceInfo != null) {
                                                    String str3 = serviceInfo.packageName;
                                                    if (serviceInfo.name != null && "com.android.vending".equals(str3) && o75Var.a()) {
                                                        try {
                                                            try {
                                                                boolean zC = fb0.a().c(context, context.getClass().getName(), new Intent(intent), n75Var, 1, null);
                                                                i = 1;
                                                                try {
                                                                    k85.h(t65Var2);
                                                                    t65Var2.H0.b(zC ? "available" : "not available", "Install Referrer Service is");
                                                                } catch (RuntimeException e) {
                                                                    e = e;
                                                                    t65 t65Var3 = k85Var3.Y;
                                                                    k85.h(t65Var3);
                                                                    t65Var3.z0.b(e.getMessage(), "Exception occurred while binding to Install Referrer Service");
                                                                }
                                                            } catch (RuntimeException e2) {
                                                                e = e2;
                                                                i = 1;
                                                            }
                                                        } catch (RuntimeException e3) {
                                                            e = e3;
                                                            i = 1;
                                                        }
                                                    } else {
                                                        i = 1;
                                                        k85.h(t65Var2);
                                                        t65Var2.C0.a("Play Store version 8.3.73 or higher required for Install Referrer");
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        k85.h(t65Var2);
                                        t65Var2.F0.a("Install Referrer Reporter is not available");
                                        k85Var = k85Var2;
                                    }
                                    i = 1;
                                }
                                C().V0();
                                j0();
                                Bundle bundle2 = new Bundle();
                                long j8 = j;
                                bundle2.putLong("_c", j8);
                                bundle2.putLong("_r", j8);
                                bundle2.putLong("_uwa", 0L);
                                bundle2.putLong("_pfo", 0L);
                                bundle2.putLong("_sys", 0L);
                                bundle2.putLong("_sysu", 0L);
                                bundle2.putLong("_et", j8);
                                if (z2) {
                                    bundle2.putLong("_dac", j8);
                                }
                                tj4.i(str2);
                                m25 m25Var6 = this.z;
                                R(m25Var6);
                                tj4.f(str2);
                                m25Var6.V0();
                                m25Var6.W0();
                                long jJ1 = m25Var6.j1(str2);
                                k85 k85Var4 = k85Var;
                                if (k85Var4.b.getPackageManager() == null) {
                                    n().z0.b(t65.Z0(str2), "PackageManager is null, first open report might be inaccurate. appId");
                                    tg5Var2 = tg5Var;
                                } else {
                                    try {
                                        packageInfoA = ay4.a(k85Var4.b).a(0, str2);
                                    } catch (PackageManager.NameNotFoundException e4) {
                                        n().z0.c("Package info is null, first open report might be inaccurate. appId", t65.Z0(str2), e4);
                                        packageInfoA = null;
                                    }
                                    if (packageInfoA != null) {
                                        long j9 = packageInfoA.firstInstallTime;
                                        if (j9 != 0) {
                                            if (j9 != packageInfoA.lastUpdateTime) {
                                                if (!c0().f1(null, r55.J0)) {
                                                    bundle2.putLong("_uwa", 1L);
                                                } else if (jJ1 == 0) {
                                                    bundle2.putLong("_uwa", 1L);
                                                    i2 = 0;
                                                    jJ1 = 0;
                                                }
                                                i2 = 0;
                                            } else {
                                                i2 = i;
                                            }
                                            tg5Var2 = tg5Var;
                                            T(new kf5(j7, Long.valueOf(i != i2 ? 0L : 1L), "_fi", "auto"), tg5Var2);
                                        } else {
                                            tg5Var2 = tg5Var;
                                        }
                                        try {
                                            applicationInfo = ay4.a(k85Var4.b).a.getPackageManager().getApplicationInfo(str2, 0);
                                        } catch (PackageManager.NameNotFoundException e5) {
                                            n().z0.c("Application info is null, first open report might be inaccurate. appId", t65.Z0(str2), e5);
                                            applicationInfo = null;
                                        }
                                        if (applicationInfo != null) {
                                            if ((i & applicationInfo.flags) != 0) {
                                                j3 = 1;
                                                bundle2.putLong("_sys", 1L);
                                            } else {
                                                j3 = 1;
                                            }
                                            if ((applicationInfo.flags & 128) != 0) {
                                                bundle2.putLong("_sysu", j3);
                                            }
                                        }
                                    }
                                }
                                long j10 = jJ1;
                                if (j10 >= 0) {
                                    bundle2.putLong("_pfo", j10);
                                }
                                if (c0().f1(null, r55.k1)) {
                                    z0().getClass();
                                    bundle2.putLong(str, System.currentTimeMillis());
                                }
                                d(new z25("_f", new y25(bundle2), "auto", j7), tg5Var2);
                            }
                        } else {
                            long j11 = j2;
                            if (tg5Var.z0) {
                                d(new z25("_cd", new y25(new Bundle()), "auto", j11), tg5Var);
                            }
                        }
                        m25 m25Var7 = this.z;
                        R(m25Var7);
                        m25Var7.I1();
                        m25 m25Var8 = this.z;
                        R(m25Var8);
                        m25Var8.J1();
                    }
                } else {
                    j = 1;
                }
                if (boolS != null) {
                    kf5 kf5Var = new kf5(j4, Long.valueOf(true != boolS.booleanValue() ? 0L : j), "_npa", "auto");
                    j2 = j4;
                    if (mf5VarP1 == null || !mf5VarP1.e.equals(kf5Var.A)) {
                        T(kf5Var, tg5Var);
                    }
                } else {
                    j2 = j4;
                    if (mf5VarP1 != null) {
                        V("_npa", tg5Var);
                    }
                }
                if (c0().f1(null, r55.c1)) {
                }
                a0(tg5Var);
                m25 m25Var52 = this.z;
                if (i3 != 0) {
                }
                if (w25VarT1 != null) {
                }
                m25 m25Var72 = this.z;
                R(m25Var72);
                m25Var72.I1();
                m25 m25Var82 = this.z;
                R(m25Var82);
                m25Var82.J1();
            } catch (Throwable th) {
                m25 m25Var9 = this.z;
                R(m25Var9);
                m25Var9.J1();
                throw th;
            }
        }
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
    */
    public final b75 a0(tg5 tg5Var) {
        boolean z;
        String str;
        long j;
        String str2;
        String str3;
        String str4;
        C().V0();
        j0();
        tj4.i(tg5Var);
        boolean z2 = tg5Var.E0;
        String str5 = tg5Var.b;
        tj4.f(str5);
        String str6 = tg5Var.K0;
        if (!str6.isEmpty()) {
            this.U0.put(str5, new bf5(this, str6));
        }
        m25 m25Var = this.z;
        R(m25Var);
        b75 b75VarX1 = m25Var.X1(str5);
        t95 t95VarJ = a(str5).j(t95.c(100, tg5Var.J0));
        r95 r95Var = r95.AD_STORAGE;
        String strA1 = t95VarJ.i(r95Var) ? this.z0.a1(str5, z2) : "";
        boolean z3 = true;
        r95 r95Var2 = r95.ANALYTICS_STORAGE;
        if (b75VarX1 != null) {
            k85 k85Var = b75VarX1.a;
            if (t95VarJ.i(r95Var) && strA1 != null) {
                f85 f85Var = k85Var.Z;
                k85.h(f85Var);
                f85Var.V0();
                if (!strA1.equals(b75VarX1.e)) {
                    f85 f85Var2 = k85Var.Z;
                    k85.h(f85Var2);
                    f85Var2.V0();
                    boolean zIsEmpty = TextUtils.isEmpty(b75VarX1.e);
                    b75VarX1.I(strA1);
                    if (z2) {
                        fd5 fd5Var = this.z0;
                        fd5Var.getClass();
                        if (!"00000000-0000-0000-0000-000000000000".equals((t95VarJ.i(r95Var) ? fd5Var.Z0(str5) : new Pair("", Boolean.FALSE)).first) && !zIsEmpty) {
                            if (t95VarJ.i(r95Var2)) {
                                b75VarX1.F(j(t95VarJ));
                                z = false;
                            } else {
                                z = true;
                            }
                            m25 m25Var2 = this.z;
                            R(m25Var2);
                            if (m25Var2.P1(str5, "_id") != null) {
                                m25 m25Var3 = this.z;
                                R(m25Var3);
                                if (m25Var3.P1(str5, "_lair") == null) {
                                    z0().getClass();
                                    mf5 mf5Var = new mf5(str5, "auto", "_lair", System.currentTimeMillis(), 1L);
                                    m25 m25Var4 = this.z;
                                    R(m25Var4);
                                    m25Var4.O1(mf5Var);
                                }
                            }
                        }
                    }
                    if (TextUtils.isEmpty(b75VarX1.E()) && t95VarJ.i(r95Var2)) {
                        b75VarX1.F(j(t95VarJ));
                    }
                }
            } else if (TextUtils.isEmpty(b75VarX1.E()) && t95VarJ.i(r95Var2)) {
                b75VarX1.F(j(t95VarJ));
            }
            k85 k85Var2 = b75VarX1.a;
            b75VarX1.H(tg5Var.f);
            str = tg5Var.B0;
            if (!TextUtils.isEmpty(str)) {
                b75VarX1.K(str);
            }
            j = tg5Var.X;
            if (j != 0) {
                b75VarX1.S(j);
            }
            str2 = tg5Var.z;
            if (!TextUtils.isEmpty(str2)) {
                b75VarX1.O(str2);
            }
            b75VarX1.Q(tg5Var.A0);
            str3 = tg5Var.A;
            if (str3 != null) {
                b75VarX1.R(str3);
            }
            b75VarX1.a(tg5Var.Y);
            b75VarX1.d(tg5Var.y0);
            str4 = tg5Var.Z;
            if (!TextUtils.isEmpty(str4)) {
                b75VarX1.v(str4);
            }
            f85 f85Var3 = k85Var2.Z;
            k85.h(f85Var3);
            f85Var3.V0();
            b75VarX1.Q |= b75VarX1.p == z2;
            b75VarX1.p = z2;
            Boolean bool = tg5Var.G0;
            f85 f85Var4 = k85Var2.Z;
            k85.h(f85Var4);
            f85Var4.V0();
            b75VarX1.Q |= !Objects.equals(b75VarX1.q, bool);
            b75VarX1.q = bool;
            b75VarX1.c(tg5Var.H0);
            String str7 = tg5Var.L0;
            f85 f85Var5 = k85Var2.Z;
            k85.h(f85Var5);
            f85Var5.V0();
            b75VarX1.Q |= !Objects.equals(b75VarX1.t, str7);
            b75VarX1.t = str7;
            sf5 sf5Var = sf5.f;
            if (c0().f1(null, r55.M0)) {
                if (c0().f1(null, r55.L0)) {
                    b75VarX1.x(null);
                }
            } else {
                b75VarX1.x(tg5Var.I0);
            }
            boolean z4 = tg5Var.M0;
            f85 f85Var6 = k85Var2.Z;
            k85.h(f85Var6);
            f85Var6.V0();
            b75VarX1.Q |= b75VarX1.u == z4;
            b75VarX1.u = z4;
            String str8 = tg5Var.S0;
            f85 f85Var7 = k85Var2.Z;
            k85.h(f85Var7);
            f85Var7.V0();
            b75VarX1.Q |= b75VarX1.C == str8;
            b75VarX1.C = str8;
            mg5.a();
            if (c0().f1(null, r55.Q0)) {
                int i = tg5Var.Q0;
                f85 f85Var8 = k85Var2.Z;
                k85.h(f85Var8);
                f85Var8.V0();
                b75VarX1.Q |= b75VarX1.x != i;
                b75VarX1.x = i;
            }
            b75VarX1.z(tg5Var.N0);
            String str9 = tg5Var.T0;
            f85 f85Var9 = k85Var2.Z;
            k85.h(f85Var9);
            f85Var9.V0();
            b75VarX1.Q |= b75VarX1.G == str9;
            b75VarX1.G = str9;
            int i2 = tg5Var.V0;
            f85 f85Var10 = k85Var2.Z;
            k85.h(f85Var10);
            f85Var10.V0();
            b75VarX1.Q |= b75VarX1.I != i2;
            b75VarX1.I = i2;
            if (!b75VarX1.o()) {
                z3 = z;
            } else if (!z) {
                return b75VarX1;
            }
            m25 m25Var5 = this.z;
            R(m25Var5);
            m25Var5.Y1(b75VarX1, z3);
            return b75VarX1;
        }
        b75VarX1 = new b75(this.C0, str5);
        if (t95VarJ.i(r95Var2)) {
            b75VarX1.F(j(t95VarJ));
        }
        if (t95VarJ.i(r95Var)) {
            b75VarX1.I(strA1);
        }
        z = false;
        k85 k85Var22 = b75VarX1.a;
        b75VarX1.H(tg5Var.f);
        str = tg5Var.B0;
        if (!TextUtils.isEmpty(str)) {
        }
        j = tg5Var.X;
        if (j != 0) {
        }
        str2 = tg5Var.z;
        if (!TextUtils.isEmpty(str2)) {
        }
        b75VarX1.Q(tg5Var.A0);
        str3 = tg5Var.A;
        if (str3 != null) {
        }
        b75VarX1.a(tg5Var.Y);
        b75VarX1.d(tg5Var.y0);
        str4 = tg5Var.Z;
        if (!TextUtils.isEmpty(str4)) {
        }
        f85 f85Var32 = k85Var22.Z;
        k85.h(f85Var32);
        f85Var32.V0();
        b75VarX1.Q |= b75VarX1.p == z2;
        b75VarX1.p = z2;
        Boolean bool2 = tg5Var.G0;
        f85 f85Var42 = k85Var22.Z;
        k85.h(f85Var42);
        f85Var42.V0();
        b75VarX1.Q |= !Objects.equals(b75VarX1.q, bool2);
        b75VarX1.q = bool2;
        b75VarX1.c(tg5Var.H0);
        String str72 = tg5Var.L0;
        f85 f85Var52 = k85Var22.Z;
        k85.h(f85Var52);
        f85Var52.V0();
        b75VarX1.Q |= !Objects.equals(b75VarX1.t, str72);
        b75VarX1.t = str72;
        sf5 sf5Var2 = sf5.f;
        if (c0().f1(null, r55.M0)) {
        }
        boolean z42 = tg5Var.M0;
        f85 f85Var62 = k85Var22.Z;
        k85.h(f85Var62);
        f85Var62.V0();
        b75VarX1.Q |= b75VarX1.u == z42;
        b75VarX1.u = z42;
        String str82 = tg5Var.S0;
        f85 f85Var72 = k85Var22.Z;
        k85.h(f85Var72);
        f85Var72.V0();
        b75VarX1.Q |= b75VarX1.C == str82;
        b75VarX1.C = str82;
        mg5.a();
        if (c0().f1(null, r55.Q0)) {
        }
        b75VarX1.z(tg5Var.N0);
        String str92 = tg5Var.T0;
        f85 f85Var92 = k85Var22.Z;
        k85.h(f85Var92);
        f85Var92.V0();
        b75VarX1.Q |= b75VarX1.G == str92;
        b75VarX1.G = str92;
        int i22 = tg5Var.V0;
        f85 f85Var102 = k85Var22.Z;
        k85.h(f85Var102);
        f85Var102.V0();
        b75VarX1.Q |= b75VarX1.I != i22;
        b75VarX1.I = i22;
        if (!b75VarX1.o()) {
        }
        m25 m25Var52 = this.z;
        R(m25Var52);
        m25Var52.Y1(b75VarX1, z3);
        return b75VarX1;
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
    */
    public final void d(z25 z25Var, tg5 tg5Var) throws Throwable {
        Throwable th;
        Cursor cursorRawQuery;
        Cursor cursor;
        Bundle bundleC1;
        z25 z25VarD;
        y25 y25Var;
        String str = tg5Var.b;
        tj4.f(str);
        oe3 oe3VarB = oe3.b(z25Var);
        Bundle bundle = (Bundle) oe3VarB.e;
        qf5 qf5VarI0 = i0();
        m25 m25Var = this.z;
        R(m25Var);
        k85 k85Var = (k85) m25Var.f;
        m25Var.V0();
        m25Var.W0();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = m25Var.K1().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                } catch (SQLiteException e) {
                    e = e;
                    t65 t65Var = k85Var.Y;
                    k85.h(t65Var);
                    t65Var.z0.b(e, "Error selecting default event parameters");
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                    throw th;
                }
                cursor2.close();
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorRawQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
        }
        if (cursorRawQuery.moveToFirst()) {
            try {
                w75 w75Var = (w75) ((v75) z65.I1(w75.x(), cursorRawQuery.getBlob(0))).e();
                m25Var.X.h0();
                bundleC1 = z65.c1(w75Var.n());
                cursorRawQuery.close();
            } catch (IOException e3) {
                t65 t65Var2 = k85Var.Y;
                k85.h(t65Var2);
                t65Var2.z0.c("Failed to retrieve default event parameters. appId", t65.Z0(str), e3);
                if (cursorRawQuery != null) {
                }
                bundleC1 = null;
            }
            qf5VarI0.g1(bundle, bundleC1);
            qf5 qf5VarI02 = i0();
            x15 x15VarC0 = c0();
            x15VarC0.getClass();
            qf5VarI02.e1(oe3VarB, Math.max(Math.min(x15VarC0.d1(str, r55.Y), 100), 25));
            z25VarD = oe3VarB.d();
            if (!c0().f1(null, r55.g1) && "_cmp".equals(z25VarD.b)) {
                y25Var = z25VarD.f;
                if ("referrer API v2".equals(y25Var.b.getString("_cis"))) {
                    String string = y25Var.b.getString("gclid");
                    if (!TextUtils.isEmpty(string)) {
                        T(new kf5(z25VarD.A, string, "_lgclid", "auto"), tg5Var);
                    }
                }
            }
            e(z25VarD, tg5Var);
        }
        t65 t65Var3 = k85Var.Y;
        k85.h(t65Var3);
        t65Var3.H0.a("Default event parameters not found");
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        bundleC1 = null;
        qf5VarI0.g1(bundle, bundleC1);
        qf5 qf5VarI022 = i0();
        x15 x15VarC02 = c0();
        x15VarC02.getClass();
        qf5VarI022.e1(oe3VarB, Math.max(Math.min(x15VarC02.d1(str, r55.Y), 100), 25));
        z25VarD = oe3VarB.d();
        if (!c0().f1(null, r55.g1)) {
            y25Var = z25VarD.f;
            if ("referrer API v2".equals(y25Var.b.getString("_cis"))) {
            }
        }
        e(z25VarD, tg5Var);
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
    */
    public final void g(z25 z25Var, tg5 tg5Var) throws Throwable {
        String str;
        ff5 ff5Var;
        boolean z;
        String str2;
        String str3;
        String str4;
        String str5;
        long jRound;
        String str6;
        mf5 mf5Var;
        mf5 mf5Var2;
        jf4 jf4Var;
        long length;
        long jIntValue;
        String str7;
        long jDelete;
        w25 w25VarA;
        String str8;
        String str9;
        String str10;
        long j;
        String str11;
        String str12;
        long j2;
        String str13;
        String str14;
        ArrayList arrayList;
        t95 t95VarJ;
        k85 k85Var;
        v25 v25Var;
        b75 b75VarX1;
        int i;
        List listQ1;
        int i2;
        m25 m25VarE0;
        m25 m25VarE02;
        Iterator<String> it;
        int i3;
        ContentValues contentValues;
        String str15;
        long jG1;
        b75 b75VarX12;
        mf5 mf5VarP1;
        tj4.i(tg5Var);
        boolean z2 = tg5Var.E0;
        long j3 = tg5Var.H0;
        long j4 = tg5Var.Y;
        String str16 = tg5Var.J0;
        long j5 = tg5Var.X;
        long j6 = tg5Var.A0;
        String str17 = tg5Var.L0;
        String str18 = tg5Var.z;
        String str19 = tg5Var.A;
        long j7 = j4;
        boolean z3 = tg5Var.y0;
        String str20 = tg5Var.b;
        tj4.f(str20);
        long jNanoTime = System.nanoTime();
        C().V0();
        j0();
        h0();
        String str21 = tg5Var.f;
        if (TextUtils.isEmpty(str21)) {
            return;
        }
        if (!z3) {
            a0(tg5Var);
            return;
        }
        x75 x75VarD0 = d0();
        String str22 = z25Var.b;
        boolean zK1 = x75VarD0.k1(str20, str22);
        k85 k85Var2 = this.C0;
        jf4 jf4Var2 = this.a1;
        if (zK1) {
            n().C0.c("Dropping blocked event. appId", t65.Z0(str20), k85Var2.A0.a(str22));
            if (!"1".equals(d0().j0(str20, "measurement.upload.blacklist_internal")) && !"1".equals(d0().j0(str20, "measurement.upload.blacklist_public"))) {
                if ("_err".equals(str22)) {
                    return;
                }
                i0();
                qf5.l1(jf4Var2, str20, 11, "_ev", str22, 0);
                return;
            }
            b75 b75VarX13 = e0().X1(str20);
            if (b75VarX13 != null) {
                k85 k85Var3 = b75VarX13.a;
                f85 f85Var = k85Var3.Z;
                k85.h(f85Var);
                f85Var.V0();
                long j8 = b75VarX13.S;
                f85 f85Var2 = k85Var3.Z;
                k85.h(f85Var2);
                f85Var2.V0();
                long jMax = Math.max(j8, b75VarX13.R);
                z0().getClass();
                long jAbs = Math.abs(System.currentTimeMillis() - jMax);
                c0();
                if (jAbs > ((Long) r55.O.a(null)).longValue()) {
                    n().G0.a("Fetching config for blocked app");
                    v(b75VarX13);
                    return;
                }
                return;
            }
            return;
        }
        oe3 oe3VarB = oe3.b(z25Var);
        qf5 qf5VarI0 = i0();
        x15 x15VarC0 = c0();
        x15VarC0.getClass();
        qf5VarI0.e1(oe3VarB, Math.max(Math.min(x15VarC0.d1(str20, r55.Y), 100), 25));
        int iMax = Math.max(Math.min(c0().d1(str20, r55.h0), 35), 10);
        Bundle bundle = (Bundle) oe3VarB.e;
        Iterator it2 = new TreeSet(bundle.keySet()).iterator();
        while (it2.hasNext()) {
            String str23 = (String) it2.next();
            Iterator it3 = it2;
            if ("items".equals(str23)) {
                i0().f1(bundle.getParcelableArray(str23), iMax);
            }
            it2 = it3;
        }
        z25 z25VarD = oe3VarB.d();
        y25 y25Var = z25VarD.f;
        String str24 = z25VarD.b;
        if (Log.isLoggable(n().b1(), 2)) {
            str = str17;
            n().H0.b(k85Var2.A0.d(z25VarD), "Logging event");
        } else {
            str = str17;
        }
        e0().H1();
        try {
            a0(tg5Var);
            z = "ecommerce_purchase".equals(str24) || "purchase".equals(str24) || "refund".equals(str24);
        } catch (Throwable th) {
            th = th;
            ff5Var = this;
        }
        if (!"_iap".equals(str24)) {
            if (!z) {
                str3 = str19;
                str4 = "events";
                str5 = "raw_events";
                str6 = str20;
                str2 = str18;
                jf4Var = jf4Var2;
                boolean zV1 = qf5.V1(str24);
                boolean zEquals = "_err".equals(str24);
                i0();
                if (y25Var == null) {
                    length = 0;
                } else {
                    Iterator<String> it4 = y25Var.b.keySet().iterator();
                    length = 0;
                    while (it4.hasNext()) {
                        Object objA = y25Var.a(it4.next());
                        if (objA instanceof Parcelable[]) {
                            length += (long) ((Parcelable[]) objA).length;
                        }
                    }
                }
                String str25 = str6;
                g25 g25VarA2 = e0().a2(b(), str25, length + 1, true, zV1, false, zEquals, false, false, false);
                long j9 = g25VarA2.b;
                c0();
                jIntValue = j9 - ((long) ((Integer) r55.l.a(null)).intValue());
                if (jIntValue <= 0) {
                    if (zV1) {
                        long j10 = g25VarA2.a;
                        c0();
                        long jIntValue2 = j10 - ((long) ((Integer) r55.n.a(null)).intValue());
                        if (jIntValue2 > 0) {
                            if (jIntValue2 % 1000 == 1) {
                                n().z0.c("Data loss. Too many public events logged. appId, count", t65.Z0(str25), Long.valueOf(g25VarA2.a));
                            }
                            i0();
                            qf5.l1(jf4Var, str25, 16, "_ev", z25VarD.b, 0);
                            e0().I1();
                        }
                    }
                    String str26 = str25;
                    if (zEquals) {
                        long jMax2 = g25VarA2.d - ((long) Math.max(0, Math.min(1000000, c0().d1(str26, r55.m))));
                        if (jMax2 > 0) {
                            if (jMax2 == 1) {
                                n().z0.c("Too many error events logged. appId, count", t65.Z0(str26), Long.valueOf(g25VarA2.d));
                            }
                            e0().I1();
                        }
                    }
                    Bundle bundleL = y25Var.l();
                    qf5 qf5VarI02 = i0();
                    String str27 = z25VarD.z;
                    qf5VarI02.k1(bundleL, "_o", str27);
                    if (i0().x1(str26, tg5Var.S0)) {
                        i0().k1(bundleL, "_dbg", 1L);
                        i0().k1(bundleL, "_r", 1L);
                    }
                    if ("_s".equals(str24) && (mf5VarP1 = e0().P1(str26, "_sno")) != null) {
                        Object obj = mf5VarP1.e;
                        if (obj instanceof Long) {
                            i0().k1(bundleL, "_sno", obj);
                        }
                    }
                    if (c0().f1(null, r55.Y0) && Objects.equals(str27, "am") && str24.equals("_ai")) {
                        Object obj2 = bundleL.get("value");
                        if (obj2 instanceof String) {
                            try {
                                double d = Double.parseDouble((String) obj2);
                                bundleL.remove("value");
                                bundleL.putDouble("value", d);
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                    m25 m25VarE03 = e0();
                    tj4.f(str26);
                    m25VarE03.V0();
                    m25VarE03.W0();
                    try {
                        str7 = str5;
                        try {
                            jDelete = m25VarE03.K1().delete(str7, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str26, String.valueOf(Math.max(0, Math.min(1000000, ((k85) m25VarE03.f).A.d1(str26, r55.q))))});
                        } catch (SQLiteException e) {
                            e = e;
                            ((k85) m25VarE03.f).n().z0.c("Error deleting over the limit events. appId", t65.Z0(str26), e);
                            jDelete = 0;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        str7 = str5;
                    }
                    if (jDelete > 0) {
                        n().C0.c("Data lost. Too many events stored on disk, deleted. appId", t65.Z0(str26), Long.valueOf(jDelete));
                    }
                    k85 k85Var4 = this.C0;
                    v25 v25Var2 = new v25(k85Var4, z25VarD.z, str26, z25VarD.b, z25VarD.A, 0L, bundleL);
                    m25 m25VarE04 = e0();
                    String str28 = v25Var2.b;
                    String str29 = str4;
                    w25 w25VarT1 = m25VarE04.t1(str29, str26, str28);
                    if (w25VarT1 == null) {
                        long jL1 = e0().l1(str26);
                        c0().getClass();
                        q55 q55Var = r55.X;
                        jf4 jf4Var3 = jf4Var;
                        if (jL1 < Math.max(Math.min(r6.d1(str26, q55Var), 2000), 500) || !zV1) {
                            jf4Var = jf4Var3;
                            w25VarA = new w25(str26, str28, 0L, 0L, 0L, v25Var2.d, 0L, null, null, null, null);
                            str26 = str26;
                        } else {
                            q65 q65Var = n().z0;
                            r65 r65VarZ0 = t65.Z0(str26);
                            String strA = k85Var4.A0.a(str28);
                            x15 x15VarC02 = c0();
                            x15VarC02.getClass();
                            q65Var.d("Too many event names used, ignoring event. appId, name, supported count", r65VarZ0, strA, Integer.valueOf(Math.max(Math.min(x15VarC02.d1(str26, q55Var), 2000), 500)));
                            i0();
                            qf5.l1(jf4Var3, str26, 8, null, null, 0);
                        }
                    } else {
                        v25Var2 = v25Var2.a(k85Var4, w25VarT1.f);
                        w25VarA = w25VarT1.a(v25Var2.d);
                    }
                    v25 v25Var3 = v25Var2;
                    e0().u1(str29, w25VarA);
                    C().V0();
                    j0();
                    String str30 = v25Var3.a;
                    tj4.f(str30);
                    tj4.d(str30.equals(str26));
                    l85 l85VarS = n85.S();
                    l85VarS.z();
                    l85VarS.j();
                    if (!TextUtils.isEmpty(str26)) {
                        l85VarS.p(str26);
                    }
                    if (TextUtils.isEmpty(str3)) {
                        str8 = str3;
                    } else {
                        str8 = str3;
                        l85VarS.n(str8);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str9 = str2;
                    } else {
                        str9 = str2;
                        l85VarS.q(str9);
                    }
                    if (TextUtils.isEmpty(str)) {
                        str10 = str;
                    } else {
                        str10 = str;
                        l85VarS.V(str10);
                    }
                    if (j6 != -2147483648L) {
                        j = j6;
                        l85VarS.P((int) j);
                    } else {
                        j = j6;
                    }
                    String str31 = str10;
                    l85VarS.r(j5);
                    if (TextUtils.isEmpty(str21)) {
                        str11 = str7;
                        str12 = str21;
                    } else {
                        str11 = str7;
                        str12 = str21;
                        l85VarS.K(str12);
                    }
                    tj4.i(str26);
                    String str32 = str8;
                    t95 t95VarJ2 = a(str26).j(t95.c(100, str16));
                    l85VarS.U(t95VarJ2.f());
                    mg5.a();
                    boolean zF1 = c0().f1(str26, r55.Q0);
                    r95 r95Var = r95.AD_STORAGE;
                    if (zF1) {
                        i0();
                        if (qf5.t1(str26)) {
                            l85VarS.A(tg5Var.Q0);
                            j2 = j;
                            long j11 = tg5Var.R0;
                            if (!t95VarJ2.i(r95Var) && j11 != 0) {
                                j11 = (j11 & (-2)) | 32;
                            }
                            l85VarS.X(j11 == 1);
                            if (j11 != 0) {
                                h75 h75VarU = i75.u();
                                h75VarU.h((j11 & 1) != 0);
                                h75VarU.i((j11 & 2) != 0);
                                h75VarU.j((j11 & 4) != 0);
                                h75VarU.k((j11 & 8) != 0);
                                h75VarU.l((j11 & 16) != 0);
                                h75VarU.m((j11 & 32) != 0);
                                h75VarU.n((j11 & 64) != 0);
                                l85VarS.B((i75) h75VarU.e());
                            }
                        } else {
                            j2 = j;
                        }
                        if (j7 != 0) {
                            l85VarS.x(j7);
                            j7 = j7;
                        }
                        l85VarS.S(j3);
                        z65 z65VarH0 = h0();
                        x95 x95VarA = x95.a(z65VarH0.X.C0.r0().getContentResolver(), ma5.a(), pp1.z);
                        Map mapB = x95VarA == null ? Collections.EMPTY_MAP : x95VarA.b();
                        if (mapB == null || mapB.isEmpty()) {
                            str13 = str9;
                            str14 = str12;
                        } else {
                            arrayList = new ArrayList();
                            str13 = str9;
                            int iIntValue = ((Integer) r55.g0.a(null)).intValue();
                            Iterator it5 = mapB.entrySet().iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    str14 = str12;
                                    break;
                                }
                                Map.Entry entry = (Map.Entry) it5.next();
                                Iterator it6 = it5;
                                str14 = str12;
                                if (((String) entry.getKey()).startsWith("measurement.id.")) {
                                    try {
                                        int i4 = Integer.parseInt((String) entry.getValue());
                                        if (i4 != 0) {
                                            arrayList.add(Integer.valueOf(i4));
                                            if (arrayList.size() >= iIntValue) {
                                                ((k85) z65VarH0.f).n().C0.b(Integer.valueOf(arrayList.size()), "Too many experiment IDs. Number of IDs");
                                                break;
                                            }
                                            continue;
                                        } else {
                                            continue;
                                        }
                                    } catch (NumberFormatException e3) {
                                        ((k85) z65VarH0.f).n().C0.b(e3, "Experiment ID NumberFormatException");
                                    }
                                }
                                it5 = it6;
                                str12 = str14;
                            }
                            if (arrayList.isEmpty()) {
                            }
                            if (arrayList != null) {
                                l85VarS.R(arrayList);
                            }
                            if (c0().f1(null, r55.b1)) {
                                l85VarS.E();
                            }
                            t95VarJ = a(str26).j(t95.c(100, str16));
                            if (t95VarJ.i(r95Var) || !z2) {
                                k85Var = k85Var2;
                                v25Var = v25Var3;
                                k85Var.k().X0();
                                String str33 = Build.MODEL;
                                l85VarS.k();
                                k85Var.k().X0();
                                String str34 = Build.VERSION.RELEASE;
                                l85VarS.c();
                                ((n85) l85VarS.f).m0(str34);
                                l85VarS.m((int) k85Var.k().Z0());
                                l85VarS.l(k85Var.k().a1());
                                l85VarS.W(tg5Var.N0);
                                if (k85Var.a()) {
                                    l85VarS.o();
                                    if (!TextUtils.isEmpty(null)) {
                                        l85VarS.c();
                                        ((n85) l85VarS.f).P0(null);
                                        throw null;
                                    }
                                }
                                b75VarX1 = e0().X1(str26);
                                if (b75VarX1 == null) {
                                    b75VarX1 = new b75(k85Var, str26);
                                    ff5Var = this;
                                    try {
                                        b75VarX1.F(ff5Var.j(t95VarJ));
                                        b75VarX1.K(tg5Var.B0);
                                        b75VarX1.H(str14);
                                        if (t95VarJ.i(r95Var)) {
                                            b75VarX1.I(ff5Var.z0.a1(str26, z2));
                                        }
                                        b75VarX1.e(0L);
                                        b75VarX1.L(0L);
                                        b75VarX1.M(0L);
                                        b75VarX1.O(str13);
                                        b75VarX1.Q(j2);
                                        b75VarX1.R(str32);
                                        b75VarX1.S(j5);
                                        b75VarX1.a(j7);
                                        b75VarX1.d(z3);
                                        b75VarX1.c(j3);
                                        i = 0;
                                        ff5Var.e0().Y1(b75VarX1, false);
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } else {
                                    i = 0;
                                    ff5Var = this;
                                }
                                if (t95VarJ.i(r95.ANALYTICS_STORAGE) && !TextUtils.isEmpty(b75VarX1.E())) {
                                    String strE = b75VarX1.E();
                                    tj4.i(strE);
                                    l85VarS.w(strE);
                                }
                                if (!TextUtils.isEmpty(b75VarX1.J())) {
                                    String strJ = b75VarX1.J();
                                    tj4.i(strJ);
                                    l85VarS.O(strJ);
                                }
                                listQ1 = ff5Var.e0().Q1(str26);
                                i2 = i;
                                while (i2 < listQ1.size()) {
                                    z85 z85VarY = a95.y();
                                    String str35 = ((mf5) listQ1.get(i2)).c;
                                    z85VarY.c();
                                    ((a95) z85VarY.f).A(str35);
                                    long j12 = ((mf5) listQ1.get(i2)).d;
                                    z85VarY.c();
                                    ((a95) z85VarY.f).z(j12);
                                    ff5Var.h0().u1(z85VarY, ((mf5) listQ1.get(i2)).e);
                                    l85VarS.d0(z85VarY);
                                    if ("_sid".equals(((mf5) listQ1.get(i2)).c)) {
                                        f85 f85Var3 = b75VarX1.a.Z;
                                        k85.h(f85Var3);
                                        f85Var3.V0();
                                        if (b75VarX1.w != 0) {
                                            z65 z65VarH02 = ff5Var.h0();
                                            if (TextUtils.isEmpty(str31)) {
                                                str15 = str31;
                                                jG1 = 0;
                                            } else {
                                                str15 = str31;
                                                jG1 = z65VarH02.G1(str15.getBytes(Charset.forName("UTF-8")));
                                            }
                                            f85 f85Var4 = b75VarX1.a.Z;
                                            k85.h(f85Var4);
                                            f85Var4.V0();
                                            if (jG1 != b75VarX1.w) {
                                                l85VarS.c();
                                                ((n85) l85VarS.f).X0();
                                            }
                                        } else {
                                            str15 = str31;
                                        }
                                    }
                                    i2++;
                                    str31 = str15;
                                }
                                try {
                                    m25VarE0 = ff5Var.e0();
                                    n85 n85Var = (n85) l85VarS.e();
                                    m25VarE0.V0();
                                    m25VarE0.W0();
                                    tj4.f(n85Var.n());
                                    byte[] bArrA = n85Var.a();
                                    long jG12 = m25VarE0.X.h0().G1(bArrA);
                                    ContentValues contentValues2 = new ContentValues();
                                    contentValues2.put("app_id", n85Var.n());
                                    contentValues2.put("metadata_fingerprint", Long.valueOf(jG12));
                                    contentValues2.put("metadata", bArrA);
                                    try {
                                        m25VarE0.K1().insertWithOnConflict("raw_events_metadata", null, contentValues2, 4);
                                        m25VarE02 = ff5Var.e0();
                                        v25 v25Var4 = v25Var;
                                        it = v25Var4.f.b.keySet().iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                x75 x75VarD02 = ff5Var.d0();
                                                String str36 = v25Var4.a;
                                                boolean zL1 = x75VarD02.l1(str36, v25Var4.b);
                                                g25 g25VarZ1 = ff5Var.e0().Z1(ff5Var.b(), str36, false, false, false, false);
                                                if (!zL1 || g25VarZ1.e >= ff5Var.c0().d1(str36, r55.p)) {
                                                    i3 = i;
                                                }
                                            } else if ("_r".equals(it.next())) {
                                                break;
                                            }
                                        }
                                        i3 = 1;
                                        m25VarE02.V0();
                                        m25VarE02.W0();
                                        String str37 = v25Var4.a;
                                        tj4.f(str37);
                                        byte[] bArrA2 = m25VarE02.X.h0().x1(v25Var4).a();
                                        contentValues = new ContentValues();
                                        contentValues.put("app_id", str37);
                                        contentValues.put("name", v25Var4.b);
                                        contentValues.put("timestamp", Long.valueOf(v25Var4.d));
                                        contentValues.put("metadata_fingerprint", Long.valueOf(jG12));
                                        contentValues.put("data", bArrA2);
                                        contentValues.put("realtime", Integer.valueOf(i3));
                                        try {
                                            if (m25VarE02.K1().insert(str11, null, contentValues) == -1) {
                                                ((k85) m25VarE02.f).n().z0.b(t65.Z0(str37), "Failed to insert raw event (got -1). appId");
                                            } else {
                                                ff5Var.F0 = 0L;
                                            }
                                        } catch (SQLiteException e4) {
                                            ((k85) m25VarE02.f).n().z0.c("Error storing raw event. appId", t65.Z0(v25Var4.a), e4);
                                        }
                                    } catch (SQLiteException e5) {
                                        ((k85) m25VarE0.f).n().z0.c("Error storing raw event metadata. appId", t65.Z0(n85Var.n()), e5);
                                        throw e5;
                                    }
                                } catch (IOException e6) {
                                    ff5Var.n().z0.c("Data loss. Failed to insert raw event metadata. appId", t65.Z0(l85VarS.o()), e6);
                                }
                                ff5Var.e0().I1();
                                ff5Var.e0().J1();
                                ff5Var.K();
                                ff5Var.n().H0.b(Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000), "Background event processing time, ms");
                                return;
                            }
                            try {
                                fd5 fd5Var = this.z0;
                                fd5Var.getClass();
                                Pair pairZ0 = t95VarJ.i(r95Var) ? fd5Var.Z0(str26) : new Pair("", Boolean.FALSE);
                                if (!TextUtils.isEmpty((CharSequence) pairZ0.first)) {
                                    l85VarS.u((String) pairZ0.first);
                                    Object obj3 = pairZ0.second;
                                    if (obj3 != null) {
                                        l85VarS.v(((Boolean) obj3).booleanValue());
                                    }
                                    if (!v25Var3.b.equals("_fx") && !((String) pairZ0.first).equals("00000000-0000-0000-0000-000000000000") && (b75VarX12 = e0().X1(str26)) != null) {
                                        f85 f85Var5 = b75VarX12.a.Z;
                                        k85.h(f85Var5);
                                        f85Var5.V0();
                                        if (b75VarX12.y) {
                                            q(str26, false, null, null);
                                            Bundle bundle2 = new Bundle();
                                            f85 f85Var6 = b75VarX12.a.Z;
                                            k85.h(f85Var6);
                                            f85Var6.V0();
                                            Long l = b75VarX12.z;
                                            if (l != null) {
                                                k85Var = k85Var2;
                                                v25Var = v25Var3;
                                                bundle2.putLong("_pfo", Math.max(0L, l.longValue()));
                                            } else {
                                                k85Var = k85Var2;
                                                v25Var = v25Var3;
                                            }
                                            f85 f85Var7 = b75VarX12.a.Z;
                                            k85.h(f85Var7);
                                            f85Var7.V0();
                                            Long l2 = b75VarX12.A;
                                            if (l2 != null) {
                                                bundle2.putLong("_uwa", l2.longValue());
                                            }
                                            bundle2.putLong("_r", 1L);
                                            jf4Var.b(str26, "_fx", bundle2);
                                        }
                                        k85Var.k().X0();
                                        String str332 = Build.MODEL;
                                        l85VarS.k();
                                        k85Var.k().X0();
                                        String str342 = Build.VERSION.RELEASE;
                                        l85VarS.c();
                                        ((n85) l85VarS.f).m0(str342);
                                        l85VarS.m((int) k85Var.k().Z0());
                                        l85VarS.l(k85Var.k().a1());
                                        l85VarS.W(tg5Var.N0);
                                        if (k85Var.a()) {
                                        }
                                        b75VarX1 = e0().X1(str26);
                                        if (b75VarX1 == null) {
                                        }
                                        if (t95VarJ.i(r95.ANALYTICS_STORAGE)) {
                                            String strE2 = b75VarX1.E();
                                            tj4.i(strE2);
                                            l85VarS.w(strE2);
                                        }
                                        if (!TextUtils.isEmpty(b75VarX1.J())) {
                                        }
                                        listQ1 = ff5Var.e0().Q1(str26);
                                        i2 = i;
                                        while (i2 < listQ1.size()) {
                                        }
                                        m25VarE0 = ff5Var.e0();
                                        n85 n85Var2 = (n85) l85VarS.e();
                                        m25VarE0.V0();
                                        m25VarE0.W0();
                                        tj4.f(n85Var2.n());
                                        byte[] bArrA3 = n85Var2.a();
                                        long jG122 = m25VarE0.X.h0().G1(bArrA3);
                                        ContentValues contentValues22 = new ContentValues();
                                        contentValues22.put("app_id", n85Var2.n());
                                        contentValues22.put("metadata_fingerprint", Long.valueOf(jG122));
                                        contentValues22.put("metadata", bArrA3);
                                        m25VarE0.K1().insertWithOnConflict("raw_events_metadata", null, contentValues22, 4);
                                        m25VarE02 = ff5Var.e0();
                                        v25 v25Var42 = v25Var;
                                        it = v25Var42.f.b.keySet().iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                            }
                                        }
                                        i3 = 1;
                                        m25VarE02.V0();
                                        m25VarE02.W0();
                                        String str372 = v25Var42.a;
                                        tj4.f(str372);
                                        byte[] bArrA22 = m25VarE02.X.h0().x1(v25Var42).a();
                                        contentValues = new ContentValues();
                                        contentValues.put("app_id", str372);
                                        contentValues.put("name", v25Var42.b);
                                        contentValues.put("timestamp", Long.valueOf(v25Var42.d));
                                        contentValues.put("metadata_fingerprint", Long.valueOf(jG122));
                                        contentValues.put("data", bArrA22);
                                        contentValues.put("realtime", Integer.valueOf(i3));
                                        if (m25VarE02.K1().insert(str11, null, contentValues) == -1) {
                                        }
                                        ff5Var.e0().I1();
                                        ff5Var.e0().J1();
                                        ff5Var.K();
                                        ff5Var.n().H0.b(Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000), "Background event processing time, ms");
                                        return;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                ff5Var = this;
                            }
                        }
                        arrayList = null;
                        if (arrayList != null) {
                        }
                        if (c0().f1(null, r55.b1)) {
                        }
                        t95VarJ = a(str26).j(t95.c(100, str16));
                        if (t95VarJ.i(r95Var)) {
                            k85Var = k85Var2;
                            v25Var = v25Var3;
                            k85Var.k().X0();
                            String str3322 = Build.MODEL;
                            l85VarS.k();
                            k85Var.k().X0();
                            String str3422 = Build.VERSION.RELEASE;
                            l85VarS.c();
                            ((n85) l85VarS.f).m0(str3422);
                            l85VarS.m((int) k85Var.k().Z0());
                            l85VarS.l(k85Var.k().a1());
                            l85VarS.W(tg5Var.N0);
                            if (k85Var.a()) {
                            }
                            b75VarX1 = e0().X1(str26);
                            if (b75VarX1 == null) {
                            }
                            if (t95VarJ.i(r95.ANALYTICS_STORAGE)) {
                            }
                            if (!TextUtils.isEmpty(b75VarX1.J())) {
                            }
                            listQ1 = ff5Var.e0().Q1(str26);
                            i2 = i;
                            while (i2 < listQ1.size()) {
                            }
                            m25VarE0 = ff5Var.e0();
                            n85 n85Var22 = (n85) l85VarS.e();
                            m25VarE0.V0();
                            m25VarE0.W0();
                            tj4.f(n85Var22.n());
                            byte[] bArrA32 = n85Var22.a();
                            long jG1222 = m25VarE0.X.h0().G1(bArrA32);
                            ContentValues contentValues222 = new ContentValues();
                            contentValues222.put("app_id", n85Var22.n());
                            contentValues222.put("metadata_fingerprint", Long.valueOf(jG1222));
                            contentValues222.put("metadata", bArrA32);
                            m25VarE0.K1().insertWithOnConflict("raw_events_metadata", null, contentValues222, 4);
                            m25VarE02 = ff5Var.e0();
                            v25 v25Var422 = v25Var;
                            it = v25Var422.f.b.keySet().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                }
                            }
                            i3 = 1;
                            m25VarE02.V0();
                            m25VarE02.W0();
                            String str3722 = v25Var422.a;
                            tj4.f(str3722);
                            byte[] bArrA222 = m25VarE02.X.h0().x1(v25Var422).a();
                            contentValues = new ContentValues();
                            contentValues.put("app_id", str3722);
                            contentValues.put("name", v25Var422.b);
                            contentValues.put("timestamp", Long.valueOf(v25Var422.d));
                            contentValues.put("metadata_fingerprint", Long.valueOf(jG1222));
                            contentValues.put("data", bArrA222);
                            contentValues.put("realtime", Integer.valueOf(i3));
                            if (m25VarE02.K1().insert(str11, null, contentValues) == -1) {
                            }
                            ff5Var.e0().I1();
                            ff5Var.e0().J1();
                            ff5Var.K();
                            ff5Var.n().H0.b(Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000), "Background event processing time, ms");
                            return;
                        }
                    }
                    ff5Var.e0().J1();
                    throw th;
                }
                if (jIntValue % 1000 == 1) {
                    n().z0.c("Data loss. Too many events logged. appId, count", t65.Z0(str25), Long.valueOf(g25VarA2.b));
                }
                e0().I1();
                e0().J1();
            }
            z = true;
        }
        str2 = str18;
        str3 = str19;
        String strK = y25Var.k();
        str4 = "events";
        Bundle bundle3 = y25Var.b;
        if (z) {
            double dDoubleValue = y25Var.d().doubleValue() * 1000000.0d;
            if (dDoubleValue == 0.0d) {
                str5 = "raw_events";
                dDoubleValue = bundle3.getLong("value") * 1000000.0d;
            } else {
                str5 = "raw_events";
            }
            if (dDoubleValue > 9.223372036854776E18d || dDoubleValue < -9.223372036854776E18d) {
                n().C0.c("Data lost. Currency value is too big. appId", t65.Z0(str20), Double.valueOf(dDoubleValue));
                e0().I1();
                e0().J1();
            } else {
                jRound = Math.round(dDoubleValue);
                if ("refund".equals(str24)) {
                    jRound = -jRound;
                }
            }
        } else {
            str5 = "raw_events";
            jRound = bundle3.getLong("value");
        }
        if (!TextUtils.isEmpty(strK)) {
            String upperCase = strK.toUpperCase(Locale.US);
            if (upperCase.matches("[A-Z]{3}")) {
                String strConcat = "_ltv_".concat(upperCase);
                mf5 mf5VarP12 = e0().P1(str20, strConcat);
                if (mf5VarP12 != null) {
                    Object obj4 = mf5VarP12.e;
                    if (obj4 instanceof Long) {
                        long jLongValue = ((Long) obj4).longValue();
                        String str38 = z25VarD.z;
                        z0().getClass();
                        mf5Var = new mf5(str20, str38, strConcat, System.currentTimeMillis(), Long.valueOf(jLongValue + jRound));
                        str6 = str20;
                    }
                    mf5Var2 = mf5Var;
                    if (e0().O1(mf5Var2)) {
                        n().z0.d("Too many unique user properties are set. Ignoring user property. appId", t65.Z0(str6), k85Var2.A0.c(mf5Var2.c), mf5Var2.e);
                        i0();
                        qf5.l1(jf4Var2, str6, 9, null, null, 0);
                        jf4Var = jf4Var2;
                    }
                    boolean zV12 = qf5.V1(str24);
                    boolean zEquals2 = "_err".equals(str24);
                    i0();
                    if (y25Var == null) {
                    }
                    String str252 = str6;
                    g25 g25VarA22 = e0().a2(b(), str252, length + 1, true, zV12, false, zEquals2, false, false, false);
                    long j92 = g25VarA22.b;
                    c0();
                    jIntValue = j92 - ((long) ((Integer) r55.l.a(null)).intValue());
                    if (jIntValue <= 0) {
                    }
                    e0().J1();
                }
                m25 m25VarE05 = e0();
                int iD1 = c0().d1(str20, r55.U) - 1;
                tj4.f(str20);
                m25VarE05.V0();
                m25VarE05.W0();
                m25VarE05.K1().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '!_ltv!_%' escape '!'order by set_timestamp desc limit ?,10);", new String[]{str20, str20, String.valueOf(iD1)});
                String str39 = z25VarD.z;
                z0().getClass();
                str6 = str20;
                mf5Var = new mf5(str6, str39, strConcat, System.currentTimeMillis(), Long.valueOf(jRound));
                mf5Var2 = mf5Var;
                if (e0().O1(mf5Var2)) {
                }
                boolean zV122 = qf5.V1(str24);
                boolean zEquals22 = "_err".equals(str24);
                i0();
                if (y25Var == null) {
                }
                String str2522 = str6;
                g25 g25VarA222 = e0().a2(b(), str2522, length + 1, true, zV122, false, zEquals22, false, false, false);
                long j922 = g25VarA222.b;
                c0();
                jIntValue = j922 - ((long) ((Integer) r55.l.a(null)).intValue());
                if (jIntValue <= 0) {
                }
                e0().J1();
            }
            jf4Var = jf4Var2;
            boolean zV1222 = qf5.V1(str24);
            boolean zEquals222 = "_err".equals(str24);
            i0();
            if (y25Var == null) {
            }
            String str25222 = str6;
            g25 g25VarA2222 = e0().a2(b(), str25222, length + 1, true, zV1222, false, zEquals222, false, false, false);
            long j9222 = g25VarA2222.b;
            c0();
            jIntValue = j9222 - ((long) ((Integer) r55.l.a(null)).intValue());
            if (jIntValue <= 0) {
            }
            e0().J1();
        }
        str6 = str20;
        jf4Var = jf4Var2;
        boolean zV12222 = qf5.V1(str24);
        boolean zEquals2222 = "_err".equals(str24);
        i0();
        if (y25Var == null) {
        }
        String str252222 = str6;
        g25 g25VarA22222 = e0().a2(b(), str252222, length + 1, true, zV12222, false, zEquals2222, false, false, false);
        long j92222 = g25VarA22222.b;
        c0();
        jIntValue = j92222 - ((long) ((Integer) r55.l.a(null)).intValue());
        if (jIntValue <= 0) {
        }
        e0().J1();
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
    */
    public final void l() {
        m25 m25Var;
        long jLongValue;
        SQLiteException e;
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
                C().V0();
                if (this.P0 != null) {
                    n().H0.a("Uploading requested multiple times");
                } else {
                    z65 z65Var = this.f;
                    R(z65Var);
                    if (z65Var.p1()) {
                        z0().getClass();
                        ?? CurrentTimeMillis = System.currentTimeMillis();
                        ?? r7 = 0;
                        cursorRawQuery = null;
                        Cursor cursorRawQuery = null;
                        string = null;
                        string = null;
                        String string = null;
                        int iD1 = c0().d1(null, r55.j0);
                        c0();
                        long jLongValue2 = CurrentTimeMillis - ((Long) r55.e.a(null)).longValue();
                        for (int i = 0; i < iD1 && F(jLongValue2, null); i++) {
                        }
                        mg5.a();
                        C().V0();
                        E();
                        long jA = this.z0.B0.a();
                        if (jA != 0) {
                            n().G0.b(Long.valueOf(Math.abs(CurrentTimeMillis - jA)), "Uploading events. Elapsed time since last upload attempt (ms)");
                        }
                        m25 m25Var2 = this.z;
                        R(m25Var2);
                        String strD1 = m25Var2.d1();
                        long j = -1;
                        if (TextUtils.isEmpty(strD1)) {
                            try {
                                this.R0 = -1L;
                                m25Var = this.z;
                                R(m25Var);
                                c0();
                                jLongValue = CurrentTimeMillis - ((Long) r55.e.a(null)).longValue();
                                m25Var.V0();
                                m25Var.W0();
                            } catch (Throwable th) {
                                th = th;
                                r7 = CurrentTimeMillis;
                            }
                            try {
                                CurrentTimeMillis = m25Var.K1().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(jLongValue)});
                                try {
                                    if (CurrentTimeMillis.moveToFirst()) {
                                        string = CurrentTimeMillis.getString(0);
                                    } else {
                                        t65 t65Var = ((k85) m25Var.f).Y;
                                        k85.h(t65Var);
                                        t65Var.H0.a("No expired configs for apps with pending events");
                                    }
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    t65 t65Var2 = ((k85) m25Var.f).Y;
                                    k85.h(t65Var2);
                                    t65Var2.z0.b(e, "Error selecting expired configs");
                                    if (CurrentTimeMillis != 0) {
                                    }
                                    if (!TextUtils.isEmpty(string)) {
                                    }
                                    this.M0 = false;
                                    L();
                                }
                            } catch (SQLiteException e3) {
                                e = e3;
                                CurrentTimeMillis = 0;
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                            CurrentTimeMillis.close();
                            if (!TextUtils.isEmpty(string)) {
                                m25 m25Var3 = this.z;
                                R(m25Var3);
                                b75 b75VarX1 = m25Var3.X1(string);
                                if (b75VarX1 != null) {
                                    v(b75VarX1);
                                }
                            }
                        } else {
                            if (this.R0 == -1) {
                                m25 m25Var4 = this.z;
                                R(m25Var4);
                                try {
                                    try {
                                        cursorRawQuery = m25Var4.K1().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                        if (cursorRawQuery.moveToFirst()) {
                                            j = cursorRawQuery.getLong(0);
                                        }
                                    } finally {
                                        if (cursorRawQuery != null) {
                                            cursorRawQuery.close();
                                        }
                                    }
                                } catch (SQLiteException e4) {
                                    t65 t65Var3 = ((k85) m25Var4.f).Y;
                                    k85.h(t65Var3);
                                    t65Var3.z0.b(e4, "Error querying raw events");
                                    if (cursorRawQuery != null) {
                                    }
                                    this.R0 = j;
                                    m(CurrentTimeMillis, strD1);
                                    this.M0 = false;
                                    L();
                                }
                                cursorRawQuery.close();
                                this.R0 = j;
                            }
                            m(CurrentTimeMillis, strD1);
                        }
                    } else {
                        n().H0.a("Network not connected, ignoring upload request");
                        K();
                    }
                }
            }
            this.M0 = false;
            L();
        } catch (Throwable th3) {
            this.M0 = false;
            L();
            throw th3;
        }
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
    */
    public final void m(long j, String str) throws Throwable {
        ?? r14;
        ?? r23;
        long j2;
        Cursor cursorQuery;
        List list;
        ?? r232;
        List<Pair> list2;
        List list3;
        t95 t95VarA;
        r95 r95Var;
        int i;
        List listSubList;
        g85 g85VarU;
        int size;
        int i2;
        boolean zI;
        boolean zF1;
        List list4;
        k85 k85Var;
        boolean z;
        String str2;
        z65 z65Var;
        String string;
        re5 re5Var;
        int i3;
        boolean z2;
        int i4;
        List list5;
        boolean z3;
        String strT;
        List list6;
        boolean zIsEmpty;
        ?? r142;
        k85 k85Var2;
        List list7;
        Cursor cursor;
        List list8;
        List list9;
        Iterator it;
        Iterator it2;
        int i5;
        int i6;
        ArrayList arrayList;
        List list10;
        ?? r233;
        ?? r234;
        SQLiteDatabase sQLiteDatabaseK1;
        String strValueOf;
        m25 m25Var;
        byte[] byteArray;
        long jT;
        long jT2;
        String str3 = str;
        int iD1 = c0().d1(str3, r55.h);
        int i7 = 0;
        int iMax = Math.max(0, c0().d1(str3, r55.i));
        m25 m25VarE0 = e0();
        k85 k85Var3 = (k85) m25VarE0.f;
        m25VarE0.V0();
        m25VarE0.W0();
        int i8 = 1;
        tj4.d(iD1 > 0);
        ?? r11 = iMax > 0 ? 1 : 0;
        tj4.d(r11);
        tj4.f(str3);
        try {
        } catch (Throwable th) {
            th = th;
            r14 = r11;
        }
        try {
            try {
                sQLiteDatabaseK1 = m25VarE0.K1();
                j2 = -1;
            } catch (SQLiteException e) {
                e = e;
                r23 = k85Var3;
                j2 = -1;
            }
            try {
                strValueOf = String.valueOf(iD1);
                cursorQuery = sQLiteDatabaseK1.query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str3}, null, null, "rowid", strValueOf);
                try {
                } catch (SQLiteException e2) {
                    e = e2;
                    r23 = k85Var3;
                }
            } catch (SQLiteException e3) {
                e = e3;
                r23 = k85Var3;
                cursorQuery = null;
                r23.n().z0.c("Error querying bundles. appId", t65.Z0(str3), e);
                list = Collections.EMPTY_LIST;
                r234 = r23;
                r233 = r23;
                if (cursorQuery != null) {
                    cursorQuery.close();
                    r233 = r234;
                }
                list2 = list;
                r232 = r233;
                if (list2.isEmpty()) {
                }
            }
            if (cursorQuery.moveToFirst()) {
                ArrayList arrayList2 = new ArrayList();
                int length = 0;
                ?? r9 = k85Var3;
                ?? r235 = strValueOf;
                while (true) {
                    long j3 = cursorQuery.getLong(i7);
                    try {
                        byte[] blob = cursorQuery.getBlob(i8);
                        z65 z65VarH0 = m25VarE0.X.h0();
                        try {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(blob);
                            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr = new byte[1024];
                            m25Var = m25VarE0;
                            r9 = r9;
                            r23 = r235;
                            while (true) {
                                try {
                                    int i9 = gZIPInputStream.read(bArr);
                                    if (i9 <= 0) {
                                        break;
                                    }
                                    r23 = r9;
                                    try {
                                        try {
                                            byteArrayOutputStream.write(bArr, 0, i9);
                                            r9 = r23;
                                            r23 = r23;
                                        } catch (IOException e4) {
                                            e = e4;
                                            try {
                                                ((k85) z65VarH0.f).n().z0.b(e, "Failed to ungzip content");
                                                throw e;
                                            } catch (IOException e5) {
                                                e = e5;
                                                r23.n().z0.c("Failed to unzip queued bundle. appId", t65.Z0(str3), e);
                                                r23 = r23;
                                                if (cursorQuery.moveToNext()) {
                                                    break;
                                                } else {
                                                    break;
                                                }
                                                cursorQuery.close();
                                                list2 = arrayList2;
                                                r232 = r23;
                                                if (list2.isEmpty()) {
                                                }
                                            }
                                        }
                                    } catch (SQLiteException e6) {
                                        e = e6;
                                        r23.n().z0.c("Error querying bundles. appId", t65.Z0(str3), e);
                                        list = Collections.EMPTY_LIST;
                                        r234 = r23;
                                        r233 = r23;
                                        if (cursorQuery != null) {
                                        }
                                        list2 = list;
                                        r232 = r233;
                                        if (list2.isEmpty()) {
                                        }
                                    }
                                } catch (IOException e7) {
                                    e = e7;
                                    r23 = r9;
                                    ((k85) z65VarH0.f).n().z0.b(e, "Failed to ungzip content");
                                    throw e;
                                }
                            }
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            byteArray = byteArrayOutputStream.toByteArray();
                        } catch (IOException e8) {
                            e = e8;
                            m25Var = m25VarE0;
                        }
                    } catch (IOException e9) {
                        e = e9;
                        m25Var = m25VarE0;
                        r23 = r9;
                    }
                    if (!arrayList2.isEmpty() && byteArray.length + length > iMax) {
                        break;
                    }
                    try {
                        l85 l85Var = (l85) z65.I1(n85.S(), byteArray);
                        if (!arrayList2.isEmpty()) {
                            n85 n85Var = (n85) ((Pair) arrayList2.get(0)).first;
                            n85 n85Var2 = (n85) l85Var.e();
                            if (!n85Var.s0().equals(n85Var2.s0()) || !n85Var.z0().equals(n85Var2.z0()) || n85Var.B0() != n85Var2.B0() || !n85Var.D0().equals(n85Var2.D0())) {
                                break;
                            }
                            Iterator it3 = n85Var.S1().iterator();
                            ?? r236 = r23;
                            while (true) {
                                if (!it3.hasNext()) {
                                    jT = -1;
                                    r23 = r236;
                                    break;
                                }
                                a95 a95Var = (a95) it3.next();
                                Iterator it4 = it3;
                                if ("_npa".equals(a95Var.p())) {
                                    jT = a95Var.t();
                                    r23 = it4;
                                    break;
                                } else {
                                    it3 = it4;
                                    r236 = it4;
                                }
                            }
                            Iterator it5 = n85Var2.S1().iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    jT2 = -1;
                                    break;
                                }
                                a95 a95Var2 = (a95) it5.next();
                                if ("_npa".equals(a95Var2.p())) {
                                    jT2 = a95Var2.t();
                                    break;
                                }
                            }
                            if (jT != jT2) {
                                break;
                            }
                        }
                        if (!cursorQuery.isNull(2)) {
                            int i10 = cursorQuery.getInt(2);
                            l85Var.c();
                            ((n85) l85Var.f).R0(i10);
                        }
                        length += byteArray.length;
                        arrayList2.add(Pair.create((n85) l85Var.e(), Long.valueOf(j3)));
                    } catch (IOException e10) {
                        r9.n().z0.c("Failed to merge queued bundle. appId", t65.Z0(str3), e10);
                    }
                    r23 = r9;
                    if (cursorQuery.moveToNext() || length > iMax) {
                        break;
                        break;
                    }
                    m25VarE0 = m25Var;
                    r9 = r23;
                    i7 = 0;
                    i8 = 1;
                    r235 = r23;
                }
                cursorQuery.close();
                list2 = arrayList2;
                r232 = r23;
                if (list2.isEmpty()) {
                }
            } else {
                list = Collections.EMPTY_LIST;
                r234 = strValueOf;
                cursorQuery.close();
                r233 = r234;
                list2 = list;
                r232 = r233;
                if (list2.isEmpty()) {
                    return;
                }
                pf5 pf5Var = pf5.f;
                x15 x15VarC0 = c0();
                q55 q55Var = r55.i1;
                boolean zF12 = x15VarC0.f1(null, q55Var);
                r95 r95Var2 = r95.ANALYTICS_STORAGE;
                if (zF12) {
                    if (!c0().f1(null, q55Var)) {
                        list6 = list2;
                    } else if (a(str3).i(r95Var2) || !d0().a1(str3)) {
                        ArrayList arrayList3 = new ArrayList(list2.size());
                        m25 m25VarE02 = e0();
                        k85 k85Var4 = (k85) m25VarE02.f;
                        tj4.f(str3);
                        m25VarE02.V0();
                        m25VarE02.W0();
                        ArrayList arrayList4 = new ArrayList();
                        try {
                            try {
                                try {
                                    SQLiteDatabase sQLiteDatabaseK12 = m25VarE02.K1();
                                    k85Var4.z0().getClass();
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    Cursor cursorQuery2 = sQLiteDatabaseK12.query("no_data_mode_events", new String[]{"data"}, "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{str3, String.valueOf(jCurrentTimeMillis)}, null, null, "rowid", null);
                                    k85Var2 = k85Var4;
                                    try {
                                        try {
                                            if (cursorQuery2.moveToFirst()) {
                                                list7 = list2;
                                                while (true) {
                                                    try {
                                                        try {
                                                            arrayList4.add((w75) ((v75) z65.I1(w75.x(), cursorQuery2.getBlob(0))).e());
                                                            cursor = cursorQuery2;
                                                            arrayList = arrayList4;
                                                        } catch (pc5 e11) {
                                                            cursor = cursorQuery2;
                                                            try {
                                                                arrayList = arrayList4;
                                                                k85Var2.n().E0.c("Failed to parse stored NO_DATA mode event, appId", t65.Z0(str3), e11);
                                                            } catch (SQLiteException e12) {
                                                                e = e12;
                                                                k85Var2.n().z0.c("Error flushing NO_DATA mode events. appId", t65.Z0(str3), e);
                                                                list8 = Collections.EMPTY_LIST;
                                                                list9 = list7;
                                                                if (cursor != null) {
                                                                }
                                                            }
                                                        }
                                                        if (!cursor.moveToNext()) {
                                                            break;
                                                        }
                                                        cursorQuery2 = cursor;
                                                        arrayList4 = arrayList;
                                                    } catch (SQLiteException e13) {
                                                        e = e13;
                                                        cursor = cursorQuery2;
                                                        k85Var2.n().z0.c("Error flushing NO_DATA mode events. appId", t65.Z0(str3), e);
                                                        list8 = Collections.EMPTY_LIST;
                                                        list9 = list7;
                                                        if (cursor != null) {
                                                        }
                                                        it = list9.iterator();
                                                        boolean z4 = true;
                                                        while (it.hasNext()) {
                                                        }
                                                        list6 = arrayList3;
                                                        zIsEmpty = list6.isEmpty();
                                                        list3 = list6;
                                                        if (zIsEmpty) {
                                                        }
                                                        t95VarA = a(str3);
                                                        r95Var = r95.AD_STORAGE;
                                                        if (!t95VarA.i(r95Var)) {
                                                        }
                                                        g85VarU = j85.u();
                                                        size = listSubList.size();
                                                        ArrayList arrayList5 = new ArrayList(listSubList.size());
                                                        if (c0().W0(str3)) {
                                                        }
                                                        boolean zI2 = a(str3).i(r95Var);
                                                        zI = a(str3).i(r95Var2);
                                                        zF1 = c0().f1(str3, r55.N0);
                                                        te5 te5Var = this.A0;
                                                        re5 re5VarW0 = te5Var.W0(str3);
                                                        list4 = listSubList;
                                                        while (true) {
                                                            k85Var = this.C0;
                                                            if (i < size) {
                                                            }
                                                            i = i + 1;
                                                            size = i3;
                                                            zI = z2;
                                                            list4 = list5;
                                                            i2 = i4;
                                                            zF1 = z3;
                                                        }
                                                        if (((j85) g85VarU.f).o() != 0) {
                                                        }
                                                    }
                                                }
                                                cursor.close();
                                                try {
                                                    int iDelete = sQLiteDatabaseK12.delete("no_data_mode_events", "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{str3, String.valueOf(jCurrentTimeMillis)});
                                                    q65 q65Var = k85Var2.n().H0;
                                                    StringBuilder sb = new StringBuilder(String.valueOf(iDelete).length() + 34);
                                                    sb.append("Pruned ");
                                                    sb.append(iDelete);
                                                    sb.append(" NO_DATA mode events. appId");
                                                    q65Var.b(str3, sb.toString());
                                                    list10 = list7;
                                                } catch (SQLiteException e14) {
                                                    e = e14;
                                                    cursor = null;
                                                    k85Var2.n().z0.c("Error flushing NO_DATA mode events. appId", t65.Z0(str3), e);
                                                    list8 = Collections.EMPTY_LIST;
                                                    list9 = list7;
                                                    if (cursor != null) {
                                                        cursor.close();
                                                        list9 = list7;
                                                    }
                                                }
                                            } else {
                                                arrayList = arrayList4;
                                                list10 = list2;
                                                cursorQuery2.close();
                                            }
                                            list8 = arrayList;
                                            list9 = list10;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            r232 = cursorQuery2;
                                            r142 = r232;
                                            if (r142 != 0) {
                                            }
                                            throw th;
                                        }
                                    } catch (SQLiteException e15) {
                                        e = e15;
                                        cursor = cursorQuery2;
                                        list7 = list2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    r142 = 0;
                                    if (r142 != 0) {
                                        r142.close();
                                    }
                                    throw th;
                                }
                            } catch (SQLiteException e16) {
                                e = e16;
                                k85Var2 = k85Var4;
                                list7 = list2;
                            }
                            it = list9.iterator();
                            boolean z42 = true;
                            while (it.hasNext()) {
                                Pair pair = (Pair) it.next();
                                l85 l85Var2 = (l85) ((n85) pair.first).g();
                                if (z42 && !list8.isEmpty()) {
                                    List listY = l85Var2.Y();
                                    l85Var2.c();
                                    ((n85) l85Var2.f).Y();
                                    l85Var2.c();
                                    ((n85) l85Var2.f).X(list8);
                                    l85Var2.c();
                                    ((n85) l85Var2.f).X(listY);
                                    z42 = false;
                                }
                                m75 m75VarO = r75.o();
                                a65 a65VarQ1 = d0().q1(str3);
                                ArrayList arrayList6 = new ArrayList();
                                if (a65VarQ1 != null) {
                                    Iterator it6 = a65VarQ1.n().iterator();
                                    while (it6.hasNext()) {
                                        o55 o55Var = (o55) it6.next();
                                        Iterator it7 = it;
                                        p75 p75VarN = q75.n();
                                        boolean z5 = z42;
                                        int iN = o55Var.n() - 1;
                                        List list11 = list8;
                                        if (iN == 1) {
                                            it2 = it6;
                                            i5 = 3;
                                            i6 = 2;
                                        } else if (iN != 2) {
                                            it2 = it6;
                                            i5 = 3;
                                            i6 = iN != 3 ? iN != 4 ? 1 : 5 : 4;
                                        } else {
                                            it2 = it6;
                                            i5 = 3;
                                            i6 = 3;
                                        }
                                        p75VarN.h(i6);
                                        int iP = o55Var.p() - 1;
                                        if (iP == 1) {
                                            i5 = 2;
                                        } else if (iP != 2) {
                                            i5 = 1;
                                        }
                                        p75VarN.i(i5);
                                        arrayList6.add((q75) p75VarN.e());
                                        it = it7;
                                        list8 = list11;
                                        z42 = z5;
                                        it6 = it2;
                                    }
                                }
                                Iterator it8 = it;
                                boolean z6 = z42;
                                List list12 = list8;
                                m75VarO.h(arrayList6);
                                l85Var2.G(m75VarO);
                                arrayList3.add(Pair.create((n85) l85Var2.e(), (Long) pair.second));
                                it = it8;
                                list8 = list12;
                                z42 = z6;
                            }
                            list6 = arrayList3;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } else {
                        List listAsList = Arrays.asList(((String) r55.j1.a(null)).split(","));
                        for (Pair pair2 : list2) {
                            try {
                                e0().e1(((Long) pair2.second).longValue());
                                for (w75 w75Var : ((n85) pair2.first).N1()) {
                                    if (listAsList.contains(w75Var.q())) {
                                        if (w75Var.q().equals("_f") || w75Var.q().equals("_v")) {
                                            v75 v75Var = (v75) w75Var.g();
                                            h0();
                                            z65.b1(v75Var, "_dac", 1L);
                                            w75Var = (w75) v75Var.e();
                                        }
                                        m25 m25VarE03 = e0();
                                        m25VarE03.V0();
                                        m25VarE03.W0();
                                        tj4.f(str3);
                                        k85 k85Var5 = (k85) m25VarE03.f;
                                        k85Var5.n().H0.b(w75Var, "Caching events in NO_DATA mode");
                                        ContentValues contentValues = new ContentValues();
                                        contentValues.put("app_id", str3);
                                        w75 w75Var2 = w75Var;
                                        contentValues.put("name", w75Var2.q());
                                        contentValues.put("data", w75Var2.a());
                                        contentValues.put("timestamp_millis", Long.valueOf(w75Var2.s()));
                                        try {
                                            if (m25VarE03.K1().insert("no_data_mode_events", null, contentValues) == j2) {
                                                k85Var5.n().z0.b(t65.Z0(str3), "Failed to insert NO_DATA mode event (got -1). appId");
                                            }
                                        } catch (SQLiteException e17) {
                                            ((k85) m25VarE03.f).n().z0.c("Error storing NO_DATA mode event. appId", t65.Z0(str3), e17);
                                        }
                                    }
                                }
                            } catch (SQLiteException unused) {
                                n().E0.b(str3, "Failed handling NO_DATA mode bundles. appId");
                            }
                        }
                        list6 = Collections.EMPTY_LIST;
                    }
                    zIsEmpty = list6.isEmpty();
                    list3 = list6;
                    if (zIsEmpty) {
                        return;
                    }
                } else {
                    list3 = list2;
                }
                t95VarA = a(str3);
                r95Var = r95.AD_STORAGE;
                if (!t95VarA.i(r95Var)) {
                    Iterator it9 = list3.iterator();
                    while (true) {
                        if (!it9.hasNext()) {
                            strT = null;
                            break;
                        }
                        n85 n85Var3 = (n85) ((Pair) it9.next()).first;
                        if (!n85Var3.t().isEmpty()) {
                            strT = n85Var3.t();
                            break;
                        }
                    }
                    if (strT != null) {
                        for (int i11 = 0; i11 < list3.size(); i11++) {
                            n85 n85Var4 = (n85) ((Pair) list3.get(i11)).first;
                            if (!n85Var4.t().isEmpty() && !n85Var4.t().equals(strT)) {
                                i = 0;
                                listSubList = list3.subList(0, i11);
                                break;
                            }
                        }
                        i = 0;
                        listSubList = list3;
                    } else {
                        i = 0;
                        listSubList = list3;
                    }
                }
                g85VarU = j85.u();
                size = listSubList.size();
                ArrayList arrayList52 = new ArrayList(listSubList.size());
                i2 = (c0().W0(str3) || !a(str3).i(r95Var)) ? i : 1;
                boolean zI22 = a(str3).i(r95Var);
                zI = a(str3).i(r95Var2);
                zF1 = c0().f1(str3, r55.N0);
                te5 te5Var2 = this.A0;
                re5 re5VarW02 = te5Var2.W0(str3);
                list4 = listSubList;
                while (true) {
                    k85Var = this.C0;
                    if (i < size) {
                        break;
                    }
                    l85 l85Var3 = (l85) ((n85) ((Pair) list4.get(i)).first).g();
                    int i12 = i;
                    arrayList52.add((Long) ((Pair) list4.get(i)).second);
                    c0().a1();
                    l85Var3.t();
                    l85Var3.c();
                    ((n85) l85Var3.f).d0(j);
                    k85Var.getClass();
                    l85Var3.L();
                    if (i2 == 0) {
                        l85Var3.c();
                        ((n85) l85Var3.f).Q0();
                    }
                    if (!zI22) {
                        l85Var3.c();
                        ((n85) l85Var3.f).x1();
                        l85Var3.c();
                        ((n85) l85Var3.f).z1();
                    }
                    if (!zI) {
                        l85Var3.c();
                        ((n85) l85Var3.f).B1();
                    }
                    r(str3, l85Var3);
                    if (!zF1) {
                        l85Var3.c();
                        ((n85) l85Var3.f).X0();
                    }
                    if (!zI) {
                        l85Var3.c();
                        ((n85) l85Var3.f).J1();
                    }
                    String strT2 = ((n85) l85Var3.f).t();
                    if (TextUtils.isEmpty(strT2)) {
                        i3 = size;
                    } else {
                        i3 = size;
                        if (!strT2.equals("00000000-0000-0000-0000-000000000000")) {
                            z2 = zI;
                            i4 = i2;
                            list5 = list4;
                            z3 = zF1;
                        }
                        if (l85Var3.Z() != 0) {
                            if (c0().f1(str3, r55.D0)) {
                                l85Var3.T(h0().G1(((n85) l85Var3.e()).a()));
                            }
                            y85 y85Var = re5VarW02.d;
                            if (y85Var != null) {
                                l85Var3.C(y85Var);
                            }
                            g85VarU.c();
                            ((j85) g85VarU.f).x((n85) l85Var3.e());
                        }
                        i = i12 + 1;
                        size = i3;
                        zI = z2;
                        list4 = list5;
                        i2 = i4;
                        zF1 = z3;
                    }
                    ArrayList arrayList7 = new ArrayList(l85Var3.Y());
                    Iterator it10 = arrayList7.iterator();
                    z2 = zI;
                    Long lValueOf = null;
                    Long lValueOf2 = null;
                    boolean z7 = false;
                    boolean z8 = false;
                    while (it10.hasNext()) {
                        int i13 = i2;
                        w75 w75Var3 = (w75) it10.next();
                        List list13 = list4;
                        boolean z9 = zF1;
                        if ("_fx".equals(w75Var3.q())) {
                            it10.remove();
                            list4 = list13;
                            i2 = i13;
                            zF1 = z9;
                            z7 = true;
                        } else if ("_f".equals(w75Var3.q())) {
                            h0();
                            b85 b85VarD1 = z65.d1("_pfo", w75Var3);
                            if (b85VarD1 != null) {
                                lValueOf = Long.valueOf(b85VarD1.s());
                            }
                            h0();
                            b85 b85VarD12 = z65.d1("_uwa", w75Var3);
                            if (b85VarD12 != null) {
                                lValueOf2 = Long.valueOf(b85VarD12.s());
                            }
                            list4 = list13;
                            i2 = i13;
                            zF1 = z9;
                        } else {
                            list4 = list13;
                            i2 = i13;
                            zF1 = z9;
                        }
                        z8 = true;
                    }
                    i4 = i2;
                    list5 = list4;
                    z3 = zF1;
                    if (z7) {
                        l85Var3.c();
                        ((n85) l85Var3.f).Y();
                        l85Var3.c();
                        ((n85) l85Var3.f).X(arrayList7);
                    }
                    if (z8) {
                        q(l85Var3.o(), true, lValueOf, lValueOf2);
                    }
                    if (l85Var3.Z() != 0) {
                    }
                    i = i12 + 1;
                    size = i3;
                    zI = z2;
                    list4 = list5;
                    i2 = i4;
                    zF1 = z3;
                }
                if (((j85) g85VarU.f).o() != 0) {
                    k(arrayList52);
                    u(false, 204, null, null, str3, Collections.EMPTY_LIST);
                    return;
                }
                j85 j85Var = (j85) g85VarU.e();
                ArrayList arrayList8 = new ArrayList();
                qb5 qb5Var = re5VarW02.c;
                boolean z10 = qb5Var == qb5.SGTM_CLIENT;
                if (qb5Var == qb5.SGTM) {
                    z = z10;
                } else {
                    if (!z10) {
                        str2 = null;
                        z65Var = this.f;
                        R(z65Var);
                        if (z65Var.p1()) {
                            return;
                        }
                        String strY1 = Log.isLoggable(n().b1(), 2) ? h0().y1(j85Var) : str2;
                        h0();
                        byte[] bArrA = j85Var.a();
                        k(arrayList52);
                        this.z0.C0.b(j);
                        n().H0.d("Uploading data. app, uncompressed size, data", str3, Integer.valueOf(bArrA.length), strY1);
                        this.L0 = true;
                        R(z65Var);
                        z65Var.t1(str3, re5VarW02, j85Var, new ab5(this, str3, arrayList8, 1));
                        return;
                    }
                    z = true;
                }
                Iterator it11 = ((j85) g85VarU.e()).n().iterator();
                while (true) {
                    if (it11.hasNext()) {
                        if (((n85) it11.next()).L()) {
                            string = UUID.randomUUID().toString();
                            break;
                        }
                    } else {
                        string = null;
                        break;
                    }
                }
                j85 j85Var2 = (j85) g85VarU.e();
                C().V0();
                j0();
                g85 g85VarV = j85.v(j85Var2);
                if (!TextUtils.isEmpty(string)) {
                    g85VarV.c();
                    ((j85) g85VarV.f).A(string);
                }
                String strI1 = d0().i1(str3);
                if (!TextUtils.isEmpty(strI1)) {
                    g85VarV.i(strI1);
                }
                ArrayList arrayList9 = new ArrayList();
                Iterator it12 = j85Var2.n().iterator();
                while (it12.hasNext()) {
                    l85 l85VarT = n85.T((n85) it12.next());
                    l85VarT.c();
                    ((n85) l85VarT.f).Q0();
                    arrayList9.add((n85) l85VarT.e());
                }
                g85VarV.c();
                ((j85) g85VarV.f).z();
                g85VarV.c();
                ((j85) g85VarV.f).y(arrayList9);
                n().H0.b(TextUtils.isEmpty(string) ? "null" : g85VarV.h(), "[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ");
                j85 j85Var3 = (j85) g85VarV.e();
                if (TextUtils.isEmpty(string)) {
                    str2 = null;
                } else {
                    j85 j85Var4 = (j85) g85VarU.e();
                    C().V0();
                    j0();
                    g85 g85VarU2 = j85.u();
                    n().H0.b(string, "[sgtm] Processing Google Signal, sgtmJoinId:");
                    g85VarU2.c();
                    ((j85) g85VarU2.f).A(string);
                    for (n85 n85Var5 : j85Var4.n()) {
                        l85 l85VarS = n85.S();
                        String strM = n85Var5.M();
                        l85VarS.c();
                        ((n85) l85VarS.f).P0(strM);
                        int iI0 = n85Var5.I0();
                        l85VarS.c();
                        ((n85) l85VarS.f).h1(iI0);
                        g85VarU2.c();
                        ((j85) g85VarU2.f).x((n85) l85VarS.e());
                    }
                    j85 j85Var5 = (j85) g85VarU2.e();
                    String strI12 = te5Var2.X.d0().i1(str3);
                    boolean zIsEmpty2 = TextUtils.isEmpty(strI12);
                    qb5 qb5Var2 = qb5.GOOGLE_SIGNAL;
                    qb5 qb5Var3 = qb5.GOOGLE_SIGNAL_PENDING;
                    if (zIsEmpty2) {
                        str2 = null;
                        String str4 = (String) r55.s.a(null);
                        if (z) {
                            qb5Var2 = qb5Var3;
                        }
                        re5Var = new re5(str4, Collections.EMPTY_MAP, qb5Var2, null);
                    } else {
                        Uri uri = Uri.parse((String) r55.s.a(null));
                        Uri.Builder builderBuildUpon = uri.buildUpon();
                        String authority = uri.getAuthority();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(strI12).length() + 1 + String.valueOf(authority).length());
                        sb2.append(strI12);
                        sb2.append(".");
                        sb2.append(authority);
                        builderBuildUpon.authority(sb2.toString());
                        String string2 = builderBuildUpon.build().toString();
                        if (z) {
                            qb5Var2 = qb5Var3;
                        }
                        str2 = null;
                        re5Var = new re5(string2, Collections.EMPTY_MAP, qb5Var2, null);
                    }
                    arrayList8.add(Pair.create(j85Var5, re5Var));
                }
                if (z) {
                    g85 g85Var = (g85) j85Var3.g();
                    for (int i14 = 0; i14 < j85Var3.o(); i14++) {
                        l85 l85Var4 = (l85) j85Var3.p(i14).g();
                        l85Var4.e0();
                        l85Var4.D(j);
                        g85Var.c();
                        ((j85) g85Var.f).w(i14, (n85) l85Var4.e());
                    }
                    arrayList8.add(Pair.create((j85) g85Var.e(), re5VarW02));
                    k(arrayList52);
                    u(false, 204, null, null, str, arrayList8);
                    if (o(str, re5VarW02.a)) {
                        n().H0.b(str, "[sgtm] Sending sgtm batches available notification to app");
                        Intent intent = new Intent();
                        intent.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                        intent.setPackage(str);
                        P(k85Var.r0(), intent);
                        return;
                    }
                    return;
                }
                str3 = str;
                j85Var = j85Var3;
                z65Var = this.f;
                R(z65Var);
                if (z65Var.p1()) {
                }
            }
        } catch (Throwable th5) {
            th = th5;
            r14 = 0;
            if (r14 != 0) {
                r14.close();
            }
            throw th;
        }
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
    */
    public final o25 o0(String str, o25 o25Var, t95 t95Var, rz4 rz4Var) {
        r95 r95VarG1;
        r95 r95Var;
        o95 o95Var;
        o95 o95VarZ0;
        x75 x75Var = this.b;
        R(x75Var);
        a65 a65VarQ1 = x75Var.q1(str);
        int i = 90;
        o95 o95Var2 = o95.DENIED;
        r95 r95Var2 = r95.AD_USER_DATA;
        if (a65VarQ1 == null) {
            if (o25Var.a() == o95Var2) {
                i = o25Var.a;
                rz4Var.e(r95Var2, i);
            } else {
                rz4Var.f(r95Var2, z15.FAILSAFE);
            }
            return new o25(Boolean.FALSE, i, Boolean.TRUE, "-");
        }
        o95 o95VarA = o25Var.a();
        o95 o95Var3 = o95.GRANTED;
        if (o95VarA == o95Var3 || o95VarA == o95Var2) {
            i = o25Var.a;
            rz4Var.e(r95Var2, i);
        } else {
            o95 o95Var4 = o95.POLICY;
            o95 o95Var5 = o95.UNINITIALIZED;
            if (o95VarA != o95Var4 || (o95VarZ0 = x75Var.Z0(str, r95Var2)) == o95Var5) {
                x75Var.V0();
                x75Var.b1(str);
                a65 a65VarQ12 = x75Var.q1(str);
                if (a65VarQ12 == null) {
                    r95VarG1 = null;
                    EnumMap enumMap = t95Var.a;
                    r95Var = r95.AD_STORAGE;
                    o95Var = (o95) enumMap.get(r95Var);
                    if (o95Var != null) {
                        o95Var5 = o95Var;
                    }
                    boolean z = o95Var5 != o95Var3 || o95Var5 == o95Var2;
                    if (r95VarG1 == r95Var || !z) {
                        rz4Var.f(r95Var2, z15.REMOTE_DEFAULT);
                        o95VarA = true == x75Var.p1(str, r95Var2) ? o95Var2 : o95Var3;
                    } else {
                        rz4Var.f(r95Var2, z15.REMOTE_DELEGATION);
                        o95VarA = o95Var5;
                    }
                } else {
                    for (p55 p55Var : a65VarQ12.o()) {
                        if (r95Var2 == x75.g1(p55Var.n())) {
                            r95VarG1 = x75.g1(p55Var.o());
                            break;
                        }
                    }
                    r95VarG1 = null;
                    EnumMap enumMap2 = t95Var.a;
                    r95Var = r95.AD_STORAGE;
                    o95Var = (o95) enumMap2.get(r95Var);
                    if (o95Var != null) {
                    }
                    if (o95Var5 != o95Var3) {
                        if (r95VarG1 == r95Var) {
                            rz4Var.f(r95Var2, z15.REMOTE_DEFAULT);
                            if (true == x75Var.p1(str, r95Var2)) {
                            }
                        }
                    }
                }
            } else {
                rz4Var.f(r95Var2, z15.REMOTE_ENFORCED_DEFAULT);
                o95VarA = o95VarZ0;
            }
        }
        x75Var.V0();
        x75Var.b1(str);
        a65 a65VarQ13 = x75Var.q1(str);
        boolean z2 = a65VarQ13 == null || !a65VarQ13.q() || a65VarQ13.r();
        R(x75Var);
        x75Var.V0();
        x75Var.b1(str);
        TreeSet treeSet = new TreeSet();
        a65 a65VarQ14 = x75Var.q1(str);
        if (a65VarQ14 != null) {
            Iterator it = a65VarQ14.p().iterator();
            while (it.hasNext()) {
                treeSet.add(((x55) it.next()).n());
            }
        }
        if (o95VarA == o95Var2 || treeSet.isEmpty()) {
            return new o25(Boolean.FALSE, i, Boolean.valueOf(z2), "-");
        }
        return new o25(Boolean.TRUE, i, Boolean.valueOf(z2), z2 ? TextUtils.join("", treeSet) : "");
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
    */
    public final void r(String str, l85 l85Var) {
        int iJ1;
        int iIndexOf;
        x75 x75Var = this.b;
        R(x75Var);
        x75Var.V0();
        x75Var.b1(str);
        ie ieVar = x75Var.y0;
        Set set = (Set) ieVar.get(str);
        if (set != null) {
            l85Var.c();
            ((n85) l85Var.f).Y0(set);
        }
        R(x75Var);
        x75Var.V0();
        x75Var.b1(str);
        if (ieVar.get(str) != null && (((Set) ieVar.get(str)).contains("device_model") || ((Set) ieVar.get(str)).contains("device_info"))) {
            l85Var.c();
            ((n85) l85Var.f).o1();
        }
        R(x75Var);
        if (x75Var.n1(str)) {
            String strG2 = ((n85) l85Var.f).g2();
            if (!TextUtils.isEmpty(strG2) && (iIndexOf = strG2.indexOf(".")) != -1) {
                String strSubstring = strG2.substring(0, iIndexOf);
                l85Var.c();
                ((n85) l85Var.f).m0(strSubstring);
            }
        }
        R(x75Var);
        x75Var.V0();
        x75Var.b1(str);
        if (ieVar.get(str) != null && ((Set) ieVar.get(str)).contains("user_id") && (iJ1 = z65.J1("_id", l85Var)) != -1) {
            l85Var.c();
            ((n85) l85Var.f).c0(iJ1);
        }
        R(x75Var);
        x75Var.V0();
        x75Var.b1(str);
        if (ieVar.get(str) != null && ((Set) ieVar.get(str)).contains("google_signals")) {
            l85Var.c();
            ((n85) l85Var.f).Q0();
        }
        R(x75Var);
        if (x75Var.o1(str)) {
            l85Var.c();
            ((n85) l85Var.f).B1();
            if (a(str).i(r95.ANALYTICS_STORAGE)) {
                HashMap map = this.U0;
                bf5 bf5Var = (bf5) map.get(str);
                if (bf5Var != null) {
                    long jC1 = c0().c1(str, r55.l0) + bf5Var.b;
                    z0().getClass();
                    if (jC1 < SystemClock.elapsedRealtime()) {
                        bf5Var = new bf5(this, i0().P1());
                        map.put(str, bf5Var);
                    }
                    String str2 = bf5Var.a;
                    l85Var.c();
                    ((n85) l85Var.f).Z0(str2);
                }
            }
        }
        R(x75Var);
        x75Var.V0();
        x75Var.b1(str);
        if (ieVar.get(str) == null || !((Set) ieVar.get(str)).contains("enhanced_user_id")) {
            return;
        }
        l85Var.c();
        ((n85) l85Var.f).X0();
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
    */
    public final void u(boolean z, int i, Throwable th, byte[] bArr, String str, List list) {
        byte[] bArr2;
        Iterator it;
        boolean zHasNext;
        qb5 qb5Var;
        Iterator it2;
        List listA1;
        int i2 = i;
        z65 z65Var = this.f;
        C().V0();
        j0();
        if (bArr == null) {
            try {
                bArr2 = new byte[0];
            } catch (Throwable th2) {
                this.L0 = false;
                L();
                throw th2;
            }
        } else {
            bArr2 = bArr;
        }
        ArrayList<Long> arrayList = this.P0;
        tj4.i(arrayList);
        this.P0 = null;
        if (!z) {
            q65 q65Var = n().H0;
            Integer numValueOf = Integer.valueOf(i2);
            q65Var.c("Network upload successful with code, uploadAttempted", numValueOf, Boolean.valueOf(z));
            if (z) {
                try {
                    u uVar = this.z0.B0;
                    z0().getClass();
                    uVar.b(System.currentTimeMillis());
                    this.z0.C0.b(0L);
                    K();
                    if (z) {
                        n().H0.a("Purged empty bundles");
                    } else {
                        n().H0.c("Successful upload. Got network response. code, size", numValueOf, Integer.valueOf(bArr2.length));
                    }
                    m25 m25Var = this.z;
                    R(m25Var);
                    m25Var.H1();
                    try {
                        HashMap map = new HashMap();
                        it = list.iterator();
                        while (true) {
                            zHasNext = it.hasNext();
                            qb5Var = qb5.SGTM_CLIENT;
                            if (zHasNext) {
                                break;
                            }
                            Pair pair = (Pair) it.next();
                            j85 j85Var = (j85) pair.first;
                            re5 re5Var = (re5) pair.second;
                            qb5 qb5Var2 = re5Var.c;
                            qb5 qb5Var3 = re5Var.c;
                            if (qb5Var2 != qb5Var) {
                                m25 m25Var2 = this.z;
                                R(m25Var2);
                                String str2 = re5Var.a;
                                Map map2 = re5Var.b;
                                if (map2 == null) {
                                    map2 = Collections.EMPTY_MAP;
                                }
                                long jZ0 = m25Var2.Z0(str, j85Var, str2, map2, qb5Var3, null);
                                if (qb5Var3 == qb5.GOOGLE_SIGNAL_PENDING && jZ0 != -1 && !j85Var.r().isEmpty()) {
                                    map.put(j85Var.r(), Long.valueOf(jZ0));
                                }
                            }
                        }
                        it2 = list.iterator();
                        while (it2.hasNext()) {
                            Pair pair2 = (Pair) it2.next();
                            j85 j85Var2 = (j85) pair2.first;
                            re5 re5Var2 = (re5) pair2.second;
                            if (re5Var2.c == qb5Var) {
                                Long l = (Long) map.get(j85Var2.r());
                                m25 m25Var3 = this.z;
                                R(m25Var3);
                                qb5 qb5Var4 = qb5Var;
                                String str3 = re5Var2.a;
                                Map map3 = re5Var2.b;
                                if (map3 == null) {
                                    map3 = Collections.EMPTY_MAP;
                                }
                                m25Var3.Z0(str, j85Var2, str3, map3, re5Var2.c, l);
                                qb5Var = qb5Var4;
                            }
                        }
                        m25 m25Var4 = this.z;
                        R(m25Var4);
                        listA1 = m25Var4.a1(str, le5.a(qb5Var), 1);
                        if (!listA1.isEmpty()) {
                            long j = ((if5) listA1.get(0)).f;
                            z0().getClass();
                            if (System.currentTimeMillis() > ((Long) r55.F.a(null)).longValue() + j) {
                                n().C0.c("[sgtm] client batches are queued too long. appId, creationTime", str, Long.valueOf(j));
                            }
                        }
                        for (Long l2 : arrayList) {
                            try {
                                m25 m25Var5 = this.z;
                                R(m25Var5);
                                m25Var5.e1(l2.longValue());
                            } catch (SQLiteException e) {
                                ArrayList arrayList2 = this.Q0;
                                if (arrayList2 == null || !arrayList2.contains(l2)) {
                                    throw e;
                                }
                            }
                        }
                        m25 m25Var6 = this.z;
                        R(m25Var6);
                        m25Var6.I1();
                        m25 m25Var7 = this.z;
                        R(m25Var7);
                        m25Var7.J1();
                        this.Q0 = null;
                        R(z65Var);
                        if (!z65Var.p1()) {
                            m25 m25Var8 = this.z;
                            R(m25Var8);
                            if (m25Var8.b1(str)) {
                                p(str);
                            } else {
                                R(z65Var);
                                if (z65Var.p1() && I()) {
                                    l();
                                } else {
                                    this.R0 = -1L;
                                    K();
                                }
                            }
                            this.F0 = 0L;
                        }
                    } catch (Throwable th3) {
                        m25 m25Var9 = this.z;
                        R(m25Var9);
                        m25Var9.J1();
                        throw th3;
                    }
                } catch (SQLiteException e2) {
                    n().z0.b(e2, "Database error while trying to delete uploaded bundles");
                    z0().getClass();
                    this.F0 = SystemClock.elapsedRealtime();
                    n().H0.b(Long.valueOf(this.F0), "Disable upload, time");
                }
            } else {
                this.z0.C0.b(0L);
                K();
                if (z) {
                }
                m25 m25Var10 = this.z;
                R(m25Var10);
                m25Var10.H1();
                HashMap map4 = new HashMap();
                it = list.iterator();
                while (true) {
                    zHasNext = it.hasNext();
                    qb5Var = qb5.SGTM_CLIENT;
                    if (zHasNext) {
                    }
                }
                it2 = list.iterator();
                while (it2.hasNext()) {
                }
                m25 m25Var42 = this.z;
                R(m25Var42);
                listA1 = m25Var42.a1(str, le5.a(qb5Var), 1);
                if (!listA1.isEmpty()) {
                }
                while (r2.hasNext()) {
                }
                m25 m25Var62 = this.z;
                R(m25Var62);
                m25Var62.I1();
                m25 m25Var72 = this.z;
                R(m25Var72);
                m25Var72.J1();
                this.Q0 = null;
                R(z65Var);
                if (!z65Var.p1()) {
                }
            }
        } else if (i2 != 200) {
            if (i2 == 204) {
                i2 = 204;
                if (th == null) {
                }
            }
            String str4 = new String(bArr2, StandardCharsets.UTF_8);
            n().E0.d("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th, str4.substring(0, Math.min(32, str4.length())));
            u uVar2 = this.z0.C0;
            z0().getClass();
            uVar2.b(System.currentTimeMillis());
            if (i2 != 503) {
                u uVar3 = this.z0.A0;
                z0().getClass();
                uVar3.b(System.currentTimeMillis());
                m25 m25Var11 = this.z;
                R(m25Var11);
                m25Var11.g1(arrayList);
                K();
            }
        } else if (th == null) {
            String str42 = new String(bArr2, StandardCharsets.UTF_8);
            n().E0.d("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th, str42.substring(0, Math.min(32, str42.length())));
            u uVar22 = this.z0.C0;
            z0().getClass();
            uVar22.b(System.currentTimeMillis());
            if (i2 != 503 || i2 == 429) {
                u uVar32 = this.z0.A0;
                z0().getClass();
                uVar32.b(System.currentTimeMillis());
            }
            m25 m25Var112 = this.z;
            R(m25Var112);
            m25Var112.g1(arrayList);
            K();
        }
        this.L0 = false;
        L();
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
    */
    public final void w(String str, int i, Throwable th, byte[] bArr, Map map) {
        boolean z;
        z65 z65Var = this.f;
        C().V0();
        j0();
        tj4.f(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.K0 = false;
                L();
                throw th2;
            }
        }
        q65 q65Var = n().H0;
        Integer numValueOf = Integer.valueOf(bArr.length);
        q65Var.b(numValueOf, "onConfigFetched. Response size");
        m25 m25Var = this.z;
        R(m25Var);
        m25Var.H1();
        try {
            m25 m25Var2 = this.z;
            R(m25Var2);
            b75 b75VarX1 = m25Var2.X1(str);
            if (i == 200 || i == 204) {
                z = th != null;
            } else {
                if (i == 304) {
                    i = 304;
                    if (th != null) {
                    }
                }
            }
            if (b75VarX1 == null) {
                n().C0.b(t65.Z0(str), "App does not exist in onConfigFetched. appId");
            } else {
                x75 x75Var = this.b;
                if (z || i == 404) {
                    String strJ = J("Last-Modified", map);
                    String strJ2 = J(HttpHeaders.Names.ETAG, map);
                    if (i == 404 || i == 304) {
                        R(x75Var);
                        if (x75Var.h1(str) == null) {
                            R(x75Var);
                            x75Var.j1(str, null, null, null);
                        }
                    } else {
                        R(x75Var);
                        x75Var.j1(str, strJ, strJ2, bArr);
                    }
                    z0().getClass();
                    b75VarX1.f(System.currentTimeMillis());
                    m25 m25Var3 = this.z;
                    R(m25Var3);
                    m25Var3.Y1(b75VarX1, false);
                    if (i == 404) {
                        n().E0.b(str, "Config not found. Using empty config. appId");
                    } else {
                        n().H0.c("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), numValueOf);
                    }
                    R(z65Var);
                    if (z65Var.p1() && I()) {
                        l();
                    } else {
                        R(z65Var);
                        if (z65Var.p1()) {
                            m25 m25Var4 = this.z;
                            R(m25Var4);
                            if (m25Var4.b1(b75VarX1.D())) {
                                p(b75VarX1.D());
                            } else {
                                K();
                            }
                        }
                    }
                } else {
                    z0().getClass();
                    b75VarX1.g(System.currentTimeMillis());
                    m25 m25Var5 = this.z;
                    R(m25Var5);
                    m25Var5.Y1(b75VarX1, false);
                    n().H0.c("Fetching config failed. code, error", Integer.valueOf(i), th);
                    R(x75Var);
                    x75Var.V0();
                    x75Var.G0.put(str, null);
                    u uVar = this.z0.C0;
                    z0().getClass();
                    uVar.b(System.currentTimeMillis());
                    if (i == 503 || i == 429) {
                        u uVar2 = this.z0.A0;
                        z0().getClass();
                        uVar2.b(System.currentTimeMillis());
                    }
                    K();
                }
            }
            m25 m25Var6 = this.z;
            R(m25Var6);
            m25Var6.I1();
            this.K0 = false;
            L();
        } finally {
            m25 m25Var7 = this.z;
            R(m25Var7);
            m25Var7.J1();
        }
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
