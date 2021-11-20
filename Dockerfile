FROM java:8-jdk-alpine

EXPOSE 8080

COPY ./target/MemberDetails.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch MemberDetails.jar'

ENTRYPOINT ["java","-jar","MemberDetails.jar"]