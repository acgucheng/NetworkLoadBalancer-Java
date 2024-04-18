# Demo Website for Load Balancing Test

## Get Started

```bash
Docker build . -t nlb-java/nlb-website-demo

Docker network create \                                                           
  --driver=bridge \
  --subnet=172.28.0.0/16 \
  --ip-range=172.28.5.0/24 \
  --gateway=172.28.5.254 \
  br0
  
docker run -d --network=br0 nlb-java/nlb-website-demo 
```