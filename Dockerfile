FROM adoptopenjdk/openjdk15:jdk-15.0.1_9-ubuntu-slim
RUN  apt-get update \
  && apt-get install -y wget unzip sed \
  && rm -rf /var/lib/apt/lists/*

CMD curl -Ls https://api.github.com/repos/Meghdut-Mandal/TestBookScrapper/releases/latest | grep -wo "https.*TestBookScrapper.zip" | wget -qi -
CMD unzip TestBookScrapper.zip
CMD ls
CMD java -jar TestBookScrapper.jar

