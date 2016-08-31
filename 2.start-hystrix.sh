echo ""
echo "* Launching HystrixDashboard"
echo "----------------------------"
mvn -DmainClass=com.gft.poc.ms.netflix.rx.dashboard.HystrixDashboardApplication spring-boot:run -Dspring.config.name=ms-dashboard
