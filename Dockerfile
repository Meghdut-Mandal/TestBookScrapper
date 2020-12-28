FROM ubuntu:bionic

RUN sudo tee /etc/apt/sources.list.d/mongodb-org-4.2.list << EOF
RUN deb https://repo.mongodb.org/apt/ubuntu bionic/mongodb-org/4.2 multiverse
RUN EOF
RUN sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com --recv E162F504A20CDF15827F718D4B7C549A058F8B6B
RUN sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com --recv 7568D9BB55FF9E5287D586017AE645C0CF8E292A
RUN sudo apt-get --assume-yes install mongodb-server
RUN sudo systemctl start  mongodb
RUN sudo systemctl enable mongodb
RUN  sudo apt-get install openjdk-15-jdk
RUN export JAVA_HOME=/usr/lib/jvm/openjdk-15-jdk
RUN export PATH=$PATH:$JAVA_HOME/bin
RUN  curl -Ls https://api.github.com/repos/Meghdut-Mandal/TestBookScrapper/releases/latest | grep -wo "https.*TestBookScrapper.zip" | wget -qi -
RUN unzip TestBookScrapper.zip
CMD ["java","-jar","TestBookScrapper.jar"]

