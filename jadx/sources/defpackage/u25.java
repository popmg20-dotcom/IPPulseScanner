package defpackage;

import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u25 extends k95 {
    public long Y;
    public String Z;

    @Override // defpackage.k95
    public final boolean W0() {
        Calendar calendar = Calendar.getInstance();
        this.Y = ((long) (calendar.get(16) + calendar.get(15))) / 60000;
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        this.Z = fw.z(new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length()), lowerCase, "-", lowerCase2);
        return false;
    }

    public final long Z0() {
        X0();
        return this.Y;
    }

    public final String a1() {
        X0();
        return this.Z;
    }
}
