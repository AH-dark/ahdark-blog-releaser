# Generated with JReleaser 1.9.0 at 2023-12-09T06:06:16.983091089Z
FROM azul/zulu-openjdk-alpine:17-jre

LABEL "org.opencontainers.image.title"="ahdark-blog-releaser"
LABEL "org.opencontainers.image.description"="AHdark Blog Release Notification Service"
LABEL "org.opencontainers.image.url"="https://github.com/AH-dark/ahdark-blog-releaser"
LABEL "org.opencontainers.image.licenses"="MIT"
LABEL "org.opencontainers.image.version"="1.0.5"
LABEL "org.opencontainers.image.revision"="25ccd68679bfe7ae4151b9d616bbd01d4114594d"


COPY assembly/ /

RUN mkdir -p /ahdark-blog-releaser-1.0.5/bin && \
    mkdir -p /ahdark-blog-releaser-1.0.5/lib && \
    mv /ahdark-blog-releaser /ahdark-blog-releaser-1.0.5/bin && \
    chmod +x /ahdark-blog-releaser-1.0.5/bin/ahdark-blog-releaser && \
    mv /ahdark-blog-releaser-all.jar /ahdark-blog-releaser-1.0.5/lib

ENV PATH="${PATH}:/ahdark-blog-releaser-1.0.5/bin"


ENTRYPOINT ["/ahdark-blog-releaser-1.0.5/bin/ahdark-blog-releaser"]
CMD ["ahdark-blog-releaser"]
