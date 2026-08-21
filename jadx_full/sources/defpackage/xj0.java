package defpackage;

import j$.util.DesugarTimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class xj0 extends ue4 implements ee0 {
    public final Boolean A;
    public final DateFormat X;
    public final AtomicReference Y;

    public xj0(Class cls, Boolean bool, DateFormat dateFormat) {
        super(cls);
        this.A = bool;
        this.X = dateFormat;
        this.Y = dateFormat == null ? null : new AtomicReference();
    }

    @Override // defpackage.ee0
    public final b72 a(gt3 gt3Var, nm nmVar) {
        Class cls = this.b;
        e52 e52VarK = l34.k(gt3Var, nmVar, cls);
        bt3 bt3Var = gt3Var.b;
        if (e52VarK != null) {
            String str = e52VarK.A;
            Locale locale = e52VarK.z;
            String str2 = e52VarK.b;
            d52 d52Var = e52VarK.f;
            TimeZone timeZone = null;
            if (d52Var.a()) {
                return r(Boolean.TRUE, null);
            }
            if (str2 != null && str2.length() > 0) {
                if (locale == null) {
                    locale = bt3Var.f.Y;
                }
                DateFormat simpleDateFormat = new SimpleDateFormat(str2, locale);
                if (e52VarK.c()) {
                    TimeZone timeZone2 = e52VarK.Z;
                    if (timeZone2 != null) {
                        timeZone = timeZone2;
                    } else if (str != null) {
                        timeZone = DesugarTimeZone.getTimeZone(str);
                        e52VarK.Z = timeZone;
                    }
                } else {
                    jl jlVar = bt3Var.f;
                    timeZone = jl.y0;
                }
                simpleDateFormat.setTimeZone(timeZone);
                return r(Boolean.FALSE, simpleDateFormat);
            }
            boolean z = locale != null;
            boolean zC = e52VarK.c();
            boolean z2 = d52Var == d52.z0;
            if (z || zC || z2) {
                DateFormat dateFormat = bt3Var.f.X;
                if (dateFormat instanceof e34) {
                    e34 e34Var = (e34) dateFormat;
                    if (locale != null && !locale.equals(e34Var.f)) {
                        e34Var = new e34(e34Var.b, locale, e34Var.z);
                    }
                    if (e52VarK.c()) {
                        TimeZone timeZone3 = e52VarK.Z;
                        if (timeZone3 != null) {
                            timeZone = timeZone3;
                        } else if (str != null) {
                            timeZone = DesugarTimeZone.getTimeZone(str);
                            e52VarK.Z = timeZone;
                        }
                        if (timeZone == null) {
                            timeZone = e34.z0;
                        }
                        TimeZone timeZone4 = e34Var.b;
                        if (timeZone != timeZone4 && !timeZone.equals(timeZone4)) {
                            e34Var = new e34(timeZone, e34Var.f, e34Var.z);
                        }
                    }
                    return r(Boolean.FALSE, e34Var);
                }
                if (!(dateFormat instanceof SimpleDateFormat)) {
                    gt3Var.z(cls, "Configured `DateFormat` (" + dateFormat.getClass().getName() + ") not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`");
                    throw null;
                }
                SimpleDateFormat simpleDateFormat2 = (SimpleDateFormat) dateFormat;
                DateFormat simpleDateFormat3 = z ? new SimpleDateFormat(simpleDateFormat2.toPattern(), locale) : (SimpleDateFormat) simpleDateFormat2.clone();
                TimeZone timeZone5 = e52VarK.Z;
                if (timeZone5 != null) {
                    timeZone = timeZone5;
                } else if (str != null) {
                    timeZone = DesugarTimeZone.getTimeZone(str);
                    e52VarK.Z = timeZone;
                }
                if (timeZone != null && !timeZone.equals(simpleDateFormat3.getTimeZone())) {
                    simpleDateFormat3.setTimeZone(timeZone);
                }
                return r(Boolean.FALSE, simpleDateFormat3);
            }
        }
        return this;
    }

    @Override // defpackage.ue4, defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        return false;
    }

    public final boolean p(gt3 gt3Var) {
        Boolean bool = this.A;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this.X == null) {
            if (gt3Var != null) {
                return gt3Var.b.h(dt3.WRITE_DATES_AS_TIMESTAMPS);
            }
            xe.k("Null SerializerProvider passed for ".concat(this.b.getName()));
        }
        return false;
    }

    public final void q(Date date, i52 i52Var, gt3 gt3Var) {
        DateFormat dateFormat = this.X;
        if (dateFormat == null) {
            gt3Var.getClass();
            if (gt3Var.b.h(dt3.WRITE_DATES_AS_TIMESTAMPS)) {
                i52Var.i0(date.getTime());
                return;
            } else {
                i52Var.G0(gt3Var.d().format(date));
                return;
            }
        }
        AtomicReference atomicReference = this.Y;
        DateFormat dateFormat2 = (DateFormat) atomicReference.getAndSet(null);
        if (dateFormat2 == null) {
            dateFormat2 = (DateFormat) dateFormat.clone();
        }
        i52Var.G0(dateFormat2.format(date));
        while (!atomicReference.compareAndSet(null, dateFormat2) && atomicReference.get() == null) {
        }
    }

    public abstract xj0 r(Boolean bool, DateFormat dateFormat);
}
