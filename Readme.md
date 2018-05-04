Valuemation Docker Bootstrap 
============================


* [Overview](#overview)
* [Requirements](#requirements)
* [Installation](#installation)
    * [Option: 1. Git](#option-1.-git)
    * [Get geography metadata](#get-geography-metadata)
* [Run Valuemation](#run-valuemation)

        
## Overview

The project will show the basic functionality of Docker in a Valuemation environment.
It consists of two parts, a tomcat webserver image and an oracle database image.
With `docker-compose` now a new system with variable `vmweb` folder and `database dump (.dmp)` can be created.</br>
![Alt text](/vm-docker-bootstrap.png?raw=true "vm-docker-bootstrap")
                
     

## Requirements
needed Software:
 - Docker
 - Docker Compose


Docker working with the Guest-OS via a Hypervisor so you need to enable **CPU visualization** in the BIOS settings </br> (see Docker Toolbox tutorial)</br>
For Windows 7 install the offical Docker Toolbox:
https://docs.docker.com/toolbox/toolbox_install_windows/


     
## Installation 



There are two ways to install the project.



### Option 1. Git
For this option you must Install the git bash for Winodws 7:
https://gitforwindows.org/

**1.** First, navigate with the commandline to the directory where the project should be installed.<br />
Execute:<br />
`git clone <url>`<br />
after the download is complete navigate in the project directory:<br />
`cd vm-docker-bootstrap`<br />
now you can start 

**2.** To install the subprojects execute the `install` script:<br />
**Linux**:<br />
`./install.sh`<br />
**Windows:**<br />
`install.bat`
### Option: 2. Without Git<br />
This installation way is more complicated.<br />
![Alt text](/vm-docker-compose-oracleGitLab.jpg?raw=true "vm-docker-bootstrap")
You can download all projects available in the Git manuel as zip over the Web-Frontend. </br>

**1.** Download and unzip the root project from this site.
after the download is complete navigate in the project directory:<br />
`cd vm-docker-bootstrap`<br />
**2.** Download and unzip the subprojects in the root project:
</br>
http://usdev016:81/vm-dev/vmx-oc-web-test
http://usdev016:81/vm-dev/vmx-oc-oracledb-test


## Run Valuemation
Now the project can be started.<br />
For the first start and whenever changes are made to the subprojects the following command must be executed.<br />
`docker-compose up --build`<br />

The command execute `docker-compose` the `docker-compose.yaml` configuration <br />
(must be run in the folder where the file is located.) <br />
and the `--build` parameter determines that a docker build will run for the appropriate configuration. <br />

`docker-compose up` <br />
Without this flag the existing containers are started (if existing).


