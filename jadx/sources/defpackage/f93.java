package defpackage;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.getsurfboard.vpn.Jni;
import com.tencent.mars.xlog.Xlog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f93 extends Thread {
    public final yw1 b;
    public LocalServerSocket f;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f93(yw1 yw1Var) {
        super("protect_thread");
        yw1Var.getClass();
        this.b = yw1Var;
        this.z = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        FileDescriptor fileDescriptor;
        int i;
        String str;
        LocalSocket localSocket = new LocalSocket();
        try {
            try {
                try {
                    File file = new File(this.b.getNoBackupFilesDir(), "protect_path");
                    file.delete();
                    localSocket.bind(new LocalSocketAddress(file.getAbsolutePath(), LocalSocketAddress.Namespace.FILESYSTEM));
                    this.f = new LocalServerSocket(localSocket.getFileDescriptor());
                    while (this.z) {
                        LocalServerSocket localServerSocket = this.f;
                        if (localServerSocket != null) {
                            try {
                                LocalSocket localSocketAccept = localServerSocket.accept();
                                try {
                                    localSocketAccept.getInputStream().read();
                                    FileDescriptor fileDescriptor2 = localSocketAccept.getAncillaryFileDescriptors()[0];
                                    try {
                                        Jni jniE = this.b.e();
                                        fileDescriptor2.getClass();
                                        localSocketAccept.getOutputStream().write(!jniE.m(fileDescriptor2) ? 1 : 0);
                                        Os.close(fileDescriptor2);
                                        localSocketAccept.close();
                                    } catch (Throwable th) {
                                        Os.close(fileDescriptor2);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    try {
                                        throw th2;
                                    } catch (Throwable th3) {
                                        ez4.l(localSocketAccept, th2);
                                        throw th3;
                                    }
                                }
                            } catch (IOException e) {
                                if (this.z) {
                                    e.printStackTrace();
                                    if (fy4.b) {
                                        Xlog.logWrite2(0L, 1, "ProtectThread", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "restart protect thread");
                                        str = "restart protect thread";
                                    } else {
                                        str = "restart protect thread";
                                    }
                                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                        Log.d("ProtectThread", str, null);
                                    }
                                    this.f = new LocalServerSocket(localSocket.getFileDescriptor());
                                }
                            }
                        }
                    }
                    fileDescriptor = localSocket.getFileDescriptor();
                } catch (Exception e2) {
                    if (this.z) {
                        e2.printStackTrace();
                    }
                    fileDescriptor = localSocket.getFileDescriptor();
                    if (fileDescriptor.valid()) {
                        i = OsConstants.SHUT_RDWR;
                    }
                }
                if (fileDescriptor.valid()) {
                    i = OsConstants.SHUT_RDWR;
                    Os.shutdown(fileDescriptor, i);
                }
            } catch (ErrnoException e3) {
                e3.printStackTrace();
            }
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "ProtectThread", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "protect thread ended");
            }
            if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                return;
            }
            Log.d("ProtectThread", "protect thread ended", null);
        } finally {
        }
    }
}
