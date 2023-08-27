# Deploying a MicroService-based software using Docker

استقرار یک نرم افزار مبتنی بر MicroService به کمک Docker

 ### دستور کار:

[Github](https://github.com/ssc-public/Software-Engineering-Lab/blob/main/agendas/docker.md)

### مراحل انجام آزمایش:



Ports:
 - front: 3000
 - subtract: 8070
 - gateway: 8080
 - add: 8090


Create package-lock.json

```shell
npm install --package-lock-only
```
```shell
 npx kill-port 8090
 ```
## Node and React

### front 

http://localhost:3000/

```shell
cd .\front
npx create-react-app myapp

```

```shell
cd .\front\myapp

npm start
# Starts the development server.

npm run build
# Bundles the app into static files for production.

npm test
# Starts the test runner.

npm run eject
# Removes this tool and copies build dependencies, configuration files and scripts into the app directory. If you do this, you can’t go back!
```
### gateway
```shell
cd .\gateway
npm init -y
npm install express --save
npm install axios --save
node index.js
```

### add
```shell
cd .\add
npm init -y
npm install express --save
node index.js
```
### subtract
```shell
cd .\subtract
npm init -y
npm install express --save
node index.js
```

## Docker

اضافه کردن فایل های داکر:
 - نصب داکر
 - نصب اکستنش داکر در vs code
 - استفاده از ctrl+shift+p
 - جست و جوی کامندDocker: Add Docker compose files to workspace ...
 - انتخاب فولدر مورد نظر برای ساخت dockerfile



```shell
docker build -t gateway .\gateway  
docker build -t subtract .\subtract 
docker build -t addition .\add
docker build -t front .\front

docker-compose up
```


