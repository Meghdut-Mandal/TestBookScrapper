echo Dev: Meghdut Mandal
echo date '+%A %W %Y %X'
sed -i 's/localhost/mongo/g' config.json
cat config.json
echo starting scrapper
java -jar TestBookScrapper.jar
