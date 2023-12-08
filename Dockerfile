# Generated with JReleaser 1.9.0 at 2023-12-08T17:32:32.198979691Z
FROM azul/zulu-openjdk-alpine:17-jre

LABEL "org.opencontainers.image.title"="ahdark-blog-releaser"
LABEL "org.opencontainers.image.description"="AHdark Blog Release Notification Service"
LABEL "org.opencontainers.image.url"="https://github.com/AH-dark/ahdark-blog-releaser"
LABEL "org.opencontainers.image.licenses"="MIT"
LABEL "org.opencontainers.image.version"="1.0.2"
LABEL "org.opencontainers.image.revision"="7c20f5b06492976da8bb9662bf1ed5c3ae54d86b"


COPY assembly/ /

RUN mkdir -p /ahdark-blog-releaser-1.0.2/bin && \
    mkdir -p /ahdark-blog-releaser-1.0.2/lib && \
    mv /ahdark-blog-releaser /ahdark-blog-releaser-1.0.2/bin && \
    chmod +x /ahdark-blog-releaser-1.0.2/bin/ahdark-blog-releaser && \
    mv /ahdark-blog-releaser-all.jar /ahdark-blog-releaser-1.0.2/lib

ENV PATH="${PATH}:/ahdark-blog-releaser-1.0.2/bin"


ENTRYPOINT ["/ahdark-blog-releaser-1.0.2/bin/ahdark-blog-releaser"]
CMD ["ahdark-blog-releaser"]
