package io.netty.handler.codec.http.multipart;

import defpackage.fw;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultHttpContent;
import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.handler.stream.ChunkedInput;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class HttpPostRequestEncoder implements ChunkedInput<HttpContent> {
    private static final Map.Entry[] percentEncodings = {new AbstractMap.SimpleImmutableEntry(Pattern.compile("\\*"), "%2A"), new AbstractMap.SimpleImmutableEntry(Pattern.compile("\\+"), "%20"), new AbstractMap.SimpleImmutableEntry(Pattern.compile("~"), "%7E")};
    private final List<InterfaceHttpData> bodyListDatas;
    private final Charset charset;
    private ByteBuf currentBuffer;
    private InterfaceHttpData currentData;
    private FileUpload currentFileUpload;
    private boolean duringMixedMode;
    private final EncoderMode encoderMode;
    private final HttpDataFactory factory;
    private long globalBodySize;
    private long globalProgress;
    private boolean headerFinalized;
    private boolean isChunked;
    private boolean isKey;
    private boolean isLastChunk;
    private boolean isLastChunkSent;
    private final boolean isMultipart;
    private ListIterator<InterfaceHttpData> iterator;
    String multipartDataBoundary;
    final List<InterfaceHttpData> multipartHttpDatas;
    String multipartMixedBoundary;
    private final HttpRequest request;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public enum EncoderMode {
        RFC1738,
        RFC3986,
        HTML5
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static class WrappedHttpRequest implements HttpRequest {
        private final HttpRequest request;

        public WrappedHttpRequest(HttpRequest httpRequest) {
            this.request = httpRequest;
        }

        @Override // io.netty.handler.codec.DecoderResultProvider
        public DecoderResult decoderResult() {
            return this.request.decoderResult();
        }

        @Override // io.netty.handler.codec.http.HttpObject
        @Deprecated
        public DecoderResult getDecoderResult() {
            return this.request.getDecoderResult();
        }

        @Override // io.netty.handler.codec.http.HttpRequest
        public HttpMethod getMethod() {
            return this.request.method();
        }

        @Override // io.netty.handler.codec.http.HttpMessage
        public HttpVersion getProtocolVersion() {
            return this.request.protocolVersion();
        }

        @Override // io.netty.handler.codec.http.HttpRequest
        public String getUri() {
            return this.request.uri();
        }

        @Override // io.netty.handler.codec.http.HttpMessage
        public HttpHeaders headers() {
            return this.request.headers();
        }

        @Override // io.netty.handler.codec.http.HttpRequest
        public HttpMethod method() {
            return this.request.method();
        }

        @Override // io.netty.handler.codec.http.HttpMessage
        public HttpVersion protocolVersion() {
            return this.request.protocolVersion();
        }

        @Override // io.netty.handler.codec.DecoderResultProvider
        public void setDecoderResult(DecoderResult decoderResult) {
            this.request.setDecoderResult(decoderResult);
        }

        @Override // io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
        public HttpRequest setMethod(HttpMethod httpMethod) {
            this.request.setMethod(httpMethod);
            return this;
        }

        @Override // io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
        public HttpRequest setProtocolVersion(HttpVersion httpVersion) {
            this.request.setProtocolVersion(httpVersion);
            return this;
        }

        @Override // io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
        public HttpRequest setUri(String str) {
            this.request.setUri(str);
            return this;
        }

        @Override // io.netty.handler.codec.http.HttpRequest
        public String uri() {
            return this.request.uri();
        }
    }

    public HttpPostRequestEncoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, boolean z, Charset charset, EncoderMode encoderMode) throws ErrorDataEncoderException {
        this.isKey = true;
        this.request = (HttpRequest) ObjectUtil.checkNotNull(httpRequest, "request");
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
        this.factory = (HttpDataFactory) ObjectUtil.checkNotNull(httpDataFactory, "factory");
        if (HttpMethod.TRACE.equals(httpRequest.method())) {
            throw new ErrorDataEncoderException("Cannot create a Encoder if request is a TRACE");
        }
        this.bodyListDatas = new ArrayList();
        this.isLastChunk = false;
        this.isLastChunkSent = false;
        this.isMultipart = z;
        this.multipartHttpDatas = new ArrayList();
        this.encoderMode = encoderMode;
        if (z) {
            initDataMultipart();
        }
    }

    private int calculateRemainingSize() {
        ByteBuf byteBuf = this.currentBuffer;
        return byteBuf != null ? HttpPostBodyUtil.chunkSize - byteBuf.readableBytes() : HttpPostBodyUtil.chunkSize;
    }

    private String encodeAttribute(String str, Charset charset) throws ErrorDataEncoderException {
        if (str == null) {
            return "";
        }
        try {
            String strEncode = URLEncoder.encode(str, charset.name());
            if (this.encoderMode == EncoderMode.RFC3986) {
                for (Map.Entry entry : percentEncodings) {
                    strEncode = ((Pattern) entry.getKey()).matcher(strEncode).replaceAll((String) entry.getValue());
                }
            }
            return strEncode;
        } catch (UnsupportedEncodingException e) {
            throw new ErrorDataEncoderException(charset.name(), e);
        }
    }

    private HttpContent encodeNextChunkMultipart(int i) throws ErrorDataEncoderException {
        ByteBuf chunk;
        InterfaceHttpData interfaceHttpData = this.currentData;
        if (interfaceHttpData == null) {
            return null;
        }
        if (interfaceHttpData instanceof InternalAttribute) {
            chunk = ((InternalAttribute) interfaceHttpData).toByteBuf();
            this.currentData = null;
        } else {
            try {
                chunk = ((HttpData) interfaceHttpData).getChunk(i);
                if (chunk.capacity() == 0) {
                    this.currentData = null;
                    return null;
                }
            } catch (IOException e) {
                throw new ErrorDataEncoderException(e);
            }
        }
        ByteBuf byteBuf = this.currentBuffer;
        if (byteBuf == null) {
            this.currentBuffer = chunk;
        } else {
            chunk = Unpooled.wrappedBuffer(byteBuf, chunk);
            this.currentBuffer = chunk;
        }
        if (chunk.readableBytes() >= 8096) {
            return new DefaultHttpContent(fillByteBuf());
        }
        this.currentData = null;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private io.netty.handler.codec.http.HttpContent encodeNextChunkUrlEncoded(int r11) throws io.netty.handler.codec.http.multipart.HttpPostRequestEncoder.ErrorDataEncoderException {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.HttpPostRequestEncoder.encodeNextChunkUrlEncoded(int):io.netty.handler.codec.http.HttpContent");
    }

    private ByteBuf fillByteBuf() {
        int i = this.currentBuffer.readableBytes();
        ByteBuf byteBuf = this.currentBuffer;
        if (i > 8096) {
            return byteBuf.readRetainedSlice(HttpPostBodyUtil.chunkSize);
        }
        this.currentBuffer = null;
        return byteBuf;
    }

    private static String getNewMultipartDelimiter() {
        return Long.toHexString(PlatformDependent.threadLocalRandom().nextLong());
    }

    private void initDataMultipart() {
        this.multipartDataBoundary = getNewMultipartDelimiter();
    }

    private void initMixedMultipart() {
        this.multipartMixedBoundary = getNewMultipartDelimiter();
    }

    private HttpContent lastChunk() {
        this.isLastChunk = true;
        ByteBuf byteBuf = this.currentBuffer;
        if (byteBuf == null) {
            this.isLastChunkSent = true;
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }
        this.currentBuffer = null;
        return new DefaultHttpContent(byteBuf);
    }

    private HttpContent nextChunk() {
        if (this.isLastChunk) {
            this.isLastChunkSent = true;
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }
        int iCalculateRemainingSize = calculateRemainingSize();
        if (iCalculateRemainingSize <= 0) {
            return new DefaultHttpContent(fillByteBuf());
        }
        if (this.currentData != null) {
            HttpContent httpContentEncodeNextChunkMultipart = this.isMultipart ? encodeNextChunkMultipart(iCalculateRemainingSize) : encodeNextChunkUrlEncoded(iCalculateRemainingSize);
            if (httpContentEncodeNextChunkMultipart != null) {
                return httpContentEncodeNextChunkMultipart;
            }
            iCalculateRemainingSize = calculateRemainingSize();
        }
        if (!this.iterator.hasNext()) {
            return lastChunk();
        }
        while (iCalculateRemainingSize > 0 && this.iterator.hasNext()) {
            this.currentData = this.iterator.next();
            HttpContent httpContentEncodeNextChunkMultipart2 = this.isMultipart ? encodeNextChunkMultipart(iCalculateRemainingSize) : encodeNextChunkUrlEncoded(iCalculateRemainingSize);
            if (httpContentEncodeNextChunkMultipart2 != null) {
                return httpContentEncodeNextChunkMultipart2;
            }
            iCalculateRemainingSize = calculateRemainingSize();
        }
        return lastChunk();
    }

    public void addBodyAttribute(String str, String str2) throws ErrorDataEncoderException {
        if (str2 == null) {
            str2 = "";
        }
        addBodyHttpData(this.factory.createAttribute(this.request, (String) ObjectUtil.checkNotNull(str, "name"), str2));
    }

    public void addBodyFileUpload(String str, String str2, File file, String str3, boolean z) throws ErrorDataEncoderException {
        ObjectUtil.checkNotNull(str, "name");
        ObjectUtil.checkNotNull(file, "file");
        if (str2 == null) {
            str2 = "";
        }
        String str4 = str2;
        if (str3 == null) {
            str3 = z ? HttpPostBodyUtil.DEFAULT_TEXT_CONTENT_TYPE : HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE;
        }
        FileUpload fileUploadCreateFileUpload = this.factory.createFileUpload(this.request, str, str4, str3, !z ? HttpPostBodyUtil.TransferEncodingMechanism.BINARY.value() : null, null, file.length());
        try {
            fileUploadCreateFileUpload.setContent(file);
            addBodyHttpData(fileUploadCreateFileUpload);
        } catch (IOException e) {
            throw new ErrorDataEncoderException(e);
        }
    }

    public void addBodyFileUploads(String str, File[] fileArr, String[] strArr, boolean[] zArr) throws ErrorDataEncoderException {
        if (fileArr.length != strArr.length && fileArr.length != zArr.length) {
            xe.k("Different array length");
            return;
        }
        for (int i = 0; i < fileArr.length; i++) {
            addBodyFileUpload(str, fileArr[i], strArr[i], zArr[i]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x044f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void addBodyHttpData(io.netty.handler.codec.http.multipart.InterfaceHttpData r18) throws io.netty.handler.codec.http.multipart.HttpPostRequestEncoder.ErrorDataEncoderException {
        /*
            Method dump skipped, instruction units count: 1183
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.HttpPostRequestEncoder.addBodyHttpData(io.netty.handler.codec.http.multipart.InterfaceHttpData):void");
    }

    public void cleanFiles() {
        this.factory.cleanRequestHttpData(this.request);
    }

    public HttpRequest finalizeRequest() throws ErrorDataEncoderException {
        if (this.headerFinalized) {
            throw new ErrorDataEncoderException("Header already encoded");
        }
        if (this.isMultipart) {
            InternalAttribute internalAttribute = new InternalAttribute(this.charset);
            if (this.duringMixedMode) {
                internalAttribute.addValue(fw.y(new StringBuilder("\r\n--"), this.multipartMixedBoundary, "--"));
            }
            internalAttribute.addValue(fw.y(new StringBuilder("\r\n--"), this.multipartDataBoundary, "--\r\n"));
            this.multipartHttpDatas.add(internalAttribute);
            this.multipartMixedBoundary = null;
            this.currentFileUpload = null;
            this.duringMixedMode = false;
            this.globalBodySize += (long) internalAttribute.size();
        }
        this.headerFinalized = true;
        HttpHeaders httpHeadersHeaders = this.request.headers();
        AsciiString asciiString = HttpHeaderNames.CONTENT_TYPE;
        List<String> all = httpHeadersHeaders.getAll(asciiString);
        List<String> all2 = httpHeadersHeaders.getAll(HttpHeaderNames.TRANSFER_ENCODING);
        if (all != null) {
            httpHeadersHeaders.remove(asciiString);
            for (String str : all) {
                String lowerCase = str.toLowerCase();
                if (!lowerCase.startsWith(HttpHeaderValues.MULTIPART_FORM_DATA.toString()) && !lowerCase.startsWith(HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString())) {
                    httpHeadersHeaders.add(HttpHeaderNames.CONTENT_TYPE, str);
                }
            }
        }
        if (this.isMultipart) {
            httpHeadersHeaders.add(HttpHeaderNames.CONTENT_TYPE, ((Object) HttpHeaderValues.MULTIPART_FORM_DATA) + "; " + ((Object) HttpHeaderValues.BOUNDARY) + '=' + this.multipartDataBoundary);
        } else {
            httpHeadersHeaders.add(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED);
        }
        long j = this.globalBodySize;
        if (!this.isMultipart) {
            j--;
        }
        this.iterator = this.multipartHttpDatas.listIterator();
        httpHeadersHeaders.set(HttpHeaderNames.CONTENT_LENGTH, String.valueOf(j));
        if (j > 8096 || this.isMultipart) {
            this.isChunked = true;
            if (all2 != null) {
                httpHeadersHeaders.remove(HttpHeaderNames.TRANSFER_ENCODING);
                for (String str2 : all2) {
                    if (!HttpHeaderValues.CHUNKED.contentEqualsIgnoreCase(str2)) {
                        httpHeadersHeaders.add(HttpHeaderNames.TRANSFER_ENCODING, str2);
                    }
                }
            }
            HttpUtil.setTransferEncodingChunked(this.request, true);
            return new WrappedHttpRequest(this.request);
        }
        HttpContent httpContentNextChunk = nextChunk();
        HttpRequest httpRequest = this.request;
        if (!(httpRequest instanceof FullHttpRequest)) {
            return new WrappedFullHttpRequest(httpRequest, httpContentNextChunk);
        }
        FullHttpRequest fullHttpRequest = (FullHttpRequest) httpRequest;
        ByteBuf byteBufContent = httpContentNextChunk.content();
        if (fullHttpRequest.content() != byteBufContent) {
            fullHttpRequest.content().clear().writeBytes(byteBufContent);
            byteBufContent.release();
        }
        return fullHttpRequest;
    }

    public List<InterfaceHttpData> getBodyListAttributes() {
        return this.bodyListDatas;
    }

    public boolean isChunked() {
        return this.isChunked;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() {
        return this.isLastChunkSent;
    }

    public boolean isMultipart() {
        return this.isMultipart;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long length() {
        boolean z = this.isMultipart;
        long j = this.globalBodySize;
        return z ? j : j - 1;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long progress() {
        return this.globalProgress;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    public HttpContent readChunk(ByteBufAllocator byteBufAllocator) {
        if (this.isLastChunkSent) {
            return null;
        }
        HttpContent httpContentNextChunk = nextChunk();
        this.globalProgress += (long) httpContentNextChunk.content().readableBytes();
        return httpContentNextChunk;
    }

    public void setBodyHttpDatas(List<InterfaceHttpData> list) throws ErrorDataEncoderException {
        ObjectUtil.checkNotNull(list, "datas");
        this.globalBodySize = 0L;
        this.bodyListDatas.clear();
        this.currentFileUpload = null;
        this.duringMixedMode = false;
        this.multipartHttpDatas.clear();
        Iterator<InterfaceHttpData> it = list.iterator();
        while (it.hasNext()) {
            addBodyHttpData(it.next());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static class ErrorDataEncoderException extends Exception {
        private static final long serialVersionUID = 5020247425493164465L;

        public ErrorDataEncoderException() {
        }

        public ErrorDataEncoderException(String str) {
            super(str);
        }

        public ErrorDataEncoderException(Throwable th) {
            super(th);
        }

        public ErrorDataEncoderException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class WrappedFullHttpRequest extends WrappedHttpRequest implements FullHttpRequest {
        private final HttpContent content;

        private WrappedFullHttpRequest(HttpRequest httpRequest, HttpContent httpContent) {
            super(httpRequest);
            this.content = httpContent;
        }

        @Override // io.netty.buffer.ByteBufHolder
        public ByteBuf content() {
            return this.content.content();
        }

        @Override // io.netty.handler.codec.http.LastHttpContent, io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
        public FullHttpRequest copy() {
            return replace(content().copy());
        }

        @Override // io.netty.handler.codec.http.LastHttpContent, io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
        public FullHttpRequest duplicate() {
            return replace(content().duplicate());
        }

        @Override // io.netty.util.ReferenceCounted
        public int refCnt() {
            return this.content.refCnt();
        }

        @Override // io.netty.util.ReferenceCounted
        public boolean release() {
            return this.content.release();
        }

        @Override // io.netty.handler.codec.http.LastHttpContent, io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
        public FullHttpRequest replace(ByteBuf byteBuf) {
            DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(protocolVersion(), method(), uri(), byteBuf);
            defaultFullHttpRequest.headers().set(headers());
            defaultFullHttpRequest.trailingHeaders().set(trailingHeaders());
            return defaultFullHttpRequest;
        }

        @Override // io.netty.util.ReferenceCounted
        public FullHttpRequest retain(int i) {
            this.content.retain(i);
            return this;
        }

        @Override // io.netty.handler.codec.http.LastHttpContent, io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
        public FullHttpRequest retainedDuplicate() {
            return replace(content().retainedDuplicate());
        }

        @Override // io.netty.util.ReferenceCounted
        public FullHttpRequest touch() {
            this.content.touch();
            return this;
        }

        @Override // io.netty.handler.codec.http.LastHttpContent
        public HttpHeaders trailingHeaders() {
            HttpContent httpContent = this.content;
            return httpContent instanceof LastHttpContent ? ((LastHttpContent) httpContent).trailingHeaders() : EmptyHttpHeaders.INSTANCE;
        }

        @Override // io.netty.handler.codec.http.multipart.HttpPostRequestEncoder.WrappedHttpRequest, io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
        public FullHttpRequest setMethod(HttpMethod httpMethod) {
            super.setMethod(httpMethod);
            return this;
        }

        @Override // io.netty.handler.codec.http.multipart.HttpPostRequestEncoder.WrappedHttpRequest, io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
        public FullHttpRequest setUri(String str) {
            super.setUri(str);
            return this;
        }

        @Override // io.netty.handler.codec.http.multipart.HttpPostRequestEncoder.WrappedHttpRequest, io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
        public FullHttpRequest setProtocolVersion(HttpVersion httpVersion) {
            super.setProtocolVersion(httpVersion);
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public boolean release(int i) {
            return this.content.release(i);
        }

        @Override // io.netty.util.ReferenceCounted
        public FullHttpRequest retain() {
            this.content.retain();
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public FullHttpRequest touch(Object obj) {
            this.content.touch(obj);
            return this;
        }
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    @Deprecated
    public HttpContent readChunk(ChannelHandlerContext channelHandlerContext) {
        return readChunk(channelHandlerContext.alloc());
    }

    public void addBodyFileUpload(String str, File file, String str2, boolean z) throws ErrorDataEncoderException {
        addBodyFileUpload(str, file.getName(), file, str2, z);
    }

    public HttpPostRequestEncoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, boolean z) {
        this(httpDataFactory, httpRequest, z, HttpConstants.DEFAULT_CHARSET, EncoderMode.RFC1738);
    }

    public HttpPostRequestEncoder(HttpRequest httpRequest, boolean z) {
        this(new DefaultHttpDataFactory(DefaultHttpDataFactory.MINSIZE), httpRequest, z, HttpConstants.DEFAULT_CHARSET, EncoderMode.RFC1738);
    }
}
