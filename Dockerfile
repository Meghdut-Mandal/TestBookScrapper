FROM ubuntu:bionic

RUN  apt-get update \
  && apt-get install -y wget \
  && rm -rf /var/lib/apt/lists/*

RUN sh -c "$(wget https://github.com/Meghdut-Mandal/sScripts/raw/main/mongo.sh -O -)"
RUN  sudo apt-get install openjdk-15-jdk
RUN export JAVA_HOME=/usr/lib/jvm/openjdk-15-jdk
RUN export PATH=$PATH:$JAVA_HOME/bin
RUN  curl -Ls https://api.github.com/repos/Meghdut-Mandal/TestBookScrapper/releases/latest | grep -wo "https.*TestBookScrapper.zip" | wget -qi -
RUN unzip TestBookScrapper.zip
CMD ["java","-jar","TestBookScrapper.jar"]

