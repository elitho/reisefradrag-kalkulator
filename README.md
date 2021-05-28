# reisefradrag-kalkulator
Bekk case A:

Reisefradrags-kalkulator med AWS Lambda og AWS API Gateway.


Test:
> curl 'https://ra8wxj59be.execute-api.eu-west-3.amazonaws.com/test/reisefradrag' --data-raw '{"arbeidsreiser": [{"km": 91, "antall": 180},{"km": 378, "antall": 4}],"besoeksreiser": [{"km": 580, "antall": 4}],"utgifterBomFergeEtc": 4850}'
