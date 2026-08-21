package defpackage;

import j$.util.DesugarTimeZone;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jl implements Serializable {
    public static final TimeZone y0 = DesugarTimeZone.getTimeZone("UTC");
    public final qv A;
    public final DateFormat X;
    public final Locale Y;
    public final yj Z;
    public final rj4 b;
    public final fx3 f;
    public final r22 z;

    public jl(wl wlVar, r22 r22Var, rj4 rj4Var, DateFormat dateFormat, Locale locale, yj yjVar, qv qvVar) {
        this.f = wlVar;
        this.z = r22Var;
        this.b = rj4Var;
        this.X = dateFormat;
        this.Y = locale;
        this.Z = yjVar;
        this.A = qvVar;
    }
}
