echo ""
echo "* Opening dashboards"
echo "--------------------"

open http://localhost:8761/

open http://localhost:10000/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A10000%2Fturbine.stream&delay=1000&title=API
