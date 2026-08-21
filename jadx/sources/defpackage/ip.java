package defpackage;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ip {
    public final ByteBuffer a;

    public ip(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            FileChannel channel = randomAccessFile.getChannel();
            try {
                this.a = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).asReadOnlyBuffer();
                if (channel != null) {
                    channel.close();
                }
                randomAccessFile.close();
            } finally {
            }
        } finally {
        }
    }
}
