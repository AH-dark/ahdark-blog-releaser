# Generated with JReleaser 1.9.0 at 2023-12-07T17:27:52.061614703Z
FROM azul/zulu-openjdk-alpine:17-jre

LABEL "org.opencontainers.image.title"="ahdark-blog-releaser"
LABEL "org.opencontainers.image.description"="AHdark Blog Release Notification Service"
LABEL "org.opencontainers.image.url"="https://github.com/aH-dark/ahdark-blog-releaser"
LABEL "org.opencontainers.image.licenses"="MIT"
LABEL "org.opencontainers.image.version"="1.0.0"
LABEL "org.opencontainers.image.revision"="c6de4de35fc0de7c697f9a6443ac0483d95eb2b0"


COPY assembly/ /

RUN unzip ahdark-blog-releaser-1.0.0.zip && \
    rm ahdark-blog-releaser-1.0.0.zip && \
    chmod +x ahdark-blog-releaser-1.0.0/bin/ahdark-blog-releaser


ENV PATH="${PATH}:/ahdark-blog-releaser-1.0.0/bin"

ENTRYPOINT ["/ahdark-blog-releaser-1.0.0/bin/ahdark-blog-releaser"]
