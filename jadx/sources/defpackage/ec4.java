package defpackage;

import org.eclipse.tm4e.languageconfiguration.internal.model.EnterAction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class ec4 {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[EnterAction.IndentAction.values().length];
        a = iArr;
        try {
            iArr[EnterAction.IndentAction.None.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[EnterAction.IndentAction.Indent.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[EnterAction.IndentAction.IndentOutdent.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[EnterAction.IndentAction.Outdent.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
