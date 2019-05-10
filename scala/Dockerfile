FROM aa8y/sbt:1.2

WORKDIR $APP_DIR
USER docker

# Download dependencies
COPY --chown=docker:docker project project
RUN sbt compile

COPY --chown=docker:docker build.sbt .
RUN sbt compile \
 && mkdir src

# Copy source and test files
COPY --chown=docker:docker src/main src/main
COPY --chown=docker:docker src/test src/test

ENTRYPOINT ["sbt"]
