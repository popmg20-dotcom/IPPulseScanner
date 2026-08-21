package defpackage;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ud2 implements td2 {
    public final LocaleList a;

    public ud2(Object obj) {
        this.a = (LocaleList) obj;
    }

    @Override // defpackage.td2
    public final String a() {
        return this.a.toLanguageTags();
    }

    @Override // defpackage.td2
    public final Object b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        return this.a.equals(((td2) obj).b());
    }

    @Override // defpackage.td2
    public final Locale get(int i) {
        return this.a.get(i);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // defpackage.td2
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // defpackage.td2
    public final int size() {
        return this.a.size();
    }

    public final String toString() {
        return this.a.toString();
    }
}
