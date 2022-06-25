FROM openjdk:8
MAINTAINER fitz <xhou@zuora.com>

EXPOSE 8888

RUN apt-get update && apt install -y curl && \
    rm -rf /var/lib/apt/lists/*

COPY ./target/hello-springboot-*.jar /app/hello-springboot.jar

WORKDIR app

CMD java -Djava.security.egd=file:/dev/./urandom -jar hello-springboot.jar

HEALTHCHECK --interval=10s --timeout=3s \
  CMD curl -f http://localhost:8888/api/hi || exit 1
