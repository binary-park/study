## 설치

docker-compose를 사용하여, 쉽고 간단하게 Sonarqube를 세팅할 수 있습니다. 해당 매뉴얼은 `docker`와 `docker-compose`가 설치 되어있다는 가정하에 설명합니다.



### docker-compose.yml 파일 생성

다음과 같이 `docker-compose.yml` 파일을 작성해 줍니다.

```
version: "2"

services:
  sonarqube:
    image: sonarqube
    container_name: sonarqube
    ports:
      - "9000:9000"
    networks:
      - sonarnet
    environment:
      - SONARQUBE_JDBC_URL=jdbc:postgresql://db:5432/sonar
    volumes:
      - sonarqube_conf:/opt/sonarqube/conf
      - sonarqube_data:/opt/sonarqube/data
      - sonarqube_extensions:/opt/sonarqube/extensions
      - sonarqube_bundled-plugins:/opt/sonarqube/lib/bundled-plugins
    restart: always
    depends_on:
    	- db

  db:
    image: postgres
    container_name: sonarqube-db
    networks:
      - sonarnet
    environment:
      - POSTGRES_USER=sonar
      - POSTGRES_PASSWORD=sonar
    volumes:
      - postgresql:/var/lib/postgresql
      # This needs explicit mapping due to https://github.com/docker-library/postgres/blob/4e48e3228a30763913ece952c611e5e9b95c8759/Dockerfile.template#L52
      - postgresql_data:/var/lib/postgresql/data
    restart: always

networks:
  sonarnet:
    driver: bridge

volumes:
  sonarqube_conf:
  sonarqube_data:
  sonarqube_extensions:
  sonarqube_bundled-plugins:
  postgresql:
  postgresql_data:
```



### 컨테이너 실행

`docker-compose.yml` 파일의 경로에서 [docker-compose](https://github.com/docker/compose) 를 사용하여 컨테이너를 실행합니다.

```bash
$ docker-compose up
```



