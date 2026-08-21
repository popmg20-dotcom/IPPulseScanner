package defpackage;

import com.getsurfboard.backup.model.BackupManifest;
import com.getsurfboard.backup.model.BackupSection;
import com.getsurfboard.backup.model.MetadataBackup;
import com.getsurfboard.backup.model.SettingsBackup;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class lj {
    public static final iq1 a = new iq1();

    public static jz1 a(k03 k03Var, Set set, mj mjVar) {
        MetadataBackup metadataBackup = k03Var.c;
        v92 v92Var = mjVar.b;
        jz1 jz1Var = new jz1();
        for (BackupSection backupSection : d70.g0(set, k03Var.a())) {
            gr3 gr3Var = new gr3(backupSection);
            try {
                int i = kj.a[backupSection.ordinal()];
                if (i == 1) {
                    SettingsBackup settingsBackup = k03Var.b;
                    if (settingsBackup != null) {
                        mjVar.a.b(settingsBackup, gr3Var);
                    }
                } else if (i == 2) {
                    mjVar.c.E(k03Var.d, gr3Var);
                } else if (i != 3) {
                    if (i != 4) {
                        throw new t80();
                    }
                    if (metadataBackup != null) {
                        v92Var.x(metadataBackup, gr3Var);
                    }
                } else if (metadataBackup != null) {
                    v92Var.y(metadataBackup, gr3Var);
                }
            } catch (Exception e) {
                String message = e.getMessage();
                if (message == null) {
                    message = e.getClass().getSimpleName();
                }
                gr3Var.d = message;
                gr3Var.e = e;
            }
            jz1Var.a.add(gr3Var);
        }
        return jz1Var;
    }

    public static k03 b(InputStream inputStream, char[] cArr) throws ti {
        Object tk3Var;
        BackupManifest backupManifest;
        SettingsBackup settingsBackup;
        ki kiVar;
        iq1 iq1Var = a;
        boolean z = (cArr == null || cArr.length == 0) ? false : true;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        MetadataBackup metadataBackup = null;
        try {
            vy4 vy4Var = z ? new vy4(inputStream, cArr) : new vy4(inputStream, null);
            try {
                for (qd2 qd2VarN = vy4Var.n(); qd2VarN != null; qd2VarN = vy4Var.n()) {
                    if (qd2VarN.n && !z) {
                        throw new si();
                    }
                    linkedHashMap.put(qd2VarN.m, l72.S(vy4Var));
                }
                vy4Var.close();
                tk3Var = xl4.a;
            } finally {
            }
        } catch (Throwable th) {
            tk3Var = new tk3(th);
        }
        Throwable thA = uk3.a(tk3Var);
        if (thA != null) {
            if (thA instanceof ti) {
                throw ((ti) thA);
            }
            if (thA instanceof qy4) {
                qy4 qy4Var = (qy4) thA;
                String message = qy4Var.getMessage();
                if (message == null) {
                    message = "";
                }
                if (p44.o0(message, "null password", true)) {
                    if (z) {
                        throw new oj();
                    }
                    throw new si();
                }
                if (qy4Var.b == 1) {
                    throw new oj();
                }
                kiVar = new ki(qy4Var);
            } else {
                kiVar = new ki(thA);
            }
            throw kiVar;
        }
        if (linkedHashMap.isEmpty()) {
            throw new ki(null);
        }
        byte[] bArr = (byte[]) linkedHashMap.remove("manifest.json");
        if (bArr != null) {
            try {
                String str = new String(bArr, y30.a);
                iq1Var.getClass();
                backupManifest = (BackupManifest) iq1Var.c(str, new bk4(BackupManifest.class));
            } catch (h62 unused) {
                backupManifest = null;
            }
            if (backupManifest != null) {
                if (backupManifest.getMinAppVersionCode() > 286) {
                    throw new nj(backupManifest.getMinAppVersionCode(), backupManifest.getAppVersion());
                }
                byte[] bArr2 = (byte[]) linkedHashMap.remove("settings.json");
                if (bArr2 != null) {
                    try {
                        String str2 = new String(bArr2, y30.a);
                        iq1Var.getClass();
                        settingsBackup = (SettingsBackup) iq1Var.c(str2, new bk4(SettingsBackup.class));
                    } catch (h62 unused2) {
                        settingsBackup = null;
                    }
                } else {
                    settingsBackup = null;
                }
                byte[] bArr3 = (byte[]) linkedHashMap.remove("metadata.json");
                if (bArr3 != null) {
                    try {
                        String str3 = new String(bArr3, y30.a);
                        iq1Var.getClass();
                        metadataBackup = (MetadataBackup) iq1Var.c(str3, new bk4(MetadataBackup.class));
                    } catch (h62 unused3) {
                    }
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (w44.j0((String) entry.getKey(), "profiles/", false)) {
                        linkedHashMap2.put(entry.getKey(), entry.getValue());
                    }
                }
                return new k03(backupManifest, settingsBackup, metadataBackup, linkedHashMap2);
            }
        }
        throw new ki(null);
    }
}
