Progetto generato in automatico dal plugin "openapi generator" sulla specifica OAS 3.1.
Il plugin genera soltanto controller e model perché cosi impostato ma dal pom si può modificare.

Dopo aver fatto "project > clean" selezionate il progetto e fate CTRL+SHIFT+O per cancellare gli import che vanno in errore.
Poi dovrebbe avviarsi senza problemi.

Se non c'è il db si puo usare h2 commentando nel file application.properties le voci sotto "db Oracle".