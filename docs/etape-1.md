| Défaut | Emplacement | Principe violé |
|---|---|---|
| L'expédition met en page le texte de la facture | `Expedition.genererFacture()`, lignes 52 à 81 | S |
| Le délai est calculé dans le service d'expédition | `ServiceExpedition.calculerDelai()`, lignes 101 à 127 | S |
| L'e-mail et le SMS partent depuis le service d'expédition | `ServiceExpedition.notifier()`, lignes 204 à 209 | S |
| Le tarif de base est un `if` par mode (`ROUTE`, `RAIL`, `MER`, `AIR`) | `CalculateurPrix.calculerPrixHT()`, lignes 25 à 41 | O |
| La remise est un `if` sur `ENTREPRISE` et `PREMIUM` | `CalculateurPrix.calculerPrixHT()`, lignes 50 à 58 | O |
| Le délai est un `switch` sur le mode | `ServiceExpedition.calculerDelai()`, lignes 103 à 124 | O |
| Le camion frigorifique refuse les colis qu'un `Camion` accepte | `CamionFrigorifique.charger()`, lignes 10 à 15 | L |
| L'affectation saute le camion frigorifique, sinon le chargement plante | `AffectationVehicule.trouverVehicule()`, lignes 26 à 28 | L |
| `Train.faireLePlein()` lève une exception, avalée par un `catch` vide | `Train.faireLePlein()`, `ServiceExpedition.demarrerExpedition()` lignes 138 à 141 | L |
| `IVehicule` impose `rouler`, `naviguer`, `voler` et `activerRefrigeration` à tous les véhicules | `IVehicule.java`, lignes 22 à 28 | I |
| Un camion doit implémenter `naviguer`, `voler` et `activerRefrigeration` | `Camion.naviguer()`, `Camion.voler()`, `Camion.activerRefrigeration()` | I |
| Un bateau doit implémenter `rouler` et `voler` | `Bateau.rouler()`, `Bateau.voler()` | I |
| Le service fabrique lui-même la base, le calculateur et l'affectation | `ServiceExpedition.java`, lignes 12 à 14 | D |
| L'e-mail est une méthode statique, le SMS est créé sur place | `EmailService.envoyer()`, `ServiceExpedition.notifier()` ligne 207 | D |
| La flotte et le compteur d'expéditions sont des données statiques partagées | `Flotte.vehicules`, `ServiceExpedition.compteur` | D |
