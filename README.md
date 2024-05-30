# smart-virtual-classroom
This is a spring boot microservice project 


## How To contribute in the backend project 

 * Fork the project in your github account and create a new branch
 * Clone the project from your account
 * import root folder project into intelij idea
 * You will see a notification to load as maven, click on that
 * If you don't find it, you need to manually set it
 * Go to every maven project & right click on the pom.xml file and in the below you will se an option add to maven, click on that
 * You will find project configs data into config-server
 * First start registry service and then Config-server, and api gateway server
 * after that you can run your all others services
 * Create a new feature and create a pull request 

## How To Run the frontend project

 * navigate to the frontend folder
 * run command : npm install
 * start the app using command : npm start



 # Tasks Need be completed 


## User Management Service
The User Management Service is responsible for handling all functionalities related to users, authentication, and authorization.

### Functionalities:
- User registration and profile management
- Authentication and authorization (JWT-based security)
- User roles and permissions
- Attendance tracking

### Endpoints:
- POST /users/register - Register a new user
- POST /users/login - Authenticate a user and provide a JWT
- GET /users/{id} - Get user details
- POST /users/attendance - Track attendance

### Database Tables:
- Users
- Roles
- Attendance

### Technologies:
- Spring Boot
- Spring Security
- JWT

## Classroom Management Service
The Classroom Management Service is responsible for classroom creation, management, assignments, and quizzes.

### Functionalities:
- Create and manage classrooms
- Manage assignments and submissions
- Create and manage quizzes

### Endpoints:
- POST /classrooms - Create a new classroom
- GET /classrooms/{id} - Get details of a classroom
- POST /classrooms/{id}/join - Join a classroom
- POST /assignments - Create a new assignment
- POST /assignments/{id}/submit - Submit an assignment
- POST /quizzes - Create a new quiz

### Database Tables:
- Classrooms
- Assignments
- Submissions
- Quizzes

### Technologies:
- Spring Boot
- Spring Data JPA

## Collaboration Tools Service
The Collaboration Tools Service handles real-time collaboration features like video conferencing, whiteboarding, and the code editor.

### Functionalities:
- Real-time video conferencing
- Interactive whiteboard
- Collaborative code editor
- Real-time notifications

### Endpoints:
- POST /videos/start - Start a video conference
- POST /videos/stop - Stop a video conference
- POST /whiteboard/draw - Handle whiteboard drawing events
- POST /code/execute - Execute code snippets

### External Services:
- Jitsi for video conferencing
- JDoodle or a similar service for code execution

### Technologies:
- Spring Boot
- WebSocket for real-time communication
- Integration with external APIs