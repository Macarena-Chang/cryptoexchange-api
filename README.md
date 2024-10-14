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
</ul> </details>

 To do:
<li><a href="">Cloud Database Instance</a></li>
</ul> </details>
<li><a href="">CI: Automate builds and testing</a></li>
<li><a href="">Jenkins/Github Actions</a></li>
<li><a href="">SonarCLoud</a></li>
</ul> </details>

## API
1- Save / Retrieve [Investment Accounts, Markets, Countries]  from DB. <br> 
2- Add a Stats Endpoint <br>
3- Swagger Available at /swagger-ui/index.html <br>

3- Reporting Microservice: Generate Report (Report by city, Report for all locations) <br>  <br>

### Report /STATS contains:
        • Market
        • Country. 
        • Percentage of market share for each Market in given country. 
 
```JSON [
    {
        "id": 1,
        "codigo": "MAE",
        "descripcion": "Mercado Argentino de Valores",
        "pais": {
            "id": 1,
            "nombre": "Argentina"
        },
        "comitentes": [
            {
                "id": 22,
                "descripcion": "Comitente 03"
            },
            {
                "id": 20,
                "descripcion": "Comitente 01"
            },
            {
                "id": 21,
                "descripcion": "Comitente 02"
            },
            {
                "id": 25,
                "descripcion": "Comitente 06"
            }
        ]
    },
    {
        "id": 2,
        "codigo": "ROFEX",
        "descripcion": "Mercado de Futuros",
        "pais": {
            "id": 1,
            "nombre": "Argentina"
        },
        "comitentes": [
            {
                "id": 26,
                "descripcion": "Comitente 07"
            }
        ]
    },
    {
        "id": 3,
        "codigo": "UFEX",
        "descripcion": "Mercado de Uruguay",
        "pais": {
            "id": 2,
            "nombre": "Uruguay"
        },
        "comitentes": [
            {
                "id": 23,
                "descripcion": "Comitente 04"
            },
            {
                "id": 24,
                "descripcion": "Comitente 05"
            }
        ]
    }
]
```

## Swagger Doc
Available at ```/swagger-ui/index.html```
![Swagger](https://i.imgur.com/tC8xvOf.png)

## :toolbox: Getting Started

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
git clone[https://github.com/Macarena-Chang/cryptoexchange-api.git]
```
