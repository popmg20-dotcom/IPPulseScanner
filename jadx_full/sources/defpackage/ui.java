package defpackage;

import android.content.SharedPreferences;
import com.getsurfboard.backup.model.BackupManifest;
import com.getsurfboard.backup.model.BackupPayload;
import com.getsurfboard.backup.model.BackupSection;
import com.getsurfboard.backup.model.BackupVersionInfo;
import com.getsurfboard.backup.model.HostEntry;
import com.getsurfboard.backup.model.MetadataBackup;
import com.getsurfboard.backup.model.ProxyGroupSelectionEntry;
import com.getsurfboard.backup.model.SettingValue;
import com.getsurfboard.backup.model.SettingsBackup;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ui {
    public static final iq1 a = new iq1();

    public static final void a(xy4 xy4Var, boolean z, String str, byte[] bArr) throws IOException {
        yy4 yy4Var = new yy4();
        yy4Var.i = str;
        yy4Var.a = 2;
        if (z) {
            yy4Var.c = true;
            yy4Var.d = 4;
            yy4Var.f = 3;
        }
        xy4Var.n(yy4Var);
        xy4Var.write(bArr);
        xy4Var.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [g41] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.ArrayList] */
    public static void b(OutputStream outputStream, Set set, mj mjVar, BackupVersionInfo backupVersionInfo, char[] cArr) throws IOException {
        SettingsBackup settingsBackup;
        ?? arrayList;
        MetadataBackup metadataBackup;
        Map linkedHashMap;
        SettingValue settingValueA;
        if (set.contains(BackupSection.SETTINGS)) {
            sv3 sv3Var = mjVar.a;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (eu3 eu3Var : sv3Var.b) {
                if (sv3Var.a.contains(eu3Var.a)) {
                    try {
                        settingValueA = sv3Var.a(eu3Var);
                    } catch (ClassCastException unused) {
                        settingValueA = null;
                    }
                    if (settingValueA != null) {
                        linkedHashMap2.put(eu3Var.a, settingValueA);
                    }
                }
            }
            settingsBackup = new SettingsBackup(linkedHashMap2);
        } else {
            settingsBackup = null;
        }
        BackupSection backupSection = BackupSection.METADATA;
        if (set.contains(backupSection) || set.contains(BackupSection.HOSTS)) {
            v92 v92Var = mjVar.b;
            boolean zContains = set.contains(backupSection);
            boolean zContains2 = set.contains(BackupSection.HOSTS);
            ua3 ua3Var = (ua3) v92Var.b;
            String strA = zContains ? i73.a() : null;
            Set<String> setC0 = k41.b;
            if (zContains) {
                Set<String> stringSet = ((SharedPreferences) v92Var.z).getStringSet("pinned_profile_list", setC0);
                stringSet.getClass();
                setC0 = d70.C0(stringSet);
            }
            ?? arrayList2 = g41.b;
            if (zContains) {
                List listA = ua3Var.a();
                listA.getClass();
                List listY0 = d70.y0(d70.B0(listA));
                ArrayList<sa3> arrayList3 = new ArrayList();
                Iterator it = listY0.iterator();
                while (it.hasNext()) {
                    d70.U(ua3Var.b((String) it.next()), arrayList3);
                }
                arrayList = new ArrayList(f70.Q(10, arrayList3));
                for (sa3 sa3Var : arrayList3) {
                    arrayList.add(new ProxyGroupSelectionEntry(sa3Var.a, sa3Var.b, sa3Var.c));
                }
            } else {
                arrayList = arrayList2;
            }
            if (zContains2) {
                List<ls1> listA2 = ((os1) v92Var.f).a();
                arrayList2 = new ArrayList(f70.Q(10, listA2));
                for (ls1 ls1Var : listA2) {
                    arrayList2.add(new HostEntry(ls1Var.f, ls1Var.z));
                }
            }
            metadataBackup = new MetadataBackup(strA, setC0, arrayList, arrayList2);
        } else {
            metadataBackup = null;
        }
        boolean z = false;
        if (set.contains(BackupSection.PROFILES)) {
            File[] fileArrListFiles = ((File) mjVar.c.f).listFiles(new td1());
            if (fileArrListFiles != null) {
                int iU = fh2.U(fileArrListFiles.length);
                if (iU < 16) {
                    iU = 16;
                }
                linkedHashMap = new LinkedHashMap(iU);
                for (File file : fileArrListFiles) {
                    linkedHashMap.put(file.getName(), le1.T(file));
                }
            } else {
                linkedHashMap = h41.b;
            }
        } else {
            linkedHashMap = null;
        }
        int minAppVersionCode = backupVersionInfo.getMinAppVersionCode();
        String appVersion = backupVersionInfo.getAppVersion();
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList4 = new ArrayList(f70.Q(10, set));
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((BackupSection) it2.next()).getManifestName());
        }
        BackupPayload backupPayload = new BackupPayload(new BackupManifest(minAppVersionCode, appVersion, jCurrentTimeMillis, arrayList4), settingsBackup, metadataBackup, linkedHashMap);
        if (cArr != null && cArr.length != 0) {
            z = true;
        }
        xy4 xy4Var = z ? new xy4(outputStream, cArr) : new xy4(outputStream, null);
        try {
            iq1 iq1Var = a;
            String strH = iq1Var.h(backupPayload.getManifest());
            Charset charset = y30.a;
            byte[] bytes = strH.getBytes(charset);
            bytes.getClass();
            a(xy4Var, z, "manifest.json", bytes);
            SettingsBackup settings = backupPayload.getSettings();
            if (settings != null) {
                byte[] bytes2 = iq1Var.h(settings).getBytes(charset);
                bytes2.getClass();
                a(xy4Var, z, "settings.json", bytes2);
            }
            MetadataBackup metadata = backupPayload.getMetadata();
            if (metadata != null) {
                byte[] bytes3 = iq1Var.h(metadata).getBytes(charset);
                bytes3.getClass();
                a(xy4Var, z, "metadata.json", bytes3);
            }
            Map<String, byte[]> profiles = backupPayload.getProfiles();
            if (profiles != null) {
                for (Map.Entry<String, byte[]> entry : profiles.entrySet()) {
                    a(xy4Var, z, "profiles/" + entry.getKey(), entry.getValue());
                }
            }
            xy4Var.close();
        } finally {
        }
    }
}
