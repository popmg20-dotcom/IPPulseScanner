package io.sentry.android.replay;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p {
    public volatile q a;

    public final boolean a(q qVar) {
        qVar.getClass();
        switch (o.a[this.a.ordinal()]) {
            case 1:
                return qVar == q.STARTED || qVar == q.CLOSED;
            case 2:
                return qVar == q.PAUSED || qVar == q.STOPPED || qVar == q.CLOSED;
            case 3:
                return qVar == q.PAUSED || qVar == q.STOPPED || qVar == q.CLOSED;
            case 4:
                return qVar == q.RESUMED || qVar == q.STOPPED || qVar == q.CLOSED;
            case 5:
                return qVar == q.STARTED || qVar == q.CLOSED;
            default:
                defpackage.g.d();
            case 6:
                return false;
        }
    }
}
