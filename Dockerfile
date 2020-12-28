FROM openjdk15:ubuntu

RUN  curl -Ls https://api.github.com/repos/Meghdut-Mandal/TestBookScrapper/releases/latest | grep -wo "https.*TestBookScrapper.zip" | wget -qi -
RUN unzip TestBookScrapper.zip
ENTRYPOINT ["java","-jar","TestBookScrapper.jar"]

