package defpackage;

import android.content.SharedPreferences;
import com.getsurfboard.base.ContextUtilsKt;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class i73 {
    public static final SharedPreferences a = ContextUtilsKt.getContext().getSharedPreferences("profile_selection", 0);

    public static final String a() {
        return a.getString("selected_profile_name", null);
    }

    public static final void b(String str) {
        SharedPreferences sharedPreferences = a;
        sharedPreferences.getClass();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("selected_profile_name", str);
        editorEdit.apply();
    }
}
