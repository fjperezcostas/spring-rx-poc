# spring-rx-poc

Just a tiny project-lab for playing and testing all capabilities of Spring Webflux and compare them with the traditional
synchronous Spring MVC approach.

## How to deploy all stack locally

`git clone https://github.com/fjperezcostas/spring-rx-poc && cd spring-rx-poc && bash startup.sh`

## Spring MVC vs Webflux comparison 

A load test have been done in order to compare the performance between two approaches. The tested scenario is as follows:

![test-scenario](https://github.com/fjperezcostas/spring-rx-poc/blob/master/assets/test-scenario.png)

Hardware:
```
Ubuntu 22.04.4 LTS
Intel(R) Core(TM) i7-6600U CPU @ 2.60GHz x 4 
16GiB RAM
```

### Results

#### Load Test Report
![load-test-report](https://github.com/fjperezcostas/spring-rx-poc/blob/master/assets/load-test-report.png)
#### Sync Proxy Service Profiling
![sync-proxy-profiling](https://github.com/fjperezcostas/spring-rx-poc/blob/master/assets/sync-proxy-profiling-stats.png)
#### Rx Proxy Service Profiling
![rx-proxy-profiling](https://github.com/fjperezcostas/spring-rx-poc/blob/master/assets/rx-proxy-profiling-stats.png)