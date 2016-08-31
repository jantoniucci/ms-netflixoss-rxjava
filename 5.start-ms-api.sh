echo ""
echo "* Launching API"
echo "---------------"
mvn -DmainClass=com.gft.poc.ms.netflix.rx.microservice.api.BookApiApplication spring-boot:run -Dspring.config.name=ms-bookapi