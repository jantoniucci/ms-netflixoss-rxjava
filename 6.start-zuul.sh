echo ""
echo "* Launching Zuul"
echo "------------------"
mvn -DmainClass=com.gft.poc.ms.netflix.rx.zuul.ZuulApplication spring-boot:run -Dspring.config.name=ms-zuul