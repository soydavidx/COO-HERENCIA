# Trabajo colaborativo Herencia 2

- Integrantes
- David (Xianjie Wu)
- Pedro Perez
- Diego Hernández

AL DESCARGAR EL ARCHIVO, PONER UN PUNTO EN LA CARPETA SETTINGS PARA QUE FUNCIONE CON ECLIPSE (.settings)
<hr/>
Vamos a realizar un programa para gestionar la información de la nueva NavesLiga 
En las naves hay liga de Sepak Takraw, voleibol y Rugby Subacuático:
•	La NavesLiga estará formada por varios clubes, los cuales deben estar formados por un director deportivo, un entrenador y varios jugadores.
•	Un club está formado por tipo de deporte, valoración (la valoración de un equipo es la de la suma de sus jugadores), ranking
•	Un jugador solo puede pertenecer a un equipo y un equipo solo a un deporte. 
•	Habrá un fichero NavesLigasData, donde se guarde toda la información relativa a la NavesLiga, Deportes, clubs y jugadores.
•	Periódicamente se cargará un fichero con los resultados y los fichajes de la semana que actualizará el fichero general NavesLigas.
</hr>

Estructura a la hora de programar
Vamos a tener dos carpetas principales
⚫carpeta Main : es la carpeta donde está todos los datos de las pernas , club , equipo y El Ranking Actualizado , para la actualizacion del ranking se debe leer la carpeta "Temporal" para obtener datos de la última partida
⚫carpeta Temporal : es una carpeta que se sobreEscribe completamente cuando se de el boton run y es la carpeta donde se guardará los datos del último partido

- cada vez que se de al boton de run se guarda todo en un archivo (cada vez que se ve al boton significa "una semana" pasada)
- en cada semana habra 3 partidos por determinado
- cada resultado de una partida se genera de forma aleatoria tanto los goles como las faltas ...
- despues de cada partido guardar los resultados de la partida solamente para el RANKING
- En el fichero que se va guardar la informacion solamente debe guardar los datos de cada persona , club , equipo y EL RANKINGGG !!ACTUALIZADO!!
- Lo único que se debe escribir con el scanner el usuario es cuando se quiera fichar un jugador
- el numero de club , equipo es fijo es decir que no se puede cambiar
