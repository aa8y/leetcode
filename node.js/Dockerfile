FROM aa8y/core:node11

WORKDIR $APP_DIR
USER docker

# Download dependencies
COPY --chown=docker:docker package.json .
COPY --chown=docker:docker package-lock.json .
RUN npm install \
 && mkdir src

COPY --chown=docker:docker .eslintrc.yml .
COPY --chown=docker:docker src/ src/

ENTRYPOINT ["npm"]
