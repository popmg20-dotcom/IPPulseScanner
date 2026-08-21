package io.netty.handler.codec.http.multipart;

import defpackage.g;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDiskHttpData extends AbstractHttpData {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractDiskHttpData.class);
    private File file;
    private FileChannel fileChannel;
    private boolean isRenamed;

    public AbstractDiskHttpData(String str, Charset charset, long j) {
        super(str, charset, j);
    }

    private static byte[] readFrom(File file) throws IOException {
        long length = file.length();
        if (length > 2147483647L) {
            xe.k("File too big to be loaded in memory");
            return null;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[(int) length];
        try {
            FileChannel channel = randomAccessFile.getChannel();
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            for (int i = 0; i < length; i += channel.read(byteBufferWrap)) {
            }
            return bArr;
        } finally {
            randomAccessFile.close();
        }
    }

    private File tempFile() {
        String postfix;
        String diskFilename = getDiskFilename();
        if (diskFilename != null) {
            postfix = "_" + Integer.toString(diskFilename.hashCode());
        } else {
            postfix = getPostfix();
        }
        File fileCreateTempFile = getBaseDirectory() == null ? PlatformDependent.createTempFile(getPrefix(), postfix, null) : PlatformDependent.createTempFile(getPrefix(), postfix, new File(getBaseDirectory()));
        if (deleteOnExit()) {
            DeleteFileOnExitHook.add(fileCreateTempFile.getPath());
        }
        return fileCreateTempFile;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z) throws Throwable {
        ByteBuf byteBuf2;
        Throwable th;
        if (byteBuf != null) {
            try {
                int i = byteBuf.readableBytes();
                long j = i;
                checkSize(this.size + j);
                long j2 = this.definedSize;
                if (j2 > 0) {
                    try {
                        if (j2 < this.size + j) {
                            throw new IOException("Out of size: " + (this.size + j) + " > " + this.definedSize);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteBuf2 = byteBuf;
                        byteBuf2.release();
                        throw th;
                    }
                }
                if (this.file == null) {
                    this.file = tempFile();
                }
                FileChannel channel = this.fileChannel;
                if (channel == null) {
                    channel = new RandomAccessFile(this.file, "rw").getChannel();
                    this.fileChannel = channel;
                }
                long jPosition = channel.position();
                int i2 = byteBuf.readerIndex();
                int i3 = i;
                long j3 = jPosition;
                while (true) {
                    if (i3 <= 0) {
                        byteBuf2 = byteBuf;
                        break;
                    }
                    byteBuf2 = byteBuf;
                    try {
                        int bytes = byteBuf2.getBytes(i2, this.fileChannel, j3, i3);
                        if (bytes < 0) {
                            break;
                        }
                        i3 -= bytes;
                        j3 += (long) bytes;
                        i2 += bytes;
                        byteBuf = byteBuf2;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        byteBuf2.release();
                        throw th;
                    }
                }
                this.fileChannel.position(j3);
                byteBuf2.readerIndex(i2);
                this.size += (long) (i - i3);
                byteBuf2.release();
            } catch (Throwable th4) {
                th = th4;
                byteBuf2 = byteBuf;
            }
        } else {
            byteBuf2 = byteBuf;
        }
        if (!z) {
            ObjectUtil.checkNotNull(byteBuf2, "buffer");
            return;
        }
        if (this.file == null) {
            this.file = tempFile();
        }
        FileChannel channel2 = this.fileChannel;
        if (channel2 == null) {
            channel2 = new RandomAccessFile(this.file, "rw").getChannel();
            this.fileChannel = channel2;
        }
        try {
            channel2.force(false);
            this.fileChannel.close();
            this.fileChannel = null;
            setCompleted();
        } catch (Throwable th5) {
            this.fileChannel.close();
            throw th5;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void delete() {
        String path;
        FileChannel fileChannel;
        FileChannel fileChannel2 = this.fileChannel;
        if (fileChannel2 != null) {
            try {
                try {
                    try {
                        fileChannel2.force(false);
                        fileChannel = this.fileChannel;
                    } catch (IOException e) {
                        logger.warn("Failed to force.", (Throwable) e);
                        fileChannel = this.fileChannel;
                    }
                    fileChannel.close();
                } catch (IOException e2) {
                    logger.warn("Failed to close a file.", (Throwable) e2);
                }
                this.fileChannel = null;
            } catch (Throwable th) {
                try {
                    this.fileChannel.close();
                } catch (IOException e3) {
                    logger.warn("Failed to close a file.", (Throwable) e3);
                }
                throw th;
            }
        }
        if (this.isRenamed) {
            return;
        }
        File file = this.file;
        if (file == null || !file.exists()) {
            path = null;
        } else {
            path = this.file.getPath();
            if (!this.file.delete()) {
                logger.warn("Failed to delete: {}", this.file);
                path = null;
            }
        }
        if (deleteOnExit() && path != null) {
            DeleteFileOnExitHook.remove(path);
        }
        this.file = null;
    }

    public abstract boolean deleteOnExit();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public byte[] get() {
        File file = this.file;
        return file == null ? EmptyArrays.EMPTY_BYTES : readFrom(file);
    }

    public abstract String getBaseDirectory();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getByteBuf() {
        File file = this.file;
        return file == null ? Unpooled.EMPTY_BUFFER : Unpooled.wrappedBuffer(readFrom(file));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        r6.fileChannel.close();
        r6.fileChannel = null;
     */
    @Override // io.netty.handler.codec.http.multipart.HttpData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.netty.buffer.ByteBuf getChunk(int r7) throws java.io.IOException {
        /*
            r6 = this;
            java.io.File r0 = r6.file
            if (r0 == 0) goto L53
            if (r7 != 0) goto L7
            goto L53
        L7:
            java.nio.channels.FileChannel r0 = r6.fileChannel
            if (r0 != 0) goto L1a
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile
            java.io.File r1 = r6.file
            java.lang.String r2 = "r"
            r0.<init>(r1, r2)
            java.nio.channels.FileChannel r0 = r0.getChannel()
            r6.fileChannel = r0
        L1a:
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r7)
            r1 = 0
            r2 = r1
        L20:
            if (r2 >= r7) goto L40
            r3 = 0
            java.nio.channels.FileChannel r4 = r6.fileChannel     // Catch: java.io.IOException -> L34
            int r4 = r4.read(r0)     // Catch: java.io.IOException -> L34
            r5 = -1
            if (r4 != r5) goto L36
            java.nio.channels.FileChannel r7 = r6.fileChannel     // Catch: java.io.IOException -> L34
            r7.close()     // Catch: java.io.IOException -> L34
            r6.fileChannel = r3     // Catch: java.io.IOException -> L34
            goto L40
        L34:
            r7 = move-exception
            goto L38
        L36:
            int r2 = r2 + r4
            goto L20
        L38:
            java.nio.channels.FileChannel r0 = r6.fileChannel
            r0.close()
            r6.fileChannel = r3
            throw r7
        L40:
            if (r2 != 0) goto L45
            io.netty.buffer.ByteBuf r6 = io.netty.buffer.Unpooled.EMPTY_BUFFER
            return r6
        L45:
            r0.flip()
            io.netty.buffer.ByteBuf r6 = io.netty.buffer.Unpooled.wrappedBuffer(r0)
            r6.readerIndex(r1)
            r6.writerIndex(r2)
            return r6
        L53:
            io.netty.buffer.ByteBuf r6 = io.netty.buffer.Unpooled.EMPTY_BUFFER
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.AbstractDiskHttpData.getChunk(int):io.netty.buffer.ByteBuf");
    }

    public abstract String getDiskFilename();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public File getFile() {
        return this.file;
    }

    public abstract String getPostfix();

    public abstract String getPrefix();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString(Charset charset) {
        File file = this.file;
        return file == null ? "" : charset == null ? new String(readFrom(file), HttpConstants.DEFAULT_CHARSET.name()) : new String(readFrom(file), charset.name());
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isInMemory() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // io.netty.handler.codec.http.multipart.HttpData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean renameTo(java.io.File r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.AbstractDiskHttpData.renameTo(java.io.File):boolean");
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(ByteBuf byteBuf) {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        try {
            long j = byteBuf.readableBytes();
            this.size = j;
            checkSize(j);
            long j2 = this.definedSize;
            if (j2 > 0 && j2 < this.size) {
                throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
            }
            if (this.file == null) {
                this.file = tempFile();
            }
            if (byteBuf.readableBytes() == 0) {
                if (!this.file.createNewFile()) {
                    if (this.file.length() == 0) {
                        byteBuf.release();
                        return;
                    } else if (!this.file.delete() || !this.file.createNewFile()) {
                        throw new IOException("file exists already: " + this.file);
                    }
                }
                return;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.file, "rw");
            try {
                randomAccessFile.setLength(0L);
                FileChannel channel = randomAccessFile.getChannel();
                ByteBuffer byteBufferNioBuffer = byteBuf.nioBuffer();
                int iWrite = 0;
                while (iWrite < this.size) {
                    iWrite += channel.write(byteBufferNioBuffer);
                }
                byteBuf.readerIndex(byteBuf.readerIndex() + iWrite);
                channel.force(false);
                randomAccessFile.close();
                setCompleted();
                byteBuf.release();
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        } finally {
            byteBuf.release();
        }
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public HttpData touch(Object obj) {
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData touch() {
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString() {
        return getString(HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(File file) throws IOException {
        long length = file.length();
        checkSize(length);
        this.size = length;
        if (this.file != null) {
            delete();
        }
        this.file = file;
        this.isRenamed = true;
        setCompleted();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(InputStream inputStream) throws IOException {
        ObjectUtil.checkNotNull(inputStream, "inputStream");
        if (this.file != null) {
            delete();
        }
        this.file = tempFile();
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.file, "rw");
        try {
            randomAccessFile.setLength(0L);
            FileChannel channel = randomAccessFile.getChannel();
            byte[] bArr = new byte[16384];
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i = inputStream.read(bArr);
            int iWrite = 0;
            while (i > 0) {
                byteBufferWrap.position(i).flip();
                iWrite += channel.write(byteBufferWrap);
                checkSize(iWrite);
                i = inputStream.read(bArr);
            }
            channel.force(false);
            randomAccessFile.close();
            long j = iWrite;
            this.size = j;
            long j2 = this.definedSize;
            if (j2 > 0 && j2 < j) {
                if (!this.file.delete()) {
                    logger.warn("Failed to delete: {}", this.file);
                }
                this.file = null;
                g.e(this.size, this.definedSize);
                return;
            }
            this.isRenamed = true;
            setCompleted();
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }
}
