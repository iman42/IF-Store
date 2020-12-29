FROM node:14-alpine

RUN addgroup -g 1001 -S nodejs
RUN adduser -S nextjs -u 1001

RUN mkdir -p /app
WORKDIR /app

COPY package.json /app
COPY package-lock.json /app
RUN npm ci

ENV NODE_ENV production

COPY . /app
RUN npm run build

USER nextjs

CMD ["npm", "start"]