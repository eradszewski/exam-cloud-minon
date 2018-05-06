Valuemation Docker Bootstrap 
============================


* [Overview](#overview)
* [Requirements](#requirements)
* [Installation](#installation)
    * [Option: 1. Git](#option-1-git)
    * [Option: 2. Without Git](#option-2-without-git)
* [Run Valuemation](#run-valuemation)
* [Import variable `vmweb` and Oracle `Dump`](#import-variable-vmweb-and-oracle-dump)
* [Dealing with Docker Compose](#dealing-with-docker-compose)
        
## Overview

The project will show the basic functionality of Docker in a Valuemation environment.
It consists of two parts, a tomcat web server image and an Oracle database image.
With `docker-compose` now a new system with variable `vmweb` folder and `database dump (.dmp)` can be created.</br>
<p align="center">
  <img src="/vm-docker-bootstrap.png">
</p> 
     

## Requirements
needed Software:
 - [ ] Docker
 - [ ] Docker Compose


Docker working with the Guest-OS via a Hypervisor so you need to enable **CPU visualization** in the BIOS settings </br> (see Docker Toolbox tutorial)</br>
For Windows 7 install the offical [Docker Toolbox](https://docs.docker.com/toolbox/toolbox_install_windows/).
<br />
**Node:** 
For optimal operation, the VM in the docker needs to be provided with slightly more resources. Depending on how strong your machine is I would recommend **2GB - 4GB RAM, 1 - 4 CPUs**.

<p align="center">
  <img src="/virtualbox_change.jpg">
</p> 

<p align="center">
  <img src="/virtualbox_change2.jpg">
</p> 

     
## Installation 
The target structure should look like this.
<br />
```
vm-docker-bootstrap
               |-> vmx-oc-web-test
                  - Dockerfile
               |-> vmx-oc-oracledb-test
                  - Dockerfile
```
There are two ways to install the project.
<br />
### Option: 1. Git
For this option you can Install the [git bash for Winodws 7](https://gitforwindows.org/).
<br />
**Note:** the switch from Unix to Windwos can generate a CRLF Bug execute the follow command on cmd
```
git config --global core.autocrlf false
```
**1.** First, navigate with the commandline to the directory where the project should be installed.<br />
**Execute**:<br />
```sh
git clone http://usdev016:81/vm-dev/vm-docker-bootstrap.git
```
<br />
After the download is complete navigate in the project directory:<br />

```sh
cd vm-docker-bootstrap
```

<br />

**2.** To install the subprojects **execute** the `install` script:<br />
**Linux**:<br />
```sh
./install.sh
```
**Windows:**
```
install.bat
```

_____________

### Option: 2. Without Git<br />
This installation way is more expensive.<br />
You can download all projects available in the Git manuel as zip over the Web-Frontend. </br>

<p align="center">
  <img src="/vm-docker-compose-oracleGitLab.jpg">
</p> 

**1.** **Download** and **unzip** the root project from this site.
<br />
After the download is complete navigate in the project directory:
```sh
cd vm-docker-bootstrap
```

**2.** **Download** and **unzip** the subprojects in the root project:

[vmx-oc-web-test](http://usdev016:81/vm-dev/vmx-oc-web-test)
<br />
[vmx-oc-oracledb-test](http://usdev016:81/vm-dev/vmx-oc-oracledb-test)

_____________

### Create a Persistent Datastore on Guest-System

For the **persistent** storage of data, especially the data of the database, a `docker volume` is needed.
```
docker volume create --name=valuemation-datavolume

```

This **volume** can now store the data of the **actually stateless container**.
<br />
For more **detailed information** about the volume the following command can be used:
```
docker volume inspect valuemation-datavolume
```

Output Example:
```
[
    {
        "CreatedAt": "2018-05-04T18:05:57Z",
        "Driver": "local",
        "Labels": {},
        "Mountpoint": "/mnt/sda1/var/lib/docker/volumes/valuemation-datavolume/_data",
        "Name": "valuemation-datavolume",
        "Options": {},
        "Scope": "local"
    }
]
```

To clear the Volume / the persistent Oracle Dump to install a new Dump use :
```
docker volume prune valuemation-datavolume --force
```

## Run Valuemation

**Only for Windwos 7:**
start the **docker toolbox**.
Since Docker does not run directly on the Windows 7 device, the IP of the Vm is required, this must be entered in the "dbpropertys" so that "Valuemation-Web" can open the connection.
The Docker-VM Ip you see in the Docker Toolbox
<p align="center">
  <img src="/IP_Toolbox.jpg">
</p> 

____________________
For **all Systems:**
Now the project can be started.<br />
For the first start and whenever changes are made to the subprojects the following command must be executed.<br />
```
docker-compose up --build
```
The execute of `docker-compose` implement the `docker-compose.yaml` configuration <br />
(must be run in the folder where the file is located.) <br />
and the `--build` parameter determines that a docker build will run for the appropriate configuration. <br />


**Without** the `--build` flag the existing containers are started (if existing).
```
docker-compose up
```

</br>
</br>

## Import variable `vmweb` and Oracle `Dump`

To use variable **Valuemation versions**, the **subprojects** of the **vmweb** folder and the dump **(.dmp)** have to be swapped out.
**Note:** The **dump(*.dmp) file** must have the same name like from the **Oracle user defined in the dump for importing the data**.

**After** the **exchange**, the subprojects have to be **rebuilt**. </br>
For this, the following command must be executed again. </br>
```
docker-compose up --build
```

**Note:** The project isn´t allowed to run. (see Dealing with Docker Compose)</br>
## Dealing with Docker Compose
To display all docker-compose instances:
```
docker-compose ps
```
To delete all instances:
```
docker-compose rm
```
View all logs: 
```
docker-compose logs
```

### Custemize Docker Compose Configuration

It is possible if needed to change the port for the Web Server Image on 80, if this is free.
<br />
Example docker-compose.yaml:
```
version: '2'
services:
...
...
...
  valumation-web:
    build:
      context: ./vmx-oc-web-test/.
#    image: vm-web:v1
    ports:
       - 80:8080
    depends_on:
      - valumation-oracle-db
...
...
...

```



