package defpackage;

import com.getsurfboard.backup.model.BackupManifest;
import com.getsurfboard.backup.model.BackupSection;
import com.getsurfboard.backup.model.MetadataBackup;
import com.getsurfboard.backup.model.SettingsBackup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k03 {
    public final BackupManifest a;
    public final SettingsBackup b;
    public final MetadataBackup c;
    public final LinkedHashMap d;

    public k03(BackupManifest backupManifest, SettingsBackup settingsBackup, MetadataBackup metadataBackup, LinkedHashMap linkedHashMap) {
        this.a = backupManifest;
        this.b = settingsBackup;
        this.c = metadataBackup;
        this.d = linkedHashMap;
    }

    public final Set a() {
        List<String> sections = this.a.getSections();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = sections.iterator();
        while (it.hasNext()) {
            BackupSection backupSectionFromManifestName = BackupSection.Companion.fromManifestName((String) it.next());
            if (backupSectionFromManifestName != null) {
                arrayList.add(backupSectionFromManifestName);
            }
        }
        return d70.C0(arrayList);
    }
}
