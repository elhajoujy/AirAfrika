-- am going from safi to casablanca

SELECT * FROM VOL ;
--this is the perfect case
SELECT * FROM VOL WHERE ville_depart = 'SAFI' OR ville_arrivee = 'CASABLANCA';
SELECT * FROM VOL WHERE ville_depart = 'SAFI' OR ville_arrivee = 'RABAT';

-- now let's trying finding a flight from safi to rabat which includes going to casablanca and then to rabat
-- this is the case where we need to use the recursive query

--NOW WE CAN NOW THAT THERE'S TWO FLIGHTS THAT I CAN  FROM SAFI TO RABAT BUT I HAVE TO VERIFY THE TIMIMG CONDITIONS
SELECT * FROM VOL f WHERE f.ville_depart = 'SAFI' OR f.ville_arrivee = 'RABAT' AND
f.heure_depart < (SELECT heure_arrivee FROM VOL s WHERE  s.ville_arrivee = 'RABAT' AND s.heure_depart < f.heure_arrivee );

SELECT * FROM VOL s WHERE  s.ville_arrivee = 'RABAT' AND s.heure_depart > '12.44' ;

SELECT * FROM VOL f WHERE f.ville_depart = 'SAFI' OR f.ville_arrivee IN
(SELECT ville_arrivee FROM VOL s WHERE  s.ville_arrivee = 'RABAT' AND f.ville_arrivee = s.ville_depart );


SELECT * FROM VOL as f WHERE f.ville_depart = 'SAFI' or ville_arrivee =
(SELECT ville_arrivee FROM VOL as s WHERE  s.ville_arrivee = 'RABAT' AND s.heure_depart < f.heure_arrivee );


SELECT * FROM reservation where date_reservation between '2020-01-01' and '2023-12-31' and status = 'CONFIRMED' ;
UPDATE reservation SET status  = 'CANCELLED' WHERE status = 'Cancelled';
SELECT * FROM reservation ;

SELECT count(*) from reservation;

-- LET'S START FROM THE BOTTOM FIRST  I WILL NEED TO SPECIFY WHERE I WANT TO GO FROM WHICH IS SAFI AND THIS EXAMPLE
-- NEXT I NEED TO SPECIFY WHERE I WANT TO GO TO WHICH IS RABAT
-- NEXT I NEED TO VERIFY IF THERE'S POSSIBILTY TO GO FROM SAFI TO RABAT DIRECTLY
-- IF NOT I NEED TO VERIFY IF THERE'S A FLIGHT FROM SAFI TO CASABLANCA AND THEN FROM CASABLANCA TO RABAT
-- NEXT I NEED TO CHECK IF THE TIMING IS CORRECT

