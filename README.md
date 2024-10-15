<div align='center'>

 

<p>API Requirements 
• Create CRUD operations for: comitentes, markets, countries.
• Add /STATS endpoint, Swagger Documentation.
• Deploy to AWS.


</div>


 
## :star2: About the Project
### :space_invader: Tech Stack
<li><a href="">Java 17</a></li>
<li><a href="">SpringBoot</a></li>
<li><a href="">Maven</a></li>
<li><a href="">RESTful APIs</a></li>
<li><a href="">MYSQL</a></li>
<li><a href="">Spring Data JPA</a></li>
<li><a href="">Lombok</a></li>
<li><a href="">Swagger/OpenAPI</a></li>
<li><a href="">AWS Deployed</a></li> 
</ul> </details>



## API
1- Save / Retrieve [Investment Accounts, Markets, Countries]  from DB. <br> 
2- Add a Stats Endpoint <br>
3- Swagger Available at /swagger-ui/index.html <br>

 
### Report /STATS contains:
        • Market
        • Country. 
        • Percentage of market share for each Market in given country. 
 
```JSON [
    {
        "pais": "Argentina",
        "mercado": {
            "MAE": 80.0
        }
    },
    {
        "pais": "Argentina",
        "mercado": {
            "ROFEX": 20.0
        }
    },
    {
        "pais": "Uruguay",
        "mercado": {
            "UFEX": 100.0
        }
    }
]
```

## Swagger Doc
Available at ```/swagger-ui/index.html``` <br>
![Swagger](https://i.imgur.com/tC8xvOf.png)
 


## Deployed API Documentation

- The API is deployed on an AWS EC2 instance and uses an AWS RDS MySQL database.
- AWS RDS Mysql instance: [database-1.cvgow4wwexa0.us-east-2.rds.amazonaws.com](database-1.cvgow4wwexa0.us-east-2.rds.amazonaws.com).
- AWS EC2: [ec2-3-142-238-82.us-east-2.compute.amazonaws.com](ec2-3-142-238-82.us-east-2.compute.amazonaws.com). <br>

👉 Full API documentation is available via **Swagger UI** at the following URL:  http://ec2-3-142-238-82.us-east-2.compute.amazonaws.com:8080/swagger-ui/index.html <br>


 


---
## :toolbox: Getting Started Locally

### :bangbang: Prerequisites

- JDK 17
- Maven
- Environment Variables


 
### :key: Environment Variables
To run this project, you will need to add the following environment variables to your application properties
`{DB_USERNAME}`

`{DB_PASSWORD}`

### :running: Run Locally

Clone the project

```bash
git clone https://github.com/Macarena-Chang/cryptoexchange-api.git
```


To do:
</ul> </details>
<li><a href="">CI: Automate builds and testing</a></li>
<li><a href="">Jenkins/Github Actions</a></li>
<li><a href="">SonarCLoud</a></li>
</ul> </details>
