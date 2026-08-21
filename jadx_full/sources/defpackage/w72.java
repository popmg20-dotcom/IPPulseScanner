package defpackage;

import java.io.Closeable;
import java.io.RandomAccessFile;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class w72 implements Closeable {
    public final RandomAccessFile A;
    public boolean b;
    public int f;
    public final ReentrantLock z = new ReentrantLock();

    public w72(RandomAccessFile randomAccessFile) {
        this.A = randomAccessFile;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.z;
        reentrantLock.lock();
        try {
            if (this.b) {
                return;
            }
            this.b = true;
            if (this.f != 0) {
                return;
            }
            synchronized (this) {
                this.A.close();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final qd1 g(long j) {
        ReentrantLock reentrantLock = this.z;
        reentrantLock.lock();
        try {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            this.f++;
            reentrantLock.unlock();
            return new qd1(this, j);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long size() {
        long length;
        ReentrantLock reentrantLock = this.z;
        reentrantLock.lock();
        try {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            synchronized (this) {
                length = this.A.length();
            }
            return length;
        } finally {
            reentrantLock.unlock();
        }
    }
}
