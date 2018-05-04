Valuemation Docker Bootstrap 
============================


* [Overview](#overview)
* [Requirements](#requirements)
* [Installation](#installation)
    * [Option: 1. Git](#option-1-git)
    * [Option: 2. Without Git](#option-2-without-git)
* [Run Valuemation](#run-valuemation)
* [Import varable `vmweb` and Oracle `Dump`](#import-varable-vmweb-and-oracle-dump)
* [Dealing with Docker Compose](#dealing-with-docker-compose)
        
## Overview

The project will show the basic functionality of Docker in a Valuemation environment.
It consists of two parts, a tomcat webserver image and an oracle database image.
With `docker-compose` now a new system with variable `vmweb` folder and `database dump (.dmp)` can be created.</br>
![Alt text](/vm-docker-bootstrap.png?raw=true "vm-docker-bootstrap")
                
     

## Requirements
needed Software:
 - [ ] Docker
 - [ ] Docker Compose


Docker working with the Guest-OS via a Hypervisor so you need to enable **CPU visualization** in the BIOS settings </br> (see Docker Toolbox tutorial)</br>
For Windows 7 install the offical [Docker Toolbox](https://docs.docker.com/toolbox/toolbox_install_windows/).


     
## Installation 



There are two ways to install the project.



### Option: 1. Git
For this option you can Install the [git bash for Winodws 7](https://gitforwindows.org/).


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
![Alt text](/vm-docker-compose-oracleGitLab.jpg?raw=true "vm-docker-bootstrap")

**1.** **Download** and **unzip** the root project from this site.
<br />
After the download is complete navigate in the project directory:
```
cd vm-docker-bootstrap
```

**2.** **Download** and **unzip** the subprojects in the root project:

[vm-oc-web-test](http://usdev016:81/vm-dev/vmx-oc-web-test)
<br />
[vm-oc-oracledb-test](http://usdev016:81/vm-dev/vmx-oc-oracledb-test)

_____________

## Run Valuemation
Now the project can be started.<br />
For the first start and whenever changes are made to the subprojects the following command must be executed.<br />
```
docker-compose up --build
```


The command execute `docker-compose` the `docker-compose.yaml` configuration <br />
(must be run in the folder where the file is located.) <br />
and the `--build` parameter determines that a docker build will run for the appropriate configuration. <br />


**Without** the `--build` flag the existing containers are started (if existing).
```
docker-compose up
```

</br>
</br>

## Import varable `vmweb` and Oracle `Dump`

To use variable **Valuemation versions**, the **subprojects** of the **vmweb** folder and the dump **.dmp** have to be swapped out.
**Note:** The **dump(*.dmp) file** must be named the same as the **Oracle user defined in the dump for importing the data**.

**After** the **exchange**, the subprojects have to be **rebuilt**. </br>
For this, the following command must be executed again. </br>
```
docker-compose up --build
```

**Note:** The project is not allowed to run. (see Dealing with Docker Compose)</br>
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

It is for example possible if needed to change the port for the Websever Image on 80, if this is free.
Example:
```
version:'2'
```



