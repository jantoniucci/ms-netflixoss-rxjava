echo ""
echo "* Launching load through Apache AB"
echo "----------------------------------"

ab -k -c 10 -n 2000 http://localhost:9997/api/books/1