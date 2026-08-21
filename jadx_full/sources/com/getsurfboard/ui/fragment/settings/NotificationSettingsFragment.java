package com.getsurfboard.ui.fragment.settings;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.SwitchPreferenceCompat;
import com.getsurfboard.R;
import defpackage.gq;
import defpackage.k41;
import defpackage.nk;
import defpackage.ye;
import defpackage.yw1;
import defpackage.zo2;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class NotificationSettingsFragment extends nk {
    public NotificationSettingsFragment() {
        super(R.xml.fragment_notification_settings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$0$0(Preference preference, Object obj) {
        preference.getClass();
        boolean z = yw1.G0;
        obj.getClass();
        yw1.G0 = !((Boolean) obj).booleanValue();
        return true;
    }

    @Override // defpackage.nk
    public Set<Integer> getRestartVPNPreferenceKeys() {
        return k41.b;
    }

    @Override // defpackage.nk, defpackage.j33, androidx.fragment.app.o
    public void onViewCreated(View view, Bundle bundle) {
        boolean zBooleanValue;
        view.getClass();
        super.onViewCreated(view, bundle);
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) findPreference(getString(R.string.setting_hide_status_bar_icon_and_notification_key));
        if (switchPreferenceCompat != null) {
            Boolean bool = ye.f;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                try {
                    try {
                        Properties properties = gq.a;
                        boolean z = (properties.getProperty("ro.miui.ui.version.code", null) == null && properties.getProperty("ro.miui.ui.version.name", null) == null && properties.getProperty("ro.miui.internal.storage", null) == null) ? false : true;
                        ye.f = Boolean.valueOf(z);
                        zBooleanValue = z;
                    } catch (Exception unused) {
                        zBooleanValue = false;
                    }
                } catch (Throwable unused2) {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    Method declaredMethod = cls.getDeclaredMethod("get", String.class);
                    Object objInvoke = declaredMethod.invoke(cls, "ro.miui.ui.version.code");
                    objInvoke.getClass();
                    if (((String) objInvoke).length() <= 0) {
                        Object objInvoke2 = declaredMethod.invoke(cls, "ro.miui.ui.version.name");
                        objInvoke2.getClass();
                        if (((String) objInvoke2).length() <= 0) {
                            Object objInvoke3 = declaredMethod.invoke(cls, "ro.miui.internal.storage");
                            objInvoke3.getClass();
                            if (((String) objInvoke3).length() <= 0) {
                                zBooleanValue = false;
                            }
                            ye.f = Boolean.valueOf(zBooleanValue);
                        }
                    }
                    zBooleanValue = true;
                    ye.f = Boolean.valueOf(zBooleanValue);
                }
            }
            if (zBooleanValue) {
                switchPreferenceCompat.x(false);
            }
            switchPreferenceCompat.X = new zo2(12);
        }
        SwitchPreferenceCompat switchPreferenceCompat2 = (SwitchPreferenceCompat) findPreference(getString(R.string.setting_auto_collapse_notification_bar_key));
        if (switchPreferenceCompat2 == null || Build.VERSION.SDK_INT < 34) {
            return;
        }
        switchPreferenceCompat2.x(false);
    }
}
