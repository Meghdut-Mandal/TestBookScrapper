FROM adoptopenjdk/openjdk15:jdk-15.0.1_9-ubuntu-slim
RUN  apt-get update \
  && apt-get install -y wget unzip sed \
  && rm -rf /var/lib/apt/lists/*

RUN curl -Ls https://api.github.com/repos/Meghdut-Mandal/TestBookScrapper/releases/latest | grep -wo "https.*TestBookScrapper.zip" | wget -qi -
RUN unzip TestBookScrapper.zip
COPY . .
RUN chmod +x run.sh
ENTRYPOINT ["./run.sh"]

