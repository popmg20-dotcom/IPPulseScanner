package io.netty.handler.codec.http.multipart;

import defpackage.vp1;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class HttpPostStandardRequestDecoder implements InterfaceHttpPostRequestDecoder {
    private final List<InterfaceHttpData> bodyListHttpData;
    private int bodyListHttpDataRank;
    private final Map<String, List<InterfaceHttpData>> bodyMapHttpData;
    private final Charset charset;
    private Attribute currentAttribute;
    private HttpPostRequestDecoder.MultiPartStatus currentStatus;
    private boolean destroyed;
    private int discardThreshold;
    private final HttpDataFactory factory;
    private boolean isLastChunk;
    private final HttpRequest request;
    private ByteBuf undecodedChunk;

    /* JADX INFO: renamed from: io.netty.handler.codec.http.multipart.HttpPostStandardRequestDecoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus;

        static {
            int[] iArr = new int[HttpPostRequestDecoder.MultiPartStatus.values().length];
            $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus = iArr;
            try {
                iArr[HttpPostRequestDecoder.MultiPartStatus.DISPOSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.FIELD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class UrlDecoder implements ByteProcessor {
        private byte hiByte;
        private int nextEscapedIdx;
        private final ByteBuf output;

        public UrlDecoder(ByteBuf byteBuf) {
            this.output = byteBuf;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            int i = this.nextEscapedIdx;
            if (i != 0) {
                if (i == 1) {
                    this.hiByte = b;
                    this.nextEscapedIdx = i + 1;
                } else {
                    int iDecodeHexNibble = StringUtil.decodeHexNibble((char) this.hiByte);
                    int iDecodeHexNibble2 = StringUtil.decodeHexNibble((char) b);
                    if (iDecodeHexNibble == -1 || iDecodeHexNibble2 == -1) {
                        this.nextEscapedIdx++;
                        return false;
                    }
                    this.output.writeByte((iDecodeHexNibble << 4) + iDecodeHexNibble2);
                    this.nextEscapedIdx = 0;
                }
            } else if (b == 37) {
                this.nextEscapedIdx = 1;
            } else {
                ByteBuf byteBuf = this.output;
                if (b == 43) {
                    byteBuf.writeByte(32);
                } else {
                    byteBuf.writeByte(b);
                }
            }
            return true;
        }
    }

    public HttpPostStandardRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, Charset charset) throws Throwable {
        this.bodyListHttpData = new ArrayList();
        this.bodyMapHttpData = new TreeMap(CaseIgnoringComparator.INSTANCE);
        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED;
        this.discardThreshold = 10485760;
        this.request = (HttpRequest) ObjectUtil.checkNotNull(httpRequest, "request");
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
        this.factory = (HttpDataFactory) ObjectUtil.checkNotNull(httpDataFactory, "factory");
        try {
            if (httpRequest instanceof HttpContent) {
                offer((HttpContent) httpRequest);
            } else {
                parseBody();
            }
        } catch (Throwable th) {
            destroy();
            PlatformDependent.throwException(th);
        }
    }

    private void checkDestroyed() {
        if (this.destroyed) {
            xe.q("HttpPostStandardRequestDecoder was destroyed already");
        }
    }

    private static ByteBuf decodeAttribute(ByteBuf byteBuf, Charset charset) {
        if (byteBuf.forEachByte(new UrlEncodedDetector(null)) == -1) {
            return null;
        }
        ByteBuf byteBufBuffer = byteBuf.alloc().buffer(byteBuf.readableBytes());
        UrlDecoder urlDecoder = new UrlDecoder(byteBufBuffer);
        int iForEachByte = byteBuf.forEachByte(urlDecoder);
        if (urlDecoder.nextEscapedIdx == 0) {
            return byteBufBuffer;
        }
        if (iForEachByte == -1) {
            iForEachByte = byteBuf.readableBytes() - 1;
        }
        int i = iForEachByte - (urlDecoder.nextEscapedIdx - 1);
        byteBufBuffer.release();
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(String.format("Invalid hex byte at index '%d' in string: '%s'", Integer.valueOf(i), byteBuf.toString(charset)));
    }

    private void parseBody() {
        HttpPostRequestDecoder.MultiPartStatus multiPartStatus = this.currentStatus;
        if (multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE && multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE) {
            parseBodyAttributes();
        } else if (this.isLastChunk) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
        }
    }

    private void parseBodyAttributes() {
        int i;
        boolean z;
        Attribute attribute;
        Attribute attribute2;
        int i2;
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf == null) {
            return;
        }
        if (!byteBuf.hasArray()) {
            parseBodyAttributesStandard();
            return;
        }
        HttpPostBodyUtil.SeekAheadOptimize seekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(this.undecodedChunk);
        int i3 = this.undecodedChunk.readerIndex();
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
        }
        loop0: while (true) {
            i = i3;
            while (true) {
                try {
                    int i4 = seekAheadOptimize.pos;
                    z = true;
                    if (i4 >= seekAheadOptimize.limit) {
                        break loop0;
                    }
                    byte[] bArr = seekAheadOptimize.bytes;
                    seekAheadOptimize.pos = i4 + 1;
                    char c = (char) (bArr[i4] & 255);
                    i2 = i3 + 1;
                    int i5 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[this.currentStatus.ordinal()];
                    if (i5 != 1) {
                        if (i5 != 2) {
                            seekAheadOptimize.setReadPosition(0);
                            i3 = i2;
                            break loop0;
                        }
                        if (c == '&') {
                            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                            setFinalBuffer(this.undecodedChunk.retainedSlice(i, i3 - i));
                            break;
                        }
                        if (c == '\r') {
                            int i6 = seekAheadOptimize.pos;
                            int i7 = seekAheadOptimize.limit;
                            if (i6 < i7) {
                                byte[] bArr2 = seekAheadOptimize.bytes;
                                seekAheadOptimize.pos = i6 + 1;
                                char c2 = (char) (bArr2[i6] & 255);
                                i2 = i3 + 2;
                                if (c2 != '\n') {
                                    seekAheadOptimize.setReadPosition(0);
                                    throw new HttpPostRequestDecoder.ErrorDataDecoderException("Bad end of line");
                                }
                                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                                seekAheadOptimize.setReadPosition(0);
                                setFinalBuffer(this.undecodedChunk.retainedSlice(i, i3 - i));
                            } else if (i7 <= 0) {
                                i3 = i2;
                            }
                        } else {
                            if (c == '\n') {
                                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                                seekAheadOptimize.setReadPosition(0);
                                setFinalBuffer(this.undecodedChunk.retainedSlice(i, i3 - i));
                                break loop0;
                            }
                            i3 = i2;
                        }
                    } else {
                        if (c == '=') {
                            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.FIELD;
                            this.currentAttribute = this.factory.createAttribute(this.request, decodeAttribute(this.undecodedChunk.toString(i, i3 - i, this.charset), this.charset));
                            break;
                        }
                        if (c == '&') {
                            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                            String strDecodeAttribute = decodeAttribute(this.undecodedChunk.toString(i, i3 - i, this.charset), this.charset);
                            if (!strDecodeAttribute.isEmpty()) {
                                Attribute attributeCreateAttribute = this.factory.createAttribute(this.request, strDecodeAttribute);
                                this.currentAttribute = attributeCreateAttribute;
                                attributeCreateAttribute.setValue("");
                                addHttpData(this.currentAttribute);
                            }
                            this.currentAttribute = null;
                        }
                        i3 = i2;
                    }
                } catch (HttpPostRequestDecoder.ErrorDataDecoderException e) {
                    e = e;
                } catch (IOException e2) {
                    e = e2;
                } catch (IllegalArgumentException e3) {
                    e = e3;
                }
            }
            i3 = i2;
        }
        i3 = i2;
        i = i3;
        z = false;
        if (!this.isLastChunk || (attribute2 = this.currentAttribute) == null) {
            if (z && (attribute = this.currentAttribute) != null && this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FIELD) {
                attribute.addContent(this.undecodedChunk.retainedSlice(i, i3 - i), false);
            }
            this.undecodedChunk.readerIndex(i);
        }
        if (i3 > i) {
            setFinalBuffer(this.undecodedChunk.retainedSlice(i, i3 - i));
        } else if (!attribute2.isCompleted()) {
            setFinalBuffer(Unpooled.EMPTY_BUFFER);
        }
        try {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
        } catch (HttpPostRequestDecoder.ErrorDataDecoderException e4) {
            e = e4;
            i = i3;
            this.undecodedChunk.readerIndex(i);
            throw e;
        } catch (IOException e5) {
            e = e5;
            i = i3;
            this.undecodedChunk.readerIndex(i);
            vp1.l(e);
            return;
        } catch (IllegalArgumentException e6) {
            e = e6;
            i = i3;
            this.undecodedChunk.readerIndex(i);
            vp1.l(e);
            return;
        }
        i = i3;
        this.undecodedChunk.readerIndex(i);
    }

    private void parseBodyAttributesStandard() {
        Attribute attribute;
        Attribute attribute2;
        int i = this.undecodedChunk.readerIndex();
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
        }
        int i2 = i;
        boolean z = true;
        while (this.undecodedChunk.isReadable() && z) {
            try {
                char unsignedByte = (char) this.undecodedChunk.readUnsignedByte();
                int i3 = i + 1;
                int i4 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[this.currentStatus.ordinal()];
                if (i4 != 1) {
                    if (i4 != 2) {
                        z = false;
                    } else if (unsignedByte == '&') {
                        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                        setFinalBuffer(this.undecodedChunk.retainedSlice(i2, i - i2));
                        z = true;
                        i = i3;
                        i2 = i;
                    } else if (unsignedByte == '\r') {
                        if (this.undecodedChunk.isReadable()) {
                            int i5 = i + 2;
                            if (((char) this.undecodedChunk.readUnsignedByte()) != '\n') {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException("Bad end of line");
                            }
                            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                            setFinalBuffer(this.undecodedChunk.retainedSlice(i2, i - i2));
                            i = i5;
                            i2 = i;
                            z = false;
                        } else {
                            continue;
                        }
                    } else if (unsignedByte == '\n') {
                        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                        setFinalBuffer(this.undecodedChunk.retainedSlice(i2, i - i2));
                        z = false;
                        i = i3;
                        i2 = i;
                    }
                    i = i3;
                } else if (unsignedByte == '=') {
                    this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.FIELD;
                    this.currentAttribute = this.factory.createAttribute(this.request, decodeAttribute(this.undecodedChunk.toString(i2, i - i2, this.charset), this.charset));
                    i = i3;
                    i2 = i;
                } else if (unsignedByte == '&') {
                    this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                    String strDecodeAttribute = decodeAttribute(this.undecodedChunk.toString(i2, i - i2, this.charset), this.charset);
                    if (!strDecodeAttribute.isEmpty()) {
                        Attribute attributeCreateAttribute = this.factory.createAttribute(this.request, strDecodeAttribute);
                        this.currentAttribute = attributeCreateAttribute;
                        attributeCreateAttribute.setValue("");
                        addHttpData(this.currentAttribute);
                    }
                    this.currentAttribute = null;
                    z = true;
                    i = i3;
                    i2 = i;
                } else {
                    i = i3;
                }
            } catch (HttpPostRequestDecoder.ErrorDataDecoderException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            } catch (IllegalArgumentException e3) {
                e = e3;
            }
        }
        if (this.isLastChunk && (attribute2 = this.currentAttribute) != null) {
            if (i > i2) {
                setFinalBuffer(this.undecodedChunk.retainedSlice(i2, i - i2));
            } else if (!attribute2.isCompleted()) {
                setFinalBuffer(Unpooled.EMPTY_BUFFER);
            }
            try {
                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
            } catch (HttpPostRequestDecoder.ErrorDataDecoderException e4) {
                i2 = i;
                e = e4;
                this.undecodedChunk.readerIndex(i2);
                throw e;
            } catch (IOException e5) {
                i2 = i;
                e = e5;
                this.undecodedChunk.readerIndex(i2);
                vp1.l(e);
                return;
            } catch (IllegalArgumentException e6) {
                i2 = i;
                e = e6;
                this.undecodedChunk.readerIndex(i2);
                vp1.l(e);
                return;
            }
        } else if (z && (attribute = this.currentAttribute) != null && this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FIELD) {
            attribute.addContent(this.undecodedChunk.retainedSlice(i2, i - i2), false);
        } else {
            i = i2;
        }
        this.undecodedChunk.readerIndex(i);
    }

    private void setFinalBuffer(ByteBuf byteBuf) {
        this.currentAttribute.addContent(byteBuf, true);
        ByteBuf byteBufDecodeAttribute = decodeAttribute(this.currentAttribute.getByteBuf(), this.charset);
        if (byteBufDecodeAttribute != null) {
            this.currentAttribute.setContent(byteBufDecodeAttribute);
        }
        addHttpData(this.currentAttribute);
        this.currentAttribute = null;
    }

    public void addHttpData(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData == null) {
            return;
        }
        List<InterfaceHttpData> arrayList = this.bodyMapHttpData.get(interfaceHttpData.getName());
        if (arrayList == null) {
            arrayList = new ArrayList<>(1);
            this.bodyMapHttpData.put(interfaceHttpData.getName(), arrayList);
        }
        arrayList.add(interfaceHttpData);
        this.bodyListHttpData.add(interfaceHttpData);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void cleanFiles() {
        checkDestroyed();
        this.factory.cleanRequestHttpData(this.request);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData currentPartialHttpData() {
        return this.currentAttribute;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void destroy() {
        cleanFiles();
        for (InterfaceHttpData interfaceHttpData : this.bodyListHttpData) {
            if (interfaceHttpData.refCnt() > 0) {
                interfaceHttpData.release();
            }
        }
        this.destroyed = true;
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf == null || byteBuf.refCnt() <= 0) {
            return;
        }
        this.undecodedChunk.release();
        this.undecodedChunk = null;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData getBodyHttpData(String str) {
        checkDestroyed();
        if (!this.isLastChunk) {
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
        }
        List<InterfaceHttpData> list = this.bodyMapHttpData.get(str);
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas(String str) {
        checkDestroyed();
        if (this.isLastChunk) {
            return this.bodyMapHttpData.get(str);
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public int getDiscardThreshold() {
        return this.discardThreshold;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean hasNext() {
        checkDestroyed();
        if (this.currentStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE || this.bodyListHttpDataRank < this.bodyListHttpData.size()) {
            return !this.bodyListHttpData.isEmpty() && this.bodyListHttpDataRank < this.bodyListHttpData.size();
        }
        throw new HttpPostRequestDecoder.EndOfDataDecoderException();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean isMultipart() {
        checkDestroyed();
        return false;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData next() {
        checkDestroyed();
        if (!hasNext()) {
            return null;
        }
        List<InterfaceHttpData> list = this.bodyListHttpData;
        int i = this.bodyListHttpDataRank;
        this.bodyListHttpDataRank = i + 1;
        return list.get(i);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public HttpPostStandardRequestDecoder offer(HttpContent httpContent) {
        checkDestroyed();
        if (httpContent instanceof LastHttpContent) {
            this.isLastChunk = true;
        }
        ByteBuf byteBufContent = httpContent.content();
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf == null) {
            this.undecodedChunk = byteBufContent.alloc().buffer(byteBufContent.readableBytes()).writeBytes(byteBufContent);
        } else {
            byteBuf.writeBytes(byteBufContent);
        }
        parseBody();
        ByteBuf byteBuf2 = this.undecodedChunk;
        if (byteBuf2 != null && byteBuf2.writerIndex() > this.discardThreshold) {
            int iRefCnt = this.undecodedChunk.refCnt();
            ByteBuf byteBuf3 = this.undecodedChunk;
            if (iRefCnt == 1) {
                byteBuf3.discardReadBytes();
                return this;
            }
            ByteBuf byteBufBuffer = byteBuf3.alloc().buffer(this.undecodedChunk.readableBytes());
            byteBufBuffer.writeBytes(this.undecodedChunk);
            this.undecodedChunk.release();
            this.undecodedChunk = byteBufBuffer;
        }
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void removeHttpDataFromClean(InterfaceHttpData interfaceHttpData) {
        checkDestroyed();
        this.factory.removeHttpDataFromClean(this.request, interfaceHttpData);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void setDiscardThreshold(int i) {
        this.discardThreshold = ObjectUtil.checkPositiveOrZero(i, "discardThreshold");
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class UrlEncodedDetector implements ByteProcessor {
        private UrlEncodedDetector() {
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            return (b == 37 || b == 43) ? false : true;
        }

        public /* synthetic */ UrlEncodedDetector(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas() {
        checkDestroyed();
        if (this.isLastChunk) {
            return this.bodyListHttpData;
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }

    public HttpPostStandardRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest) {
        this(httpDataFactory, httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    public HttpPostStandardRequestDecoder(HttpRequest httpRequest) {
        this(new DefaultHttpDataFactory(DefaultHttpDataFactory.MINSIZE), httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    private static String decodeAttribute(String str, Charset charset) {
        try {
            return QueryStringDecoder.decodeComponent(str, charset);
        } catch (IllegalArgumentException e) {
            throw new HttpPostRequestDecoder.ErrorDataDecoderException("Bad string: '" + str + '\'', e);
        }
    }
}
