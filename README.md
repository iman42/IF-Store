# IF Store

This repo contains a bunch of services which, together, run the IF Store comic book website.

**Prequisites:** 

- [Docker Compose](https://docs.docker.com/compose/install/), usually included in "Docker Desktop" for Windows and Mac, otherwise needs to be installed separately.

## To run in production mode:

From root directory of the repo, run: 
```bash
./run prod
```

This will run all the services in production-mode, and connect them to each other. To hit the frontend from the browser, visit [http://localhost:3000/](http://localhost:3000/).

## To run in development mode:

From root directory of the repo, run: 
```bash
./run dev
```

This will run all the services in development-mode. See `README.md` file in individual services for details.

## To configure editor:

This is treated as a monorepo. A default configuration and some recommended extensions have been specified for the [VSCode](https://code.visualstudio.com/) code editor. To see the recommended extensions, open the root folder in VSCode, press `⌘+Shift+P` (or `Ctrl+Shift+P` on Windows), and execute the `Extensions: Show Recommended Extensions` command.