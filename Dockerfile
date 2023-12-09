# Generated with JReleaser 1.9.0 at 2023-12-09T06:53:44.917265531Z
FROM azul/zulu-openjdk-alpine:17-jre

LABEL "org.opencontainers.image.title"="ahdark-blog-releaser"
LABEL "org.opencontainers.image.description"="AHdark Blog Release Notification Service"
LABEL "org.opencontainers.image.url"="https://github.com/AH-dark/ahdark-blog-releaser"
LABEL "org.opencontainers.image.licenses"="MIT"
LABEL "org.opencontainers.image.version"="1.0.6"
LABEL "org.opencontainers.image.revision"="8c748df8a0d68b083ab34e6278b28b38d273d0a5"


COPY assembly/ /

RUN mkdir -p /ahdark-blog-releaser-1.0.6/bin && \
    mkdir -p /ahdark-blog-releaser-1.0.6/lib && \
    mv /ahdark-blog-releaser /ahdark-blog-releaser-1.0.6/bin && \
    chmod +x /ahdark-blog-releaser-1.0.6/bin/ahdark-blog-releaser && \
    mv /ahdark-blog-releaser-all.jar /ahdark-blog-releaser-1.0.6/lib

ENV PATH="${PATH}:/ahdark-blog-releaser-1.0.6/bin"


ENTRYPOINT ["/ahdark-blog-releaser-1.0.6/bin/ahdark-blog-releaser"]
CMD ["ahdark-blog-releaser"]
