
AWS Training
------------
Topics: EC2, EBS, EFS, S3, RDS

Fundamental servies: Cloud computing, below services are provided through internet & pay-on-use.
Compute on demand
Storage on demand
Network(bandwidth) on demand

AWS provides all 3 services delivery, 90+ services
IaaS - Hardware provisioning
PaaS - configuring hardware, OS,  
SaaS - application software

3 deployment model
public - 
private - own data center
hybrid -  computing in AWS public and data is stored in own data center

Advantage:
1. Capital investment in minimal and have only operational cost, pay on use
2. Scaling, AWS cloud formation(portability), scale up and scale back. elastic
3. No capacity planning and management required, managed automatically.
4. No data center maintenace
5. Applications available globally

Depending on IaaS, PaaS, SaaS SLA are provided by AWS itself

Storage services:
EBS
EFS
S3

Networking Services:
VPN
Route53

Messaging Services:
SQS 
SES 
SNS

Database services:
RDS

Content Delivery services:
CDN services

Analytics services:
Hadoop
DWH

Mobile services:
IOT services

Development and Management Tools:
devops

cloudping.info

Edge locations:
WAF - Securirty services - stop DoS attacks


Storage:
Object - S3 - scalable
Block -EBS - HHD
Archive - 

GP2 -> SSD
GP1 -> Hybrid

http://ec2instances.info

lsblk

sudo mkfs -t xfs /dev/xvdf

mount /dev/sdf /disk2 -> mount disk2 to /sdf directory


AWS S3 is a object storage, store any type of data. 

S3 has elastic buckets. the bucket name is always unique.

each bucket & file can have ACL

aws s3 cp sample.txt s3://mybuckettraining/files/

aws s3 cp sheep1.png s3://imagestoresg/
upload: .\sheep1.png to s3://imagestoresg/sheep1.png


Use multi-part upload in S3 to make the upload reliable

AWS EFS - Elastic file system
------------------------------

Can be mounted as network drive to EC2 instance
Shared network file system can read from all instances
Scalable

Scaling
-------

Vertical scaling: Supports stateless and statefull applications
Adding more power

Horizontal scaling: 
Adding more instances with load balancer in the front

RDS are only vertically scalable

VPC  
---

Virtual private network is a network isolated zone. It contains subnets.
Each subnet is one availability zone. change IP rules can control comm b/w subnets.
Internet gateway is created at the time of VPC creation

In IG we can block the out going traffic




scalable architecture

Load balancer 
EC2 - horizontal scaling
EFS - scalable network storage
S3 - scalable S3 storage
RDS - database vertically scalable
cloud front
Auto scaling

https://aws.amazon.com/architecture/










