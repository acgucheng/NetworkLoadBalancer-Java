# NetworkLoadBalancer-Java
## Run Demo

### Environment Setup

Config the test network for nlb demo.

```bash
docker network create --driver=bridge --subnet=172.28.5.0/24 nlb-demo-network
```
Use docker compose command to compose the demo project.

```bash
docker compose -f compose-public.yaml up
```

### Config NLB

1. Check the ip addresses of the demo website.

```bash
docker network inspect nlb-demo-network
```

Record the container ip address named "networkloadbalancer-java-demo" (there will be three containers)

2. Open the controll panel of the network load balancer.

Type http://localhost in the browser to login into the Host Manager.

Delete the default host, and add the host with the ip addresses before. The port are 8080.
