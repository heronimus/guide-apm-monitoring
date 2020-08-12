FROM node:12-alpine

# Create app directory
WORKDIR /usr/src/app

# Install app dependencies
# A wildcard is used to ensure both package.json AND package-lock.json are copied
# where available (npm@5+)
COPY home-ui/package*.json ./

RUN npm install
# If you are building your code for production
RUN npm ci --only=production

ENV NODE_ENV production

# Bundle app source
COPY home-ui .

EXPOSE 8080
CMD [ "node", "./bin/www" ]