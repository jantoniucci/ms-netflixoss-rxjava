echo ""
echo "* Launching Eureka"
echo "------------------"
mvn -DmainClass=com.gft.poc.ms.netflix.rx.eureka.EurekaApplication spring-boot:run -Dspring.config.name=ms-eureka