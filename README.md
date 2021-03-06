# IF Store
![CI Status](https://github.com/iman42/if-store/actions/workflows/ci.yml/badge.svg)

This repo contains a bunch of services which, together, run the IF Store comic book website.

## Architecture:

![Architecture Image](architecture/architecture.drawio.png)

## Dependencies: 

- [Docker Compose](https://docs.docker.com/compose/install/), usually included in "Docker Desktop" for Windows and Mac, otherwise needs to be installed separately.
- A running docker engine (start the docker desktop program)

## To test:

From root directory, run: 
```bash
./run test
```

## [In Progress] To run in production mode:

From root directory, run: 
```bash
./build
```

This will build tagged docker images with the production version of all the services. Those should be deployed in a kubernetes cluster somewhere.

## To run in development mode:

From root directory, run: 
```bash
./run dev
```

This will run all the services in development-mode, and connect them to each other. To hit the frontend from the browser, visit [http://localhost:3000/](http://localhost:3000/).

You can also run services individually, outside of docker. See the `README.md` in the service you're trying to run.

## To configure editor:

This is treated as a monorepo. A default configuration and some recommended extensions have been specified for the [VSCode](https://code.visualstudio.com/) code editor. 

To see the recommended extensions: 
1. open the root folder in VSCode
2. press `⌘+Shift+P` (or `Ctrl+Shift+P` on Windows)
3. execute the `Extensions: Show Recommended Extensions` command.

## To add a new service:

Just add a new directory in `./services/`, and make sure all the tests pass :)
