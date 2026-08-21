package defpackage;

import android.content.ComponentName;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class dy2 {
    public static final String a = ue2.i("PackageManagerHelper");

    public static void a(Context context, Class cls, boolean z) {
        String str = a;
        try {
            int componentEnabledSetting = context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, cls.getName()));
            boolean z2 = false;
            if (componentEnabledSetting != 0 && componentEnabledSetting == 1) {
                z2 = true;
            }
            if (z == z2) {
                ue2.g().a(str, "Skipping component enablement for ".concat(cls.getName()));
                return;
            }
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            ue2 ue2VarG = ue2.g();
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(" ");
            sb.append(z ? "enabled" : "disabled");
            ue2VarG.a(str, sb.toString());
        } catch (Exception e) {
            ue2 ue2VarG2 = ue2.g();
            StringBuilder sb2 = new StringBuilder(cls.getName());
            sb2.append("could not be ");
            sb2.append(z ? "enabled" : "disabled");
            ue2VarG2.d(str, sb2.toString(), e);
        }
    }
}
