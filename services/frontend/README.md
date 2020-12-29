This is a [Next.js](https://nextjs.org/) project bootstrapped with [`create-next-app`](https://github.com/vercel/next.js/tree/canary/packages/create-next-app).

## Dependencies
- [NVM](https://github.com/nvm-sh/nvm)
    - This will install [NodeJS](https://nodejs.org/) and [NPM](https://www.npmjs.com/)

**To install all dependencies:**
```bash
nvm install
nvm use
npm ci
```

After this, run `npm use` when opening a new terminal.

## To Run

To run in development-mode, execute the [npm script](https://docs.npmjs.com/cli/v6/using-npm/scripts) `dev`. Like this:

```bash
npm run dev
```

The results are served at [http://localhost:3000](http://localhost:3000) and "hot-reloading" is enabled (meaning, with certain limitations, changes made to source code can be seen without needing to quit and re-run).

## To Run Tests

```bash
npm test
```

## To Build and Deploy

```bash
npm run build
npm start
```

See details [here](https://nextjs.org/docs/deployment#nodejs-server).
>`next build` builds the production application in the .next folder. After building, `next start` starts a Node.js server

## Code Organization