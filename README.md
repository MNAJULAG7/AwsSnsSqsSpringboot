🚀 **Implemented AWS SNS and SQS with Spring Boot Microservices!**

I have successfully implemented an event-driven communication system using AWS SNS and SQS.

**How it works:**

1. When a user confirms an order, the Order Service creates an order event.
2. The Order Service publishes the event to an AWS SNS Topic.
3. SNS distributes the event to an SQS Queue.
4. The Inventory Service receives the message from SQS.
5. The Inventory Service processes the event and updates the stock.

**Technologies Used:**
- Java & Spring Boot
- AWS SNS
- AWS SQS
- Amazon EC2
- Docker & Docker Compose
- AWS IAM Roles and Policies

I deployed both Order Service and Inventory Service as Docker containers on an EC2 instance and configured IAM permissions for SNS and SQS access.

This project helped me understand how AWS services support communication between microservices using event-driven architecture.

**Learning by building! 💻🚀**

#AWS #SpringBoot #Microservices #SNS #SQS #Docker #EC2 #Java #CloudComputing #LearningByDoing
