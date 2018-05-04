Valuemation Docker Bootstrap 
============================


* [Overview](#overview)
* [Installation](#installation)
    * [Option: 1. Git](#option-1.-git)
    * [Get geography metadata](#get-geography-metadata)
* [Run Valuemation](#run-valuemation)

        
## Overview

The project will show the basic functionality of Docker in a Valuemation environment.
It consists of two parts, a tomcat webserver image and an oracle database image.
With `docker-compose` now a new system with variable `vmweb` folder and `database dump (.dmp)` can be created.

                
     
     
     
## Installation 



There are two ways to install the project.



### Option 1. Git
For this option you must Install the git bash for Winodws 7:
https://gitforwindows.org/

**1.** First, navigate with the commandline to the directory where the project should be installed.<br />
Execute:<br />
`git clone <url>`<br />
after the sownlode is complete navigate in the project directory:<br />
`cd vm --------`<br />
now you can start 

**2.** To install the subprojects execute the `install` script:<br />
**Linux**:<br />
`./install.sh`<br />
**Windows:**<br />
### Option: 2. Without Git<br />
This installation way is more complicated.<br />

## Run Valuemation
Now the project can be started.<br />
For the first start and whenever changes are made to the subprojects the following command must be executed.<br />
`docker-compose up --build`<br />

The command execute `docker-compose` the `docker-compose.yaml` configuration <br />
(must be run in the folder where the file is located.) <br />
and the `--build` parameter determines that a docker build will run for the appropriate configuration. <br />

`docker-compose up` <br />
Without this flag the existing containers are started (if existing).


