# PROP - MasterMind

## Informació del projecte

- Nom del projecte: MasterMind
- Assignatura: Projectes de Programació (PROP)
- Universitat: Facultat d'Informàtica de Barcelona (FIB - UPC)
- Curs: 2022/23 Q2
- Grup: 12.5

- Programadors:
    - Duran López, Marc
    - Gibert García, Miquel
    - Jaume Morera, Sergi
    - Puigdemont Monllor, Arnau

- Contacte:
    - marc.duran.lopez@estudiantat.upc.edu
    - miquel.gibert.garcia@estudiantat.upc.edu
    - sergi.jaume@estudiantat.upc.edu
    - arnau.puigdemont@estudiantat.upc.edu

- Descripció dels arxius:
    - DATA/: Conté els Json dels usuaris guardats
    - DOCS/: Conté la documentació del projecte
    - EXE/: Conté el driver i els jocs de proves
    - FONTS/: Conté el codi del projecte
    - lib/: Conté les llibreries del projecte
    - img/: Conté les imatges utilitzades al joc
    - Makefile: Arxiu make per compilar el Mastermind

- Com executar el projecte:
    - Executar 'make all' per compilar el codi
    - Executar 'jarDriver' per Compila el codi del sistema i el driver corresponent i crea   en un .jar executable
    - Executar 'make executaDriver' per executar el .jar
    - Executar 'make *NomClasse*Test' per executar el test *NomClasse*
    NomClasse pot ser:  - Usuari
                        - Tauler
                        - Stats
                        - Record
                        - Ranking
                        - Partida
                        - FiveGuess
    - Executar 'make AllTest' per executar tots els tests
    - Executar 'make clean' per netejar 