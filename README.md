# To-Do-List-Webapp

The web application, To Do List is written using [Nuxtjs](https://nuxtjs.org/) and [Java Spring](https://spring.io/).

This project has been built as a playground or template for future projects as well as getting one familiar with Spring, Docker, and CI/CD process. View live demo [here](https://to-do-list-java-webapp.herokuapp.com/).

Tutorials: https://milanwittpohl.com/projects/tutorials/full-stack-web-app

Original Repo: https://gitlab.com/milan.wittpohl/full-stack-web-app-demo

## Login Information
```
Username: username
Password: password
```

## Simple Setup
### Installation
```
# install the dependencies for frontend
cd frontend
npm i

# install the dependencies for backend
cd backend
npm i
```

### Development
Local development
```
cd frontend
npm run dev

cd backend
gradlew
gradlew :bootRun
```

Dockerizing Frontend and Backend
```
docker build --file=frontend/frontend/Dockerfile  -t playground-web-frontend .

gradle build
docker build --file=backend/backend/dockerfile  -t playground-web-backend .

docker-compose -f docker-compose.yml up
```
