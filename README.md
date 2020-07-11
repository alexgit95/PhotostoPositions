# PhotostoPositions

Permet de recuperer les photos de la table Photos et d'extraire un ensemble de positions que l'on inserera dans la table positions.

Le traitement est le suivant, on recupere toutes les photos.

Une position represente le regroupement de tous les points d'un meme jour dans un rayon de 4Km.

On insere ensuite les nouvelles positions uniquements dans la table Positions.

## Configuration

Pas de configuration necessaire, si ce n'est la configuration des credentials AWS dans votre repertoire .aws/

