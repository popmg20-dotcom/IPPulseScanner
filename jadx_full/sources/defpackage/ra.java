package defpackage;

import android.content.res.Configuration;
import android.os.LocaleList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ra {
    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (locales.equals(locales2)) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    public static rd2 b(Configuration configuration) {
        return rd2.b(configuration.getLocales().toLanguageTags());
    }

    public static void c(rd2 rd2Var) {
        LocaleList.setDefault(LocaleList.forLanguageTags(rd2Var.a.a()));
    }

    public static void d(Configuration configuration, rd2 rd2Var) {
        configuration.setLocales(LocaleList.forLanguageTags(rd2Var.a.a()));
    }
}
