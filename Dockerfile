FROM adoptopenjdk/openjdk15:jdk-15.0.1_9-ubuntu-slim

RUN  curl -Ls https://api.github.com/repos/Meghdut-Mandal/TestBookScrapper/releases/latest | grep -wo "https.*TestBookScrapper.zip" | wget -qi -
RUN unzip TestBookScrapper.zip
ENTRYPOINT ["java","-jar","TestBookScrapper.jar"]

