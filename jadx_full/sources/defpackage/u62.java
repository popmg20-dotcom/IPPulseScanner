package defpackage;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class u62 extends il {
    public static final Pattern d = Pattern.compile("^(?:true|false)$");
    public static final Pattern e = Pattern.compile("^(-?(0|[1-9][0-9]*)(\\.[0-9]*)?([eE][-+]?[0-9]+)?)|(-?\\.inf)|(\\.nan)$");
    public static final Pattern f = Pattern.compile("^-?(0|[1-9][0-9]*)$");
    public static final Pattern g = Pattern.compile("^(?:null)$");
}
