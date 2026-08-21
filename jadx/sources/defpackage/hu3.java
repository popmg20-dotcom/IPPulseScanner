package defpackage;

import android.os.Bundle;
import android.view.View;
import androidx.preference.Preference;
import com.getsurfboard.R;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hu3 extends j33 {
    @Override // defpackage.j33
    public final void onCreatePreferences(Bundle bundle, String str) {
        setPreferencesFromResource(R.xml.fragment_settings, str);
    }

    @Override // defpackage.j33, androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        getListView().setItemAnimator(null);
        getListView().setClipToPadding(false);
        o73 o73Var = new o73(7, this);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(view, o73Var);
        Preference preferenceFindPreference = findPreference("app");
        if (preferenceFindPreference != null) {
            preferenceFindPreference.w(getString(R.string.setting_app_category_summary, getString(R.string.app_name)));
        }
    }
}
