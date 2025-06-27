FROM adoptopenjdk:11-jre-hotspot
COPY CreditCardPayment*.jar /application.jar
CMD java -jar /application.jar