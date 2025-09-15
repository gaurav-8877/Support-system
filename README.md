HI guys  I am gourav

Backend (Spring Boot)
---------------------

Location: `server/`

Prerequisites:
- Java 17+
- Maven 3.9+

Run backend:
```
cd server
mvn spring-boot:run
```

API endpoints (http://localhost:8080):
- GET `/api/players`, POST `/api/players`, GET `/api/players/{id}`, PUT `/api/players/{id}`, DELETE `/api/players/{id}`
- GET `/api/players/search?name=...`, GET `/api/players/sport/{sport}`, GET `/api/players/skill/{level}`
- GET `/api/mentorships`, POST `/api/mentorships`, PUT `/api/mentorships/{id}`, DELETE `/api/mentorships/{id}`
- GET `/api/crowdfunding/campaigns`, POST `/api/crowdfunding/campaigns`, POST `/api/crowdfunding/campaigns/{id}/donations`
- GET `/api/news`, POST `/api/news`, DELETE `/api/news/{id}`

Note: The backend uses an in-memory store and resets on restart.

Frontend
--------

Run frontend:
```
npm install
npm run dev
```

The frontend services call `http://localhost:8080`.