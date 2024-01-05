[![Web Build Status](https://github.com/google/filament/workflows/Web/badge.svg)](https://github.com/dangducminh/se15.2/actions?query=workflow)

# Setup project
## Setup environment
### Java
This project use java 8 . Consequently, Java 8 must be installed.
Refer to some tutorials below
- [Vietnamese instructions for installation](https://hocjava.com/cai-dat-java-tren-windows-10/)
- [English instructions for installation](https://phoenixnap.com/kb/install-java-windows)

Or use the ide's java environment such as Intellij , etc
### Database:
This project use Mysql. Refer to some tutorials below
- [Vietnamese instructions for installation](https://openplanning.net/10221/cai-dat-co-so-du-lieu-mysql-tren-windows)
- [English instructions for installation](https://www.freecodecamp.org/news/how-to-install-mysql-workbench-on-windows/)

Or install it via Docker :

`docker run --name mysql  -dp 3306:3306 -e MYSQL_ROOT_PASSWORD=root  mysql:5.7-oracle`

### Logging
Project logging system is ELK
This project use Mysql. Refer to some tutorials below
- [English document](https://www.techtarget.com/searchitoperations/definition/Elastic-Stack)
Start ELK:
- cd deploy/logging-system
- docker compose up -d 

