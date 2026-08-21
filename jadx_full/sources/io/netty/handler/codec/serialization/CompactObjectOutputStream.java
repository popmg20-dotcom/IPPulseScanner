package io.netty.handler.codec.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
class CompactObjectOutputStream extends ObjectOutputStream {
    static final int TYPE_FAT_DESCRIPTOR = 0;
    static final int TYPE_THIN_DESCRIPTOR = 1;

    public CompactObjectOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.ObjectOutputStream
    public void writeClassDescriptor(ObjectStreamClass objectStreamClass) throws IOException {
        Class<?> clsForClass = objectStreamClass.forClass();
        if (clsForClass.isPrimitive() || clsForClass.isArray() || clsForClass.isInterface() || objectStreamClass.getSerialVersionUID() == 0) {
            write(0);
            super.writeClassDescriptor(objectStreamClass);
        } else {
            write(1);
            writeUTF(objectStreamClass.getName());
        }
    }

    @Override // java.io.ObjectOutputStream
    public void writeStreamHeader() throws IOException {
        writeByte(5);
    }
}
