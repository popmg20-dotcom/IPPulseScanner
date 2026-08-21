package io.sentry.cache.tape;

import defpackage.vp1;
import defpackage.xe;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Iterator {
    public final /* synthetic */ i A;
    public int b = 0;
    public long f;
    public int z;

    public h(i iVar) {
        this.A = iVar;
        this.f = iVar.X.a;
        this.z = iVar.y0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        i iVar = this.A;
        if (iVar.A0) {
            xe.q("closed");
            return false;
        }
        if (iVar.y0 == this.z) {
            return this.b != iVar.A;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final Object next() throws IOException {
        byte[] bArr = i.B0;
        i iVar = this.A;
        if (iVar.A0) {
            xe.q("closed");
            return null;
        }
        if (iVar.y0 != this.z) {
            throw new ConcurrentModificationException();
        }
        int i = iVar.A;
        if (i == 0) {
            vp1.g();
            return null;
        }
        if (this.b >= i) {
            vp1.g();
            return null;
        }
        try {
            g gVarS = iVar.s(this.f);
            int i2 = gVarS.b;
            long j = gVarS.a;
            byte[] bArr2 = new byte[i2];
            long j2 = j + 4;
            long jZ = iVar.Z(j2);
            this.f = jZ;
            if (!iVar.U(jZ, i2, bArr2)) {
                this.b = iVar.A;
                return bArr;
            }
            this.f = iVar.Z(j2 + ((long) i2));
            this.b++;
            return bArr2;
        } catch (IOException e) {
            throw e;
        } catch (OutOfMemoryError unused) {
            iVar.M();
            this.b = iVar.A;
            return bArr;
        }
    }

    @Override // java.util.Iterator
    public final void remove() throws IOException {
        i iVar = this.A;
        if (iVar.y0 != this.z) {
            throw new ConcurrentModificationException();
        }
        if (iVar.A == 0) {
            vp1.g();
        } else {
            if (this.b != 1) {
                vp1.n("Removal is only permitted from the head.");
                return;
            }
            iVar.I(1);
            this.z = iVar.y0;
            this.b--;
        }
    }
}
