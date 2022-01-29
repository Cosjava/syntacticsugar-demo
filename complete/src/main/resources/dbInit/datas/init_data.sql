insert into PERSONNES(
    "IDENTIFIANT",
    "NOM",
	"PRENOM",
	"PRESENTATION"
) values (1, 'TOTO', 'François', 'blablabla');

insert into CONFERENCES(
    "IDENTIFIANT",
    "TITRE",
	"DESCRIPTION",
	"CATEGORIE",
	"HORODATE_DEBUT",
	"HORODATE_FIN",
	"FK_PERSONNE"
) values (1, 'Toto', 'Pierre', 'KEYNOTE',
PARSEDATETIME('24/02/2021 17:00:00', 'dd/MM/yyyy HH:mm:ss'),
PARSEDATETIME('24/02/2021 18:00:00', 'dd/MM/yyyy HH:mm:ss'),
1);

insert into CONFERENCES(
    "IDENTIFIANT",
    "TITRE",
	"DESCRIPTION",
	"CATEGORIE",
	"HORODATE_DEBUT",
	"HORODATE_FIN",
	"FK_PERSONNE",
	"MATERIEL",
	"TYPE"
) values (2, 'Toto2', 'Pierre', 'ATELIER',
PARSEDATETIME('24/02/2021 17:00:00', 'dd/MM/yyyy HH:mm:ss'),
PARSEDATETIME('24/02/2021 18:00:00', 'dd/MM/yyyy HH:mm:ss'),
1, 'Pc portable + installation ide', 'LANGUAGES');