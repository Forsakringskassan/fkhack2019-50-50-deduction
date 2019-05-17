# fkhack2019-50-50-deductionservice

Store reduction

```
curl -d '{ "amount" :"1500","deductionType" : "KRONOFOGDEN" }'  -H "Content-Type: application/json" -X POST http://localhost:8080/deductionservice/customers/6fa459ea-ee8a-3ca4-894e-db77e160355e
```


Calculate nett

```
curl -d '{ "id" :"6fa459ea-ee8a-3ca4-894e-db77e160355e","gross" : "10000" }'  -H "Content-Type: application/json" -X POST http://localhost:8080/deductionservice/reduce
```


Check available reductions for customer

```
curl -v http://localhost:8080/deductionservice/customers/6fa459ea-ee8a-3ca4-894e-db77e160355e
```




