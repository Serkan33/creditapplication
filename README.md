# Kocfinan Kredi Sorgulama
Bir kredi başvuru sistemi için kredi başvuru isteklerini alıp ilgili kriterlere göre
müşteriye kredi sonucunu dönen servisin içinde yer alacak restful bir endpoint’in herhangi bir Java
(Spring Boot, SparkJava vb) kütüphanesi kullanılarak yazılması.

## Frontend

Projenin arayüzü angular 8 ile geliştirilmiştir.

## Backend

Projenin backend kısmı spring boot 2.2.2 ile geliştirilmiştir. PostgreSql veritabanı kullanılmıştır.

## Build

Projeyi çalıştırmak için docker-compose gereklidir. Docker compose yüklendikten sonra `docker-compose.yml` dosyasının bulunduğu dizinde `docker-compose up --build` komutu ile projeyi çalıştırabilirsiniz. Angular projesi `http://localhost:4200` portunda çalışacaktır. 

Veritabanına kullanıcı eklemek için `http://localhost:8080/credit/user/save` endpointine post request yapabilirsiniz. Aşağıda örnek body verilmiştir.
```
{
	"name":"Deniz",
	"lastName":"Aslan",
	"citizenNumber":"11111111112",
	"monthlyIncome":8000,
	"phone":"05394639322",
	"creditScore":1000
}
```

## Swagger

Api dokümanını erişmek için [Swagger](http://localhost:8080/swagger-ui.html) linkini kullanabilirsiniz.
