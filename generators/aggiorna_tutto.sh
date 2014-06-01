echo genero i pazienti e li copio nella cartella database...
cd pazienti
./fai_pazienti.sh
cd ..

echo copio il file paziente.sql dove serve...
cp pazienti/paziente.sql cartelleCliniche/ 
cp pazienti/paziente.sql cartelleCliniche/bin

echo genero le cartelle cliniche...
cd cartelleCliniche/bin
java main > cartelle_cliniche.sql
cd ../..

echo copio cartelle_cliniche.sql dove serve...
cp cartelleCliniche/bin/cartelle_cliniche.sql ../database
cp cartelleCliniche/bin/cartelle_cliniche.sql terapie/terapie

echo genero le terapie...
cd terapie/terapie/
java -jar terapie.jar > terapie.sql
cd ../..

echo copio le terapie dove serve...
cp terapie/terapie/terapie.sql ../database
