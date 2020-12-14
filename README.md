# IF Store

This repo contains a bunch of services which, together, run the IF Store comic book website.

### To run in production mode:
Prequisites: 
- Docker Compose - [https://docs.docker.com/compose/install/](https://docs.docker.com/compose/install/)
    - _"On desktop systems like Docker Desktop for Mac and Windows, Docker Compose is included as part of those desktop installs."_

From root directory, run: 
- `docker-compose up --build`  

This will run all the services in production-mode, and connect them to each other. To hit the frontend from the browser, visit [http://localhost:3000/](http://localhost:3000/).

### To run in development mode:
See the `README.md` in the service you're trying to run.