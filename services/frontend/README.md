This is a [Next.js](https://nextjs.org/) project bootstrapped with [`create-next-app`](https://github.com/vercel/next.js/tree/canary/packages/create-next-app).

## Dependencies
- [NodeJS](https://nodejs.org/) and [NPM](https://www.npmjs.com/get-npm)
    - On my machine, the versions are `15.3.0` and `7.0.14` respectively, but versions above `14.15.3` & `6.14.10` should also work.
    - [NVM](https://github.com/nvm-sh/nvm) is a tool you can use to juggle different versions of these.

## To Run

To run in development-mode, execute the [npm script](https://docs.npmjs.com/cli/v6/using-npm/scripts) `dev`. Like this:

```bash
npm ci
npm run dev
```

The results are served at [http://localhost:3000](http://localhost:3000) and "hot-reloading" is enabled (meaning, with certain limitations, changes made to source code can be seen without needing to quit and re-run).

## To Run Tests

```bash
npm ci
npm test
```

## To Build and Deploy

```bash
npm ci
npm run build
npm start
```

See details [here](https://nextjs.org/docs/deployment#nodejs-server).
>`next build` builds the production application in the .next folder. After building, `next start` starts a Node.js server

## Code Organization