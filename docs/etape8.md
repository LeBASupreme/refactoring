# Étape 8

## Combien de fichiers existants ont été modifiés ?

4 : `ModeTransport`, `Utils`, `Flotte`, `ValidateurExpedition`.

À l'étape 1, le même ajout ouvrait `CalculateurPrix` (un `if` de tarif, puis un `if` pour le hors gabarit), `ServiceExpedition` (le `switch` du délai et le départ selon le mode) et `AffectationVehicule` (un `instanceof` de plus), en plus de `Utils` et de `Flotte`. Ces trois classes n'ont pas été rouvertes.

## Les 68 tests passent-ils toujours ?

Oui. Le hors gabarit n'est pas branché dans `AssembleurPrix`, donc les colis du contrat qui dépassent 200 cm gardent leur prix.

## Tests unitaires des nouvelles classes

Ils sont dans `ExtensionsTest` : tarif fluvial, délai fluvial, péniche, trajet Paris → Le Havre, supplément hors gabarit.
