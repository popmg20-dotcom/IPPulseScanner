package io.sentry;

import defpackage.ha0;
import defpackage.xe;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a5 implements Callable {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ l1 b;
    public final /* synthetic */ s3 c;
    public final /* synthetic */ File d;
    public final /* synthetic */ Object e;

    public /* synthetic */ a5(l1 l1Var, s3 s3Var, AtomicReference atomicReference, File file) {
        this.b = l1Var;
        this.c = s3Var;
        this.e = atomicReference;
        this.d = file;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws io.sentry.exception.c {
        int i = this.a;
        File file = this.d;
        Object obj = this.e;
        s3 s3Var = this.c;
        l1 l1Var = this.b;
        switch (i) {
            case 0:
                c1 c1Var = (c1) obj;
                if (file != null) {
                    if (!file.exists()) {
                        throw new io.sentry.exception.c(ha0.o("Dropping profile chunk, because the file '", file.getName(), "' doesn't exists"));
                    }
                    if ("java".equals(s3Var.Y)) {
                        if (x2.a == c1Var) {
                            throw new io.sentry.exception.c("No ProfileConverter available, dropping chunk.");
                        }
                        try {
                            file.getAbsolutePath();
                            ((x2) c1Var).getClass();
                            s3Var.E0 = new io.sentry.protocol.profiling.a();
                        } catch (Exception e) {
                            throw new io.sentry.exception.c("Profile conversion failed", e);
                        }
                        break;
                    } else {
                        try {
                            String str = new String(io.sentry.vendor.a.b(io.sentry.util.b.p(52428800L, file.getPath())), "US-ASCII");
                            if (str.isEmpty()) {
                                throw new io.sentry.exception.c("Profiling trace file is empty");
                            }
                            s3Var.D0 = str;
                        } catch (UnsupportedEncodingException e2) {
                            xe.i(e2);
                            return null;
                        }
                    }
                }
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, d5.d), 512);
                            try {
                                l1Var.a(s3Var, bufferedWriter);
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                bufferedWriter.close();
                                byteArrayOutputStream.close();
                            } finally {
                                try {
                                    break;
                                } catch (Throwable th) {
                                }
                            }
                        } catch (Throwable th2) {
                            try {
                                byteArrayOutputStream.close();
                                break;
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    } catch (IOException e3) {
                        throw new io.sentry.exception.c("Failed to serialize profile chunk\n" + e3.getMessage());
                    }
                } finally {
                    if (file != null) {
                    }
                }
            default:
                AtomicReference atomicReference = (AtomicReference) obj;
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream2, d5.d));
                        try {
                            l1Var.a(s3Var, bufferedWriter2);
                            bufferedWriter2.flush();
                            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                            atomicReference.set(Integer.valueOf(byteArray2.length));
                            bufferedWriter2.close();
                            byteArrayOutputStream2.close();
                            try {
                                try {
                                    byte[] bArrP = io.sentry.util.b.p(52428800L, file.getPath());
                                    file.delete();
                                    byte[] bArr = new byte[byteArray2.length + bArrP.length];
                                    System.arraycopy(byteArray2, 0, bArr, 0, byteArray2.length);
                                    System.arraycopy(bArrP, 0, bArr, byteArray2.length, bArrP.length);
                                    return bArr;
                                } catch (IOException e4) {
                                    throw new io.sentry.exception.c("Failed to read perfetto trace file\n" + e4.getMessage());
                                }
                            } finally {
                                file.delete();
                            }
                        } finally {
                            try {
                                break;
                            } catch (Throwable th4) {
                            }
                        }
                    } finally {
                        try {
                            break;
                        } catch (Throwable th5) {
                        }
                    }
                } catch (IOException e5) {
                    throw new io.sentry.exception.c(ha0.n("Failed to serialize perfetto profile chunk\n", e5.getMessage()));
                }
        }
    }

    public /* synthetic */ a5(File file, s3 s3Var, c1 c1Var, l1 l1Var) {
        this.d = file;
        this.c = s3Var;
        this.e = c1Var;
        this.b = l1Var;
    }
}
