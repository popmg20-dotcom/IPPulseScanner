package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import io.netty.channel.internal.ChannelUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k31 {
    public static final Object j = new Object();
    public static volatile k31 k;
    public final ReentrantReadWriteLock a;
    public final me b;
    public volatile int c;
    public final Handler d;
    public final g31 e;
    public final j31 f;
    public final d7 g;
    public final int h;
    public final ll0 i;

    public k31(ci1 ci1Var) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.a = reentrantReadWriteLock;
        this.c = 3;
        j31 j31Var = (j31) ci1Var.b;
        this.f = j31Var;
        int i = ci1Var.a;
        this.h = i;
        this.i = (ll0) ci1Var.c;
        this.d = new Handler(Looper.getMainLooper());
        this.b = new me(0);
        this.g = new d7(16);
        g31 g31Var = new g31(this);
        this.e = g31Var;
        reentrantReadWriteLock.writeLock().lock();
        if (i == 0) {
            try {
                this.c = 0;
            } catch (Throwable th) {
                this.a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                j31Var.a(new f31(g31Var));
            } catch (Throwable th2) {
                d(th2);
            }
        }
    }

    public static k31 a() {
        k31 k31Var;
        synchronized (j) {
            k31Var = k;
            r25.j("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.", k31Var != null);
        }
        return k31Var;
    }

    public final int b() {
        this.a.readLock().lock();
        try {
            return this.c;
        } finally {
            this.a.readLock().unlock();
        }
    }

    public final void c() {
        r25.j("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading", this.h == 1);
        if (b() == 1) {
            return;
        }
        this.a.writeLock().lock();
        try {
            if (this.c == 0) {
                return;
            }
            this.c = 0;
            this.a.writeLock().unlock();
            g31 g31Var = this.e;
            k31 k31Var = g31Var.a;
            try {
                k31Var.f.a(new f31(g31Var));
            } catch (Throwable th) {
                k31Var.d(th);
            }
        } finally {
            this.a.writeLock().unlock();
        }
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 2;
            arrayList.addAll(this.b);
            this.b.clear();
            this.a.writeLock().unlock();
            this.d.post(new zv(arrayList, this.c, th));
        } catch (Throwable th2) {
            this.a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a0 A[Catch: all -> 0x0093, TRY_ENTER, TryCatch #0 {all -> 0x0093, blocks: (B:30:0x006b, B:33:0x0070, B:35:0x0074, B:37:0x0081, B:44:0x00a0, B:46:0x00aa, B:48:0x00ad, B:50:0x00b0, B:52:0x00c0, B:53:0x00c3), top: B:81:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b0 A[Catch: all -> 0x0093, TryCatch #0 {all -> 0x0093, blocks: (B:30:0x006b, B:33:0x0070, B:35:0x0074, B:37:0x0081, B:44:0x00a0, B:46:0x00aa, B:48:0x00ad, B:50:0x00b0, B:52:0x00c0, B:53:0x00c3), top: B:81:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d2 A[Catch: all -> 0x0109, TRY_ENTER, TryCatch #1 {all -> 0x0109, blocks: (B:57:0x00d2, B:60:0x00da, B:42:0x0096), top: B:83:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CharSequence e(int i, int i2, CharSequence charSequence) throws Throwable {
        Throwable th;
        CharSequence charSequence2;
        int i3;
        int i4;
        lk4[] lk4VarArr;
        r25.j("Not initialized yet", b() == 1);
        r25.h(i, "start cannot be negative");
        r25.h(i2, "end cannot be negative");
        r25.h(ChannelUtils.WRITE_STATUS_SNDBUF_FULL, "maxEmojiCount cannot be negative");
        r25.f(i <= i2, "start should be <= than end");
        jm4 jm4Var = null;
        if (charSequence == null) {
            return null;
        }
        r25.f(i <= charSequence.length(), "start should be < than charSequence length");
        r25.f(i2 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i == i2) {
            return charSequence;
        }
        ed4 ed4Var = this.e.b;
        ed4Var.getClass();
        boolean z = charSequence instanceof rz3;
        if (z) {
            ((rz3) charSequence).a();
        }
        if (z) {
            jm4Var = new jm4((Spannable) charSequence);
            if (jm4Var != null) {
            }
            i3 = i;
            i4 = i2;
            if (i3 == i4) {
            }
            ((rz3) charSequence2).b();
            return charSequence2;
        }
        try {
            if (!(charSequence instanceof Spannable)) {
                if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i - 1, i2 + 1, lk4.class) <= i2) {
                    jm4Var = new jm4();
                    jm4Var.b = false;
                    jm4Var.f = new SpannableString(charSequence);
                }
                if (jm4Var != null) {
                    while (i < r4) {
                    }
                }
                i3 = i;
                i4 = i2;
                if (i3 == i4) {
                    charSequence2 = charSequence;
                    if (!z) {
                    }
                }
                ((rz3) charSequence2).b();
                return charSequence2;
            }
            try {
                jm4Var = new jm4((Spannable) charSequence);
                if (jm4Var != null && (lk4VarArr = (lk4[]) jm4Var.f.getSpans(i, i2, lk4.class)) != null && lk4VarArr.length > 0) {
                    for (lk4 lk4Var : lk4VarArr) {
                        int spanStart = jm4Var.f.getSpanStart(lk4Var);
                        int spanEnd = jm4Var.f.getSpanEnd(lk4Var);
                        if (spanStart != i2) {
                            jm4Var.removeSpan(lk4Var);
                        }
                        i = Math.min(spanStart, i);
                        i2 = Math.max(spanEnd, i2);
                    }
                }
                i3 = i;
                i4 = i2;
                if (i3 == i4 || i3 >= charSequence.length()) {
                    charSequence2 = charSequence;
                    if (!z) {
                        return charSequence2;
                    }
                } else {
                    charSequence2 = charSequence;
                    try {
                        jm4 jm4Var2 = (jm4) ed4Var.M(charSequence2, i3, i4, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, false, new eg0(11, jm4Var, (d7) ed4Var.f));
                        if (jm4Var2 != null) {
                            Spannable spannable = jm4Var2.f;
                            if (z) {
                                ((rz3) charSequence2).b();
                            }
                            return spannable;
                        }
                        if (!z) {
                            return charSequence2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        if (!z) {
                        }
                    }
                }
                ((rz3) charSequence2).b();
                return charSequence2;
            } catch (Throwable th3) {
                th = th3;
                charSequence2 = charSequence;
                th = th;
                if (!z) {
                }
            }
        } catch (Throwable th4) {
            th = th4;
            charSequence2 = charSequence;
        }
        if (!z) {
            throw th;
        }
        ((rz3) charSequence2).b();
        throw th;
    }

    public final void f(i31 i31Var) {
        this.a.writeLock().lock();
        try {
            if (this.c == 1 || this.c == 2) {
                this.d.post(new zv(Arrays.asList(i31Var), this.c, (Throwable) null));
            } else {
                this.b.add(i31Var);
            }
            this.a.writeLock().unlock();
        } catch (Throwable th) {
            this.a.writeLock().unlock();
            throw th;
        }
    }
}
