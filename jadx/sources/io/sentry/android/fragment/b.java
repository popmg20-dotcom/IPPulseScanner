package io.sentry.android.fragment;

import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 io.sentry.android.fragment.b, still in use, count: 1, list:
  (r0v0 io.sentry.android.fragment.b) from 0x0099: INVOKE (r11v5 java.util.HashSet), (r0v0 io.sentry.android.fragment.b) VIRTUAL call: java.util.HashSet.add(java.lang.Object):boolean A[MD:(E):boolean (c)] (LINE:154)
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    ATTACHED("attached"),
    SAVE_INSTANCE_STATE("save instance state"),
    CREATED("created"),
    VIEW_CREATED("view created"),
    STARTED("started"),
    RESUMED("resumed"),
    PAUSED("paused"),
    STOPPED("stopped"),
    VIEW_DESTROYED("view destroyed"),
    DESTROYED("destroyed"),
    DETACHED("detached");

    private static final Set<b> states;
    private final String breadcrumbName;
    public static final a Companion = new a();

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(new b("attached"));
        hashSet.add(new b("save instance state"));
        hashSet.add(new b("created"));
        hashSet.add(new b("view created"));
        hashSet.add(new b("started"));
        hashSet.add(new b("resumed"));
        hashSet.add(new b("paused"));
        hashSet.add(new b("stopped"));
        hashSet.add(new b("view destroyed"));
        hashSet.add(new b("destroyed"));
        hashSet.add(new b("detached"));
        states = hashSet;
    }

    private b(String str) {
        this.breadcrumbName = str;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) $VALUES.clone();
    }

    public final String getBreadcrumbName$sentry_android_fragment_release() {
        return this.breadcrumbName;
    }
}
