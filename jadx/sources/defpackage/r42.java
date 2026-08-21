package defpackage;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r42 {
    public static final r42 A;
    public static final /* synthetic */ r42[] X;
    public static final r42 b;
    public static final r42 f;
    public static final r42 z;

    static {
        r42 r42Var = new r42("ANY", 0);
        b = r42Var;
        r42 r42Var2 = new r42("NON_PRIVATE", 1);
        r42 r42Var3 = new r42("PROTECTED_AND_PUBLIC", 2);
        r42 r42Var4 = new r42("PUBLIC_ONLY", 3);
        f = r42Var4;
        r42 r42Var5 = new r42("NONE", 4);
        z = r42Var5;
        r42 r42Var6 = new r42("DEFAULT", 5);
        A = r42Var6;
        X = new r42[]{r42Var, r42Var2, r42Var3, r42Var4, r42Var5, r42Var6};
    }

    public static r42 valueOf(String str) {
        return (r42) Enum.valueOf(r42.class, str);
    }

    public static r42[] values() {
        return (r42[]) X.clone();
    }

    public final boolean a(Member member) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal == 1) {
            return !Modifier.isPrivate(member.getModifiers());
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                return false;
            }
        } else if (Modifier.isProtected(member.getModifiers())) {
            return true;
        }
        return Modifier.isPublic(member.getModifiers());
    }
}
