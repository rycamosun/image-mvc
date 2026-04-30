# Image Gallery MVC

A Java Swing desktop app where users can register log in and manage a personal image gallery.

## Demo

![Demo](demo.png)

## Install

```bash
  git clone https://github.com/rycamosun/image-mvc
  cd image-mvc

  mysql -u root -p < schema.sql
  
  mkdir -p lib && curl -L -o lib/mysql-connector-j.jar \
    https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/9.6.0/mysql-connector-j-9.6.0.jar
```

## Usage

```bash
export DB_URL=jdbc:mysql://localhost:3306/yourdb
export DB_USER=user
export DB_PASSWORD=yourpassword

ant
```

## Tech Stack

**Client:** Java Swing

**Server:** JDBC + MySQL

## License

[MIT](https://github.com/rycamosun/image-mvc/blob/main/LICENSE)
