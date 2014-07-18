#ottengo tutti i nomi dei file
rm popola_pgadmin.sql
FILE=`cat popola.sql | cut -d "i" -f2- | cut -d ";" -f1`

for i in $FILE; do

	less $i >> popola_pgadmin.sql
	
done;

