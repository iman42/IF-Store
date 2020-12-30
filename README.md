# IF Store

This repo contains a bunch of services which, together, run the IF Store comic book website.

## To run:

**Prequisites:** 
- [Docker Compose](https://docs.docker.com/compose/install/), usually included in "Docker Desktop" for Windows and Mac, otherwise needs to be installed separately.

From root directory of the repo, run: 

```bash
./run prod
```
or 
```bash
./run dev
```

This will run either development-mode, or prod-mode, in a docker container. The frontend service is accessible from a browser at http://localhost:3000.

## To configure editor:

This is treated as a monorepo. A default configuration and some recommended extensions have been specified for the [VSCode](https://code.visualstudio.com/) code editor. To see the recommended extensions, open the root folder in VSCode, press `⌘+Shift+P` (or `Ctrl+Shift+P` on Windows), and execute the `Extensions: Show Recommended Extensions` command.