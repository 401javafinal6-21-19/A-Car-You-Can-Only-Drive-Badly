# Team 
[ Dana V, Jessica Z, Merry C, Michael J, Nicole K, Trey H ]


## Problem Domain
* Control an RC car wireless over bluetooh
* Manually control the car through bluetooth
* Crowdsource control of the car through twitch
## DriveBadlyBot
https://glitch.com/~drivebadlybot

## Resources
* [XiaoR Geek Chasis](https://www.amazon.com/Robot-Chassis-Motor-Arduino-Raspberry/dp/B07F759T89/ref=trb_chk_auth?keywords=arduino%2Brc%2Bcar&qid=1560381949&s=gateway&sr=8-39&openid.assoc_handle=amazon_checkout_us&openid.claimed_id=https%3A%2F%2Fwww.amazon.com%2Fap%2Fid%2Famzn1.account.AHLEH7FC5XQKN2RLJ3BWBUXAZHBA&openid.identity=https%3A%2F%2Fwww.amazon.com%2Fap%2Fid%2Famzn1.account.AHLEH7FC5XQKN2RLJ3BWBUXAZHBA&openid.mode=id_res&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.op_endpoint=https%3A%2F%2Fwww.amazon.com%2Fap%2Fsignin&openid.response_nonce=2019-06-12T23%3A34%3A38Z-6126370302708543090&openid.return_to=https%3A%2F%2Fwww.amazon.com%2FRobot-Chassis-Motor-Arduino-Raspberry%2Fdp%2FB07F759T89%2Fref%3Dtrb_chk_auth%3Fkeywords%3Darduino%252Brc%252Bcar%26qid%3D1560381949%26s%3Dgateway%26sr%3D8-39%26trb_auth%3D1%26trb_open%3D1%26trb_sid%3D139-8734638-2875921&openid.signed=assoc_handle%2Cclaimed_id%2Cidentity%2Cmode%2Cns%2Cop_endpoint%2Cresponse_nonce%2Creturn_to%2CsiteState%2Cns.pape%2Cpape.auth_policies%2Cpape.auth_time%2Csigned&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.auth_policies=http%3A%2F%2Fschemas.openid.net%2Fpape%2Fpolicies%2F2007%2F06%2Fnone&openid.pape.auth_time=2019-06-12T23%3A34%3A38Z&openid.sig=b4pgY8rxUGzn3%2Fb3yeK8VX1PlfQW0tP9uxVCO6VBj%2B8%3D&serial=&siteState=%7ChasWorkingJavascript.1%7ChasWorkingJavascript.1)

* [Twitch Chat Colored Light Reference](https://github.com/alexkarimov/twitchlights)

* [Twitch Chat tmi.js](https://www.youtube.com/watch?v=AnO2YKBAFc4)

* [RC CAR Reference](https://create.arduino.cc/projecthub/samanfern/bluetooth-controlled-car-d5d9ca)
## Creation and Installation 
* Build your car 
  1. Solder the wires to the motors, attach the motors to the chasis, and the wheels to the motors per chasis instructions. (the chasis we used can be found here [XiaoR Geek Chasis](https://www.amazon.com/Robot-Chassis-Motor-Arduino-Raspberry/dp/B07F759T89/ref=trb_chk_auth?keywords=arduino%2Brc%2Bcar&qid=1560381949&s=gateway&sr=8-39&openid.assoc_handle=amazon_checkout_us&openid.claimed_id=https%3A%2F%2Fwww.amazon.com%2Fap%2Fid%2Famzn1.account.AHLEH7FC5XQKN2RLJ3BWBUXAZHBA&openid.identity=https%3A%2F%2Fwww.amazon.com%2Fap%2Fid%2Famzn1.account.AHLEH7FC5XQKN2RLJ3BWBUXAZHBA&openid.mode=id_res&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.op_endpoint=https%3A%2F%2Fwww.amazon.com%2Fap%2Fsignin&openid.response_nonce=2019-06-12T23%3A34%3A38Z-6126370302708543090&openid.return_to=https%3A%2F%2Fwww.amazon.com%2FRobot-Chassis-Motor-Arduino-Raspberry%2Fdp%2FB07F759T89%2Fref%3Dtrb_chk_auth%3Fkeywords%3Darduino%252Brc%252Bcar%26qid%3D1560381949%26s%3Dgateway%26sr%3D8-39%26trb_auth%3D1%26trb_open%3D1%26trb_sid%3D139-8734638-2875921&openid.signed=assoc_handle%2Cclaimed_id%2Cidentity%2Cmode%2Cns%2Cop_endpoint%2Cresponse_nonce%2Creturn_to%2CsiteState%2Cns.pape%2Cpape.auth_policies%2Cpape.auth_time%2Csigned&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.auth_policies=http%3A%2F%2Fschemas.openid.net%2Fpape%2Fpolicies%2F2007%2F06%2Fnone&openid.pape.auth_time=2019-06-12T23%3A34%3A38Z&openid.sig=b4pgY8rxUGzn3%2Fb3yeK8VX1PlfQW0tP9uxVCO6VBj%2B8%3D&serial=&siteState=%7ChasWorkingJavascript.1%7ChasWorkingJavascript.1)
. 
2. Attach a small breadboard, set of 4 switches, battery pack, and Rasberry Pi to the chasis. 
![small breadboard](https://www.bananarobotics.com/shop/image/cache/data/sku/BR/0/1/0/1/9/BR010198-Small-400-Point-White-Breadboard/top-600x600.JPG)
![pi](http://raspberry.piaustralia.com.au/assets/full/ET-RASPBERRY-PI-3.png3)
![relays](http://images.carptum.com.s3.amazonaws.com/23766/6ef5a0f2b26f41af68e80a4c80b483e67e34cfef/size_1600x.jpg)
3. Place a power supply on one end of the breadboard 
![power supply](https://tinkersphere.com/907-thickbox_default/breadboard-power-supply-module-33v-5v-arduino-raspberry-pi-compatible.jpg)

4. Wire using pie GPIO Pins 26, 27, 28, 29 according to these diagrams: 

![Pie one](https://drive.google.com/open?id=0B6MjkZqKUJnVUURKTWJKN2lDUWx4MzF6eXZ6eWd6cXd0TkVB)
![Pie two](https://drive.google.com/open?id=0B6MjkZqKUJnVZGV5SVdVWlpJVHEya2JJbHdoWFZGRy1MMi00)
![Pie three](https://drive.google.com/open?id=0B6MjkZqKUJnVR1hSdFVrNXVCeVV3ejJEVjVqblE2bnVCRUY0)

* Install the correct Software on the Pie. 
  1. Format the SD card and install Raspian according to the directions per [Noobs](https://www.raspberrypi.org/downloads/noobs/) directions. 
  2. Insert the card in the pie and let it intilize. 
  3. Install [OpenJDK12](https://openjdk.java.net/projects/jdk/12/) on the pi. 
  4. Install [J4Pi](https://pi4j.com/1.2/pins/model-2b-rev1.html) on the pi.
  5. Pull this repository onto the pi. 
  6. Set up a firebase controller by following the instructions at [this link](https://github.com/401javafinal6-21-19/Car-Driver). 
  7. Go to the google cloud services page in your project and down load the Json file, save it in the root of this repo on the pi. 
  8. Run a ./gradlew -build. 
