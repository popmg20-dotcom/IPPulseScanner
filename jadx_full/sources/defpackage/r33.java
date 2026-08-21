package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r33 {
    public final Context a;
    public long b = 0;
    public SharedPreferences c = null;
    public SharedPreferences.Editor d;
    public boolean e;
    public final String f;
    public PreferenceScreen g;
    public j33 h;
    public j33 i;
    public j33 j;

    public r33(Context context) {
        this.a = context;
        this.f = context.getPackageName() + "_preferences";
    }

    public final SharedPreferences.Editor a() {
        if (!this.e) {
            return c().edit();
        }
        SharedPreferences.Editor editor = this.d;
        if (editor != null) {
            return editor;
        }
        SharedPreferences.Editor editorEdit = c().edit();
        this.d = editorEdit;
        return editorEdit;
    }

    public final long b() {
        long j;
        synchronized (this) {
            j = this.b;
            this.b = 1 + j;
        }
        return j;
    }

    public final SharedPreferences c() {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = this.a.getSharedPreferences(this.f, 0);
        this.c = sharedPreferences2;
        return sharedPreferences2;
    }

    public final PreferenceScreen d(Context context, int i, PreferenceScreen preferenceScreen) {
        this.e = true;
        q33 q33Var = new q33(context, this);
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            PreferenceGroup preferenceGroupC = q33Var.c(xml, preferenceScreen);
            xml.close();
            PreferenceScreen preferenceScreen2 = (PreferenceScreen) preferenceGroupC;
            preferenceScreen2.l(this);
            SharedPreferences.Editor editor = this.d;
            if (editor != null) {
                editor.apply();
            }
            this.e = false;
            return preferenceScreen2;
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }
}
