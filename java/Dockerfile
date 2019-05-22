FROM aa8y/core:gradle5

WORKDIR $APP_DIR
USER docker

# Download dependencies
COPY --chown=docker:docker build.gradle .
RUN gradle clean \
 && mkdir config src

# Copy Checkstyle configuration
COPY --chown=docker:docker config config

# Copy source and test files
COPY --chown=docker:docker src/main src/main
COPY --chown=docker:docker src/test src/test
RUN gradle --stop compileJava compileTest

ENTRYPOINT ["gradle"]
