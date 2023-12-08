# Generated with JReleaser 1.9.0 at 2023-12-08T17:35:37.172572817Z
FROM azul/zulu-openjdk-alpine:17-jre

LABEL "org.opencontainers.image.title"="ahdark-blog-releaser"
LABEL "org.opencontainers.image.description"="AHdark Blog Release Notification Service"
LABEL "org.opencontainers.image.url"="https://github.com/AH-dark/ahdark-blog-releaser"
LABEL "org.opencontainers.image.licenses"="MIT"
LABEL "org.opencontainers.image.version"="1.0.3"
LABEL "org.opencontainers.image.revision"="32c1797d5e668a6f877c4291afa0c8783583a872"


COPY assembly/ /

RUN mkdir -p /ahdark-blog-releaser-1.0.3/bin && \
    mkdir -p /ahdark-blog-releaser-1.0.3/lib && \
    mv /ahdark-blog-releaser /ahdark-blog-releaser-1.0.3/bin && \
    chmod +x /ahdark-blog-releaser-1.0.3/bin/ahdark-blog-releaser && \
    mv /ahdark-blog-releaser-all.jar /ahdark-blog-releaser-1.0.3/lib

ENV PATH="${PATH}:/ahdark-blog-releaser-1.0.3/bin"


ENTRYPOINT ["/ahdark-blog-releaser-1.0.3/bin/ahdark-blog-releaser"]
CMD ["ahdark-blog-releaser"]
