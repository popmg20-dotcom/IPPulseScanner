package defpackage;

import j$.util.DesugarCollections;
import java.util.EnumSet;
import java.util.Set;
import java.util.TreeMap;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class br implements yr, to2 {
    public static final ar A;
    public static final Set X;
    public static final /* synthetic */ br[] Y;
    public static final yq f;
    public static final zq z;
    public final String b;

    static {
        yq yqVar = new yq("none", 0, "none");
        f = yqVar;
        zq zqVar = new zq("zlib", 1, "zlib");
        z = zqVar;
        ar arVar = new ar("delayedZlib", 2, "zlib@openssh.com");
        A = arVar;
        Y = new br[]{yqVar, zqVar, arVar};
        X = DesugarCollections.unmodifiableSet(EnumSet.allOf(br.class));
        new TreeMap(String.CASE_INSENSITIVE_ORDER);
    }

    public br(String str, int i, String str2) {
        this.b = str2;
    }

    public static br valueOf(String str) {
        return (br) Enum.valueOf(br.class, str);
    }

    public static br[] values() {
        return (br[]) Y.clone();
    }

    @Override // defpackage.nw2
    public final boolean g() {
        return true;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return a();
    }

    @Override // defpackage.to2
    public final String getName() {
        return this.b;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.b;
    }
}
