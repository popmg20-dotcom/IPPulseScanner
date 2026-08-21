package io.netty.handler.codec.http.multipart;

import defpackage.fw;
import defpackage.g;
import defpackage.st4;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractMemoryHttpData extends AbstractHttpData {
    private ByteBuf byteBuf;
    private int chunkPosition;

    public AbstractMemoryHttpData(String str, Charset charset, long j) {
        super(str, charset, j);
        this.byteBuf = Unpooled.EMPTY_BUFFER;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z) throws IOException {
        if (byteBuf != null) {
            long j = byteBuf.readableBytes();
            try {
                checkSize(this.size + j);
                long j2 = this.definedSize;
                if (j2 > 0 && j2 < this.size + j) {
                    byteBuf.release();
                    g.e(this.size + j, this.definedSize);
                    return;
                }
                this.size += j;
                ByteBuf byteBuf2 = this.byteBuf;
                if (byteBuf2 == null) {
                    this.byteBuf = byteBuf;
                } else if (j == 0) {
                    byteBuf.release();
                } else {
                    int i = byteBuf2.readableBytes();
                    ByteBuf byteBuf3 = this.byteBuf;
                    if (i == 0) {
                        byteBuf3.release();
                        this.byteBuf = byteBuf;
                    } else if (byteBuf3 instanceof CompositeByteBuf) {
                        ((CompositeByteBuf) byteBuf3).addComponent(true, byteBuf);
                    } else {
                        CompositeByteBuf compositeByteBufCompositeBuffer = Unpooled.compositeBuffer(ChannelUtils.WRITE_STATUS_SNDBUF_FULL);
                        compositeByteBufCompositeBuffer.addComponents(true, this.byteBuf, byteBuf);
                        this.byteBuf = compositeByteBufCompositeBuffer;
                    }
                }
            } catch (IOException e) {
                byteBuf.release();
                throw e;
            }
        }
        if (z) {
            setCompleted();
        } else {
            ObjectUtil.checkNotNull(byteBuf, "buffer");
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void delete() {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf != null) {
            byteBuf.release();
            this.byteBuf = null;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public byte[] get() {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null) {
            return Unpooled.EMPTY_BUFFER.array();
        }
        byte[] bArr = new byte[byteBuf.readableBytes()];
        ByteBuf byteBuf2 = this.byteBuf;
        byteBuf2.getBytes(byteBuf2.readerIndex(), bArr);
        return bArr;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getByteBuf() {
        return this.byteBuf;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getChunk(int i) {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null || i == 0 || byteBuf.readableBytes() == 0) {
            this.chunkPosition = 0;
            return Unpooled.EMPTY_BUFFER;
        }
        int i2 = this.byteBuf.readableBytes();
        int i3 = this.chunkPosition;
        int i4 = i2 - i3;
        if (i4 == 0) {
            this.chunkPosition = 0;
            return Unpooled.EMPTY_BUFFER;
        }
        if (i4 < i) {
            i = i4;
        }
        ByteBuf byteBufRetainedSlice = this.byteBuf.retainedSlice(i3, i);
        this.chunkPosition += i;
        return byteBufRetainedSlice;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public File getFile() throws IOException {
        throw new IOException("Not represented by a file");
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString(Charset charset) {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null) {
            return "";
        }
        if (charset == null) {
            charset = HttpConstants.DEFAULT_CHARSET;
        }
        return byteBuf.toString(charset);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isInMemory() {
        return true;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean renameTo(File file) throws IOException {
        ObjectUtil.checkNotNull(file, "dest");
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null) {
            if (file.createNewFile()) {
                return true;
            }
            st4.i(file, "file exists already: ");
            return false;
        }
        int i = byteBuf.readableBytes();
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            FileChannel channel = randomAccessFile.getChannel();
            try {
                int iNioBufferCount = this.byteBuf.nioBufferCount();
                ByteBuf byteBuf2 = this.byteBuf;
                long jWrite = 0;
                if (iNioBufferCount == 1) {
                    ByteBuffer byteBufferNioBuffer = byteBuf2.nioBuffer();
                    while (jWrite < i) {
                        jWrite += (long) channel.write(byteBufferNioBuffer);
                    }
                } else {
                    ByteBuffer[] byteBufferArrNioBuffers = byteBuf2.nioBuffers();
                    while (jWrite < i) {
                        jWrite += channel.write(byteBufferArrNioBuffers);
                    }
                }
                channel.force(false);
                channel.close();
                randomAccessFile.close();
                return jWrite == ((long) i);
            } catch (Throwable th) {
                channel.close();
                throw th;
            }
        } catch (Throwable th2) {
            randomAccessFile.close();
            throw th2;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(File file) throws IOException {
        ObjectUtil.checkNotNull(file, "file");
        long length = file.length();
        if (length > 2147483647L) {
            xe.k("File too big to be loaded in memory");
            return;
        }
        checkSize(length);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            FileChannel channel = randomAccessFile.getChannel();
            try {
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[(int) length]);
                for (int i = 0; i < length; i += channel.read(byteBufferWrap)) {
                }
                randomAccessFile.close();
                byteBufferWrap.flip();
                ByteBuf byteBuf = this.byteBuf;
                if (byteBuf != null) {
                    byteBuf.release();
                }
                this.byteBuf = Unpooled.wrappedBuffer(ChannelUtils.WRITE_STATUS_SNDBUF_FULL, byteBufferWrap);
                this.size = length;
                setCompleted();
            } finally {
                channel.close();
            }
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public HttpData touch(Object obj) {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf != null) {
            byteBuf.touch(obj);
        }
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData touch() {
        return touch((Object) null);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString() {
        return getString(HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(InputStream inputStream) throws IOException {
        ObjectUtil.checkNotNull(inputStream, "inputStream");
        byte[] bArr = new byte[16384];
        ByteBuf byteBufBuffer = Unpooled.buffer();
        try {
            int i = inputStream.read(bArr);
            int i2 = 0;
            while (i > 0) {
                byteBufBuffer.writeBytes(bArr, 0, i);
                i2 += i;
                checkSize(i2);
                i = inputStream.read(bArr);
            }
            long j = i2;
            this.size = j;
            long j2 = this.definedSize;
            if (j2 > 0 && j2 < j) {
                byteBufBuffer.release();
                g.e(this.size, this.definedSize);
                return;
            }
            ByteBuf byteBuf = this.byteBuf;
            if (byteBuf != null) {
                byteBuf.release();
            }
            this.byteBuf = byteBufBuffer;
            setCompleted();
        } catch (IOException e) {
            byteBufBuffer.release();
            throw e;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(ByteBuf byteBuf) throws IOException {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        long j = byteBuf.readableBytes();
        try {
            checkSize(j);
            long j2 = this.definedSize;
            if (j2 > 0 && j2 < j) {
                byteBuf.release();
                StringBuilder sbC = fw.C("Out of size: ", " > ", j);
                sbC.append(this.definedSize);
                throw new IOException(sbC.toString());
            }
            ByteBuf byteBuf2 = this.byteBuf;
            if (byteBuf2 != null) {
                byteBuf2.release();
            }
            this.byteBuf = byteBuf;
            this.size = j;
            setCompleted();
        } catch (IOException e) {
            byteBuf.release();
            throw e;
        }
    }
}
