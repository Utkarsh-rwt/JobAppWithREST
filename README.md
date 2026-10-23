# Job Portal

A simple job listing application with a React frontend and a Spring Boot REST API. Users can browse and search job posts, create listings, edit them, and delete them.

## Tech stack

- Frontend: React 18, React Router, Material UI, Axios
- Backend: Java 17, Spring Boot, Spring Data JPA, Hibernate
- Database: PostgreSQL

## Requirements

- Java 17 or newer
- Maven
- Node.js and npm
- PostgreSQL

## Run locally

### 1. Configure PostgreSQL

Create a PostgreSQL database named `Demo`, then provide the connection settings as environment variables before starting the backend:

```bash
export DB_URL=jdbc:postgresql://localhost:5432/Demo
export DB_USERNAME=your_postgres_username
export DB_PASSWORD=your_postgres_password
```

`DB_URL` defaults to the local `Demo` database URL if omitted. Set `DB_USERNAME` and `DB_PASSWORD` to your local PostgreSQL credentials. The application uses Hibernate's `ddl-auto=update` setting to create or update the schema.

### 2. Start the backend

From the repository root, run:

```bash
mvn spring-boot:run
```

The API starts at `http://localhost:8080`.

### 3. Start the frontend

In another terminal:

```bash
cd Frontend
npm install
npm start
```

The React app starts at `http://localhost:3000` and uses `http://localhost:8080` as its API base URL by default. To use a different API address, set `REACT_APP_API_URL` before starting the frontend.

## REST API

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/jobPosts` | List all job posts |
| `GET` | `/jobPost/{postID}` | Get one job post |
| `GET` | `/jobPosts/search/{keyword}` | Search job profile and description |
| `POST` | `/jobPost` | Create a job post |
| `PUT` | `/jobPost` | Update a job post |
| `DELETE` | `/jobPost/{postID}` | Delete a job post |
| `GET` | `/load` | Load the sample job posts into the database |

Example request body:

```json
{
  "postID": 41,
  "postProfile": "Java Developer",
  "postDesc": "Build backend services with Spring Boot",
  "reqExperience": 2,
  "postTechStack": ["Java", "Spring Boot", "PostgreSQL"]
}
```

`postID` is the job post's primary key and must be unique. The `/load` endpoint inserts the sample listings defined in the backend and should be used with an empty database or when those IDs are not already present.

## Project layout

```text
Frontend/                         React application
src/main/java/.../JobController   REST endpoints
src/main/java/.../Service         Job service and sample data
src/main/java/.../Repository      Spring Data JPA repository
src/main/java/.../Model           Job post entity
src/main/resources/               Spring configuration
```
