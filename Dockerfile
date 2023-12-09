# Generated with JReleaser 1.9.0 at 2023-12-08T17:47:04.548922164Z
FROM azul/zulu-openjdk-alpine:17-jre

LABEL "org.opencontainers.image.title"="ahdark-blog-releaser"
LABEL "org.opencontainers.image.description"="AHdark Blog Release Notification Service"
LABEL "org.opencontainers.image.url"="https://github.com/AH-dark/ahdark-blog-releaser"
LABEL "org.opencontainers.image.licenses"="MIT"
LABEL "org.opencontainers.image.version"="1.0.4"
LABEL "org.opencontainers.image.revision"="d7058576bdd605e08999ba886947e17c2d0a67a5"


COPY assembly/ /

RUN mkdir -p /ahdark-blog-releaser-1.0.4/bin && \
    mkdir -p /ahdark-blog-releaser-1.0.4/lib && \
    mv /ahdark-blog-releaser /ahdark-blog-releaser-1.0.4/bin && \
    chmod +x /ahdark-blog-releaser-1.0.4/bin/ahdark-blog-releaser && \
    mv /ahdark-blog-releaser-all.jar /ahdark-blog-releaser-1.0.4/lib

ENV PATH="${PATH}:/ahdark-blog-releaser-1.0.4/bin"


ENTRYPOINT ["/ahdark-blog-releaser-1.0.4/bin/ahdark-blog-releaser"]
CMD ["ahdark-blog-releaser"]
