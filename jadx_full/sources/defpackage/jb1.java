package defpackage;

import java.util.Calendar;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class jb1 extends lb1 {
    public static final jb1 b = new jb1("(Z|(?:[+-]\\d{2}))");
    public static final jb1 c = new jb1("(Z|(?:[+-]\\d{2}\\d{2}))");
    public static final jb1 d = new jb1("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");

    public jb1(String str) {
        this.a = Pattern.compile(str);
    }

    @Override // defpackage.lb1
    public final void c(Calendar calendar, String str) {
        calendar.setTimeZone(dc1.a(str));
    }
}
