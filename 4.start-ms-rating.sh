echo ""
echo "* Launching Ratings"
echo "-------------------"
mvn -DmainClass=com.gft.poc.ms.netflix.rx.microservice.rating.BookRatingMicroserviceApplication spring-boot:run -Dspring.config.name=ms-bookrating