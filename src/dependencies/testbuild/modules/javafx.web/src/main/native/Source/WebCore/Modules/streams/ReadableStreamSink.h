/*
 * Copyright (C) 2017 Apple Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY APPLE INC. AND ITS CONTRIBUTORS ``AS IS''
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL APPLE INC. OR ITS CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */


#pragma once

#if ENABLE(STREAMS_API)

#include "ExceptionOr.h"
#include "ReadableStreamChunk.h"
#include <wtf/Function.h>
#include <wtf/RefCounted.h>

namespace WebCore {

class BufferSource;
class ReadableStream;
struct ReadableStreamChunk;
class SharedBuffer;

class ReadableStreamSink : public RefCounted<ReadableStreamSink> {
public:
    virtual ~ReadableStreamSink() = default;

    virtual void enqueue(const BufferSource&) = 0;
    virtual void close() = 0;
    virtual void error(String&&) = 0;
};

class ReadableStreamToSharedBufferSink final : public ReadableStreamSink {
public:
    using Callback = WTF::Function<void(ExceptionOr<ReadableStreamChunk*>&&)>;
    static Ref<ReadableStreamToSharedBufferSink> create(Callback&& callback) { return adoptRef(*new ReadableStreamToSharedBufferSink(WTFMove(callback))); }
    void pipeFrom(ReadableStream&);
    void clearCallback() { m_callback = { }; }

private:
    explicit ReadableStreamToSharedBufferSink(Callback&&);

    void enqueue(const BufferSource&) final;
    void close() final;
    void error(String&&) final;

    Callback m_callback;
};

} // namespace WebCore

#endif // ENABLE(STREAMS_API)
