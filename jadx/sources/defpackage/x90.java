package defpackage;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x90 extends vq4 {
    public final /* synthetic */ int a;
    public final Object b;

    public x90() {
        this.a = 0;
        this.b = new ArrayList(3);
    }

    @Override // defpackage.vq4
    public final void a(int i) {
        int i2 = this.a;
        Object obj = this.b;
        switch (i2) {
            case 0:
                try {
                    Iterator it = ((ArrayList) obj).iterator();
                    while (it.hasNext()) {
                        ((vq4) it.next()).a(i);
                        break;
                    }
                } catch (ConcurrentModificationException e) {
                    e04.l("Adding and removing callbacks during dispatch to callbacks is not supported", e);
                    return;
                }
                break;
            default:
                ((jk1) obj).b(false);
                break;
        }
    }

    @Override // defpackage.vq4
    public void b(int i, float f, int i2) {
        switch (this.a) {
            case 0:
                try {
                    Iterator it = ((ArrayList) this.b).iterator();
                    while (it.hasNext()) {
                        ((vq4) it.next()).b(i, f, i2);
                        break;
                    }
                } catch (ConcurrentModificationException e) {
                    e04.l("Adding and removing callbacks during dispatch to callbacks is not supported", e);
                    return;
                }
                break;
        }
    }

    @Override // defpackage.vq4
    public final void c(int i) {
        int i2 = this.a;
        Object obj = this.b;
        switch (i2) {
            case 0:
                try {
                    Iterator it = ((ArrayList) obj).iterator();
                    while (it.hasNext()) {
                        ((vq4) it.next()).c(i);
                        break;
                    }
                } catch (ConcurrentModificationException e) {
                    e04.l("Adding and removing callbacks during dispatch to callbacks is not supported", e);
                    return;
                }
                break;
            default:
                ((jk1) obj).b(false);
                break;
        }
    }

    public x90(jk1 jk1Var) {
        this.a = 1;
        this.b = jk1Var;
    }
}
